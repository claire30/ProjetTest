import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.*;
import java.io.*;

public class Kernel {
	ArrayList<Regle> liste;

	public Kernel(){
		this.liste = new ArrayList<Regle>();
	}

	public void ajoutRegle(int r){
		Regle r1 = new Regle(r);
		if(!this.liste.contains(r1))  this.liste.add(r1);
	}
	
	public void ajoutRegle(Regle r){
		if(!this.liste.contains(r)) this.liste.add(r);
	}
		
	public Couple appliquerRegle(Couple c){
		int k = c.getK();
		Graph g = c.getG();
		g.display();
		try {
				System.in.read();
			    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }	
		Iterator<Regle> regles = this.liste.iterator();
		int nbrC = g.getNodeCount(), nbrC1 = nbrC, cpt = 0;
		Couple c1 = new Couple(g,k);
		Regle r1 = null;			
		while(regles.hasNext() && c1.getK() > 0){
			r1 = regles.next();
			nbrC = nbrC1;
			c1 = r1.appliquerRegle(c1);
			nbrC1 = c1.getG().getNodeCount();
			if(nbrC != nbrC1){
				System.out.println("Regle "+r1.getNum()+"\nk="+c1.getK());
				c1.getG().display();
			try {
				System.in.read();
			    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }	
				regles = this.liste.iterator();
			}
		}
		if(nbrC1>2*Math.pow(c1.getK(),2)){
			Graph graph = new SingleGraph("Instance non");
			graph.addNode("1");
			graph.addNode("2");
			graph.addEdge("1-2","1","2");
			Couple c2 = new Couple(graph,0);
			return c2;
		}
		return c1;		
	}

	public static boolean kernelization(Couple c) {
		Kernel ker1 = new Kernel();
		ker1.ajoutRegle(0);
		ker1.ajoutRegle(1);
		ker1.ajoutRegle(2);
		Couple c1 = ker1.appliquerRegle(c);
		return c1.getG().getNodeCount()==0;
	}

	public Couple appliquerRegleB(Couple c){
		int k = c.getK();
		Graph g = c.getG();
		Iterator<Regle> regles = this.liste.iterator();
		Couple c1 = new Couple(g,k);
		while(regles.hasNext()){
			Regle r1 = regles.next();
			c1 = r1.appliquerRegle(c1);
			System.out.println("Regle "+r1.getNum() + "appliquée");
		}
		return c1;
	}
	
	public static Couple appliquerString(Couple c, String s){
		int k = c.getK();
		Graph g = c.getG();
		Kernel ker = new Kernel();
		for (int i = 0; i<s.length();i++){
			char a = s.charAt(i);
			int b = Character.getNumericValue(a);
			if(b >= 0 && b <Regle.getNombre())ker.ajoutRegle(b);
		}
		Couple c1 = ker.appliquerRegle(c);
		return c1;
	}
		
}

//V1 du kernel il applique betement
//V2 du kernel il applique de maniere intelligente while()

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.*;
public class Regle{

	private int numRegle;
	private final static int nombreRegles = 3;

	public Regle(int n){
		this.numRegle = n;
	}
	public static int getNombre(){
		return nombreRegles;
	}
	public int getNum(){
		return this.numRegle;		
	}
	public Couple appliquerRegle(Couple c){
		int k = c.getK();
		Graph g = c.getG();
		boolean found = false;
        Iterator <? extends Node> nodes = g.getNodeIterator();//Iterator sur les sommets
		switch(this.numRegle){
			case 0:
				while(nodes.hasNext() && !found){
					Node node = nodes.next();
					if (node.getDegree()==0){// Si un sommet est de degré 0
						g.removeNode(node.getId());
						found = true;
						//System.out.println("regle appliquée : "+ this.numRegle);
					}
	   			}
				break;
			
			case 1:
				if (k > 0){ 					//Si k est au moins égal a 1 on peut commencer
			   		while(nodes.hasNext()&& !found){
				   		Node node = nodes.next();
				   		if (node.getDegree() == 1){ 		//Si un sommet est de degré 1
							Edge edge = node.getEdge(0);
					   		g.removeNode(edge.getOpposite(node).getId()); //On supprime le voisin du sommet
					   		k--; //On fait k-1
					  		found = true;
							//System.out.println("regle appliquée : "+ this.numRegle);
				  		}
			   		}
	   			}
				break;
			case 2: 
				if (k > 0){
					while(nodes.hasNext()&& !found){
			   			Node node = nodes.next();
			   			if (node.getDegree()>=k){ //Si un sommet est de degré supérieur ou égal a k
							g.removeNode(node.getId());
							k--;
							//System.out.println("regle appliquée : "+ this.numRegle);
							found = true;
			   			}
					}
	   			}
				break;
			default:
		}
		return new Couple(g,k);					
	}	
}

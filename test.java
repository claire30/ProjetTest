import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.lang.Math;
import java.util.*;
public class test{

	public static Graph generate(int node, int edge){
		Graph graph = new SingleGraph("EnMarche");
		int cpt = 0;//Variable que l'on incrémente à chaque ajout de relation dans le tableau recensant toute les relations
		if (edge <= (node*(node-1))/2){
			for (int i = 0; i<node;i++){
				Node a = graph.addNode(String.valueOf(i));
				a.addAttribute("ui.label", String.valueOf(i));
			}
			
			//On va ajouter aléatoirement des relations (en veillant qu'elles ne soient pas deja existantes) jusqu'à ce que e atteigne 0
			//On va boucler tant que le nombre de relations n'est pas égal à celui recherché
			while (cpt !=edge){
				int n1 = (int)((Math.random()*node*100)/100);
				int n2 = (int)((Math.random()*node*100)/100);

				while(n1 == n2){
					n2 = (int)((Math.random()*node*100)/100);
				}
				//Création d'un booléen qui contiendra le résultat du test d'équivalence entre le nouveau string et ceux du tableau
				String node1 = String.valueOf(n1);
				String node2 = String.valueOf(n2);
				String nom = node1+"-"+node2;
				String nomBis = node2+'-'+node1;
				if(graph.getEdge(nom)==null && graph.getEdge(nomBis)==null){
					graph.addEdge(nom,node1,node2);
					cpt++;
				}
			}
		} else System.out.println("Erreur nombre de relations trop grand");
		return graph;
	}
	public static void main(String args[]) {
		System.out.println("Que voulez-vous faire ?\n1) Définir un graphe et ses règles\n2) Aléatoire");
		Scanner choix = new Scanner(System.in);
		int x = -1, k, sommets, aretes;
		Couple c, c1;
		while(x<1 || x>2) x = choix.nextInt();
		switch(x){
			case 1 :
				System.out.print("Combien de sommets ? ");
				sommets = choix.nextInt();
				System.out.print("\nCombien d'arêtes ? ");
				aretes = choix.nextInt();
				Graph g = generate(sommets,aretes);
				System.out.print("\nDéfinissez un k pour la Kernelization : ");
				k = choix.nextInt();
				c = new Couple(g, k);
				System.out.print("\nQuelle(s) règle(s) souhaitez-vous appliquer ? (sous la forme '012' pour les règles 0,1 et 2) ");
				String regle = choix.next();
				c1 = Kernel.appliquerString(c,regle); 
				System.out.println("Fin de l'optimisation");
				break;
			case 2 :
				k = 4;
				sommets = 9;
				aretes = 10;
				System.out.println("Nous prenons un graphe à 9 sommets et 10 arêtes, et un k=4. Nous appliquons toutes les règles.");	
				c = new Couple(generate(sommets,aretes), k);
				c1 = Kernel.appliquerString(c,"012");
				System.out.println("Fin de l'optimisation");
				break;
 		}
	}
}

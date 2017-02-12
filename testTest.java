import static org.junit.Assert.*;

import org.graphstream.graph.Graph;
import org.junit.Test;


public class testTest {

	private int sommetNormaux; 
	private Graph g; 
	private Graph g1;
	

	public void setUp() throws Exception {
		/*initialisation de sommets */
		sommetNormaux=10; 
		 
		
		

		
	}
	
	
	// TEST CONCERNANT LES ARETES DU GRAPHE
	/*Ce test permet de vérifier le fonctionnements du générateur de graphe avec des un nombre d'aretes supérieur au nombre maxmimal d'aretes possible
	 * on choisit de générer un graphe avec 10 sommets et 5000 arêtes
	 * Le résultat attendu est un nombre d'aretes non égals à 5000, le nombre d'aretes doit être égal à 0
	 * Le résultat obtenu est conforme au résulat attendu. 
	 * Nous pouvons l'expliquer avec le code de la fonction générant le graphe. En effet, le nombre d'aretes étant trop grand, on ne rentre pas dans la boucle créant les sommets et les aretes donc nous ne créons pas d'aretes*/
	@Test
	public void testAretesHorsNormes() {
		
		g1=test.generate(sommetNormaux,5000); 
		assertNotEquals("non égaux",g1.getEdgeCount(),5000);
		assertEquals("sont égaux", g1.getEdgeCount(),0); 
	}
	
	//Test CONCERNANT LES SOMMETS DU GRAPHE
	
	
	/*Ce test permet de vérifier le fonctionnements du générateur de graphe avec des un nombre de sommets négatif
	 * on choisit de générer un graphe avec -10 sommets et 0 arêtes
	 * Le résultat attendu est un nombre de sommets non égals à -10, le nombre de sommets doit être égal à 0
	 * Le résultat obtenu est conforme au résulat attendu. 
	 * Nous pouvons l'expliquer avec le code de la fonction générant le graphe. En effet, avec un nombre de sommets négatif, nous ne rentrons pas dans la boucle for permettant de créer les sommets donc on obtient au final 0 sommets
	 */
	@Test

	public void testSommetsHorsNormes() {
		/* initialisation d'un graphe avec un nombre de sommets anomal */
		g1=test.generate(-10, 0); 
		assertNotEquals("relations vraie", g1.getNodeCount(),-10);
		assertEquals("sont égaux", g1.getNodeCount(),0); 
	}
	



}

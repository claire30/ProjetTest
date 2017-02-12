import static org.junit.Assert.*;

import org.graphstream.graph.Graph;
import org.junit.Test;


public class testTest {




	public void setUp() throws Exception {

	}


	// TEST CONCERNANT LES ARETES DU GRAPHE
	/*Ce test permet de vérifier le fonctionnements du générateur de graphe avec des un nombre d'aretes supérieur au nombre maxmimal d'aretes possible
	 * on choisit de générer un graphe avec 10 sommets et 5000 arêtes
	 * Le résultat attendu est un nombre d'aretes non égal à 5000, le nombre d'aretes doit être égal à 0
	 * Le résultat obtenu est conforme au résulat attendu. 
	 * Nous pouvons l'expliquer avec le code de la fonction générant le graphe. En effet, le nombre d'aretes étant trop grand, on ne rentre pas dans la boucle créant les sommets et les aretes donc nous ne créons pas d'aretes*/
	@Test
	public void testAretesHorsNormes() {

		Graph g1=test.generate(10,5000); 
		assertNotEquals("non égaux",g1.getEdgeCount(),5000);
		assertEquals("sont égaux", g1.getEdgeCount(),0); 
	}

	/*Ce test permet de vérifier le comportement du programme avec des arêtes négatif
	 * on choisir de générer un graphe à 10 sommets et -5 arêtes
	 * Le résultat attendu est un nombre d'aretes normalisé c'est à dire compris entre 0 et le nombre d'arretes maximal soit (n(n-1))/2 où n représente l'ordre du graphe
	 * Le résultat obtenu n'est pas conforme aux attentes puisque le test ne termine jamais (pas de temps affichés et la console eclipse est toujours en activité )
	 * L'assertEquals n'est donc jamais réalisé dans ce test 
	 * Nous pouvons expliquer cette boucle infinie lors de la création des aretes. En effet, nous allons rentrer dans la boucle permettant de créer des aretes. Cependant le compteur étant initialisé à 0, la boucle while (cpt !=edge) ne s'arrete jamais lorsque le nombre d'aretes est négatif. En effet le compteur va cesser d'augmenter au cours du programme
	 */
	@Test 
	public void testSommetsOkAretesNon() {
		Graph g4=test.generate(10,-5); 
		assertEquals("sont égaux", g4.getEdgeCount(), -5);

	}
	
	@Test
	public void testAretesNormes() {
		Graph g5=test.generate(10,5); 
		assertEquals("sont égaux", g5.getEdgeCount(),5);
		
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
		Graph g3=test.generate(-10, 0); 
		assertNotEquals("relations vraie", g3.getNodeCount(),-10);
		assertEquals("sont égaux", g3.getNodeCount(),0); 
	} 
	/*
	 * Ce test permet de vérifier le nombre de sommet dans lorsque les sommets et les aretes sont dans les normes définis par le programme
	 * Le résultat attendu doit être le nombre de sommets (10)
	 * Le résultat obtenu est conforme au résultat attendu
	 */
	@Test
	public void testSommetOkAretesOk() {
		Graph g4=test.generate(10, 1);
		
		assertEquals("sont égaux", g4.getNodeCount(), 10);
	}
	
	/*
	 * Ce test permet de vérifier le comportement du programme avec un nombre important de sommet
	 * Le résultat attendu est une exception ou un nombre de sommet normalisé c'est à dire beaucoup plus petit pour ne pas avoir des problèmes de performances
	 * Le résultat obtenu est une boucle infinie. La méthode assertEquals n'est jamais appelé. Nous pouvons expliqué cela à cause d'exceptions qui ne sont pas levées quand l'entier est trop grand
	 * 
	 */
	
	/*
	@Test
	public void testSommetGrand() {
		Graph g7=test.generate(10000000, 1);
		assertEquals("sont égaux", g7.getNodeCount(),10000000);
	}
	
	*/
	//Test concernant les propriétés  du graphe 
	
	/* Ce test permet de vérifier que le nom du graphe est bien le même que celui indiqué dans le programme
	 * Le résultat attendu doit être en marche
	 * Le résultat obtenu est conforme au résultat attendu
	 */
	@Test
	public void testNomGraphe() {
		Graph g6=test.generate(10, 1);
		assertEquals(g6.toString(), "EnMarche");
	}
	
	/* Ce test permet de vérifier que le graphe créé n'est pas null
	 * Le résultat attendu doit être un graphe qui ne fait pas référence à null
	 * Le résultat obtenu est conforme aux attentes
	 */
	@Test 
	public void testGraphNull() {
		Graph g10=test.generate(10, 1);
		assertNotNull(g10);
		
	}
	
	/*Ce test permet de vérifier le comportement du programme lorsque le graphe n'est pas conforme aux normes (nombre d'aretes trop grand). 
	 * Le résultat attendu est un graphe sans sommet ni aretes (juste initialisé avec son nom)
	 *Le résultat est conforme aux attentes. Il est à noter que retourner un graphe vide n'est pas la seule solution possible
	 *
	 */
	@Test
	public void testGraphAretesNon() {
		Graph g11=test.generate(10, 200);
		assertNotNull(g11);
		assertEquals(g11.toString(), "EnMarche");
		
	}
	
	/*Ce test permet de vérifier le comportement du programme lorsque le graphe n'est pas conforme aux normes (sommets négatif)
	 * Le résultat attendu est un graphe sans sommet ni aretes (juste initialisé avec son nom)
	 *Le résultat est conforme aux attentes
	 *
	 */
	@Test 
	public void testGraphAretesNefativ() {
		Graph g12=test.generate(-10, 0);
		assertNotNull(g12);
		assertEquals(g12.toString(), "EnMarche");
				
		
	}
	
	//Test sur les degrés d'un sommet



}

import static org.junit.Assert.*;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
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
	
	/*Ce test permet de vérifier le degré des sommets pour un graphe à 0 aretes
	 * Nous allons saisir générer un graphe de degré 3 avec 0 sommets
	 * Le résulat attendu est un degré 0 pour les 3 sommets 
	 * Le résultat obtenu est conforme au résultat attendu
	 */
	@Test
	public void testDegre() {
		Graph g14=test.generate(3, 0);
		Node n1=g14.getNode("1");
		Node n2=g14.getNode("2");
		Node n3=g14.getNode("0");
		assertEquals("sont égaux", n1.getDegree(),0);
		assertEquals("sont égaux", n2.getDegree(),0);
		assertEquals("sont égaux", n3.getDegree(),0);
	}
	
	/*
	 * Ce test permet de vérifier le degré des sommets d'un graphe complet
	 * Nous allons générer un graphe d'ordre 5, ayant le maximum d'aretes soit 10 aretes pour former un graphe complet
	 * Le résultat attendu est un degré 4 pour tous les sommets
	 * Le résultat obtenu est conforme au résultat attendu 
	 * Ainsi le mécanisme qui vérifie l'existance d'une arete avant de l'ajouter est donc correct. 
	 * Si ce mécanisme n'était pas correct, nous aurions pu avoir des degrés supérieur à 4 pour certains sommmets
	 * 
	 */
	@Test
	public void testDegreComplet(){
		Graph g15=test.generate(5,10); 
		Node n1=g15.getNode("0");
		Node n2=g15.getNode("1");
		Node n3=g15.getNode("2");
		Node n4=g15.getNode("3");
		Node n5=g15.getNode("4");
		assertEquals("sont égaux", n1.getDegree(),4);
		assertEquals("sont égaux", n2.getDegree(),4);
		assertEquals("sont égaux", n3.getDegree(),4);
		assertEquals("sont égaux", n4.getDegree(),4);
		assertEquals("sont égaux", n5.getDegree(),4);
		
		
	}
	
	@Test
	/*
	 * Ce test permet de tester le mécanisme aléatoire de la génération de graphe 
	 * Nous allons générer deux graphes avec 20 sommets et 80 aretes et nous allons regarder si les degré du sommet 0 sont égaux
	 * Etant donné le nombre de choix possible, il est peu probable que ces degrés soit égaux
	 * Le résultat obtenu est conforme au résultat attendu (bien qu'il y ait selon le nombre de test, une probabilité que ces degrés soient égaux) 
	 */
	public void testAléatoire() {
		Graph g16=test.generate(20, 80); 
		Graph g17=test.generate(20, 80); 
		Node n1=g16.getNode("0");
		Node n1b=g17.getNode("0"); 
		assertNotEquals(n1.getDegree(), n1b.getDegree());
		
	}
	/*
	 * Ce test permet de vérifier que le degré d'un sommet est compris dans les normes
	 * Nous générons un graphe complet d'ordre 5 ayant 5 aretes
	 * Notre degré du sommet doit être compris entre 0 et 4
	 * Le resultat obtenu est conforme aux attentes
	 */
	@Test
	public void DegreSommet() {
		Graph g18=test.generate(5, 5);
		Node n1=g18.getNode("0");
		assertTrue("relations vraies", n1.getDegree()>=0 );
		assertTrue("relations vraies", n1.getDegree()<=4);
		
	}
	



}

import static org.junit.Assert.*;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class RegleTest {
	
	private Regle r;
	
	private Regle r0;
	private Regle r1;
	private Regle r2;
	private Regle r3;
	
	private Graph g1;
	private Graph g2;

	private int k1;
	private int k2;
	private int kNegatif;

	private Couple c1;
	private Couple c2;
	private Couple c1Negatif;
	private Couple c2Negatif;
	
	
	@BeforeClass 
	public static void debut() {
		System.out.println("début des tests");
	}
	
	@Before
	public void initRegle() {
		r = new Regle(1);
		
		r0 = new Regle(0);
		r1 = new Regle(1);
		r2 = new Regle(2);
		r3 = new Regle(3);
		
		k1 = 4;
		k2 = 3;
		
		kNegatif = -1;
		
		g1 = new SingleGraph("graphe g1");
		g2 = new SingleGraph("graphe g2");

		// on crée un graphe g1 de 10 sommets
		for (int i = 0; i < 10; i++) {
			g1.addNode(i + "");
		}

		// et on rajoute des aretes

		g1.addEdge("1-7", "1", "7");
		g1.addEdge("1-9", "1", "9");
		g1.addEdge("2-4", "2", "4");
		g1.addEdge("2-5", "2", "5");
		g1.addEdge("3-5", "3", "5");
		g1.addEdge("3-7", "3", "7");
		g1.addEdge("4-5", "4", "5");
		g1.addEdge("4-6", "4", "6");
		g1.addEdge("5-7", "5", "7");		
		g1.addEdge("5-6", "5", "6");
		g1.addEdge("6-7", "6", "7");
		g1.addEdge("6-8", "6", "8");
		g1.addEdge("6-9", "6", "9");
		g1.addEdge("7-9", "7", "9");
		
		for(int i=0; i<5; i++) {
			g2.addNode(i+"");
		}
		
		g2.addEdge("0-1", "0", "1");
		g2.addEdge("0-2", "0", "2");
		g2.addEdge("0-3", "0", "3");
		g2.addEdge("0-4", "0", "4");
		g2.addEdge("1-2", "1", "2");
		g2.addEdge("3-4", "3", "4");
		
		c1 = new Couple(g1, k1);
		c2 = new Couple(g2, k2);
		
		c1Negatif = new Couple(g1, kNegatif);
		c2Negatif = new Couple(g2, kNegatif);
	}
	
	
//TEST GETTER
	
	/* Ce test permet de vérifier que la méthode getNum() de Regle fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entrée standard
	 * 
	 * -> le résultat attendu de la part du programme est le n choisis dans la fonction setUp() ( soit 1 )
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void testGetNum() {
		assertEquals("doît être égaux", r.getNum(), 1);
	}
	
	/*
	 * Ce test permet de vérifier le fonctionnement de la fonction getNum lorsque la règle définie est hors normes (règle 3)
	 * Nous nous attendons à avoir soit la règle définit comme null, soit le numéro de la règle normalisé à la valeur 0
	 * Le résultat est différent des attentes
	 */
	@Test 
	public void testGetNombreMauvaiseRègle() {
		assertTrue(r3==null ||r3.getNum()==0);
	}
	
	/* Ce test permet de vérifier que la méthode getNombre() de Regle fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> le résultat attendu de la part du programme est le nombre de règle défini dans la classe Règle (soit 3).
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	
	
	
	@Test
	public void testGetNombreRegle() {
		assertEquals("doît être égaux", Regle.getNombre(), 3);
		
	}


	
//TEST CONSTUCTEUR
	
	/* Ce test permet de vérifier que le constructeur de la classe Regle fonctionne correctement dans les conditions suivantes :
	 * -> l'objet est bien crée
	 * 
	 * -> le résultat attendu de la part du programme est le n passé en paramètre obtenu par la méthode getNum()
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void testBonneNumRegle() {
		Regle r0 = new Regle(0);
		Regle r1 = new Regle(1);
		Regle r2 = new Regle(2);
		
		assertNotNull("Ne doît pas être null", r0);
		assertNotNull("Ne doît pas être null", r1);
		assertNotNull("Ne doît pas être null", r2);
		
		assertNotSame(r0, r1); 
		assertNotSame(r0,r2); 
		assertNotSame(r1,r2);
		assertEquals("doît être égaux", r0.getNum(), 0);
		assertEquals("doît être égaux", r1.getNum(), 1);
		assertEquals("doît être égaux", r2.getNum(), 2);
	}
	
	
	/* Ce test permet de vérifier que le constructeur de la classe Regle fonctionne correctement dans les conditions suivantes :
	 * -> soit l'objet ne doit pas être crée lors que les mauvaise valeurs sont passées en paramètre, c'est-à-dire n est différent de 0, 1, 2.
	 * soit l'objet crée la règle 0 c'est à dire qu'il y a une normalisation de la règle et qu'on remplace toute règle différente de (0,1,2) par la règle 0
	 * -> le résultat est différent des attentes puisque l'objet créé n'est pas null et ne correspond pas à la règle 0
	 * La règle est donc créée même avec des valeurs différentes de 0, 1 ou 2
	 */
	@Test
	public void testMauvaiseNumRegle() {
		Regle r0 = new Regle(3);
		Regle r1 = new Regle(-1);
		Regle r2 = new Regle(100);
		
		
		assertTrue((r0.getNum()==0 && r0!=null) || (r0==null));
		assertTrue((r1.getNum()==0 && r1!=null) || (r1==null));
		assertTrue((r2.getNum()==0 && r2!=null) || (r2==null));
	}
	
	//
	// Test appliquerRegle
	//

	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> si k est négatif, il ne faut rien faire
	 * 
	 * -> Le résultat est différent.
	 * En effet, le nombre de sommet du graphe est différent du nombre de départ
	 */
	@Test
	public void testAppliquerRegle0NegatifSommet() {
		
		int nodesInit = c1Negatif.getG().getNodeCount();
		Couple cRes = r0.appliquerRegle(c1Negatif);
		assertEquals(cRes.getK(), c1Negatif.getK());
		assertTrue(cRes.getG().getNodeCount() == nodesInit);
		
	}
	/* Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> si k est négatif, il ne faut rien faire
	 * 
	 * -> Le résultat est différent.
	 * En effet, le sommet 0 est null donc il est supprimé
	 */
	
	@Test
	public void testAppliquerRegle0NegatifNull() {
		Couple cRes = r0.appliquerRegle(c1Negatif);
		assertNotNull(cRes.getG().getNode("6"));
		assertNotNull(cRes.getG().getNode("0"));
		
	}
	
	
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> Si k est négatif, il ne faut rien faire
	 * 
	 * -> le résultat est bien celui attendu
	 * 
	 */
	@Test
	public void testAppliquerRegle1Negatif() {
		
		int nodesInit = c1Negatif.getG().getNodeCount();
		Couple cRes = r1.appliquerRegle(c1Negatif);
		
		assertTrue(cRes.getG().getNodeCount() == nodesInit);
		
		assertNotNull(cRes.getG().getNode("6"));
		assertNotNull(cRes.getG().getNode("0"));
		
		assertEquals(cRes.getK(), c1Negatif.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> si le k est négatif, il ne faut rien faire
	 * 
	 * -> Le résultat est bien celui attendu
	 * 
	 */
	@Test
	public void testAppliquerRegle2Negatif() {
		
		int nodesInit = c2Negatif.getG().getNodeCount();
		Couple cRes = r2.appliquerRegle(c2Negatif);
		
		assertTrue(cRes.getG().getNodeCount() == nodesInit);
		
		assertNotNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("1"));
		
		assertEquals(cRes.getK(), c2Negatif.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> on vérifie si la règle 0 enlève bien le sommet 0 du graphe g1, qui est de degrès 0, sans modifier le k
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 0 est supprimé du graphe, et le k n'est pas modifié
	 * 
	 * -> Cependant, ici, le graphe passé en argument est directement modifié, contrairement à la méthode appliquerRegle de Kernel
	 *
	 */
	@Test
	public void testAppliquerRegle0() {
		
		int nodesInit = c1.getG().getNodeCount();
		Couple cRes = r0.appliquerRegle(c1);
		
		assertTrue(cRes.getG().getNodeCount() == nodesInit -1);
		
		assertNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("6"));
		
		assertEquals(cRes.getK(), c1.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> on vérifie si la règle 1 enlève bien le sommet 6 du graphe g1, car il est le seul voisin du sommet 8, de degrès 1
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 6 est supprimé du graphe, et le k est décrémenté
	 * 
	 * -> Cependant, ici, le graphe passé en argument est directement modifié, contrairement à la méthode appliquerRegle de Kernel
	 * 
	 */
	@Test
	public void testAppliquerRegle1() {
		
		int nodesInit = c1.getG().getNodeCount();
		Couple cRes = r1.appliquerRegle(c1);
		
		assertTrue(cRes.getG().getNodeCount() == nodesInit -1);
		
		assertNull(cRes.getG().getNode("6"));
		assertNotNull(cRes.getG().getNode("0"));
		
		assertEquals(cRes.getK(), c1.getK() -1);
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> on vérifie si la règle 2 enlève bien le sommet 0 du graphe g2, car il est de degrès 4, ce qui est supérieur à k=3, tout en décrémentant k
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 0 est supprimé du graphe, et le k est décrémenté
	 * 
	 * -> Cependant, ici, le graphe passé en argument est directement modifié, contrairement à la méthode appliquerRegle de Kernel
	 * 
	 */
	@Test
	public void testAppliquerRegle2() {
		
		int nodesInit = c2.getG().getNodeCount();
		Couple cRes = r2.appliquerRegle(c2);
		
		assertTrue(cRes.getG().getNodeCount() == nodesInit -1);
		
		assertNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("1"));
		
		assertEquals(cRes.getK(), c2.getK() -1);
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> on vérifie si, en passant un couple null au kernel, celui-ci nous renvoie un couple non null ou pas
	 * 
	 * -> la méthode renvoie un null pointeur exception
	 * 
	 */
	@Test
	public void testAppliquerRegleNull() {
		Couple cRes = r1.appliquerRegle(null);
		
		assertNotNull(cRes);
	}
	

	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 0 sur g2
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * 
	 */
	@Test
	public void testAppliquerRegle0Inutile() {
		Couple cRes = r0.appliquerRegle(c2);
		
		assertEquals(cRes.getG().toString(),c2.getG().toString());
		
		assertFalse(cRes.getK() != c2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 1 sur g2
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * 
	 */
	@Test
	public void testAppliquerRegle1Inutile() {
		Couple cRes = r1.appliquerRegle(c2);
		
		assertEquals(cRes.getG().toString(),c2.getG().toString());
		
		assertFalse(cRes.getK() != c2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 2 sur g2 avec un k=10
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * 
	 */
	@Test
	public void testAppliquerRegle2Inutile() {
		Couple cInutile2 = new Couple(g2, 10);
		Couple cRes = r2.appliquerRegle(cInutile2);
		
		assertEquals(cRes.getG().toString(),cInutile2.getG().toString());
		
		assertFalse(cRes.getK() != cInutile2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Regle fonctionne, même si la règle a un numéro "incorrect"
	 * 
	 * Pour celà, on crée une règle qui n'est pas censé exister ( par exemple, la règle numéro 3 )
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui n'existe pas
	 * C'est à dire, si on applique la règle 3 sur g1
	 * 
	 */
	@Test
	public void testAppliquerRegleInexistante() {
		
		Couple cRes = r3.appliquerRegle(c1);
		
		assertEquals(cRes.getG().toString(),c1.getG().toString());
		
		assertFalse(cRes.getK() != c1.getK());
	}
	
	// TEST DE PERFORMANCE
	/* Ces tests donnent une indication mais les résultats ne sont pas toujours identiques. En effet, ils dépendent de la JVM */ 

	
	/*Ce test permet de regarder la performance de la fonction appliquerRegle
	 * Nous allons essayer d'appliquer la règle numéro 0 1000 fois sur un graphe à 100 000 sommets
	 * Nous pouvons appliquer 1000 fois la règle sur un graphe à 40 000 sommets en moins de 10 secondes
	 * Si nous relançons le test avec un graphe à 50 000 sommets, le test s'effectue en plus de 10 secondes
	 * Cette fonction a donc des performances satisfaisantes. 
	 * Elle est plus performante que la fonction appliquerRegle de la classe Kernel car elle n'affiche pas les graphes (qui prennent un temps important) à chaque itération. 
	 * Nous avons mis une annotation @Ignore pour ne pas lancer les tests lorsque nous appuyons sur run car le temps d'exécution de l'ensemble des tests est long
	 * Si vous voulez lancer ces tests, mettez le @Ignore en commentaire.
	 */
	@Ignore
	@Test(timeout=10000)
	public void testAppliquerReglePerf0() {
		Graph gtest = new SingleGraph("graphe g1");



		for (int i = 0; i <40000; i++) {
			gtest.addNode(i + "");
		}

		// et on rajoute des aretes

		gtest.addEdge("1-7", "1", "7");
		gtest.addEdge("1-9", "1", "9");
		gtest.addEdge("2-4", "2", "4");
		gtest.addEdge("2-5", "2", "5");
		gtest.addEdge("3-5", "3", "5");
		gtest.addEdge("3-7", "3", "7");
		gtest.addEdge("4-5", "4", "5");
		gtest.addEdge("4-6", "4", "6");
		gtest.addEdge("5-7", "5", "7");		
		gtest.addEdge("5-6", "5", "6");
		gtest.addEdge("6-7", "6", "7");
		gtest.addEdge("6-8", "6", "8");
		gtest.addEdge("6-9", "6", "9");
		gtest.addEdge("7-9", "7", "9");

		Couple c0test=new Couple(gtest,2);
		for(int i=0; i<1000; i++) {
			Couple cRes = r0.appliquerRegle(c0test);
		}
	}
	
	@After
	public void testFini() {
		System.out.println("test fini"); 
	}
	
	@AfterClass
	public static void testFiniEnsemble() {
		System.out.println("ensemble de test fini"); 
	}
}


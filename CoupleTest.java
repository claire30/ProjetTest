import static org.junit.Assert.*;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.Graphs;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoupleTest {
	
	public Couple c1;
	public Graph g1;
	public int k1;
	public Couple c2;
	public Graph g2;
	public int k2;

	/* Ceci est le setup, c'est ici que l'on va instancier et initialiser les variables de la classe test.
	 * Comme le précise le @Before, ceci sera exécuté avant les tests
	 * et permet d'avoir des variables instanciées pour pouvoir s'en servir dans les différents tests 
	 */
	@Before
	public void setUp() throws Exception {
		g1 = new SingleGraph("graph de test ");
		k1 = 4;
		c1 = new Couple(g1, k1);
		g2 = new SingleGraph("graph de test ");
		k2 = 6;
		c2 = new Couple(g2, k2);
	}

	
	/* Ceci est le close, c'est ici que l'on va fermer les variables de la classe test qui ont besoin de l'etre.
	 * Comme le précise le @After, ceci sera exécuté après la fin de tous les tests
	 * et permet d'éviter les fuites de mémoire où autre soucis.
	 * Dans ce projet, nous n'avons pas de problème de ce type
	 */	
	@After
	public void tearDown() throws Exception {
	}
	
	/* Ce test permet de vérifier que la méthode <<insérer un nom ici>> fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entrée << est conforme aux attentes  // pose un problème ( décrire le problème ie: nb arrêtes < 0 ) >>
	 * 
	 * -> le résultat attendu de la part du programme est << une truc normal / lever une exception / règler l'erreur sans en informer ... >>
	 * 
	 * -> le résultat obtenu est << conforme aux attentes / différent des attentes ( décrire les différences ) >>
	 * 
	 * -> si résultat différent : qu'est ce qui cause ce problème ?
	 */
	@Test
	public void unNomSignificatif() {
		// Un morceau de code assertChose(truc);
		assertTrue(true);
	}
	
	//
	//			Tests Constructeur
	//
	
	/* Ce test permet de vérifier que le constructeur de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entrée est conforme aux attentes, c'est à dire un graphe g quelconque, et un k strictement positif
	 * 
	 * -> le résultat attendu de la part du programme est le k passé en paramètre obtenu par la méthode getK()
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void creerCoupleOkK() {
		Graph g = new SingleGraph("graphe de test");
		Couple c = new Couple(g, 4);
		assertTrue(c.getK() == 4);
	}
	
	/* Ce test permet de vérifier que le constructeur de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entrée est conforme aux attentes, c'est à dire un graphe g quelconque, et un k strictement positif
	 * 
	 * -> le résultat attendu de la part du programme n'est pas le graphe G passé en paramètre, mais une copie de ce graphe obtenue par la méthode getG()
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void creerCoupleOkGraph() {
		Graph g = new SingleGraph("A modifier");
		Couple c = new Couple(g, 4);
		assertNotSame(c.getG(), g);
		assertSame(c.getG().toString(), g.toString());
	}
	
	/* Ce test permet de vérifier que le constructeur de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entrée pose un problème, c'est à dire un graphe g quelconque, et un k négatif
	 * 
	 * -> le résultat attendu de la part du programme n'est pas le k passé en paramètre, mais un k cohérent avec la situation 
	 * 
	 * -> le résultat obtenu est différent des attentes, en effet, le k n'est pas modifié
	 * 
	 * -> celà peut poser un problème, car il est totalement illogique et impossible de chercher un vertex cover de taille négative dans un graphe
	 * 
	 */
	@Test
	public void creerCoupleKNegatif() {
		Graph g = new SingleGraph("A modifier");
		Couple c = new Couple(g, -4);
		assertNotEquals(-4, c.getK());
	}
	
	/* Ce test permet de vérifier que le constructeur de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entrée pose un problème, c'est à dire un graphe g null, et un k strictement positif
	 * 
	 * -> le résultat attendu de la part du programme n'est pas un graphe null passé en paramètre, mais un graphe cohérent avec la situation
	 * 
	 * il est aussi attendu de ne pas avoir d'erreur de type "NullPointerException"
	 * 
	 * -> le résultat obtenu est différent des attentes, en effet, une erreur de type NullPointerException est levée, mais n'est pas gérée par la classe.
	 * 
	 * -> Ce problème est dû à la fonction Graphs.clone() qui renvoie cette erreur si le graphe passé en argument est null.
	 * 
	 */
	@Test
	public void creerCoupleGNull() {
		Couple c = new Couple(null, 4);
		assertNotEquals(c.getG(), null);
	}
	
	//
	//			Tests getK()
	//
	
	/* Ce test permet de vérifier que la méthode getK() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entrée standard
	 * 
	 * -> le résultat attendu de la part du programme est le k choisis dans la fonction setUp() ( soit 4 )
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void getKNormal() {
		assertEquals(c1.getK(), k1);
	}
	
	/* Ce test permet de vérifier que la méthode getK() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entrée standard
	 * 
	 * -> le résultat attendu de la part du programme est le k choisis dans la fonction setUp() ( soit 6 )
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void getK2Normal() {
		assertEquals(c2.getK(), k2);
	}
	
	//
	//			Tests getG()
	//
	
	/* Ce test permet de vérifier que la méthode getG() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entrée standard
	 * 
	 * -> on teste avec un .toString() afin de comparer que les deux graphes soit identiques, biens que le graphe du couple ai été cloné
	 * 
	 * -> le résultat attendu de la part du programme est que les deux graphes soit identiques
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void getGNormal() {
		assertEquals(c1.getG().toString() , g1.toString());
	}
	
	/* Ce test permet de vérifier que la méthode getG() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entrée standard
	 * 
	 * -> on teste avec un .toString() afin de comparer que les deux graphes soit identiques, biens que le graphe du couple ai été cloné
	 * 
	 * -> le résultat attendu de la part du programme est que les deux graphes soit identiques
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void getG2Normal() {
		assertSame(c2.getG().toString() , g2.toString());
	}
	
	//
	//			Tests afficherGraph()
	//
	
	/* Ce test permet de vérifier que la méthode afficherGraph() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entrée standard
	 * 
	 * -> on teste uniquement d'appeller la méthode et on confirme le test si la fonction ne renvoie pas d'erreur
	 * car cette fonction ne renvoie rien et ne modifie aucun attribut, aussi bien sur l'objet Couple que sur lobjet Graph du couple
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void afficherGraph1Normal() {
		c1.afficherGraph();
		assertFalse(1 == 2);
	}
	
	/* Ce test permet de vérifier que la méthode afficherGraph() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entrée standard
	 * 
	 * -> on teste uniquement d'appeller la méthode et on confirme le test si la fonction ne renvoie pas d'erreur
	 * car cette fonction ne renvoie rien et ne modifie aucun attribut, aussi bien sur l'objet Couple que sur l'objet Graph du couple
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void afficherGraph2Normal() {
		c2.afficherGraph();
		assertFalse(1 == 2);
	}
	
}

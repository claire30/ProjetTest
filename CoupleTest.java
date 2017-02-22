import static org.junit.Assert.*;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.Graphs;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;




public class CoupleTest {

	private Couple c1;
	private Graph g1;
	private int k1;
	private Couple c2;
	private Graph g2;
	private int k2;
	private Graph g3; 
	private Couple c3;
	private int k3;
	private Couple c4;
	private Graph g4; 
	private Couple c5;

	private Graph gGrand; 
	private Couple grand; 
	
	
	private Graph gGrand2; 
	private Couple gGrandtest; 
	
	
	/* Ceci est le setup, c'est ici que l'on va instancier et initialiser les variables de la classe test.
	 * Comme le précise le @Before, ceci sera exécuté avant les tests
	 * et permet d'avoir des variables instanciées pour pouvoir s'en servir dans les différents tests 
	 */
	
	@Before
	public void setUp() throws Exception {
		/*initialisation de graphes vides de test et de couples*/
		g1 = new SingleGraph("graph de test ");
		k1 = 4;
		c1 = new Couple(g1, k1);
		g2 = new SingleGraph("graph de test ");
		k2 = 6;
		c2 = new Couple(g2, k2);
		/* initialisation d'un graphe de test avec sommets et aretes */
		g3=new SingleGraph("graphe test k  ");
		for(int i=0; i<6; i++) {
			//on ajoute des sommets au graphe en convertissant les valeurs en String 
			Node a = g3.addNode(String.valueOf(i));
			//on nomme le sommet avec la valeur du i en caractère
			a.addAttribute("ui.label",String.valueOf(i));
		}

		/*création des aretes,
		 * Exemple g3.addEdge("1-2","1","2");
		 *  1-2 est le nom de la relation, 1 le premier sommet et 2 le deuxième sommt
		 * 
		 */

		g3.addEdge("1-2","1","2");
		g3.addEdge("2-4","2","4");
		g3.addEdge("5-4","5","4");





		k3=1000; 

		/* création de couples de test avec différents k */
		c3=new Couple(g3,k3);
		c4=new Couple (g3,k1);
		
		c5=new Couple(g3,k2);
		
		
	}
	


	/* Ceci est le close, c'est ici que l'on va fermer les variables de la classe test qui ont besoin de l'etre.
	 * Comme le précise le @After, ceci sera exécuté après la fin de tous les tests
	 * et permet d'éviter les fuites de mémoire où autre soucis.
	 * Dans ce projet, nous n'avons pas de problème de ce type
	 */	
	

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
		Couple c = new Couple(g3, 4);
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
		Couple c = new Couple(g3, 4);
		assertNotSame(c.getG(), g3);
		assertSame(c.getG().toString(), g3.toString());
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
	 * -> l'entrée pose un problème, c'est à dire un graphe g quelconque, et un k supérieur à l'ordre du graphe en paramètre
	 * 
	 * -> le résultat attendu de la part du programme n'est pas le k passé en paramètre, mais un k cohérent avec la situation 
	 * 
	 * -> le résultat obtenu est différent des attentes, en effet, le k n'est pas modifié
	 * 
	 * -> celà peut poser un problème, car il est totalement illogique de chercher un vertex cover est supérieur à l'ordre du graphe . Il suffit de limiter l'étude à l'ordre du graphe
	 * 
	 */
	@Test
	public void creerCoupleKGrand() {
		
		Couple c = new Couple(g3, 1000);
		assertEquals(c.getK(),c.getG().getNodeCount() );
	}
	
	


	/*ce test permet de vérifier que le fonctionnement du Constructeur de Couple
	 * 
	 * ->paramètres d'entrée : un graphe quelconque g3, et un k supérieur à l'ordre du graphe g3
	 * 
	 * ->Le résultat attendu n'est pas le k passé en paramètre, mais un k conhérent avec l'objectif c'est à dire un k normalisé
	 * 
	 * -> Le résultat obtenu ne correspond pas aux attentes puisque le k n'est pas modifié
	 * 
	 * ->Ce résultat est incohérent car nous pouvons recouvrir toutes les arêtes en prenant un k égal à l'ordre du graphe 
	 * 
	 * 
	 */
	



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
		assertEquals(c4.getK(), k1);
	}


	/*Test concernant l'utilisation de la méthode getK
	 * ->entrée : un graphe g3 quelconque ainsi qu'un paramètre k négatif
	 * Le résultat attendu est une normalisation de k, c'est à dire que k doit être compris entre 0 et l'ordre du graphe inclus
	 * Le résultat obtenu n'est pas conforme aux attentes puisque le k n'est pas modifié, il n'y pas eu de normalisation du paramètre
	 */

	@Test 
	public void testGetKNégatif() {
		Couple c= new Couple (g3, -4);
		assertEquals("doivent être égaux",c.getK(),1 ); 
	}
	/*Test concernant l'utilisation de la méthode getK avec un k supérieur à l'ordre du graphe
	 * entrée : couple comportant un graphe g3 et un k supérieur à l'ordre de g3
	 * Le résultat atendu est une normalisation de k c'est à dire que k doit être égal à l'ordre d graphe
	 * Le résultat obtenu n'est pas conforme aux attentes puisque le k n'est pas modifié, il n'y pas eu de normalisation
	 */
	@Test
	public void testGetKGrand() {
		assertEquals("doivent être égaux", c3.getK(),g3.getNodeCount()); 
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
		assertEquals(c4.getG().toString() , g3.toString());
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
		assertSame(c5.getG().toString() , g3.toString());
	}

	/* Ce test permet de vérifier que le graphe créé (avec des sommets) n'est pas nul
	 * Le résultat attendu est que le graphe créé ne fait pas référence à null
	 * Le résultat obtenu est conforme au attentes
	 */
	@Test
	public void getG3NotNull() {
		assertNotNull(c3.getG());
	}

	/*Ce test permet de vérifier que le graphe créé (sans sommets) n'est pas null
	 *Le résultat attendu est que le graphe créé ne fait pas référence à null
	 * Le résultat obtenu est conforme au attentes
	 */
	@Test
	public void getG1NotNull(){
		assertNotNull(c1.getG());
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
		c4.afficherGraph();
	
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
		c5.afficherGraph();
		assertFalse(1 == 2);
	}


	/*Test sur le graphe G
	 * 
	 * 
	 */
	/*ce test permet de vérifier que le graphe créé comporte bien le nombre de sommets attendu
	 * Le résultat attendu est que les nombres de sommets soient égaux (6 ici)
	 * Le résultat obtenu est conforme aux attentes 
	 */
	@Test
	public void testSommet() {
		assertEquals("sommets égaux", c3.getG().getNodeCount(),6);
	}

	/*ce test permet de vérifier que le graphe créé (ensemble de sommets vide) comporte bien 0 sommets
	 * Le résultat obtenu est conforme aux attentes. 
	 */
	@Test
	public void testSommetGraphVide() {
		assertEquals("sommets égaux",c1.getG().getNodeCount(),0); 
	}


	/* ce test permet de vérifier le nombre d'aretes d'un graphe vide 
	 * Le résultat attendu est 0
	 * Le résultat obtenu est conforme au résultat attendu
	 */
	@Test 
	public void testAretesGraphVide() {
		assertEquals("aretes égales", c1.getG().getEdgeCount(),0);
	}

	/* ce test permet de vérifir le nombre d'aretes d'un graphe non vide
	 * le résultat attendu est que le nombre d'aretes du graphe soit conforme aux arretes que nous avons créé (3)
	 * Le résultat obtenu est conforme au résultat attendu. 
	 */
	@Test
	public void testAretesGraph() {
		assertEquals("aretes égales", c3.getG().getEdgeCount(),3);
	}

	/* ce test permet de vérifier le degré d'un sommet
	 * Le résultat attendu doit correspondre au nombre de voisin du sommet(ici 2)
	 * Le résultat obtenu est conforme au résultat attendu
	 */
	@Test
	public void NbDegreSommet() {
		Node a =c3.getG().getNode("2"); 
		assertTrue("relations vraies", a.getDegree()==2 );

	}
	/*
	 * Ce test permet de vérifier qu'une arete n'existe pas
	 * Pour créer une arete nous avons deux possiblités x-y et y-x, nous vérifions que les deux possiblités retourne null
	 * Le test est conforme aux attentes
	 */
	@Test
	public void nonExistenceArete() {
		assertTrue(g3.getEdge("2-3")==null ||g3.getEdge("3-2")==null); 
	}
	/*
	 * Ce test permet de vérifier l'existence d'une arete
	 * A partir d'un graphe g3, on va vérifier que l'arete 1-2 existe. Cette arête existe si la relation 1-2 ne vaut pas null mais que la relation 2-1 vaut null
	 * Le résultat obtenu est conforme aux attentes. 
	 */
	@Test
	public void ExistenceArete() {
		assertTrue(g3.getEdge("1-2")!=null ||g3.getEdge("2-1")==null);
	}
	
	//TEST DE TEMPS AVEC DES PARAMETRES PLUTOT GRAND 
	//(les initialisations se font dans les fonctions car sinon le timeout ne fonctionne pas)
	
	
	
	
	/*
	 * Ce test permet de vérifier la performance du constructeur, il peut varier selon les ordinateur
	 * Nous mettons une durée de 10 secondes avec un graphe de 1 100 000 sommets et un k de 10 00 000. 
	 * Le constructeur met plus de 10 secondes ce qui passe le test en erreur. 
	 * Si nous refaissons le test avec 900 000 sommets, le constructeur s'exécute en moins de 10 secondes. Les performances de cette méthode sont donc très satisfaisantes
	 */
	
	@Test (timeout=10000) 
	public void testConstructeurGrand() {
		gGrand=new SingleGraph("graphe test");
		for(int i=0; i<1100000; i++) {
			//on ajoute des sommets au graphe en convertissant les valeurs en String 
			Node a = gGrand.addNode(String.valueOf(i));
			//on nomme le sommet avec la valeur du i en caractère
			a.addAttribute("ui.label",String.valueOf(i));
		}
		/*
		 * Initialisation d'un grouple à grande valeur 
		 */
		grand=new Couple(gGrand,1100000);
		Couple test=new Couple(gGrand, 1100000);
		assertNotNull(test);
	}
	
		
	/*
	 * Ce test permet de vérifier les performances concernant l'affichage d'un graphe d'un couple
	 *Nous fixons une durée de 10 seconds et ave un graphe de 700 000 sommets, l'affichage dure plus de 10 secondes et le test passe en erreur
	 *Si nous effectuons le test avec 500 000 sommets, l'affichage dure moins de 10 secondes. Les performances sont donc satisfaisantes
	 */
	@Test(timeout=10000)
	public void testAffichage() {
		Graph gGrand2=new SingleGraph("graphe test");
		for(int i=0; i<700000; i++) {
			//on ajoute des sommets au graphe en convertissant les valeurs en String 
			Node a = gGrand2.addNode(String.valueOf(i));
			//on nomme le sommet avec la valeur du i en caractère
			a.addAttribute("ui.label",String.valueOf(i));
		}
		
		gGrandtest=new Couple(gGrand2,10);
		
		gGrandtest.afficherGraph();
		assertTrue(true);
	}
	


}

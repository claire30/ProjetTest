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
	 * Comme le pr�cise le @Before, ceci sera ex�cut� avant les tests
	 * et permet d'avoir des variables instanci�es pour pouvoir s'en servir dans les diff�rents tests 
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
	 * Comme le pr�cise le @After, ceci sera ex�cut� apr�s la fin de tous les tests
	 * et permet d'�viter les fuites de m�moire o� autre soucis.
	 * Dans ce projet, nous n'avons pas de probl�me de ce type
	 */	
	@After
	public void tearDown() throws Exception {
	}
	
	/* Ce test permet de v�rifier que la m�thode <<ins�rer un nom ici>> fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entr�e << est conforme aux attentes  // pose un probl�me ( d�crire le probl�me ie: nb arr�tes < 0 ) >>
	 * 
	 * -> le r�sultat attendu de la part du programme est << une truc normal / lever une exception / r�gler l'erreur sans en informer ... >>
	 * 
	 * -> le r�sultat obtenu est << conforme aux attentes / diff�rent des attentes ( d�crire les diff�rences ) >>
	 * 
	 * -> si r�sultat diff�rent : qu'est ce qui cause ce probl�me ?
	 */
	@Test
	public void unNomSignificatif() {
		// Un morceau de code assertChose(truc);
		assertTrue(true);
	}
	
	//
	//			Tests Constructeur
	//
	
	/* Ce test permet de v�rifier que le constructeur de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entr�e est conforme aux attentes, c'est � dire un graphe g quelconque, et un k strictement positif
	 * 
	 * -> le r�sultat attendu de la part du programme est le k pass� en param�tre obtenu par la m�thode getK()
	 * 
	 * -> le r�sultat obtenu est conforme aux attentes
	 */
	@Test
	public void creerCoupleOkK() {
		Graph g = new SingleGraph("graphe de test");
		Couple c = new Couple(g, 4);
		assertTrue(c.getK() == 4);
	}
	
	/* Ce test permet de v�rifier que le constructeur de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entr�e est conforme aux attentes, c'est � dire un graphe g quelconque, et un k strictement positif
	 * 
	 * -> le r�sultat attendu de la part du programme n'est pas le graphe G pass� en param�tre, mais une copie de ce graphe obtenue par la m�thode getG()
	 * 
	 * -> le r�sultat obtenu est conforme aux attentes
	 */
	@Test
	public void creerCoupleOkGraph() {
		Graph g = new SingleGraph("A modifier");
		Couple c = new Couple(g, 4);
		assertNotSame(c.getG(), g);
		assertSame(c.getG().toString(), g.toString());
	}
	
	/* Ce test permet de v�rifier que le constructeur de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entr�e pose un probl�me, c'est � dire un graphe g quelconque, et un k n�gatif
	 * 
	 * -> le r�sultat attendu de la part du programme n'est pas le k pass� en param�tre, mais un k coh�rent avec la situation 
	 * 
	 * -> le r�sultat obtenu est diff�rent des attentes, en effet, le k n'est pas modifi�
	 * 
	 * -> cel� peut poser un probl�me, car il est totalement illogique et impossible de chercher un vertex cover de taille n�gative dans un graphe
	 * 
	 */
	@Test
	public void creerCoupleKNegatif() {
		Graph g = new SingleGraph("A modifier");
		Couple c = new Couple(g, -4);
		assertNotEquals(-4, c.getK());
	}
	
	/* Ce test permet de v�rifier que le constructeur de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> l'entr�e pose un probl�me, c'est � dire un graphe g null, et un k strictement positif
	 * 
	 * -> le r�sultat attendu de la part du programme n'est pas un graphe null pass� en param�tre, mais un graphe coh�rent avec la situation
	 * 
	 * il est aussi attendu de ne pas avoir d'erreur de type "NullPointerException"
	 * 
	 * -> le r�sultat obtenu est diff�rent des attentes, en effet, une erreur de type NullPointerException est lev�e, mais n'est pas g�r�e par la classe.
	 * 
	 * -> Ce probl�me est d� � la fonction Graphs.clone() qui renvoie cette erreur si le graphe pass� en argument est null.
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
	
	/* Ce test permet de v�rifier que la m�thode getK() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entr�e standard
	 * 
	 * -> le r�sultat attendu de la part du programme est le k choisis dans la fonction setUp() ( soit 4 )
	 * 
	 * -> le r�sultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void getKNormal() {
		assertEquals(c1.getK(), k1);
	}
	
	/* Ce test permet de v�rifier que la m�thode getK() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entr�e standard
	 * 
	 * -> le r�sultat attendu de la part du programme est le k choisis dans la fonction setUp() ( soit 6 )
	 * 
	 * -> le r�sultat obtenu est diff�rent des attentes, en effet, une erreur de type NullPointerException est lev�e, mais n'est pas g�r�e par la classe.
	 * 
	 * -> Ce probl�me est d� � la fonction Graphs.clone() qui renvoie cette erreur si le graphe pass� en argument est null.
	 * 
	 */
	@Test
	public void getK2Normal() {
		assertEquals(c2.getK(), k2);
	}
	
	//
	//			Tests getG()
	//
	
	/* Ce test permet de v�rifier que la m�thode getG() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entr�e standard
	 * 
	 * -> on teste avec un .toString() afin de comparer que les deux graphes soit identiques, biens que le graphe du couple ai �t� clon�
	 * 
	 * -> le r�sultat attendu de la part du programme est que les deux graphes soit identiques
	 * 
	 * -> le r�sultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void getGNormal() {
		assertEquals(c1.getG().toString() , g1.toString());
	}
	
	/* Ce test permet de v�rifier que la m�thode getG() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entr�e standard
	 * 
	 * -> on teste avec un .toString() afin de comparer que les deux graphes soit identiques, biens que le graphe du couple ai �t� clon�
	 * 
	 * -> le r�sultat attendu de la part du programme est que les deux graphes soit identiques
	 * 
	 * -> le r�sultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void getG2Normal() {
		assertSame(c2.getG().toString() , g2.toString());
	}
	
	//
	//			Tests afficherGraph()
	//
	
	/* Ce test permet de v�rifier que la m�thode afficherGraph() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entr�e standard
	 * 
	 * -> on teste uniquement d'appeller la m�thode et on confirme le test si la fonction ne renvoie pas d'erreur
	 * car cette fonction ne renvoie rien et ne modifie aucun attribut, aussi bien sur l'objet Couple que sur lobjet Graph du couple
	 * 
	 * -> le r�sultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void afficherGraph1Normal() {
		c1.afficherGraph();
		assertFalse(1 == 2);
	}
	
	/* Ce test permet de v�rifier que la m�thode afficherGraph() de Couple fonctionne correctement dans les conditions suivantes :
	 * 
	 * -> entr�e standard
	 * 
	 * -> on teste uniquement d'appeller la m�thode et on confirme le test si la fonction ne renvoie pas d'erreur
	 * car cette fonction ne renvoie rien et ne modifie aucun attribut, aussi bien sur l'objet Couple que sur l'objet Graph du couple
	 * 
	 * -> le r�sultat obtenu est conforme aux attentes
	 * 
	 */
	@Test
	public void afficherGraph2Normal() {
		c2.afficherGraph();
		assertFalse(1 == 2);
	}
	
}

import static org.junit.Assert.*;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoupleTest {

	/* Ceci est le setup, c'est ici que l'on va instancier et initialiser les variables de la classe test.
	 * Comme le pr�cise le @Before, ceci sera ex�cut� avant les tests
	 * et permet d'avoir des variables instanci�es pour pouvoir s'en servir dans les diff�rents tests 
	 */
	@Before
	public void setUp() throws Exception {
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
	public void test() {
		fail("Not yet implemented");
	}
	
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
	 * -> le r�sultat attendu de la part du programme est le graphe G pass� en param�tre obtenu par la m�thode getG()
	 * 
	 * -> le r�sultat obtenu est diff�rent des attentes, en effet, le grahe n'est pas �gal au graphe pass� en argument.
	 * 
	 * -> Cel� peut etre d� au fait que le graphe g pass� en argument est clon� avant d'etre conserv� afin de ne pas modfier le graphe de d�part
	 */
	@Test
	public void creerCoupleOkGraph() {
		Graph g = new SingleGraph("A modifier");
		Couple c = new Couple(g, 4);
		assertTrue(c.getG().equals(g));
	}

}

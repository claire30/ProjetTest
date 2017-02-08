import static org.junit.Assert.*;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoupleTest {

	/* Ceci est le setup, c'est ici que l'on va instancier et initialiser les variables de la classe test.
	 * Comme le précise le @Before, ceci sera exécuté avant les tests
	 * et permet d'avoir des variables instanciées pour pouvoir s'en servir dans les différents tests 
	 */
	@Before
	public void setUp() throws Exception {
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
	public void test() {
		fail("Not yet implemented");
	}
	
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
	 * -> le résultat attendu de la part du programme est le graphe G passé en paramètre obtenu par la méthode getG()
	 * 
	 * -> le résultat obtenu est différent des attentes, en effet, le grahe n'est pas égal au graphe passé en argument.
	 * 
	 * -> Celà peut etre dû au fait que le graphe g passé en argument est cloné avant d'etre conservé afin de ne pas modfier le graphe de départ
	 */
	@Test
	public void creerCoupleOkGraph() {
		Graph g = new SingleGraph("A modifier");
		Couple c = new Couple(g, 4);
		assertTrue(c.getG().equals(g));
	}

}

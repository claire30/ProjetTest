import static org.junit.Assert.*;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.Before;
import org.junit.Test;

public class KernelTest {

	private Kernel ke1;
	private Kernel ke2;

	private Kernel keg0;
	private Kernel keg1;
	private Kernel keg2;

	private Graph g1;
	private Graph g2;

	private int k1;
	private int k2;

	private Couple c1;
	private Couple c2;

	/*
	 * Ceci est le setup, c'est ici que l'on va instancier et initialiser les
	 * variables de la classe test. Comme le précise le @Before, ceci sera
	 * exécuté avant les tests et permet d'avoir des variables instanciées pour
	 * pouvoir s'en servir dans les différents tests
	 */
	@Before
	public void setUp() throws Exception {

		ke1 = new Kernel();
		ke2 = new Kernel();

		keg0 = new Kernel();
		keg0.ajoutRegle(0);
		
		keg1 = new Kernel();
		keg1.ajoutRegle(1);

		keg2 = new Kernel();
		keg2.ajoutRegle(2);

		k1 = 4;
		k2 = 3;

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
	}

	//
	// Test Constructeur
	//

	/*
	 * Ce test permet de vérifier que le constructeur de Kernel fonctionne
	 * correctement
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel ne
	 * soit pas null, et que sa liste de lrègles non plus
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void testConstructeur() {
		Kernel k = new Kernel();

		assertNotNull(k);
		assertNotNull(k.liste);

		assertTrue(k.liste.size() == 0);
	}

	//
	// Test ajoutRègle
	//

	/*
	 * Ce test permet de vérifier que la fonction ajoutRegle de Kernel
	 * fonctionne corerctement
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel
	 * contienne la règle demandée, et uniquement celle-ci
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void testAjoutRegleNormal() {

		assertEquals(ke1.liste, ke2.liste);

		ke1.ajoutRegle(0);
		ke2.ajoutRegle(1);

		assertNotEquals(ke1.liste, ke2.liste);
		assertEquals(ke1.liste.size(), ke2.liste.size());
	}

	/*
	 * Ce test permet de vérifier que la fonction ajoutRegle de Kernel
	 * fonctionne correctement
	 * 
	 * -> Pour celà, on essaye de mettre deux fois la même règle dans la liste
	 * d'un Kernel
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel
	 * contienne la règle demandée une seule fois, et ignore la seconde demande,
	 * car il est inutile d'avoir deux fois la même règle dans un mêm Kernel
	 * 
	 * -> le résultat obtenu est différent de celui attendu En effet, la règle
	 * est ajoutée une deuxième fois
	 */

	@Test
	public void testAjoutRegleDouble() {

		assertTrue(ke1.liste.isEmpty());

		ke1.ajoutRegle(0);
		assertFalse(ke1.liste.isEmpty());

		assertEquals(ke1.liste.size(), 1);

		ke1.ajoutRegle(0);
		assertNotEquals(ke1.liste.size(), 2);

	}

	/*
	 * Ce test permet de vérifier que la fonction ajoutRegle de Kernel
	 * fonctionne corerctement
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel
	 * contienne la règle demandée, et uniquement celle-ci
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void testAjoutRegleNormal2() {

		assertEquals(ke1.liste, ke2.liste);

		Regle r1 = new Regle(0);
		Regle r2 = new Regle(1);

		ke1.ajoutRegle(r1);
		ke2.ajoutRegle(r2);

		assertNotEquals(ke1.liste, ke2.liste);
		assertEquals(ke1.liste.size(), ke2.liste.size());
	}

	/*
	 * Ce test permet de vérifier que la fonction ajoutRegle de Kernel
	 * fonctionne correctement
	 * 
	 * -> Pour celà, on essaye de mettre deux fois la même règle dans la liste
	 * d'un Kernel
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel
	 * contienne la règle demandée une seule fois, et ignore la seconde demande,
	 * car il est inutile d'avoir deux fois la même règle dans un même Kernel
	 * 
	 * -> le résultat obtenu est différent de celui attendu En effet, si on
	 * utilise le même objet regle lors de la création, celle-ci est bien unique,
	 * cependant, en créant une deuième Regle, mais cependant avec le même
	 * numéro, on obtient une Regle identique à la précedente, mais qui peux
	 * cependant etre ajoutée à la liste, et on se retrouve donc avec deux fois
	 * la même règle dans le Kernel.
	 */
	@Test
	public void testAjoutRegleDouble2() {

		Regle r1 = new Regle(0);

		assertTrue(ke1.liste.isEmpty());

		ke1.ajoutRegle(r1);
		assertFalse(ke1.liste.isEmpty());

		assertEquals(ke1.liste.size(), 1);

		ke1.ajoutRegle(r1);
		assertNotEquals(ke1.liste.size(), 2);

		Regle r2 = new Regle(0);

		ke1.ajoutRegle(r2);
		assertNotEquals(ke1.liste.size(), 2);

	}

	/*
	 * Ce test permet de vérifier que la fonction ajoutRegle de Kernel
	 * fonctionne correctement
	 * 
	 * -> Pour celà, on essaye de mettre un pointeur null comme argument de la
	 * fonction
	 * 
	 * -> le résultat attendu de la part du programme est le que la fonction ne
	 * crée pas une règle null pour la mettre dans la liste mais plutot, qu'il
	 * ignore l'instruction
	 * 
	 * -> le résultat obtenu est différent de celui attendu En effet, une Regle
	 * "null" est ajoutée à la liste
	 */
	@Test
	public void testAjoutRegleNull() {

		assertTrue(ke1.liste.isEmpty());

		ke1.ajoutRegle(null);
		assertTrue(ke1.liste.isEmpty());

		Regle r2 = new Regle(0);

		ke1.ajoutRegle(r2);
		assertNotEquals(ke1.liste.size(), 1);

	}

	//
	// Test appliquerRegle
	//

	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si la règle 0 enlève bien le sommet 0 du graphe g1, qui est de degrès 0, sans modifier le k
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 0 est supprimé du graphe, et le k n'est pas modifié
	 *
	 */
	@Test
	public void testAppliquerRegle0() {
		Couple cRes = keg0.appliquerRegle(c1);
		
		assertTrue(cRes.getG().getNodeCount() == c1.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("6"));
		
		assertEquals(cRes.getK(), c1.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si la règle 1 enlève bien le sommet 6 du graphe g1, car il est le seul voisin du sommet 8, de degrès 1
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 6 est supprimé du graphe, et le k est décrémenté
	 * 
	 */
	@Test
	public void testAppliquerRegle1() {
		Couple cRes = keg1.appliquerRegle(c1);
		
		assertTrue(cRes.getG().getNodeCount() == c1.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("6"));
		assertNotNull(cRes.getG().getNode("0"));
		
		assertEquals(cRes.getK(), c1.getK() -1);
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si la règle 2 enlève bien le sommet 0 du graphe g2, car il est de degrès 4, ce qui est supérieur à k=3, tout en décrémentant k
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 0 est supprimé du graphe, et le k est décrémenté
	 * 
	 */
	@Test
	public void testAppliquerRegle2() {
		Couple cRes = keg2.appliquerRegle(c2);
		
		assertTrue(cRes.getG().getNodeCount() == c2.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("1"));
		
		assertEquals(cRes.getK(), c2.getK() -1);
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si, en passant un couple null au kernel, celui-ci nous renvoie un couple non null ou pas
	 * 
	 * -> la méthode renvoie un null pointeur exception
	 * 
	 */
	@Test
	public void testAppliquerRegleNull() {
		Couple cRes = keg1.appliquerRegle(null);
		
		assertNotNull(cRes);
	}
	

	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 0 sur g2
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * cependant, on rentre dans la boucle, car il faut appuyer sur entré pour continuer,
	 * ce qui est une perte de performances, car il n'était pas besoin de rentrer dans la boucle
	 * 
	 */
	@Test
	public void testAppliquerRegle0Inutile() {
		Couple cRes = keg0.appliquerRegle(c2);
		
		assertEquals(cRes.getG().toString(),c2.getG().toString());
		
		assertFalse(cRes.getK() != c2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 1 sur g2
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * cependant, on rentre dans la boucle, car il faut appuyer sur entré pour continuer,
	 * ce qui est une perte de performances, car il n'était pas besoin de rentrer dans la boucle
	 * 
	 */
	@Test
	public void testAppliquerRegle1Inutile() {
		Couple cRes = keg1.appliquerRegle(c2);
		
		assertEquals(cRes.getG().toString(),c2.getG().toString());
		
		assertFalse(cRes.getK() != c2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 2 sur g2 avec un k=10
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * Il n'est même pas necessaire d'apuyer sur entré, ce qui montre que l'on n'est pas rentré dans la boucle
	 * ce qui est un gain de temps et de performances
	 */
	@Test
	public void testAppliquerRegle2Inutile() {
		Couple cInutile2 = new Couple(g2, 10);
		Couple cRes = keg2.appliquerRegle(cInutile2);
		
		assertEquals(cRes.getG().toString(),cInutile2.getG().toString());
		
		assertFalse(cRes.getK() != cInutile2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Kernel fonctionne, même si le Kernel est "incorrect"
	 * 
	 * Pour celà, on crée un Kernel avec une règle qui n'est aps censé exister ( par exemple, la règle 3 )
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui n'existe pas
	 * C'est à dire, si on applique la règle 3 sur g1
	 * 
	 */
	@Test
	public void testAppliquerRegleInexistante() {
		Kernel keInexist = new Kernel();
		keInexist.ajoutRegle(300);
		
		Couple cRes = keInexist.appliquerRegle(c1);
		
		assertEquals(cRes.getG().toString(),c1.getG().toString());
		
		assertFalse(cRes.getK() != c1.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegle de Kernel fonctionne, même si le Kernel est "incorrect"
	 * 
	 * Pour celà, on crée un Kernel avec plusieurs règles qui ne sont pas censées exister ( par exemple, les règles 3/4/5 )
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui n'existe pas
	 * C'est à dire, si on applique les règles 3/4 et 5 sur g1
	 * 
	 */
	@Test
	public void testAppliquerReglesInexistantes() {
		Kernel keInexist = new Kernel();
		keInexist.ajoutRegle(3);
		keInexist.ajoutRegle(4);
		keInexist.ajoutRegle(5);
		
		Couple cRes = keInexist.appliquerRegle(c1);
		
		assertEquals(cRes.getG().toString(),c1.getG().toString());
		
		assertFalse(cRes.getK() != c1.getK());
	}
	
	//
	// Test kernelisation
	//

	/*
	 * Ce test permet de vérifier que la fonction kernelisation de Kernel
	 * fonctionne corerctement
	 * 
	 * -> le graphe g2 est fait de telle sorte qu'il soit possible de trouver un vertex cover de taille 3,
	 * cette fonction est donc supposée renvoyer vrai
	 * 
	 * -> La fonction renvoie cependant faux. Celà est dû au fait que, après l'application des règles,
	 * le graphe n'est pas vide, c'est à dire, qu'il reste encore un sommet, de degrès 0, qui devrais etre enlevé par la règle 0
	 * et donc la condition sur le nombre de sommet = 0 est fausse
	 * 
	 * il faudrait reappliquer la regle 0 a la fin de la simulation pour remplir la condition
	 */
	@Test
	public void testKernelisationOui() {
		
		assertTrue(Kernel.kernelization(c2));
		
	}
	
	/*
	 * Ce test permet de vérifier que la fonction kernelisation de Kernel
	 * fonctionne corerctement
	 * 
	 * -> le graphe g1 est fait de telle sorte qu'il ne soit pas possible de trouver un vertex cover de taille 4,
	 * cette fonction doit donc retourner faux
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void testKernelisationNon() {
		
		assertFalse(Kernel.kernelization(c1));
		
	}
	
	/*
	 * Ce test permet de vérifier que la fonction kernelisation de Kernel
	 * fonctionne correctement
	 * 
	 * -> on passe un argument null a la fonction pour voir sa réaction
	 * On s'attend a ce que l'argument null soit géré, et qu'il n'y ai pas de nullPointerException
	 * 
	 * -> La méthode lève un NullPointerException
	 */
	@Test
	public void testKernelisationNull() {
		
		assertFalse(Kernel.kernelization(null));
		
	}
	
	//
	// Test appliquerRegleB
	//

	/*
	 * Ce test permet de vérifier que la fonction appliquerRegleB de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si la règle 0 enlève bien le sommet 0 du graphe g1, qui est de degrès 0, sans modifier le k
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 0 est supprimé du graphe, et le k n'est pas modifié
	 *
	 */
	@Test
	public void testAppliquerRegleB0() {
		Couple cRes = keg0.appliquerRegleB(c1);
		
		assertTrue(cRes.getG().getNodeCount() == c1.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("6"));
		
		assertEquals(cRes.getK(), c1.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegleB de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si la règle 1 enlève bien le sommet 6 du graphe g1, car il est le seul voisin du sommet 8, de degrès 1
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 6 est supprimé du graphe, et le k est décrémenté
	 * 
	 */
	@Test
	public void testAppliquerRegleB1() {
		Couple cRes = keg1.appliquerRegleB(c1);
		
		assertTrue(cRes.getG().getNodeCount() == c1.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("6"));
		assertNotNull(cRes.getG().getNode("0"));
		
		assertEquals(cRes.getK(), c1.getK() -1);
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegleB de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si la règle 2 enlève bien le sommet 0 du graphe g2, car il est de degrès 4, ce qui est supérieur à k=3, tout en décrémentant k
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 0 est supprimé du graphe, et le k est décrémenté
	 * 
	 */
	@Test
	public void testAppliquerRegleB2() {
		Couple cRes = keg2.appliquerRegleB(c2);
		
		assertTrue(cRes.getG().getNodeCount() == c2.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("1"));
		
		assertEquals(cRes.getK(), c2.getK() -1);
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegleB de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si, en passant un couple null au kernel, celui-ci nous renvoie un couple non null ou pas
	 * 
	 * -> la méthode renvoie un null pointeur exception
	 * 
	 */
	@Test
	public void testAppliquerRegleBNull() {
		Couple cRes = keg1.appliquerRegleB(null);
		
		assertNotNull(cRes);
	}
	

	/*
	 * Ce test permet de vérifier que la fonction appliquerRegleB de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 0 sur g2
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * cependant, on rentre dans la boucle, car il faut appuyer sur entré pour continuer,
	 * ce qui est une perte de performances, car il n'était pas besoin de rentrer dans la boucle
	 * 
	 */
	@Test
	public void testAppliquerRegleB0Inutile() {
		Couple cRes = keg0.appliquerRegleB(c2);
		
		assertEquals(cRes.getG().toString(),c2.getG().toString());
		
		assertFalse(cRes.getK() != c2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegleB de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 1 sur g2
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * cependant, on rentre dans la boucle, car il faut appuyer sur entré pour continuer,
	 * ce qui est une perte de performances, car il n'était pas besoin de rentrer dans la boucle
	 * 
	 */
	@Test
	public void testAppliquerRegleB1Inutile() {
		Couple cRes = keg1.appliquerRegleB(c2);
		
		assertEquals(cRes.getG().toString(),c2.getG().toString());
		
		assertFalse(cRes.getK() != c2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegleB de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 2 sur g2 avec un k=10
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * Il n'est même pas necessaire d'apuyer sur entré, ce qui montre que l'on n'est pas rentré dans la boucle
	 * ce qui est un gain de temps et de performances
	 */
	@Test
	public void testAppliquerRegleB2Inutile() {
		Couple cInutile2 = new Couple(g2, 10);
		Couple cRes = keg2.appliquerRegleB(cInutile2);
		
		assertEquals(cRes.getG().toString(),cInutile2.getG().toString());
		
		assertFalse(cRes.getK() != cInutile2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegleB de Kernel fonctionne, même si le Kernel est "incorrect"
	 * 
	 * Pour celà, on crée un Kernel avec une règle qui n'est aps censé exister ( par exemple, la règle 3 )
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui n'existe pas
	 * C'est à dire, si on applique la règle 3 sur g1
	 * 
	 */
	@Test
	public void testAppliquerRegleBInexistante() {
		Kernel keInexist = new Kernel();
		keInexist.ajoutRegle(300);
		
		Couple cRes = keInexist.appliquerRegleB(c1);
		
		assertEquals(cRes.getG().toString(),c1.getG().toString());
		
		assertFalse(cRes.getK() != c1.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerRegleB de Kernel fonctionne, même si le Kernel est "incorrect"
	 * 
	 * Pour celà, on crée un Kernel avec plusieurs règles qui ne sont pas censées exister ( par exemple, les règles 3/4/5 )
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui n'existe pas
	 * C'est à dire, si on applique les règles 3/4 et 5 sur g1
	 * 
	 */
	@Test
	public void testAppliquerReglesBInexistantes() {
		Kernel keInexist = new Kernel();
		keInexist.ajoutRegle(3);
		keInexist.ajoutRegle(4);
		keInexist.ajoutRegle(5);
		
		Couple cRes = keInexist.appliquerRegleB(c1);
		
		assertEquals(cRes.getG().toString(),c1.getG().toString());
		
		assertFalse(cRes.getK() != c1.getK());
	}
	
	//
	// Test appliquerString
	//

	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si la règle 0 enlève bien le sommet 0 du graphe g1, qui est de degrès 0, sans modifier le k
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 0 est supprimé du graphe, et le k n'est pas modifié
	 *
	 */
	@Test
	public void testAppliquerString0() {
		Couple cRes = Kernel.appliquerString(c1,"0");
		
		assertTrue(cRes.getG().getNodeCount() == c1.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("6"));
		
		assertEquals(cRes.getK(), c1.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si la règle 1 enlève bien le sommet 6 du graphe g1, car il est le seul voisin du sommet 8, de degrès 1
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 6 est supprimé du graphe, et le k est décrémenté
	 * 
	 */
	@Test
	public void testAppliquerString1() {
		Couple cRes = Kernel.appliquerString(c1,"1");
		
		assertTrue(cRes.getG().getNodeCount() == c1.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("6"));
		assertNotNull(cRes.getG().getNode("0"));
		
		assertEquals(cRes.getK(), c1.getK() -1);
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si la règle 2 enlève bien le sommet 0 du graphe g2, car il est de degrès 4, ce qui est supérieur à k=3, tout en décrémentant k
	 * 
	 * -> Le résultat est bien celui attendu, c'est à dire que le sommet 0 est supprimé du graphe, et le k est décrémenté
	 * 
	 */
	@Test
	public void testAppliquerString2() {
		Couple cRes = Kernel.appliquerString(c2, "2");
		
		assertTrue(cRes.getG().getNodeCount() == c2.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("1"));
		
		assertEquals(cRes.getK(), c2.getK() -1);
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si, en passant un string null au kernel, celui-ci nous renvoie un couple non null ou pas
	 * 
	 * -> la méthode renvoie un null pointeur exception
	 * 
	 */
	@Test
	public void testAppliquerStringNull() {
		Couple cRes = Kernel.appliquerString(c1, null);
		
		assertNotNull(cRes);
	}
	

	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 0 sur g2
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * cependant, on rentre dans la boucle, car il faut appuyer sur entré pour continuer,
	 * ce qui est une perte de performances, car il n'était pas besoin de rentrer dans la boucle
	 * 
	 */
	@Test
	public void testAppliquerString0Inutile() {
		Couple cRes = Kernel.appliquerString(c2, "0");
		
		assertEquals(cRes.getG().toString(),c2.getG().toString());
		
		assertFalse(cRes.getK() != c2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 1 sur g2
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * cependant, on rentre dans la boucle, car il faut appuyer sur entré pour continuer,
	 * ce qui est une perte de performances, car il n'était pas besoin de rentrer dans la boucle
	 * 
	 */
	@Test
	public void testAppliquerString1Inutile() {
		Couple cRes = Kernel.appliquerString(c2, "1");
		
		assertEquals(cRes.getG().toString(),c2.getG().toString());
		
		assertFalse(cRes.getK() != c2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne correctement
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui ne s'applique pas à lui-même
	 * C'est à dire, si on applique la règle 2 sur g2 avec un k=10
	 * 
	 * -> le résultat est bien celui attendu, c'est à dire que ni le graphe ni le k n'est modifié
	 * Il n'est même pas necessaire d'apuyer sur entré, ce qui montre que l'on n'est pas rentré dans la boucle
	 * ce qui est un gain de temps et de performances
	 */
	@Test
	public void testAppliquerString2Inutile() {
		Couple cInutile2 = new Couple(g2, 10);
		Couple cRes = Kernel.appliquerString(cInutile2, "2");
		
		assertEquals(cRes.getG().toString(),cInutile2.getG().toString());
		
		assertFalse(cRes.getK() != cInutile2.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne, même si le Kernel est "incorrect"
	 * 
	 * Pour celà, on crée un Kernel avec une règle qui n'est aps censé exister ( par exemple, la règle 3 )
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui n'existe pas
	 * C'est à dire, si on applique la règle 5 sur g1
	 * 
	 */
	@Test
	public void testAppliquerStringInexistante() {
		
		Couple cRes = Kernel.appliquerString(c1, "5");
		
		assertEquals(cRes.getG().toString(),c1.getG().toString());
		
		assertFalse(cRes.getK() != c1.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne, même si le Kernel est "incorrect"
	 * 
	 * Pour celà, on crée un Kernel avec plusieurs règles qui ne sont pas censées exister ( par exemple, les règles 3/4/5 )
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui n'existe pas
	 * C'est à dire, si on applique les règles 3/4 et 5 sur g1
	 * 
	 */
	@Test
	public void testAppliquerStringInexistantes() {
		
		Couple cRes = Kernel.appliquerString(c1, "345");
		
		assertEquals(cRes.getG().toString(),c1.getG().toString());
		
		assertFalse(cRes.getK() != c1.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne, même si le Kernel est "incorrect"
	 * 
	 * Pour celà, on crée un Kernel avec plusieurs règles qui ne sont pas censées exister ( par exemple, les règles 3/4/5 )
	 * et d'autres règles qui existent ( par exemple, la règle 0)
	 * 
	 * -> on vérifie si le graphe est modifié par une règle qui n'existe pas
	 * C'est à dire, si on applique les règles 3/4 et 5 sur g1
	 * Tout en étant réelement modifié par la règle 0
	 * 
	 */
	@Test
	public void testAppliquerStringMiInexistantes() {
		
		Couple cRes = Kernel.appliquerString(c1, "3045");
		
		assertTrue(cRes.getG().getNodeCount() == c1.getG().getNodeCount() -1);
		
		assertNull(cRes.getG().getNode("0"));
		assertNotNull(cRes.getG().getNode("6"));
		
		assertEquals(cRes.getK(), c1.getK());
	}
	
	/*
	 * Ce test permet de vérifier que la fonction appliquerString de Kernel fonctionne, même si le Kernel est "incorrect"
	 * 
	 * Pour celà, on crée crée un string qui ne contien pas des nombres, mais des lettres
	 * 
	 * -> on vérifie si une exception est crée, ou si le programme gère l'erreur, et ne fait rien
	 * 
	 */
	@Test
	public void testAppliquerStringLettres() {
		
		Couple cRes = Kernel.appliquerString(c1, "toto");
		
		assertEquals(cRes.getG().toString(),c1.getG().toString());
		
		assertFalse(cRes.getK() != c1.getK());
	}
	

}





















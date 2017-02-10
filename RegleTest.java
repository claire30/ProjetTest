import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegleTest {
	
	Regle r;
	
	@Before
	public void initRegle() {
		r = new Regle(1);
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
		
		assertEquals("doît être égaux", r0.getNum(), 0);
		assertEquals("doît être égaux", r1.getNum(), 1);
		assertEquals("doît être égaux", r2.getNum(), 2);
	}
	
	
	/* Ce test permet de vérifier que le constructeur de la classe Regle fonctionne correctement dans les conditions suivantes :
	 * -> l'objet ne doit pas être crée lors que les mauvaise valeurs sont passées en paramètre, c'est-à-dire n est différent de 0, 1, 2.
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void testMauvaiseNumRegle() {
		Regle r0 = new Regle(3);
		Regle r1 = new Regle(-1);
		Regle r2 = new Regle(100);
		
		assertNull("Doît être null", r0);
		assertNull("Doît être null", r1);
		assertNull("Doît être null", r2);
		
	}
	



}

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KernelTest {
	
	private Kernel k1;
	private Kernel k2;
	
	/* Ceci est le setup, c'est ici que l'on va instancier et initialiser les variables de la classe test.
	 * Comme le précise le @Before, ceci sera exécuté avant les tests
	 * et permet d'avoir des variables instanciées pour pouvoir s'en servir dans les différents tests 
	 */
	@Before
	public void setUp() throws Exception {
		
		k1 = new Kernel();
		k2 = new Kernel();		
	}

	
	//
	//			Test Constructeur
	//
	
	/* Ce test permet de vérifier que le constructeur de Kernel fonctionne correctement
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel ne soit pas null, et que sa liste de lrègles non plus
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

}

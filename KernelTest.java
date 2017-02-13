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
	
	//
	//			Test ajoutRègle
	//
	
	/* Ce test permet de vérifier que la fonction ajoutRegle de Kernel fonctionne corerctement
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel contienne la règle demandée, et uniquement celle-ci
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void testAjoutRegleNormal() {

		assertEquals(k1.liste, k2.liste);
		
		k1.ajoutRegle(0);
		k2.ajoutRegle(1);
		
		assertNotEquals(k1.liste, k2.liste);
		assertEquals(k1.liste.size(), k2.liste.size());
	}
	
	/* Ce test permet de vérifier que la fonction ajoutRegle de Kernel fonctionne correctement
	 * 
	 * -> Pour celà, on essaye de mettre deux fois la même règle dans la liste d'un Kernel
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel contienne la règle demandée une seule fois, et ignore la seconde demande, 
	 * car il est inutile d'avoir deux fois la même règle dans un mêm Kernel
	 * 
	 * -> le résultat obtenu est différent de celui attendu
	 * En effet, la règle est ajoutée une deuxième fois
	 */
	
	@Test
	public void testAjoutRegleDouble() {
		
		assertTrue(k1.liste.isEmpty());
		
		k1.ajoutRegle(0);
		assertFalse(k1.liste.isEmpty());
		
		assertEquals(k1.liste.size(),1);
		
		k1.ajoutRegle(0);
		assertNotEquals(k1.liste.size(),2);
		
	}
	
	/* Ce test permet de vérifier que la fonction ajoutRegle de Kernel fonctionne corerctement
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel contienne la règle demandée, et uniquement celle-ci
	 * 
	 * -> le résultat obtenu est conforme aux attentes
	 */
	@Test
	public void testAjoutRegleNormal2() {

		assertEquals(k1.liste, k2.liste);
		
		Regle r1 = new Regle(0);
		Regle r2 = new Regle(1);
		
		k1.ajoutRegle(r1);
		k2.ajoutRegle(r2);
		
		assertNotEquals(k1.liste, k2.liste);
		assertEquals(k1.liste.size(), k2.liste.size());
	}
	
	/* Ce test permet de vérifier que la fonction ajoutRegle de Kernel fonctionne correctement
	 * 
	 * -> Pour celà, on essaye de mettre deux fois la même règle dans la liste d'un Kernel
	 * 
	 * -> le résultat attendu de la part du programme est le que le Kernel contienne la règle demandée une seule fois, et ignore la seconde demande, 
	 * car il est inutile d'avoir deux fois la même règle dans un mêm Kernel
	 * 
	 * -> le résultat obtenu est différent de celui attendu
	 * En effet, si on utilise le même objet regle lors de la création, celle-ci est bien unqie, cependant, en créant une deuième Regle,
	 * mais cependant avec le même numéro, on obtient une Regle identique à la précedente, mais qui peux cependant etre ajoutée à la liste,
	 * et on se retrouve donc avec deux fois la même règle dans le Kernel.
	 */
	@Test
	public void testAjoutRegleDouble2() {
		
		Regle r1 = new Regle(0);
		
		assertTrue(k1.liste.isEmpty());
		
		k1.ajoutRegle(r1);
		assertFalse(k1.liste.isEmpty());
		
		assertEquals(k1.liste.size(),1);
		
		k1.ajoutRegle(r1);
		assertNotEquals(k1.liste.size(),2);
		
		Regle r2 = new Regle(0);
		
		k1.ajoutRegle(r2);
		assertNotEquals(k1.liste.size(),2);
		
	}
	
	/* Ce test permet de vérifier que la fonction ajoutRegle de Kernel fonctionne correctement
	 * 
	 * -> Pour celà, on essaye de mettre un pointeur null comme argument de la fonction
	 * 
	 * -> le résultat attendu de la part du programme est le que la fonction ne crée pas une règle null pour la mettre dans la liste
	 * mais plutot, qu'il ignore l'instruction
	 * 
	 * -> le résultat obtenu est différent de celui attendu
	 * En effet, une Regle "null" est ajoutée à la liste
	 */
	@Test
	public void testAjoutRegleNull() {
		
		assertTrue(k1.liste.isEmpty());
		
		k1.ajoutRegle(null);
		assertTrue(k1.liste.isEmpty());
		
		Regle r2 = new Regle(0);
		
		k1.ajoutRegle(r2);
		assertNotEquals(k1.liste.size(),1);
		
	}

}











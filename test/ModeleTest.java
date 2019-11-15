/**
 * Classe de test unitaire
 */

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModeleTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	 /**
	  * Test de la connexion d'un utilisateur
	  */
	public void testConnexion_utilisateur() {
		String login = "onur";
		String mdp = "palali";
		Assert.assertTrue("CA MARCHE PAS !", Modele.connexion_utilisateur(login, mdp));
	}
}

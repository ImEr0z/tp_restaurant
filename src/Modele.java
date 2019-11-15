
/**
 * @author opalali
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Modele {

	/**
	 * Déclaration des objets de connexion
	 * connexion = pour se connecter
	 * st = permet l'exécution d'une requête
	 * rs = permet la saisie d'une réquête et le retour
	 */
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement ps;

	/**
	 * Fonction de connexion à la BDD
	 * Condition de connexion à la BDD
	 * avec le try et catch.
	 */
	public static void connexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.100/2020palali", "opalali", "123456");
			st = connexion.createStatement();
		}
		catch(ClassNotFoundException erreur) {
			System.out.println("Driver non chargé !" + erreur);
		}
		catch(SQLException erreur) {
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
	}

	/**
	 * Fonction de déconnexion
	 * Avec le try/catch
	 */
	public static void deconnexion(){
		try {
			connexion.close();
		} catch (SQLException erreur) {
			System.out.println("La déconnexion à la base de données a échouée ou Erreur SQL…" + erreur);
		}
	}
	
	/**
	 * Fonction de connexion d'un utilisateur
	 * Avec le try/catch
	 */
	/*public static void connexion_utilisateur(String login, String mdp){
		try {
			ps = connexion.prepareStatement("SELECT * FROM utilisateur WHERE loginUtilisateur = '" + login + "' AND mdpUtilisateur = '" + mdp + "'");
			rs = ps.executeQuery();
			int count = rs.getRow();
			if(count > 0){
				JOptionPane.showMessageDialog(null, "Le S.H.I.E.L.D. vous souhaite la bienvenue : " + "AGENT ", "Shield's information", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "ACCES REFUSÉ",  "Shield's information", JOptionPane.INFORMATION_MESSAGE);
				Modele.deconnexion();
				System.exit(0);
			}
		}
		catch (SQLException erreur) {
			System.out.println("La requête de connexion à la base de données a échouée ou Erreur SQL…" + erreur);
		}
	}*/
	
	/**
	 * Fonction de connexion d'un utilisateur
	 * Avec le try/catch en boolean
	 * @param login
	 * @param mdp
	 * @return
	 */
	public static boolean connexion_utilisateur(String login, String mdp){
		connexion();
		int count = 0;
		try{
			ps = connexion.prepareStatement("SELECT COUNT(loginUtilisateur) FROM utilisateur WHERE loginUtilisateur = ? AND  mdpUtilisateur = ?");
			ps.setString(1, login);
			ps.setString(2, mdp);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
			rs.close();
			ps.close();
			deconnexion();
		} 
		catch (SQLException e){
			return false;
		}
		if(count == 1){
			JOptionPane.showMessageDialog(null, "Flunch's, vous souhaite la bienvenue : " + "CHEF ", "flunch's information", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		else{
			JOptionPane.showMessageDialog(null, "ACCES REFUSÉ - Flunch's ",  "Flunch's information", JOptionPane.INFORMATION_MESSAGE);
			Modele.deconnexion();
			System.exit(0);
			return false;
		}
	}
	
	/**
	 * Toutes les fonctions de récupération des plats/desserts/boissons
	 */
	
	/**
	 * Retourne la liste des desserts
	 * @return
	 */
	public static ArrayList<Dessert> getLesDesserts(){
		ArrayList<Dessert> lesDesserts = new ArrayList<Dessert>();
		try {
			int idDessert;
			int prixDessert;
			String nomDessert;
			int stockDessert;
			ps = connexion.prepareStatement("SELECT * FROM dessert");
			rs = ps.executeQuery();

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			while (rs.next()) {
				idDessert = rs.getInt("idDessert");
				prixDessert = rs.getInt("prixDessert");
				nomDessert = rs.getString("nomDessert");
				stockDessert = rs.getInt("stockDessert");

				lesDesserts.add(new Dessert(idDessert, prixDessert, nomDessert, stockDessert));
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return lesDesserts;
	}
	
	/**
	 * Retourne la liste de la totalité des boissons
	 * @return
	 */
	public static ArrayList<Boisson> getLesBoissons(){
		ArrayList<Boisson> lesBoissons = new ArrayList<Boisson>();
		try {
			int idBoisson;
			int prixBoisson;
			String nomBoisson;
			int stockBoisson;
			ps = connexion.prepareStatement("SELECT * FROM v_boissons");
			rs = ps.executeQuery();

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			while (rs.next()) {
				idBoisson = rs.getInt("idBoisson");
				prixBoisson = rs.getInt("prixBoisson");
				nomBoisson = rs.getString("nomBoisson");
				stockBoisson = rs.getInt("stockBoisson");

				lesBoissons.add(new Boisson(idBoisson, prixBoisson, nomBoisson, stockBoisson));
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return lesBoissons;
	}
	
	/**
	 * Retourne la liste de la totalité des boissons soft
	 * @return
	 */
	public static ArrayList<softBoisson> getLesBoissonsSoft(){
		ArrayList<softBoisson> lesBoissonsSoft = new ArrayList<softBoisson>();
		try {
			int idBoisson;
			int prixBoisson;
			String nomBoisson;
			int stockBoisson;
			ps = connexion.prepareStatement("SELECT * FROM soft");
			rs = ps.executeQuery();

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			while (rs.next()) {
				idBoisson = rs.getInt("idSoft");
				prixBoisson = rs.getInt("prixSoft");
				nomBoisson = rs.getString("nomSoft");
				stockBoisson = rs.getInt("stockSoft");

				lesBoissonsSoft.add(new softBoisson(idBoisson, prixBoisson, nomBoisson, stockBoisson));
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return lesBoissonsSoft;
	}
	
	/**
	 * Retourne la liste de la totalité des boissons alcoolisées
	 * @return
	 */
	public static ArrayList<alcoolBoisson> getLesBoissonsAlcoolisees(){
		ArrayList<alcoolBoisson> lesBoissonsAlcoolisees = new ArrayList<alcoolBoisson>();
		try {
			int idBoisson;
			int prixBoisson;
			String nomBoisson;
			int stockBoisson;
			ps = connexion.prepareStatement("SELECT * FROM alcool");
			rs = ps.executeQuery();

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			while (rs.next()) {
				idBoisson = rs.getInt("idAlcool");
				prixBoisson = rs.getInt("prixAlcool");
				nomBoisson = rs.getString("nomAlcool");
				stockBoisson = rs.getInt("stockAlcool");

				lesBoissonsAlcoolisees.add(new alcoolBoisson(idBoisson, prixBoisson, nomBoisson, stockBoisson));
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return lesBoissonsAlcoolisees;
	}
	
	
	
	/**
	 * Retourne la liste des plats
	 * @return
	 */
	public static ArrayList<Plat> getLesPlats(){
		ArrayList<Plat> lesPlats = new ArrayList<Plat>();
		try {
			int idPlat;
			int prixPlat;
			String nomPlat;
			int stockPlat;
			ps = connexion.prepareStatement("SELECT * FROM plat");
			rs = ps.executeQuery();

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			while (rs.next()) {
				idPlat = rs.getInt("idPlat");
				prixPlat = rs.getInt("prixPlat");
				nomPlat = rs.getString("nomPlat");
				stockPlat = rs.getInt("stockPlat");

				lesPlats.add(new Plat(idPlat, prixPlat, nomPlat, stockPlat));
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return lesPlats;
	}
	
	/**
	 * Retourne le nombre de desserts
	 * @return
	 */
	public static int getNbDessert(){
		int nbDessert = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(*) FROM dessert;");

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			rs.next();
			nbDessert = rs.getInt(1); // on peut mettre un AS dans la requête et remplacer le 1 par AS.

			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return nbDessert;
	}
	
	/**
	 * Retourne le nombre de boissons soft
	 * @return
	 */
	public static int getNbBoissonSoft(){
		int nbDessert = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(*) FROM soft;");

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			rs.next();
			nbDessert = rs.getInt(1); // on peut mettre un AS dans la requête et remplacer le 1 par AS.

			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return nbDessert;
	}
	
	/**
	 * Retourne le nombre de boissons soft
	 * @return
	 */
	public static int getNbBoissonAlcool(){
		int nbDessert = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(*) FROM alcool;");

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			rs.next();
			nbDessert = rs.getInt(1); // on peut mettre un AS dans la requête et remplacer le 1 par AS.

			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return nbDessert;
	}
	
	/**
	 * Retourne le nombre de boisson
	 * @return
	 */
	public static int getNbBoisson(){
		int nbBoisson = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(*) FROM v_boissons;");

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			rs.next();
			nbBoisson = rs.getInt(1); // on peut mettre un AS dans la requête et remplacer le 1 par AS.

			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return nbBoisson;
	}
	
	/**
	 * Retourne le nombre de plat
	 * @return
	 */
	public static int getNbPlat(){
		int nbPlat = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(*) FROM plat;");

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			rs.next();
			nbPlat = rs.getInt(1); // on peut mettre un AS dans la requête et remplacer le 1 par AS.

			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return nbPlat;
	}
	
	/**
	 * Retourne le nombre de plat
	 * @return
	 */
	public static int getNbCommandeAchetee(){
		int nbCommandeHistorique = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(*) FROM historique_commande;");

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			rs.next();
			nbCommandeHistorique = rs.getInt(1); // on peut mettre un AS dans la requête et remplacer le 1 par AS.

			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return nbCommandeHistorique;
	}
	
	
	/**
	 * Retourne la liste des commandes déjà faites
	 * @return
	 */
	public static ArrayList<CommandeHistorisee> getLesCommandesHistorisees(){
		ArrayList<CommandeHistorisee> lesCommandesHistorisees = new ArrayList<CommandeHistorisee>();
		try {
			int idCommande;
			int prixCommande;
			String nomPlat;
			String nomDessert;
			String nomBoisson;
			int stockPlat;
			ps = connexion.prepareStatement("SELECT * FROM historique_commande");
			rs = ps.executeQuery();

			/**
			 * Accéder à chacune des lignes du résultat de la requête 
			 * rs.next() = fetch
			 * rs.close() = Permet de libérer la mémoire utilisée et permet de refaire une requête.
			 */
			while (rs.next()) {
				idCommande = rs.getInt("idHistoriqueCommande");
				prixCommande = rs.getInt("prixCommande");
				nomPlat = rs.getString("HistoriquePlat");
				nomDessert = rs.getString("HistoriqueDessert");
				nomBoisson = rs.getString("HistoriqueBoisson");

				lesCommandesHistorisees.add(new CommandeHistorisee(idCommande, prixCommande, nomPlat, nomDessert, nomBoisson));
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return lesCommandesHistorisees;
	}

	/**
	 * Requête permettant l'insertion d'une nouvelle commande
	 * @param unPlat
	 * @param unDessert
	 * @param uneBoisson
	 * @return
	 */
	public static boolean insertionCommande(String unPlat, String unDessert, String uneBoisson){
		String lePlat = unPlat;
		String laBoisson = uneBoisson;
		String leDessert = unDessert;
		try {
			st.executeUpdate("INSERT INTO HISTORIQUE_COMMANDE(prixCommande, HistoriquePlat, HistoriqueDessert, HistoriqueBoisson) VALUES ('15','" + lePlat + "','" + leDessert + "','" + laBoisson + "');");
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant la suppression d'un plat
	 * @param unPlat
	 * @return
	 */
	public static boolean deleteCommande(String unPlat){
		String lePlat = unPlat;
		try {
			st.executeUpdate("DELETE FROM PLAT WHERE nomPlat = '" + unPlat + "';");
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	/**
	 * Requête permettant l'ajout d'un plat
	 * @param unPlat
	 * @return
	 */
	public static boolean addCommande(int unPrixPlat, String unNomPlat, int unStockPlat){
		String lePlat = unNomPlat;
		int leStockPlat = unStockPlat;
		int lePrixPlat = unPrixPlat;
		try {
			st.executeUpdate("INSERT INTO PLAT(prixPlat, nomPlat, stockPlat) VALUES ('" + lePrixPlat + "','" + lePlat + "','" + leStockPlat + "');");
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant la recherche d'un plat
	 * @param unPlat
	 * @return
	 */
	public static boolean searchCommande(String unNomPlat){
		String lePlat = unNomPlat;
		try {
			ps = connexion.prepareStatement("SELECT nomPlat FROM PLAT WHERE nomPlat = '" + lePlat + "' ");
			rs = ps.executeQuery();
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant l'ajout d'un dessert
	 * @param unPlat
	 * @return
	 */
	public static boolean addCommandeDessert(int unPrixDessert, String unNomDessert, int unStockDessert){
		String leDessert = unNomDessert;
		int leStockDessert = unStockDessert;
		int lePrixDessert = unPrixDessert;
		try {
			st.executeUpdate("INSERT INTO DESSERT(prixDessert, nomDessert, stockDessert) VALUES ('" + lePrixDessert + "','" + leDessert + "','" + leStockDessert + "');");
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant la recherche d'un dessert
	 * @param unPlat
	 * @return
	 */
	public static boolean searchCommandeDessert(String unNomDessert){
		String leDessert = unNomDessert;
		try {
			ps = connexion.prepareStatement("SELECT nomDessert FROM DESSERT WHERE nomDessert = '" + leDessert + "' ");
			rs = ps.executeQuery();
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant la suppression d'un dessert
	 * @param unPlat
	 * @return
	 */
	public static boolean deleteCommandeDessert(String unDessert){
		String leDessert = unDessert;
		try {
			st.executeUpdate("DELETE FROM DESSERT WHERE nomDessert = '" + leDessert + "';");
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant l'ajout d'une boisson soft
	 * @param unPlat
	 * @return
	 */
	public static boolean addCommandeBoissonSoft(int unPrixDessert, String unNomDessert, int unStockDessert){
		String leDessert = unNomDessert;
		int leStockDessert = unStockDessert;
		int lePrixDessert = unPrixDessert;
		try {
			st.executeUpdate("INSERT INTO soft(prixSoft, nomSoft, stockSoft) VALUES ('" + lePrixDessert + "','" + leDessert + "','" + leStockDessert + "');");
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant l'ajout du boisson alcoolisée
	 * @param unPlat
	 * @return
	 */
	public static boolean addCommandeBoissonAlcool(int unPrixDessert, String unNomDessert, int unStockDessert){
		String leDessert = unNomDessert;
		int leStockDessert = unStockDessert;
		int lePrixDessert = unPrixDessert;
		try {
			st.executeUpdate("INSERT INTO alcool(prixAlcool, nomAlcool, stockAlcool) VALUES ('" + lePrixDessert + "','" + leDessert + "','" + leStockDessert + "');");
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant la suppression d'une boisson soft
	 * @param unPlat
	 * @return
	 */
	public static boolean deleteCommandeBoissonSoft(String unDessert){
		String leDessert = unDessert;
		try {
			st.executeUpdate("DELETE FROM soft WHERE nomSoft = '" + leDessert + "';");
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant la suppression d'une boisson alcoolisée
	 * @param unPlat
	 * @return
	 */
	public static boolean deleteCommandeBoissonAlcool(String unDessert){
		String leDessert = unDessert;
		try {
			st.executeUpdate("DELETE FROM alcool WHERE nomAlcool = '" + leDessert + "';");
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
	
	/**
	 * Requête permettant la recherche d'une boisson
	 * @param unNomBoisson
	 * @return
	 */
	public static boolean searchCommandeBoisson(String unNomBoisson){
		String laBoisson = unNomBoisson;
		try {
			ps = connexion.prepareStatement("SELECT nomBoisson FROM v_boissons WHERE nomBoisson = '" + laBoisson + "' ");
			rs = ps.executeQuery();
			return true;
		} 
		catch (SQLException erreur) {
			System.out.println("La requête à la base de données a échouée ou Erreur SQL…" + erreur);
		}
		return false;
	}
}

/**
 * @author opalali
 */

public class CommandeHistorisee {

	/**
	 * Attributs privées
	 */
	private int idCommande;
	private int	prixCommande;
	private String nomPlat;
	private String nomDessert;
	private String nomBoisson;

	/**
	 * Méthodes publiques
	 */
	public CommandeHistorisee(){

	}

	/**
	 * @param unIdDessert
	 * @param unPrixDessert
	 * @param unNomDessert
	 * @param unStockDessert
	 */
	public CommandeHistorisee(int unIdCommande, int unPrixCommande, String unNomPlat, String unNomDessert, String unNomBoisson){
		this.idCommande = unIdCommande;
		this.prixCommande = unPrixCommande;
		this.nomPlat = unNomPlat;
		this.nomDessert = unNomDessert;
		this.nomBoisson = unNomBoisson;
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public int getPrixCommande() {
		return this.prixCommande;
	}

	public String getNomDessert() {
		return this.nomDessert;
	}
	public String getNomBoisson() {
		return this.nomBoisson;
	}
	public String getNomPlat() {
		return this.nomPlat;
	}
	
	/**
	 * toString de la classe Dessert
	 */
	public String toString(){
		String chaine = "";
		if(this.idCommande != 0){
			chaine += "\nNuméro Dessert :" + this.idCommande;
		}
		if(this.prixCommande != 0){
			chaine += "\nPrix Dessert :" + this.prixCommande;
		}
		if(this.nomDessert != null){
			chaine += "\nNom Dessert :" + this.nomDessert;
		}
		if(this.nomBoisson != null){
			chaine += "\nStock Dessert :" + this.nomBoisson;
		}
		if(this.nomPlat != null){
			chaine += "\nStock Dessert :" + this.nomPlat;
		}
		return chaine;
	}
}

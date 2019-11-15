/**
 * @author opalali
 */

public class Plat {

	/**
	 * Attributs privées
	 */
	private int idPlat;
	private int	prixPlat ;
	private String nomPlat;
	private int stockPlat;

	/**
	 * Méthodes publiques
	 */
	public Plat(){

	}

	/**
	 * @param unIdDessert
	 * @param unPrixDessert
	 * @param unNomDessert
	 * @param unStockDessert
	 */
	public Plat(int unIdPlat, int unPrixPlat, String unNomPlat, int unStockPlat){
		this.idPlat = unIdPlat;
		this.prixPlat = unPrixPlat;
		this.nomPlat = unNomPlat;
		this.stockPlat = unStockPlat;
	}

	public int getIdPlat() {
		return this.idPlat;
	}

	public int getPrixPlat() {
		return this.prixPlat;
	}

	public String getNomPlat() {
		return this.nomPlat;
	}
	
	public int getStockPlat() {
		return this.stockPlat;
	}
	
	/**
	 * Conversion vers XML
	 * @return
	 */
	public String toXML() {
		return "<Plat>\n"
				+ "\t<Numero>" + this.idPlat + "</Numero>\n"
				+ "\t<Nom>" + this.nomPlat + "</Nom>\n"
				+ "\t<Prix>" + this.prixPlat + "</Prix>\n"
				+ "\t<Stock>" + this.stockPlat + "</Stock>\n"
				+ "</Plat>";
	}
	
	/**
	 * toString de la classe Dessert
	 */
	public String toString(){
		String chaine = "";
		if(this.idPlat != 0){
			chaine += "\nNuméro Dessert :" + this.idPlat;
		}
		if(this.prixPlat != 0){
			chaine += "\nPrix Dessert :" + this.prixPlat;
		}
		if(this.nomPlat != null){
			chaine += "\nNom Dessert :" + this.nomPlat;
		}
		if(this.stockPlat != 0){
			chaine += "\nStock Dessert :" + this.stockPlat;
		}
		return chaine;
	}
}

/**
 * @author opalali
 */

public class Dessert {

	/**
	 * Attributs privées
	 */
	private int idDessert;
	private int	prixDessert ;
	private String nomDessert;
	private int stockDessert;

	/**
	 * Méthodes publiques
	 */
	public Dessert(){

	}

	/**
	 * @param unIdDessert
	 * @param unPrixDessert
	 * @param unNomDessert
	 * @param unStockDessert
	 */
	public Dessert(int unIdDessert, int unPrixDessert, String unNomDessert, int unStockDessert){
		this.idDessert = unIdDessert;
		this.prixDessert = unPrixDessert;
		this.nomDessert = unNomDessert;
		this.stockDessert = unStockDessert;
	}

	public int getIdDessert() {
		return this.idDessert;
	}

	public int getPrixDessert() {
		return this.prixDessert;
	}

	public String getNomDessert() {
		return this.nomDessert;
	}
	
	public int getStockDessert() {
		return this.stockDessert;
	}
	
	/**
	 * Conversion vers XML
	 * @return
	 */
	public String toXML() {
		return "<Dessert>\n"
				+ "\t<Numero>" + this.idDessert + "</Numero>\n"
				+ "\t<Nom>" + this.nomDessert + "</Nom>\n"
				+ "\t<Prix>" + this.prixDessert + "</Prix>\n"
				+ "\t<Stock>" + this.stockDessert + "</Stock>\n"
				+ "</Dessert>";
	}
	
	/**
	 * toString de la classe Dessert
	 */
	public String toString(){
		String chaine = "";
		if(this.idDessert != 0){
			chaine += "\nNuméro Dessert :" + this.idDessert;
		}
		if(this.prixDessert != 0){
			chaine += "\nPrix Dessert :" + this.prixDessert;
		}
		if(this.nomDessert != null){
			chaine += "\nNom Dessert :" + this.nomDessert;
		}
		if(this.stockDessert != 0){
			chaine += "\nStock Dessert :" + this.stockDessert;
		}
		return chaine;
	}
}

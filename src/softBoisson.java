/**
 * @author opalali
 */

public class softBoisson {

	/**
	 * Attributs privées
	 */
	private int idBoisson;
	private int	prixBoisson;
	private String nomBoisson;
	private int stockBoisson;

	/**
	 * Méthodes publiques
	 */
	public softBoisson(){

	}

	/**
	 * 
	 * @param unIdBoisson
	 * @param unPrixBoisson
	 * @param unNomBoisson
	 * @param unStockBoisson
	 */
	public softBoisson(int unIdBoisson, int unPrixBoisson, String unNomBoisson, int unStockBoisson){
		this.idBoisson = unIdBoisson;
		this.prixBoisson = unPrixBoisson;
		this.nomBoisson = unNomBoisson;
		this.stockBoisson = unStockBoisson;
	}

	public int getIdBoisson() {
		return this.idBoisson;
	}

	public int getPrixBoisson() {
		return this.prixBoisson;
	}

	public String getNomBoisson() {
		return this.nomBoisson;
	}
	
	public int getStockBoisson() {
		return this.stockBoisson;
	}
	
	/**
	 * Conversion vers XML
	 * @return
	 */
	public String toXML() {
		return "<Boisson Soft>\n"
				+ "\t<Numero>" + this.idBoisson + "</Numero>\n"
				+ "\t<Nom>" + this.nomBoisson + "</Nom>\n"
				+ "\t<Prix>" + this.prixBoisson + "</Prix>\n"
				+ "\t<Stock>" + this.stockBoisson + "</Stock>\n"
				+ "</Boisson Soft>";
	}
	
	/**
	 * toString de la classe boissons soft
	 */
	public String toString(){
		String chaine = "";
		if(this.idBoisson != 0){
			chaine += "\nNuméro Dessert :" + this.idBoisson;
		}
		if(this.prixBoisson != 0){
			chaine += "\nPrix Dessert :" + this.prixBoisson;
		}
		if(this.nomBoisson != null){
			chaine += "\nNom Dessert :" + this.nomBoisson;
		}
		if(this.stockBoisson != 0){
			chaine += "\nStock Dessert :" + this.stockBoisson;
		}
		return chaine;
	}
}

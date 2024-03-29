/**
 * @author opalali
 */

public class alcoolBoisson {

	/**
	 * Attributs priv�es
	 */
	private int idBoisson;
	private int	prixBoisson;
	private String nomBoisson;
	private int stockBoisson;

	/**
	 * M�thodes publiques
	 */
	public alcoolBoisson(){

	}

	/**
	 * @param unIdDessert
	 * @param unPrixDessert
	 * @param unNomDessert
	 * @param unStockDessert
	 */
	public alcoolBoisson(int unIdBoisson, int unPrixBoisson, String unNomBoisson, int unStockBoisson){
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
		return "<Boisson Alcoolis�e>\n"
				+ "\t<Numero>" + this.idBoisson + "</Numero>\n"
				+ "\t<Nom>" + this.nomBoisson + "</Nom>\n"
				+ "\t<Prix>" + this.prixBoisson + "</Prix>\n"
				+ "\t<Stock>" + this.stockBoisson + "</Stock>\n"
				+ "</Boisson Alcoolis�e>";
	}
	
	/**
	 * toString de la classe Alcool boisson
	 */
	public String toString(){
		String chaine = "";
		if(this.idBoisson != 0){
			chaine += "\nNum�ro Dessert :" + this.idBoisson;
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

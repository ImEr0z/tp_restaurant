import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class Tableau_dessert extends JPanel{

	private JPanel panelLigne1;
	private JLabel titreProduit;
	private JLabel titreNbDessert;
	private JTable tableau;
	private JScrollPane scrollPane;

	public Tableau_dessert(ArrayList<Dessert> lesDesserts) {

		// Instanciation des panels
		this.panelLigne1 = new JPanel();
		this.titreProduit = new JLabel("Affichage des desserts présents chez Flunch's\n");
		this.titreNbDessert = new JLabel("\nNombre de dessert présent : " + Modele.getNbDessert());
		this.setLayout(new GridLayout(3,1,0,0));

		/**
		 * Mise en forme du titre afficher dans la fenêtre
		 */
		Font f = new Font("Sherif", Font.BOLD, 18);
		this.titreProduit.setFont(f);
		this.panelLigne1.add(this.titreProduit);
		this.add(this.panelLigne1);
		
		this.titreNbDessert.setFont(f);
		this.panelLigne1.add(this.titreNbDessert);
		this.add(this.panelLigne1);


		/**
		 * TABLEAU : composé d'une ligne de titres de colonnes (title) et de données (data)
		 */
		int compteur = 0;
		Object[][]data = new Object[lesDesserts.size()][4];
		for(Dessert elt : Modele.getLesDesserts()) {
			data[compteur][0] = elt.getIdDessert();
			data[compteur][1] = elt.getPrixDessert();
			data[compteur][2] = elt.getNomDessert();
			data[compteur][3] = elt.getStockDessert();
			compteur++;
		}

		String [] title = {"idDessert", "prixDessert","nomDessert", "stockDessert"};
		this.tableau = new JTable(data,title);
		this.tableau.setRowHeight(20); //espacement des cellules
		//le tableau doit être obligatoirement ajouté dans un composant JScrollPane
		this.scrollPane = new JScrollPane(this.tableau);
		this.add(this.scrollPane);
	}
}
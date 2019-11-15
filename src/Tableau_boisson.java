import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.event.ActionEvent;

public class Tableau_boisson extends JPanel{

	private JPanel panelLigne1;
	private JLabel titreProduit;
	private JTable tableau;
	private JLabel titreNbBoisson;
	private JScrollPane scrollPane;

	public Tableau_boisson(ArrayList<Boisson> lesBoissons) {

		// Instanciation des panels
		this.panelLigne1 = new JPanel();
		this.titreProduit = new JLabel("Affichage des boissons présents chez Flunch's");
		this.titreNbBoisson = new JLabel("\nNombre de dessert présent : " + Modele.getNbBoisson());
		this.setLayout(new GridLayout(3,1,0,0));

		/**
		 * Mise en forme du titre afficher dans la fenêtre
		 */
		Font f = new Font("Sherif", Font.BOLD, 18);
		this.titreProduit.setFont(f);
		this.panelLigne1.add(this.titreProduit);
		this.add(this.panelLigne1);
		
		this.titreNbBoisson.setFont(f);
		this.panelLigne1.add(this.titreNbBoisson);
		this.add(this.panelLigne1);

		/**
		 * TABLEAU : composé d'une ligne de titres de colonnes (title) et de données (data)
		 */
		int compteur = 0;
		Object[][]data = new Object[lesBoissons.size()][4];
		for(Boisson elt : Modele.getLesBoissons()) {
			data[compteur][0] = elt.getIdBoisson();
			data[compteur][1] = elt.getPrixBoisson();
			data[compteur][2] = elt.getNomBoisson();
			data[compteur][3] = elt.getStockBoisson();
			compteur++;
		}

		String [] title = {"idBoisson", "prixBoisson","nomBoisson", "stockBoisson"};
		this.tableau = new JTable(data,title);
		this.tableau.setRowHeight(20); //espacement des cellules
		//le tableau doit être obligatoirement ajouté dans un composant JScrollPane
		this.scrollPane = new JScrollPane(this.tableau);
		this.add(this.scrollPane);
	}
}
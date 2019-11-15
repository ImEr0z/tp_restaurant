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

public class Tableau_plat extends JPanel{

	private JPanel panelLigne1;
	private JLabel titreProduit;
	private JTable tableau;
	private JLabel titreNbPlat;
	private JScrollPane scrollPane;

	public Tableau_plat(ArrayList<Plat> lesPlats) {

		// Instanciation des panels
		this.panelLigne1 = new JPanel();
		this.titreProduit = new JLabel("Affichage des plats pr�sents chez Flunch's\n");
		this.titreNbPlat = new JLabel("\nNombre de dessert pr�sent : " + Modele.getNbPlat());

		this.setLayout(new GridLayout(3,1,0,0));

		/**
		 * Mise en forme du titre afficher dans la fen�tre
		 */
		Font f = new Font("Sherif", Font.BOLD, 18);
		this.titreProduit.setFont(f);
		this.panelLigne1.add(this.titreProduit);
		this.add(this.panelLigne1);
		
		this.titreNbPlat.setFont(f);
		this.panelLigne1.add(this.titreNbPlat);
		this.add(this.panelLigne1);

		/**
		 * TABLEAU : compos� d'une ligne de titres de colonnes (title) et de donn�es (data)
		 */
		int compteur = 0;
		Object[][]data = new Object[lesPlats.size()][4];
		for(Plat elt : Modele.getLesPlats()) {
			data[compteur][0] = elt.getIdPlat();
			data[compteur][1] = elt.getPrixPlat();
			data[compteur][2] = elt.getNomPlat();
			data[compteur][3] = elt.getStockPlat();
			compteur++;
		}

		String [] title = {"idPlat", "prixPlat","nomPlat", "stockPlat"};
		this.tableau = new JTable(data,title);
		this.tableau.setRowHeight(20); //espacement des cellules
		//le tableau doit �tre obligatoirement ajout� dans un composant JScrollPane
		this.scrollPane = new JScrollPane(this.tableau);
		this.add(this.scrollPane);
	}
}
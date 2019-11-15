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

public class Tableau_historiqueCommande extends JPanel{

	private JPanel panelLigne1;
	private JLabel titreProduit;
	private JTable tableau;
	private JLabel titreNbPlat;
	private JScrollPane scrollPane;

	public Tableau_historiqueCommande(ArrayList<CommandeHistorisee> lesCommandesHistorisees) {

		// Instanciation des panels
		this.panelLigne1 = new JPanel();
		this.titreProduit = new JLabel("Affichage des commandes d�j� faites pr�sentes chez Flunch's");
		this.titreNbPlat = new JLabel("Nombre de commandes achet�es : " + Modele.getNbCommandeAchetee());

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
		Object[][]data = new Object[lesCommandesHistorisees.size()][5];
		for(CommandeHistorisee elt : Modele.getLesCommandesHistorisees()) {
			data[compteur][0] = elt.getIdCommande();
			data[compteur][1] = elt.getPrixCommande();
			data[compteur][2] = elt.getNomPlat();
			data[compteur][3] = elt.getNomDessert();
			data[compteur][4] = elt.getNomBoisson();
			compteur++;
		}

		String [] title = {"IdCommande", "PrixCommande","NomBoisson", "NomDessert","nomPlat"};
		this.tableau = new JTable(data,title);
		this.tableau.setRowHeight(20); //espacement des cellules
		//le tableau doit �tre obligatoirement ajout� dans un composant JScrollPane
		this.scrollPane = new JScrollPane(this.tableau);
		this.add(this.scrollPane);
	}
}
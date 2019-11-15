import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Commande extends JPanel implements ActionListener{

	private JPanel pProduit;
	private JPanel pBoisson;
	private JLabel titreBoisson;
	private JComboBox <String> boisson;
	private JLabel prixBoisson;
	private String nomBoisson;
	private JPanel pPlat;
	private JLabel titrePlat;
	private JComboBox <String> plat;
	private JLabel prixPlat;
	private String nomPlat;
	private JPanel pDessert;
	private JLabel titreDessert;
	private JComboBox <String> dessert;
	private JLabel prixDessert;
	private String nomDessert;
	private JPanel pPrixTotal;
	private float total;
	private JLabel prixTotal;
	private JPanel pBoutonCommande;
	private JButton boutonCommande;
	
	public Commande(){
		
		pProduit = new JPanel();

		/**
		 * Les boissons
		 */
		pBoisson = new JPanel();
		titreBoisson = new JLabel("Boisson :");
		boisson = new JComboBox();
		for(Boisson bo : Modele.getLesBoissons()){
			boisson.addItem(bo.getNomBoisson());
		}
		nomBoisson = (String) boisson.getSelectedItem();
		//prixBoisson = new JLabel("Prix : " + Modele.prixBoisson(nomBoisson) + " €");
		/**
		 * Les plats
		 */
		pPlat = new JPanel();
		titrePlat = new JLabel("Plat :");
		plat= new JComboBox();
		for(Plat leplat : Modele.getLesPlats()){
			plat.addItem(leplat.getNomPlat());
		}
		nomPlat = (String) plat.getSelectedItem();
		//prixPlat = new JLabel("Prix : " + Modele.prixPlat(nomPlat) + " €");
		
		/**
		 * Les desserts
		 */
		pDessert = new JPanel();
		titreDessert = new JLabel("Dessert :");
		dessert = new JComboBox();
		for(Dessert ledessert : Modele.getLesDesserts()){
			dessert.addItem(ledessert.getNomDessert());
		}
		nomDessert = (String) dessert.getSelectedItem();
		//prixDessert = new JLabel("Prix : " + Modele.prixDessert(nomDessert) + " €");

		/**
		 * Le total
		 */
		pPrixTotal = new JPanel();
		//total = Modele.prixBoisson(nomBoisson) + Modele.prixBucket(nomBucket) + Modele.prixDessert(nomDessert);
		//prixTotal = new JLabel("Prix totale est de " + total + " €");
		
		pBoutonCommande = new JPanel();
		boutonCommande = new JButton("Commander");
		
		/**
		 * Ajout et positionnement
		 */
		pBoisson.setLayout(new BorderLayout());
		pBoisson.add(titreBoisson, BorderLayout.NORTH);
		pBoisson.add(boisson, BorderLayout.CENTER);
		//pBoisson.add(prixBoisson, BorderLayout.SOUTH);
		
		pPlat.setLayout(new BorderLayout());
		pPlat.add(titrePlat, BorderLayout.NORTH);
		pPlat.add(plat, BorderLayout.CENTER);
		//pPlat.add(prixPlat, BorderLayout.SOUTH);
		
		pDessert.setLayout(new BorderLayout());
		pDessert.add(titreDessert, BorderLayout.NORTH);
		pDessert.add(dessert, BorderLayout.CENTER);
		//pDessert.add(prixDessert, BorderLayout.SOUTH);
		
		pProduit.add(pBoisson);
		pProduit.add(pPlat);
		pProduit.add(pDessert);
		
		//pPrixTotal.add(prixTotal);
		
		pBoutonCommande.add(boutonCommande);
		boutonCommande.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(pProduit, BorderLayout.NORTH);
		this.add(pPrixTotal, BorderLayout.CENTER);
		this.add(pBoutonCommande, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boutonCommande){
			String sBoisson = boisson.getSelectedItem().toString();
			String sPlat = plat.getSelectedItem().toString();
			String sDessert = dessert.getSelectedItem().toString();
			if(Modele.insertionCommande(sBoisson,sPlat,sDessert)){
				JOptionPane.showMessageDialog(null, "Commande historisée " + "CHEF ", "flunch's information", JOptionPane.INFORMATION_MESSAGE);

			}
			else{
				JOptionPane.showMessageDialog(null, "ERREUR" + "CHEF ", "flunch's information", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

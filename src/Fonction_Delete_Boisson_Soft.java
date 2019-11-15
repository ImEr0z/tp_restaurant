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

public class Fonction_Delete_Boisson_Soft extends JPanel implements ActionListener{

	private JPanel pProduit;
	private JPanel pPlat;
	private JLabel titrePlat;
	private JComboBox <String> plat;
	private JLabel prixPlat;
	private String nomPlat;
	private JPanel pPrixTotal;
	private float total;
	private JLabel prixTotal;
	private JPanel pBoutonCommande;
	private JButton boutonCommande;
	
	public Fonction_Delete_Boisson_Soft(){
		
		pProduit = new JPanel();

		/**
		 * Les plats
		 */
		pPlat = new JPanel();
		titrePlat = new JLabel("Boisson soft à supprimer :");
		plat= new JComboBox();
		for(softBoisson laboisson : Modele.getLesBoissonsSoft()){
			plat.addItem(laboisson.getNomBoisson());
		}
		nomPlat = (String) plat.getSelectedItem();
		//prixPlat = new JLabel("Prix : " + Modele.prixPlat(nomPlat) + " €");
		

		/**
		 * Le total
		 */
		pPrixTotal = new JPanel();
		//total = Modele.prixBoisson(nomBoisson) + Modele.prixBucket(nomBucket) + Modele.prixDessert(nomDessert);
		//prixTotal = new JLabel("Prix totale est de " + total + " €");
		pBoutonCommande = new JPanel();
		boutonCommande = new JButton("Supprimer");
		
		/**
		 * Ajout et positionnement
		 */
		pPlat.setLayout(new BorderLayout());
		pPlat.add(titrePlat, BorderLayout.NORTH);
		pPlat.add(plat, BorderLayout.CENTER);
		//pPlat.add(prixPlat, BorderLayout.SOUTH);

		pProduit.add(pPlat);
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
			String sPlat = plat.getSelectedItem().toString();
			if(Modele.deleteCommandeBoissonSoft(sPlat)){
				JOptionPane.showMessageDialog(null, "La boisson soft a été supprimée avec succès " + "CHEF ", "flunch's information", JOptionPane.INFORMATION_MESSAGE);

			}
			else{
				JOptionPane.showMessageDialog(null, "ERREUR" + "CHEF ", "flunch's information", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

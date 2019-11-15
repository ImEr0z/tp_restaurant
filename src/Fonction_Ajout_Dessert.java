import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class Fonction_Ajout_Dessert extends JPanel implements ActionListener{

	private JPanel pProduit;
	private JPanel pPlat;
	private JLabel titreNom;
	private JLabel titrePrix;
	private JLabel titreStock;
	private JLabel titreProduit;
	private JComboBox <String> plat;
	private JLabel prixPlat;
	private String nomPlat;
	private JPanel pPrixTotal;
	private float total;
	private JLabel prixTotal;
	private JPanel pBoutonCommande;
	private JButton boutonCommande;
	private JTextField jtfPrixPlat;
	private JTextField jtfNomPlat;
	private JTextField jtfStockPlat;
	
	public Fonction_Ajout_Dessert(){
		
		
		pProduit = new JPanel();
		pBoutonCommande = new JPanel();
		pPlat = new JPanel();
		titreNom = new JLabel("Nom du dessert :");
		titrePrix = new JLabel("Prix du dessert :");
		titreStock = new JLabel("Stock disponible :");
		this.jtfPrixPlat = new JTextField();
		this.jtfNomPlat = new JTextField();
		this.jtfStockPlat = new JTextField();
		
		this.jtfPrixPlat.setPreferredSize(new Dimension(150, 20));
		this.jtfNomPlat.setPreferredSize(new Dimension(150, 20));
		this.jtfStockPlat.setPreferredSize(new Dimension(150, 20));
		
		pBoutonCommande = new JPanel();
		boutonCommande = new JButton("Ajouter");
		
		/**
		 * Ajout et positionnement
		 */
		pPlat.add(titrePrix);
		pPlat.add(jtfPrixPlat);
		pPlat.add(titreNom);
		pPlat.add(jtfNomPlat);
		pPlat.add(titreStock);
		pPlat.add(jtfStockPlat);

		pProduit.add(pPlat);
		
		pBoutonCommande.add(boutonCommande);
		boutonCommande.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(pProduit, BorderLayout.CENTER);
		this.add(pBoutonCommande, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boutonCommande){
			String nomPlat = jtfNomPlat.getText();
			int prixPlat = Integer.parseInt(jtfPrixPlat.getText());
			int stockPlat = Integer.parseInt(jtfStockPlat.getText());
			
			if(Modele.addCommandeDessert(prixPlat, nomPlat, stockPlat)){
				JOptionPane.showMessageDialog(null, "Le dessert a été ajouté avec succès " + "CHEF ", "flunch's information", JOptionPane.INFORMATION_MESSAGE);

			}
			else{
				JOptionPane.showMessageDialog(null, "ERREUR" + "CHEF ", "flunch's information", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

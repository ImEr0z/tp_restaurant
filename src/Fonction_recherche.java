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

public class Fonction_recherche extends JPanel implements ActionListener{

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
	
	public Fonction_recherche(){
		
		
		pProduit = new JPanel();
		pBoutonCommande = new JPanel();
		pPlat = new JPanel();
		titreNom = new JLabel("Nom du plat :");
		this.jtfNomPlat = new JTextField();
		
		this.jtfNomPlat.setPreferredSize(new Dimension(150, 20));
		
		pBoutonCommande = new JPanel();
		boutonCommande = new JButton("Rechercher");
		
		/**
		 * Ajout et positionnement
		 */
		pPlat.add(titreNom);
		pPlat.add(jtfNomPlat);

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
			if(Modele.searchCommande(nomPlat)){
				JOptionPane.showMessageDialog(null, "Le plat a été trouvé avec succès " + "CHEF ", "flunch's information", JOptionPane.INFORMATION_MESSAGE);

			}
			else{
				JOptionPane.showMessageDialog(null, "ERREUR" + "CHEF ", "flunch's information", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

/**
 * Classe de connexion du tp restaurant
 * @author opalali
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenetre_connexion extends JFrame implements ActionListener{
	
	private JPanel panelGlobal;
	private JPanel panelMilieu;
	private JPanel panelBas;
	private JPanel panelImage;
	private JTextField jtfNom;
	private JTextField jtfLogin;
	private JButton btnValider;
	private JLabel lblMessage;
	
	public Fenetre_connexion(){
		
		this.setTitle("Fenetre de connexion - Flunch's");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.panelGlobal = new JPanel();
		this.panelMilieu = new JPanel();
		this.panelBas = new JPanel();
		this.panelImage = new JPanel();
		JPanel jpHaut = new JPanel();
		JPanel jpBas= new JPanel();
		JOptionPane jop1 = new JOptionPane();
	
		this.panelGlobal.setLayout(new BorderLayout());
		
		// Instanciation des nombreux param�tres
		this.jtfNom = new JTextField("onur");
		this.jtfLogin = new JTextField("palali");
		JButton btOK = new JButton("Acc�s Flunch's");
		
		// Cr�ation d'un nouvel objet permettant de g�rer la police de caract�re
		Font police = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
		// D�finition de la police de caract�res � utiliser dans le champ de saisie
		this.jtfNom.setFont(police);
		this.jtfLogin.setFont(police);
		// D�finition de la taille du champ de saisie
		this.jtfNom.setPreferredSize(new Dimension(150, 20));
		this.jtfLogin.setPreferredSize(new Dimension(150, 20));
		this.setContentPane(new AfficheImage("P:\\Workspace\\TP_RESTAURANT_JAVA\\flunch.png"));
		// Ajout dans le panel
		jpHaut.add(this.jtfNom);
		jpHaut.add(this.jtfLogin);
		jpBas.add(btOK);
		this.panelMilieu.add(jpHaut);
		this.panelBas.add(jpBas);
		
		btOK.addActionListener(this);
		// Param�tre des positions
		jpHaut.setLayout(new GridLayout(2,1));
		
		// Ajout des panels dans le global
		this.panelGlobal.add(this.panelMilieu, BorderLayout.CENTER);
		this.panelGlobal.add(this.panelBas, BorderLayout.SOUTH);
		
		//ajouter le JPanel au conteneur principal de notre fen�tre
		this.getContentPane().add(this.panelGlobal);
		//Rendre visible la fen�tre
		this.setVisible(true);
	}
	
	public JTextField getJtfLogin() {
		return this.jtfLogin;
	}
	
	/**
	 * Lorsqu'on appuie sur le bouton 'demande d'acc�s'
	 * la v�rification du login, et l'affichage du panel principal
	 * s'ex�cute
	 */
	public void actionPerformed(ActionEvent evenement) {
		String login = jtfNom.getText();
		String mdp = jtfLogin.getText();
		Modele.connexion_utilisateur(login, mdp);
		this.setVisible(false); 
		new Fenetre_principale().setVisible(true);
	}
}
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenetre_principale extends JFrame implements ActionListener{

	//attributs privés
	private JPanel panelGlobal;
	private JPanel panelPrincipal;
	private JPanel panelLigne1;
	private JLabel titreProduit;
	private JTable tableau;
	private JScrollPane scrollPane;
	private JMenuItem plat;
	private JMenuItem dessert;
	private JMenuItem boisson;
	private JMenuItem softBoisson;
	private JMenuItem alcoolBoisson;
	private JMenuItem quitter;
	private JMenuItem commander;
	private JMenuItem searchPlat;
	private JMenuItem ajoutPlat;
	private JMenuItem deletePlat;
	private JMenuItem searchDessert;
	private JMenuItem ajoutDessert;
	private JMenuItem deleteDessert;
	private JMenuItem searchBoisson;
	private JMenuItem ajoutBoissonSoft;
	private JMenuItem ajoutBoissonAlcool;
	private JMenuItem deleteBoissonAlcool;
	private JMenuItem deleteBoissonSoft;
	private JMenuItem commande_historique;



	public Fenetre_principale() {
		Modele.connexion();
		ArrayList<Dessert> lesDesserts;
		JMenuBar menu = new JMenuBar();

		/**
		 * 
		 */
		this.setTitle("Interface de commande - Flunch's");
		this.setContentPane(new AfficheImage("P:\\Workspace\\TP_RESTAURANT_JAVA\\image.jpg"));
		this.setSize(720,420);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.panelPrincipal = new JPanel();

		/**
		 * Création des menus
		 */
		JMenu menuMainPlat = new JMenu("Plat");
		plat = new JMenuItem("Tous les plats");
		ajoutPlat = new JMenuItem("Ajouter un plat");
		deletePlat = new JMenuItem("Supprimer un plat");
		searchPlat = new JMenuItem("Rechercher un plat");
		JMenu menuMainDessert = new JMenu("Dessert");
		ajoutDessert = new JMenuItem("Ajouter un dessert");
		deleteDessert = new JMenuItem("Supprimer un dessert");
		searchDessert = new JMenuItem("Rechercher un dessert");
		dessert = new JMenuItem("Tous les desserts");
		JMenu menuMainBoisson = new JMenu("Boisson");
		softBoisson = new JMenuItem("Les boissons soft");
		alcoolBoisson = new JMenuItem("Les boissons alcoolisées");
		boisson = new JMenuItem("Toutes les boissons");
		ajoutBoissonSoft = new JMenuItem("Ajouter une boisson soft");
		ajoutBoissonAlcool = new JMenuItem("Ajouter une boisson alcoolisée");
		deleteBoissonAlcool = new JMenuItem("Supprimer une boisson Alcoolisée");
		deleteBoissonSoft = new JMenuItem("Supprimer une boisson Soft");
		searchBoisson = new JMenuItem("Rechercher une boisson");
		JMenu menuMainCommande = new JMenu("Commander");
		commander = new JMenuItem("Faire une commande");
		JMenu menuMainCommandeHistorique = new JMenu("Historique");
		commande_historique = new JMenuItem("Consulter les commandes");
		JMenu menuMainQuitter = new JMenu("Quitter");
		quitter = new JMenuItem("Quitter");

		/**
		 * 
		 */
		menuMainPlat.add(plat);
		menuMainPlat.add(ajoutPlat);
		menuMainPlat.add(deletePlat);
		menuMainPlat.add(searchPlat);
		menuMainDessert.add(dessert);
		menuMainDessert.add(ajoutDessert);
		menuMainDessert.add(deleteDessert);
		menuMainDessert.add(searchDessert);
		menuMainBoisson.add(softBoisson);
		menuMainBoisson.add(alcoolBoisson);
		menuMainBoisson.add(boisson);
		menuMainBoisson.add(ajoutBoissonSoft);
		menuMainBoisson.add(ajoutBoissonAlcool);
		menuMainBoisson.add(deleteBoissonAlcool);
		menuMainBoisson.add(deleteBoissonSoft);
		menuMainBoisson.add(searchBoisson);
		menuMainCommande.add(commander);
		menuMainCommandeHistorique.add(commande_historique);
		menuMainQuitter.add(quitter);

		/**
		 * 
		 */
		menu.add(menuMainPlat);
		menu.add(menuMainDessert);
		menu.add(menuMainBoisson);
		menu.add(menuMainCommande);
		menu.add(menuMainCommandeHistorique);
		menu.add(menuMainQuitter);
		
		dessert.addActionListener(this);
		ajoutPlat.addActionListener(this);
		deletePlat.addActionListener(this);
		searchPlat.addActionListener(this);
		softBoisson.addActionListener(this);
		alcoolBoisson.addActionListener(this);
		boisson.addActionListener(this);
		plat.addActionListener(this);
		ajoutDessert.addActionListener(this);
		deleteDessert.addActionListener(this);
		searchDessert.addActionListener(this);
		ajoutBoissonSoft.addActionListener(this);
		ajoutBoissonAlcool.addActionListener(this);
		deleteBoissonAlcool.addActionListener(this);
		deleteBoissonSoft.addActionListener(this);
		searchBoisson.addActionListener(this);
		plat.addActionListener(this);
		
		quitter.addActionListener(this);
		commander.addActionListener(this);
		commande_historique.addActionListener(this);

		this.setJMenuBar(menu);
		this.setVisible(true);
	}

	/**
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dessert){
			setContentPane(new Tableau_dessert(Modele.getLesDesserts()));
			this.revalidate();
		}
		else{
			if(e.getSource() == quitter){
				System.exit(0);
				Modele.deconnexion();
			}
			else{
				if(e.getSource() == boisson){
					setContentPane(new Tableau_boisson(Modele.getLesBoissons()));
					this.revalidate();
				}
				else{
					if(e.getSource() == plat){
						setContentPane(new Tableau_plat(Modele.getLesPlats()));
						this.revalidate();
					}
					else{
						if(e.getSource() == commander){
							setContentPane(new Commande());
							this.revalidate();
						}
						else{
							if(e.getSource() == commande_historique){
								setContentPane(new Tableau_historiqueCommande(Modele.getLesCommandesHistorisees()));
								this.revalidate();
							}
							else{
								if(e.getSource() == ajoutPlat){
									setContentPane(new Fonction_ajout());
									this.revalidate();
								}
								else{
									if(e.getSource() == deletePlat){
										setContentPane(new Fonction_delete());
										this.revalidate();
									}
									else{
										if(e.getSource() == searchPlat){
											setContentPane(new Fonction_recherche());
											this.revalidate();
										}
										else{
											if(e.getSource() == softBoisson){
												setContentPane(new Tableau_softBoisson(Modele.getLesBoissonsSoft()));
												this.revalidate();
											}
											else{
												if(e.getSource() == alcoolBoisson){
													setContentPane(new Tableau_alcoolBoisson(Modele.getLesBoissonsAlcoolisees()));
													this.revalidate();
												}
												else{
													if(e.getSource() == ajoutBoissonSoft){
														setContentPane(new Fonction_Ajouter_Boisson_Soft());
														this.revalidate();
													}
													else{
														if(e.getSource() == ajoutBoissonAlcool){
															setContentPane(new Fonction_Ajouter_Boisson_Alcool());
															this.revalidate();
														}
														else{
															if(e.getSource() == searchBoisson){
																setContentPane(new Fonction_Recherche_Boisson());
																this.revalidate();
															}
															else{
																if(e.getSource() == deleteBoissonAlcool){
																	setContentPane(new Fonction_Delete_Boisson_Alcool());
																	this.revalidate();
																}
																else{
																	if(e.getSource() == ajoutDessert){
																		setContentPane(new Fonction_Ajout_Dessert());
																		this.revalidate();
																	}
																	else{
																		if(e.getSource() == deleteDessert){
																			setContentPane(new Fonction_Delete_Dessert());
																			this.revalidate();
																		}
																		else{
																			if(e.getSource() == searchDessert){
																				setContentPane(new Fonction_Recherche_Dessert());
																				this.revalidate();
																			}
																			else{
																				if(e.getSource() == deleteBoissonSoft){
																					setContentPane(new Fonction_Delete_Boisson_Soft());
																					this.revalidate();
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
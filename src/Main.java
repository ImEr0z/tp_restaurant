/**
 * @author opalali
 * Classe permettant la connexion à la base de donnée via java et JDBC
 */

import java.sql.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Fenetre_connexion uneFenetre = new Fenetre_connexion();
		Modele.connexion();

		/**
		 * Déclaration de modèle
		 * et de la liste des habitants
		 * Connexion à la BDD
		 */
		//ArrayList<Habitant> lesHabitants = Modele.getLesHabitants();

		/**
		 * Affiche le nombre d'habitants dans la BDD
		 */
		//System.out.println("Nombre d'habitants : " + Modele.getNbHabitants());

		/**
		 * Affichage de la liste des habitants grâce au foreach
		 */
		/*
		 for(Habitant habitant : lesHabitants){
			System.out.println(habitant.toString());
		}
		*/

		/**
		 * Déconnexion de la BDD
		 */
		//Modele.deconnexion();
	}
}

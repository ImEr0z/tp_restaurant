/**
 * @author opalali
 * Classe permettant la connexion � la base de donn�e via java et JDBC
 */

import java.sql.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Fenetre_connexion uneFenetre = new Fenetre_connexion();
		Modele.connexion();

		/**
		 * D�claration de mod�le
		 * et de la liste des habitants
		 * Connexion � la BDD
		 */
		//ArrayList<Habitant> lesHabitants = Modele.getLesHabitants();

		/**
		 * Affiche le nombre d'habitants dans la BDD
		 */
		//System.out.println("Nombre d'habitants : " + Modele.getNbHabitants());

		/**
		 * Affichage de la liste des habitants gr�ce au foreach
		 */
		/*
		 for(Habitant habitant : lesHabitants){
			System.out.println(habitant.toString());
		}
		*/

		/**
		 * D�connexion de la BDD
		 */
		//Modele.deconnexion();
	}
}

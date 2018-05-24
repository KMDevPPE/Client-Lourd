package modele;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Particulier;
import controleur.Entreprise;
import controleur.Etat;
import controleur.Salarie;

public class ModeleClients 
{

/*	public static void insertParticulier (Particulier unParti) // bien import le client de controleur
	{
		String requete = "insert into particulier (id_C,datenaiss,nom_c,prenom_c,ville_c,cp_c,rue_c,telephone,mail,mdp values (null, '" + unParti.getNom()+"' , '" + unParti.getAdresse() + "' );";
		
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	} */
	
	public static ArrayList<Client> selectAllClients ()
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "select * from entreprise ;";
		String requete2 =  "select * from particulier ;";
	
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
		
			while (unRes.next()) // tant qu'il y a un resultat
			{ 
				int idclient = unRes.getInt("ID_C");
				String nom = unRes.getString("NOM_C");
				String prenom = unRes.getString("PRENOM_C");
				String rue = unRes.getString("RUE_C");
				String ville = unRes.getString("VILLE_C");
				String cp = unRes.getString("CP_C");
				String tel = unRes.getString("TELEPHONE");
				String mail = unRes.getString("MAIL");
				String mdp = unRes.getString("MDP");
				String raison = unRes.getString("RAISON");
				String domaine = unRes.getString("DOMAINE");
				String siret = unRes.getString("SIRET");
				Entreprise uneEntre = new Entreprise(idclient, nom, prenom, rue, ville, cp, tel, mail, mdp, raison, domaine, siret); // on utilise ce constructeur car on connait l'di du client
				lesClients.add(uneEntre); // ajout d'un client dans l'array list lesClients
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete2);		
		
			while (unRes.next()) // tant qu'il y a un resultat
			{ 
				int idclient = unRes.getInt("ID_C");
				String nom = unRes.getString("NOM_C");
				String prenom = unRes.getString("PRENOM_C");
				String rue = unRes.getString("RUE_C");
				String ville = unRes.getString("VILLE_C");
				String cp = unRes.getString("CP_C");
				String tel = unRes.getString("TELEPHONE");
				String mail = unRes.getString("MAIL");
				String mdp = unRes.getString("MDP");
				String datenaiss = unRes.getString("DATENAISS");
				Particulier unParti = new Particulier(idclient, nom, prenom, rue, ville, cp, tel, mail, mdp, datenaiss); // on utilise ce constructeur car on connait l'di du client
				lesClients.add(unParti); // ajout d'un client dans l'array list lesClients
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete2);
		}
		return lesClients;
	}
	
	/*
	public static void deleteClient (Client unClient)
	{
		String requete = "delete from client where ID_C =" +unClient.getIdclient() +";";
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void updateClient (Client unClient)
	{
		String requete = "update client set mail ='" + unClient.getNom() + "',adresse='" +unClient.getAdresse() + "' where ID_C = " + unClient.getIdclient() +";";
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static Client selectWhere (Client unClient)
	{
		String requete = "select * from client where " + "mail = '" + unClient.getNom() + "' and adresse = '" + unClient.getAdresse()+ "' ; ";
		Client leClient = null ;
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idclient = unRes.getInt("ID_C");
				leClient = new Client(idclient, unClient.getNom(), unClient.getAdresse());
			}			
			unStat.close();
			uneBdd.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leClient;
	}
	*/

}

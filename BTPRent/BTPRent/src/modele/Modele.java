package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


//import controleur.Etat;
import controleur.Salarie;

public class Modele 
{
	public static String VerifConnexion (String login, String mdp)
	{
		String requete = "Select count(*) as nb, droits , ID_S " + " from SALARIE where MAIL = '"+ login + "' and mdp ='" + mdp +"' group by ID_S;" ;
		
		String droits ="";
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int nb = unRes.getInt("nb");
				if(nb != 0) droits = unRes.getString("droits");
			}
			BDD.seDeconnecter();
			unStat.close();
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
		return droits;
	}
	
	/*
	public static void insertClient (Client unClient) // bien import le client de controleur
	{
		String requete = "insert into client (ID_C, ,ADRESSE) values (null, '" + unClient.getNom()+"' , '" + unClient.getAdresse() + "' );";
		
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			BDD.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static ArrayList<Client> selectAllClients ()
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "select ID_C, MAIL, ADRESSE from client ;";
	
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int idclient = unRes.getInt("ID_C");
				String nom = unRes.getString("MAIL");
				String adresse = unRes.getString("adresse");
				Client unClient = new Client(idclient, nom, adresse); // on utilise ce constructeur car on connait l'di du client
				lesClients.add(unClient); // ajout d'un client dans l'array list lesClients
			}
			unStat.close();
			unRes.close();
			BDD.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesClients;
	}
	
	public static void deleteClient (Client unClient)
	{
		String requete = "delete from client where ID_C =" +unClient.getIdclient() +";";
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			BDD.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void updateClient (Client unClient)
	{
		String requete = "update client set mail ='" + unClient.getNom() + "',adresse='" +unClient.getAdresse() + "' where ID_C = " + unClient.getIdclient() +";";
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			BDD.seDeconnecter();
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
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idclient = unRes.getInt("ID_C");
				leClient = new Client(idclient, unClient.getNom(), unClient.getAdresse());
			}			
			unStat.close();
			BDD.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leClient;
	}*/
	
	//---------------------------------------------------------MODELE SALARIE ---------------------------------------------------------
	
	public static void insertSalarie (Salarie unSalarie)  //Ajout d'un salarié avec jdbc en requetant
	{
		String requete = "insert into SALARIE (ID_S, NOM_S, PRENOM_S, mail, mdp, droits) values (null, '" + unSalarie.getNom()+"' , '" + unSalarie.getPrenom()+"' , '" + unSalarie.getMail()+"' , '" + unSalarie.getMdp()+"' , '" + unSalarie.getDroits() + "' );";
		
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			BDD.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static ArrayList<Salarie> selectAllSalarie ()  // selectionne tous les salariés de la BDD
	{
		ArrayList<Salarie> lesSalaries = new ArrayList<Salarie>();
		String requete = "select ID_S, NOM_S, PRENOM_S, MAIL, mdp, droits from SALARIE ;";
	
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int idsalarie = unRes.getInt("ID_S");
				String nom = unRes.getString("NOM_S");
				String prenom = unRes.getString("PRENOM_S");
				String mail = unRes.getString("MAIL");
				String mdp = unRes.getString("MDP");
				String droits = unRes.getString("DROITS");
				Salarie unSalarie = new Salarie(idsalarie, nom, prenom, mail, mdp, droits); 
				lesSalaries.add(unSalarie); 
			}
			unStat.close();
			unRes.close();
			BDD.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesSalaries;
	}
	
	public static void deleteSalarie (Salarie unSalarie) //supprime un salarié par son ID
	{
		String requete = "delete from SALARIE where ID_S =" +unSalarie.getIdsalarie() +";";
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			BDD.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void updateSalarie (Salarie unSalarie) // modifie le ou les champs spécifiques d'un salarié
	{
		String requete = "update SALARIE set nom_s ='" + unSalarie.getNom() + "',prenom_s='" +unSalarie.getPrenom() + "',mail='" +unSalarie.getMail() + "',mdp='" +unSalarie.getMdp() + "',droits='" +unSalarie.getDroits() + "' where ID_S = " + unSalarie.getIdsalarie() +";";
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			BDD.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static Salarie selectWhere (Salarie unSalarie) // affiche un salarié en fonction de son nom et prenom 
	{
		String requete = "select * from SALARIE where " + "nom_s = '" + unSalarie.getNom() + "' and prenom_s = '" + unSalarie.getPrenom()+ "' ; ";
		Salarie leSalarie = null ;
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idsalarie = unRes.getInt("ID_S");
				leSalarie = new Salarie(idsalarie, unSalarie.getNom(), unSalarie.getPrenom(), unSalarie.getMail(), unSalarie.getMdp(), unSalarie.getDroits());
			}			
			unStat.close();
			BDD.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leSalarie;
	}
	
	/*----------------------------------------USELESS MAIS PAS SUPPR-------------------------------------
	public static ArrayList<Etat> selectEtat ()  //vue etat
	{
		ArrayList<Etat> lesEtats = new ArrayList<Etat>();
		String requete = "select * from ETAT ;";
	
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				String nomC = unRes.getString("nomClient");
				String nomT = unRes.getString("nomTechnicien");
				String description = unRes.getString("description");
				String dateInter = unRes.getString("dateInter");
				Etat unEtat = new Etat(nomC, nomT ,description, dateInter); 
				lesEtats.add(unEtat); 
			}
			unStat.close();
			unRes.close();
			BDD.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesEtats;
	} */
	
}

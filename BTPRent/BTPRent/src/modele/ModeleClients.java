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
//------------------INSERT ENTREPRISES --------------------------------------------
	public static void insertEntreprise (Entreprise uneEntreprise) 
	{
		String requete = "insert into entreprise (id_C,nom_c,prenom_c,ville_c,cp_c,rue_c,telephone,mail,mdp, raison, domaine, siret) values (null , '" + uneEntreprise.getNom()+"' , '" + uneEntreprise.getPrenom() + "',"
				+ " '" + uneEntreprise.getVille()+"' , '" + uneEntreprise.getCp()+"' , '" + uneEntreprise.getRue()+"' , '" + uneEntreprise.getTel()+"' , '" + uneEntreprise.getMail()+"' , "
						+ "'" + uneEntreprise.getMdp()+"' , '" + uneEntreprise.getRaison()+"' , '" + uneEntreprise.getDomaine()+"' , '" + uneEntreprise.getSiret()+"');";
		
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
	//------------------INSERT  PARTICULIERS--------------------------------------------	
	public static void insertParticulier (Particulier unParti) 
	{
		String requete = "insert into particulier (id_C,datenaiss,nom_c,prenom_c,ville_c,cp_c,rue_c,telephone,mail,mdp) values (null , '" + unParti.getDatenaiss()+"',"
				+ "'" + unParti.getNom()+"' , '" + unParti.getPrenom() + "', '" + unParti.getVille()+"' , '" + unParti.getCp()+"' , '" + unParti.getRue()+"' "
						+ ", '" + unParti.getTel()+"' , '" + unParti.getMail()+"' , '" + unParti.getMdp()+"');";
		
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
	//-------------SELECT ALL CLIENTS ENTREPRISES ET PARTICULIERS---------------------------------------
	public static ArrayList<Client> selectAllClients ()
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "select * from client ;";
	
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
				Client unClient = new Client(idclient, nom, prenom, rue, ville, cp, tel, mail, mdp); // on utilise ce constructeur car on connait l'di du client
				lesClients.add(unClient); // ajout d'un client dans l'array list lesClients
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesClients;
	}
	
	public static ArrayList<Entreprise> selectAllEntreprises ()
	{
		ArrayList<Entreprise> lesEntreprises = new ArrayList<Entreprise>();
		String requete = "select * from entreprise ;";
	
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
				lesEntreprises.add(uneEntre); // ajout d'un client dans l'array list lesClients
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
				return lesEntreprises;
	}
	
	public static ArrayList<Particulier> selectAllParticuliers ()
	{
		ArrayList<Particulier> lesParticuliers = new ArrayList<Particulier>();
		String requete =  "select * from particulier ;";
	
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
				String datenaiss = unRes.getString("DATENAISS");
				Particulier unParti = new Particulier(idclient, nom, prenom, rue, ville, cp, tel, mail, mdp, datenaiss); // on utilise ce constructeur car on connait l'di du client
				lesParticuliers.add(unParti); // ajout d'un client dans l'array list lesClients
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
				return lesParticuliers;
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
	} */
	 //-------------SELECT WHERE--------------------
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
	
	public static Particulier selectWhereP (Particulier unParticulier)
	{
		String requete = "select * from particulier where " + "nom_c = '" + unParticulier.getNom() + "' and prenom_c = '" + unParticulier.getPrenom()+ "' and mail = '" + unParticulier.getMail()+ "' ; ";
		Particulier leParticulier = null ;
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idclient = unRes.getInt("ID_C");
				leParticulier = new Particulier(idclient, unParticulier.getNom(), unParticulier.getPrenom(), unParticulier.getDatenaiss(),
						unParticulier.getRue(), unParticulier.getVille(), unParticulier.getCp(), unParticulier.getTel(), unParticulier.getMail(),
						unParticulier.getMdp());
			}			
			unStat.close();
			uneBdd.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leParticulier;
	}
	
	public static Entreprise selectWhereE (Entreprise uneEntreprise)
	{
		String requete = "select * from entreprise where " + "nom_c = '" + uneEntreprise.getNom() + "' and prenom_c = '" + uneEntreprise.getPrenom()+ "' and mail = '" + uneEntreprise.getMail()+ "' ; ";
		Entreprise lEntreprise = null ;
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idclient = unRes.getInt("ID_C");
				lEntreprise = new Entreprise(idclient, uneEntreprise.getNom(), uneEntreprise.getPrenom(), uneEntreprise.getRue(), uneEntreprise.getVille(), uneEntreprise.getCp(), 
						uneEntreprise.getTel(), uneEntreprise.getMail(), uneEntreprise.getMdp(), uneEntreprise.getRaison(), uneEntreprise.getDomaine(), uneEntreprise.getSiret());
			}			
			unStat.close();
			uneBdd.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return lEntreprise;
	}
	

}

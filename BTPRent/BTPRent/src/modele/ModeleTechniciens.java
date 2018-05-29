package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Technicien;

public class ModeleTechniciens 
{
	public static void insertTechnicien (Technicien unTechnicien) 
	{
		String requete = "insert into technicien (IDT, NOMT, PRENOMT, mail, mdp) values (null, '" + unTechnicien.getNom()+"' , '" + unTechnicien.getPrenom()+"' ,"
				+ " '" + unTechnicien.getMail()+"' , '" + unTechnicien.getMdp()+"');";
		
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
	
	public static ArrayList<Technicien> selectAllTechnicien ()
	{
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
		String requete = "select IDT, NOMT, PRENOMT, MAIL, mdp from technicien ;";
	
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int idtechnicien = unRes.getInt("IDT");
				String nom = unRes.getString("NOMT");
				String prenom = unRes.getString("PRENOMT");
				String mail = unRes.getString("MAIL");
				String mdp = unRes.getString("mdp");
				Technicien unTechnicien = new Technicien(idtechnicien, nom, prenom, mail, mdp); 
				lesTechniciens.add(unTechnicien); 
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesTechniciens;
	}
	
	public static void deleteTechnicien (Technicien unTechnicien)
	{
		String requete = "delete from technicien where IDT =" +unTechnicien.getIdTechnicien() +";";
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
	
	public static void updateTechnicien (Technicien unTechnicien)
	{
		String requete = "update technicien set nomt ='" + unTechnicien.getNom() + "',prenomt='" +unTechnicien.getPrenom() + "',mail='" +unTechnicien.getMail() + 
				"',mdp='" +unTechnicien.getMdp() + "' WHERE IDT = " + unTechnicien.getIdTechnicien() +";";
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
	
	public static Technicien selectWhere (Technicien unTechnicien)
	{
		String requete = "select * from technicien where " + "nomt = '" + unTechnicien.getNom() + "' and prenomt = '" + unTechnicien.getPrenom()+ "' ; ";
		Technicien leTechnicien = null ;
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idtechnicien = unRes.getInt("IDT");
				leTechnicien = new Technicien(idtechnicien, unTechnicien.getNom(), unTechnicien.getPrenom(), unTechnicien.getMail(), unTechnicien.getMdp());
			}			
			unStat.close();
			uneBdd.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leTechnicien;
	}

}

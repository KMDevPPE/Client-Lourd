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
		String requete = "insert into TECHNICIEN (IDT, NOMT, PRENOMT, mail, mdp) values (null, '" + unTechnicien.getNom()+"' , '" + unTechnicien.getPrenom()+"' ,"
				+ " '" + unTechnicien.getMail()+"' , '" + unTechnicien.getMdp()+"');";
		
		
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
	
	public static ArrayList<Technicien> selectAllTechnicien ()
	{
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
		String requete = "select IDT, NOMT, PRENOMT, MAIL, mdp from TECHNICIEN ;";
	
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int idtechnicien = unRes.getInt("IDT");
				String nom = unRes.getString("NOMT");
				String prenom = unRes.getString("PRENOMT");
				String mail = unRes.getString("MAIL");
				String mdp = unRes.getString("MDP");
				Technicien unTechnicien = new Technicien(idtechnicien, nom, prenom, mail, mdp); 
				lesTechniciens.add(unTechnicien); 
			}
			unStat.close();
			unRes.close();
			BDD.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesTechniciens;
	}
	
	public static void deleteTechnicien (Technicien unTechnicien)
	{
		String requete = "delete from TECHNICIEN where IDT =" +unTechnicien.getIdTechnicien() +";";
		
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
	
	public static void updateTechnicien (Technicien unTechnicien)
	{
		String requete = "update TECHNICIEN set nomt ='" + unTechnicien.getNom() + "',prenomt='" +unTechnicien.getPrenom() + "',mail='" +unTechnicien.getMail() + 
				"',mdp='" +unTechnicien.getMdp() + "' WHERE IDT = " + unTechnicien.getIdTechnicien() +";";
		
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
	
	public static Technicien selectWhere (Technicien unTechnicien)
	{
		String requete = "select * from TECHNICIEN where " + "nomt = '" + unTechnicien.getNom() + "' and prenomt = '" + unTechnicien.getPrenom()+ "' ; ";
		Technicien leTechnicien = null ;
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idtechnicien = unRes.getInt("IDT");
				leTechnicien = new Technicien(idtechnicien, unTechnicien.getNom(), unTechnicien.getPrenom(), unTechnicien.getMail(), unTechnicien.getMdp());
			}			
			unStat.close();
			BDD.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leTechnicien;
	}

}

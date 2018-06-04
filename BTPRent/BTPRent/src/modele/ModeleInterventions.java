package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Materiel;
import controleur.Intervention;
import controleur.Technicien;
import controleur.Intervention;

public class ModeleInterventions
{
	public static ArrayList<Intervention> selectAllIntervention ()
	{
		ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>(); 
		
		String requete = "SELECT i.ID_I, t.NOMT, m.NOM_M, i.Date_debut, i.date_fin FROM INTERVENIR I" + 
				" LEFT JOIN Technicien t ON t.IDT = i.IDT LEFT JOIN Materiel m ON m.ID_M = i.ID_M ;" ;
		
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int IdIntervention = unRes.getInt("i.ID_I");
				String nomTechnicien = unRes.getString("t.NOMT");
				String nomMateriel = unRes.getString("m.NOM_M");
				String datedeb = unRes.getString("i.Date_debut");
				String datefin = unRes.getString("i.Date_fin");
				Intervention uneIntervention = new Intervention(IdIntervention, nomTechnicien, nomMateriel,  datedeb, datefin); 
				lesInterventions.add(uneIntervention); 
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesInterventions;
	}
	
	public static void insertIntervention (Intervention uneIntervention) // Permet l'ajout d'une intervention
	{																	 // Il est préférable d'ajouter une intervention en entrant l'ID du matériel car des matériaux ont le meme nom
		String ReqIdTechnicien = "(select IDT from technicien where NOMT = '"+uneIntervention.getNomTechnicien()+"' )";
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(ReqIdTechnicien);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + ReqIdTechnicien);
		}
		
		
		String requete = "insert into intervenir values (null, "+ReqIdTechnicien+","+uneIntervention.getIdMateriel()+",'"+uneIntervention.getDateDebut()+"','"+uneIntervention.getDateFin()+"') ;"; 
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
	
	public static void updateIntervention (Intervention uneIntervention) 
	{																			  
		String ReqIdTechnicien = "(select IDT from technicien where NOMT = '"+uneIntervention.getNomTechnicien()+"' )";
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(ReqIdTechnicien);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + ReqIdTechnicien);
		}
		
		String requete = "update intervenir set IDT ="+ReqIdTechnicien+", ID_M ="+uneIntervention.getIdMateriel()+", Date_Debut ='"+uneIntervention.getDateDebut()+"', Date_Fin ='"+uneIntervention.getDateFin()+"' where ID_I = "+uneIntervention.getIdIntervention()+";";
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
	
	public static void deleteIntervention (Intervention uneIntervention) //supprime une intervention par son ID
	{
		String requete = "delete from intervenir where ID_I =" +uneIntervention.getIdIntervention() +";";
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
	
	
	public static Intervention selectWhere (Intervention uneIntervention) 
	{
		String ReqNomMateriel = "(select NOM_M FROM Materiel where ID_M = "+uneIntervention.getIdMateriel()+" )";   // cette requete permet d'obtenir le nom du matériel stocker dans la variable ReqNomMateriel Quand on connait l'ID du materiel pour l'afficher correctement dans le tableau après l'insertion d'une intervention 
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");  										  
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(ReqNomMateriel);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + ReqNomMateriel);
		}
		
		String requete = "SELECT  ID_I, t.NOMT, m.NOM_M, i.Date_debut, i.date_fin FROM INTERVENIR I" + 
				" LEFT JOIN Technicien t ON t.IDT = i.IDT LEFT JOIN Materiel m ON m.ID_M = i.ID_M where t.NOMT = '"+uneIntervention.getNomTechnicien()+"' AND m.NOM_M = '"+ReqNomMateriel+"' ;" ;
		Intervention lIntervention = null ;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idIntervention = unRes.getInt("ID_I");
				String nomMateriel = unRes.getString("m.NOM_M");
				lIntervention = new Intervention(idIntervention, uneIntervention.getNomTechnicien(), nomMateriel, uneIntervention.getDateDebut(), uneIntervention.getDateFin());
			}			
			unStat.close();
			uneBdd.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return lIntervention;
	}	
	
	
	
} 



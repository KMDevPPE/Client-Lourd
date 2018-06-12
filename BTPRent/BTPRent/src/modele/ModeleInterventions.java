package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Intervention;


public class ModeleInterventions
{
	public static ArrayList<Intervention> selectAllIntervention ()
	{
		ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>(); 
		
		String requete = "SELECT i.ID_I, t.NOMT, m.NOM_M, i.Date_debut, i.date_fin FROM INTERVENIR i" + 
				" LEFT JOIN TECHNICIEN t ON t.IDT = i.IDT LEFT JOIN MATERIEL m ON m.ID_M = i.ID_M ;" ;
		
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int IdIntervention = unRes.getInt("i.ID_I");
				String nomTechnicien = unRes.getString("t.NOMT");
				String nomMateriel = unRes.getString("m.NOM_M");
				String datedeb = unRes.getString("i.DATE_DEBUT");
				String datefin = unRes.getString("i.DATE_FIN");
				Intervention uneIntervention = new Intervention(IdIntervention, 0, nomTechnicien, nomMateriel,  datedeb, datefin); 
				lesInterventions.add(uneIntervention); 
			}
			unStat.close();
			unRes.close();
			BDD.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesInterventions;
	}
	
	public static void insertIntervention (Intervention uneIntervention) // Permet l'ajout d'une intervention
	{																	 // Il est préférable d'ajouter une intervention en entrant l'ID du matériel car des matériaux ont le meme nom
		String ReqIdTechnicien = "(select IDT from TECHNICIEN where NOMT = '"+uneIntervention.getNomTechnicien()+"' )";
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			unStat.execute(ReqIdTechnicien);
			unStat.close();
			BDD.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + ReqIdTechnicien);
		}
		
		
		String requete = "insert into INTERVENIR values (null, "+ReqIdTechnicien+","+uneIntervention.getIdMateriel()+",'"+uneIntervention.getDateDebut()+"','"+uneIntervention.getDateFin()+"') ;"; 
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
	
	public static void updateIntervention (Intervention uneIntervention) 
	{																			  
		String ReqIdTechnicien = "(select IDT from TECHNICIEN where NOMT = '"+uneIntervention.getNomTechnicien()+"' )";
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			unStat.execute(ReqIdTechnicien);
			unStat.close();
			BDD.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + ReqIdTechnicien);
		}
		
		String requete = "update INTERVENIR set IDT ="+ReqIdTechnicien+", ID_M ="+uneIntervention.getIdMateriel()+", Date_Debut ='"+uneIntervention.getDateDebut()+"', Date_Fin ='"+uneIntervention.getDateFin()+"' where ID_I = "+uneIntervention.getIdIntervention()+";";
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
	
	public static void deleteIntervention (Intervention uneIntervention) //supprime une intervention par son ID
	{
		String requete = "delete from INTERVENIR where ID_I =" +uneIntervention.getIdIntervention() +";";
		
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
	
	
	public static Intervention selectWhere (Intervention uneIntervention) 
	{
		
		String requete = "SELECT  ID_I, t.NOMT, m.NOM_M, i.Date_debut, i.date_fin FROM INTERVENIR I" + 
				" LEFT JOIN TECHNICIEN t ON t.IDT = i.IDT LEFT JOIN MATERIEL m ON m.ID_M = i.ID_M where t.NOMT = '"+uneIntervention.getNomTechnicien()+"' AND m.ID_M = '"+uneIntervention.getNomMateriel()+"' ;" ;
		System.out.println(requete);
		Intervention lIntervention = null ;
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idIntervention = unRes.getInt("ID_I");
				lIntervention = new Intervention(idIntervention, 0, uneIntervention.getNomTechnicien(), unRes.getString("NOM_M"), uneIntervention.getDateDebut(), uneIntervention.getDateFin());
				System.out.println(lIntervention.getNomMateriel());
			}			
			unStat.close();
			BDD.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return lIntervention;
	}	
	
	
	
} 



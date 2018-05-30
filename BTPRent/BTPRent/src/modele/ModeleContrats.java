package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Etat;
import controleur.Salarie;
import controleur.Contrat;

public class ModeleContrats
{
	public static ArrayList<Contrat> selectAllContrat ()
	{
		ArrayList<Contrat> lesContrats = new ArrayList<Contrat>(); 
		
		String requete = "SELECT co.ID_CONT , c.NOM_C, m.NOM_M, s.NOM_S, co.Date_deb, co.date_f FROM CONTRAT CO" + 
				" LEFT JOIN Client c ON c.ID_C = co.ID_C LEFT JOIN Materiel m ON m.ID_M = co.ID_M LEFT JOIN Salarie s ON s.ID_S = co.ID_S;" ;
		
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int idContrat = unRes.getInt("co.ID_CONT");
				String nomClient = unRes.getString("c.NOM_C");
				String nomMateriel = unRes.getString("m.NOM_M");
				String nomSalarie = unRes.getString("s.NOM_S");
				String datedeb = unRes.getString("co.Date_deb");
				String datefin = unRes.getString("co.Date_f");
				Contrat unContrat = new Contrat(idContrat, nomClient, nomMateriel, nomSalarie, datedeb, datefin); 
				lesContrats.add(unContrat); 
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesContrats;
	}
	
	public static void updateSalarieContrat (Contrat unContrat, Salarie unSalarie) // Permet l'ajout ou la modif d'un référent salarié en rentrant le nom dans l'onglet contrat de l'app 
	{																			  
		String ReqIdSalarie = "(select ID_S from salarie where NOM_S = '"+unSalarie.getNom()+"' )";
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(ReqIdSalarie);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + ReqIdSalarie);
		}
		String requete = "update contrat set ID_S ="+ReqIdSalarie+", Date_Deb ='"+unContrat.getDateDebut()+"', Date_F ='"+unContrat.getDateFin()+"' where ID_CONT = "+unContrat.getIdContrat()+";";
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
	
	
	public static Contrat selectWhere (Contrat unContrat) // INUTILE
	{
		String requete = "select co.ID_CONT , c.NOM_C, m.NOM_M, s.NOM_S, co.Date_deb, co.date_f from CONTRAT CO LEFT JOIN(Client c, Materiel m, Salarie s)"
				+ " ON (c.ID_C = co.ID_C AND m.ID_M = co.ID_M AND s.ID_S = co.ID_S)  where " + "c.nom_C = '" + unContrat.getNomClient() + "' and m.NOM_M = '" + unContrat.getNomMateriel() + "' "
						+ "and m.NOM_S = '" + unContrat.getNomSalarie() + "'; ";
		Contrat leContrat = null ;
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idContrat = unRes.getInt("ID_CONT");
				leContrat = new Contrat(idContrat, unContrat.getNomClient(), unContrat.getNomMateriel(), unContrat.getNomSalarie(), unContrat.getDateDebut(), unContrat.getDateFin());
			}			
			unStat.close();
			uneBdd.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leContrat;
	}
	
	
} 

/*-------------------------------------------------OLD CONTRAT AFFICHE JUSTE LES ID--------------------------
public class ModeleContrats
{
	public static ArrayList<Contrat> selectAllContrat ()
	{
		ArrayList<Contrat> lesContrats = new ArrayList<Contrat>(); // "ID Contrat", "Nom du client", "Matériel loué", "Employé référent", "Date de début", "Date de fin"
		String requete = "select ID_CONT, ID_C, ID_M, ID_S, DATE_DEB, DATE_F from contrat ;"; 
		
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int idContrat = unRes.getInt("ID_CONT");
				int idClient = unRes.getInt("ID_C");
				int idMateriel = unRes.getInt("ID_M");
				int idSalarie = unRes.getInt("ID_S");
				String datedeb = unRes.getString("Date_deb");
				String datefin = unRes.getString("Date_f");
				Contrat unContrat = new Contrat(idContrat, idClient, idMateriel, idSalarie, datedeb, datefin); 
				lesContrats.add(unContrat); 
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesContrats;
	}
	
	
	
	public static Contrat selectWhere (Contrat unContrat)
	{
		String requete = "select * from contrat where c.ID_C = '" + unContrat.getIdClient() + "' and ID_M = '" + unContrat.getIdMateriel() + "' "
						+ "and ID_S = '" + unContrat.getIdSalarie() + "'; ";
		Contrat leContrat = null ;
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idContrat = unRes.getInt("ID_CONT");
				leContrat = new Contrat(idContrat, unContrat.getIdClient(), unContrat.getIdMateriel(), unContrat.getIdSalarie(), unContrat.getDateDebut(), unContrat.getDateFin());
			}			
			unStat.close();
			uneBdd.seDeconnecter();
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leContrat;
	}
	
	public static ArrayList<Etat> selectEtat ()  //vue etat
	{
		ArrayList<Etat> lesEtats = new ArrayList<Etat>();
		String requete = "select NOM_C, NOMT, i.DATE_DEBUT, i.DATE_FIN, from INTERVENIR i LEFT JOIN (TECHNICIEN t, MATERIEL m) ON ( t.IDT = i.IDT AND m.ID_M = i.ID_M )"
				+ " AND ;"; 
	
		BDD uneBdd = new BDD("localhost", "intervention", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
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
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesEtats;
	}
} */

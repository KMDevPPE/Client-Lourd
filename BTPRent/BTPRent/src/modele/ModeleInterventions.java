package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Etat;
import controleur.Salarie;

public class ModeleInterventions {

	
	public static ArrayList<Salarie> selectAllSalarie ()
	{
		ArrayList<Salarie> lesSalaries = new ArrayList<Salarie>();
		String requete = "select ID_S, NOM_S, PRENOM_S, MAIL, mdp, droits from salarie ;";
	
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int idsalarie = unRes.getInt("ID_S");
				String nom = unRes.getString("NOM_S");
				String prenom = unRes.getString("PRENOM_S");
				String mail = unRes.getString("MAIL");
				String mdp = unRes.getString("mdp");
				String droits = unRes.getString("droits");
				Salarie unSalarie = new Salarie(idsalarie, nom, prenom, mail, mdp, droits); 
				lesSalaries.add(unSalarie); 
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesSalaries;
	}
	
	
	
	public static Salarie selectWhere (Salarie unSalarie)
	{
		String requete = "select * from salarie where " + "nom_s = '" + unSalarie.getNom() + "' and prenom_s = '" + unSalarie.getPrenom()+ "' ; ";
		Salarie leSalarie = null ;
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idsalarie = unRes.getInt("ID_S");
				leSalarie = new Salarie(idsalarie, unSalarie.getNom(), unSalarie.getPrenom(), unSalarie.getMail(), unSalarie.getMdp(), unSalarie.getDroits());
			}			
			unStat.close();
			uneBdd.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leSalarie;
	}
	
	public static ArrayList<Etat> selectEtat ()  //vue etat
	{
		ArrayList<Etat> lesEtats = new ArrayList<Etat>();
		String requete = "select NOM_C, NOMT, i.DATE_DEBUT, i.DATE_FIN, from INTERVENIR i LEFT JOIN (TECHNICIEN t, MATERIEL m) ON ( t.IDT = i.IDT AND m.ID_M = i.ID_M )"
				+ " AND ;"; /* SELECT * FROM t1 LEFT JOIN (t2, t3, t4)
                 ON (t2.a = t1.a AND t3.b = t1.b AND t4.c = t1.c) */
	
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
}

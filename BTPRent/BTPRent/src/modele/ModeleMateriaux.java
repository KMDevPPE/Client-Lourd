package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Etat;
import controleur.Materiel;

public class ModeleMateriaux extends Modele
{
	public static void insertMateriel (Materiel unMateriel) 
	{
		String requete = "insert into materiel (ID_M, ID_LOCALISATION, ID_TYPE, ID_ETAT, NOM_M) values (null, '" + unMateriel.getIdLocalisation()+"' , '" + unMateriel.getIdType()+"' , '" + unMateriel.getIdEtat()+"' , '" + unMateriel.getNom() + "' );";
		
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
	
	public static ArrayList<Materiel> selectAllMateriel ()
	{
		ArrayList<Materiel> lesMateriaux = new ArrayList<Materiel>();
		String requete = "select m.id_m, m.nom_M, m.prix_m, t.libelle, e.nom_etat, l.lieux, l.cp, l.rue, l.date_deb, l.date_fin" +
				" from materiel m , type_materiel t , localisation l , etat e" +
				" where m.idlocalisation = l.idlocalisation " +
				" and m.idtype = t.idtype" +
				" and m.idetat = e.idetat ;";
	
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int idmateriel = unRes.getInt("ID_M");
				String nom = unRes.getString("NOM_M");
				float prix = unRes.getFloat("prix_m");
				String libelle = unRes.getString("libelle");
				String nomEtat = unRes.getString("nom_etat");
				String lieu = unRes.getString("lieux");
				String cp = unRes.getString("cp");
				String rue = unRes.getString("rue");
				String dateDeb = unRes.getString("date_deb");
				String dateFin = unRes.getString("date_fin");
				
				Materiel unMateriel = new Materiel(idmateriel, prix, nom, lieu, cp, rue, dateDeb, dateFin, nomEtat, libelle); 
				lesMateriaux.add(unMateriel); 
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesMateriaux;
	}
	
	public static void deleteMateriel (Materiel unMateriel)
	{
		String requete = "delete from materiel where ID_M =" +unMateriel.getIdMateriel() +";";
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
	
	public static void updateMateriel (Materiel unMateriel)
	{
		String requete = "update materiel set ID_LOCALALISATION=" +unMateriel.getIdLocalisation() + ",ID_TYPE=" +unMateriel.getIdType() + ",ID_ETAT=" +unMateriel.getIdEtat() + "',nom_m ='" + unMateriel.getNom() + "'' where ID_M = " + unMateriel.getIdMateriel() +" ;";
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
	
	public static Materiel selectWhere (Materiel unMateriel)
	{
		String requete = "select * from materiel where " + "nom_m = '" + unMateriel.getNom() + "'; ";
		Materiel leMateriel = null ;
		BDD uneBdd = new BDD("localhost", "BTPRent", "root", "");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idmateriel = unRes.getInt("ID_M");
				leMateriel = new Materiel(idmateriel,unMateriel.getPrix(),unMateriel.getNom(), unMateriel.getLieu(), unMateriel.getCp(), unMateriel.getRue(), unMateriel.getDateDeb(), unMateriel.getDateFin(), unMateriel.getNomEtat(), unMateriel.getLibelle()); 
			}			
			unStat.close();
			uneBdd.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leMateriel;
	}
	
	//----------------------------------------USELESS MAIS PAS SUPPR-------------------------------------
	public static ArrayList<Etat> selectEtat ()  //vue etat
	{
		ArrayList<Etat> lesEtats = new ArrayList<Etat>();
		String requete = "select * from etat ;";
	
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

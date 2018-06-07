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
		String requete = "call PInsMat ('"+unMateriel.getNom()+"',"+unMateriel.getPrix()+",'"+unMateriel.getLieu()+"','"+unMateriel.getCp()+"','"+unMateriel.getRue()+"','"+unMateriel.getImage()+"',"+unMateriel.getStock()+",'"+unMateriel.getNomType()+"','"+unMateriel.getNomEtat()+"');";
		
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
	
	public static ArrayList<Materiel> selectAllMateriel ()
	{
		ArrayList<Materiel> lesMateriaux = new ArrayList<Materiel>();
		/*String requete = "select m.id_m, m.nom_M, m.prix_m, m.image_m, m.stock_m, t.libelle, e.nom_etat, l.lieux, l.cp, l.rue_c" +
				" from materiel m , type_materiel t , localisation l , etat e" +
				" where m.id_localisation = l.id_localisation " +
				" and m.id_type = t.id_type" +
				" and m.id_etat = e.id_etat ;"; */
		String requete = "select m.id_m, m.nom_M, m.prix_m, m.image_m, m.stock_m, t.libelle, e.nom_etat, l.lieux, l.cp, l.rue_c " +
				" from MATERIEL m LEFT JOIN TYPE_MATERIEL t ON m.id_type = t.id_type "
				+ " LEFT JOIN LOCALISATION l ON m.id_localisation = l.id_localisation "
				+ " LEFT JOIN ETAT e ON m.id_etat = e.id_etat ;"; 
	// select m.id_m, m.nom_M, m.prix_m, m.image_m, m.stock_m, t.libelle, e.nom_etat, l.lieux, l.cp, l.rue_c from materiel m LEFT JOIN type_materiel t ON m.id_type = t.id_type  LEFT JOIN localisation l ON m.id_localisation = l.id_localisation LEFT JOIN etat e ON m.id_etat = e.id_etat ;	
	
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);		
			
			while (unRes.next()) // tant qu'il y a un resultat
			{
				int idmateriel = unRes.getInt("m.ID_M");
				String nom = unRes.getString("m.NOM_M");
				float prix = unRes.getFloat("m.prix_m");
				int stock = unRes.getInt("m.stock_m");
				String image = unRes.getString("m.image_m");
				String nomType = unRes.getString("t.libelle");
				String nomEtat = unRes.getString("nom_etat");
				String lieu = unRes.getString("l.lieux");
				String cp = unRes.getString("l.cp");
				String rue = unRes.getString("l.rue_c");
				
				Materiel unMateriel = new Materiel(idmateriel, prix, nom, lieu, cp, rue, stock, image, nomEtat, nomType); 
				lesMateriaux.add(unMateriel); 
			}
			unStat.close();
			unRes.close();
			BDD.seDeconnecter();
		}		
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesMateriaux;
	}
	
	
	public static void deleteMateriel (Materiel unMateriel)
	{
		String requete = "delete from MATERIEL where ID_M =" +unMateriel.getIdMateriel() +";";
		
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
	
	public static void updateMateriel (Materiel unMateriel)
	{
		
		String requete = "update MATERIEL set stock_ m ="+unMateriel.getStock()+", image_m='"+unMateriel.getImage()+"' ,nom_m ='"+unMateriel.getNom() +"' , prix_m ="+unMateriel.getPrix()+"  where ID_M = " + unMateriel.getIdMateriel() +" ;";
		
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
	
	public static Materiel selectWhere (Materiel unMateriel)
	{
		String requete = "select * from MATERIEL M LEFT JOIN LOCALISATION l ON l.ID_LOCALISATION = m.ID_LOCALISATION where " + "M.nom_m = '" + unMateriel.getNom() + "' and M.stock_m = '"+unMateriel.getStock()+"' and l.lieux = '"+unMateriel.getLieu()+"'; ";
		Materiel leMateriel = null ;
		
		try
		{
			BDD.seConnecter();
			Statement unStat = BDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idmateriel = unRes.getInt("ID_M");
				leMateriel = new Materiel(idmateriel,unMateriel.getPrix(),unMateriel.getNom(), unMateriel.getLieu(), unMateriel.getCp(), unMateriel.getRue(), unMateriel.getStock(), unMateriel.getImage(), unMateriel.getNomEtat(), unMateriel.getNomType()); 
			}			
			unStat.close();
			BDD.seDeconnecter();;
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}
	
		return leMateriel;
	}
	
}

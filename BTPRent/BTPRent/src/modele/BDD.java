package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD 
{
	private static String serveur = "192.168.8.228", bdd ="BTPRent", user="yanis", mdp="yanis";
	private static Connection maConnexion =null;
	
	private static BDD uneBDD ;
	
	 
	
	public static void chargerPilote ()
	{
		//verification de la presence du pilote JDBC
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException exp)
		{
			System.out.println("Absence du pilote JDBC");
		}
	}
	public static  void seConnecter ()
	{
		//methode de connexion au serveur et la bdd
		String url = "jdbc:mysql://" + serveur+"/"+bdd;
		try
		{
			if (maConnexion ==null) {
				maConnexion = DriverManager.getConnection(url, user, mdp);
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur de connexion a : "+ url);
		}
	}
	public  static void seDeconnecter ()
	{
		// methode de deconnexion de la BDD
		try{
				if (maConnexion != null)
			{
				maConnexion.close();
				maConnexion = null;
			}
		}catch (SQLException exp)
		{
			System.out.println("Erreur de fermeture de la connexion");
		}		
	}
	public static  Connection getMaConnexion ()
	{
		// getter sur la variable connexion
		return maConnexion;
	}

}

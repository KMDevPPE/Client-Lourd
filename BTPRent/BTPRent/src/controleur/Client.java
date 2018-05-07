package controleur;

public class Client {
	
	private int idclient;
	private String nom, adresse;
	
	public Client ()
	{
		this.idclient = 0;
		this.nom = "";
		this.adresse = "";
	}
	
	public Client (int idclient, String nom, String adresse)
	{
		this.idclient = idclient;
		this.nom = nom;
		this.adresse = adresse;
	}
	
	public Client (String nom, String adresse)
	{
		this.idclient = 0;
		this.nom = nom;
		this.adresse = adresse;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	

}

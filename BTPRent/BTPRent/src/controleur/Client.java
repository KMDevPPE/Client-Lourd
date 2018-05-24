package controleur;

public class Client {
	// ID Client", "Nom", "Prenom", "Date Naiss", "Raison", "Domaine", 
	//"Siret", "Rue", "Ville", "Code Postal", "Telephone", "Email"
	private int idclient;
	protected String nom, prenom, rue, ville, cp, tel, mail, mdp ;
	private String adresse;
	
	public Client ()
	{
		this.idclient = 0;
		this.nom = "";
		this.prenom = "";
		this.ville = "";
		this.cp = "";
		this.rue = "";
		this.tel = "";
		this.mail = "";
		this.mdp = "";
	}
	
	public Client (int idc, String nom, String prenom) // a suppr
	{
		this.idclient = idc;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Client (int idclient, String nom, String prenom, String rue, String ville, String cp, String tel, String mail, String mdp)
	{
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.cp = cp;
		this.rue = rue;
		this.tel = tel;
		this.mail = mail;
		this.mdp = mdp;
	}
	
	public Client (String nom, String prenom, String rue, String ville, String cp, String tel, String mail, String mdp)
	{
		this.idclient = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.cp = cp;
		this.rue = rue;
		this.tel = tel;
		this.mail = mail;
		this.mdp = mdp;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	
	

}

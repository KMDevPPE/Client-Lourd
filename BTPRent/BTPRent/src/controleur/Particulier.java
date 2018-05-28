package controleur;

public class Particulier extends Client
{
	private String  datenaiss;
	
	public Particulier()
	{
		super();
		this.datenaiss = "";
	}
	
	public Particulier(int idclient, String nom, String prenom, String rue, String ville, String cp, String tel, String mail, String mdp, 
			String datenaiss)
	{
		super (idclient, nom, prenom, rue, ville, cp, tel, mail, mdp);
		this.datenaiss = datenaiss;
		
	}
	
	public Particulier(String nom, String prenom, String rue, String ville, String cp, String tel, String mail, String mdp, String datenaiss)
	{
		super (nom, prenom, rue, ville, cp, tel, mail, mdp);
		this.datenaiss = datenaiss;
		
	}

	public Particulier(int idclient, String nom, String prenom, String mail) { 
		super(idclient, nom, prenom, mail);
	}

	public String getDatenaiss() {
		return datenaiss;
	}

	public void setDatenaiss(String datenaiss) {
		this.datenaiss = datenaiss;
	}
	
	

}

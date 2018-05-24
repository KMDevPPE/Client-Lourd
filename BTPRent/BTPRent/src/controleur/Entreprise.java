package controleur;

public class Entreprise extends Client
{
	private String raison, domaine, siret;
	
	public Entreprise()
	{
		super();
		this.raison = "";
		this.domaine= "";
		this.siret = "";
	}
	
	public Entreprise(int idclient, String nom, String prenom, String rue, String ville, String cp, String tel, String mail, String mdp, 
			String raison, String domaine, String siret)
	{
		super (idclient, nom, prenom, rue, ville, cp, tel, mail, mdp);
		this.raison = raison;
		this.domaine= domaine;
		this.siret = siret;
		
	}
	
	public Entreprise(String nom, String prenom, String rue, String ville, String cp, String tel, String mail, String mdp, 
			String raison, String domaine, String siret)
	{
		super (nom, prenom, rue, ville, cp, tel, mail, mdp);
		this.raison = raison;
		this.domaine= domaine;
		this.siret = siret;
		
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	
}

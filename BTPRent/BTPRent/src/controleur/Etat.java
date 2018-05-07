package controleur;

public class Etat {
	
	private String nomC, nomT, dateInter, description;
	
	public Etat (String nomC, String nomT, String dateInter, String description)
	{
		this.nomC = nomC;
		this.nomT = nomT;
		this.dateInter = dateInter;
		this.description = description;
	}

	public String getNomC() {
		return nomC;
	}

	public void setNomC(String nomC) {
		this.nomC = nomC;
	}

	public String getNomT() {
		return nomT;
	}

	public void setNomT(String nomT) {
		this.nomT = nomT;
	}

	public String getDateInter() {
		return dateInter;
	}

	public void setDateInter(String dateInter) {
		this.dateInter = dateInter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

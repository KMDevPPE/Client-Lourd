package controleur;

public class Intervention 
{
	private int IdIntervention, IdMateriel;
	private String nomTechnicien, nomMateriel, dateDebut, dateFin;
	
	public Intervention ()
	{
		IdIntervention = 0;
		IdMateriel = 0;
		nomTechnicien = "";
		nomMateriel = "";
		dateDebut = "";
		dateFin = "";
	}
	
	public Intervention (int IdM, String nomT, String dateD, String dateF)
	{
		IdIntervention = 0;
		IdMateriel = IdM;
		nomTechnicien = nomT;
		dateDebut = dateD;
		dateFin = dateF;
	}
	public Intervention (int IdInter, int IdM, String nomT, String dateD, String dateF)
	{
		IdIntervention = IdInter;
		IdMateriel = IdM;
		nomTechnicien = nomT;
		dateDebut = dateD;
		dateFin = dateF;
	}
	
	public Intervention (int IdInter, String nomT, String nomM, String dateD, String dateF)
	{
		IdIntervention = IdInter;
		nomTechnicien = nomT;
		nomMateriel = nomM;
		dateDebut = dateD;
		dateFin = dateF;
	}
	
	public int getIdIntervention() {
		return IdIntervention;
	}

	public void setIdIntervention(int idIntervention) {
		IdIntervention = idIntervention;
	}
	
	

	public int getIdMateriel() {
		return IdMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		IdMateriel = idMateriel;
	}

	public String getNomTechnicien() {
		return nomTechnicien;
	}

	public void setNomTechnicien(String nomTechnicien) {
		this.nomTechnicien = nomTechnicien;
	}

	public String getNomMateriel() {
		return nomMateriel;
	}

	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	

}

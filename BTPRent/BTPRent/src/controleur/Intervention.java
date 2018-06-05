package controleur;

public class Intervention 
{
	private int IdIntervention, IdMateriel;
	private String nomTechnicien, nomMateriel, dateDebut, dateFin;
	
	public Intervention ()
	{
		this.IdIntervention = 0;
		this.IdMateriel = 0;
		this.nomTechnicien = "";
		this.nomMateriel = "";
		this.dateDebut = "";
		this.dateFin = "";
	}
	
	public Intervention (String nomM, String nomT, String dateD, String dateF)
	{
		this.IdIntervention = 0;
		this.IdMateriel = 0;
		this.nomMateriel = nomM;
		this.nomTechnicien = nomT;
		this.dateDebut = dateD;
		this.dateFin = dateF;
	}
	
	public Intervention (int IdM, String nomT, String dateD, String dateF)
	{
		this.IdIntervention = 0;
		this.IdMateriel = IdM;
		this.nomTechnicien = nomT;
		this.dateDebut = dateD;
		this.dateFin = dateF;
	}
	public Intervention (int IdInter, int IdM, String nomT, String dateD, String dateF)
	{
		this.IdIntervention = IdInter;
		this.IdMateriel = IdM;
		this.nomTechnicien = nomT;
		this.dateDebut = dateD;
		this.dateFin = dateF;
	}
	
	public Intervention (int IdM, String nomT, String nomM, String dateD, String dateF)
	{
		this.IdIntervention = 0;
		this.IdMateriel = IdM;
		this.nomTechnicien = nomT;
		this.nomMateriel = nomM;
		this.dateDebut = dateD;
		this.dateFin = dateF;
	}
	
	public Intervention (int IdInter, int IdM, String nomT, String nomM, String dateD, String dateF)
	{
		this.IdIntervention = IdInter;
		this.IdMateriel = IdM;
		this.nomTechnicien = nomT;
		this.nomMateriel = nomM;
		this.dateDebut = dateD;
		this.dateFin = dateF;
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

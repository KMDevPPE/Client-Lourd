package controleur;

public class Materiel { 
	
		
		private int idMateriel, idLocalisation , idType, idEtat;
		private String nom;
		private float prix;
		// variables localisation
		String lieu, cp, rue, dateDeb, dateFin;
		//variables etat
		String nomEtat;
		//variables type
		String libelle;
		
		public Materiel ()
		{
			this.idMateriel = 0;
			this.idLocalisation = 0;
			this.idType = 0;
			this.idEtat = 0;
			this.prix = 0;
			this.nom = "";
			this.lieu = "";
			this.cp = "";
			this.rue = "";
			this.dateDeb = "";
			this.dateFin = "";
			this.nomEtat = "";
			this.libelle = "";
			
		}
		
		public Materiel ( int idLocalisation, int idType, int idEtat, float prix, String nom,
				String lieu, String cp, String rue, String dateDeb, String dateFin, String nomEtat, String libelle)
		{
			this.idMateriel = 0;			
			this.idLocalisation = idLocalisation;
			this.idType = idType;
			this.idEtat = idEtat;
			this.prix = prix;
			this.nom = nom;
			this.lieu = lieu;
			this.cp = cp;
			this.rue = rue;
			this.dateDeb = dateDeb;
			this.dateFin = dateFin;
			this.nomEtat = nomEtat;
			this.libelle = libelle;
			
		}
		
		public Materiel (int idMateriel, float prix, String nom, String lieu, String cp, String rue, String dateDeb, String dateFin, String nomEtat, String libelle)
		{
			this.idMateriel = idMateriel;			
			this.idLocalisation = 0;
			this.idType = 0;
			this.idEtat = 0;
			this.prix = prix;
			this.nom = nom;
			this.lieu = lieu;
			this.cp = cp;
			this.rue = rue;
			this.dateDeb = dateDeb;
			this.dateFin = dateFin;
			this.nomEtat = nomEtat;
			this.libelle = libelle;
		}
		
		public Materiel (float prix, String nom, String lieu, String cp, String rue, String dateDeb, String dateFin, String nomEtat, String libelle)
		{
			this.idMateriel = 0;			
			this.idLocalisation = 0;
			this.idType = 0;
			this.idEtat = 0;
			this.prix = prix;
			this.nom = nom;
			this.lieu = lieu;
			this.cp = cp;
			this.rue = rue;
			this.dateDeb = dateDeb;
			this.dateFin = dateFin;
			this.nomEtat = nomEtat;
			this.libelle = libelle;
		}
		
		public Materiel (String nom)
		{
			this.idMateriel = 0;
			this.idLocalisation = 0;
			this.idType = 0;
			this.idEtat = 0;
			this.prix = 0;
			this.nom = nom;
			this.lieu = "" ;
			this.cp = "";
			this.rue = "";
			this.dateDeb = "";
			this.dateFin = "";
			this.nomEtat = "";
			this.libelle = "";
			
		}

		public int getIdMateriel() {
			return idMateriel;
		}

		public void setIdMateriel(int idMateriel) {
			this.idMateriel = idMateriel;
		}

		public int getIdLocalisation() {
			return idLocalisation;
		}

		public void setIdLocalisation(int idLocalisation) {
			this.idLocalisation = idLocalisation;
		}

		public int getIdType() {
			return idType;
		}

		public void setIdType(int idType) {
			this.idType = idType;
		}

		public int getIdEtat() {
			return idEtat;
		}

		public void setIdEtat(int idEtat) {
			this.idEtat = idEtat;
		}
		
		public float getPrix() {
			return prix;
		}

		public void setPrix(float prix) {
			this.prix = prix;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getLieu() {
			return lieu;
		}

		public void setLieu(String lieu) {
			this.lieu = lieu;
		}

		public String getCp() {
			return cp;
		}

		public void setCp(String cp) {
			this.cp = cp;
		}

		public String getRue() {
			return rue;
		}

		public void setRue(String rue) {
			this.rue = rue;
		}

		public String getDateDeb() {
			return dateDeb;
		}

		public void setDateDeb(String dateDeb) {
			this.dateDeb = dateDeb;
		}

		public String getDateFin() {
			return dateFin;
		}

		public void setDateFin(String dateFin) {
			this.dateFin = dateFin;
		}

		public String getNomEtat() {
			return nomEtat;
		}

		public void setNomEtat(String nomEtat) {
			this.nomEtat = nomEtat;
		}

		public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		
		
		

}

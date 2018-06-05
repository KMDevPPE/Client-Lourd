package controleur;

public class Materiel { 
	
		
		private int idMateriel, idLocalisation , idType, idEtat, stock;
		private String nom;
		private float prix;
		// variables localisation
		String lieu, cp, rue, image;
		//variable etat
		String nomEtat;
		//variable type
		String nomType;
		
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
			this.stock = 0;
			this.image = "";
			this.nomEtat = "";
			this.nomType = "";
			
		}
		
		public Materiel ( int idLocalisation, int idType, int idEtat, float prix, String nom,
				String lieu, String cp, String rue, int stock, String image, String nomEtat, String nomType)
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
			this.stock = stock;
			this.image = image;
			this.nomEtat = nomEtat;
			this.nomType = nomType;
			
		}
		
		public Materiel (int idMateriel, float prix, String nom, String lieu, String cp, String rue, int stock, String image, String nomEtat, String nomType)
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
			this.stock = stock;
			this.image = image;
			this.nomEtat = nomEtat;
			this.nomType = nomType;
		}
		
		public Materiel (float prix, String nom, String lieu, String cp, String rue, int stock, String image, String nomEtat, String nomType)
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
			this.stock = stock;
			this.image = image;
			this.nomEtat = nomEtat;
			this.nomType = nomType;
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
			this.stock = 0;
			this.image = "";
			this.nomEtat = "";
			this.nomType = "";
			
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

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getNomEtat() {
			return nomEtat;
		}

		public void setNomEtat(String nomEtat) {
			this.nomEtat = nomEtat;
		}

		public String getNomType() {
			return nomType;
		}

		public void setNomType(String nomType) {
			this.nomType = nomType;
		}

		
		
		

}

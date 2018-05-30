package controleur;

public class Salarie { 
	
		
		private int idsalarie;
		private String nom, prenom, mail, mdp, droits;
		
		public Salarie ()
		{
			this.idsalarie = 0;
			this.nom = "";
			this.prenom = "";
			this.mail = "";
			this.mdp = "";
			this.droits = "";	
			
		}
		
		public Salarie (String nom)
		{
			this.idsalarie = 0;
			this.nom = nom;
			this.prenom = "";
			this.mail = "";
			this.mdp = "";
			this.droits = "";	
			
		}
		
		public Salarie (int idsalarie, String nom, String prenom, String mail, String mdp, String droits)
		{
			this.idsalarie = idsalarie;
			this.nom = nom;
			this.prenom = prenom;
			this.mail = mail;
			this.mdp = mdp;
			this.droits = droits;
		}
		
		public Salarie (String nom, String prenom, String mail, String mdp, String droits)
		{
			this.idsalarie = 0;
			this.nom = nom;
			this.prenom = prenom;
			this.mail = mail;
			this.mdp = mdp;
			this.droits = droits;
		}

		public int getIdsalarie() {
			return idsalarie;
		}

		public void setIdsalarie(int idsalarie) {
			this.idsalarie = idsalarie;
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

		public String getDroits() {
			return droits;
		}

		public void setDroits(String droits) {
			this.droits = droits;
		}
		
		

}

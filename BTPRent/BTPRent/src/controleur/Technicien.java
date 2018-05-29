package controleur;

public class Technicien { 	
		
		private int idTechnicien;
		private String nom, prenom, mail, mdp;
		
		public Technicien ()
		{
			this.idTechnicien = 0;
			this.nom = "";
			this.prenom = "";
			this.mail = "";
			this.mdp = "";		
		}
		
		public Technicien (String nom, String prenom, String mail, String mdp)
		{
			this.idTechnicien = 0;
			this.nom = nom;
			this.prenom = prenom;
			this.mail = mail;
			this.mdp = mdp;
		}
		
		public Technicien (int idTechnicien, String nom, String prenom, String mail, String mdp)
		{
			this.idTechnicien = idTechnicien;
			this.nom = nom;
			this.prenom = prenom;
			this.mail = mail;
			this.mdp = mdp;
		}
		
		public int getIdTechnicien() {
			return idTechnicien;
		}

		public void setIdTechnicien(int idTechnicien) {
			this.idTechnicien = idTechnicien;
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
}

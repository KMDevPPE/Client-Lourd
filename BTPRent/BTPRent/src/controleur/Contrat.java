package controleur;

public class Contrat { 
	
		private int idContrat;
		private String nomClient, nomMateriel, nomSalarie, dateDebut, dateFin;
		
		public Contrat ()
		{
			this.idContrat = 0;
			this.nomClient = "";
			this.nomMateriel = "";
			this.nomSalarie = "";
			this.dateDebut = "";
			this.dateFin = "";	
			
		}
		
		public Contrat (int idContrat, String nomClient, String nomMateriel, String nomSalarie, String dateDebut, String dateFin)
		{
			this.idContrat = idContrat;
			this.nomClient = nomClient;
			this.nomMateriel = nomMateriel;
			this.nomSalarie = nomSalarie;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
		}
		
		public Contrat (String nomClient, String nomMateriel, String nomSalarie, String dateDebut, String dateFin)
		{
			this.idContrat = 0;
			this.nomClient = nomClient;
			this.nomMateriel = nomMateriel;
			this.nomSalarie = nomSalarie;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
		}

		public int getIdContrat() {
			return idContrat;
		}

		public void setIdContrat(int idContrat) {
			this.idContrat = idContrat;
		}

		public String getNomClient() {
			return nomClient;
		}

		public void setNomClient(String nomClient) {
			this.nomClient = nomClient;
		}

		public String getNomMateriel() {
			return nomMateriel;
		}

		public void setNomMateriel(String nomMateriel) {
			this.nomMateriel = nomMateriel;
		}

		public String getNomSalarie() {
			return nomSalarie;
		}

		public void setNomSalarie(String nomSalarie) {
			this.nomSalarie = nomSalarie;
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
		
		/*-------------------------------------	OLD CLASS CONTRAT AFFICHE JUSTE LES ID ----------------------------	
		private int idContrat, idMateriel, idSalarie, idClient;
		private String dateDebut, dateFin;
		
		public Contrat ()
		{
			this.idContrat = 0;
			this.idMateriel = 0;
			this.idSalarie = 0;
			this.idClient = 0;
			this.dateDebut = "";
			this.dateFin = "";	
			
		}
		
		public Contrat (int idContrat, int idMateriel, int idSalarie, int idClient, String dateDebut, String dateFin)
		{
			this.idContrat = idContrat;
			this.idMateriel = idMateriel;
			this.idSalarie = idSalarie;
			this.idClient = idClient;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
		}
		
		public Contrat (int idMateriel, int idSalarie, int idClient, String dateDebut, String dateFin)
		{
			this.idContrat = 0;
			this.idMateriel = idMateriel;
			this.idSalarie = idSalarie;
			this.idClient = idClient;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
		}

		public int getIdContrat() {
			return idContrat;
		}

		public void setIdContrat(int idContrat) {
			this.idContrat = idContrat;
		}

		public int getIdMateriel() {
			return idMateriel;
		}

		public void setIdMateriel(int idMateriel) {
			this.idMateriel = idMateriel;
		}

		public int getIdSalarie() {
			return idSalarie;
		}

		public void setIdSalarie(int idSalarie) {
			this.idSalarie = idSalarie;
		}

		public int getIdClient() {
			return idClient;
		}

		public void setIdClient(int idClient) {
			this.idClient = idClient;
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
		} */

}

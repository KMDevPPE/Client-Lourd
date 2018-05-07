package controleur;

import vue.Vueconnexion;

public class Main {
	
	private static Vueconnexion uneConnexion ;
	
	public static void rendreVisible (boolean action)
	{
		Main.uneConnexion.setVisible(action);
	}
	
	public static void main(String[] args) {
		Main.uneConnexion = new Vueconnexion(); //lancement de la fenetre
	}

}

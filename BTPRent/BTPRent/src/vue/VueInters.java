package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.BDD;
import modele.Modele;
import controleur.Etat;
import controleur.Tableau;

public class VueInters extends JPanel
{
	private Tableau unTableau;
	private JTable tableEtats ;
	
	//récuperer la dimension de l'écran
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int largeur = tailleMoniteur.width * 4/5;
		int hauteur = tailleMoniteur.height * 4/5;
	
	
	public VueInters()
	{

		this.setBounds(0, hauteur/10, largeur, hauteur);
		this.setBackground(Color.RED);
		this.setLayout(null); // les surface
		
		String entete [] ={"nom Client", "Nom Technicien", "Date Intervention", "Description"};
		
		this.unTableau = new Tableau(getDonnees(), entete);
		this.tableEtats = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(tableEtats);
		uneScroll.setBounds(largeur/40, largeur/60, largeur-(largeur/20), hauteur*3/5);
		this.add(uneScroll);
		
	
		this.setVisible(false);
	}
	
	public Object [][] getDonnees ()
	{
		ArrayList<Etat> lesEtats = Modele.selectEtat();
		Object donnees[][] = new Object[lesEtats.size()][4];
		int i = 0;
		for(Etat unEtat : lesEtats){
			donnees[i][0] = unEtat.getNomC();
			donnees[i][1] = unEtat.getNomT();
			donnees[i][2] = unEtat.getDateInter();
			donnees[i][3] = unEtat.getDescription();
			i++;
		}
		return donnees;
	}

}

package vue;

import java.awt.Color;
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
	
	
	public VueInters()
	{
		this.setBounds(40, 100, 1440, 760);
		this.setBackground(Color.RED);
		this.setLayout(null); // les surface
		
		String entete [] ={"nom Client", "Nom Technicien", "Date Intervention", "Description"};
		
		this.unTableau = new Tableau(getDonnees(), entete);
		this.tableEtats = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(tableEtats);
		uneScroll.setBounds(50, 20, 1350, 550);
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

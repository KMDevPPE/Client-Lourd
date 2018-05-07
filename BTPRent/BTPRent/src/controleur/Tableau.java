package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
	private Object [][] donnees ; //matrice de données
	private String [] entete ; //entete de la table
	
	public Tableau(Object [][] donnees, String [] entete )
	{
		this.donnees = donnees;
		this.entete = entete;
		
	}
	@Override
	public int getColumnCount() {
		// le nombre de colonnne du tableau
		return this.entete.length;
	}

	@Override
	public int getRowCount() {
		// prendre le nombre de ligne : l enomre de ligne de la matrice donnee
		return this.donnees.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// prendre la valeur au coroisement de la ligne / colonne
		return this.donnees[rowIndex][columnIndex];
	}
	
	public void add(Object ligne[])
	{
		// cette methode recoit une lgine et l'ajoute à la matrice données 
		Object newTable [][] = new Object [this.donnees.length + 1] [this.entete.length];
		for (int i = 0; i < this.donnees.length ; i++)
		{
			newTable[i] = this.donnees[i];
		}
		newTable[this.donnees.length] = ligne;
		// on recopie la nouvelle matrice dans donnees
		this.donnees = newTable ;
		// on confirme les changements
		this.fireTableDataChanged();

	}
	
	public void delete (int rowIndex)
	{
		//cette methode  supprime la ligne dont le numéro est rowIndex
		Object newTable [][] = new Object [this.donnees.length - 1] [this.entete.length];
		int j=0;
		for (int i = 0; i < this.donnees.length ; i++) // tant que ce n'est pas la ligne a supprimer (do
		{												// je recopie ligne par ligne sauf quand c'est la ligne à suprimer (i)
			if (rowIndex != i)
				{
					newTable[j] = this.donnees[i];
					j++;
				}
		}
		// on recopie la nouvelle matrice dans donnees
		this.donnees = newTable ;
		// on confirme les changements
		this.fireTableDataChanged();

	}
	
	public void update (int rowIndex, Object ligne[])
	{
		// cette methode met a jour une ligne du tableau
		Object newTable [][] = new Object [this.donnees.length][this.entete.length];
		for (int i = 0; i < this.donnees.length ; i++)
		{												
			if (rowIndex == i)
				{
					newTable[i] = ligne;
				}
			else
			{
				newTable[i] = this.donnees[i];
			}
		}
		// on recopie la nouvelle matrice
		this.donnees = newTable;
		// on confirme les changements
		this.fireTableDataChanged();
		
	}
	
	public String getColumnName(int column )
	{
		return this.entete[column];
	}

}

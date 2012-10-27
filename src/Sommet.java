
public class Sommet 
{
	private int nom;
	private int noSommet;
	
	public Sommet(int nom, int noSommet)
	{
		this.setNom(nom);
		this.setNoSommet(noSommet);
	}
	
	public int getNom() {
		return nom;
	}
	public int getNoSommet() {
		return noSommet;
	}
	public void setNom(int nom) {
		this.nom = nom;
	}
	public void setNoSommet(int noSommet) {
		this.noSommet = noSommet;
	}
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Reducteur {
	private File input3SAT;
	private ThreeSAT threeSat;
	private TraitementFichier fichier;
	private ArrayList<Sommet> sommets;
	private ArrayList<Arrete> arretes;
	
	/**
	 * Constructeur du réducteur
	 * @param filename Le num du fichier
	 * @throws IOException
	 */
	public Reducteur(String filename) throws IOException{
		this.input3SAT = new File(filename);
		this.getThreeSat();
		this.sommets = new ArrayList<Sommet>();
		this.arretes = new ArrayList<Arrete>();
		int k=0;
		for(int i=0;i<this.threeSat.getExpr().size();i++)
		{
			for(int j=0;j<3;j++)
			{
				Sommet s = new Sommet(this.threeSat.getExpr().get(i)[j], k);
				sommets.add(s);
				k++;
			}
		}
		
		for(int i=0;i<this.sommets.size();i=i+3)
		{
			arretes.add(new Arrete(sommets.get(i), sommets.get(i+1)));
			arretes.add(new Arrete(sommets.get(i+1), sommets.get(i+2)));
			arretes.add(new Arrete(sommets.get(i+2), sommets.get(i)));
		}
		
		ArrayList<Integer> literaux = new ArrayList<Integer>();
		for(int i=0;i<this.sommets.size();i++)
		{
			literaux.add(sommets.get(i).getNom());
		}
	    Set set = new HashSet() ;
        set.addAll(literaux) ;
        ArrayList<Integer> distinctLiteraux = new ArrayList<Integer>(set) ;

        ArrayList<Sommet> literauxUniques = new ArrayList<Sommet>();
		for(int i=0;i<distinctLiteraux.size();i++)
		{
			literauxUniques.add(new Sommet(distinctLiteraux.get(i), i+100));
		}

		for(int i=0;i<sommets.size();i++)
		{
			for(int j=0;j<literauxUniques.size();j++)
			{
				if(sommets.get(i).getNom()==literauxUniques.get(j).getNom())
				{
					arretes.add(new Arrete(sommets.get(i), literauxUniques.get(j)));
				}
			}
		}

		for(int j=0;j<literauxUniques.size();j++)
		{
			for(int i=0;i<literauxUniques.size();i++)
			{
				if(literauxUniques.get(j).getNom()==(-literauxUniques.get(i).getNom()))
				{	
					arretes.add(new Arrete(literauxUniques.get(i), literauxUniques.get(j)));
				}
			}
		}
		

	    String resultat = "Graph{\n";
		for(int i=0;i<sommets.size();i++)
		{
			resultat = resultat+sommets.get(i).getNoSommet()+" ";
		}
		for(int i=0;i<literauxUniques.size();i++)
		{
			resultat = resultat+literauxUniques.get(i).getNoSommet()+" ";
		}
		resultat = resultat+"\n";
		for(int i=0;i<arretes.size();i++)
		{
			resultat = resultat+arretes.get(i).getS1().getNoSommet()+"--"+arretes.get(i).getS2().getNoSommet()+"\n";
		}
		resultat= resultat+"{";
	    FileWriter sortie = new FileWriter("outputReducteur");
	    sortie.write(resultat);
	    sortie.flush();
	    sortie.close ();
	}

	/**
	 * Récupère les informations du fichier 3SAT
	 * @throws IOException
	 */
	private void getThreeSat() throws IOException {
		this.fichier = new TraitementFichier(this.input3SAT);
		String infos = this.fichier.getString();
		System.out.println(infos);
		String strArray[] = infos.split("\\r?\\n");
		ArrayList<String[]> numbers = new ArrayList<String[]>();
		String line;
		String number = "";
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].matches("^[0-9]*$")) {
				number = strArray[i];
			}
			if (strArray[i].matches("^\\([-0-9|0-9|,| ]*\\)")) {
				line = strArray[i].replaceAll("\\(|\\)", "");
				String lineNumbers[] = line.split(",");
				numbers.add(lineNumbers);
			}
		}
		
		// Affichage
		if(number != ""){
			System.out.println("number: " + number);
		}
		this.threeSat = new ThreeSAT(Integer.valueOf(number).intValue());
		for (int i = 0; i < numbers.size(); i++) {
			int[] temp = new int[3];
			for(int y = 0; y<3; y++){
				temp[y] = Integer.valueOf((numbers.get(i)[y]).trim()).intValue();
				// Affichage
				System.out.println("values.get(" + i + ")["+y+"] => "+ temp[y]);
			}
			this.threeSat.addExpression(temp);
		}
	}
	
	/**
	 * Lancement du réducteur
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Reducteur reducteur = new Reducteur("input3SAT");
		
		
	}
}

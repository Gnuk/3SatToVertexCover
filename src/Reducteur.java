import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Reducteur {
	private File input3SAT;
	private ThreeSAT threeSat;
	private TraitementFichier fichier;
	private ArrayList<Sommet> sommets;
	
	/**
	 * Constructeur du réducteur
	 * @param filename Le num du fichier
	 * @throws IOException
	 */
	public Reducteur(String filename) throws IOException{
		this.input3SAT = new File(filename);
		this.getThreeSat();
		System.out.println(this.threeSat.getExpr().get(1)[2]);
		int k=0;
		for(int i=0;i<this.threeSat.getExpr().size();i++)
		{
			for(int j=0;j<3;j++)
			{
				sommets.add(new Sommet(this.threeSat.getExpr().get(j)[i], k));
				System.out.println(sommets.get(k).getNom());
				k++;
			}
		}
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

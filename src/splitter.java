import java.util.ArrayList;


public class splitter {

	public static void main(String[] args) {
		String str = "Graph{\n0 1 2 3 4 5\n1--2\n1--3\n}";
		String strArray[] = str.split("\n");
		String strSommets = "";
		ArrayList<String[]> arretesListe = new ArrayList(); 
		String arrete;
		for(int i=0; i<strArray.length; i++){
			if(strArray[i].matches("[a-zA-Z_0-9 ]*")){
				strSommets = strSommets + " " + strArray[i];
				
			}
			if(strArray[i].matches("[a-zA-Z_0-9]*--[a-zA-Z_0-9]*")){
				arrete=strArray[i].trim();
				String arreteCourante[] = arrete.split("--");
				arretesListe.add(arreteCourante);
			}
		}
		strSommets=strSommets.trim();
		String sommets[] = strSommets.split(" ");
		// Affichage
		for(int i=0; i<sommets.length;i++){
			System.out.println("sommets["+i+"] : "+sommets[i]);
		}
		String arretes[][] = new String[arretesListe.size()][2];
		for(int i=0; i<arretesListe.size(); i++){
			arretes[i][0]=arretesListe.get(i)[0];
			arretes[i][1]=arretesListe.get(i)[1];
			// Affichage
			System.out.println("arretes["+i+"]"+" [0] => "+arretes[i][0] + " [1] => "+arretes[i][1]);
		}
	}
}

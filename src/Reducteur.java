import java.io.File;
import java.io.IOException;


public class Reducteur {
	private File input3SAT;
	private ThreeSAT threeSat;

	public Reducteur(String filename) throws IOException{
		this.input3SAT = new File(filename);
		this.threeSat = this.getThreeSat();
	}

	private ThreeSAT getThreeSat() throws IOException {
		TraitementFichier fichier = new TraitementFichier(this.input3SAT);
		// TODO Auto-generated method stub
		return null;
	}
}

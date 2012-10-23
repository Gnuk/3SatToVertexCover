import java.io.File;


public class Reducteur {
	private Object input3SAT;
	private ThreeSAT threeSat;

	public Reducteur(String filename){
		this.input3SAT = new File(filename);
		this.threeSat = this.getThreeSat();
	}

	private ThreeSAT getThreeSat() {
		// TODO Auto-generated method stub
		return null;
	}
}

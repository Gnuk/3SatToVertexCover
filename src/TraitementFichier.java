import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;


public class TraitementFichier {
	
	private File file;
	private String string;
	public TraitementFichier(File file) throws IOException{
		this.file=file;
		this.loadFile();
	}
	public TraitementFichier(String filename) throws IOException{
		this.file=new File(filename);
		this.loadFile();
	}
	private void loadFile() throws IOException {
		File f=this.file;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
		StringWriter out = new StringWriter();
		int b;

		while ((b = in.read()) != -1)
			out.write(b);

		out.flush();
		out.close();
		in.close();

		this.string =  out.toString();

	}
	public String getString() {
		return string;
	}
}

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.Edge;
import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.ListenableUndirectedGraph;


public class Solveur {
	private int k;
	private File inputGraph;
	private ListenableGraph<Object, Edge> g;
	
	public static void main(String[] args) {
		Solveur s = new Solveur("graphToSolve") ;
	}
	
	public Solveur(String fileName)
	{
		this.inputGraph = new File(fileName);

		this.g = new ListenableUndirectedGraph<Object, Edge>(DefaultEdge.class);

		this.creerGraphe(this.loadFile(this.inputGraph));
		
		this.verifierGraphe();

	}
	
	public String loadFile(File f) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
		StringWriter out = new StringWriter();
		int b;

		while ((b = in.read()) != -1)
			out.write(b);

		out.flush();
		out.close();
		in.close();

		return out.toString();

	}

	public void creerGraphe(String str) {
		System.out.println(str);
		String strArray[] = str.split("\n");
		String strSommets = "";
		ArrayList<String[]> arretesListe = new ArrayList<String[]>();
		String arrete;
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].matches("[a-zA-Z_0-9 ]*\r$")
					|| strArray[i].matches("[a-zA-Z_0-9 ]*")) {
				strSommets = strSommets + " " + strArray[i];
			}
			if (strArray[i].matches("[a-zA-Z_0-9]*--[a-zA-Z_0-9]*\r$")
					|| strArray[i].matches("[a-zA-Z_0-9]*--[a-zA-Z_0-9]*")) {
				arrete = strArray[i].trim();
				String arreteCourante[] = arrete.split("--");
				arretesListe.add(arreteCourante);
			}
		}
		strSommets = strSommets.trim();
		String sommets[] = strSommets.split(" ");
		// Affichage
		for (int i = 0; i < sommets.length; i++) {
			System.out.println("sommets[" + i + "] : " + sommets[i]);
			this.g.addVertex(sommets[i]);
		}
		String arretes[][] = new String[arretesListe.size()][2];
		for (int i = 0; i < arretesListe.size(); i++) {
			arretes[i][0] = arretesListe.get(i)[0];
			arretes[i][1] = arretesListe.get(i)[1];
			// Affichage
			System.out.println("arretes[" + i + "]" + " [0] => "
					+ arretes[i][0] + " [1] => " + arretes[i][1]);
			this.g.addEdge(arretesListe.get(i)[0], arretesListe.get(i)[1]);
		}
	}
	
	public boolean verifierGraphe()
	{
		ArrayList<Edge> memory = new ArrayList<Edge>();
		for(int i=0;i<c.length; i++)
		{
			Set<Edge> arretes = g.edgesOf(c[i]);
			Iterator<Edge> j = arretes.iterator();
			while(j.hasNext())
			{
				memory.add(j.next());
				
			}
		}
		for(int i=0; i<memory.size();i++)
		{
			g.removeEdge(memory.get(i));
		}
		Set<Edge> arretesRestantes = g.edgeSet();
		if(arretesRestantes.isEmpty())
		{
			System.out.println("verifié");
			return true;
		}
		else
		{
			System.out.println("^perdu");
			return false;
		}
	}
}

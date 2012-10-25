import java.util.ArrayList;


public class ThreeSAT {
	private int n;
	private ArrayList<String>errors;
	private ArrayList<int[]>expr;
	private boolean valid;
	
	/**
	 * Constructeur de 3SAT
	 * @param n
	 */
	public ThreeSAT(int n){
		this.n=n;
		this.valid = true;
		this.expr = new ArrayList<int[]>();
		this.errors = new ArrayList<String>();
	}
	
	/**
	 * Une ligne de 3SAT
	 * @param expr
	 */
	public void addExpression(int[] expr){
		if(expr.length == this.n){
			this.expr.add(expr);
		}
		else{
			this.errors.add("L'expression n'est pas de taille " + this.n);
			this.valid = false;
		}
	}
	
	/**
	 * Indique si le 3SAT est valide
	 * @return
	 */
	public boolean isValid() {
		return valid;
	}
	
	/**
	 * Récupère les expressions du 3SAT
	 * @return
	 */
	public ArrayList<int[]> getExpr() {
		return expr;
	}
	
	/**
	 * Affiche les erreurs s'il y en a
	 */
	private void showErrors() {
		for(int i = 0; i < this.errors.size(); i++){
			System.out.println("Erreur" + this.errors.get(i));
		}
	}
	
	/**
	 * Récupère le nombre associé au 3SAT
	 * @return
	 */
	public int getN() {
		return n;
	}
}

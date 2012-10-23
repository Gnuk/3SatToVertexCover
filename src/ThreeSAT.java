import java.util.ArrayList;


public class ThreeSAT {
	private int n;
	private ArrayList<String>errors;
	private ArrayList<int[]>expr;
	private boolean valid;
	public ThreeSAT(int n){
		this.n=n;
		this.valid = true;
		this.expr = new ArrayList<int[]>();
		this.errors = new ArrayList<String>();
	}
	public void addExpression(int[] expr){
		if(expr.length == this.n){
			this.expr.add(expr);
		}
		else{
			this.errors.add("L'expression n'est pas de taille " + this.n);
			this.valid = false;
		}
	}
	public boolean isValid() {
		return valid;
	}
	public ArrayList<int[]> getExpr() {
		return expr;
	}
	private void showErrors() {
		for(int i = 0; i < this.errors.size(); i++){
			System.out.println("Erreur" + this.errors.get(i));
		}
	}
}

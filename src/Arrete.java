
public class Arrete {

	private Sommet s1;
	private Sommet s2;
	
	public Arrete(Sommet s1, Sommet s2)
	{
		this.setS1(s1);
		this.setS2(s2);
	}
	
	public Sommet getS1() {
		return s1;
	}
	public Sommet getS2() {
		return s2;
	}
	public void setS1(Sommet s1) {
		this.s1 = s1;
	}
	public void setS2(Sommet s2) {
		this.s2 = s2;
	}
}

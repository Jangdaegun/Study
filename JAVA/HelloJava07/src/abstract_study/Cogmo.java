package abstract_study;

public class Cogmo extends LOL {

	public void passive() {
		System.out.println("cogmo passive!");
	}
	
	
	@Override
	public void Q() {
		System.out.println("Q : Q attack");
	}

	@Override
	public void W() {
		System.out.println("W : W attack");
	}

	@Override
	public void E() {
		System.out.println("E : E attack");
	}

	@Override
	public void R() {
		System.out.println("R : R attack");

	}

}

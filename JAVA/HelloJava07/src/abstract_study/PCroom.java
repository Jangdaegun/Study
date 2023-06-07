package abstract_study;

public class PCroom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LOL c1 = new Cogmo();
		Cogmo c2 = new Cogmo();
		
		LOL c3 = new LOL() {

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
		};
		c1.Q();
		c2.passive();
		((Cogmo)c1).passive();
		c3.Q();
	}

}

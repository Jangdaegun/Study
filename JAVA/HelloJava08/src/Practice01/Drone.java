package Practice01;

public class Drone implements Fliable {

	@Override
	public void fly() {
		System.out.println("drone fly");
	}

	@Override
	public void flapWings() {
		System.out.println("drone flapWings");
	}

}

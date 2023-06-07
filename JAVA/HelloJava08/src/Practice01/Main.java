package Practice01;

public class Main {

	public static void main(String[] args) {

		Giraffe giraffe = new Giraffe(5, "Giirraaffee");
		giraffe.sleep();

		Robot robot = new Robot();
		robot.walk();
		robot.run();

		Drone drone = new Drone();
		drone.fly();
		drone.flapWings();
	}
}

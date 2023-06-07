package test_protected;

import study_class.Circle;
import study_class.Globe;
import study_class.Sphere;

public class protected_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle(10);
		System.out.println("make sp1");
		Sphere sp1 = new Sphere();
		System.out.println("make g1");
		Globe g1 = new Globe(100);
		
		g1.setColor("blue");
		g1.spinGlobe(g1.getColor());
	}

}

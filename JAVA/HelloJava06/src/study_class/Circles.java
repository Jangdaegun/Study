package study_class;

public class Circles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1 = new Circle();
		c1.setR(50);
		Circle c2 = new Circle(10);
		
		System.out.println(c1.getArea());
		System.out.println(c1.getround());
		System.out.println(c2.getArea());
		System.out.println(c2.getround());
		
		Sphere sp1 = new Sphere();
		sp1.setR(15);
		sp1.color = "Red";
		sp1.spin();
		Circle.setPI(3.0);
		System.out.println("PI°¡ 3.0ÀÏ ‹š");
		System.out.println(c1.getArea());
		System.out.println(c1.getround());
		System.out.println(c2.getArea());
		System.out.println(c2.getround());
		System.out.println(sp1.getArea());
		System.out.println(sp1.getround());
		System.out.println(sp1.calcVolume());

		Sphere.setPI(3.1);
		Globe.setPI(3.1415);
		
		Globe g1 = new Globe(195);
		g1.color = "Blue";
		g1.spin();
		g1.dance();
		g1.getArea();
		g1.setR(200);
		
	}

}

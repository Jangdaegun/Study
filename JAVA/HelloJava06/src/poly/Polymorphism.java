package poly;

import java.util.ArrayList;

import study_class.Circle;
import study_class.Globe;
import study_class.Sphere;

public class Polymorphism {

	public static void main(String[] args) {
		Circle c = new Sphere();
		c.setR(20);
		Circle c2 = new Globe(200);
		c2.setR(30);
		Circle c3 = new Circle(10);
		Sphere ss = new Sphere();
		ss.setR(40);
		Sphere ss2 = new Globe(300);
		ss2.setR(50);
		
		
		Circle[] circles = new Circle[10];
		circles[0] = c;
		circles[1] = c2;
		circles[2] = c3;
		circles[3] = new Globe(245);
		circles[4] = new Sphere();
		circles[5] = new Circle();
		
		ArrayList<Circle> cc = new ArrayList<>();
		cc.add(c);
		cc.add(c2);
		cc.add(c3);
		cc.add(ss);
		cc.add(ss2);
		
		
		for (Circle circle : cc) {
			System.out.println(circle.getArea());
			System.out.println(circle.getround());
			circle.dance();
			if(circle instanceof Sphere)//new Sphere(), new Globe()라면
			{
				((Sphere)circle).breakCircle();//new Globe()도 호출됨
				System.out.println(((Sphere)circle).calcVolume());
			}
			if(circle instanceof Globe) {
				((Globe)circle).setColor("Green");
				((Globe)circle).spinGlobe
				(((Globe)circle).getColor());
				
			}
				
		}
	}

}

package Zoo;

import java.util.ArrayList;

public class Zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal c1 = new Cat();
		Animal c2 = new Cat();
		Animal c3 = new Cat();
		Animal d1 = new Dog();
		Animal d2 = new Dog();

		c1.setName("미국 고양이");
		c1.setAge(10);
		c2.setName("한국 고양이");
		c2.setAge(1);
		c3.setName("영국 고양이");
		c3.setAge(5);
		d1.setName("미국 강아지");
		d1.setAge(5);
		d2.setName("한국 강아지");
		d2.setAge(3);

		Animal[] animals = new Animal[10];
		animals[0] = c1;
		animals[1] = c2;
		animals[2] = c3;
		animals[3] = d1;
		animals[4] = d2;

		ArrayList<Animal> Aniarray = new ArrayList<Animal>();
		Aniarray.add(c1);
		Aniarray.add(c2);
		Aniarray.add(c3);
		Aniarray.add(d1);
		Aniarray.add(d2);

		for (Animal animal : Aniarray) {
			if (animal instanceof Cat) {
				((Cat) animal).setEyeColor("빨간");
				((Cat) animal).Meow();
			}
			if (animal instanceof Dog) {
				((Dog) animal).bark();
			}
		}
	}

}

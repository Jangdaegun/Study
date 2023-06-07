package Practice01;

public abstract class Animal {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public abstract void sleep();
}

package Zoo;

public class Animal {
	private String name;
	private int age;

	public void sleep() {
		System.out.println(getName() + "! ¿·¿ª ¿‹¥Ÿ.");
		System.out.println(getAge() + "ªÏ ¥‰∞‘ ¿‹¥Ÿ.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

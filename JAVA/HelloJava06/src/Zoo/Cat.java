package Zoo;

public class Cat extends Animal {
	private String eyeColor;

	public void Meow() {
		System.out.println("Meow Meow");
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	@Override
	public void sleep() {
		System.out.println("�̸� : " + getName());
		System.out.println(eyeColor + "�� ���� ���´�..");
	}
}

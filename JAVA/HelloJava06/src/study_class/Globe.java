package study_class;

public class Globe extends Sphere {

	private int CountOfCountry;

	public Globe(int countOfCountry) {
		this.CountOfCountry = countOfCountry;
	}

	public void spinGlobe(String c) {
		color = c;
		spin();
	}

	public void setColor(String c) {
		color = c;
	}

	public String getColor() {
		return color;
	}

	@Override
	public void dance() {
		System.out.println(this.CountOfCountry + "������� ���ϴ�.");
	}

	@Override
	public void breakCircle() {

		System.out.println(this.CountOfCountry + "������� �������ϴ�.");
	}

}

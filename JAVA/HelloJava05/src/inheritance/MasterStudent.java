package inheritance;

public class MasterStudent extends UnivStudent {

	private String profName;
	protected String thesisTopic;
	
	protected void writeThesis() {
		System.out.println(getProfName()+"교수님의 지도를 받아");
		System.out.println("논문을 씁니다. 무조건 최신 논문 인용");
		System.out.println("글자는 꽉 차야함. 내용은 중요치 않아.");
	}
	
	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}

	public MasterStudent(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	public MasterStudent(String name, int age, String hakbeon) {
		super(name, age, hakbeon);
		// TODO Auto-generated constructor stub
	}

	public MasterStudent(String name, int age, String hakbeon, String profName) {
		super(name, age, hakbeon);
		this.profName = profName;
	}

	public void cleanRoom() {
		System.out.println(getProfName() + "교수님 차 유리에 붙은 불법 딱지 제거");
	}

	public void cleanRoon(String name) {
		System.out.println(getProfName() + "교수님의" + name + "을 청소한다.");
	}
	
	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("대학원생처럼 공부한다.");
	}
	
	@Override
	public void sleep() {
		System.out.println(getProfName() + "교수님 연구실에서 잔다.");
	}

}

package inter_abstract_study;

public abstract class Digimon {

	private String name;
	private int level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public abstract void evolution();

	public abstract void degeneration();
}

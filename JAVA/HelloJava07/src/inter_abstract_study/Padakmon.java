package inter_abstract_study;

public class Padakmon extends Digimon implements Holiable {

	@Override
	public void killundead() {
		return;
	}

	@Override
	public void holypeast() {
		return;
	}

	@Override
	public void holybolt() {
		return;
	}

	@Override
	public void evolution() {
		System.out.println("Holi evolution!");
	}

	@Override
	public void degeneration() {
		System.out.println(" Holi degeneration!");
	}

}

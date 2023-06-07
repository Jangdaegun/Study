package interface_study2;

public class ElecStudent implements Studiable {

	@Override
	public void study() {
		System.out.println("study elec");
	}

	@Override
	public void rest() {
		System.out.println("rest elec");
	}

}

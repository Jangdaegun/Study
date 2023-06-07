package interface_study2;

public interface Studiable {
	public void study();

	public default void rest() {
		System.out.println("rest student");
	}

}

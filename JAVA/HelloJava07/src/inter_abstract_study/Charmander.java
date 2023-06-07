package inter_abstract_study;

import interface_study.Animalable;
import interface_study.Pocketmon;

public class Charmander extends Pocketmon implements Animalable, Fireable {

	@Override
	public void shotFire() {
		System.out.println("shot fire!");
	}

	@Override
	public void Fireball() {
		System.out.println("fire ball!");
	}

	@Override
	public void FlameWall() {
		System.out.println("flame wall!");
	}

	@Override
	public void bodyattack() {
		System.out.println("body attack!");
	}

	@Override
	public void quickattack() {
		System.out.println("quick attack!");
	}

	@Override
	public void run() {
		System.out.println("run!!");
	}

	@Override
	public void jump() {
		System.out.println("jump!!!");
	}

	@Override
	public void cry() {
		System.out.println("cry!!");
	}

}

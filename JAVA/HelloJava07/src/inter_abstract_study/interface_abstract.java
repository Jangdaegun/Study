package inter_abstract_study;

import interface_study.Bulbasaur;
import interface_study.Ivysaur;
import interface_study.Pocketmon;

public class interface_abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pocketmon p1 = new Bulbasaur();
		Pocketmon p2 = new Charmander();
		Bulbasaur b1 = new Bulbasaur();
		Bulbasaur b2 = new Ivysaur();
		Charmander c1 = new Charmander();
		
		p1.cry();
		p2.cry();
		b1.bodyattack();
		b2.quickattack();
		c1.bodyattack();
	}

}

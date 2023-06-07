package game;

public class Diablo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GameCharacter.getCount());
		GameCharacter g1 = new GameCharacter("핫핑크공주소병수", "전사");
		GameCharacter g2 = new GameCharacter("네이비블랙최은지", "마법사");
		GameCharacter g3 = new GameCharacter("무색무취이동준", "선생님");
		GameCharacter g4 = new GameCharacter();
		System.out.println(GameCharacter.getCount());

		GameCharacter.chat("hiihi");
		GameCharacter.chat("무색무취이동준","쉬고시펑요");
		
		g1.printInfo();
		g2.printInfo();
		g3.printInfo();
		
		g1.setJob("마법사");
		g1.setLevel(255);
		g2.setJob("전사");
		g2.setLevel(100);
		g3.setLevel(35);
		
		g1.printInfo();
		g2.printInfo();
		g3.printInfo();
		
		g1.attack();
		g2.attack();
		g3.attack();
		
	}

}

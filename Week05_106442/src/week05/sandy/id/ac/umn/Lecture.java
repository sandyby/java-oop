package week05.sandy.id.ac.umn;

public class Lecture {

	public static void main(String[] args) {
		Character npc = new Character("Sandal", 100, 60, 60, 60, 60, 60);
		Swordsman sword1 = new Swordsman("Sandy", 100, 80, 80, 80, 80, 80);
		Magician mage1 = new Magician("Yuvens", 100, 80, 80, 80, 80, 80);

		System.out.println(String.format("NPC\n%d\n%d", npc.TakeDamage(50), npc.Hit()));
		System.out.println(String.format("Swordsman\n%d\n%d", sword1.TakeDamage(50), sword1.Hit()));
		System.out.println(String.format("Magician\n%d\n%d\n%d\n%d", mage1.TakeDamage(50), mage1.Hit(),
				mage1.Hit("small"), mage1.Hit("large")));
	}
}

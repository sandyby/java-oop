package week05.sandy.id.ac.umn;

public class Magician extends Character {

	public Magician(String name, float maxHp, float attack, float defense, int intelligence, int strength,
			int agility) {
		super(name, maxHp, attack, defense, intelligence, strength, agility);
	}

	@Override
	public int TakeDamage(int d) {
		int X = (int) (d - (0.8 * this.defense + this.intelligence * 0.3 + this.agility * 0.2));
		return (int) (this.currentHp - X);
	}

	@Override
	public int Hit() {
		int X = (int) (1.2 * this.attack + this.intelligence * 0.7 + this.agility * 0.1 + this.strength * 0.1);
		return X;
	}

	public int Hit(String targetSize) {
		double mod = (targetSize.toLowerCase() == "small" ? 0.75 : (targetSize.toLowerCase() == "large" ? 0.8 : 1));

		int X = (int) (mod * (1.2 * this.attack + this.intelligence * 0.7 + this.agility * 0.1 + this.strength * 0.1));
		return X;
	}
}

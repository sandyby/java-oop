package week05.sandy.id.ac.umn;

public class Swordsman extends Character {

	public Swordsman(String name, float maxHp, float attack, float defense, int intelligence, int strength,
			int agility) {
		super(name, maxHp, attack, defense, intelligence, strength, agility);
	}

	@Override
	public int TakeDamage(int d) {
		int X = (int) (d - (this.defense + this.strength * 0.5 + this.agility * 0.2));
		return (int) (this.currentHp - X);
	}

	@Override
	public int Hit() {
		int X = (int) (this.attack + this.strength * 0.5 + this.intelligence * 0.3);
		return X;
	}
}

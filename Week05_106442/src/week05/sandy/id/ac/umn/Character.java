package week05.sandy.id.ac.umn;

public class Character {
	protected String name;
	protected float maxHp;
	protected float currentHp;
	protected float attack;
	protected float defense;
	protected int intelligence;
	protected int strength;
	protected int agility;

	public Character(String name, float maxHp, float attack, float defense, int intelligence, int strength,
			int agility) {
		this.name = name;
		this.maxHp = maxHp;
		this.currentHp = maxHp;
		this.attack = attack;
		this.defense = defense;
		this.intelligence = intelligence;
		this.strength = strength;
		this.agility = agility;
	}

	public int TakeDamage(int damage) {
		int X = (int) (damage - this.defense);
//		logika
		System.out.println(this.currentHp);
		return (int) (this.currentHp -= X);
	}

	public int Hit() {
		return (int) this.attack;
	}
}

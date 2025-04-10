package sandyb;

public class W05 {
	public static class Character {
		protected String name;
		protected float maxHp;
		protected float currentHp;
		protected float attack;
		protected float defense;
		protected int intelligence;
		protected int strength;
		protected int agility;

		/*
		 * currentHp gak diterima di parameter diambil dari nilai maxHp di parameter
		 */

		public Character(String name, float maxHp, float attack, float defense, int intelligence, int strength,
				int agility) {
			this.name = name;
			this.maxHp = maxHp;
			this.currentHp = maxHp; // derived
			this.attack = attack;
			this.defense = defense;
			this.intelligence = intelligence;
			this.strength = strength;
			this.agility = agility;
		}

		public int TakeDamage(int d) {
			/*
			 * mengurangi currentHp yang dimiliki berdasarkan nilai X, di mana X = d -
			 * defense
			 */
			float X = (float) d - defense;
			return (int) (currentHp - X);
		}

		public int Hit() {
			return (int) attack;
		}
	}

	public static class Swordsman extends Character {
		public Swordsman(String name, float maxHp, float attack, float defense, int intelligence, int strength,
				int agility) {
			super(name, maxHp, attack, defense, intelligence, strength, agility);
		}

		@Override
		public int TakeDamage(int d) {
			float X = (float) (d - (defense + strength * 0.5 + agility * 0.2));
			return (int) (currentHp - X);
		}

		@Override
		public int Hit() {
			return (int) (attack + strength * 0.5 + intelligence * 0.3);
		}
	}

	public static class Magician extends Character {
		public Magician(String name, float maxHp, float attack, float defense, int intelligence, int strength,
				int agility) {
			super(name, maxHp, attack, defense, intelligence, strength, agility);
		}

		@Override
		public int TakeDamage(int d) {
			float X = (float) (d - (0.8 * defense + intelligence * 0.3 + agility * 0.2));
			return (int) (currentHp - X);
		}

		@Override
		public int Hit() {
			return (int) (1.2 * attack + intelligence * 0.7 + agility * 0.1 + strength * 0.1);
		}

		public int Hit(String targetSize) {
			float mod;
			if (targetSize.equalsIgnoreCase("large")) {
				mod = (float) 0.8;
			} else {
				mod = (float) 0.75; // di case ini, defaultnya "small"
			}

			float X = (float) (mod * (1.2 * attack + intelligence * 0.7 + agility * 0.1 + strength * 0.1));
			return (int) X;
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Character blueprint = new Character("Ben", 100, 80, 60, 89, 77, 90);
			Swordsman swordsman = new Swordsman("Seb", 100, 88, 80, 82, 95, 90);
			Magician magician = new Magician("Pen", 100, 96, 65, 96, 75, 85);

			System.out.println("------------------\nBlueprint Character\n------------------");
			System.out.println("Name: " + blueprint.name);
			System.out.println("Max HP: " + blueprint.maxHp);
			System.out.println("Curr HP: " + blueprint.currentHp);
			System.out.println("Attack: " + blueprint.attack);
			System.out.println("Defense: " + blueprint.defense);
			System.out.println("Intelligence: " + blueprint.intelligence);
			System.out.println("Strength: " + blueprint.strength);
			System.out.println("Agility: " + blueprint.agility);
			System.out.println("------\nActions\n------");
			System.out.println("TakeDamage: " + blueprint.TakeDamage(70));
			System.out.println("Hit: " + blueprint.Hit());

			System.out.println("------------------\nSwordsman Character\n------------------");
			System.out.println("Name: " + swordsman.name);
			System.out.println("Max HP: " + swordsman.maxHp);
			System.out.println("Curr HP: " + swordsman.currentHp);
			System.out.println("Attack: " + swordsman.attack);
			System.out.println("Defense: " + swordsman.defense);
			System.out.println("Intelligence: " + swordsman.intelligence);
			System.out.println("Strength: " + swordsman.strength);
			System.out.println("Agility: " + swordsman.agility);
			System.out.println("------\nActions\n------");
			System.out.println("TakeDamage: " + swordsman.TakeDamage(70));
			System.out.println("Hit: " + swordsman.Hit());

			System.out.println("------------------\nMagician Character\n------------------");
			System.out.println("Name: " + magician.name);
			System.out.println("Max HP: " + magician.maxHp);
			System.out.println("Curr HP: " + magician.currentHp);
			System.out.println("Attack: " + magician.attack);
			System.out.println("Defense: " + magician.defense);
			System.out.println("Intelligence: " + magician.intelligence);
			System.out.println("Strength: " + magician.strength);
			System.out.println("Agility: " + magician.agility);
			System.out.println("------\nActions\n------");
			System.out.println("TakeDamage: " + magician.TakeDamage(70));
			System.out.println("Hit (sm): " + magician.Hit("small"));
			System.out.println("Hit (lg): " + magician.Hit("large"));
			System.out.println("Hit (default): " + magician.Hit("sasdasdas"));
			System.out.println("Hit: " + magician.Hit());
		}
	}
}

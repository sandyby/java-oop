package sandyb;

import java.util.ArrayList;

public class W04 {
	public static Person getPerson() {
		return new Person(null, ' ', null, null);
	}

	public static class Person {
		public static final int MAX_CHILDREN = 50;
		private String nama;
		private char jenisKelamin;
		private Person parent;
		private Person[] children;

		public Person(String nama, char jenisKelamin, Person parent, Person[] children) {
			this.nama = nama;
			this.jenisKelamin = jenisKelamin;
			this.parent = parent;
			this.children = children;
		}

		public String getNama() {
			return nama;
		}

		public char getJenisKelamin() {
			return jenisKelamin;
		}

		public Person getParent() {
			return parent;
		}

		public void setNama(String nama) {
			this.nama = nama;
		}

		public Person[] getChildren() {
			return children;
		}

		public Person[] getChildren(char jenisKelamin) {
			int filteredCounter = 0;
			if (children == null || children.length == 0) {
				return new Person[0];
			}

			if (jenisKelamin == ' ') {
				return children;
			}

			for (Person person : children) {
				if (person.getJenisKelamin() == jenisKelamin) {
					filteredCounter++;
				}
			}

			Person[] filteredChildrenByGender = new Person[filteredCounter];
			int indexCounter = 0;
			for (Person person : children) {
				// System.out.println(person.getJenisKelamin() + " " + person.getNama());
				// System.out.println(filteredCounter);
				// System.out.println(indexCounter);
				if (person.getJenisKelamin() == jenisKelamin && indexCounter < filteredCounter) {
//					System.out.println(person.getNama());
					filteredChildrenByGender[indexCounter] = person;
					indexCounter++;
				}
			}

			return filteredChildrenByGender;
		}

		public Person[] getAllAncestors() {
			int ancestorCount = 0;
			Person parentReference = this.getParent();
			while (parentReference != null) {
				ancestorCount++;
				parentReference = parentReference.getParent();
			}

			Person[] ancestors = null;
//			System.out.println(ancestorCount);
			if (ancestorCount != 0)
				ancestors = new Person[ancestorCount];

			parentReference = this.getParent();
			int indexCounter = 0;
			while (parentReference != null) {
				ancestors[indexCounter] = parentReference;
//				System.out.println(parentReference.getNama());
				parentReference = parentReference.getParent();
				if (indexCounter == ancestorCount)
					break;
				indexCounter++;
			}

			return ancestors;
		}

		public Person[] getAllSuccessors() {
			/*
			 * 
			 * :) sengsara pake Array, mending pake ArrayList aja :D
			 * 
			 */
			ArrayList<Person> successors = new ArrayList<>();
			Person[] children = this.getChildren();
			if (children != null) {
				for (Person child : children) {
					if (child != null) {
						successors.add(child);
						Person[] grandChildren = child.getAllSuccessors(); // rekursif
						for (Person grandChild : grandChildren) {
							successors.add(grandChild);
						}
					}
				}
			}
			return successors.toArray(new Person[0]);
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Person grandpa = new Person("Budi", 'L', null, null);
			Person grandma = new Person("Ani", 'P', null, null);
			Person dad = new Person("Sandy", 'L', grandpa, null);
			Person mom = new Person("Rina", 'P', grandma, null);
			Person son1 = new Person("Tarekh", 'L', dad, null);
			Person daughter = new Person("Siti", 'P', mom, null);
			Person son2 = new Person("Adi", 'L', dad, null);
			Person grandkid = new Person("Lila", 'P', daughter, null);
			Person greatGrandkid = new Person("Miko", 'L', grandkid, null);

			Person[] greatGrandkidChildren = {};
			Person[] grandkidChildren = { greatGrandkid };
			Person[] son1Children = { daughter };
			Person[] dadChildren = { son1, son2 };
			Person[] momChildren = { son1, son2 };
			Person[] grandpaChildren = { dad };
			Person[] grandmaChildren = { mom };

			grandpa.children = grandpaChildren;
			grandma.children = grandmaChildren;
			dad.children = dadChildren;
			mom.children = momChildren;
			son1.children = son1Children;
			grandkid.children = grandkidChildren;
			greatGrandkid.children = greatGrandkidChildren;

			System.out.println("All successors of Grandma:");
			Person[] grandmaSuccessors = grandma.getAllSuccessors();
			for (Person p : grandmaSuccessors) {
				System.out.println(p.getNama());
			}

			System.out.println("\nAll successors of Grandpa:");
			Person[] grandpaSuccessors = grandpa.getAllSuccessors();
			for (Person p : grandpaSuccessors) {
				System.out.println(p.getNama());
			}

			System.out.println("\nAll ancestors of Lila:");
			Person[] grandkidAncestors = grandkid.getAllAncestors();
			for (Person p : grandkidAncestors) {
				System.out.println(p.getNama());
			}

			System.out.println("\nAll ancestors of Adi:");
			Person[] son2Ancestors = son2.getAllAncestors();
			for (Person p : son2Ancestors) {
				System.out.println(p.getNama());
			}

			System.out.println("\nAll male children of Rina:");
			Person[] momMaleChildrens = mom.getChildren('L');
			for (Person p : momMaleChildrens) {
				System.out.println(p.getNama());
			}

			System.out.println("\nAll female children of Rina:");
			Person[] momFemaleChildrens = mom.getChildren('F');
			for (Person p : momFemaleChildrens) {
				System.out.println(p.getNama());
			}

			System.out.println("\nAll children of Rina:");
			Person[] momChildrens = mom.getChildren();
			for (Person p : momChildrens) {
				System.out.println(p.getNama());
			}

			System.out.println("\nParent of Tarekh:");
			Person son1Parent = son1.getParent();
			System.out.println(son1Parent.getNama());
		}
	}
}

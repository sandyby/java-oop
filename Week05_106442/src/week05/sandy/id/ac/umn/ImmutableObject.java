package week05.sandy.id.ac.umn;

public class ImmutableObject {
	public static class ImmutableEmployee {
		private final int id;
		private final String name;

		public ImmutableEmployee(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

//		public void setId(int id) {
//			this.id = id;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}

		@Override
		public String toString() {
			return "ImmutableEmployee{" + "id=" + id + ", name='" + name + "'}";
		}
	}

	public static class Main {
		public static void main(String[] args) {
			ImmutableEmployee ie1 = new ImmutableEmployee(1, "Sandy");
			System.out.println(ie1.getId());
			System.out.println(ie1.getName());
		}
	}
}

package sandyb;

import java.util.ArrayList;

public class W06_PhoneBook {
//	static interface ContactInfoStuff {
//		String getName();
//
//		String getContact();
//
//		boolean match(String name);
//	}

//	static interface PhoneBookStuff {
//
//	}

//	public static class ContactInfo implements ContactInfoStuff {
	public static class ContactInfo {
		private String firstName;
		private String lastName;
		private String phoneNumber;
		private String country;

		public ContactInfo(String firstName, String lastName, String phoneNumber, String country) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.country = country;
		}

		private String getName() {
			return firstName + " " + lastName;
		}

		public String getContact() {
			return this.getName() + " - " + phoneNumber + " (" + country + ")";
		}

		public boolean match(String name) {
			if (name.equalsIgnoreCase(lastName) || name.equalsIgnoreCase(firstName))
				return true;
			return false;
		}
	}

//	public static class PhoneBook extends ContactInfo {
	public static class PhoneBook {
		private ContactInfo owner;
		private ArrayList<ContactInfo> contacts = new ArrayList<>();

		public PhoneBook(ContactInfo owner) {
			this.owner = owner;
		}

		public ContactInfo getOwner() {
			return owner;
		}

		public void addContact(ContactInfo contact) {
			contacts.add(contact);
		}

		public ContactInfo findContactByName(String name) {
			for (ContactInfo contact : contacts) {
				if (contact.firstName.toLowerCase().contains(name.toLowerCase())
						|| contact.lastName.toLowerCase().contains(name.toLowerCase())) {
					System.out.println("Contact found!");
					return contact;
				}
			}
			System.out.println("Contact not found!");
			return null;
		}

		public ContactInfo[] findContactsByName(String name) {
			ArrayList<ContactInfo> foundContacts = new ArrayList<>();
			for (ContactInfo contact : contacts) {
				if (contact.firstName.toLowerCase().contains(name.toLowerCase())
						|| contact.lastName.toLowerCase().contains(name.toLowerCase()))
					foundContacts.add(contact);
			}
			if (foundContacts.size() > 0) {
				System.out.println("Found " + foundContacts.size() + " contact(s) with the name: " + name);
				return foundContacts.toArray(new ContactInfo[0]);
			}
			System.out.println("No contact(s) were found!");
			return new ContactInfo[0];
		}
	}

	public static class Main {
		public static void main(String[] args) {
			ContactInfo contact1 = new ContactInfo("John", "Doe", "123456789", "USA");
			ContactInfo contact2 = new ContactInfo("Jane", "Smith", "987654321", "Canada");
			ContactInfo contact3 = new ContactInfo("Lory", "Jane", "18131238", "Cinere");

			ContactInfo owner = new ContactInfo("Alice", "Johnson", "555555555", "Australia");
			PhoneBook phoneBook = new PhoneBook(owner);
			phoneBook.addContact(contact1);
			phoneBook.addContact(contact2);
			phoneBook.addContact(contact3);

			ContactInfo foundContact = phoneBook.findContactByName("Doe");
			System.out.println(foundContact.getContact() + "\n");

			ContactInfo[] foundContacts = phoneBook.findContactsByName("Jane");
			for (ContactInfo contact : foundContacts) {
				System.out.println(contact.getContact());
			}
		}
	}
}

package phonebbook;

import java.util.Scanner;

public class Index {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String[] users = {};
		
		for (;;) {
			System.out.println("\nPlease select an option: \n1) create user \n2) search user \n3)update user \n4) terminate program");
			int option = input.nextInt();
			
			if(option == 1) {
				String[] newArray = new String[users.length + 1];
				for(int i = 0; i<users.length;i++) {
					newArray[i] = users[i];
				}
				String user = createPerson();
				System.out.println("\nNew user added to phonebook:\n" + user);
				newArray[newArray.length-1] = user;
				users = newArray;
			}
			if(option == 2) {
				System.out.println("\nEnter first or last name: ");
				String search = input.next();
				for(int i = 0; i<users.length;i++) {
					if(users[i].contains(search)) {
						System.out.println("\n" + users[i]);
					}
				}	
			}
			if(option ==3) {
				System.out.println("\nEnter phone number: ");
				String search = input.next();
				for(int i = 0; i<users.length;i++) {
					if(users[i].contains(search)) {
						System.out.println(users[i]);
						System.out.println("\nwhat would you like to do: \n1) return to  main menu \n2) update user info \n3) delete user");
						int option3 = input.nextInt();
						
						if(option3 == 1) {
							break;
						}
						
						if(option3 == 2) {
							String user = createPerson();
							System.out.println("\nUser has been updated: \n" +  user);
							users[i] = user;
						}
						
						if(option3 == 3) {
							users[i] = null;
						}
							
					}
						
				}
					
			}
				
			
			if(option == 4) {
				System.out.println("system terminated");
				System.exit(0);
			}
			
		}
	}
		public static String createPerson() {
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("\nEnter first name:" );
			String firstName = input.nextLine();
			System.out.println("Enter last name:" );
			String lastName = input.nextLine();
			System.out.println("Enter phone number:" );
			String phone = input.nextLine();
			
			System.out.println("Enter house number and street:" );
			String street = input.nextLine();
			System.out.println("Enter city:" );
			String city = input.nextLine();
			System.out.println("Enter state:" );
			String state = input.nextLine();
			System.out.println("Enter zip code:" );
			String zip = input.nextLine();
			
			People person = new People(firstName, lastName, phone);
			String user = person.getFirstName() + person.getLastName() + person.getPhone();
			
			Address address = new Address(street, city, state, zip);
			String residence = address.getStreet() + address.getCity() + address.getState()	+ address.getZip();	
			
			return user + residence;
		
	}

}

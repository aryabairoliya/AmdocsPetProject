package Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchMain {
	public static void main(String args[]) throws petInputException {
		int petId;
		String petCategory;
		String petType;
		String color;
		int age;
		double price;
		boolean isVaccinated;
		String foodHabits;
		Scanner sc=new Scanner(System.in);
		//Pet pet=new Pet();
		PetDAO petDao=new PetDAO();
		
		int choice=0;
		do {
			
		System.out.println("Enter your choice:");
		System.out.println("1.Add new pet Details: ");
		System.out.println("2.Update Pet Price and Vaccination Status.");
		System.out.println("3.Delete Pet details.");
		System.out.println("4.View all pets.");
		System.out.println("5.Count pets by Category.");
		System.out.println("6.Find by Price.");
		System.out.println("7.Find by Vaccination Status for pet type.");
		System.out.println("8.Exit");
		choice=sc.nextInt();
			
		
		switch(choice) {
		case 1:
			int flag=0;
			while(flag==0) {
			try {
			System.out.println("Enter pet ID: ");
			petId=sc.nextInt();
			System.out.println("Enter pet Category");
			petCategory=sc.next();
			System.out.println("Enter pet Type:");
			petType=sc.next();
			System.out.println("Enter Pet color");
			color=sc.next();
			System.out.println("Enter pet age: ");
			age=sc.nextInt();
			System.out.println("Enter the price of the pet:");
			price=sc.nextDouble();
			System.out.println("Is your pet Vaccinated(true/false)?");
			isVaccinated=sc.nextBoolean();
			System.out.println("What are the food habits of your pet?");
			foodHabits=sc.next();
			Pet pet=new Pet(petId,petCategory,petType,color,age,price,isVaccinated,foodHabits);
			
			petDao.addPetDetails(pet);
			flag=1;
			}catch(Exception e) {
				flag=0;
				
				try {
					sc.next();					
					throw new petInputException();
				}catch(petInputException p) {
					
				}
				
			}}
			
			break;
		case 2:
			flag=0;
			while(flag==0) {
				try {
			System.out.println("What is the id of the pet you want to update price and vaccination status of: ");
			petId=sc.nextInt();
			System.out.println("What is the new pet price: ");
			price=sc.nextDouble();
			System.out.println("Is you pet Vaccinated?");
			isVaccinated=sc.nextBoolean();
			
			petDao.updatePetPriceAndVaccinationStatus(petId,price, isVaccinated);
			flag=1;
			}catch(Exception e) {
				flag=0;
				
				try {
					sc.next();					
					throw new petInputException();
				}catch(petInputException p) {
					
				}
				
			}}
			break;
			
		case 3:
			flag=0;
			while(flag==0) {
				try {
			System.out.println("Enter the id for which you want to delete pet details:");
			petId=sc.nextInt();
			petDao.deletePetDetails(petId);
			flag=1;
				}catch(Exception e) {
					flag=0;
					
					try {
						sc.next();					
						throw new petInputException();
					}catch(petInputException p) {
						
					}
					
				}}
			break;
			
		case 4:
			List <Pet> pets=new ArrayList<Pet>();
			pets=petDao.showAllPets();
			System.out.println(pets);
			break;
		case 5:
			System.out.println("Enter the category of the pet you want to count: ");
			petCategory=sc.next();
			System.out.println(petDao.countPetsByCategory(petCategory)); 
			
			break;
		case 6:
			flag=0;
			while(flag==0) {
				try {
			System.out.println("Enter the range of minimum and max price to search for pet:");
			double minPrice;
			double maxPrice;
			minPrice=sc.nextDouble();
			maxPrice=sc.nextDouble();
			List <Pet> petss=new ArrayList<Pet>();
			petss=petDao.searchByPrice(minPrice, maxPrice);
			System.out.println(petss);
			
			petDao.searchByPrice(minPrice, maxPrice);
			flag=1;
				}catch(Exception e) {
					flag=0;
					
					try {
						sc.next();					
						throw new petInputException();
					}catch(petInputException p) {
						
					}
					
				}}
			break;
		case 7:
			flag=0;
			while(flag==0) {
				try {
			System.out.println("Enter the pet type for which you want to find vaccination status: ");
			petType=sc.next();
			System.out.println("Enter the vaccination status(true/false)");
			isVaccinated=sc.nextBoolean();
			System.out.println(petDao.countByVaccinationStatusForPetType(isVaccinated,petType));
			flag=1;
			}catch(Exception e) {
				flag=0;
				
				try {
					sc.next();					
					throw new petInputException();
				}catch(petInputException p) {
					
				}
				
			}}
			break;
		case 8:
			System.out.println("Successfully exited from the system...");
			break;
		default:
				System.out.println("Please enter a valid integer between 1 and 8");
				break;
			}
		}
		while(choice!=8);
		
	}
}

package Pet;

public class petInputException extends Exception {
	petInputException(){
		System.out.println("The input entered doesn't match the expected input range. Please add input accordingly.");
	}
}

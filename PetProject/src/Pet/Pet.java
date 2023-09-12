package Pet;

public class Pet {
int petId;
String petCategory;
String petType;
String color;
int age;
double price;
boolean isVaccinated;
String foodHabits;

public Pet() {
	petId=0;
	petCategory=null;
	petType=null;
	color=null;
	age=0;
	price=0;
	isVaccinated=false;
	foodHabits=null;
}

public Pet(int petId, String petCategory, String petType, String color, int age, double price, boolean isVaccinated,
		String foodHabits) {
	//super();
	this.petId = petId;
	this.petCategory = petCategory;
	this.petType = petType;
	this.color = color;
	this.age = age;
	this.price = price;
	this.isVaccinated = isVaccinated;
	this.foodHabits = foodHabits;
}

public int getPetId() {
	return petId;
}

public void setPetId(int petId) {
	this.petId = petId;
}

public String getPetCategory() {
	return petCategory;
}

public void setPetCategory(String petCategory) {
	this.petCategory = petCategory;
}

public String getPetType() {
	return petType;
}

public void setPetType(String petType) {
	this.petType = petType;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public boolean isVaccinated() {
	return isVaccinated;
}

public void setVaccinated(boolean isVaccinated) {
	this.isVaccinated = isVaccinated;
}

public String getFoodHabits() {
	return foodHabits;
}

public void setFoodHabits(String foodHabits) {
	this.foodHabits = foodHabits;
}

@Override
public String toString() {
	return "\nPetId=" + petId + "\npetCategory=" + petCategory + "\npetType=" + petType + "\ncolor=" + color
			+ "\nage=" + age + "\nprice=" + price + "\nisVaccinated=" + isVaccinated + "\nfoodHabits=" + foodHabits
			+ "\n\n";
}

}


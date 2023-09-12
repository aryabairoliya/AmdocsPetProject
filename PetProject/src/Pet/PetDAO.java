package Pet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetDAO extends JDBCConnection{
List<Pet> l;

	int addPetDetails(Pet p) {
		int count=0;
		 try {
			 PreparedStatement pst=getConnection().prepareStatement("insert into pet values(?,?,?,?,?,?,?,?)");
			 pst.setInt(1, p.getPetId());
			 pst.setString(2, p.getPetCategory());
			 pst.setString(3, p.getPetType());
			 pst.setString(4, p.getColor());
			 pst.setInt(5,p.getAge());
			 pst.setDouble(6, p.getPrice());
			 char vacc;
			 if(p.isVaccinated==true) {
				 vacc = 'y';
			 } else {
				 vacc = 'n';
			 }
			 pst.setString(7, String.valueOf(vacc));
			 pst.setString(8, p.getFoodHabits());
			count= pst.executeUpdate();
			
		 }catch(Exception e) {
			 System.out.println("error"+e.getMessage());
		 }
		 return count;
	}
	int deletePetDetails(int id) {
		int count=0;
		 try {
			 PreparedStatement pst=getConnection().prepareStatement("delete from pet where petId=?");
			 
			 
			 
			 pst.setInt(1, id);
			 
			count= pst.executeUpdate();
			if(count>0) {
				System.out.println("Deleted");
			}
			else {
				System.out.println("ID does not exist");
			}
			
		 }catch(Exception e) {
			 System.out.println("error"+e.getMessage());
		 }
		return count;
	}
	boolean updatePetPriceAndVaccinationStatus(int petId,double price, boolean isVaccinated) {
		
		Pet p=new Pet();
		int count=0;
		 try {
			 PreparedStatement pst=getConnection().prepareStatement("update pet set price=?,isVaccinated=? where petId=?");
			 
			 pst.setDouble(1, price);
			 char vacc;
			 if(isVaccinated==true) {
				 vacc = 'y';
			 } else {
				 vacc = 'n';
			 }
			 pst.setString(2, String.valueOf(vacc));
			 
			 pst.setInt(3, petId);
			 
			count= pst.executeUpdate();
			if(count>0) {
				System.out.println("Updated");
			}
			else {
				System.out.println("ID not found");
			}
			
		 }catch(Exception e) {
			 System.out.println("error"+e.getMessage());
		 }
		 if(count!=0)
			 return true;
		 return false;
		
	}
	List<Pet> showAllPets() {
		
		List<Pet> pets=new ArrayList<Pet>();
		try {
			PreparedStatement pst=getConnection().prepareStatement("Select * from pet");
			ResultSet count=pst.executeQuery();
			while(count.next()) {
				int ID=count.getInt(1);
				String category=count.getString(2);
				String type=count.getString(3);
				String color=count.getString(4);
				int age=count.getInt(5);
				double price=count.getDouble(6);
				char vcc=count.getString(7).charAt(0);
				boolean isVac;
				if(vcc=='y')
					isVac=true;
				else
					isVac=false;
				String foodHabits=count.getString(8);
				Pet p=new Pet(ID,category,type,color,age,price,isVac,foodHabits);
				pets.add(p);
					
			}
		}catch(Exception e) {
			System.out.println("error4"+e.getMessage());
		}
		return pets;
	}
	int countPetsByCategory(String petCategory) {
		int t=0;
		Statement stmt;
		ResultSet rs;
		 try {
			 PreparedStatement pst=getConnection().prepareStatement("select count(petId) from pet where petCategory=? ");
			 
			 pst.setString(1, petCategory);
			 ResultSet count=pst.executeQuery();
			 while(count.next()) {
			 t=count.getInt(1);
			 }
			
		 }catch(Exception e) {
			 System.out.println("error"+e.getMessage());
		 }
		 return t;
	}
	List searchByPrice(double minPrice,double maxPrice) {
		List<Pet> pets=new ArrayList<Pet>();
		 try {
			 PreparedStatement pst=getConnection().prepareStatement("select * from pet where price between ? and ? ");
			 
			 pst.setDouble(1, minPrice);
			 pst.setDouble(2, maxPrice);
			 ResultSet count=pst.executeQuery();
				while(count.next()) {
					int ID=count.getInt(1);
					String category=count.getString(2);
					String type=count.getString(3);
					String color=count.getString(4);
					int age=count.getInt(5);
					double price=count.getDouble(6);
					char vcc=count.getString(7).charAt(0);
					boolean isVac;
					if(vcc=='y')
						isVac=true;
					else
						isVac=false;
					String foodHabits=count.getString(8);
					Pet p=new Pet(ID,category,type,color,age,price,isVac,foodHabits);
					pets.add(p);
						
				}
			}catch(Exception e) {
				System.out.println("error6"+e.getMessage());
			}
			return pets;
			
		 
	}
	int countByVaccinationStatusForPetType(boolean isVaccinated,String petType) {
		int t=0;
		 try {
			 char vcc;
			 if(isVaccinated==true)
				 vcc='y';
			 else
				 vcc='n';
			 PreparedStatement pst=getConnection().prepareStatement("select count(petId) from pet where isVaccinated=?and petType=?");
			 pst.setString(1, String.valueOf(vcc));
			 pst.setString(2, petType);
			 
			 ResultSet count=pst.executeQuery();
			 while(count.next()) {
			 t=count.getInt(1);
			 }
			 
			
		 }catch(Exception e) {
			 System.out.println("error7"+e.getMessage());
		 }
		 return t;

		
	}
}

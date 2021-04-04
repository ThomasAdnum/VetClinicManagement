import java.util.*;

public class Clinic 
{	

	private Doctor doctor1, doctor2;
	private Pet pet1, pet2, pet3, pet4;

	private void run(){

		doctor1 = null;
		doctor2 = null;
		pet1 = null;
		pet2 = null;
		pet3 = null;
		pet4 = null;

	}
	//This method should control the flow of the program 
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		Clinic clinic = new Clinic();
    		clinic.run();
			
			int option;
			String addDoctor, addPet, deleteDoctor, deletePet, listDoctor, listPet, assignedPet, assignDoctor, analysePet;

		do {
			System.out.println("add a Doctor: 1 \n add a Pet: 2 \n delete a Doctor: 3 \n delete a Pet: 4 \n show a list of Doctors: 5 \n show a list of Pets: 6 \n show Pets assigned to Doctors: 7 \n assign Doctor to a Pet: 8 \n analyse a Pet: 9 \n Exit menu: 10");
			option = console.nextInt();
			switch(option)
			{
				case 1: addDoctor();
						break;
				
				case 2: addPet();
						break;
				
				case 3: deleteDoctor();
						break;
				
				case 4: deletePet();
						break;
				
				case 5: listDoctor();
						break;
				
				case 6: listPet();
						break;
				
				case 7: assignedPet();
						break;
				
				case 8: assignedDoctor();
						break;
				
				case 9: analysePet();
						break;
				case 10: break;
				default: System.out.println("invalid option");
			}
		}
			while (option!=10);
	}		
		public static void addDoctor(Clinic clinic){
			if (doctor1==null || doctor2==null){
				doctor = new Doctor();
				System.out.println("What is the Doctors name? "+clinic.getName());
				System.out.println("What is the Doctors specialisation? "+clinic.getSpecialisation());
			}
				if (doctor1==null){	
					return doctor1=doctor;
				}
				else{	
				return doctor2=doctor;
				}
			else
			{
				System.out.println("No space for a new doctor");
			}
		}
	}
}
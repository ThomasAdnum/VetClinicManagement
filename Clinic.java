/* SENG1110 Programming Assignment 1
Due Date: 30th April 2021
Authors: Tom Adnum c and Teigen Carter c3303109
Description: This program is a veterinary clinic management system that allows
the user to manage doctors and pets in a vet clinic.
*/

import java.util.*;

public class Clinic {

    private Doctor doctor1, doctor2;
    private Pet pet1, pet2, pet3, pet4;
    Scanner console = new Scanner(System.in);
    int numDoc;
    // String totalpets;
    int numPets;// move to top, for global veriable

    public Clinic() {// constructor
        doctor1 = null;
        doctor2 = null;
        pet1 = null;
        pet2 = null;
        pet3 = null;
        pet4 = null;
/*all instance variables are set to null initially. Their output will change depending on the input
that the user enters. This input will be changes using the methods of Set and Get in the Pet and Doctor
classes. */

        numDoc = 0;

    }

    public void run() { 
        int option;
        String addDoctor, addPet, deleteDoctor, deletePet, listDoctor, 
        listPet, assignedPet, assignDoctor, analysePet; // initialises Strings that will be used for the menu and functionalities 

        do {
            System.out.println( //this menu will be printed as soon as the program is opened. The user will input the corresponding number with their option.
                    "add a Doctor: 1 \n add a Pet: 2 \n delete a Doctor: 3 \n delete a Pet: 4 \n show a list of Doctors: 5 \n show a list of Pets: 6 \n show Pets assigned to Doctors: 7 \n assign Doctor to a Pet: 8 \n analyse a Pet: 9 \n Exit menu: 10");
            option = console.nextInt();
            console.nextLine();
            switch (option) { //switch loop is used to allow the user to choose and option and when they are finished, it returns them to the menu to choose their next option.
            case 1:
                addDoctor();
                addDoctor(); //function allows two doctors to be input
                break;

            case 2:
                addPet(); //function allows up to 4 pets to be input
                break;

            case 3:
                deleteDoctor();//function allows any of the 2 doctors to be deleted from the system
                break;

            case 4:
                deletePet();//function alows any of the 4 pets to be deleted from the system
                break;

            case 5:
                listDoctor();//function displays a list of doctors in the system
                break;

            case 6:
                listPet();//function displays a list of Pets in the system
                break;

            case 7:
                listAssignedPets();//function displays a list of pets that have been assigned to a doctor
                break;

            /*case 8:
                assignDoctor();//function allows for pets to be assigned to a doctor
                break;

            case 9:
                analysePet();//function allows user to analyse their pet
                break;*/

            case 10:
                break;//option 10 will break the loop and exit the menu
            default:
                System.out.println("invalid option");//if the wrong number is entered, it will display as an error

            }
        } while (option != 10);

    }
    /*
     * An easy way of managing the doctors to have them in order, doctor1 is in
     * front of doctor2. If both are used and doctor1 was deleted doctor2 would move
     * in its place. Also added a variable called numDoc which just keeps count of
     * the number of doctors. If numDoc was 1, we know that the first doctor is
     * taken and the second is free
     */

    public void addDoctor() {
        if (numDoc != 2) {// There is space for another doctor
            // Gets the name of the doctor
            String message = (numDoc == 1) ? "second" : "first";

            System.out.println("What is the name for the " + message + " doctor?");
            String newName = console.nextLine();// name of doctor

            if (numDoc == 1) {
                if (newName.equalsIgnoreCase(doctor1.getName())) {
                    System.out.println("Cannot be same name as doctor one, enter different name? ");
                    newName = console.nextLine();
                }
            }

            // Gets the specialist of the doctor
            System.out.println("What is the Doctors specialisation? ");
            String newSpecialist = console.nextLine();

            // Checking the specialist, can only be cat or dog
            while (!(newSpecialist).equalsIgnoreCase("dog") && !newSpecialist.equalsIgnoreCase("cat")) {
                System.out.println("Can only be cat or dog");
                newSpecialist = console.nextLine();
            }

            // Sets data to correct doctor
            if (numDoc == 0) {
                doctor1 = new Doctor();
                doctor1.setData(newName, newSpecialist);// setData is a function inside doctor which just assigns

            } else {
                doctor2 = new Doctor();
                doctor2.setData(newName, newSpecialist);
            }
            numDoc++;
        } else {
            System.out.println("No space for a new doctor");
        }
    }
    // This method should control the flow of the program

    public void addPet() {
        // check if you're able to add another pet
        // get and check the data and assign it to the pet

        String newName;
        String newType;
        String newSize;
        int newAge;
        int newWeight;

        System.out.println("Enter total pets: ");
        int totalpets = console.nextInt();// check this, that when added to numPets doesn't go over the limit
        while (totalpets + numPets > 4) {
            System.out.println("Please enter a value 4 or less: ");
            totalpets = console.nextInt();// check this, that when added to numPets doesn't go over the limit
        }
        console.nextLine();
        for (int i = 1; i < totalpets + 1; i++) {
            System.out.println("Please enter the pets name: ");
            newName = console.nextLine();
            System.out.println("Please enter the pets type: ");
            newType = console.nextLine();
            System.out.println("Please enter the pets size (s, m, l): ");
            newSize = console.nextLine();
            System.out.println("Please enter the pets age: ");
            newAge = console.nextInt();
            System.out.println("Please enter the pets weight: ");
            newWeight = console.nextInt();
            console.nextLine();

            switch (i) {
            case 1:
                pet1 = new Pet();
                pet1.setData(newName, newType, newSize, newAge, newWeight);
                break;

            case 2:
                pet2 = new Pet();
                pet2.setData(newName, newType, newSize, newAge, newWeight);
                break;

            case 3:
                pet3 = new Pet();
                pet3.setData(newName, newType, newSize, newAge, newWeight);
                break;

            case 4:
                pet4 = new Pet();
                pet4.setData(newName, newType, newSize, newAge, newWeight);
                break;
            }
        }
    }

    public void deleteDoctor() {
        String newdoctor;
        System.out.println("Please enter the name of the Doctor you want to delete: ");
        newdoctor = console.nextLine();

        if (doctor2 != null && newdoctor.equalsIgnoreCase(doctor2.getName())) {//compares the strings of the name the doctor has been set and the name the user inputs
            doctor2 = null;
            pet2 = null;
            System.out.println("Doctor 2 has been deleted");//wipes the name to null
        } else if (newdoctor.equalsIgnoreCase(doctor1.getName())) {
            doctor1 = null;
            pet1 = null;
            System.out.println("Doctor 1 has been deleted");//wipes the name to null
        } else {
            System.out.println("There is no doctor name that matches.");//if the name doesn't match, error message
            System.out.println("Please try again: ");
            deleteDoctor();//re-enter the name
        }

    }

    public void deletePet() {
        String newpet;
        System.out.println("Please enter the name of the Pet you want to delete: ");
        newpet = console.nextLine();

        if (pet4 != null && newpet.equalsIgnoreCase(pet4.getName())) {
            pet4 = null;
            System.out.println("Pet 4 has been deleted");
        } else if (pet3 != null && newpet.equalsIgnoreCase(pet3.getName())) {
            pet3 = null;
            System.out.println("Pet 3 has been deleted");
        } else if (pet2 != null && newpet.equalsIgnoreCase(pet2.getName())) {
            pet2 = null;
            System.out.println("Pet 2 has been deleted");
        } else if (newpet.equalsIgnoreCase(pet1.getName())) {
            pet1 = null;
            System.out.println("Pet 1 has been deleted");
        } else {
            System.out.println("There is no pet name that matches.");
            System.out.println("Please try again: ");
            deletePet();
        }

    }

    public void listDoctor() {
        if (doctor1 == null) {
            System.out.println("No Doctors.");
        }

        else {
            System.out
                    .println("Doctor: " + doctor1.getName() + " | " + "Specialisation: " + doctor1.getSpecialisation());
        }

        if (doctor2 == null) {
            System.out.println("No Doctors.");
        }

        else {
            System.out
                    .println("Doctor: " + doctor2.getName() + " | " + "Specialisation: " + doctor2.getSpecialisation());
        }
    }

    public void listPet() {
        if (pet1 == null) {
            System.out.println("No Pets.");
        }

        else {
            System.out.println("Pet: " + pet1.getName() + " | " + "Size: " + pet1.getSize() + " | " + "Weight: "
                    + pet1.getWeight() + " | " + "Type: " + pet1.getType() + " | " + "Age: " + pet1.getAge() + " | "
                    + "Doctor: " + pet1.getDoctor());
        }
        if (pet2 == null) {
            System.out.println("No Pets.");
        }

        else {
            System.out.println("Pet: " + pet2.getName() + " | " + "Size: " + pet2.getSize() + " | " + "Weight: "
                    + pet2.getWeight() + " | " + "Type: " + pet2.getType() + " | " + "Age: " + pet2.getAge() + " | "
                    + "Doctor: " + pet2.getDoctor());
        }

        if (pet3 == null) {
            System.out.println("No Pets.");
        }

        else {
            System.out.println("Pet: " + pet3.getName() + " | " + "Size: " + pet3.getSize() + " | " + "Weight: "
                    + pet3.getWeight() + " | " + "Type: " + pet3.getType() + " | " + "Age: " + pet3.getAge() + " | "
                    + "Doctor: " + pet3.getDoctor());
        }
        if (pet4 == null) {
            System.out.println("No Pets.");
        }

        else {
            System.out.println("Pet: " + pet4.getName() + " | " + "Size: " + pet4.getSize() + " | " + "Weight: "
                    + pet4.getWeight() + " | " + "Type: " + pet4.getType() + " | " + "Age: " + pet4.getAge() + " | "
                    + "Doctor: " + pet4.getDoctor());
        }
    }

    public void listAssignedPets() {
        String doctorName;
        System.out.println("Enter the name of the doctor: ");
        doctorName = console.nextLine();

        String petList = "";
        if (doctorName.equals(pet1.getName())) {
            petList += pet1.getName();
        }
        if (doctorName.equals(pet2.getName())) {
            if(petList.length() > 0) {
                petList += ", ";
            }
        }
        if (doctorName.equals(pet3.getName())) {
            if(petList.length() > 0) {
                petList += ", ";
            }
            
        }
        if (doctorName.equals(pet4.getName())) {
            if(petList.length() > 0) {
                petList += ", ";
            }
        }

        if (petList.length() > 0) {
            System.out.println("Pets assigned to " + doctorName + " are: " + petList);
        }

        System.out.println("No pets assigned to doctor " + doctorName);

        if(!doctorName.equals(doctor1.getName()) || !doctorName.equals(doctor2.getName())){
            System.out.println("No Doctor with that name.");
        }
        if(doctor1 == null || doctor2 == null){
            System.out.println("No doctors.");
        }


       
    }


    public void assignDoctor() {
        String petName;
        String doctorName;
        System.out.println("Enter name of pet: ");
        petName = console.nextLine();
        System.out.println("Please enter name of Doctor: ");
        doctorName = console.nextLine();

        if(!doctorName.equals(doctor1.getName()) || !doctorName.equals(doctor2.getName())){
            System.out.println("Doctor does not exist.");
        }
        if(!petName.equals(pet1.getName()) || !petName.equals(pet2.getName())|| !petName.equals(pet3.getName())|| !petName.equals(pet4.getName())){
            System.out.println("Pet does not exist.");
        }
       
        Pet petRef; 
        Doctor docRef;

        switch (petName) {
            case pet1.getName():
                petRef = pet1;
                break;
            case pet2.getName():
                petRef = pet2;
                break;
            case pet3.getName():
                petRef = pet3;
                break;
            case pet4.getName():
                petRef = pet4;
                break;

            default:
                break;
        }

        switch (doctorName) {
            case doctor1.getName():
                docRef = doctor1;
            break;
            case doctor2.getName():
                docRef = doctor2;
            break;

            default:
            break;

        }

        //similar reference for doctor
        if(petRef.getDoctor() != null){
            if (petRef.getDoctor().equalsIgnoreCase(doctorName)) {
                System.out.println("Already assigned to this doctor");
            }
            else {
                System.out.println("Doctor " + docRef.getName() + " is assigned to this pet, are you sure you want to change this? (y/n)");
                confirm = console.nextLine();
            }
        }

        if (petRef.getSpecialisation().equalsIgnoreCase(doctor1.getSpecialisation()) || petRef.getSpecialisation().equalsIgnoreCase(doctor2.getSpecialisation())) {
            System.out.println("Doctor has the wrong specialisation for this Pet.");
        }
        

    }

    public void analysePet() {
        String petName;
        System.out.println("Enter name of pet: ");
        petName = console.nextLine();
// check if doctor and pet exist
//         
        Pet petRef; 
        switch (petName) {
            case pet1.getName():
                petRef = pet1;
                break;
            case pet2.getName():
                petRef = pet2;
                break;
            case pet3.getName():
                petRef = pet3;
                break;
            case pet4.getName():
                petRef = pet4;
                break;
            default:
                break;
        }

    }

    /*
     * else { pet1 = null; } if (newpet != pet2.getName()) {
     * System.out.println("There are no previous names that match."); } else { pet2
     * = null; } if (newpet != pet3.getName()) {
     * System.out.println("There are no previous names that match."); } else { pet3
     * = null; } if (newpet != pet4.getName()) {
     * System.out.println("There are no previous names that match."); } else { pet4
     * = null; }
     */
    public static void main(String[] args) {
        // Scanner console = new Scanner(System.in);
        Clinic clinic = new Clinic();
        clinic.run();
    }
}
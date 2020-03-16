import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PetsClinic {
    Map <Integer, PetsClinic> petsClinicRegistration = new TreeMap<>();

    private Client client;
    private Pet pet;

    public PetsClinic (){
    }

    public PetsClinic (Client client, Pet pet){
        this.client = client;
        this.pet = pet;
    }

    // 1 case:
    public void addNewClient (){
        int cardNumber = petsClinicRegistration.size();
        PetsClinic petsClinic = new PetsClinic(new Client("Tatiana"), new Pet("cat", "Varya"));
        PetsClinic petsClinic1 = new PetsClinic(new Client("Daria"), new Pet("dog", "Dusya"));

//        PetsClinic petsClinic = new PetsClinic (new Client(readFromScreen("Enter full name of client:")),
//                new Pet(readFromScreen("Enter type of pet:"), readFromScreen("Enter  pet name:")));
        petsClinicRegistration.put(++cardNumber,petsClinic);
        petsClinicRegistration.put(++cardNumber, petsClinic1);
        System.out.println("Client was added");
    }

    public static String readFromScreen (String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(input);
        return scanner.nextLine();
    }

    // 2 case:
    public void findClientByName (){
        String findName = readFromScreen("Enter the name you are looking for:");
        for (Map.Entry e : petsClinicRegistration.entrySet()) {
            if (findName.equals(e.getValue())) {
                System.out.println("Find " + findName + client.getFullName());
            }
            else {
                System.out.println("Not Found");
            }
        }
    }

    // 3 case:
    public void findClientByPetName (){

    }

    // 4 case:
    public void findClientByCardNumber (){

    }

    // 8 case:
    public void viewAllClients (){
        for (Map.Entry e : petsClinicRegistration.entrySet()) {
            System.out.println("Card number: " + e.getKey()+". \n"+ e.getValue());
        }
    }

    @Override
    public String toString() {
        return "Client's name is '" + client.getFullName() + '\'' +
                ". Pet: " + "pet type = '" +  pet.getPetType() + '\'' +
                ", pet name = '" + pet.getPetName() + '\'';
    }
}

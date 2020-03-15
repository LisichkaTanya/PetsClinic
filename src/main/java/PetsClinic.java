import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PetsClinic {
    Map <Integer, Client> petsClinicRegistration = new TreeMap<>();
    public static String addClientData (String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(input);
        return scanner.nextLine();
    }

    public void viewAllClients (){
        for (Map.Entry e : petsClinicRegistration.entrySet()) {
            System.out.println("Card number: " + e.getKey()+". "+ e.getValue());
        }
    }

    public void addNewClient (){
        int cardNumber = petsClinicRegistration.size();
        System.out.println();
        Client client = new Client(addClientData("Enter full name of client:"),
                new Pet(addClientData("Enter type of pet:"), addClientData("Enter  pet name:")));
        petsClinicRegistration.put(++cardNumber,client);
    }

    public void findClientByName (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name you are looking for:");
        petsClinicRegistration.get(scanner.nextLine());
    }

    public void findClientByPetName (){

    }

    public void findClientByCardNumber (){

    }

    @Override
    public String toString() {
        return "PetsClinic \n" + petsClinicRegistration;
    }
}

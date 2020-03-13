import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PetsClinic {
    public static void main(String[] args) {
        PetsClinic petsClinic = new PetsClinic();
        String exitClinic = "no";
        while (exitClinic.equals("no")) {
            System.out.println("Choose the operation. Enter the appropriate number: \n" +
                    "1 - add new client \n" +
                    "2 - find a client by full name \n" +
                    "3 - find a client by pet name \n" +
                    "4 - fins a client by card number \n" +
                    "5 - delete a client \n" +
                    "6 - rename a client \n" +
                    "7 - rename a pet \n" +
                    "8 - view all clients");

            Scanner scanner = new Scanner(System.in);
            int operation = scanner.nextInt();

            switch (operation) {
                case 1: petsClinic.addNewClient();
                    break;
            }
            System.out.println("Do you want to exit clinic? Enter 'yes' or 'no':");
            if (scanner.nextLine().equals("no")){
                continue;
            }
            else exitClinic = "yes";
            scanner.close();
        }



    }
    public void addNewClient (){
        Map <Integer, Client> petsClinicRegistration = new TreeMap<>();
        int cardNumber = petsClinicRegistration.size();
        System.out.println();
        Client client = new Client(addClientData("Enter full name of client:"),
                new Pet(addClientData("Enter type of pet:"), addClientData("Enter  pet name:")));
        petsClinicRegistration.put(cardNumber++,client);
    }
    public static String addClientData (String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(input);
        return scanner.nextLine();
    }
}

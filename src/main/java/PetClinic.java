import java.io.*;
import java.util.*;

/**
 * This class include array  which collects persons and their pets and give the new client a card number
 * here implemented all methods (add new client, find, rename client or his pet, delete client from list, view all list)
 */
public class PetClinic implements Serializable {
    List<Client> arrayPetsClinicRegistration = new ArrayList<>();

    /**
     * This method to communicate via the screen
     * @param input - String which tell to user what he need to do
     * @return - will return string what was reading from screen
     */
    public static String readFromScreen (String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(input);
        return scanner.nextLine();
    }

    // 1 case:
    public void addNewClient (){
        int cardNumber = arrayPetsClinicRegistration.size() + 1;
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++){
            if (arrayPetsClinicRegistration.get(i).getCardNumber() >= arrayPetsClinicRegistration.size()){
                cardNumber = arrayPetsClinicRegistration.get(i).getCardNumber() + 1;
            }
        }
        Client client = new Client (cardNumber, new Person(readFromScreen("Enter full name of client:")),
                new Pet(readFromScreen("Enter type of pet:"), readFromScreen("Enter  pet name:")));
        if (arrayPetsClinicRegistration.size() == 0) {
            arrayPetsClinicRegistration.add(client);
            System.out.println("Client was added");
            return;
        }
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (client.getPerson().getFullName().equals(arrayPetsClinicRegistration.get(i).getPerson().getFullName())) {
                System.out.println("This person is already in the clinic's list " + arrayPetsClinicRegistration.get(i));
                return;
            }
            else {
                arrayPetsClinicRegistration.add(client);
            }
        }
        System.out.println("Client was added");

    }

    // 2 case:
    public void findClientByName (){
        String findName = readFromScreen("Enter the name you are looking for:");
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findName.equals(arrayPetsClinicRegistration.get(i).getPerson().getFullName())) {
                System.out.println("Find " + arrayPetsClinicRegistration.get(i));
                return;
            }
        }
        System.out.println(findName + " is not found.");
    }

    // 3 case:
    public void findClientByPetName (){
        String findPetName = readFromScreen("Enter the pet name you are looking for:");
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findPetName.equals(arrayPetsClinicRegistration.get(i).getPet().getPetName())) {
                System.out.println("Find " + arrayPetsClinicRegistration.get(i));
                return;
            }
        }
        System.out.println(findPetName + " is not found.");
    }

    // 4 case:
    public void findClientByCardNumber (){
        int findCardNumber = Integer.parseInt(readFromScreen("Enter the card number you are looking for:"));
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findCardNumber == (arrayPetsClinicRegistration.get(i).getCardNumber())) {
                System.out.println("Find " + arrayPetsClinicRegistration.get(i));
                return;
            }
        }
        System.out.println(findCardNumber + " is not found.");
    }

    // 5 case:
    public void deleteClient (){
        String deleteClientByName = readFromScreen("Enter name of client which you want to delete:");
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (deleteClientByName.equals(arrayPetsClinicRegistration.get(i).getPerson().getFullName())) {
                arrayPetsClinicRegistration.remove(i);
                System.out.println("Client " + deleteClientByName + " was remove from Clinic. ");
                return;
            }
        }
        System.out.println(deleteClientByName + " is not found.");
    }

    // 6 case:
    public void renameClient (){
        String findName = readFromScreen("Enter the name you are looking for rename:");
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findName.equals(arrayPetsClinicRegistration.get(i).getPerson().getFullName())) {
                System.out.println("Successful find. " + arrayPetsClinicRegistration.get(i));
                arrayPetsClinicRegistration.get(i).getPerson().setFullName(readFromScreen("Enter new name for client:"));
                System.out.println("Successful rename " + arrayPetsClinicRegistration.get(i));
                return;
            }
        }
        System.out.println(findName + " is not found.");
    }

    // 7 case:
    public void renamePet (){
        String findPetName = readFromScreen("Enter the pet name you are looking for rename:");
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findPetName.equals(arrayPetsClinicRegistration.get(i).getPet().getPetName())) {
                System.out.println("Successful find. " + arrayPetsClinicRegistration.get(i));
                arrayPetsClinicRegistration.get(i).getPet().setPetName(readFromScreen("Enter new pet name:"));
                System.out.println("Successful rename pet " + arrayPetsClinicRegistration.get(i));
                return;
            }
        }
        System.out.println(findPetName + " is not found.");
    }

    // 8 case:
    public void viewAllClients (){
        if (arrayPetsClinicRegistration.size()== 0){
            System.out.println("No clients in clinic");
            return;
        }

        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            System.out.println(arrayPetsClinicRegistration.get(i));
        }
    }

    @Override
    public String toString() {
        return "PetClinic \n" +
                arrayPetsClinicRegistration;
    }

    // 100 case: add clients to test
    public void addTestClient (){
        Client client1 = new Client(1, new Person("Tatiana"), new Pet("cat", "Varya"));
        Client client2 = new Client(2, new Person("Daria"), new Pet("hamster", "Pushok"));
        Client client3 = new Client(3, new Person("Galina"), new Pet("dog", "Dusya"));
        arrayPetsClinicRegistration.add(client1);
        arrayPetsClinicRegistration.add(client2);
        arrayPetsClinicRegistration.add(client3);
    }

    public List<Client> getArrayPetsClinicRegistration() {
        return arrayPetsClinicRegistration;
    }
}

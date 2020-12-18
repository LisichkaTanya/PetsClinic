import java.io.*;
import java.util.*;

/**
 * This class include array  which collects persons and their pets and give the new client a card number
 * here implemented all methods (add new client, find, rename client or his pet, delete client from list, view all list)
 */
public class PetClinic implements Serializable {
    List<Client> arrayPetsClinicRegistration = new ArrayList<>();

    // 1 case:
    public void addNewClient(String personName, String petType, String petName) {
        int cardNumber = arrayPetsClinicRegistration.size() + 1;
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (arrayPetsClinicRegistration.get(i).getCardNumber() >= arrayPetsClinicRegistration.size()) {
                cardNumber = arrayPetsClinicRegistration.get(i).getCardNumber() + 1;
            }
        }
        Client client = new Client(cardNumber, new Person(personName),
                new Pet(petType, petName));
        if (arrayPetsClinicRegistration.size() == 0) {
            arrayPetsClinicRegistration.add(client);
            System.out.println("Client was added. " + client);
            return;
        }
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (client.getPerson().getFullName().equals(arrayPetsClinicRegistration.get(i).getPerson().getFullName())) {
                System.out.println("This person is already in the clinic's list " + arrayPetsClinicRegistration.get(i));
                return;
            } else {
                arrayPetsClinicRegistration.add(client);
                System.out.println("Client was added. " + client);
                return;
            }
        }
    }

    // 2 case:
    public Client findClientByName(String findName) {
        Client findClient = null;
        for (Client client : arrayPetsClinicRegistration) {
            if (findName.equals(client.getPerson().getFullName())) {
                System.out.println("Find " + client);
                findClient = client;
                return findClient;
            }
        }
        System.out.println(findName + " is not found.");
        return findClient;
    }

    // 3 case:
    public Client findClientByPetName(String findPetName) {
        Client findClient = null;
        for (Client client : arrayPetsClinicRegistration) {
            if (findPetName.equals(client.getPet().getPetName())) {
                System.out.println("Find " + client);
                findClient = client;
                return findClient;
            }
        }
        System.out.println(findPetName + " is not found.");
        return findClient;
    }

    // 4 case:
    public Client findClientByCardNumber(String findCardNumber) {
        Client findClient = null;
        for (Client client : arrayPetsClinicRegistration) {
            if (Integer.parseInt(findCardNumber) == (client.getCardNumber())) {
                System.out.println("Find " + client);
                findClient = client;
                return findClient;
            }
        }
        System.out.println(findCardNumber + " is not found.");
        return findClient;
    }

    // 5 case:
    public void deleteClient(String deleteClientByName) {
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
    public void renameClient(String findName, String newName) {
        for (Client client : arrayPetsClinicRegistration) {
            if (findName.equals(client.getPerson().getFullName())) {
                System.out.println("Successful find. " + client);
                client.getPerson().setFullName(newName);
                System.out.println("Successful rename " + client);
                return;
            }
        }
        System.out.println(findName + " is not found.");
    }

    // 7 case:
    public void renamePet(String findPetName, String newPetName) {
        for (Client client : arrayPetsClinicRegistration) {
            if (findPetName.equals(client.getPet().getPetName())) {
                System.out.println("Successful find. " + client);
                client.getPet().setPetName(newPetName);
                System.out.println("Successful rename pet " + client);
                return;
            }
        }
        System.out.println(findPetName + " is not found.");
    }

    // 8 case:
    public void viewAllClients() {
        if (arrayPetsClinicRegistration.size() == 0) {
            System.out.println("No clients in clinic");
            return;
        }

        for (Client client : arrayPetsClinicRegistration) {
            System.out.println(client);
        }
    }

    @Override
    public String toString() {
        return "PetClinic \n" +
                arrayPetsClinicRegistration;
    }

    public List<Client> getArrayPetsClinicRegistration() {
        return arrayPetsClinicRegistration;
    }
}

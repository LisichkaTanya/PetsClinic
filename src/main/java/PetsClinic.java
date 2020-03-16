import java.util.*;

public class PetsClinic {
    List<PetsClinic> arrayPetsClinicRegistration = new ArrayList<>();

    private Client client;
    private Pet pet;
    private int cardNumber;

    public PetsClinic (){
    }

    public PetsClinic (int cardNumber, Client client, Pet pet){
        this.client = client;
        this.pet = pet;
        this.cardNumber = cardNumber;
    }

    public static String readFromScreen (String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(input);
        return scanner.nextLine();
    }

    // 1 case:
    public void addNewClient (){
        cardNumber = arrayPetsClinicRegistration.size() + 1;
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++){
            if (arrayPetsClinicRegistration.get(i).getCardNumber() >= arrayPetsClinicRegistration.size()){
                cardNumber = arrayPetsClinicRegistration.get(i).getCardNumber() + 1;
            }
        }
        PetsClinic petsClinic = new PetsClinic (cardNumber, new Client(readFromScreen("Enter full name of client:")),
                new Pet(readFromScreen("Enter type of pet:"), readFromScreen("Enter  pet name:")));
        arrayPetsClinicRegistration.add (petsClinic);
        System.out.println("Client was added");
    }

    // 2 case:
    public void findClientByName (){
        String findName = readFromScreen("Enter the name you are looking for:");
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findName.equals(arrayPetsClinicRegistration.get(i).getClient().getFullName())) {
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
            if (deleteClientByName.equals(arrayPetsClinicRegistration.get(i).getClient().getFullName())) {
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
            if (findName.equals(arrayPetsClinicRegistration.get(i).getClient().getFullName())) {
                System.out.println("Successful find. " + arrayPetsClinicRegistration.get(i));
                arrayPetsClinicRegistration.get(i).client.setFullName(readFromScreen("Enter new name for client:"));
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
                arrayPetsClinicRegistration.get(i).pet.setPetName(readFromScreen("Enter new pet name:"));
                System.out.println("Successful rename pet " + arrayPetsClinicRegistration.get(i));
                return;
            }
        }
        System.out.println(findPetName + " is not found.");
    }

    // 8 case:
    public void viewAllClients (){
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            System.out.println(arrayPetsClinicRegistration.get(i));
        }
    }

    public Client getClient() {
        return client;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "Card number: " + getCardNumber() + ". " +
                "Client's name is '" + client.getFullName() + '\'' +
                ". Pet: " + "pet type = '" +  pet.getPetType() + '\'' +
                ", pet name = '" + pet.getPetName() + '\'';
    }
}

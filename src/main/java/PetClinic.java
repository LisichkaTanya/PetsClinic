import java.io.*;
import java.util.*;

public class PetClinic implements Serializable {

    List<Client> arrayPetsClinicRegistration = new ArrayList<>();

    // This method read text from screen
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
        arrayPetsClinicRegistration.add (client);
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
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            System.out.println(arrayPetsClinicRegistration.get(i));
        }
    }

    // 9 case: Write registration list in file
    public void writeInFile () throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("RegistrationClientsOfPetClinic.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //oos.writeInt(arrayPetsClinicRegistration.size());
            for (Client client :arrayPetsClinicRegistration) {
                oos.writeObject(client);
            }
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    // Read registration list from file
    public void readFromFile () throws IOException {
        try {
            FileInputStream fis = new FileInputStream("RegistrationClientsOfPetClinic.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
//            int clientsCount = ois.readInt();
//            for (int i =0; i < clientsCount; i++){
//                List<PetsClinic> array = (ArrayList)ois.readObject();
//            }
            arrayPetsClinicRegistration = (ArrayList<Client>) ois.readObject();
            ois.close();
        }

        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "PetClinic{" +
                "arrayPetsClinicRegistration=" + arrayPetsClinicRegistration +
                '}';
    }

    // test
    public void addTestClient (){
        Client client1 = new Client(1, new Person("Tatiana"), new Pet("cat", "Varya"));
        Client client2 = new Client(2, new Person("Daria"), new Pet("hamster", "Pushok"));
        Client client3 = new Client(3, new Person("Galina"), new Pet("dog", "Dusya"));
        arrayPetsClinicRegistration.add(client1);
        arrayPetsClinicRegistration.add(client2);
        arrayPetsClinicRegistration.add(client3);
    }
}

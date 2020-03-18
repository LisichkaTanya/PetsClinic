import java.io.*;
import java.util.ArrayList;

/**
 * @author LisichkaTanya
 * @since 12.03.2020
 * This class include method main, point of enter program
 * Here are: start work on the clinic; choose operations to do
 */
public class WorkClinic {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PetClinic petClinic;
        petClinic = readFromFile();
        String exitFromClinic = "no";

        while (exitFromClinic.equals("no")) {
            System.out.println("Choose the operation. Enter the appropriate number: \n" +
                    "1 - add new client \n" +
                    "2 - find a client by full name \n" +
                    "3 - find a client by pet name \n" +
                    "4 - find a client by card number \n" +
                    "5 - delete a client \n" +
                    "6 - rename a client \n" +
                    "7 - rename a pet \n" +
                    "8 - view all clients\n" +
                    "9 - exit the clinic");

            int operation = Integer.parseInt(reader.readLine());

            switch (operation) {
                case 1: petClinic.addNewClient();
                    break;
                case 2: petClinic.findClientByName();
                    break;
                case 3: petClinic.findClientByPetName();
                    break;
                case 4: petClinic.findClientByCardNumber();
                    break;
                case 5: petClinic.deleteClient();
                    break;
                case 6 : petClinic.renameClient();
                    break;
                case 7 : petClinic.renamePet();
                    break;
                case 8: petClinic.viewAllClients();
                    break;
                case 9: exitFromClinic = "yes";
                    writeInFile(petClinic);
                    break;

                    //test write in file
                case 10: readFromFile();
                    break;
                    // test add new client
                case 11: petClinic.addTestClient();
                    break;
            }
        }
    }
    // 9 case: Write registration list in file
    public static void writeInFile (PetClinic petClinic) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("RegistrationClientsOfPetClinic.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(petClinic);
            //oos.writeInt(arrayPetsClinicRegistration.size());
//            for (Client client : petClinic.getArrayPetsClinicRegistration()) {
//            oos.writeObject(client);
//            }
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    // Read registration list from file
    public static PetClinic readFromFile () throws IOException {
        PetClinic petClinic = null;
        try {
            FileInputStream fis = new FileInputStream("RegistrationClientsOfPetClinic.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
//            int clientsCount = ois.readInt();
//            for (int i =0; i < clientsCount; i++){
//                List<PetsClinic> array = (ArrayList)ois.readObject();
//            }
            petClinic = (PetClinic) ois.readObject();
            ois.close();
        }

        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return petClinic;
    }
}

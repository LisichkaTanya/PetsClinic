import java.io.*;

/**
 * @author LisichkaTanya
 * @since 12.03.2020
 * This class include method main, point of enter program
 * Here are: start work on the clinic; choose operations to do
 */
public class WorkClinic {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PetClinic petClinic = new PetClinic();
        String exitFromClinic = "no";
        //petsClinic.readFromFile();

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
                    petClinic.writeInFile();
                    break;

                    //test write in file
                case 10: petClinic.writeInFile();
                    break;
                    // test add new client
                case 11: petClinic.addTestClient();
                    break;
            }
        }
    }
}

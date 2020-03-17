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
        PetsClinic petsClinic = new PetsClinic();
        String exitFromClinic = "no";
       // petsClinic.readFromFile();

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
                case 1: petsClinic.addNewClient();
                    break;
                case 2: petsClinic.findClientByName();
                    break;
                case 3: petsClinic.findClientByPetName();
                    break;
                case 4: petsClinic.findClientByCardNumber();
                    break;
                case 5: petsClinic.deleteClient();
                    break;
                case 6 : petsClinic.renameClient();
                    break;
                case 7 : petsClinic.renamePet();
                    break;
                case 8: petsClinic.viewAllClients();
                    break;
                case 9: exitFromClinic = "yes";
                    petsClinic.writeInFile();
                    break;
            }
        }
    }
}

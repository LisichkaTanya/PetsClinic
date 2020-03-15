import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkClinic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PetsClinic petsClinic = new PetsClinic();

        while (true) {
            System.out.println("Choose the operation. Enter the appropriate number: \n" +
                    "1 - add new client \n" +
                    "2 - find a client by full name \n" +
                    "3 - find a client by pet name \n" +
                    "4 - fins a client by card number \n" +
                    "5 - delete a client \n" +
                    "6 - rename a client \n" +
                    "7 - rename a pet \n" +
                    "8 - view all clients");

            int operation = Integer.parseInt(reader.readLine());

            switch (operation) {
                case 1: petsClinic.addNewClient();
                    break;
                case 2: petsClinic.findClientByName();
                    break;
                case 8: petsClinic.viewAllClients();
                    break;
            }

            System.out.println("Do you want to exit clinic? Enter 'yes' or 'no':");

            String exitClinic = reader.readLine();
            if (exitClinic.equals("yes")){
                break;
            }
            else{
                continue;
            }
        }
    }
}

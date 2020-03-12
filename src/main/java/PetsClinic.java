import java.util.Map;
import java.util.TreeMap;

public class PetsClinic {
    public static void main(String[] args) {
        Map <Integer, Client> petsClinicRegistration = new TreeMap<>();
        petsClinicRegistration.put(1, new Client("Solomatina Tatiana", "Rijik", "cat" ));
        petsClinicRegistration.put(2, new Client("Solomatona Daria", "Varia", "cat"));

        System.out.println(petsClinicRegistration);
    }
}

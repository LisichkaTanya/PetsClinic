
public class Client {
    private String fullName;
    private Pet pet;

    public Client (String fullName, Pet pet){
        this.fullName = fullName;
        this.pet = pet;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Client's name is '" +
                fullName + '\'' +
                ", client has pet: " + pet;
    }
}

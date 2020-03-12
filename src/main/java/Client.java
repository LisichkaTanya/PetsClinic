
public class Client {
    private String fullName;
    private String petName;
    private String petType;

    public Client (String fullName, String petName, String petType){
        this.fullName = fullName;
        this.petName = petName;
        this.petType = petType;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    @Override
    public String toString() {
        return "Client{" +
                "fullName='" + fullName + '\'' +
                ", petName=" + petName +
                ", petType=" + petType +
                '}';
    }
}

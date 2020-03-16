
public class Client {
    private String fullName;

    public Client (String fullName){
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Client's name is '" +
                fullName + '\'';
    }
}

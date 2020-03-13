public class Pet {
    private String petType;
    private String petName;

    public Pet (String petType, String petName){
        this.petType = petType;
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    public String toString() {
        return "pet type = '" + petType + '\'' +
                ", pet name = '" + petName + '\'';
    }
}

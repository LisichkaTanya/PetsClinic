import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class TestPetClinic {
    private PetClinic testPetClinic;

    @Before
    public void setUp() {
        Client client1 = new Client(1, new Person("Tatiana"), new Pet("cat", "Varya"));
        Client client2 = new Client(2, new Person("Daria"), new Pet("hamster", "Pushok"));
        Client client3 = new Client(3, new Person("Galina"), new Pet("dog", "Dusya"));
        testPetClinic = new PetClinic();
        testPetClinic.arrayPetsClinicRegistration.add(client1);
        testPetClinic.arrayPetsClinicRegistration.add(client2);
        testPetClinic.arrayPetsClinicRegistration.add(client3);

    }

    @Test
    public void shouldAddNewClient() {
        Assert.assertThat(testPetClinic.arrayPetsClinicRegistration.size(), is(3));
        testPetClinic.addNewClient("Evgeny", "crocodile", "Gena");
        Assert.assertThat(testPetClinic.arrayPetsClinicRegistration.size(), is(4));
    }

    @Test
    public void shouldFindClientByName() {
        Assert.assertThat(testPetClinic.findClientByName("Daria"), is(testPetClinic.arrayPetsClinicRegistration.get(1)));
    }

    @Test
    public void shouldFindClientByPetName() {
        Assert.assertThat(testPetClinic.findClientByPetName("Dusya"), is(testPetClinic.arrayPetsClinicRegistration.get(2)));
    }

    @Test
    public void shouldFindClientByCardNumber() {
        Assert.assertThat(testPetClinic.findClientByCardNumber("1"), is(testPetClinic.arrayPetsClinicRegistration.get(0)));
    }

    @Test
    public void shouldDeleteClientByName() {
        testPetClinic.deleteClient("Daria");
        Assert.assertThat(testPetClinic.arrayPetsClinicRegistration.size(), is(2));
    }

    @Test
    public void shouldRenameClient() {
        testPetClinic.renameClient("Daria", "Dasha");
        Assert.assertThat(testPetClinic.arrayPetsClinicRegistration.get(1).getPerson().getFullName(), is("Dasha"));
    }

    @Test
    public void shouldRenamePet() {
        testPetClinic.renamePet("Varya", "Murzik");
        Assert.assertThat(testPetClinic.arrayPetsClinicRegistration.get(0).getPet().getPetName(), is("Murzik"));
    }
}
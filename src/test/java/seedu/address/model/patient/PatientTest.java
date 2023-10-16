package seedu.address.model.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

public class PatientTest {

    private Patient patient;

    @BeforeEach
    public void setUp() {
        // Sample data for testing
        Name name = new Name("John Doe");
        Phone phone = new Phone("98765432");
        Email email = new Email("johndoe@example.com");
        Set<Tag> tags = new HashSet<>();

        patient = new Patient(name, phone, email, tags);
    }

    @Test
    public void getName() {
        assertEquals(new Name("John Doe"), patient.getName());
    }

    @Test
    public void getPhone() {
        assertEquals(new Phone("98765432"), patient.getPhone());
    }

    @Test
    public void getEmail() {
        assertEquals(new Email("johndoe@example.com"), patient.getEmail());
    }

    @Test
    public void getTags() {
        assertTrue(patient.getTags().isEmpty());
    }

    @Test
    public void isSamePerson_samePatient_returnsTrue() {
        assertTrue(patient.isSamePerson(patient));
    }
}

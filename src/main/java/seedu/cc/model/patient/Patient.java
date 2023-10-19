package seedu.cc.model.patient;

import java.util.Set;

import seedu.cc.model.person.Address;
import seedu.cc.model.person.Email;
import seedu.cc.model.person.Name;
import seedu.cc.model.person.Person;
import seedu.cc.model.person.Phone;
import seedu.cc.model.tag.Tag;

/**
 * Represents a Patient in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Patient extends Person {
    private final Nric nric;
    /**
     * Every field must be present and not null.
     *
     * @param name
     * @param nric
     * @param phone
     * @param email
     * @param address
     * @param tags
     */
    public Patient(Name name, Nric nric, Phone phone, Email email, Address address, Set<Tag> tags) {
        super(name, phone, email, address, tags);
        this.nric = nric;
    }

    //getters and setters
    public Name getName() {
        return super.getName();
    }

    public Nric getNric() {
        return this.nric;
    }

    public Phone getPhone() {
        return super.getPhone();
    }

    public Email getEmail() {
        return super.getEmail();
    }

    public Address getAddress() {
        return super.getAddress();
    }

    public Set<Tag> getTags() {
        return super.getTags();
    }

    public boolean isSamePerson(Patient otherPatient) {
        return super.isSamePerson(otherPatient) && this.nric.equals(otherPatient.getNric());
    }

    public boolean equals(Object other) {
        return super.equals(other);
    }

    public String toString() {
        return super.toString();
    }
}

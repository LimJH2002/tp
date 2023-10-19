package seedu.cc.testutil;

import seedu.cc.model.ClinicBook;
import seedu.cc.model.patient.Patient;

/**
 * A utility class to help with building Clinicbook objects.
 * Example usage: <br>
 *     {@code ClinicBook ab = new ClinicBookBuilder().withPatient("John", "Doe").build();}
 */
public class ClinicBookBuilder {

    private ClinicBook clinicBook;

    public ClinicBookBuilder() {
        clinicBook = new ClinicBook();
    }

    public ClinicBookBuilder(ClinicBook clinicBook) {
        this.clinicBook = clinicBook;
    }

    /**
     * Adds a new {@code Patient} to the {@code ClinicBook} that we are building.
     */
    public ClinicBookBuilder withPatient(Patient person) {
        clinicBook.addPatient(person);
        return this;
    }

    public ClinicBook build() {
        return clinicBook;
    }
}

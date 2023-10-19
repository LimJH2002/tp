package seedu.cc.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.cc.commons.util.ToStringBuilder;
import seedu.cc.model.patient.Patient;
import seedu.cc.model.patient.UniquePatientList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class ClinicBook implements ReadOnlyClinicBook {

    private final UniquePatientList patients;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        patients = new UniquePatientList();
    }

    public ClinicBook() {}

    /**
     * Creates an ClinicBook using the Persons in the {@code toBeCopied}
     */
    public ClinicBook(ReadOnlyClinicBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the patient list with {@code patients}.
     * {@code patients} must not contain duplicate patients.
     */
    public void setPatients(List<Patient> patients) {
        this.patients.setPatients(patients);
    }

    /**
     * Resets the existing data of this {@code ClinicBook} with {@code newData}.
     */
    public void resetData(ReadOnlyClinicBook newData) {
        requireNonNull(newData);

        setPatients(newData.getPatientList());
    }

    //// person-level operations

    /**
     * Returns true if a patient with the same identity as {@code patient} exists in the clinic book.
     */
    public boolean hasPatient(Patient person) {
        requireNonNull(person);
        return patients.contains(person);
    }

    /**
     * Adds a patient to the clinic book.
     * The patient must not already exist in the clinic book.
     */
    public void addPatient(Patient p) {
        patients.add(p);
    }

    /**
     * Replaces the given patient {@code target} in the list with {@code editedPatient}.
     * {@code target} must exist in the clinic book.
     * The patient identity of {@code editedPatient} must not be the same as another
     *  existing patient in the clinic book.
     */
    public void setPatient(Patient target, Patient editedPatient) {
        requireNonNull(editedPatient);

        patients.setPatient(target, editedPatient);
    }

    /**
     * Removes {@code key} from this {@code ClinicBook}.
     * {@code key} must exist in the address book.
     */
    public void removePatient(Patient key) {
        patients.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("patients", patients)
                .toString();
    }

    @Override
    public ObservableList<Patient> getPatientList() {
        return patients.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ClinicBook)) {
            return false;
        }

        ClinicBook otherAddressBook = (ClinicBook) other;
        return patients.equals(otherAddressBook.patients);
    }

    @Override
    public int hashCode() {
        return patients.hashCode();
    }
}

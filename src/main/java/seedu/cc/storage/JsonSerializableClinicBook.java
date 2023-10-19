package seedu.cc.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.cc.commons.exceptions.IllegalValueException;
import seedu.cc.model.ClinicBook;
import seedu.cc.model.ReadOnlyClinicBook;
import seedu.cc.model.patient.Patient;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "clinicbook")
class JsonSerializableClinicBook {

    public static final String MESSAGE_DUPLICATE_PERSON = "Patient list contains duplicate person(s).";

    private final List<JsonAdaptedPatient> persons = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableClinicBook} with the given persons.
     */
    @JsonCreator
    public JsonSerializableClinicBook(@JsonProperty("patients") List<JsonAdaptedPatient> patients) {
        this.persons.addAll(patients);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableClinicBook(ReadOnlyClinicBook source) {
        persons.addAll(source.getPatientList().stream().map(JsonAdaptedPatient::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code ClinicBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public ClinicBook toModelType() throws IllegalValueException {
        ClinicBook clinicBook = new ClinicBook();
        for (JsonAdaptedPatient jsonAdaptedPatient : persons) {
            Patient patient = jsonAdaptedPatient.toModelType();
            if (clinicBook.hasPatient(patient)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            clinicBook.addPatient(patient);
        }
        return clinicBook;
    }

}

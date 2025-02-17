package seedu.cc.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.cc.storage.JsonAdaptedPatient.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.cc.testutil.Assert.assertThrows;
import static seedu.cc.testutil.TypicalPatients.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.cc.commons.exceptions.IllegalValueException;
import seedu.cc.model.patient.Nric;
import seedu.cc.model.person.Age;
import seedu.cc.model.person.Email;
import seedu.cc.model.person.Name;
import seedu.cc.model.person.Phone;

public class JsonAdaptedPatientTest {
    private static final String INVALID_NAME = "R@chel";

    private static final String INVALID_NRIC = "S ";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_NRIC = BENSON.getNric().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ADDRESS = BENSON.getAge().toString();
    private static final List<JsonAdaptedMedicalHistoryEvent> VALID_MEDICAL_HISTORY_EVENTS =
            BENSON.getMedicalHistory().getMedicalHistoryEvents().stream()
                    .map(JsonAdaptedMedicalHistoryEvent::new)
                    .collect(Collectors.toList());
    private static final List<JsonAdaptedAppointmentEvent> VALID_APPOINTMENT_EVENTS =
            BENSON.getAppointmentList().getAppointmentList().stream()
                    .map(JsonAdaptedAppointmentEvent::new)
                    .collect(Collectors.toList());
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validPatientDetails_returnsPatient() throws Exception {
        JsonAdaptedPatient person = new JsonAdaptedPatient(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedPatient person = new JsonAdaptedPatient(INVALID_NAME, VALID_NRIC, VALID_PHONE, VALID_EMAIL,
                VALID_ADDRESS, VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedPatient person = new JsonAdaptedPatient(null, VALID_NRIC, VALID_PHONE, VALID_EMAIL,
                VALID_ADDRESS, VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidNric_throwsIllegalValueException() {
        JsonAdaptedPatient person =
                new JsonAdaptedPatient(VALID_NAME, INVALID_NRIC, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                        VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = Nric.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullNric_throwsIllegalValueException() {
        JsonAdaptedPatient person =
                new JsonAdaptedPatient(VALID_NAME, null, VALID_PHONE, VALID_EMAIL,
                        VALID_ADDRESS, VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Nric.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }


    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedPatient person = new JsonAdaptedPatient(VALID_NAME, VALID_NRIC, INVALID_PHONE, VALID_EMAIL,
                VALID_ADDRESS, VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedPatient person = new JsonAdaptedPatient(VALID_NAME, VALID_NRIC, null, VALID_EMAIL,
                VALID_ADDRESS, VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedPatient person =
                new JsonAdaptedPatient(VALID_NAME, VALID_NRIC, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS,
                        VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedPatient person = new JsonAdaptedPatient(VALID_NAME, VALID_NRIC, VALID_PHONE, null,
                VALID_ADDRESS, VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidAge_throwsIllegalValueException() {
        JsonAdaptedPatient person =
                new JsonAdaptedPatient(VALID_NAME, VALID_NRIC, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS,
                        VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = Age.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAge_throwsIllegalValueException() {
        JsonAdaptedPatient person = new JsonAdaptedPatient(VALID_NAME, VALID_NRIC, VALID_PHONE, VALID_EMAIL,
            null, VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Age.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedPatient person =
                new JsonAdaptedPatient(VALID_NAME, VALID_NRIC, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                        VALID_MEDICAL_HISTORY_EVENTS, VALID_APPOINTMENT_EVENTS, invalidTags);
        assertThrows(IllegalValueException.class, person::toModelType);
    }
}

package seedu.cc.model.patient;

import static java.util.Objects.requireNonNull;
import static seedu.cc.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's NRIC in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidNric(String)}
 */
public class Nric {


    public static final String MESSAGE_CONSTRAINTS =
            "NRIC should contain numbers and letters, and it should be 9 digits long for Singapore";
    public static final String VALIDATION_REGEX = "[A-Z]\\d{7}[A-Z]"; // Singapore NRIC format
    public final String value;

    /**
     * Constructs a {@code Phone}.
     *
     * @param nric A valid nric number.
     */
    public Nric(String nric) {
        requireNonNull(nric);
//        checkArgument(isValidNric(nric), MESSAGE_CONSTRAINTS);
        value = nric;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidNric(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Nric)) {
            return false;
        }

        Nric otherNric = (Nric) other;
        return value.equals(otherNric.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}


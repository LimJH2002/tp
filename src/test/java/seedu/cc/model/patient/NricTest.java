package seedu.cc.model.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NricTest {

    @Test
    void isValidNric() {
        // valid NRIC numbers
        assertTrue(Nric.isValidNric("M1234567P"));
        assertTrue(Nric.isValidNric("M8765432P"));

        // invalid NRIC numbers
        assertFalse(Nric.isValidNric("12345678"));
        assertFalse(Nric.isValidNric("87654321"));
        assertFalse(Nric.isValidNric("1234"));
        assertFalse(Nric.isValidNric("12345678901234567"));
        assertFalse(Nric.isValidNric("abcdefg"));
        assertFalse(Nric.isValidNric("1234567a"));
        assertFalse(Nric.isValidNric(""));
        assertFalse(Nric.isValidNric(" "));
    }

    @Test
    void testToString() {
        assertEquals("M1234567P", new Nric("M1234567P").toString());
        assertEquals("M8765432P", new Nric("M8765432P").toString());
    }

    @Test
    void testEquals() {
        // equal Nric objects
        assertEquals(new Nric("M1234567P"), new Nric("M1234567P"));
        assertEquals(new Nric("M8765432P"), new Nric("M8765432P"));

        // unequal Nric objects
        assertNotEquals(new Nric("M1234567P"), new Nric("M8765432P"));
        assertNotEquals(new Nric("M8765432P"), new Nric("M1234567P"));

        // comparing with null
        assertNotEquals(new Nric("M8765432P"), null);
    }

    @Test
    void testHashCode() {
        // equal hash codes for equal objects
        assertEquals(new Nric("M1234567P").hashCode(), new Nric("M1234567P").hashCode());
        assertEquals(new Nric("M8765432P").hashCode(), new Nric("M8765432P").hashCode());

        // unequal hash codes for unequal objects
        assertNotEquals(new Nric("M1234567P").hashCode(), new Nric("M8765432P").hashCode());
        assertNotEquals(new Nric("M8765432P").hashCode(), new Nric("M1234567P").hashCode());
    }
}


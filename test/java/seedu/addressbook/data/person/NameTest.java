package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    private static final String MESSAGE_SIMILAR_NAMES = "The 2 names should be similar";
    private Name name;

    @Before
    public void setup() throws IllegalValueException {
        name = new Name("John K Smith");
    }

    @Test
    public void constructor_containsNonAlphabeticCharacters_throwsIllegalValueException() {
        try {
            Name invalidName = new Name("1234!!");
            fail("Should throw IllegalValueException");
        } catch (IllegalValueException ive) {
            assertEquals("Exception error message should be the same", 
                    ive.getMessage(), Name.MESSAGE_NAME_CONSTRAINTS);
        }
    }

    @Test
    public void isSimilar_otherHasDifferentCaseFromName_returnsTrue() 
            throws IllegalValueException {
        Name other = new Name("john k smith");
        assertTrue(MESSAGE_SIMILAR_NAMES, name.isSimilar(other));
    }

    @Test
    public void isSimilar_otherIsSubsetOfName_returnsTrue() 
            throws IllegalValueException {
        Name other = new Name("John Smith");
        assertTrue(MESSAGE_SIMILAR_NAMES, name.isSimilar(other));
    }

    @Test
    public void isSimilar_otherIsSupersetOfName_returnsTrue() 
            throws IllegalValueException {
        Name other = new Name("John K Donald Smith");
        assertTrue(MESSAGE_SIMILAR_NAMES, name.isSimilar(other));
    }

    @Test
    public void isSimilar_otherHasDifferentOrderFromName_returnsTrue() 
            throws IllegalValueException {
        Name other = new Name("Smith John K");
        assertTrue(MESSAGE_SIMILAR_NAMES, name.isSimilar(other));
    }

    @Test
    public void isSimilar_otherIsNull_returnsFalse() {
        Name other = null;
        assertFalse("Name should not be similar to a null", name.isSimilar(other));
    }

}

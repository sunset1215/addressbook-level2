package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void testIsSimilar_differentCase() throws IllegalValueException {
        Name name = new Name("John K Smith");
        Name other = new Name("john k smith");
        assertTrue("The 2 names should be similar", name.isSimilar(other));
    }
    
}

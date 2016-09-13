package seedu.addressbook.common;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.common.Utils;

/**
 * Unit tests for Utils class
 * 
 * @author Vivian
 */
public class UtilsTest {

    private Object nullObj;
    private Object intObj;
    private Object strObj;

    private String unique1;
    private String unique2;
    private String unique3;

    private String copy1;

    @Before
    public void setup() {
        nullObj = null;
        intObj = new Integer(2);
        strObj = new String("I am a string");

        unique1 = new String("I am unique 1");
        unique2 = new String("I am unique 2");
        unique3 = new String("I am unique 3");
        copy1 = unique1;
    }

    /**
     * Test method for {@link seedu.addressbook.common.Utils#isAnyNull(java.lang.Object[])}.
     */
    @Test
    public void isAnyNull_noNullArgs_returnsFalse() {
        assertFalse("Should have no null args", Utils.isAnyNull(intObj, strObj));
    }

    /**
     * Test method for {@link seedu.addressbook.common.Utils#isAnyNull(java.lang.Object[])}.
     */
    @Test
    public void isAnyNull_hasNullArgs_returnsTrue() {
        assertTrue("Should have at least 1 null args", Utils.isAnyNull(nullObj, strObj));
    }

    /**
     * Test method for {@link seedu.addressbook.common.Utils#elementsAreUnique(java.util.Collection)}.
     */
    @Test
    public void elementsAreUnique_hasNonUniqueElements_returnsFalse() {
        Collection<String> collection = new ArrayList<String>();
        collection.add(unique1);
        collection.add(unique2);
        collection.add(copy1);
        assertFalse("Elements should be non-unique", Utils.elementsAreUnique(collection));
    }

    /**
     * Test method for {@link seedu.addressbook.common.Utils#elementsAreUnique(java.util.Collection)}.
     */
    @Test
    public void elementsAreUnique_hasUniqueElements_returnsTrue() {
        Collection<String> collection = new ArrayList<String>();
        collection.add(unique1);
        collection.add(unique2);
        collection.add(unique3);
        assertTrue("Elements should be unique", Utils.elementsAreUnique(collection));
    }

    @After
    public void teardown() {
        intObj = null;
        strObj = null;

        unique1 = null;
        unique2 = null;
        unique3 = null;
        copy1 = null;
    }

}

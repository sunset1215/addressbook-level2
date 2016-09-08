package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import seedu.addressbook.common.Utils;

/**
 * Unit tests for Utils class
 * 
 * @author Vivian
 */
public class UtilsTest {

    /**
     * Test method for {@link seedu.addressbook.common.Utils#isAnyNull(java.lang.Object[])}.
     */
    @Test
    public void testIsAnyNull_noNullArgsReturnFalse() {
        Object obj1 = new Integer(2);
        Object obj2 = new String("String object");
        assertFalse("Should have no null args", Utils.isAnyNull(obj1, obj2));
    }
    
    /**
     * Test method for {@link seedu.addressbook.common.Utils#isAnyNull(java.lang.Object[])}.
     */
    @Test
    public void testIsAnyNull_hasNullArgsReturnTrue() {
        Object obj1 = null;
        Object obj2 = new String("String object");
        assertTrue("Should have at least 1 null args", Utils.isAnyNull(obj1, obj2));
    }

    /**
     * Test method for {@link seedu.addressbook.common.Utils#elementsAreUnique(java.util.Collection)}.
     */
    @Test
    public void testElementsAreUnique_hasNonUniqueElementsReturnFalse() {
        String string1 = new String("This is string 1");
        String string2 = new String("This is string 2");
        String string3 = string1;
        Collection<String> collection = new ArrayList<String>();
        collection.add(string1);
        collection.add(string2);
        collection.add(string3);
        assertFalse("Elements should be non-unique", Utils.elementsAreUnique(collection));
    }
    
    /**
     * Test method for {@link seedu.addressbook.common.Utils#elementsAreUnique(java.util.Collection)}.
     */
    @Test
    public void testElementsAreUnique_hasUniqueElementsReturnTrue() {
        String string1 = new String("This is string 1");
        String string2 = new String("This is string 2");
        String string3 = new String("This is string 3");
        Collection<String> collection = new ArrayList<String>();
        collection.add(string1);
        collection.add(string2);
        collection.add(string3);
        assertTrue("Elements should be unique", Utils.elementsAreUnique(collection));
    }

}

package seedu.addressbook.data;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

/**
 * Represents a tag operation
 */
public class Tagging {

    private final ReadOnlyPerson person;
    private final Tag tag;
    private final String operation;

    public static final String OPERATION_ADD = "+";
    public static final String OPERATION_REMOVE = "-";

    public Tagging(ReadOnlyPerson person, Tag tag, String operation) {
        this.person = person;
        this.tag = tag;
        this.operation = operation;
    }

    @Override
    public String toString() {
        String tagging = operation + " " + person.getName() + " [" + tag.tagName + "]";
        return tagging;
    }

}

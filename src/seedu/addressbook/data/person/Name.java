package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                        && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if
     * 1. they are in different cases
     * 2. they are subset/superset of each other
     */
    public boolean isSimilar(Name other) {
        // different case
        if (fullName.equalsIgnoreCase(other.fullName)) {
            return true;
        }

        // other is subset of name
        if (other.isSubsetOf(this.fullName)) {
            return true;
        }

        // other is superset of name (i.e. name is subset of other)
        if (isSubsetOf(other.fullName)) {
            return true;
        }

        return false;
    }

    private boolean isSubsetOf(String superName) {
        // names are padded with whitespace at the start and end so that checks are done against a whole word
        String lcPaddedSuperName = " " + superName.toLowerCase() + " ";
        String lcSubName = fullName.toLowerCase();
        String[] lcSubNameParts = lcSubName.split("\\P{Alpha}+"); // splits on any non-alphabetic characters

        for (int i = 0; i < lcSubNameParts.length; i++) {
            String paddedSubNamePart = " " + lcSubNameParts[i] + " ";
            if (!lcPaddedSuperName.contains(paddedSubNamePart)) {
                return false;
            }
        }

        return true;
    }

}

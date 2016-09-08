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
    public static final String MESSAGE_NAME_CONSTRAINTS =
            "Person names should be spaces or alphabetic characters";
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
     * Returns true if the other name is very similar to this name. 
     * Two names are considered similar if: 
     * <pre>
     * 1. they are in different case
     * 2. they are subset/superset of each other
     * </pre>
     */
    public boolean isSimilar(Name other) {
        if(!isOtherNameNull(other)) {
            return isNameEqualsIgnoreCase(other) ||
                 isNameSubsetOfOther(other) ||
                 isNameSupersetOfOther(other);
        }
        return false;
    }

    /**
     * Returns true if this is a superset of other name
     * 
     * @param subName the name that is the subset
     * @return
     */
    private boolean isNameSupersetOfOther(Name subName) {
        // if this is superset of subName, then subName is subset of this
        return subName.isNameSubsetOfOther(this);
    }

    /**
     * Returns true if this is a subset of other name
     * 
     * @param superName the name that is the superset
     * @return
     */
    private boolean isNameSubsetOfOther(Name superName) {
        // names are padded with whitespace at the start and end so that checks
        // are done against a whole word
        String lcPaddedSuperName = " " + superName.fullName.toLowerCase() + " ";
        String lcSubName = this.fullName.toLowerCase();

        // split on any non-alphabetic characters
        String[] lcSubNameParts = lcSubName.split("\\P{Alpha}+");

        // check that superName contains every word from subName
        for (int i = 0; i < lcSubNameParts.length; i++) {
            String paddedSubNamePart = " " + lcSubNameParts[i] + " ";
            if (!lcPaddedSuperName.contains(paddedSubNamePart)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNameEqualsIgnoreCase(Name other) {
        return this.fullName.equalsIgnoreCase(other.fullName);
    }

    private boolean isOtherNameNull(Name other) {
        return other == null;
    }

}

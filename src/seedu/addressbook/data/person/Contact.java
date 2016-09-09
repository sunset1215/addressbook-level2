package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Parent class of Phone, Email and Address class.
 */
public class Contact {

    private String value;
    private boolean isPrivate;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String value, boolean isPrivate, String regex, String exceptionMessage)
            throws IllegalValueException {
        if (!isValidContact(value, regex)) {
            throw new IllegalValueException(exceptionMessage);
        }
        this.value = value;
        this.isPrivate = isPrivate;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * Returns true if a given string is a valid person contact.
     */
    private boolean isValidContact(String test, String regex) {
        return test.matches(regex);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }



}

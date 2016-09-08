package seedu.addressbook.data.person;

/**
 * Generalization of Phone, Email and Address class
 */
public class Contact {

    private String value;
    private boolean isPrivate;

    public Contact() {
        this.value = "";
        this.isPrivate = false;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}

package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {

	private final Person person;
	private final Tag tag;
	private final String operation;
	
	private static final String OPERATION_ADD = "Add";
	private static final String OPERATION_REMOVE = "Remove";
	
	public Tagging(Person person, Tag tag, String operation) {
		this.person = person;
		this.tag = tag;
		this.operation = operation;
	}
	
}

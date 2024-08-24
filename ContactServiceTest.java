import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        service.addContact(contact);
        service.updateContact("1234567890", "Jane", "Smith", "0987654321", "456 Main St");
        Contact updatedContact = service.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Main St", updatedContact.getAddress());
    }
}

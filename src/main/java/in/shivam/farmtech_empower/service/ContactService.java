package in.shivam.farmtech_empower.service;

import in.shivam.farmtech_empower.entity.Contact;
import in.shivam.farmtech_empower.repository.ContactMessageRepository; // Updated to match the correct name
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactMessageRepository contactRepo; // Updated variable name

    /**
     * Saves the contact information and returns true if successful.
     *
     * @param contact The contact information to save.
     * @return true if the contact is saved successfully, false otherwise.
     */
    public boolean saveContact(Contact contact) {
        try {
            contactRepo.save(contact); // Assuming `contactRepo` has a `save` method
            return true;
        } catch (Exception e) {
            // Optionally log the exception
            e.printStackTrace();
            return false;
        }
    }
}

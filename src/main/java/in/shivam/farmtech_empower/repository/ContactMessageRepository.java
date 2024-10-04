package in.shivam.farmtech_empower.repository;

import in.shivam.farmtech_empower.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<Contact, Integer> {
    // Add any custom query methods here if necessary
}

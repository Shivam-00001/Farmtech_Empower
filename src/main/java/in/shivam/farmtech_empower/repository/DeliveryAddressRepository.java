package in.shivam.farmtech_empower.repository;

import in.shivam.farmtech_empower.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Integer> {
    // Add any custom query methods here if necessary
}

package in.shivam.farmtech_empower.service;

import in.shivam.farmtech_empower.entity.DeliveryAddress;
import in.shivam.farmtech_empower.repository.DeliveryAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAddressService {

    @Autowired
    private DeliveryAddressRepository repository;

    public boolean saveDeliveryAddress(DeliveryAddress address) {
        try {
            repository.save(address);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

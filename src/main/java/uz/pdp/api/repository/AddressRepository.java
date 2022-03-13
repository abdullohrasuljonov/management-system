package uz.pdp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.api.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    boolean existsByStreetAndHomeNumber(String street, String homeNumber);
}

package uz.pdp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.api.entity.Address;
import uz.pdp.api.payload.AddressDto;
import uz.pdp.api.payload.ApiResponse;
import uz.pdp.api.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public ApiResponse addAddress(AddressDto addressDto){
        boolean exists = addressRepository.existsByStreetAndHomeNumber(addressDto.getStreet(), addressDto.getHomeNumber());
        if (exists)
            return new ApiResponse("Home number already exist such a street!",false);
        Address address=new Address();
        address.setStreet(addressDto.getStreet());
        address.setHomeNumber(addressDto.getHomeNumber());
        addressRepository.save(address);
        return new ApiResponse("Successfully added!",true);
    }

    public List<Address> all(){
        return addressRepository.findAll();
    }

    public Address getById(Integer id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.orElse(null);
    }

    public ApiResponse editAddress(Integer id,AddressDto addressDto){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (!optionalAddress.isPresent())
            return new ApiResponse("There is no address such an id!",false);
        boolean exists = addressRepository.existsByStreetAndHomeNumber(addressDto.getStreet(), addressDto.getHomeNumber());
        if (exists)
            return new ApiResponse("Home number already exist such a street!",false);
        Address address=optionalAddress.get();
        address.setStreet(addressDto.getStreet());
        address.setHomeNumber(addressDto.getHomeNumber());
        addressRepository.save(address);
        return new ApiResponse("Successfully edited!",true);
    }

    public ApiResponse deleteAddress(Integer id){
        try {
            addressRepository.deleteById(id);
            return new ApiResponse("Successfully deleted!",true);
        }catch (Exception e){
            return new ApiResponse("Deleting error!",false);
        }
    }
}

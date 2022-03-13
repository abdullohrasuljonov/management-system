package uz.pdp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.api.entity.Worker;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Integer> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);

    List<Worker> getAllByDepartmentId(Integer department_id);
}

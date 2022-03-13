package uz.pdp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.api.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    boolean existsByName(String name);

    List<Department> getAllByCompanyId(Integer company_id);
}

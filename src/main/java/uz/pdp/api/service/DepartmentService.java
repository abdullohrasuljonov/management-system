package uz.pdp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.api.entity.Company;
import uz.pdp.api.entity.Department;
import uz.pdp.api.payload.ApiResponse;
import uz.pdp.api.payload.DepartmentDto;
import uz.pdp.api.repository.CompanyRepository;
import uz.pdp.api.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CompanyRepository companyRepository;

    public List<Department> all() {
        return departmentRepository.findAll();
    }

    public Department getById(Integer id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        return optionalDepartment.orElse(null);
    }

    public List<Department> getByCompanyId(Integer companyId) {
        return departmentRepository.getAllByCompanyId(companyId);
    }

    public ApiResponse addDepartment(DepartmentDto departmentDto) {
        boolean exists = departmentRepository.existsByName(departmentDto.getName());
        if (exists)
            return new ApiResponse("Name already exist!", false);
        Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompanyId());
        if (!optionalCompany.isPresent())
            return new ApiResponse("There is no company such an id!", false);
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setCompany(optionalCompany.get());
        departmentRepository.save(department);
        return new ApiResponse("Successfully added!", true);
    }

    public ApiResponse editDepartment(Integer id, DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent())
            return new ApiResponse("There is no department such an id!", false);
        boolean exists = departmentRepository.existsByName(departmentDto.getName());
        if (exists)
            return new ApiResponse("Name already exist!", false);
        Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompanyId());
        if (!optionalCompany.isPresent())
            return new ApiResponse("There is no company such an id!", false);
        Department department = optionalDepartment.get();
        department.setName(departmentDto.getName());
        department.setCompany(optionalCompany.get());
        departmentRepository.save(department);
        return new ApiResponse("Successfully edited!", true);
    }

    public ApiResponse deleteDepartment(Integer id){
        try {
            departmentRepository.deleteById(id);
            return new ApiResponse("Successfully deleted!",true);
        }catch (Exception e){
            return new ApiResponse("Deleting error!",false);
        }
    }
}

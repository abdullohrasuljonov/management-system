package uz.pdp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.api.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    boolean existsByCorpName(String corpName);
}

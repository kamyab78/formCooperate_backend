package ir.bourna.form.Repositories;

import ir.bourna.form.Entities.CompanyEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends PagingAndSortingRepository<CompanyEntity, Integer> {
    List<CompanyEntity> findAllByPartnerid(int partnerId);

}

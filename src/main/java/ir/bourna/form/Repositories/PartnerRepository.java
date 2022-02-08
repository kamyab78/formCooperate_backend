package ir.bourna.form.Repositories;

import ir.bourna.form.Entities.PartnerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PartnerRepository extends PagingAndSortingRepository<PartnerEntity, Integer> {
    PartnerEntity findById(int id);
    List<PartnerEntity> findAll();
}

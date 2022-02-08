package ir.bourna.form.Repositories;

import ir.bourna.form.Entities.InstituteEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface InstituteRepository extends PagingAndSortingRepository<InstituteEntity, Integer> {

    List<InstituteEntity> findAllByPartnerid(int partnerId);
}

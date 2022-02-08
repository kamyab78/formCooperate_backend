package ir.bourna.form.Repositories;

import ir.bourna.form.Entities.ProjectEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<ProjectEntity, Integer> {
    ProjectEntity findById(int id);
    List<ProjectEntity> findAll();
    List<ProjectEntity> findAllByPartnerid(int id);
    ProjectEntity findByIdAndPartnerid(int id , int partnerid);
}

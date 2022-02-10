package ir.bourna.form.Services;

import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.ProjectRequestDto;
import ir.bourna.form.Entities.ProjectEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProjectService {


    BaseResponseDTO addProject(ProjectRequestDto projectRequestDto, int partnerId);

    BaseResponseDTO editProject(ProjectRequestDto projectRequestDto, int partnerId);

    ResponseEntity<List<ProjectEntity>> getProject(int partnerId);

    BaseResponseDTO changestateproject(int partnerId);

    ResponseEntity<ProjectEntity> getProjectDetailUser(int partnerId, int projectId);

    List<ProjectEntity> projectlist(int partnerId);
}

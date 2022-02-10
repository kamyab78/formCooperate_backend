package ir.bourna.form.Services;


import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.ProjectRequestDto;
import ir.bourna.form.Entities.ProjectEntity;
import ir.bourna.form.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public BaseResponseDTO addProject(ProjectRequestDto projectRequestDto, int partnerId) {
        ProjectEntity projectEntity = new ProjectEntity();
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();

        projectEntity.setActivitydomain(projectRequestDto.getActivitydomain());
        projectEntity.setDescription(projectRequestDto.getDescription());
        projectEntity.setDisabled(projectRequestDto.isDisabled());
        projectEntity.setTitle(projectRequestDto.getTitle());
        projectEntity.setPartnerid(partnerId);
        projectRepository.save(projectEntity);

        baseResponseDTO.setMessage("پروژه شما با موفقیت ثبت شد");
        baseResponseDTO.setCode(200);
        return baseResponseDTO;
    }

    @Override
    public BaseResponseDTO editProject(ProjectRequestDto projectRequestDto, int partnerId) {
        ProjectEntity projectEntity = projectRepository.findById(partnerId);
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();

        projectEntity.setActivitydomain(projectRequestDto.getActivitydomain());
        projectEntity.setDescription(projectRequestDto.getDescription());
        projectEntity.setDisabled(projectRequestDto.isDisabled());
        projectEntity.setTitle(projectRequestDto.getTitle());
        projectEntity.setPartnerid(partnerId);
        projectRepository.save(projectEntity);

        baseResponseDTO.setMessage("پروژه شما  با موفقیت تغییر یافت");
        baseResponseDTO.setCode(200);
        return baseResponseDTO;
    }

    @Override
    public ResponseEntity<List<ProjectEntity>> getProject(int partnerId) {
        List<ProjectEntity> projectEntities = projectRepository.findAll();
        return ResponseEntity.ok(projectEntities);
    }

    @Override
    public BaseResponseDTO changestateproject(int partnerId) {
        ProjectEntity projectEntity = projectRepository.findById(partnerId);
        projectEntity.setDisabled(!projectEntity.isDisabled());
        projectRepository.save(projectEntity);
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(200);
        baseResponseDTO.setMessage("وضعیت فعالی مورد نظر تغییر یافت");
        return baseResponseDTO;
    }

    @Override
    public ResponseEntity<ProjectEntity> getProjectDetailUser(int partnerId, int projectId) {
        ProjectEntity projectEntity = projectRepository.findByIdAndPartnerid(projectId,partnerId);
        return ResponseEntity.ok(projectEntity);
    }

    @Override
    public List<ProjectEntity> projectlist(int partnerId) {
        List<ProjectEntity> projectList= projectRepository.findAllByPartnerid(partnerId);
        return projectList;
    }
}
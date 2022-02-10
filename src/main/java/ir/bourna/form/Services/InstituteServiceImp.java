package ir.bourna.form.Services;


import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.InstituteRequestDto;
import ir.bourna.form.Entities.InstituteEntity;
import ir.bourna.form.Entities.ProjectEntity;
import ir.bourna.form.Repositories.InstituteRepository;
import ir.bourna.form.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituteServiceImp implements InstituteService {

    @Autowired
    InstituteRepository instituteRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public BaseResponseDTO addInstitiuteUser(int partnerId, InstituteRequestDto instituteRequestDto, int projectid) {

        InstituteEntity instituteEntity = new InstituteEntity();
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        instituteEntity.setEmail(instituteRequestDto.getEmail());
        instituteEntity.setHourdes(instituteRequestDto.getHourdes());
        instituteEntity.setWorkexp(instituteRequestDto.getWorkexp());
        instituteEntity.setName(instituteRequestDto.getName());
        instituteEntity.setProjectid(projectid);
        ProjectEntity projectEntity = projectRepository.findById(projectid);
        instituteEntity.setProjectname(projectEntity.getTitle());
        instituteEntity.setPhone(instituteRequestDto.getPhone());
        instituteEntity.setSupportdes(instituteRequestDto.getSupportdes());
        instituteEntity.setDegree(instituteRequestDto.getDegree());
        instituteEntity.setLastname(instituteRequestDto.getLastname());
        instituteEntity.setPartnerid(partnerId);
        instituteRepository.save(instituteEntity);

        baseResponseDTO.setMessage("درخواست شما با موفقیت ثبت شد");
        baseResponseDTO.setCode(200);
        return baseResponseDTO;
    }
}
package ir.bourna.form.Services;


import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.CompanyRequestDto;
import ir.bourna.form.Entities.CompanyEntity;
import ir.bourna.form.Entities.ProjectEntity;
import ir.bourna.form.Repositories.CompanyRepository;
import ir.bourna.form.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public BaseResponseDTO addCompanyUser(int partnerId, CompanyRequestDto companyRequestDto, int projectid) {
        CompanyEntity companyEntity = new CompanyEntity();
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        companyEntity.setEmail(companyRequestDto.getEmail());
        companyEntity.setHourdes(companyRequestDto.getHourdes());
        companyEntity.setWorkexp(companyRequestDto.getWorkexp());
        companyEntity.setProjectid(projectid);
        ProjectEntity projectEntity = projectRepository.findById(projectid);
        companyEntity.setProjectname(projectEntity.getTitle());
        companyEntity.setName(companyRequestDto.getName());
        companyEntity.setPhone(companyRequestDto.getPhone());
        companyEntity.setSupportdes(companyRequestDto.getSupportdes());
        companyEntity.setPartnerid(partnerId);
        companyRepository.save(companyEntity);

        baseResponseDTO.setMessage("درخواست شما با موفقیت ثبت شد");
        baseResponseDTO.setCode(200);
        return baseResponseDTO;
    }
}

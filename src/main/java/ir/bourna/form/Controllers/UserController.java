package ir.bourna.form.Controllers;

import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.CompanyRequestDto;
import ir.bourna.form.Dtos.InstituteRequestDto;
import ir.bourna.form.Dtos.SendemailticketRequestDTO;
import ir.bourna.form.Entities.ProjectEntity;
import ir.bourna.form.Services.CompanyService;
import ir.bourna.form.Services.InstituteService;
import ir.bourna.form.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    ProjectService projectService;
    @Autowired
    CompanyService companyService;
    @Autowired
    InstituteService instituteService;
    @GetMapping("/projectlist")
    private List<ProjectEntity> projectlist(@RequestParam int partnerId) {
        return projectService.projectlist(partnerId);
    }
    @GetMapping("/projectdetail")
    private ResponseEntity<ProjectEntity> getProjectDetailUser(@RequestParam int partnerId,@RequestParam int projectId) {
        return projectService.getProjectDetailUser(partnerId,projectId);
    }
    @PostMapping("/instituteuser")
    private BaseResponseDTO addInstituteUser(@RequestParam int partnerId,@RequestParam int projectid, @RequestBody InstituteRequestDto instituteRequestDto) {
        return instituteService.addInstitiuteUser(partnerId,instituteRequestDto,projectid);
    }
    @PostMapping("/companyuser")
    private BaseResponseDTO addCompanyUser(@RequestParam int partnerId,@RequestParam int projectid,  @RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.addCompanyUser(partnerId,companyRequestDto,projectid);
    }
    @PostMapping("/sendmail")
    private BaseResponseDTO sendmail(@RequestBody SendemailticketRequestDTO sendemailticketRequestDTO) {
        return companyService.sendmail(sendemailticketRequestDTO);
    }
}

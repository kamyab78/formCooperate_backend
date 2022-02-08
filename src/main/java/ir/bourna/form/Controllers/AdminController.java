package ir.bourna.form.Controllers;

import ir.bourna.form.Config.ExportPartnersTable;
import ir.bourna.form.Dtos.PartnerRequestDto;
import ir.bourna.form.Dtos.ProjectRequestDto;
import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Entities.PartnerEntity;
import ir.bourna.form.Entities.ProjectEntity;
import ir.bourna.form.Services.PartnerService;
import ir.bourna.form.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    PartnerService partnerService;
    @Autowired
    ProjectService projectService;

    //--------PARTNER CRUD----------

    @PostMapping("/partners")
    private BaseResponseDTO addPartner(@RequestBody PartnerRequestDto partnerRequestDto) {
        return partnerService.addPartner(partnerRequestDto);
    }

    @PutMapping("/partners")
    private BaseResponseDTO editPartner(@RequestBody PartnerRequestDto partnerRequestDto, @RequestParam int partnerId) {
        return partnerService.editPartner(partnerRequestDto, partnerId);
    }

    @GetMapping("/partners")
    private ResponseEntity<List<PartnerEntity>> getPartner() {
        return partnerService.getPartner();
    }

    @PutMapping("/changestatepartner")
    private BaseResponseDTO changestatepartner(@RequestParam int partnerId) {
        return partnerService.changestatepartner(partnerId);
    }

    //--------PROJECT CRUD----------

    @PostMapping("/projects")
    private BaseResponseDTO addProject(@RequestBody ProjectRequestDto projectRequestDto, @RequestParam int partnerId) {
        return projectService.addProject(projectRequestDto, partnerId);
    }

    @PutMapping("/projects")
    private BaseResponseDTO editProject(@RequestBody ProjectRequestDto projectRequestDto, @RequestParam int partnerId) {
        return projectService.editProject(projectRequestDto, partnerId);
    }

    @GetMapping("/projects")
    private ResponseEntity<List<ProjectEntity>> getProject(@RequestParam int partnerId) {
        return projectService.getProject(partnerId);
    }

    @PutMapping("/changestateproject")
    private BaseResponseDTO changestateproject(@RequestParam int partnerId) {
        return projectService.changestateproject(partnerId);
    }

    //--------GET USER DATA EXCEL----------
    @GetMapping("/downloadFile")
    public void exportToExcel(@RequestParam int partnerId) { {
            ExportPartnersTable excelExporter = new ExportPartnersTable();
            try {
                excelExporter.export(partnerId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
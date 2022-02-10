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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    @GetMapping("/create")
    public void exportToExcel(@RequestParam int partnerId) {
        {
            ExportPartnersTable excelExporter = new ExportPartnersTable();
            try {
                excelExporter.export(partnerId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() throws IOException {
        String file = "E:\\projects\\irform\\partnerscompany-export1644506750.xlsx";
        Path path = Paths.get(file);
        String filename ="hellllo";
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(resource);
    }
}
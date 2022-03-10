package ir.bourna.form.Services;


import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.CompanyRequestDto;
import ir.bourna.form.Dtos.SendemailticketRequestDTO;
import ir.bourna.form.Entities.CompanyEntity;
import ir.bourna.form.Entities.ProjectEntity;
import ir.bourna.form.Repositories.CompanyRepository;
import ir.bourna.form.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

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

    @Override
    public BaseResponseDTO sendmail(SendemailticketRequestDTO sendemailticketRequestDTO) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("iustticketsender@gmail.com");
        mailSender.setPassword("Bourn@123456");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("iustticketsender@gmail.com");
        message.setTo("Iscp@iust.ac.ir");
        message.setSubject(sendemailticketRequestDTO.getSubject());
        message.setText(sendemailticketRequestDTO.getText());
        mailSender.send(message);
        return null;
    }

}

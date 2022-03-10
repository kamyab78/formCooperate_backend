package ir.bourna.form.Services;

import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.CompanyRequestDto;
import ir.bourna.form.Dtos.SendemailticketRequestDTO;


public interface CompanyService {


    BaseResponseDTO addCompanyUser(int partnerId, CompanyRequestDto companyRequestDto, int projectid);

    BaseResponseDTO sendmail(SendemailticketRequestDTO sendemailticketRequestDTO);
}

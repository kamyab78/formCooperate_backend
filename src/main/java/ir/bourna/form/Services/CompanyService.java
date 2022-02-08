package ir.bourna.form.Services;

import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.CompanyRequestDto;


public interface CompanyService {


    BaseResponseDTO addCompanyUser(int partnerId, CompanyRequestDto companyRequestDto);
}

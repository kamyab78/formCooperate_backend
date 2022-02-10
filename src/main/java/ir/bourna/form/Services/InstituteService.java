package ir.bourna.form.Services;

import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.InstituteRequestDto;


public interface InstituteService {

    BaseResponseDTO addInstitiuteUser(int partnerId, InstituteRequestDto instituteRequestDto, int projectid);
}

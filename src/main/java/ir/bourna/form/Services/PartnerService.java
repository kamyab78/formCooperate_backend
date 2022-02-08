package ir.bourna.form.Services;

import ir.bourna.form.Dtos.PartnerRequestDto;
import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Entities.PartnerEntity;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PartnerService {

    BaseResponseDTO addPartner(PartnerRequestDto partnerRequestDto);

    BaseResponseDTO editPartner(PartnerRequestDto partnerRequestDto, int username);

    ResponseEntity<List<PartnerEntity>> getPartner();

    BaseResponseDTO changestatepartner(int partnerId);

}

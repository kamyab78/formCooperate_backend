package ir.bourna.form.Services;


import ir.bourna.form.Dtos.BaseResponseDTO;
import ir.bourna.form.Dtos.PartnerRequestDto;
import ir.bourna.form.Entities.CompanyEntity;
import ir.bourna.form.Entities.InstituteEntity;
import ir.bourna.form.Entities.PartnerEntity;
import ir.bourna.form.Repositories.CompanyRepository;
import ir.bourna.form.Repositories.InstituteRepository;
import ir.bourna.form.Repositories.PartnerRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImp implements PartnerService {
    @Autowired
    PartnerRepository partnerRepository;
    @Autowired
    InstituteRepository instituteRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public BaseResponseDTO addPartner(PartnerRequestDto partnerRequestDto) {
        PartnerEntity partnerEntity = new PartnerEntity();
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        partnerEntity.setTitle(partnerRequestDto.getTitle());
        partnerEntity.setDisabled(partnerRequestDto.isDisabled());
        partnerRepository.save(partnerEntity);

        baseResponseDTO.setMessage("پارتنر با موفقیت ثبت شد");
        baseResponseDTO.setCode(200);
        return baseResponseDTO;
    }

    @Override
    public BaseResponseDTO editPartner(PartnerRequestDto partnerRequestDto, int partnerId) {
        PartnerEntity partnerEntity = partnerRepository.findById(partnerId);
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        partnerEntity.setTitle(partnerRequestDto.getTitle());
        partnerEntity.setDisabled(partnerRequestDto.isDisabled());
        partnerRepository.save(partnerEntity);

        baseResponseDTO.setMessage("تغییرات پارنتر ثبت شد");
        baseResponseDTO.setCode(200);
        return baseResponseDTO;
    }

    @Override
    public ResponseEntity<List<PartnerEntity>> getPartner() {
        List<PartnerEntity> partnerEntities = partnerRepository.findAll();
        return ResponseEntity.ok(partnerEntities);
    }

    @Override
    public BaseResponseDTO changestatepartner(int partnerId) {
        PartnerEntity partnerEntity = partnerRepository.findById(partnerId);
        partnerEntity.setDisabled(!partnerEntity.isDisabled());
        partnerRepository.save(partnerEntity);
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(200);
        baseResponseDTO.setMessage("وضعیت فعالی مورد نظر تغییر یافت");
        return baseResponseDTO;
    }


}

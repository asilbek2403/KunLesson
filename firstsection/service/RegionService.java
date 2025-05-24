package asil.uz.darsKun_uz.firstsection.service;

import asil.uz.darsKun_uz.firstsection.Dto.RegionDto;
import asil.uz.darsKun_uz.firstsection.Dto.RegionShortDto;
import asil.uz.darsKun_uz.firstsection.Enumrol.Lenguagc;
import asil.uz.darsKun_uz.firstsection.entity.RegionEntity;
import asil.uz.darsKun_uz.firstsection.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class  RegionService {


    @Autowired
    private RegionRepository regionRepository;

    public RegionDto create(RegionDto regionDto) {
        RegionEntity regionEntity = new RegionEntity();
//        Optional<RegionEntity> region = regionRepository.findById(regionEntity.getId());

//        regionEntity.setOrderNum(regionDto.getOrderNum());
//        regionEntity.setKey(regionDto.getKey());
//        regionEntity.setCreated_Date(LocalDate.from(regionDto.getCreatedDate()));
//        regionEntity.setVisible(regionDto.getVisible());
//        regionEntity.setNameUz(regionDto.getNameUz());
//        regionEntity.setNameRu(regionDto.getNameRu());
//        regionEntity.setNameEn(regionDto.getNameEn());
//        regionRepository.save(regionEntity);
//        regionEntity.setId(regionDto.getId());
////        regionEntity.setLenguagc(regionDto.getLenguagc());
//
//        return regionDto;
        regionEntity.setOrderNum(regionDto.getOrderNum());
        regionEntity.setKey(regionDto.getKey());
        regionEntity.setCreatedDate(regionDto.getCreatedDate() != null ? LocalDate.from(regionDto.getCreatedDate()) : LocalDate.now());
        regionEntity.setVisible(regionDto.getVisible() != null ? regionDto.getVisible() : true);
        regionEntity.setNameUz(regionDto.getNameUz());
        regionEntity.setNameRu(regionDto.getNameRu());
        regionEntity.setNameEn(regionDto.getNameEn());
        regionEntity.setDescription(regionDto.getDescription());

        regionRepository.save(regionEntity);

        regionDto.setId(regionEntity.getId()); // ID saqlanganidan so‘ng DTOga o‘rnatiladi

        return regionDto;
    }


    public RegionDto update(Integer id , RegionDto regionDto) {
        Optional<RegionEntity> regionEntity = regionRepository.findById(id);

        if (regionEntity.isPresent()) {


        RegionEntity regionEntity1 = regionEntity.get();
            if(regionDto.getOrderNum() != null) {
                regionEntity1.setOrderNum(regionDto.getOrderNum()); // ✅ to‘g‘ri
            }
            if(regionDto.getKey() != null) regionEntity1.setKey(regionDto.getKey());                 // ✅
            regionEntity1.setNameUz(regionDto.getNameUz());
            regionEntity1.setNameRu(regionDto.getNameRu());
            regionEntity1.setNameEn(regionDto.getNameEn());
            if(regionDto.getVisible() !=null) regionEntity1.setVisible(regionDto.getVisible());// ✅ agar boolean bo‘lsa
//            if(regionDto.getLenguagc() !=null) regionEntity1.setLenguagc(regionDto.getLenguagc());       // ✅ typo tuzatilgan

// Saqlaymiz
            regionRepository.save(regionEntity1);

            RegionDto regionDto1 = new RegionDto();
            regionDto1.setOrderNum(regionEntity1.getOrderNum());
            regionDto1.setKey(regionEntity1.getKey());
//            regionDto1.setLenguagc(regionEntity1.getLenguagc());
            regionDto1.setNameUz(regionEntity1.getNameUz());
            regionDto1.setNameRu(regionEntity1.getNameRu());
            regionDto1.setNameEn(regionEntity1.getNameEn());
            regionDto1.setVisible(regionEntity1.getVisible());
            return regionDto1;
        }
        return null;
    }



    public boolean delete(Integer id) {
        regionRepository.deleteById(id);
        return true;
    }

    public List<RegionDto> getAll() {
        List<RegionEntity> regionEntityList = regionRepository.findAll();
        List<RegionDto> regionDtoList = new ArrayList<>();

        regionEntityList.forEach(regionEntity -> regionDtoList.add(toDto(regionEntity)));
        return regionDtoList;

    }


    public RegionDto toDto(RegionEntity regionEntity) {
//        List<RegionDto> regionDtoList = new ArrayList<>(); //shart emas lekin bu ham ishladi

        RegionDto regionDto = new RegionDto();
        regionDto.setId(regionEntity.getId());
        regionDto.setOrderNum(regionEntity.getOrderNum());
        regionDto.setKey(regionEntity.getKey());
//        regionDto.setLenguagc(regionEntity.getLenguagc());
        regionDto.setNameUz(regionEntity.getNameUz());
        regionDto.setNameRu(regionEntity.getNameRu());
        regionDto.setNameEn(regionEntity.getNameEn());
        regionDto.setVisible(regionEntity.getVisible());
//        regionDtoList.add(regionDto); // buni o'zida list.add()(hlda ishlatamiz_)

        return regionDto;
    }



    public List<RegionShortDto> getByLeng(Lenguagc lenguagc)  {
        List<RegionEntity> regionEntityList = regionRepository.findAllByVisibleTrue();
        List<RegionShortDto> regionShortDtoList = new ArrayList<>();

        for (RegionEntity region : regionEntityList) {
            RegionShortDto regionShortDto = new RegionShortDto();
            regionShortDto.setId(region.getId());
            regionShortDto.setKey(region.getKey());

            switch (lenguagc) {
                case UZ -> regionShortDto.setName(region.getNameUz());
                case RU -> regionShortDto.setName(region.getNameRu());
                case EN -> regionShortDto.setName(region.getNameEn());
            }

            regionShortDtoList.add(regionShortDto);
        }

        return regionShortDtoList;
    }


}

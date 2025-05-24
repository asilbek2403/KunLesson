package asil.uz.darsKun_uz.firstsection.service;

import asil.uz.darsKun_uz.firstsection.Dto.LangResponseDTO;
import asil.uz.darsKun_uz.firstsection.Dto.SectionDto;
import asil.uz.darsKun_uz.firstsection.Enumrol.Lenguagc;
import asil.uz.darsKun_uz.firstsection.entity.SectionEntity;
import asil.uz.darsKun_uz.firstsection.exceptionlar.AppBadException;
import asil.uz.darsKun_uz.firstsection.exceptionlar.NotFoundException;
import asil.uz.darsKun_uz.firstsection.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class SectionService {

    @Autowired
    private SectionRepository repository;

    public SectionDto create(SectionDto dto){
        Optional<SectionEntity> optional = repository.findByOrderNumber(dto.getOrderNumber());
        if (optional.isPresent()) {
            throw new AppBadException("OrderNumber " + dto.getOrderNumber() + " already exist");
        }
        SectionEntity entity = new SectionEntity();
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        entity.setSectionKey(dto.getSectionKey());
        entity.setCreatedDate(LocalDateTime.now());
        entity.setImageId(dto.getImageId());
        repository.save(entity);
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public SectionDto update(Integer id, SectionDto newDto){
        Optional<SectionEntity> optional = repository.findById(id);
        if (optional.isEmpty() || optional.get().getVisible() == Boolean.FALSE){
            throw new NotFoundException("Section not found");
        }
        SectionEntity entity = optional.get();
        entity.setOrderNumber(newDto.getOrderNumber());
        entity.setNameUz(newDto.getNameUz());
        entity.setNameRu(newDto.getNameRu());
        entity.setNameEn(newDto.getNameEn());
        entity.setSectionKey(newDto.getSectionKey());
        newDto.setId(entity.getId());
        newDto.setCreatedDate(entity.getCreatedDate());
        newDto.setImageId(entity.getImageId());
        repository.save(entity);
        return newDto;
    }

    public Boolean delete(Integer id) {
        var entity = repository.findByIdAndVisibleIsTrue(id)
                .orElseThrow(() -> new NotFoundException("Section not found"));
        int i = repository.updateVisibleById(entity.getId());
        return i == 1;
    }

    public List<SectionDto> getAllByOrder() {
        Iterable<SectionEntity> iterable = repository.getAllByOrderSorted();
        List<SectionDto> dtos = new LinkedList<>();
        iterable.forEach(entity -> dtos.add(toDto(entity)));
        return dtos;
    }

    public List<LangResponseDTO> getAllbyLang(Lenguagc lang){
        Iterable<SectionEntity> iterable = repository.getAllByOrderSorted();
        List<LangResponseDTO> dtos = new LinkedList<>();
        iterable.forEach(entity -> dtos.add(toLangResponseDto(lang, entity)));
        return dtos;
    }

    private SectionDto toDto(SectionEntity entity) {
        SectionDto dto = new SectionDto();
        dto.setId(entity.getId());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setNameEn(entity.getNameEn());
        dto.setSectionKey(entity.getSectionKey());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setImageId(entity.getImageId());
        return dto;
    }

    private LangResponseDTO toLangResponseDto(Lenguagc lang, SectionEntity entity){
        LangResponseDTO dto = new LangResponseDTO();
        dto.setId(entity.getId());
        dto.setKey(entity.getSectionKey());
        switch (lang){
            case UZ:
                dto.setName(entity.getNameUz());
                break;
            case RU:
                dto.setName(entity.getNameRu());
                break;
            case EN:
                dto.setName(entity.getNameEn());
                break;
        }
        return dto;
    }

}

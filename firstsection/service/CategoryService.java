package asil.uz.darsKun_uz.firstsection.service;

import asil.uz.darsKun_uz.firstsection.Dto.CategoryDto;
import asil.uz.darsKun_uz.firstsection.Enumrol.Lenguagc;
import asil.uz.darsKun_uz.firstsection.entity.CategoryEntity;
import asil.uz.darsKun_uz.firstsection.exceptionlar.AppBadException;
import asil.uz.darsKun_uz.firstsection.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    public CategoryDto create(CategoryDto dto) {
        Optional<CategoryEntity> optional = repository.findByCategoryKey(dto.getCategoryKey());
        if (optional.isPresent()) {
            throw new AppBadException("Category key already exist");
        }
        CategoryEntity entity = new CategoryEntity();
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        entity.setCategoryKey(dto.getCategoryKey());
        entity.setVisible(Boolean.TRUE);
        entity.setCreatedDate(LocalDateTime.now());
        repository.save(entity);
        // response
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public CategoryDto update(Integer id, CategoryDto newDto) {// Jahon
        Optional<CategoryEntity> optional = repository.findByIdAndVisibleIsTrue(id);
        if (optional.isEmpty()) {
            throw new AppBadException("Category not found");
        }
        Optional<CategoryEntity> keyOptional = repository.findByCategoryKey(newDto.getCategoryKey()); // Jahon
        if (keyOptional.isPresent() && !id.equals(keyOptional.get().getId())) {
            throw new AppBadException("CategoryKey present");
        }
        // 1-Jahon,2-Iksodiyot,3-Sport
        CategoryEntity entity = optional.get();
        entity.setOrderNumber(newDto.getOrderNumber());
        entity.setNameUz(newDto.getNameUz());
        entity.setNameRu(newDto.getNameRu());
        entity.setNameEn(newDto.getNameEn());
        entity.setCategoryKey(newDto.getCategoryKey());
        repository.save(entity);

        newDto.setId(entity.getId());
        return newDto;
    }

    public Boolean delete(Integer id) {
        return repository.updateVisibleById(id) == 1;
    }

    public List<CategoryDto> getAllByOrder() {
        Iterable<CategoryEntity> iterable = repository.getAllByOrderSorted();
        List<CategoryDto> dtos = new LinkedList<>();
        iterable.forEach(entity -> dtos.add(toDto(entity)));
        return dtos;
    }

    public List<CategoryDto> getAllByLang(Lenguagc lang) { // uz
        Iterable<CategoryEntity> iterable = repository.getAllByOrderSorted(); // TODO  get category by lang 1
        List<CategoryDto> dtos = new LinkedList<>();
        iterable.forEach(entity -> dtos.add(toLangResponseDto(lang, entity)));
        return dtos;
    }

    private CategoryDto toDto(CategoryEntity entity) {
        CategoryDto dto = new CategoryDto();
        dto.setId(entity.getId());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setNameEn(entity.getNameEn());
        dto.setCategoryKey(entity.getCategoryKey());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    private CategoryDto toLangResponseDto(Lenguagc lang, CategoryEntity entity) {
        CategoryDto dto = new CategoryDto();
        dto.setId(entity.getId());
        dto.setCategoryKey(entity.getCategoryKey());
        switch (lang) {
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


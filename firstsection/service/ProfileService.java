package asil.uz.darsKun_uz.firstsection.service;

import asil.uz.darsKun_uz.firstsection.Dto.ProfileDTO;
import asil.uz.darsKun_uz.firstsection.entity.ProfileEntity;
import asil.uz.darsKun_uz.firstsection.repository.ProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository repository;

    public ProfileDTO create(ProfileDTO dto) {
        if (repository.findByUsername((dto.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setStatus(dto.getStatus());
        entity.setRoleList(dto.getRoleList());
        entity.setCreatedDate(LocalDateTime.now());
        repository.save(entity);

        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public ProfileDTO update(Integer id, ProfileDTO dto) {
        ProfileEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setRoleList(dto.getRoleList());
        entity.setStatus(dto.getStatus());
        repository.save(entity);
        return dto;
    }

    public Boolean delete(Integer id) {
        return repository.deleteById(id) == 1;
    }

    public Page<ProfileDTO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable).map(this::toDto);
    }

    public ProfileDTO updateOwnDetails(Integer id, ProfileDTO dto) {
        ProfileEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        repository.save(entity);
        return dto;
    }

    public void updatePhoto(Integer id, String photoId) {
        ProfileEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        entity.setPhotoId(photoId);
        repository.save(entity);
    }

    public List<ProfileDTO> filter(ProfileFilterDTO filter) {
        Specification<Profile> spec = ProfileSpecification.build(filter);
        return repository.findAll(spec).stream().map(this::toDto).collect(Collectors.toList());
    }

    private ProfileDTO toDto(Profile entity) {
        ProfileDTO dto = new ProfileDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}


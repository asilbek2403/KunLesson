package asil.uz.darsKun_uz.firstsection.repository;

import asil.uz.darsKun_uz.firstsection.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository  extends JpaRepository<RegionEntity, Integer> {
    List<RegionEntity> findAllByVisibleTrue();
    List<RegionEntity> findAllByVisibleFalse();

    Optional<RegionEntity> findByOrderNum(Integer number);




}

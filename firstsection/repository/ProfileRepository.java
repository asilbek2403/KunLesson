package asil.uz.darsKun_uz.firstsection.repository;

import asil.uz.darsKun_uz.firstsection.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfileRepository extends CrudRepository<ProfileEntity, Integer> {


    List<ProfileEntity> findByUsername(String username) {
        return null;
    }

}

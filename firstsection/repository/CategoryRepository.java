package asil.uz.darsKun_uz.firstsection.repository;

import asil.uz.darsKun_uz.firstsection.entity.CategoryEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

    @Query("from CategoryEntity where visible = true order by orderNumber asc")
    List<CategoryEntity> getAllByOrderSorted();


    @Transactional
    @Modifying
    @Query("update CategoryEntity set visible = false where id = ?1")
    int updateVisibleById(Integer id);

    Optional<CategoryEntity> findByIdAndVisibleIsTrue(Integer id);

    Optional<CategoryEntity> findByOrderNumber(Integer number);

    Optional<CategoryEntity> findByCategoryKey(String key);


}




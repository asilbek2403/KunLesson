package asil.uz.darsKun_uz.firstsection.entity;

//import asil.uz.darsKun_uz.firstsection.Enumrol.Lenguagc;
//import asil.uz.darsKun_uz.firstsection.Enumrol.RegionName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="region")
public class RegionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer orderNum;

    @Column
    private String description;

    @Column(unique= true, nullable = false)
    private String key;

    private Boolean visible;

    private LocalDate createdDate;  // DTO bilan mos

    private String nameUz;
    private String nameRu;
    private String nameEn;
}

//
//@Getter
//@Setter
//
//@Entity
//@Table(name="region")
//public class RegionEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @Column
//    private Integer orderNum;
//    @Column
//    private String description;
////    @Enumerated (EnumType.STRING)
////    @Column(nullable = false)
////    private Lenguagc lenguagc;
////@Enumerated (EnumType.STRING)
////    private RegionName regionName;
//    @Column(unique= true, nullable = false)
//    private String key;
//
//    private Boolean visible;
//
//    private LocalDate  createdDate;
//
//
//    private String nameUz;
//    private String nameRu;
//    private String nameEn;
//
//    public String getNameUz() {
//        return nameUz;}
//    public void setNameUz(String nameUz) {
//        this.nameUz = nameUz;
//    }
//    public String getNameRu() {
//        return nameRu;
//    }
//    public void setNameRu(String nameRu) {
//        this.nameRu = nameRu;
//    }
//    public String getNameEn() {
//        return nameEn;
//    }
//    public void setNameEn(String nameEn) {
//        this.nameEn = nameEn;
//    }
//
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getOrderNum() {
//        return orderNum;
//    }
//
//    public void setOrderNum(Integer orderNum) {
//        this.orderNum = orderNum;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
////    public Lenguagc getLenguagc() {
////        return lenguagc;
////    }
////
////    public void setLenguagc(Lenguagc lenguagc) {
////        this.lenguagc = lenguagc;
////    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    public Boolean getVisible() {
//        return visible;
//    }
//
//    public void setVisible(Boolean visible) {
//        this.visible = visible;
//    }
//
//    public LocalDate getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDate created_Date) {
//        this.createdDate = created_Date;
//    }
//
//
//
//}

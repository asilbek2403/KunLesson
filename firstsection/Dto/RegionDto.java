package asil.uz.darsKun_uz.firstsection.Dto;


import asil.uz.darsKun_uz.firstsection.Enumrol.Lenguagc;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class RegionDto {
    private Integer id;
    private Integer orderNum;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private String key;
    private Boolean visible;
    private LocalDate createdDate;  // LocalDate bilan moslashtirildi
    private String description;
}

//
//@Getter
//@Setter
//public class RegionDto {
//    private Integer id;
//    private Integer orderNum;
////    private Lenguagc lenguagc;
//    private String nameUz;
//    private String nameRu;
//    private String nameEn;
//
//
//    private String key;
//    private Boolean visible;
//
//    private LocalDate createdDate;
//    private String description;
//    // GET by language uchun qo‘shimcha name
////    private String name;
//
//    public String getNameUz() {
//        return nameUz;
//    }
//
//    public void setNameUz(String nameUz) {
//        this.nameUz = nameUz;
//    }
//
//    public String getNameRu() {
//        return nameRu;
//    }
//
//    public void setNameRu(String nameRu) {
//        this.nameRu = nameRu;
//    }
//
//    public String getNameEn() {
//        return nameEn;
//    }
//
//    public void setNameEn(String nameEn) {
//        this.nameEn = nameEn;
//    }
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
//    public void setCreatedDate(LocalDate createdDate) {
//        this.createdDate = createdDate;
//    }
//
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
//}

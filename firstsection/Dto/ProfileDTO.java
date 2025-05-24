package asil.uz.darsKun_uz.firstsection.Dto;

import asil.uz.darsKun_uz.firstsection.Enumrol.ProfileRole;
import asil.uz.darsKun_uz.firstsection.Enumrol.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class ProfileDTO {
    private Integer id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private ProfileStatus status;
    private List<ProfileRole> roleList;
    private LocalDateTime createdDate;
    private String photoId;
}


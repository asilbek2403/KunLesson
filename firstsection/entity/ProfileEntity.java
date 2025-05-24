package asil.uz.darsKun_uz.firstsection.entity;

import asil.uz.darsKun_uz.firstsection.Enumrol.ProfileRole;
import asil.uz.darsKun_uz.firstsection.Enumrol.ProfileStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter



@Entity
@Table(name="profile")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String username; // email or phone
    private String password;
    private Boolean visible = true;

    @Enumerated(EnumType.STRING)
    private ProfileStatus status;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<ProfileRole> roleList;

    @Column
    private LocalDateTime createdDate;
    @Column
    private String photoId;

}

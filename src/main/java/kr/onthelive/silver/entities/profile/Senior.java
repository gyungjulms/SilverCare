package kr.onthelive.silver.entities.profile;

import kr.onthelive.silver.entities.Account;
import kr.onthelive.silver.entities.device.Device;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "senior")
public class Senior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "senior_phone_number")
    private String seniorPhoneNumber;

    @Column(name = "senior_gender")
    private String seniorGender;

    @Column(name = "senior_blood_type")
    private String seniorBloodType;



    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "senior", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrganizationMember> organizationMembers = new ArrayList<>();

    @OneToMany(mappedBy = "senior", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Device> devices = new ArrayList<>();

}
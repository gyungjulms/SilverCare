package kr.onthelive.silver.entities.profile;

import kr.onthelive.silver.entities.Account;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "organization_member")
public class OrganizationMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "organization_member_address")
    private String organizationMemberAddress;

    @Column(name = "organization_member_photosrc")
    private String organizationMemberPhotosrc;

    @Column(name = "organization_member_gender")
    private String organizationMemberGender;

    @Column(name = "organization_member_birthday")
    private String organizationMemberBirthday;

    @Column(name = "organization_phone_number", unique = true)
    private String organizationPhoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "senior_id")
    private Senior senior;

}
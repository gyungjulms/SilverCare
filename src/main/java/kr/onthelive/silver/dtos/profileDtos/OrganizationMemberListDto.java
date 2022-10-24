package kr.onthelive.silver.dtos.profileDtos;

import kr.onthelive.silver.entities.profile.OrganizationMember;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * A DTO for the {@link OrganizationMember} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class OrganizationMemberListDto implements Serializable {
    private String organizationMemberAddress;
    private String organizationMemberPhotosrc;
    private String organizationMemberGender;
    private String organizationMemberBirthday;
    private String organizationPhoneNumber;
    private String result;
    private MemberAccountDto account;
}
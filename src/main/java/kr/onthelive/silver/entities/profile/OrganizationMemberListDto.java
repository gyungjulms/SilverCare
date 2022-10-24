package kr.onthelive.silver.entities.profile;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link OrganizationMember} entity
 */
@Data
public class OrganizationMemberListDto implements Serializable {
    private final String organizationMemberAddress;
    private final String organizationMemberPhotosrc;
    private final String organizationMemberGender;
    private final String organizationMemberBirthday;
    private final String organizationPhoneNumber;
    private final MemberAccountDto account;
}
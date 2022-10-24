package kr.onthelive.silver.mappers.profileMappers;

import kr.onthelive.silver.entities.profile.OrganizationMember;
import kr.onthelive.silver.dtos.profileDtos.OrganizationMemberListDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrganizationMemberMapper {
    OrganizationMember organizationMemberListDtoToOrganizationMember(OrganizationMemberListDto organizationMemberListDto);

    OrganizationMemberListDto organizationMemberToOrganizationMemberListDto(OrganizationMember organizationMember);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrganizationMember updateOrganizationMemberFromOrganizationMemberListDto(OrganizationMemberListDto organizationMemberListDto, @MappingTarget OrganizationMember organizationMember);
}

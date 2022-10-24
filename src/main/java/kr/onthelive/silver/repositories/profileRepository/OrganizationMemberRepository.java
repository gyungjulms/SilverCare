package kr.onthelive.silver.repositories.profileRepository;

import kr.onthelive.silver.entities.profile.OrganizationMember;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationMemberRepository extends JpaRepository<OrganizationMember, Long> {
    OrganizationMember findOrganizationMemberByAccount_UserId(@NonNull String userId);
}
package kr.onthelive.silver.dtos.profileDtos;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * A DTO for the {@link kr.onthelive.silver.entities.Account} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MemberAccountDto implements Serializable {
    private String userId;
    private String accountPassword;
    private String accountName;
    private String accountRole;
}
package kr.onthelive.silver.entities.profile;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link kr.onthelive.silver.entities.Account} entity
 */
@Data
public class MemberAccountDto implements Serializable {
    private final String userId;
    private final String accountPassword;
    private final String accountRole;
    private final String accountName;
}
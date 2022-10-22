package kr.onthelive.silver.dtos.LoginPageDtos;

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
public class LoginResponseDto implements Serializable {
    private int id;
    private String accountId;
    private String accountRole;
    private String accountName;
    private String jwtToken;
    private String result;
}
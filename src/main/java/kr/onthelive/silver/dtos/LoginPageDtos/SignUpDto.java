package kr.onthelive.silver.dtos.LoginPageDtos;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link kr.onthelive.silver.entities.Account} entity
 */

@AllArgsConstructor
@NoArgsConstructor
@Component
@Getter
@Setter
public class SignUpDto implements Serializable {
    private String accountId;
    private String accountPassword;
    private String accountName;
}
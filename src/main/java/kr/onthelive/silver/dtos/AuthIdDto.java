package kr.onthelive.silver.dtos;

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
public class AuthIdDto implements Serializable {
    private String accountId;
}
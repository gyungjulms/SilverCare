package kr.onthelive.silver.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link kr.onthelive.silver.entities.Account} entity
 */
@Data
public class AuthIdDto implements Serializable {
    private String userId;
}
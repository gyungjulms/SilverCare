package kr.onthelive.silver.dtos.LoginPageDtos;

import kr.onthelive.silver.dtos.base.BaseResponseDto;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class JwtResponseDto extends BaseResponseDto implements Serializable {
    private String jwtToken;
}

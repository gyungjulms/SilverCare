package kr.onthelive.silver.mappers;

import kr.onthelive.silver.dtos.LoginPageDtos.LoginResponseDto;
import kr.onthelive.silver.entities.Account;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LoginResponseMapper {
    Account loginResponseDtoToAccount(LoginResponseDto loginResponseDto);

    LoginResponseDto accountToLoginResponseDto(Account account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account updateAccountFromLoginResponseDto(LoginResponseDto loginResponseDto, @MappingTarget Account account);
}

package kr.onthelive.silver.mappers;

import kr.onthelive.silver.dtos.LoginPageDtos.LoginDto;
import kr.onthelive.silver.entities.Account;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LoginMapper {
    Account loginDtoToAccount(LoginDto loginDto);

    LoginDto accountToLoginDto(Account account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account updateAccountFromLoginDto(LoginDto loginDto, @MappingTarget Account account);
}

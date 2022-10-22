package kr.onthelive.silver.mappers;

import kr.onthelive.silver.dtos.LoginPageDtos.SignUpDto;
import kr.onthelive.silver.entities.Account;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SignUpMapper {
    Account signUpDtoToAccount(SignUpDto signUpDto);

    SignUpDto accountToSignUpDto(Account account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account updateAccountFromSignUpDto(SignUpDto signUpDto, @MappingTarget Account account);
}

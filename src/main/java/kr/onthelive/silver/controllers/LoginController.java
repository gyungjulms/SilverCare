package kr.onthelive.silver.controllers;

import io.swagger.annotations.Api;
import kr.onthelive.silver.dtos.LoginPageDtos.LoginDto;
import kr.onthelive.silver.dtos.LoginPageDtos.LoginResponseDto;
import kr.onthelive.silver.entities.Account;
import kr.onthelive.silver.mappers.LoginResponseMapper;
import kr.onthelive.silver.repositories.AccountRepository;
import kr.onthelive.silver.security.JwtTokenProvider;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Data
@CrossOrigin
@Api(tags = "로그인 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private final AccountRepository accountRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final LoginResponseMapper loginResponseMapper;
    //    Account account = new Account();


    @PostMapping("/login")
    public LoginResponseDto canLogin(@RequestBody @NonNull @Valid LoginDto loginDto) {
//        AccountDto accountDto = new AccountDto();
        Account account = accountRepository.findByAccountId(loginDto.getAccountId());
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        if (account == null) {
            loginResponseDto.setResult("Not found Id");
            return loginResponseDto;
        }
        else if (account.getAccountPassword().equals(loginDto.getAccountPassword())) {
            loginResponseDto = loginResponseMapper.accountToLoginResponseDto(account);
            loginResponseDto.setJwtToken(JwtTokenProvider.generateToken(account.getAccountId(),account.getAccountRole()));
            loginResponseDto.setResult("success");
            return loginResponseDto;
        }
        else {
            loginResponseDto.setResult("Not found password");
            System.out.println("로그인 실패했노 ...");
            return loginResponseDto;
        }

    }


//    public JwtResponseDto canLogin(@RequestBody @NonNull @Valid LoginDto loginDto) {
//        JwtResponseDto jwtResponseDto = new JwtResponseDto();
//        if (loginDto.getUserid().equals("id") && loginDto.getPassword().equals("pw")) {
//            jwtResponseDto.setSuccess();
//            jwtResponseDto.setJwtToken(JwtTokenProvider.generateToken(loginDto.getUserid(), ""));
//        } else {
//            jwtResponseDto.setFailure("wrong id/password...");
//        }
//        return jwtResponseDto;
//    }
};

//    @PostMapping("/signin")
//    public

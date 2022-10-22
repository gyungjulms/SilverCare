package kr.onthelive.silver.controllers;


import io.swagger.annotations.Api;
import kr.onthelive.silver.dtos.LoginPageDtos.ResultDto;
import kr.onthelive.silver.dtos.LoginPageDtos.SignUpDto;
import kr.onthelive.silver.entities.Account;
import kr.onthelive.silver.mappers.SignUpMapper;
import kr.onthelive.silver.repositories.AccountRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Data
@CrossOrigin
@RestController
@Api(tags = "회원가입 컨트롤러")
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private final AccountRepository accountRepository;
    private final SignUpMapper signUpMapper;

    @PostMapping("/signup")
    public synchronized ResultDto add(@RequestBody @NonNull SignUpDto signUpDto) {

       Account account = new Account();
        System.out.println(signUpMapper.signUpDtoToAccount(signUpDto));
        account = signUpMapper.signUpDtoToAccount(signUpDto);
        accountRepository.save(account);
        ResultDto resultDto = new ResultDto();
        resultDto.setResult("success");
        return resultDto;
    }


//    @GetMapping("/getall")
//    public List<Account> getAllSignup(){
//        return signupService.getAllSignUp();
//    }
    }

//    @PostMapping("/login")
//    public String login();

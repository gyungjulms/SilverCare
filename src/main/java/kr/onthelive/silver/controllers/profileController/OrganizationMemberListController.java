package kr.onthelive.silver.controllers.profileController;


import io.swagger.annotations.Api;
import kr.onthelive.silver.dtos.AuthIdDto;
import kr.onthelive.silver.dtos.LoginPageDtos.ResultDto;
import kr.onthelive.silver.entities.Account;
import kr.onthelive.silver.entities.profile.OrganizationMember;
import kr.onthelive.silver.entities.profile.OrganizationMemberListDto;
import kr.onthelive.silver.mappers.profileMappers.OrganizationMemberMapper;
import kr.onthelive.silver.repositories.AccountRepository;
import kr.onthelive.silver.repositories.profileRepository.OrganizationMemberRepository;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@Data
@CrossOrigin
@RestController
@Api(tags = "기관 맴버 ")
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrganizationMemberListController {

    @Autowired
    private final OrganizationMemberRepository organizationMemberRepository;
    private final OrganizationMemberMapper organizationMemberMapper;
    private final AccountRepository accountRepository;



    @PostMapping("/memberaccount/create")
    public ResultDto  addMemberAccount(@RequestBody @NonNull OrganizationMemberListDto organizationMemberListDto ) {
        ResultDto resultDto = new ResultDto();
        Account searchedAccount = new Account();
//        OrganizationMember searchedOrganization = new OrganizationMember();

        searchedAccount = accountRepository.findByUserId(organizationMemberListDto.getAccount().getUserId());
        if (searchedAccount == null) {
            OrganizationMember organizationMember;
            organizationMember = organizationMemberMapper.organizationMemberListDtoToOrganizationMember(organizationMemberListDto);
            System.out.println(organizationMember);
            organizationMemberRepository.save(organizationMember);
            resultDto.setResult("success");
            return resultDto;
        } else  {
            resultDto.setResult("failed");
            return resultDto;
        }
    }


    @PostMapping("/memberaccount/update")
    public ResultDto updateMemberAccount(@RequestBody @NonNull OrganizationMemberListDto organizationMemberListDto){
        ResultDto resultDto = new ResultDto();
        OrganizationMember organizationMember ;
        organizationMember = organizationMemberRepository.findOrganizationMemberByAccount_UserId(organizationMemberListDto.getAccount().getUserId());
        if ( organizationMember != null && organizationMember.getAccount().getAccountUseFlag().equals(true)) {
            organizationMemberRepository.save(organizationMemberMapper.updateOrganizationMemberFromOrganizationMemberListDto(organizationMemberListDto, organizationMember));
            resultDto.setResult("success");
            return resultDto;
        } else {
            resultDto.setResult("failed");
            return resultDto;
        }
    };

    @PostMapping("/memberaccount/read")
    public synchronized OrganizationMemberListDto readMemberAccount(@RequestBody @NonNull AuthIdDto authIdDto){
//        Account account = accountRepository.findByUserId(authIdDto.getUserId());
        OrganizationMember organizationMember;
        OrganizationMemberListDto organizationMemberListDto;
        System.out.println(authIdDto.getUserId());
        System.out.println(authIdDto);
        organizationMember = organizationMemberRepository.findOrganizationMemberByAccount_UserId(authIdDto.getUserId());


        if (organizationMember != null) {
            organizationMemberListDto = organizationMemberMapper.organizationMemberToOrganizationMemberListDto(organizationMember);
            return organizationMemberListDto;
        } else {
            return null;
        }
    }

    @PostMapping("/memberaccount/delete")
    public ResultDto deleteMemberAccount(@RequestBody @NonNull AuthIdDto authIdDto){
        OrganizationMember organizationMember = organizationMemberRepository.findOrganizationMemberByAccount_UserId(authIdDto.getUserId());
        ResultDto resultDto = new ResultDto();
        if (organizationMember != null ){
        Account account = accountRepository.findByUserId(organizationMember.getAccount().getUserId());
        account.setAccountUseFlag(false);
        accountRepository.save(account);
        resultDto.setResult("success");
        return resultDto;
        } else {
            return null;
        }
    }

//    @PostMapping("/memberaccount/read")
//    public OrganizationMemberListDto readMemberAccount(@RequestBody @NonNull AuthIdDto authIdDto) {
//        Account account = accountRepository.findByUserId(authIdDto.getUserId());
//        if (account.getAccountRole().equals() );
//    }


}

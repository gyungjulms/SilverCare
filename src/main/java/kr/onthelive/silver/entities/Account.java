package kr.onthelive.silver.entities;

import kr.onthelive.silver.entities.profile.OrganizationMember;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "account_password", nullable = false)
    private String accountPassword;

    @Builder.Default
    @Column(name = "account_role", nullable = false)
    private String accountRole = "user";

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Builder.Default
    @Column(name = "account_use_flag")
    private Boolean accountUseFlag = true;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private OrganizationMember organizationMember;

}
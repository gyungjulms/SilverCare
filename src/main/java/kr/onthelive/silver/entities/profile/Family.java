package kr.onthelive.silver.entities.profile;

import kr.onthelive.silver.entities.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "family_address")
    private String family_address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "senior_id")
    private Senior seniorId;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Account account;

}
package kr.onthelive.silver.repositories;

import kr.onthelive.silver.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountId(@NonNull String UserId);
}
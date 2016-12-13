package com.tomogle.springaccount.services;

import com.tomogle.springaccount.entities.Account;
import com.tomogle.springaccount.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service @Transactional
@Profile("dev")
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Transactional(readOnly = true)
  public BigDecimal getBalance(final Long id) {
    return accountRepository.getAccount(id).getBalance();
  }

  public BigDecimal deposit(final Long id, final BigDecimal amount) {
    Account account = accountRepository.getAccount(id);
    BigDecimal initialBalance = account.getBalance();
    BigDecimal newBalance = initialBalance.add(amount);
    account.setBalance(newBalance);
    accountRepository.updateAccount(account);
    return newBalance;
  }
}

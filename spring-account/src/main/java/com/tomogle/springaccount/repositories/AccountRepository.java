package com.tomogle.springaccount.repositories;

import com.tomogle.springaccount.entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository {

  List<Account> getAccounts();
  Account getAccount(Long id);
  int getNumberOfAccounts();
  Long createAccount(BigDecimal initialBalance);
  int deleteAccount(Long id);
  void updateAccount(Account account);
}

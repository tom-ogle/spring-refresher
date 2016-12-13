package com.tomogle.springaccount.entities;

import org.springframework.util.Assert;

import java.math.BigDecimal;

public class Account {

  private Long id;
  private BigDecimal balance;

  public Account(final Long id, final BigDecimal balance) {
    Assert.notNull(id);
    Assert.notNull(balance);
    this.id = id;
    this.balance = balance;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(final BigDecimal balance) {
    this.balance = balance;
  }

  public Long getId() {
    return id;
  }

  @Override public String toString() {
    return "Account{" +
        "id=" + id +
        ", balance=" + balance +
        '}';
  }

  @Override public boolean equals(final Object o) {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;

    Account account = (Account) o;

    return id != null ? id.equals(account.id) : account.id == null;
  }

  @Override public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}

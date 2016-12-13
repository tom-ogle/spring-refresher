package com.tomogle.springaccount.entities;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class AccountTest {
  
  @Test
  public void shouldCreateAccountForNonNullArguments() throws Exception {
    Account account = new Account(1L, new BigDecimal(10));
    assertNotNull(account);
  }

  @Test
  public void shouldAllowRetrievalOfBalance() throws Exception {
    BigDecimal balance = new BigDecimal(20);
    Account account = new Account(1L, balance);
    assertEquals(balance, account.getBalance());
  }

  @Test
  public void shouldAllowRetrievalOfId() throws Exception {
    Long id = 20L;
    Account account = new Account(id, new BigDecimal(20));
    assertEquals(id, account.getId());
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowForNullId() throws Exception {
    new Account(null, new BigDecimal(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowForNullBalance() throws Exception {
    new Account(1L, null);
  }

  @Test
  public void shouldGiveSameHashcodeForObjectsWithSameId() throws Exception {
    Account account1 = new Account(2L, new BigDecimal(20));
    Account account2 = new Account(2L, new BigDecimal(25));
    int hashCode1 = account1.hashCode();
    int hashCode2 = account2.hashCode();
    assertEquals(hashCode1, hashCode2);
  }

  @Test
  public void shouldBeEqualForDifferentObjectsWithSameInternalState() throws Exception {
    Account account1 = new Account(5L, new BigDecimal(25));
    Account account2 = new Account(5L, new BigDecimal(25));
    assertEquals(account1, account2);
  }

  @Test
  public void shouldBeUnEqualForObjectsWithDifferentId() throws Exception {
    Account account1 = new Account(5L, new BigDecimal(25));
    Account account2 = new Account(6L, new BigDecimal(25));
    assertNotEquals(account1, account2);
  }

  @Test
  public void shouldBeEqualForObjectsWithSameIdDifferentBalance() throws Exception {
    Account account1 = new Account(5L, new BigDecimal(25));
    Account account2 = new Account(5L, new BigDecimal(30));
    assertEquals(account1, account2);
  }
}
package com.tomogle.springaccount.repositories;

import com.tomogle.springaccount.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Profile({"dev", "test"})
public class JdbcAccountRepository implements AccountRepository {

  private JdbcTemplate template;
  private static long nextId = 4;

  @Autowired
  public JdbcAccountRepository(final DataSource dataSource) {
    template = new JdbcTemplate(dataSource);
  }

  @Override public List<Account> getAccounts() {
    String sql = "SELECT * FROM account";
    return template.query(sql, new AccountMapper());
  }

  @Override public Account getAccount(final Long id) {
    String sql = "SELECT * FROM account WHERE id = ?";
    return template.queryForObject(sql, new AccountMapper(), id);
  }

  @Override public int getNumberOfAccounts() {
    String sql = "SELECT COUNT(*) FROM account";
    return template.queryForObject(sql, Integer.class);
  }

  @Override public Long createAccount(final BigDecimal initialBalance) {
    String sql = "INSERT INTO account (id, balance) VALUES (?, ?)";
    long id = nextId++;
    template.update(sql, id, initialBalance);
    return id;
  }

  @Override public int deleteAccount(final Long id) {
    String sql = "DELETE FROM account WHERE id = ?";
    return template.update(sql, id);
  }

  @Override public void updateAccount(final Account account) {
    String sql = "UPDATE account set balance = ? where id = ?";
    template.update(sql, account.getBalance(), account.getId());
  }

  private class AccountMapper implements RowMapper<Account> {

    @Override public Account mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
      return new Account(resultSet.getLong("id"), resultSet.getBigDecimal("balance"));
    }
  }
}

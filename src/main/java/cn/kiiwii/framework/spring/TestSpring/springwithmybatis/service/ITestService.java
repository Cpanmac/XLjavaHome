package cn.kiiwii.framework.spring.TestSpring.springwithmybatis.service;

import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.model.Account;
import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.model.User;

import java.util.List;

public interface ITestService {
    public void test();

    public boolean transfer(float money, int from, int to) throws Exception;

    public int insertAccount(Account account) throws Exception;

    public Account findAccountById(int i);

    public User findUserById(int i);

    public List<Account> findAccountsById(int i);
}

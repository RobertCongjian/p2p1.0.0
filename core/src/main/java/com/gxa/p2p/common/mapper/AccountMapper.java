package com.gxa.p2p.common.mapper;


import com.gxa.p2p.common.domain.Account;

public interface AccountMapper {

    int insertAccount(Account account);

    Account getAccountById(Long id);

}
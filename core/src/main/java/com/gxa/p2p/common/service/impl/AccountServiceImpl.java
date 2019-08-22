package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccountById(Long id) {
        return accountMapper.getAccountById(id);
    }
}

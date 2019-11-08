package com.gxa.p2p.common.mapper;


import com.gxa.p2p.common.domain.Account;import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountMapper {

    int insertAccount(Account account);

    Account getAccountById(Long id);

    void updateByUserId(@Param("userId")Long userId, @Param("amount")BigDecimal amount);
}
package com.gxa.p2p.common.service;

import java.math.BigDecimal;

public interface BidService {

    int invest(Long bidRequestId, BigDecimal amount);
}

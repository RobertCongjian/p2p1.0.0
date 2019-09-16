package com.gxa.p2p.business.mapper;

import com.gxa.p2p.business.domain.Bid;

import java.util.List;

public interface BidMapper {

    public int insertBid(Bid bid);

    List<Bid> getBidsById(Long id);
}

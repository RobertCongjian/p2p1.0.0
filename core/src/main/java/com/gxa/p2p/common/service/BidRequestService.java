package com.gxa.p2p.common.service;

import com.gxa.p2p.business.domain.BidRequest;
import com.gxa.p2p.common.query.BidRequestQueryObject;
import com.gxa.p2p.common.query.PageResultSet;

import java.util.List;
import java.util.Map;

public interface BidRequestService {
    int insertBidRequest(BidRequest bidRequest);

    PageResultSet queryForPage(BidRequestQueryObject bidRequestQueryObject,int id);

    Map<String, Object> queryInfoById(Long id);

    List<BidRequest> queryPassAuditing();


    PageResultSet queryForPageWithState(BidRequestQueryObject bidRequestQueryObject);
}

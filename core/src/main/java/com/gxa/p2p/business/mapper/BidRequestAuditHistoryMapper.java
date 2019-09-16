package com.gxa.p2p.business.mapper;

import com.gxa.p2p.business.domain.BidRequestAuditHistory;

import java.util.List;

public interface BidRequestAuditHistoryMapper {
    int insertInfo(BidRequestAuditHistory bidRequestAuditHistory);

    BidRequestAuditHistory queryByBidRequestId(Long id);

    List<BidRequestAuditHistory> queryAllInfo();

    List<BidRequestAuditHistory> listAuditHistorayByBidRequest(Long id);
}

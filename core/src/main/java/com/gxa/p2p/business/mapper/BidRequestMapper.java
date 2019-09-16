package com.gxa.p2p.business.mapper;

import com.gxa.p2p.business.domain.BidRequest;
import com.gxa.p2p.common.query.BidRequestQueryObject;
import org.apache.ibatis.annotations.Param;import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BidRequestMapper {
    int insertBidRequest(BidRequest bidRequest);

    int queryForCount(long id);

    List<BidRequest> queryForPage(@Param("bidRequestQueryObject")BidRequestQueryObject bidRequestQueryObject, @Param("id")long id);

    BidRequest queryById(Long bidRequestId);

    int updateItem(@Param("bidRequestupdate")BidRequest bidRequestupdate, @Param("id")Long id);

    List<BidRequest> queryPassAuditing();

    int queryForCountWithState(@Param("bidRequestQueryObject")BidRequestQueryObject bidRequestQueryObject);

    List<BidRequest> queryForPageWithState(@Param("bidRequestQueryObject")BidRequestQueryObject bidRequestQueryObject);
}

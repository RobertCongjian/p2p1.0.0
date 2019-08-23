package com.gxa.p2p.common.service;

import com.gxa.p2p.common.query.IplogQueryObject;
import com.gxa.p2p.common.query.PageResultSet;

import java.util.List;

public interface IplogService {
    PageResultSet queryforPage(IplogQueryObject iplogQueryObject);
}

package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.mapper.IplogMapper;
import com.gxa.p2p.common.query.IplogQueryObject;
import com.gxa.p2p.common.query.PageResultSet;
import com.gxa.p2p.common.service.IplogService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IplogServiceImpl implements IplogService {


    @Autowired
    private IplogMapper iplogMapper;

    @Override
    public PageResultSet queryforPage(IplogQueryObject iplogQueryObject) {
        LoginInfo loginInfo = UserContext.getLoginInfo();
        String username = loginInfo.getUsername();
        int count =iplogMapper.queryForCount(iplogQueryObject,username);

        PageResultSet pageResultSet;
        //如果存在符合条件的数据，对数据进行分页查询，获取当前页的数据;没有则返回空的数据集

        if(count>0){
            List<Iplog> iplogs = iplogMapper.queryForPage(iplogQueryObject,username);
            for(Iplog iplog:iplogs){
                System.err.println(iplog.toString());
                System.out.println();
            }
            pageResultSet = new PageResultSet(
                    iplogs,
                    count,
                    iplogQueryObject.getCurrentPage(),
                    iplogQueryObject.getPageSize()
            );


        }else {
            pageResultSet = PageResultSet.empty(iplogQueryObject.getPageSize());
        }
        return pageResultSet;
    }
}

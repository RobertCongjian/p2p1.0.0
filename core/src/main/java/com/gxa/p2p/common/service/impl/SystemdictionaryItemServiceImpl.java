package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.mapper.SystemdictionaryitemMapper;
import com.gxa.p2p.common.service.SystemdictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SystemdictionaryItemServiceImpl implements SystemdictionaryItemService {

    @Autowired
    private SystemdictionaryitemMapper systemdictionaryitemMapper;

    @Override
    public List<Systemdictionaryitem> getAllInfo() {
        return systemdictionaryitemMapper.selectAll();
    }
}

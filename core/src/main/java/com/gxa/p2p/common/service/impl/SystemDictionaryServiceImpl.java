package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Systemdictionary;
import com.gxa.p2p.common.mapper.SystemdictionaryMapper;
import com.gxa.p2p.common.service.SystemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SystemDictionaryServiceImpl implements SystemDictionaryService {

    @Autowired
    private SystemdictionaryMapper systemdictionaryMapper;

    @Override
    public List<Systemdictionary> getAllInfo() {
        return systemdictionaryMapper.selectAll();
    }
}

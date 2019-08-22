package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Systemdictionaryitem;
import java.util.List;

public interface SystemdictionaryitemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemdictionaryitem record);

    Systemdictionaryitem selectByPrimaryKey(Long id);

    List<Systemdictionaryitem> selectAll();

    int updateByPrimaryKey(Systemdictionaryitem record);

    List<Systemdictionaryitem> selectItemBysn(String sn);
}
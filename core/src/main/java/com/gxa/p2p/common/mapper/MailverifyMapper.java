package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Mailverify;
import java.util.List;

public interface MailverifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Mailverify record);

    Mailverify selectByPrimaryKey(Long id);

    List<Mailverify> selectAll();

    int updateByPrimaryKey(Mailverify record);

    Mailverify selectByUUID(String uuid);
}
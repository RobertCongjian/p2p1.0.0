package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Userinfo;import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserinfoMapper {


    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Long id);

    Userinfo getUserInfoAndSystemdictionaryById(Long id);

    int updateItem(@Param("userinfo")Userinfo userinfo, @Param("id")Long id);

}
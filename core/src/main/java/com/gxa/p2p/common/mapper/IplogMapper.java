package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.query.IplogQueryObject;import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IplogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Iplog record);

    Iplog selectByPrimaryKey(Long id);

    List<Iplog> selectAll();

    int updateByPrimaryKey(Iplog record);

    int queryForCount(@Param("iplogQueryObject")IplogQueryObject iplogQueryObject, @Param("username")String username);

    List<Iplog> queryForPage(@Param("iplogQueryObject")IplogQueryObject iplogQueryObject, @Param("username")String username);
}
package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.query.LoginInfoQueryObject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface LoginInfoMapper {
    int deleteByPrimaryKey(Long id);

    /**
     * 新用户注册
     *
     * @param loginInfo
     *
     */
    int insert(LoginInfo loginInfo);


    LoginInfo selectByPrimaryKey(Long id);

    List<LoginInfo> selectAll();

    int updateByPrimaryKey(LoginInfo record);

    int selectCountByUsername(String username);


    LoginInfo login(@Param("username") String username, @Param("password") String password, @Param("usertype")int usertype);

    int queryForCount();

    List<LoginInfo> queryForPage(LoginInfoQueryObject loginInfoQueryObject);
}
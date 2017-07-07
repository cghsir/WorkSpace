package com.cghsir.mapper;

import com.cghsir.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("users");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPsw() != null) {
            sql.VALUES("psw", "#{psw,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}
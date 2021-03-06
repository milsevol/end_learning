package com.johnny.chapter2.main;

import com.johnny.chapter2.mapper.RoleMapper;
import com.johnny.chapter2.po.Role;
import com.johnny.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chapter2Main01 {

    private static Logger logger = LogManager.getLogger(Chapter2Main01.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
           // Role role = new Role("name", "note");
            roleMapper.getRole(1l);
           // roleMapper.insertRole(role);
            //roleMapper.deleteRole(1L);
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("执行成功!");
    }
}
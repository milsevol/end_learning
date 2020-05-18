package com.johnny.chapter2.main;

import com.johnny.chapter2.mapper.RoleMapper;
import com.johnny.chapter2.po.Role;
import com.johnny.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chapter2Main02 {

    private static Logger logger = LogManager.getLogger(Chapter2Main02.class.getName());

    /**
     * SqlSession 发送 SQL
     * @param args
     */
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            Role role = sqlSession.selectOne("com.johnny.chapter2.mapper.RoleMapper.getRole",2L);
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
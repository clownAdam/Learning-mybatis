package cn.clown.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * <p>工具类</p>
 *
 * @author clown
 * @date 2021
 */
public class MyBatisUtil {
    /**
     * 定义SqlSessionFactory
     */
    private static SqlSessionFactory factory = null;

    static {
        //使用静态块创建一次SqlSessionFactory
        String config = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            factory = null;
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }
}

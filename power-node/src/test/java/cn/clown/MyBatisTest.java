package cn.clown;


import cn.clown.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testStart() throws IOException {
        //mybatis主配置文件
        final String config = "mybatis.xml";
        //读取配置文件
        InputStream in = Resources.getResourceAsStream(config);
        //创建sqlSessionFactory对象,目的是获取sqlsession
        SqlSessionFactoryBuilder factory = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = factory.build(in);
        //获取sqlsession,sqlSession能执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sqlSession的selectList()
        List<Student> list = sqlSession.selectList("cn.clown.dao.StudentDao.selectAllStudents");

        list.forEach(student -> System.out.println(student));

        sqlSession.close();

    }

}

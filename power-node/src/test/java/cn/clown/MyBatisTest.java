package cn.clown;


import cn.clown.common.MyBatisUtil;
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

    @Test
    public void testInsert() throws IOException {
        String config = "mybatis.xml";
        /**
         * Resources:用于读取资源文件
         */
        InputStream in = Resources.getResourceAsStream(config);
        /**
         * SqlSessionFactoryBuilder():
         */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Student student = new Student(4, "李四", "444@qq.com", 44);
        int rows = sqlSession.insert("cn.clown.dao.StudentDao.insertStudent", student);

//        sqlSession.commit();
        System.out.println("增加记录的行数：" + rows);
        sqlSession.close();
    }

    @Test
    public void testUtils() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> list = sqlSession.selectList("cn.clown.dao.StudentDao.selectAllStudents");
        List<Object> list1 = sqlSession.selectList("aaa");
        list1.forEach(item -> System.out.println(item));
    }
}

package cn.clown;


import cn.clown.common.MyBatisUtil;
import cn.clown.dao.StudentDao;
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
        list1.forEach(System.out::println);
    }

    @Test
    public void testMapper() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);

        List<Student> students = mapper.selectAllStudents();
        students.forEach(System.out::println);

//        int zhang = mapper.insertStudent(new Student(8, "zhang", "32f2fr@qq.com", 23));
//        System.out.println("zhang = " + zhang);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.selectById(1);
        System.out.println("student = " + student);
        sqlSession.close();
    }
    @Test
    public void testSelectMultiParam() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
        SqlSession sqlSession = factory.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.selectMultiParam("张三", 44);
        students.forEach(System.out::println);
        sqlSession.close();
    }
}

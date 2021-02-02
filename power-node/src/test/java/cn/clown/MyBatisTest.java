package cn.clown;


import cn.clown.common.MyBatisUtil;
import cn.clown.dao.StudentDao;
import cn.clown.domain.PrimaryStudent;
import cn.clown.domain.Student;
import cn.clown.vo.QueryParam;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
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
    public void testSelectById() {
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

    @Test
    public void testSelectMultiObject() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> students = sqlSession.getMapper(StudentDao.class).selectMultiObject(new QueryParam("王五", 44));
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectByNameOrAge() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.selectByNameOrAge("李四", 25);
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectMultiMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 44);
        List<Student> students = mapper.selectMultiMap(map);
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testCountStudent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        int count = mapper.countStudent();
        System.out.println("count = " + count);
        sqlSession.close();
    }

    @Test
    public void testSelectReturnMap() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = mapper.selectReturnMap(1);
        System.out.println("map = " + map);
        sqlSession.close();
    }

    @Test
    public void testSelectUseResultMap() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.selectUseResultMap(new QueryParam("张三", 44));
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectUseFieldAlias() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<PrimaryStudent> students = mapper.selectUseFieldAlias(new QueryParam("张三", 44));
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectUseDiffResultMap() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<PrimaryStudent> students = mapper.selectUseDiffResultMap(new QueryParam("张三", 44));
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectLikeFirst() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
//        List<Student> students = mapper.selectLikeFirst("%李%");
        List<Student> students = mapper.selectLikeFirst("李");
        students.forEach(System.out::println);
        sqlSession.close();
    }
}

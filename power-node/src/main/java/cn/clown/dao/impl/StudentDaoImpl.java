package cn.clown.dao.impl;

import cn.clown.common.MyBatisUtil;
import cn.clown.domain.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * dao接口实现类
 *
 * @author clown
 * @date 2021
 */
public class StudentDaoImpl {
    public List<Student> selectAllStudents() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> selectAllStudents = sqlSession.selectList("selectAllStudents");
        sqlSession.close();
        return selectAllStudents;
    }

    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int flag = sqlSession.insert("insertStudent", student);
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }
}

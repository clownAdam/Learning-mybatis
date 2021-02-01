package cn.clown.dao;

import cn.clown.domain.Student;

import java.util.List;

/**
 * Student Dao interface
 *
 * @author clown
 * @date 2021
 */
public interface StudentDao {
    /**
     * 查询所有数据
     *
     * @return 返回所有的Student数据信息
     */
    List<Student> selectAllStudents();

    /**
     * 插入student数据
     * @param student 数据
     * @return 插入状态
     */
    int insertStudent(Student student);
}

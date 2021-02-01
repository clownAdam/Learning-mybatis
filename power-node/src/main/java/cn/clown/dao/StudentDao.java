package cn.clown.dao;

import cn.clown.domain.Student;
import org.apache.ibatis.annotations.Param;

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
     *
     * @param student 数据
     * @return 插入状态
     */
    int insertStudent(Student student);

    /**
     * 根据id进行查找student
     *
     * @param personid id
     * @return student
     */
    Student selectById(int personid);

    /**
     * 查找多个
     * @param age age
     * @param name name
     * @return list student
     */
    List<Student> selectMultiParam(@Param("name") String name, @Param("age") int age);
}

package cn.clown.dao;

import cn.clown.domain.PrimaryStudent;
import cn.clown.domain.Student;
import cn.clown.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
     * @param personId id
     * @return student
     */
    Student selectById(int personId);

    /**
     * 查找多个
     *
     * @param age  age
     * @param name name
     * @return list student
     */
    List<Student> selectMultiParam(@Param("name") String name, @Param("age") int age);

    /**
     * 查找对象
     *
     * @param queryParam 对象参数
     * @return student
     */
    List<Student> selectMultiObject(QueryParam queryParam);

    /**
     * select
     *
     * @param name name
     * @param age  age
     * @return students
     */
    List<Student> selectByNameOrAge(String name, int age);

    /**
     * map-list
     *
     * @param map map
     * @return students
     */
    List<Student> selectMultiMap(Map<String, Object> map);

    /**
     * 查询学生总人数
     *
     * @return countStudent
     */
    int countStudent();

    /**
     * select
     *
     * @param id id
     * @return map
     */
    Map<Object, Object> selectReturnMap(int id);

    /**
     * selectUseResultMap
     *
     * @param queryParam queryParam
     * @return Students
     */
    List<Student> selectUseResultMap(QueryParam queryParam);

    /**
     * selectUseFieldAlias
     *
     * @param queryParam queryParam
     * @return PrimaryStudent
     */
    List<PrimaryStudent> selectUseFieldAlias(QueryParam queryParam);

    /**
     * selectUseDiffResultMap
     *
     * @param queryParam queryParam
     * @return PrimaryStudent
     */
    List<PrimaryStudent> selectUseDiffResultMap(QueryParam queryParam);

    /**
     * selectLikeFirst
     *
     * @param like_name name
     * @return Students
     */
    List<Student> selectLikeFirst(@Param("like_name") String like_name);
}

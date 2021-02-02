package cn.clown.domain;

/**
 * <p>Description:实体类</p>
 *
 * @author clown
 * @date 2021
 */
public class PrimaryStudent {
    private Integer stuId;
    private String stuName;
    private Integer stuAge;

    public PrimaryStudent() {
    }

    public PrimaryStudent(Integer stuId, String stuName, Integer stuAge) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "PrimaryStudent{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }
}

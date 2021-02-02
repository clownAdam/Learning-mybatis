package cn.clown.vo;

/**
 * 保存参数值的对象
 *
 * @author clown
 * @date 2021
 */
public class QueryParam {
    private String queryName;
    private int queryAge;

    public QueryParam() {
    }

    public QueryParam(String queryName, int queryAge) {
        this.queryName = queryName;
        this.queryAge = queryAge;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public int getQueryAge() {
        return queryAge;
    }

    public void setQueryAge(int queryAge) {
        this.queryAge = queryAge;
    }
}

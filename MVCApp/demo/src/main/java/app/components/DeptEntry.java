package app.components;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptEntry {
 
    private int deptno;
    private String dname;
    private String loc;

    public DeptEntry(ResultSet rs)throws SQLException{
        deptno = rs.getInt("deptno");
        dname = rs.getString("dname");
        loc = rs.getString("loc");
    }

    public int getDeptno() {
        return deptno;
    }

    public String getDname() {
        return dname;
    }

    public String getLoc() {
        return loc;
    }

    
}

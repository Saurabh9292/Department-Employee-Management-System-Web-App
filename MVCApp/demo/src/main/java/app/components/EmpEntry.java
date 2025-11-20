package app.components;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpEntry {

    private int empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private double sal;
    private Double comm;
    private int deptno;

    public EmpEntry(ResultSet source) throws SQLException {

        empno = source.getInt("empno");
        ename = source.getString("ename");
        job = source.getString("job");

        int mgrValue = source.getInt("mgr");
        mgr = source.wasNull() ? null : mgrValue;

        hiredate = source.getDate("hiredate");

        sal = source.getDouble("sal");

        double commValue = source.getDouble("comm");
        comm = source.wasNull() ? null : commValue;

        deptno = source.getInt("deptno");
    }

    public final int getEmpno() {
        return empno;
    }

    public final String getEname() {
        return ename;
    }

    public final String getJob() {
        return job;
    }

    public final String getMgr() {
        return (mgr == null ? "-" : mgr.toString());
    }

    public final String getHiredate() {
        return String.format("%tF", hiredate);
    }

    public final double getSal() {
        return sal;
    }

    public final String getComm() {
        return (comm == null ? "-" : comm.toString());
    }

    public final int getDeptno() {
        return deptno;
    }
}

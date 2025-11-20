package app.components;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HRControllerServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login-view.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        
        //-----1. LOGIN PROCESS-----

        if("login".equals(action)){

            String user = req.getParameter("username");
            String pass = req.getParameter("password");

            var Login  =  new LoginModelBean();

            if(Login.authenticate(user, pass)) {


                //--Fetch Departments--
                var depts =new ArrayList<DeptEntry>();

                try(var con = HRDB.pool.getConnection()){

                    var stmt = con.prepareStatement("Select deptno,dname,loc from dept order by deptno ");

                    var rs = stmt.executeQuery();
                    while(rs.next()){
                        depts.add(new DeptEntry(rs));
                    }

                    rs.close();
                    stmt.close();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                req.setAttribute("departments", depts);

                req.getRequestDispatcher("/WEB-INF/pages/departments-view.jsp")
                            .forward(req, resp);


            }else{
                req.setAttribute("problem","Invalid HR Username or Password");

                req.getRequestDispatcher("/WEB-INF/pages/login-view.jsp")
                            .forward(req, resp);
            }

            return;     
        }

        // ---------- 2. Employee List Process--------

        if("employees".equals(action)){

            int deptno = Integer.parseInt(req.getParameter("deptno"));
            var emps = new ArrayList<EmpEntry>();

            try(var con = HRDB.pool.getConnection()){

                var stmt = con.prepareStatement("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp WHERE deptno=?");
                stmt.setInt(1, deptno);

                var rs = stmt.executeQuery();
                while(rs.next()){
                    emps.add(new EmpEntry(rs));
                }

                rs.close();
                stmt.close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            req.setAttribute("employees", emps);

            req.getRequestDispatcher("/WEB-INF/pages/employees-view.jsp").forward(req, resp);
            return;
        }

              // DEFAULT → login page
        req.getRequestDispatcher("/WEB-INF/pages/login-view.jsp")
               .forward(req, resp);


    }

    
}

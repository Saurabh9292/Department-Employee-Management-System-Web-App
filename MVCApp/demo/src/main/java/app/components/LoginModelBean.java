package app.components;

import java.sql.SQLException;

public class LoginModelBean {

    private String username;

    public final String getUsername() {
        return username;
    }

    public boolean authenticate(String user, String password) {
        try (var con = HRDB.pool.getConnection()) {

            var stmt = con.prepareStatement(
                "select count(*) from hr_login where username=? and password=?"
            );
            stmt.setString(1, user);
            stmt.setString(2, password);

            var rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            rs.close();
            stmt.close();

            if (count == 1) {
                username = user;
                return true;
            }

            username = null;
            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

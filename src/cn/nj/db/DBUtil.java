package cn.nj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class DBUtil {
    public static Connection conn = null;
    public static String url = "jdbc:mysql://localhost:3306/sgdb?characterEncoding=utf8&useSSL=true";
    public static String user = "root";
    public static String password = "echo";
    //2.1 封装连接功能
    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //2.2封装关闭功能
    public static void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User SelectByUsername(String username) {
        User user=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn = getConn();
        String sql="Select * from info where username=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()) {
                user=new User();
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
            }
            close(conn, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<User> selectAllUser() {
        ArrayList<User> users = new ArrayList<User>();

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn = getConn();
        String sql="Select * from emp";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            close(conn, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static boolean insertUser(User user) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn = getConn();
        boolean flag=false;
        String sql="insert into info(username,password) values(?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            int count=ps.executeUpdate();
            if(count!=0){
                flag=true;
            }
            close(conn, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static boolean updateUser(User user) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn = getConn();
        boolean flag=false;
        String sql="update emp set username=?,password=?,realname=?,age=?,sex=?,birthday=?,salary=? where username=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(8, user.getUsername());
            int count=ps.executeUpdate();
            if(count!=0){
                flag=true;
            }
            close(conn, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static boolean deleteUser(User user) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn = getConn();
        boolean flag=false;
        String sql="delete from emp where username=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            int count=ps.executeUpdate();
            if(count!=0){
                flag=true;
            }
            close(conn, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static User selectById(int id) {
        User user=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn = getConn();
        String sql="Select * from emp where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                user=new User();
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));

            }
            close(conn, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static boolean deleteByUserId(int userId) {
            Connection conn=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            conn = getConn();
            boolean flag=false;
            String sql="delete from emp where id=?";
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
                int count=ps.executeUpdate();
                if(count!=0){
                    flag=true;
                }
                close(conn, ps, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return flag;
        }
	}



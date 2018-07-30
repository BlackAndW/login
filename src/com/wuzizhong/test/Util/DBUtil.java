package com.wuzizhong.test.Util;

import java.sql.*;

public class DBUtil {
    private String url;
    private String user;
    private String password;
    private Connection conn = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    //加载驱动并且建立连接
    public void getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        }

        try {
        	url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
        	//链接的mysql
            user="root";
            password="123456";
            conn=DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //释放资源
    public void close(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //查询的方法 
    public ResultSet select(String sql){
        try {
            ps=conn.prepareStatement(sql);
            System.out.println("发送成功");
        } catch (SQLException e) {
            e.printStackTrace();    
            System.out.println("发送失败");
        }

        try {
            rs=ps.executeQuery();
            System.out.println("查询成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("查询失败");
        }
        
        return rs;
    }
    
    public ResultSet select(String sql,Object [] obj){
        try {
            ps=conn.prepareStatement(sql);
            System.out.println("发送成功");
        } catch (SQLException e) {
            e.printStackTrace();    
            System.out.println("发送失败");
        }

        for(int i=0;i<obj.length;i++){
            try {
                ps.setObject(i+1, obj[i]);
                System.out.println("参数设置成功");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("参数设置失败");
            }
        }
        try {
            rs=ps.executeQuery();
            System.out.println("查询成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("查询失败");
        }
        
        return rs;
    }


    //修改的方法
    public int update(String sql,Object[]obj){
        this.getConn();
        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("发送失败");
        }
        for(int i=0;i<obj.length;i++){
            try {
                ps.setObject(i+1, obj[i]);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("参数设置失败");
            }
        }
        int state =0;
        try {
        	state = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("执行sql语句失败");
        }
        return state;

    }
}


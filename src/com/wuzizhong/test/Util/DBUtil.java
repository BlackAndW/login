package com.wuzizhong.test.Util;

import java.sql.*;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static Connection conn = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    //加载驱动并且建立连接
    public Connection getConn() throws SQLException{
    	conn = dataSource.getConnection();
        return conn;
    }
    public static DataSource getDatasource() {
    	return dataSource;
    }
    
    //释放资源
    public void close() throws SQLException{
    	conn.close();
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
    public int update(String sql,Object[]obj) throws SQLException{
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


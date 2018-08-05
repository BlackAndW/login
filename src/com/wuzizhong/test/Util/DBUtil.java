package com.wuzizhong.test.Util;

import java.sql.*;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static Connection conn = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    //�����������ҽ�������
    public Connection getConn() throws SQLException{
    	conn = dataSource.getConnection();
        return conn;
    }
    public static DataSource getDatasource() {
    	return dataSource;
    }
    
    //�ͷ���Դ
    public void close() throws SQLException{
    	conn.close();
    }

    //��ѯ�ķ��� 
    public ResultSet select(String sql){
        try {
            ps=conn.prepareStatement(sql);
            System.out.println("���ͳɹ�");
        } catch (SQLException e) {
            e.printStackTrace();    
            System.out.println("����ʧ��");
        }

        try {
            rs=ps.executeQuery();
            System.out.println("��ѯ�ɹ�");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("��ѯʧ��");
        }
        
        return rs;
    }
    
    public ResultSet select(String sql,Object [] obj){
        try {
            ps=conn.prepareStatement(sql);
            System.out.println("���ͳɹ�");
        } catch (SQLException e) {
            e.printStackTrace();    
            System.out.println("����ʧ��");
        }

        for(int i=0;i<obj.length;i++){
            try {
                ps.setObject(i+1, obj[i]);
                System.out.println("�������óɹ�");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("��������ʧ��");
            }
        }
        try {
            rs=ps.executeQuery();
            System.out.println("��ѯ�ɹ�");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("��ѯʧ��");
        }
        
        return rs;
    }


    //�޸ĵķ���
    public int update(String sql,Object[]obj) throws SQLException{
        this.getConn();
        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("����ʧ��");
        }
        for(int i=0;i<obj.length;i++){
            try {
                ps.setObject(i+1, obj[i]);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("��������ʧ��");
            }
        }
        int state =0;
        try {
        	state = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ִ��sql���ʧ��");
        }
        return state;

    }
}


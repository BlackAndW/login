package com.wuzizhong.test.Util;

import java.sql.*;

public class DBUtil {
    private String url;
    private String user;
    private String password;
    private Connection conn = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    //�����������ҽ�������
    public void getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("�������سɹ�");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("��������ʧ��");
        }

        try {
        	url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
        	//���ӵ�mysql
            user="root";
            password="123456";
            conn=DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //�ͷ���Դ
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
    public int update(String sql,Object[]obj){
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


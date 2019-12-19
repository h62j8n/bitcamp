package com.bit.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BitOracle {
   // �̱�������
   private static Connection conn;

   private BitOracle() {}	// ������ ���� ����

   public static Connection getConnection() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "scott";
      String password = "tiger";

      try {
         if (conn == null || conn.isClosed()) {
            try {
               Class.forName(driver);
               conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
               System.out.println("url,user,pw Ȯ��");
               // System.out.println("����Ŭ ���� Ȯ��");

            } catch (ClassNotFoundException e) {
               // drirver ��ΰ� Ʋ�Ȱų� jar���� ��÷�ν� �߻�
               System.out.println("ojdbc14.jar �߰� Ȯ��");
               System.out.println("����̹� ��� Ȯ��");
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return BitOracle.conn;
   }
}
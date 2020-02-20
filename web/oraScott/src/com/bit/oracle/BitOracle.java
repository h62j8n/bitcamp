package com.bit.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BitOracle {
   // 싱글톤패턴
   private static Connection conn;

   private BitOracle() {}	// 생성자 접근 불허

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
               System.out.println("url,user,pw 확인");
               // System.out.println("오라클 서버 확인");

            } catch (ClassNotFoundException e) {
               // drirver 경로가 틀렸거나 jar파일 미첨부시 발생
               System.out.println("ojdbc14.jar 추가 확인");
               System.out.println("드라이버 경로 확인");
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return BitOracle.conn;
   }
}
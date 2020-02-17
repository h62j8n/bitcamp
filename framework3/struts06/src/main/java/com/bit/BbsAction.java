package com.bit;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.Action;

public class BbsAction {
   private List<Emp02Vo> list;
   
   public List<Emp02Vo> getList() {
      return list;
   }
   
   public String execute(){
      return Action.SUCCESS;
   }
   
   public String addForm(){
      return Action.SUCCESS;
   }
   
   public String list() throws SQLException{
      Emp02Dao dao = new Emp02Dao();
      list=dao.selectAll();
      return Action.SUCCESS;
   }
}
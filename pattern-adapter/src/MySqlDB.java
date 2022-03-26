package com.englishclass.englishlists.application.model;

import java.util.List;

public class MySqlDB {

  public void insertMysql(List<Object> list) {
    System.out.println("Adicionei uma nova lista no mysql");
  }


  public void updateMysql() {
    System.out.println("atualizei uma lista no mysql");
  }


  public void listOneMysql(String listId) {
    System.out.println("consultei um item da lista no mysql");
  }

  
  public void listManyMysql() {
    System.out.println("Consultei todos os items da lista no mysql");
  }
}

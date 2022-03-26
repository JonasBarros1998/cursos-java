package com.englishclass.englishlists.application.model;

import java.util.List;

import com.englishclass.englishlists.application.model.adapters.Target;

public class MySqlImplementation implements Target {

  private MySqlDB mySqlDB;

  public MySqlImplementation() {
    this.mySqlDB = new MySqlDB();
  }

  @Override
  public void insert(List<Object> list) {
    this.mySqlDB.insertMysql(list);
  }

  @Override
  public void update() {
    this.mySqlDB.updateMysql();
  }

  @Override
  public void listOne(String listId) {
    this.mySqlDB.listOneMysql(listId);
  }

  @Override
  public void listMany() {
    this.mySqlDB.listManyMysql();
  }
}

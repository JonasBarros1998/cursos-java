package com.englishclass.englishlists.application.model;

import java.util.List;

import com.englishclass.englishlists.application.model.adapters.Target;

public class MongoDBImplementation implements Target {

  @Override
  public void insert(List<Object> list) {
    System.out.println("Adicionei uma nova lista no banco");
  }

  @Override
  public void update() {
    System.out.println("atualizei uma lista no banco");
  }

  @Override
  public void listOne(String listId) {
    System.out.println("consultei um item da lista");
  }

  @Override
  public void listMany() {
    System.out.println("Consultei todos os items da lista");
  }
  
}

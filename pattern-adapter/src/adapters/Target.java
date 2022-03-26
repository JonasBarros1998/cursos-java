package com.englishclass.englishlists.application.model.adapters;

import java.util.ArrayList;
import java.util.List;

public interface Target {
  void insert(List<Object> list);
  void update();
  void listOne(String listId);
  void listMany();
}

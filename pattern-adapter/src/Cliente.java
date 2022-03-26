package com.englishclass.englishlists.application.model;

import com.englishclass.englishlists.application.model.adapters.Target;

public class Cliente {
  private Target target;
  public Cliente(Target target) {
    this.target = target;
  }

  public void queroListar() {
    this.target.listMany();
  }
}

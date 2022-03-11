package com.br.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class EmailTest {

  @Test
  public void naoDeveriaCriarEmailsComEnderecosInvalidos() {
    assertThrows(IllegalArgumentException.class, () -> new Email(null));
    assertThrows(IllegalArgumentException.class, () -> new Email(""));
    assertThrows(IllegalArgumentException.class, () -> new Email("emailInvalido"));
  }

  @Test
  public void deveCriarUmEmailCorretamente() {}
  
}

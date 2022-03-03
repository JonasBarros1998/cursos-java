package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {
  @Test
  void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
    BonusService service = new BonusService();
    assertThrows(
      IllegalArgumentException.class, 
      () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
  }

  @Test
  void DeveExibirUmaMensagemSebonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
    BonusService service = new BonusService();

    try {
      service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
    } catch (Exception e) {
      assertEquals("Funcionario com salario maior que 1000 nao pode receber bonus", e.getMessage());
    }
      
  }

  @Test
  void bonusDeveriaSer10PorcentoDoSalario() {
    BonusService service = new BonusService();
    BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
    assertEquals(new BigDecimal("250.00"), bonus);
  }

  @Test
  void bonusDeveriaSer10porcentoParaSalarioDeDezMil() {
    BonusService service = new BonusService();
    BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
    assertEquals(new BigDecimal("1000.00"), bonus);
  }
}

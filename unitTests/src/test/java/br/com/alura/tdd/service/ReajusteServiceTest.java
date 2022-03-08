package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

/**
 * Notações do JUnit
 * 
 * @AfterEach executar um metodo após cada uma dos metodos serem chamados
 * @BeforeAll Executar um metodo antes de todos os metodos de teste serem executados
 * @AfterAll Executar um metodo depois que todos os metodos de teste serem executados
 * 
 */

public class ReajusteServiceTest {

  private ReajusteService service;
  private Funcionario funcionario;

  /**
   * Dizer para o Junit para inicializar esse metodos antes de 
   * executar cada metodo de teste
   */
  @BeforeEach
  @AfterAll
  public void inicializar() {
    this.service = new ReajusteService();
    this.funcionario = new Funcionario("Paulo", LocalDate.now(), new BigDecimal("1000"));
  }


  @Test
  public void ReajusteDeveriaSerDe3PorcentoQuandoDesepenhoForADesejar() {
    this.service.concederReajuste(this.funcionario, Desempenho.A_DESEJAR);
    assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
  }
}

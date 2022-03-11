package com.br.escola.aplicacao.indicacao;

import com.br.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

  void enviarPara(Aluno indicado);
}

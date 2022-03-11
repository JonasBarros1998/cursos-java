package com.br.escola.infra.Aluno;

import java.util.ArrayList;
import java.util.List;

import com.br.escola.dominio.aluno.Aluno;
import com.br.escola.dominio.aluno.AlunoNaoEncontrado;
import com.br.escola.dominio.aluno.CPF;
import com.br.escola.dominio.aluno.Email;
import com.br.escola.dominio.aluno.RepositorioDeAluno;
import com.br.escola.dominio.aluno.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAluno {

  private final Connection connection;

  public RepositorioDeAlunosComJDBC(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void matricular(Aluno aluno) {
    String sql = "INSERT INTO ALUNO VALUES (?, ?, ?)";
    try {
      PreparedStatement ps = this.connection.prepareStatement(sql);
      ps.setString(1, aluno.getCPF());
      ps.setString(2, aluno.getNome());
      ps.setString(3, aluno.getEmail());
      ps.execute();

      sql = "INSERT INTO TELEFONE VALUES (?, ?)";
      ps = connection.prepareStatement(sql);
      for (Telefone telefone : aluno.getTelefones()) {
        ps.setString(1, telefone.getDdd());
        ps.setString(2, telefone.getNumero());
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    
  }

  @Override
	public Aluno buscarPorCPF(CPF cpf) {
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());

			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if (!encontrou) {
				throw new AlunoNaoEncontrado(cpf);
			}

			String nome = rs.getString("nome");
			Email email = new Email(rs.getString("email"));
			Aluno encontrado = new Aluno(nome, cpf, email);
			
			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String numero = rs.getString("numero");
				String ddd = rs.getString("ddd");
				encontrado.adicionarTelefone(ddd, numero);
			}
			
			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		try {
			String sql = "SELECT id, cpf, nome, email FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Aluno> alunos = new ArrayList<>();
			while (rs.next()) {
				CPF cpf = new CPF(rs.getString("cpf"));
				String nome = rs.getString("nome");
				Email email = new Email(rs.getString("email"));
				Aluno aluno = new Aluno(nome, cpf, email);
				
				Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				ResultSet rsTelefone = psTelefone.executeQuery();
				while (rsTelefone.next()) {
					String numero = rsTelefone.getString("numero");
					String ddd = rsTelefone.getString("ddd");
					aluno.adicionarTelefone(ddd, numero);
				}
			
				alunos.add(aluno);
			}
			
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
  
}

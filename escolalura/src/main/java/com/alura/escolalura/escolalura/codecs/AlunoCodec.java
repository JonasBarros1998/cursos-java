package com.alura.escolalura.escolalura.codecs;

import java.security.CodeSigner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.alura.escolalura.escolalura.Model.Aluno;
import com.alura.escolalura.escolalura.Model.Contato;
import com.alura.escolalura.escolalura.Model.Curso;
import com.alura.escolalura.escolalura.Model.Habilidade;
import com.alura.escolalura.escolalura.Model.Nota;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class AlunoCodec implements CollectibleCodec<Aluno> {

  private Codec<Document> codec;

  public AlunoCodec(Codec<Document> codec2) {
    this.codec = codec2;
  }

  @Override
  public void encode(BsonWriter writer, Aluno aluno, EncoderContext encoder) {
    Object id = aluno.getId();
    String nome = aluno.getNome();
    Date dataNascimento = aluno.getDataNascimento();
    Curso curso = aluno.getCurso();
    List<Habilidade> habilidades = aluno.getHabilidades();
    List<Nota> notas = aluno.getNotas();
    Contato contato = aluno.getContato();

    List<Double> coordinates = new ArrayList<Double>();
    for(Double location : contato.getCoordinates()){
      coordinates.add(location);
    }

    Document document = new Document();

    document.put("_id", id);
    document.put("nome", nome);
    document.put("data_nascimento", dataNascimento);
    document.put("curso", new Document("nome", curso.getNome()));
    
    if(habilidades != null) {
      List<Document> habilidadesDocument = new ArrayList<>();
      for (Habilidade habilidade : habilidades) {
        habilidadesDocument.add(new Document("nome", habilidade.getNome())
            .append("nivel", habilidade.getNivel()));
      }
      document.put("habilidades", habilidadesDocument);
    }

    if(notas != null) {
      List<Integer> notasParaSalvar = new ArrayList<>();
      for (Nota nota : notas) {
        notasParaSalvar.add(nota.getValor()); 
      }
      document.put("notas", notasParaSalvar);
    } 

    document.put("contato", new Document()
    .append("endereco" , contato.getEndereco())
    .append("coordinates", coordinates)
    .append("type", contato.getType()));

    this.codec.encode(writer, document, encoder);
  }

  @Override
  public Class<Aluno> getEncoderClass() {
    return Aluno.class;
  }

  @Override
  public Aluno decode(BsonReader reader, DecoderContext decoder) {
    Document document = this.codec.decode(reader, decoder);
    Aluno aluno = new Aluno();
    aluno.setId(document.getObjectId("_id"));
    aluno.setNome(document.getString("nome"));
    aluno.setDataNascimento(document.getDate("data_nascimento"));

    List<Integer> notas = (List<Integer>) document.get("notas");
    Document curso = (Document) document.get("curso");
    if (curso != null) {
      String nomeCurso = curso.getString("nome");
      aluno.setCurso(new Curso(nomeCurso));
    }

    if (notas != null) {
      List<Nota> notasDoAluno = new ArrayList<>();
      for (int nota : notas) {
        notasDoAluno.add(new Nota(nota));
        aluno.setNotas(notasDoAluno);
      }
    }

    List<Document> habilidades = (List<Document>) document.get("habilidades");

    if (habilidades != null) {
      List<Habilidade> habilidadesDoAluno = new ArrayList<>();
      for (Document documentHabilidade : habilidades) {
        habilidadesDoAluno.add(new Habilidade(documentHabilidade.getString("nome"), documentHabilidade.getString("nivel")));
      }

      aluno.setHabilidades(habilidadesDoAluno);
    }

    Document contato = (Document) document.get("contato");
    if (contato != null) {
      String endereco = contato.getString("contato");
      List<Double> coordinates = (List<Double>) contato.get("coordinates");
      aluno.setContato(new Contato(endereco, coordinates));
    }
    return aluno;
  }

  @Override
  public Aluno generateIdIfAbsentFromDocument(Aluno aluno) {
    return this.documentHasId(aluno) ? aluno.criarId() : aluno;
  }

  @Override
  public boolean documentHasId(Aluno aluno) {
    return aluno.getId() == null;
  }

  @Override
  public BsonValue getDocumentId(Aluno aluno) {
    if (this.documentHasId(aluno)) {
      throw new IllegalStateException("Esse documento não tem id");
    }
    return new BsonString(aluno.getId().toHexString());
  }
  
}

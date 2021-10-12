public class TestaReferencias {
  public static void main(String[] args) {

    ControleBonificacao controle = new ControleBonificacao();
    
    Gerente gerente = new Gerente();
    gerente.setSalario(5000);
    
    Design design = new Design();
    design.setSalario(3000);
    
    EditorDeVideos editorDeVideos = new EditorDeVideos();
    editorDeVideos.setSalario(2000);

   
    controle.registar(design);
    //System.out.println("Design: " + controle.getSoma());

    controle.registar(gerente);
    //System.out.println("Gerente: " + controle.getSoma());
    
    controle.registar(editorDeVideos);
    System.out.println("Editor de Videos: " + controle.getSoma());

  }
}

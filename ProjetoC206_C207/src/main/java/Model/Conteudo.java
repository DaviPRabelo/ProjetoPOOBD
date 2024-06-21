package Model;

public abstract class Conteudo {
    private int id;
    private String titulo;
    private String genero;
    private int nota;
    private String diretor;

    public Conteudo(int id, String titulo, String genero, int nota, String diretor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.nota = nota;
        this.diretor = diretor;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getNota() {
        return nota;
    }

    public String getDiretor() {
        return diretor;
    }
}

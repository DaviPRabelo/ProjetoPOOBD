package Model;

import DAO.FilmesDAO;

import java.util.ArrayList;

public class Filmes extends Conteudo implements vereficar {

    private int duracao;

    private int idStreaming;
    private FilmesDAO filmesDAO = new FilmesDAO();
    public Filmes(int id, String titulo, String genero, int nota, int duracao, String diretor, int idStreaming) {
        super(id, titulo,genero,nota,diretor);
        this.duracao = duracao;
        this.idStreaming = idStreaming;
    }
    public void insertable(){
        filmesDAO.insertFilmes(getId(), getTitulo(), getGenero(), getNota(), duracao,getDiretor(),idStreaming);
    }
    public int getDuracao() {
        return duracao;
    }

    public void nomeFilmes(int Str){
        ArrayList<Filmes> filmes = filmesDAO.nomeselectfilme(Str);
        for (int i = 0; i < filmes.size(); i++) {
            if(filmes.get(i).getTitulo() != null){
                System.out.println(filmes.get(i).getId()+" --- " + filmes.get(i).getTitulo());
            }
        }
        filmes.clear();
    }
    @Override
    public boolean verificar(int valor, int Str) {
        return filmesDAO.especificselectfilme(valor, Str);
    }
    public void selecionado(int id, int Str){
        ArrayList<Filmes> filmes = filmesDAO.especificfilme(id, Str);
        for (int i = 0; i < filmes.size(); i++) {
            if(filmes.get(i) != null){
                System.out.println("Filme selecionado: "+filmes.get(i).getTitulo());
                System.out.println("Duração: " + filmes.get(i).getDuracao());
                System.out.println("Diretor: " + filmes.get(i).getDiretor());
                System.out.println("Nota: " + filmes.get(i).getNota());
            }
        }
        System.out.println("ASSISTINDO");
        System.out.println("Filme acabo aaaa");
        filmes.clear();
    }


}

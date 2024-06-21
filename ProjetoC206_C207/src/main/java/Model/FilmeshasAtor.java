package Model;

import DAO.FilmeshasAtorDAO;

import java.util.ArrayList;

public class FilmeshasAtor {

    private FilmeshasAtorDAO filmeshasAtorDAO = new FilmeshasAtorDAO();


    public void inserttable(int idAtor, int idFilmes){
        filmeshasAtorDAO.insertAtorhasfilmes(idAtor, idFilmes);
    }

    public void selectAtorFilme(int id, int idStr){
       ArrayList<Filmes> filme = filmeshasAtorDAO.selectFilmesHasAtor(id, idStr);
        for (Filmes filmes : filme) {
            if (filmes != null) {
                System.out.println("Id ---" + filmes.getId() + " Nome: " + filmes.getTitulo());
            }
        }
        filme.clear();
    }

}

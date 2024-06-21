package Model;

import DAO.SerieshasAtorDAO;

import java.util.ArrayList;

public class SerieshasAtor {
    private SerieshasAtorDAO serieshasAtorDAO = new SerieshasAtorDAO();

    public void insertAS(int idAtor, int idSeries){
        serieshasAtorDAO.insertAtorhasfilmes(idAtor,idSeries);
    }
    public void selectSeriesAtor(int id, int str){
       ArrayList<Series> serie = serieshasAtorDAO.selectSeriesHasAtor(id, str);
        for (int i = 0; i < serie.size(); i++) {
            if(serie.get(i) != null){
                System.out.println("Id "+ serie.get(i).getId() + " Nome: "+serie.get(i).getTitulo());

            }
        }
        serie.clear();
    }

}

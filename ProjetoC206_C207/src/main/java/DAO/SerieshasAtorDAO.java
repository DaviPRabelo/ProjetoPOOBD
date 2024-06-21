package DAO;

import Model.FilmeshasAtor;
import Model.Series;
import Model.SerieshasAtor;

import java.sql.SQLException;
import java.util.ArrayList;

public class SerieshasAtorDAO extends ConnectionDAO{
    boolean sucesso = false;
    public boolean insertAtorhasfilmes(int ida, int ids){
        connectToDB();
        String sql = "INSERT INTO ator_has_Series (ator_idator,series_idSeries) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, ida);
            pst.setInt(2, ids);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    public ArrayList<Series> selectSeriesHasAtor(int id, int idStr) {
        ArrayList<Series> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT distinct idSeries, Series.nome, Series.genero, Series.Nota,Series.Diretor, Series.qntEp, Series.Streaming_idStreaming  FROM Ator_has_Series, Series, Ator WHERE Ator_has_Series.Series_idSeries = Series.idSeries AND Ator_has_Series.Ator_idAtor = "+ id+" AND Series.Streaming_idStreaming = " +idStr;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Series do Ator");
            while (rs.next()) {
                Series userAux = new Series(rs.getInt("idSeries"),rs.getString("Series.nome"), rs.getString("Series.genero"), rs.getInt("Series.Nota"),rs.getString("Series.Diretor"), rs.getInt("Series.qntEp"),  rs.getInt("Series.Streaming_idStreaming"));
                users.add(userAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return users;
    }

}

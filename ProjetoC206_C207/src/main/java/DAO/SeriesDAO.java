package DAO;

import Model.Filmes;
import Model.Series;

import java.sql.SQLException;
import java.util.ArrayList;

public class SeriesDAO extends ConnectionDAO{
    boolean sucesso = false;
    public boolean insertSeries(int id, String titulo, String genero, int nota, int qntEp, String diretor, int idStreaming) {
        connectToDB();
        String sql = "INSERT INTO Series (idSeries,Nome,genero,qntEp,Nota,Diretor,Streaming_idStreaming) values(?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, titulo);
            pst.setString(3, genero);
            pst.setInt(4, qntEp);
            pst.setInt(5, nota);
            pst.setString(6, diretor);
            pst.setInt(7, idStreaming);
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


    public ArrayList<Series> nomeselectSerie(int Str) {
        ArrayList<Series> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Series WHERE Streaming_idStreaming =" +Str  ;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Series: ");
            while (rs.next()) {
                Series userAux = new Series(rs.getInt("idSeries"),rs.getString("nome"), rs.getString("Genero"), rs.getInt("Nota"), rs.getString("Diretor"),rs.getInt("qntEp"), rs.getInt("Streaming_idStreaming"));
                System.out.println(userAux.getId()+" --- " + userAux.getTitulo());
                users.add(userAux);
            }
            sucesso = true;
        } catch (SQLException e) {

            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {

            }
        }
        return users;
    }
    public boolean especificselectSeries(int id, int Str) {

        connectToDB();
        String sql = "SELECT * FROM Series WHERE idSeries="+id+" and Streaming_idStreaming = " +Str;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Series userAux = new Series(rs.getInt("idSeries"),rs.getString("nome"), rs.getString("Genero"), rs.getInt("Nota"),rs.getString("Diretor"),rs.getInt("qntEp"),  rs.getInt("Streaming_idStreaming"));
                if(id == userAux.getId()) {
                    return true;
                }
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
        return false;
    }
    public ArrayList<Series> especificSeries(int id, int Str) {
        ArrayList<Series> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Series WHERE idSeries="+id+" and Streaming_idStreaming = " +Str;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Series userAux = new Series(rs.getInt("idSeries"),rs.getString("nome"), rs.getString("Genero"), rs.getInt("Nota"),rs.getString("Diretor"),rs.getInt("qntEp"),  rs.getInt("Streaming_idStreaming"));
                if(id == userAux.getId()) {
                    users.add(userAux);
                }
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


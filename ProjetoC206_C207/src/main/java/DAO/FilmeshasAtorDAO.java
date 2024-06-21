package DAO;
import Model.Filmes;
import Model.FilmeshasAtor;


import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeshasAtorDAO extends ConnectionDAO{
    boolean sucesso = false;
    public boolean insertAtorhasfilmes(int ida, int idf) {
        connectToDB();
        String sql = "INSERT INTO ator_has_filmes (ator_idator,filmes_idfilmes) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, ida);
            pst.setInt(2, idf);
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
    public ArrayList<Filmes> selectFilmesHasAtor(int id, int idStr) {
        ArrayList<Filmes> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT distinct idFilmes, Filmes.nome, Filmes.genero, Filmes.Nota,Filmes.Diretor, Filmes.Duracao, Filmes.Streaming_idStreaming  FROM Ator_has_Filmes, Filmes, Ator WHERE   Ator_has_Filmes.Filmes_idFilmes = Filmes.idFilmes and Ator_has_Filmes.Ator_idAtor = "+ id+" AND Filmes.Streaming_idStreaming = " +idStr;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Filmes do Ator: ");
            while (rs.next()) {
                Filmes userAux = new Filmes(rs.getInt("idFilmes"),rs.getString("Filmes.nome"), rs.getString("Filmes.genero"), rs.getInt("Filmes.Nota"),rs.getInt("Filmes.Duracao"), rs.getString("Filmes.Diretor"), rs.getInt("Filmes.Streaming_idStreaming"));
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

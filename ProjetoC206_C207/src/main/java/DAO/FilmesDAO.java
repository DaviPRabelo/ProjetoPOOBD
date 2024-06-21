package DAO;
import Model.Filmes;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmesDAO extends ConnectionDAO{
    boolean sucesso = false;
    public boolean insertFilmes(int id, String titulo, String genero, int nota, int duracao, String diretor, int idStreaming) {
        connectToDB();
        String sql = "INSERT INTO Filmes (idFilmes,Nome,Genero,Duracao,Nota,Diretor,Streaming_idStreaming) values(?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, titulo);
            pst.setString(3, genero);
            pst.setInt(4, duracao);
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

    public ArrayList<Filmes> selectfilme() {
        ArrayList<Filmes> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Filmes";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Filmes: ");
            while (rs.next()) {
                Filmes userAux = new Filmes(rs.getInt("idFilmes"),rs.getString("nome"), rs.getString("Genero"), rs.getInt("Nota"),rs.getInt("Duração"), rs.getString("Diretor"), rs.getInt("Streaming_idStreaming"));
                System.out.println("Titulo = " + userAux.getTitulo());
                System.out.println("Genero = " + userAux.getGenero());
                System.out.println("Duração = " + userAux.getDuracao());
                System.out.println("Nota = " + userAux.getNota());
                System.out.println("Diretor = " + userAux.getDiretor());
                System.out.println("--------------------------------");
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
    public boolean especificselectfilme(int id, int idStr) {
        connectToDB();
        String sql = "SELECT * FROM Filmes WHERE idFilmes="+id +" and Streaming_idStreaming=" +idStr;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Filmes userAux = new Filmes(rs.getInt("idFilmes"),rs.getString("nome"), rs.getString("Genero"), rs.getInt("Nota"),rs.getInt("Duracao"), rs.getString("Diretor"), rs.getInt("Streaming_idStreaming"));
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
    public ArrayList especificfilme(int id, int idStr) {
        ArrayList<Filmes> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Filmes WHERE idFilmes="+id +" and Streaming_idStreaming=" +idStr;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Filmes userAux = new Filmes(rs.getInt("idFilmes"),rs.getString("nome"), rs.getString("Genero"), rs.getInt("Nota"),rs.getInt("Duracao"), rs.getString("Diretor"), rs.getInt("Streaming_idStreaming"));
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
    public ArrayList<Filmes> nomeselectfilme(int Str) {
        ArrayList<Filmes> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Filmes WHERE Streaming_idStreaming = "+Str;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Filmes: ");
            while (rs.next()) {
                Filmes userAux = new Filmes(rs.getInt("idFilmes"),rs.getString("nome"), rs.getString("Genero"), rs.getInt("Nota"),rs.getInt("Duracao"), rs.getString("Diretor"), rs.getInt("Streaming_idStreaming"));
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
    public boolean especificnomefilme(int id) {
        connectToDB();
        String sql = "SELECT nome FROM Filmes WHERE idFilmes="+id;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Filmes userAux = new Filmes(rs.getInt("idFilmes"),rs.getString("nome"), rs.getString("Genero"), rs.getInt("Nota"),rs.getInt("Duracao"), rs.getString("Diretor"), rs.getInt("Streaming_idStreaming"));
                if(id == userAux.getId()) {
                    System.out.println("Titulo = " + userAux.getTitulo());
                    System.out.println("Genero = " + userAux.getGenero());
                    System.out.println("Duração = " + userAux.getDuracao());
                    System.out.println("Nota = " + userAux.getNota());
                    System.out.println("Diretor = " + userAux.getDiretor());

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
}

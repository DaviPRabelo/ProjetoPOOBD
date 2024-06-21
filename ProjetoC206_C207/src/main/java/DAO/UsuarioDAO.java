package DAO;
import Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
public class UsuarioDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public void insertUsuario(int id, String nome, int idStreaming, int idLogin) {
        connectToDB();
        String sql = "INSERT INTO Usuario (idUsuario, nome, Streaming_idStreaming, Login_idLogin) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, nome);
            pst.setInt(3, idStreaming);
            pst.setInt(4, idLogin);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }
    //UPDATE
    public boolean updateUser(int id, String nome, int idStreaming, int idLogin) {
        connectToDB();
        String sql = "UPDATE Usuario SET nome=? where idUsuario=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2,id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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
    //DELETE
    public boolean deleteUsuario(int id) {
        connectToDB();
        String sql = "DELETE FROM Usuario where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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
    //SELECT
    public int selectid(int log, int str) {
        connectToDB();
        String sql = "SELECT * FROM Usuario WHERE Login_idLogin = "+log+" and Streaming_idStreaming = "+str;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Usuario userAux = new Usuario(rs.getInt("idUsuario"),rs.getString("nome"),rs.getInt("Streaming_idStreaming"), rs.getInt("Login_idLogin"));
                return userAux.getId();

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
        return 0;
    }
}
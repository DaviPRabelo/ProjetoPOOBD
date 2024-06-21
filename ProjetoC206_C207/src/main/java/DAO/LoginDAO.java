package DAO;
import Model.Login;
import java.sql.SQLException;
import java.util.ArrayList;
public class LoginDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public void insertLogin(int id, String email, String senha, int idStreaming) {
        connectToDB();
        String sql = "INSERT INTO Login (idLogin,email,senha,Streaming_idStreaming) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, email);
            pst.setString(3, senha);
            pst.setInt(4, idStreaming);
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
    }
    //UPDATE
    public void updateLoginEmail(int id, String email, int Str) {
        connectToDB();
        String sql = "UPDATE login SET email=? where idLogin=? and Streaming_idStreaming =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setInt(2,id);
            pst.setInt(3,Str);
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
    }
    public void updateLoginSenha(int id, String senha, int Str) {
        connectToDB();
        String sql = "UPDATE login SET senha=? where idLogin=? and Streaming_idStreaming =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, senha);
            pst.setInt(2,id);
            pst.setInt(3,Str);
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
    }
    //DELETE
    public boolean deleteLogin(int id) {
        connectToDB();
        String sql = "DELETE FROM login where id=?";
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
    public ArrayList<Login> selectLogin(int id,int idStr) {
        ArrayList<Login> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Login WHERE idLogin = "+id+" AND Streaming_idStreaming = " +idStr;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Dados da conta: ");
            while (rs.next()) {
                Login userAux = new Login(rs.getInt("idLogin"),rs.getString("email"),rs.getString("senha"),rs.getInt("Streaming_idStreaming"));
                System.out.println("email = " + userAux.getEmail());
                System.out.println("idLogin = " + userAux.getIdLogin());
                System.out.println("idStreaming = " + userAux.getIdStreaming());
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
    public int idLogado(String email, String senha, int idStr) {
        ArrayList<Login> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Login WHERE Streaming_idStreaming="+idStr;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Login userAux = new Login(rs.getInt("idLogin"),rs.getString("email"),rs.getString("senha"),rs.getInt("Streaming_idStreaming"));
                if(email.equals(userAux.getEmail()) && senha.equals(userAux.getSenha())){
                    return userAux.getIdLogin();
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
        return 0;
    }
    public boolean verifcar(String email, String senha, int idStr) {
        ArrayList<Login> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Login WHERE Streaming_idStreaming="+idStr;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Login userAux = new Login(rs.getInt("idLogin"),rs.getString("email"),rs.getString("senha"),rs.getInt("Streaming_idStreaming"));
                if(email.equals(userAux.getEmail()) && senha.equals(userAux.getSenha())){
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
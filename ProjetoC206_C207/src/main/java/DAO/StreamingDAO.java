package DAO;
import Model.Streaming;
import java.sql.SQLException;
import java.util.ArrayList;

public class StreamingDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertStreaming(int id, String nome) {
        connectToDB();
        String sql = "INSERT INTO Streaming (idStreaming,nome) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, nome);
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
        return sucesso;
    }

    //SELECT
    public ArrayList<Streaming> selectStreaming() {
        ArrayList<Streaming> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Streaming";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Streaming userAux = new Streaming(rs.getInt("idStreaming"),rs.getString("nome"));

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
    public ArrayList<Streaming> str(int i) {
        ArrayList<Streaming> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Streaming";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Streaming userAux = new Streaming(rs.getInt("idStreaming"),rs.getString("nome"));
                if(userAux.getId() == i){
                    System.out.println("Você esta usando a = " + userAux.getNome());
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

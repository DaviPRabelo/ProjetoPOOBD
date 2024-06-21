package DAO;
import Model.Ator;
import java.sql.SQLException;
import java.util.ArrayList;

public class AtorDAO extends ConnectionDAO{
     boolean sucesso = false;
    public void insertAtor(int id, int idade, String nome) {
        connectToDB();
        String sql = "INSERT INTO Ator (idAtor,nome,idade) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, nome);
            pst.setInt(3,idade);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());

        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }
    public ArrayList<Ator> selectAtor() {
        ArrayList<Ator> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Ator";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Ator userAux = new Ator(rs.getInt("idAtor"),rs.getString("nome"), rs.getInt("idade"));
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

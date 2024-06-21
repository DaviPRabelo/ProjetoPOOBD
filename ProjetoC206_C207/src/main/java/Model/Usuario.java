package Model;


import DAO.UsuarioDAO;




public class Usuario {
    private int id;
    private String nome;
    private int idStreaming;
    private int idLogin;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static int qntUser;


    public Usuario(int id, String nome, int idStreaming, int idLogin) {
        this.id = id;
        this.nome = nome;
        this.idStreaming = idStreaming;
        this.idLogin = idLogin;
    }
    public void insertTable() {
        qntUser++;
        usuarioDAO.insertUsuario(id, nome, idStreaming, idLogin);
    }

    public int getId() {
        return id;
    }



    public String getNome() {
        return nome;
    }


    public int Id(int log, int str){
        return usuarioDAO.selectid(log,str);
    }
    public void mudarnome(int idu,String nome, int log, int str){
        this.nome = nome;
        usuarioDAO.updateUser(idu,nome,log,str);
        System.out.println("Nome alterado");
    }

    public static int getQntUser() {
        return qntUser;
    }
    public void deletar(int id){
        usuarioDAO.deleteUsuario(id);
    }
}
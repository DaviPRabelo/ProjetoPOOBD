package Model;

import DAO.LoginDAO;

public class Login {
    private int idLogin;
    private String email;
    private String senha;
    private int idStreaming;
    private LoginDAO loginDAO = new LoginDAO();
    private static int qntLogin =0;

    public Login(int id, String email, String senha, int idStreaming) {
        this.idLogin = id;
        this.email = email;
        this.senha = senha;
        this.idStreaming = idStreaming;

    }

    public void insertTable(){
        qntLogin++;
        loginDAO.insertLogin(idLogin, email, senha, idStreaming);

    }
    public boolean vrfc(String email, String senha, int i){
        boolean vdd = loginDAO.verifcar(email, senha, i);
        if(vdd){
            System.out.println("Acesso liberado");
            return true;
        }
        else {
            System.out.println("Acesso Negado ");
            return false;
        }
    }

    public int getIdLogin() {
        return idLogin;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdStreaming() {
        return idStreaming;
    }

    public static int getQntLogin() {
        return qntLogin;
    }
    public void select(int id, int Str){
        loginDAO.selectLogin(id, Str);
    }
    public int idLog(String email, String senha, int i){
            return loginDAO.idLogado(email, senha, i);

    }

    public void setEmail(String email,int log, int Str) {
        loginDAO.updateLoginEmail(log,email,Str);
        System.out.println("Email alterado");
    }
    public void setSenha(String senha,int log, int Str) {
        loginDAO.updateLoginSenha(log,senha,Str);
        System.out.println("Senha alterada");
    }

    public void deletar(int id){
        loginDAO.deleteLogin(id);
    }
}

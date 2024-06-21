package Model;

import DAO.StreamingDAO;

import java.util.ArrayList;

public class Streaming{
    private int id;
    private String nome;
    private StreamingDAO streamingDAO = new StreamingDAO();
    private static int qntStr;

    public Streaming(int id,String nome) {
        this.id = id;
        this.nome = nome;

    }
    public void insertTable() {
        qntStr++;
        streamingDAO.insertStreaming(id, nome);
    }

    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }
    public void mostrarStr(){
       ArrayList<Streaming> st = streamingDAO.selectStreaming();
        for (Streaming streaming : st) {
            if (streaming != null) {
                System.out.println(streaming.getId()+" --- "+streaming.getNome());
            }
        }
        System.out.println("0 --- Sair");
    }
    public void strespecifica(int id){
        streamingDAO.str(id);
    }

    public static int getQntStr() {
        return qntStr;
    }
}

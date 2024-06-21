package Model;

import DAO.AtorDAO;

import java.util.ArrayList;

public class Ator {
    private int id;
    private String nome;
    private int idade;


    private AtorDAO atorDAO = new AtorDAO();

    public Ator(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }
    public void insert(){
        atorDAO.insertAtor(id,idade,nome);
    }
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public void selectAtor(){
        System.out.println("Selecione um ator");
        ArrayList<Ator> ators = atorDAO.selectAtor();
        for (int i = 0; i < ators.size(); i++) {
            if(ators.get(i) != null){
                System.out.println(ators.get(i).id +" --- "+ators.get(i).getNome());
            }
        }
    }
}

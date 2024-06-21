package org.example;
import DAO.*;
import Model.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Streaming stream1 = new Streaming(1, "Netfrix");
        Streaming stream2 = new Streaming(2, "Mazom Praimi");
        Streaming stream3 = new Streaming(3, "Dosney prus");
        Login log1 = new Login(1, "email@email.com", "aaaa", stream1.getId());
        Login log2 = new Login(2, "email1@email.com", "aaaa", stream1.getId());
        Login log3 = new Login(3, "email2@email.com", "aaaa", stream2.getId());
        Login log4 = new Login(4, "email3@email.com", "aaaa", stream3.getId());
        Login log5 = new Login(5, "email4@email.com", "aaaa", stream3.getId());
        Usuario user1 = new Usuario(1, "Jorge", stream1.getId(), log1.getIdLogin());
        Usuario user2 = new Usuario(2, "Panes", stream1.getId(), log1.getIdLogin());
        Usuario user3 = new Usuario(3, "Larico", stream2.getId(), log2.getIdLogin());
        Usuario user4 = new Usuario(4, "Calabreso", stream3.getId(), log3.getIdLogin());
        Usuario user5 = new Usuario(5, "Coiso", stream3.getId(), log3.getIdLogin());
        Filmes filmes = new Filmes(5, "Jão e o mão de feijão", "Drama", 5, 90, "Jão", stream1.getId());
        Filmes filmes1 = new Filmes(1, "Pamonha", "Comedia", 7, 20, "Milho", stream1.getId());
        Filmes filmes2 = new Filmes(2, "Panetone assassino", "Terror", 4, 110, "Jão", stream2.getId());
        Filmes filmes3 = new Filmes(3, "A volta dos que não foram", "Ação", 10, 170, "O que voltou", stream2.getId());
        Filmes filmes4 = new Filmes(4, "A queda da subida", "Suspense", 7, 92, "O que subiu", stream3.getId());
        Filmes filmes5 = new Filmes(7, "Cerricete", "Biografia", 7, 77, "Cerricete", stream3.getId());
        Filmes filmes6 = new Filmes(6, "Atchim", "Pós-Apocaliptico", 4, 69, "O cara que espirrou", stream2.getId());
        Filmes filmes7 = new Filmes(9, "Belo adormecido", "Animação", 5, 90, "O que acordou", stream1.getId());
        Filmes filmes8 = new Filmes(8, "CURINTIA", "Épico", 10, 2012, "Cássio", stream1.getId());
        Series serie1 = new Series(1, "Banana", "Comedia", 7, "Jorge", 23, stream1.getId());
        Series serie2 = new Series(2, "Mezi", "Biografia", 10, "Mezi", 22, stream1.getId());
        Series serie3 = new Series(3, "Os garotos", "Ação", 8, "Bruto", 43, stream2.getId());
        Series serie4 = new Series(4, "Mindê", "Animação", 7, "Lobo pidão", 12, stream2.getId());
        Series serie5 = new Series(6, "Serie B", "Esportes", 2, "Santastico", 24, stream3.getId());
        Ator atoe = new Ator(2, "Paulin do pneu", 19);
        Ator ator1 = new Ator(1, "Espiga", 32);
        FilmeshasAtor fha = new FilmeshasAtor();
        SerieshasAtor sha = new SerieshasAtor();

        stream1.insertTable();
        stream2.insertTable();
        stream3.insertTable();
        log1.insertTable();
        log2.insertTable();
        log3.insertTable();
        log4.insertTable();
        log5.insertTable();
        user1.insertTable();
        user2.insertTable();
        user3.insertTable();
        user4.insertTable();
        user5.insertTable();
        filmes.insertable();
        filmes1.insertable();
        filmes2.insertable();
        filmes3.insertable();
        filmes4.insertable();
        filmes5.insertable();
        filmes6.insertable();
        filmes7.insertable();
        filmes8.insertable();
        serie1.insertTable();
        serie2.insertTable();
        serie4.insertTable();
        serie3.insertTable();
        serie5.insertTable();
        ator1.insert();
        atoe.insert();
        fha.inserttable(ator1.getId(), filmes.getId());
        fha.inserttable(ator1.getId(), filmes1.getId());
        fha.inserttable(atoe.getId(), filmes2.getId());
        fha.inserttable(atoe.getId(), filmes3.getId());
        fha.inserttable(atoe.getId(), filmes4.getId());
        fha.inserttable(ator1.getId(), filmes5.getId());
        fha.inserttable(ator1.getId(), filmes6.getId());
        fha.inserttable(ator1.getId(), filmes7.getId());
        fha.inserttable(atoe.getId(), filmes8.getId());
        sha.insertAS(ator1.getId(), serie1.getId());
        sha.insertAS(ator1.getId(), serie2.getId());
        sha.insertAS(atoe.getId(), serie3.getId());
        sha.insertAS(atoe.getId(), serie4.getId());
        sha.insertAS(ator1.getId(), serie5.getId());

        Scanner scan = new Scanner(System.in);
        String email;
        String senha;
        String nome;
        int loga;
        int x;
        int idU;
        int a;
        boolean ver = false;
        int film = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
        do {
            System.out.println("Seja bem vindo, qual Streaming deseja usar: ");

            stream1.mostrarStr();
            a = scan.nextInt();
            stream1.strespecifica(a);
            if (a == 0) {

            } else if (a <= Streaming.getQntStr()) {

                boolean vdd = false;
                int i = 0;
                System.out.println("Ja possui um login?");
                System.out.println("1--Sim");
                System.out.println("2--Nao");
                int lo = scan.nextInt();
                if (lo == 2) {
                    System.out.println("Coloque seu email");
                    email = scan.next();
                    System.out.println("Coloque a sua senha:");
                    senha = scan.next();
                    Login newlog = new Login(Login.getQntLogin() + 1, email, senha, a);
                    newlog.insertTable();
                    System.out.println("Agora digite seu nome de usuario: ");
                    nome = scan.next();
                    Usuario user = new Usuario(Usuario.getQntUser()+1, nome, a, newlog.getIdLogin());
                    user.insertTable();
                    System.out.println("Cadastro completo");
                    lo = 1;
                }

                if (lo == 1) {
                    System.out.println("Faça seu login: ");
                    do {
                        if (i > 0) {
                            System.out.println("Senha ou email errado");
                        }
                        System.out.println("Email:");
                        String e = scan.next();

                        System.out.println("Senha");
                        String s = scan.next();
                        i++;
                        vdd = log1.vrfc(e, s, a);
                        loga = log1.idLog(e, s, a);
                        idU = user1.Id(loga, a);


                    }
                    while (!vdd);

                    System.out.println("O que deseja fazer");
                    do {
                        System.out.println("1 Assistir um Filme");
                        System.out.println("2 Assistir uma Serie");
                        System.out.println("3 Procura filme por ator");
                        System.out.println("4 Procura serie por ator");
                        System.out.println("5 Alterar/Atualizar o perfil");
                        System.out.println("0 Sair");
                        x = scan.nextInt();
                        switch (x) {
                            case 1: {

                                while (!ver) {
                                    System.out.println("Selecione o filme que deseja: ");
                                    filmes1.nomeFilmes(a);
                                    film = scan.nextInt();
                                    ver = filmes1.verificar(film, a);
                                }
                                filmes1.selecionado(film, a);
                                System.out.println("Deseja ver mais algo");
                                ver = false;
                                break;
                            }
                            case 2: {
                                ver = false;
                                while (!ver) {
                                    System.out.println("Selecione a serie que deseja: ");
                                    serie1.nomeSeries(a);
                                    film = scan.nextInt();
                                    ver = serie1.verificar(film, a);
                                }
                                System.out.println("Você escolheu a serie: ");
                                serie1.selecionado(film, a);

                                System.out.println("Deseja ver mais algo");

                                ver = false;
                                break;
                            }
                            case 3: {
                                ator1.selectAtor();
                                System.out.println("Selecione um ator");
                                int ator = scan.nextInt();

                                fha.selectAtorFilme(ator, a);
                                System.out.println("Deseja ver mais algo");
                                break;
                            }
                            case 4:{
                                ator1.selectAtor();
                                System.out.println("Selecione um ator");
                                int ator = scan.nextInt();
                                sha.selectSeriesAtor(ator, a);
                                System.out.println("Deseja ver mais algo");
                                break;
                            }
                            case 5: {
                                System.out.println("O que deseja alterar no seu perfil, Senhor(a)?");
                                System.out.println("1 -- Nome");
                                System.out.println("2 -- email");
                                System.out.println("3 -- senha");
                                System.out.println("4 -- APAGAR A CONTA");
                                int pao = scan.nextInt();
                                switch (pao) {
                                    case 1: {
                                        System.out.println("Digite o novo nome:");

                                        String novo = scan.next();
                                        user1.mudarnome(idU, novo, loga, a);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Digite novo email: ");
                                        String novo = scan.next();
                                        log1.setEmail(novo, loga, a);
                                        System.out.println("Agora faça o login novamente");
                                        x = 0;
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Digite nova senha: ");
                                        String novo = scan.next();
                                        log1.setSenha(novo, loga, a);
                                        System.out.println("Faça o login novamente");
                                        x =0;
                                        break;
                                    }
                                    case 4:{
                                        System.out.println("TEM CERTEZA?");
                                        System.out.println("1 -- SIM");
                                        System.out.println("2 -- NÃO");
                                        int ex = scan.nextInt();
                                        if(ex == 2){
                                            break;
                                        } else if (ex == 1) {
                                            user1.deletar(idU);
                                            log1.deletar(loga);
                                            x =0;
                                        }
                                        else {
                                            throw new IllegalStateException("Unexpected value: " + ex);
                                        }
                                    }
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + pao);
                                }
                            }
                            default: {

                            }
                        }

                    }
                    while (x != 0);
                }
            }
            else{
                throw new IllegalStateException("Unexpected value: " + a);
            }
        } while (a != 0) ;


    }
}


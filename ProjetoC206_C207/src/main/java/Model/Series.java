package Model;

import DAO.SeriesDAO;

import java.util.ArrayList;

public class Series extends Conteudo implements vereficar{

    private int qntEp;
    private int idStreaming;

    private SeriesDAO seriesDAO = new SeriesDAO();


    public Series(int id, String titulo, String genero, int nota, String diretor, int qntEp, int idStreaming) {
        super(id, titulo, genero, nota, diretor);
        this.qntEp = qntEp;
        this.idStreaming = idStreaming;

    }
    public void insertTable(){
        seriesDAO.insertSeries( getId(), getTitulo(),  getGenero(),  getNota(),  qntEp, getDiretor(),idStreaming);
    }
    public int getQntEp() {
        return qntEp;
    }

    public void nomeSeries(int Str){
        seriesDAO.nomeselectSerie(Str);
    }

    @Override
    public boolean verificar(int valor, int Str) {
        return seriesDAO.especificselectSeries(valor, Str);

    }
    public void selecionado(int id, int Str){
        ArrayList<Series> series = seriesDAO.especificSeries(id, Str);
        for (int i = 0; i < series.size(); i++) {
            if(series.get(i) != null){
                System.out.println("Serie selecionada: "+series.get(i).getTitulo());
                System.out.println("Quantidade Episodios " + series.get(i).getQntEp());
                System.out.println("Diretor: " + series.get(i).getDiretor());
                System.out.println("Nota: " + series.get(i).getNota());
            }
        }
        System.out.println("ASSISTINDO");
        System.out.println("Acabo a serie aaaa");
        series.clear();
    }



}

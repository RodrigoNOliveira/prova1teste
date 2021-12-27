import java.util.ArrayList;

public class Campeonato {

    private String nome;
    private int qtdPtds;
    private int anoCamp;
    protected ArrayList<Partidas> listPartidas;
    protected ArrayList<PartidasJogadas> listJogadas;
    private String vencedor;
    private Time tim;
    private int qtdGols = 0;

    
    public Campeonato(String nome, int anoCamp) {
        this.qtdPtds = 0;
        this.nome = nome;
        this.anoCamp = anoCamp;
        this.listPartidas = new ArrayList<Partidas>();
        this.listJogadas = new ArrayList<PartidasJogadas>();

    }

    public void addPtd(Partidas ptds) {
        if (this.qtdPtds < 10) {
            this.listPartidas.add(ptds);
            this.qtdPtds++;
        }
    }

    public void addPtdJgds(PartidasJogadas ptdsJgds) {
        if (this.qtdPtds < 10) {
            this.listJogadas.add(ptdsJgds);
            this.qtdPtds++;
        }
    }


    public void addGols (int gols){
        qtdGols += tim.getQtdGols();
        this.tim.setQtdGols(qtdGols);
    }

    public void geraListaPtds() {
        StringBuilder msg = new StringBuilder();
        msg.append("\n ------ Lista de partidas ------\n");
        msg.append("\nCampeonato: " + this.nome + " --------- Ano de: " + this.anoCamp);
        msg.append("\n\n Partida ----------- Mandante ---------------- Visitante\n\n");
        for (int i = 0; i < listPartidas.size(); i++) {
            if (listPartidas.get(i) != null) {
                msg.append(
                        "\n" + listPartidas.get(i).getId() + " --------- " + listPartidas.get(i).getMandante() + " ---------------- " + listPartidas.get(i).getVisitante());
            }

        }
        System.out.println(msg.toString());
    }

    
    public void geraListaJogadas() {
        StringBuilder msg = new StringBuilder();
        msg.append("\n ------- Lista de partidas Jogadas --------\n");
        msg.append("\nCampeonato: " + this.nome + " ----------- Ano de: " + this.anoCamp);
        msg.append("\n\nMandante --- Placar  --- Visitante ------- Vencedor ------- Estadio\n\n");
        for (int i = 0; i < listJogadas.size(); i++) {
            if (listJogadas.get(i) != null) {

                msg.append(
                        "\n" + listJogadas.get(i).getMandante() + " -------- " + listJogadas.get(i).getGolsMandante() + " x "
                                + listJogadas.get(i).getGolsVisitante() + " -------- " + listJogadas.get(i).getVisitante() 
                                + " -------- " + listJogadas.get(i).getVencedor() + " -------- " + listPartidas.get(i).getEstJgd());
                
            }

        }
        System.out.println(msg.toString());
    }

    public void geraListaClassificacao() {
        StringBuilder msg = new StringBuilder();
        msg.append("\n ----- Classificação -------\n");
        msg.append("\nCampeonato: " + this.nome + " - Ano de: " + this.anoCamp);
        msg.append("\n\nMandante ------ Visitante\n\n");
        for (int i = 0; i < listPartidas.size(); i++) {
            if (listPartidas.get(i) != null) {
                msg.append(
                        "\n" + listPartidas.get(i).getMandante() + "----------" + listPartidas.get(i).getVisitante());
            }

        }
        System.out.println(msg.toString());
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdPtds() {
        return qtdPtds;
    }

    public void setQtdPtds(int qtdPtds) {
        this.qtdPtds = qtdPtds;
    }

    /**
     * @return ArrayList<Partidas> return the listPartidas
     */
    public ArrayList<Partidas> getListPartidas() {
        return listPartidas;
    }

    /**
     * @param listPartidas the listPartidas to set
     */
    public void setListPartidas(ArrayList<Partidas> listPartidas) {
        this.listPartidas = listPartidas;
    }

    /**
     * @return int return the anoCamp
     */
    public int getAnoCamp() {
        return anoCamp;
    }

    /**
     * @param anoCamp the anoCamp to set
     */
    public void setAnoCamp(int anoCamp) {
        this.anoCamp = anoCamp;
    }

    /**
     * @return String return the vencedor
     */
    public String getVencedor() {
        return vencedor;
    }

    /**
     * @param vencedor the vencedor to set
     */
    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    /**
     * @return ArrayList<PartidasJogadas> return the listJogadas
     */
    public ArrayList<PartidasJogadas> getListJogadas() {
        return listJogadas;
    }

    /**
     * @param listJogadas the listJogadas to set
     */
    public void setListJogadas(ArrayList<PartidasJogadas> listJogadas) {
        this.listJogadas = listJogadas;
    }

}
import java.util.ArrayList;

public class Time {
    private String nome;
    private Estadio estadio;
    private int vitorias;
    private int qtdGols;
    protected ArrayList<Jogadores> listJogadores;
    protected Estadio[] vetorEstadio;
    //protected int[] vetGols ;
    private Jogadores capt;
    private int qtdEst;
    protected ArrayList<Integer> listGols;

    public Time(String nome){
        this.nome = nome;
        this.listJogadores = new ArrayList<Jogadores>();
        this.vetorEstadio =  new Estadio[1];
        this.qtdEst = 0;
        this.vitorias = 0;
        this.qtdGols = 0;
        this.listGols = new ArrayList<Integer>();
         
    }


    public Jogadores getCapt() {
        return capt;
    }
    public void setCapt(Jogadores capt) {
        this.capt = capt;
    }
    
    public void somarGols(int gol){
        this.listGols.add(gol);
        
    }

 
    /*public Time(String nome,int vitorias, int gols){
        this.nome = nome;
        this.vitorias = 0;

    }*/



    public ArrayList<Jogadores> getListJogadores() {
        return listJogadores;
    }

    public void setListJogadores(ArrayList<Jogadores> listJogadores) {
        this.listJogadores = listJogadores;
    }


    public void adicionarJogador(Jogadores j){
        this.listJogadores.add(j);
    }
    public void adicionarEstadio(Estadio e){
        if (qtdEst < vetorEstadio.length){
            this.vetorEstadio[this.qtdEst] = e;
            this.qtdEst++;}
        
    }

    public void addVit(Time tim) { 
            this.vitorias +=1;

        }

    public void capitao(Jogadores c){
        this.capt = c;
    }

        public void geraInfo() {
            StringBuilder msg = new StringBuilder();
            msg.append("\n ------ Informações time ------\n");
            msg.append("\nTime: " + this.nome + " --------- Estádio: ");
            for (int i = 0; i < vetorEstadio.length; i++) {  
            if (vetorEstadio[i] != null){
            msg.append(vetorEstadio[i].getNome());}
            }
            
            
            msg.append("\n\nGols  do time: ");
            for (int i = 0; i < listGols.size(); i++) {
                if (listGols.get(i) != null){
                    qtdGols += listGols.get(i);
                }
            
            }msg.append(qtdGols);
            msg.append("\n\nJogadores:");
            for (int i = 0; i < listJogadores.size(); i++) {
                if (listJogadores.get(i) != null) {
                    msg.append(
                            "\n" + listJogadores.get(i).getNome());
                }
    
            }
            if (capt != null){
            msg.append("\n\nCapitão do time: " + capt.getNome());}
            else {msg.append("\n\nCapitão não cadastrado");}

            System.out.println(msg.toString());
        }
    
    public Estadio[] getVetorEstadio() {
            return vetorEstadio;
        }


        public void setVetorEstadio(Estadio[] vetorEstadio) {
            this.vetorEstadio = vetorEstadio;
        }


       /* public int[] getVetGols() {
            return vetGols;
        }


        public void setVetGols(int[] vetGols) {
            this.vetGols = vetGols;
        }*/


        public int getQtdEst() {
            return qtdEst;
        }


        public void setQtdEst(int qtdEst) {
            this.qtdEst = qtdEst;
        }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQtdGols() {
        return qtdGols;
    }

    public void setQtdGols(int qtdGols) {
        this.qtdGols = qtdGols;
    }
    public Estadio getEstadio() {
        return estadio;
    }
    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
        this.nome = estadio.getNome();
    }
    public int getVitorias() {
        return vitorias;
    }
    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }


    public ArrayList<Integer> getListGols() {
        return listGols;
    }


    public void setListGols(ArrayList<Integer> listGols) {
        this.listGols = listGols;
    }


   

}
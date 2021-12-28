import java.util.ArrayList;

public class Time {
    private String nome;
    private Estadio estadio;
    protected int vitorias;
    protected int qtdGols;
    protected ArrayList<Jogadores> listJogadores;
    protected Estadio[] vetorEstadio;
    //protected int[] vetGols ;
    private Jogadores capt;
    private int qtdEst;
    protected ArrayList<Integer> listGols;
    protected ArrayList<Integer> listVtr;

    public Time(String nome){
        this.nome = nome;
        this.listJogadores = new ArrayList<Jogadores>();
        this.vetorEstadio =  new Estadio[1];
        this.qtdEst = 0;
        this.vitorias = 0;
        this.qtdGols = 0;
        this.listGols = new ArrayList<Integer>();
        this.listVtr = new ArrayList<Integer>();
         
    }

   

    public ArrayList<Integer> getListVtr() {
        return listVtr;
    }


    public void setListVtr(ArrayList<Integer> listVtr) {
        this.listVtr = listVtr;
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
    public void somarVitorias(int vitoria){
        this.listVtr.add(vitoria);
        
    }


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
            qtdGols = 0;
            for (int i = 0; i < listGols.size(); i++) {
            qtdGols = 0; 
                if (listGols.get(i) != null){
                    qtdGols = qtdGols + listGols.get(i);
                }
            
            } msg.append(qtdGols);
            
            msg.append("\n\nVitorias  do time: ");
            vitorias = 0;
            for (int i = 0; i < listVtr.size(); i++) {
              
                if (listVtr.get(i) != null){
                    vitorias = vitorias + listVtr.get(i);
                }
            
            }msg.append(vitorias);
            vitorias = 0;
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

public class Time {
    private String nome;
    /*private Estadio estadio;
    private Partidas partidas;
    private int vitorias;*/

    /*public Time(String nome, Estadio estadio, Partidas partidas){
        this.nome = nome;
        this.estadio = estadio;
        this.partidas = partidas;

    }*/
    public Time(String nome){
        this.nome = nome;
    }

    /*public String Mandante(){
        String mandante = this.partidas.getMandante();
        return mandante;
    }
    public String Visitante(){
        String visitante = this.partidas.getVisitante();
        return visitante;
    }

    public void estadio(Estadio estd){
        
            setEstadio(estd);
    }*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    /*public Estadio getEstadio() {
        return estadio;
    }
    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Partidas getPartidas() {
        return partidas;
    }
  
    public void setPartidas(Partidas partidas) {
        this.partidas = partidas;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }
*/
}

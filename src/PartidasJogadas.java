public class PartidasJogadas {
    private String mandante;
    private String visitante;
    private Estadio estadioMdt;
    private int golsMandante;
    private int golsVisitante;
    private String vencedor;

    public PartidasJogadas(String mandante, String visitante, int golsMandante, int golsVisitante, String vencedor) {
        this.mandante = mandante;
        this.visitante = visitante;
        this.golsMandante = golsMandante;
        this.golsVisitante = golsVisitante;
        this.vencedor = vencedor;
    }



    public String getVencedor() {
        return vencedor;
    }



    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }



    public String getMandante() {
        return mandante;}
 
    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public String getVisitante() {
        return visitante;
    }

 
    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    
    public Estadio getEstadioMdt() {
        return estadioMdt;
    }

    
    public void setEstadioMdt(Estadio estadioMdt) {
        this.estadioMdt = estadioMdt;
    }

 
    public int getGolsMandante() {
        return golsMandante;
    }

   
    public void setGolsMandante(int golsMandante) {
        this.golsMandante = golsMandante;
    }

   
    public int getGolsVisitante() {
        return golsVisitante;
    }

    public void setGolsVisitante(int golsVisitante) {
        this.golsVisitante = golsVisitante;
    }


}

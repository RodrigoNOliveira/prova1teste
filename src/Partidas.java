public class Partidas {
    private String mandante;
    private String visitante;
    private int id;
    private String estJgd;
    //private Time tim;



    public Partidas( int id, String mandante, String visitante, String estJgd ) {
        this.id = id;
        this.mandante = mandante;
        this.visitante = visitante;
        this.estJgd = estJgd;
    }
  
    /*public void estdJgds(){
        if (tim.getNome().equals(mandante)){
            String estdJgd = tim.getEstadio().getNome();
        }
    }*/

    public String getEstJgd() {
        return estJgd;
    }

    public void setEstJgd(String estJgd) {
        this.estJgd = estJgd;
    }

    /**
     * @return String return the mandante
     */
    public String getMandante() {
        return mandante;
    }

    /**
     * @param mandante the mandante to set
     */
    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    /**
     * @return String return the visitante
     */
    public String getVisitante() {
        return visitante;
    }

    /**
     * @param visitante the visitante to set
     */
    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }


    /**
     * @return int return the id
     */
    public int  getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}

public class Partidas {
    private String mandante;
    private String visitante;
    private String capMdt;
    private String capVisit;
    private int id;



    public Partidas( int id, String mandante, String visitante, String capMdt,
            String capVisit) {
        this.id = id;
        this.mandante = mandante;
        this.visitante = visitante;
        this.capMdt = capMdt;
        this.capVisit = capVisit;
    }
  

    public String getCapMdt() {
        return capMdt;
    }

    public void setCapMdt(String capMdt) {
        this.capMdt = capMdt;
    }

    public String getCapVisit() {
        return capVisit;
    }

    public void setCapVisit(String capVisit) {
        this.capVisit = capVisit;
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

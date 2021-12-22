import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Processos {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Campeonato> listCamp;
    private ArrayList<Time> listTime;
    private ArrayList<Estadio> listEstadio;
    private ArrayList<Jogadores> listJgdrs;
    private ArrayList<Partidas> listPartidas;
    private ArrayList<PartidasJogadas> listPtdJgds;
    private int totalPtds;
    // private Partidas partidas;
    // private Time tim;

    public Processos() {
        this.totalPtds = 0;
        this.listCamp = new ArrayList<Campeonato>();
        this.listTime = new ArrayList<Time>();
        this.listEstadio = new ArrayList<Estadio>();
        this.listJgdrs = new ArrayList<Jogadores>();
        this.listPartidas = new ArrayList<Partidas>();
        this.listPtdJgds = new ArrayList<PartidasJogadas>();
        // this.partidas = partidas;
    }

    public void cadastrarCampeonato() {
        scanner.nextLine();
        System.out.println("Digite o nome do campeonato: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o ano do campeonato: ");
        int ano = scanner.nextInt();
        Campeonato camp = new Campeonato(nome, ano);
        this.listCamp.add(camp);
    }

    public void cadastrarTime() {
        scanner.nextLine();
        System.out.println("Digite o nome do time: ");
        String nome = scanner.nextLine();
        Time tim = new Time(nome);
        this.listTime.add(tim);

    }

    public void cadastrarEstadio() {
        scanner.nextLine();
        System.out.println("Digite o nome do estádio: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Digite o endereço do estádio: ");
        String endereco = scanner.nextLine();
        scanner.nextLine();
        Estadio estd = new Estadio(nome, endereco);
        // tim.estadio(estd);
        this.listEstadio.add(estd);

    }

    public void cadastrarJogadores() throws ParseException {
        System.out.println("Digite o nome do jogador:");
        String nome = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Digite sua data de nascimento: (xx/xx/xxxx)");

        String data = scanner.nextLine();
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date nascimento = df.parse(data);
            scanner.nextLine();
            System.out.println("Digite seu gênero: ");
            String genero = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Digite sua altura:");
            float altura = scanner.nextFloat();
            scanner.nextLine();
            Jogadores jdrs = new Jogadores(nome, nascimento, genero, altura);
            this.listJgdrs.add(jdrs);
        } catch (ParseException exc) {
            System.out.println("data informada em formato errado!");
        }

    }

    public void cadastrarPartida() {
        String mandante = " ";
        String visitante = " ";
        String capMdt = " ";
        String capVisit = " ";
        Campeonato camp;

        System.out.println("Digite o nome do campeonato: ");
        String nome = this.scanner.nextLine();
        scanner.nextLine();
        camp = this.buscarCamp(nome);
        if (camp != null) {

            System.out.println("Digite o nome do time mandante: ");
            nome = this.scanner.nextLine();
            scanner.nextLine();

            Time tim = this.buscarTime(nome);
            if (tim != null) {
                mandante = nome;
                System.out.println("Digite o jogador capitão do time mandante: ");
                nome = scanner.nextLine();
                scanner.nextLine();
                Jogadores jgdrs = this.buscarJogadores(nome);
                if (jgdrs != null) {
                    capMdt = nome;
                    System.out.println("Digite o nome do time visitante: ");
                    nome = this.scanner.nextLine();
                    scanner.nextLine();
                    tim = this.buscarTime(nome);
                    if (tim != null) {
                        visitante = nome;
                        System.out.println("Digite o jogador capitão do time visitante: ");
                        nome = scanner.nextLine();
                        scanner.nextLine();
                        jgdrs = this.buscarJogadores(nome);
                        if (jgdrs != null) {

                            capVisit = nome;
                            Partidas ptdsJgds = new Partidas(totalPtds + 1, mandante, visitante, capMdt, capVisit);
                            camp.addPtd(ptdsJgds);
                            this.totalPtds++;

                        } else {
                            System.out.println("jogador não encontrado");
                        }
                    } else {
                        System.out.println("Time não encontrado");
                    }
                } else {
                    System.out.println("jogador não encontrado");
                }
            } else {
                System.out.println("Time não encotrado");
            }
        } else {
            System.out.println("Time não encontrado!");
        }

        /*
         * Partidas ptds = new Partidas(mandante, visitante, capMdt, capVisit);
         * this.listPartidas.add(ptds);
         */
    }

    public void cadastrarResultado() {
        String mandante = " ";
        String visitante = " ";
        int golsMandante = 0;
        int golsVisitante = 0;
        Campeonato camp;
        String vencedor = " ";
        Partidas ptds;

        System.out.println("Digite o nome do campeonato: ");
        String nome = this.scanner.nextLine();
        scanner.nextLine();
        camp = this.buscarCamp(nome);
        if (camp != null) {
            geraListaPartida();
            System.out.println("Digite o numero da partida: ");
            int id = this.scanner.nextInt();
            ptds = this.buscarPtds(id);
            scanner.nextLine();
            if (ptds != null) {
                System.out.println("Digite os gols que o time mandante fez: ");
                golsMandante = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite os gols que o time visitante fez: ");
                golsVisitante = scanner.nextInt();
                scanner.nextLine();
                if (golsMandante > golsVisitante) {
                    vencedor = mandante;
                } else if (golsMandante < golsVisitante) {
                    vencedor = visitante;
                } else {
                    vencedor = "empate";
                }
                PartidasJogadas ptdsJgds = new PartidasJogadas(mandante, visitante, golsMandante,
                        golsVisitante, vencedor);
                camp.addPtdJgds(ptdsJgds);
            } else {
                System.out.println("Partida não encontrada");
            }
        } else {
            System.out.println("Campeonato não encontrado!");
        }
    }

    /*
     * System.out.println("Digite o nome do campeonato: ");
     * String nome = this.scanner.nextLine();
     * scanner.nextLine();
     * camp = this.buscarCamp(nome);
     * if (camp != null) {
     * 
     * 
     * System.out.println("Digite o nome do time mandante: ");
     * nome = this.scanner.nextLine();
     * scanner.nextLine();
     * 
     * Time tim = this.buscarTime(nome);
     * if (tim != null) {
     * 
     * mandante = nome;
     * System.out.println("Digite os gols que o time mandante fez: ");
     * golsMandante = scanner.nextInt();
     * scanner.nextLine();
     * System.out.println("Digite o nome do time visitante: ");
     * nome = this.scanner.nextLine();
     * scanner.nextLine();
     * tim = this.buscarTime(nome);
     * if (tim != null) {
     * visitante = nome;
     * System.out.println("Digite os gols que o time visitante fez: ");
     * golsVisitante = scanner.nextInt();
     * scanner.nextLine();
     * 
     * if ( golsMandante > golsVisitante){
     * vencedor = mandante;
     * } else if (golsMandante < golsVisitante){
     * vencedor = visitante;
     * } else {
     * vencedor = "empate";
     * }
     * 
     * 
     * 
     * PartidasJogadas ptdsJgds = new PartidasJogadas(mandante, visitante,
     * golsMandante,
     * golsVisitante, vencedor);
     * camp.addPtdJgds(ptdsJgds);
     * 
     * } else {
     * System.out.println("Time não encontrado");
     * }
     * } else {
     * System.out.println("Time não encontrado");
     * }
     * } else {
     * System.out.println("Campeonato não encontrado!");
     * }
     * 
     * }
     */

    public Campeonato buscarCamp(String nome) {
        for (int i = 0; i < this.listCamp.size(); i++) {
            if (this.listCamp.get(i).getNome().equalsIgnoreCase(nome)) {
                return this.listCamp.get(i);
            }

        }
        return null;
    }

    public Jogadores buscarJogadores(String nome) {
        for (int i = 0; i < this.listJgdrs.size(); i++) {
            if (this.listJgdrs.get(i).getNome().equalsIgnoreCase(nome)) {
                return this.listJgdrs.get(i);
            }
        }
        return null;
    }

    public Partidas buscarPtds(int id) {
        for (int i = 0; i < this.listPartidas.size(); i++) {

            if (this.listPartidas.size() == id - 1) {

                return this.listPartidas.get(i);

            }
        }
        return null;
    }

    public Time buscarTime(String nome) {
        for (int i = 0; i < this.listTime.size(); i++) {
            if (this.listTime.get(i).getNome().equalsIgnoreCase(nome)) {
                return this.listTime.get(i);
            }

        }
        return null;
    }

    public void geraListaPartida() {
        System.out.println("Digite o nome do campeonato: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        Campeonato camp = this.buscarCamp(nome);
        if (camp != null) {
            camp.geraListaPtds();
        } else {
            System.out.println("Campeonato não encontrado");
        }
    }

    public void geraListaJogadas() {
        System.out.println("Digite o nome do campeonato: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        Campeonato camp = this.buscarCamp(nome);
        if (camp != null) {
            camp.geraListaJogadas();
        } else {
            System.out.println("Campeonato não encontrado");
        }
    }

    public void geraListaClassificacao() {
        System.out.println("Digite o nome do campeonato: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        Campeonato camp = this.buscarCamp(nome);
        if (camp != null) {
            camp.geraListaPtds();
        } else {
            System.out.println("Campeonato não encontrado");
        }
    }

    public ArrayList<Campeonato> getListCamp() {
        return listCamp;
    }

    public void setListCamp(ArrayList<Campeonato> listCamp) {
        this.listCamp = listCamp;
    }

    public ArrayList<Time> getListTime() {
        return listTime;
    }

    public void setListTime(ArrayList<Time> listTime) {
        this.listTime = listTime;
    }

    public ArrayList<Estadio> getListEstadio() {
        return listEstadio;
    }

    public void setListEstadio(ArrayList<Estadio> listEstadio) {
        this.listEstadio = listEstadio;
    }

    public ArrayList<Jogadores> getListJgdrs() {
        return listJgdrs;
    }

    public void setListJgdrs(ArrayList<Jogadores> listJgdrs) {
        this.listJgdrs = listJgdrs;
    }

    public ArrayList<Partidas> getListPartidas() {
        return listPartidas;
    }

    public void setListPartidas(ArrayList<Partidas> listPartidas) {
        this.listPartidas = listPartidas;
    }

    public ArrayList<PartidasJogadas> getListPtdJgds() {
        return listPtdJgds;
    }

    public void setListPtdJgds(ArrayList<PartidasJogadas> listPtdJgds) {
        this.listPtdJgds = listPtdJgds;
    }

    /**
     * @return Scanner return the scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * @param scanner the scanner to set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * @return int return the totalPtds
     */
    public int getTotalPtds() {
        return totalPtds;
    }

    /**
     * @param totalPtds the totalPtds to set
     */
    public void setTotalPtds(int totalPtds) {
        this.totalPtds = totalPtds;
    }

}

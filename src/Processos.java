import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Processos {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Campeonato> listCamp;
    //protected ArrayList<Time> listTime;
    private ArrayList<Estadio> listEstadio;

    private int totalPtds;
    private Campeonato camp;
    private Partidas ptds;
    private Time tim;
    private Jogadores jogadores;
    private PartidasJogadas ptdsJgds;
    protected int gols;

    public Processos() {
        this.totalPtds = 0;
        this.listCamp = new ArrayList<Campeonato>();
        //this.listTime = new ArrayList<Time>();
        this.listEstadio = new ArrayList<Estadio>();
    }

    public void cadastrarCampeonato() {
        // scanner.nextLine();
        System.out.print("Digite o nome do campeonato: ");
        String nome = scanner.nextLine();
        // scanner.nextLine();
        System.out.print("Digite o ano do campeonato: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        Campeonato camp = new Campeonato(nome, ano);
        this.listCamp.add(camp);
    }

    public void cadastrarTime() {
        System.out.print("Digite o nome do campeonato: ");
        String nome = this.scanner.nextLine();
        scanner.nextLine();
        camp = this.buscarCamp(nome);
        if (camp != null) {
        scanner.nextLine();
        System.out.print("Digite o nome do time: ");
        nome = scanner.nextLine();
        scanner.nextLine();
        Time tim = new Time(nome);
        camp.addTime(tim);}
        else {
            System.out.println("Campeonato não encontrado!");
        }

    }

    public void cadastrarEstadio() {
        System.out.print("Digite o nome do time: ");
        String nome = this.scanner.nextLine();
        scanner.nextLine();
        tim = this.buscarTime(nome);
        if (tim != null) {
            scanner.nextLine();
            System.out.print("Digite o nome do estádio: ");
            nome = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Digite o endereço do estádio: ");
            String endereco = scanner.nextLine();
            scanner.nextLine();
            Estadio estd = new Estadio(nome, endereco);
            this.listEstadio.add(estd);
            tim.adicionarEstadio(estd);
        } else {
            System.out.println("Time não encontrado!");
        }

    }

    public void cadastrarJogadores() throws ParseException {
        System.out.print("Digite o nome do time: ");
        String nome = this.scanner.nextLine();
        scanner.nextLine();
        tim = this.buscarTime(nome);
        if (tim != null) {
            System.out.print("Digite o nome do jogador:");
            nome = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Digite sua data de nascimento(xx/xx/xxxx): ");

            String data = scanner.nextLine();
            try {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date nascimento = df.parse(data);
                scanner.nextLine();
                System.out.print("Digite seu gênero: ");
                String genero = scanner.nextLine();
                scanner.nextLine();
                System.out.print("Digite sua altura:");
                float altura = scanner.nextFloat();
                scanner.nextLine();
                Jogadores jogadores = new Jogadores(nome, nascimento, genero, altura);

                tim.adicionarJogador(jogadores);
            } catch (ParseException exc) {
                System.out.println("data informada em formato errado!");
            }

        } else {
            System.out.println("Time não encontrado!");
        }
    }

    public void cadastrarPartida() {
        String mandante = " ";
        String visitante = " ";
        String estdJgd;

        System.out.print("Digite o nome do campeonato: ");
        String nome = this.scanner.nextLine();
        scanner.nextLine();
        camp = this.buscarCamp(nome);
        if (camp != null) {

            System.out.print("Digite o nome do time mandante: ");
            nome = this.scanner.nextLine();
            scanner.nextLine();
            
            tim = this.buscarTime(nome);
            if (tim != null) { 
                
                if (tim.vetorEstadio[0] != null) {
                    estdJgd = tim.vetorEstadio[0].getNome();
                } else {
                    estdJgd = "Estádio não cadastrado";
                }
                
                mandante = nome;
                System.out.print("Digite o jogador capitão do time mandante: ");
                nome = scanner.nextLine();
                scanner.nextLine();
                jogadores = buscarJogadores(nome); 
                
                if (jogadores != null) {
                    tim.capitao(jogadores);

                    
                    
                    System.out.print("Digite o nome do time visitante: ");
                    nome = this.scanner.nextLine();
                    scanner.nextLine();
                    
                    tim = this.buscarTime(nome);
                      
                    if (tim != null) {   
                        
                        visitante = nome;
                        System.out.print("Digite o jogador capitão do time visitante: ");
                        nome = scanner.nextLine();
                        scanner.nextLine();
                        jogadores = this.buscarJogadores(nome);
                        if (jogadores != null) {

                            tim.capitao(jogadores);
                            
                            Partidas ptds = new Partidas(totalPtds + 1, mandante, visitante, estdJgd);
                            camp.addPtd(ptds);
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
            System.out.println("Campeonato não encontrado!");
        }
    }

    public void cadastrarResultado() {
        String mandante = " ";
        String visitante = " ";
        int golsMandante = 0;
        int golsVisitante = 0;
        // Campeonato camp;
        String vencedor = " ";
        // Partidas ptds;

        System.out.print("Digite o nome do campeonato: ");
        String nome = this.scanner.nextLine();
        scanner.nextLine();
        camp = this.buscarCamp(nome);
        if (camp != null) {
            geraListaPartida();
            System.out.print("Digite o numero da partida: ");
            int id = this.scanner.nextInt();
            ptds = this.buscarPtds(id);
            scanner.nextLine();
            if (ptds != null) {
                mandante = ptds.getMandante();
                System.out.print("Digite os gols que o time mandante fez: ");
                golsMandante = scanner.nextInt();
                String nome1 = mandante;
                tim = this.buscarTime(nome1);
                if (tim != null){
                    tim.somarGols(golsMandante);
                }
                
                scanner.nextLine();
                visitante = ptds.getVisitante();
                System.out.print("Digite os gols que o time visitante fez: ");
                golsVisitante = scanner.nextInt();
                String nome2 = visitante;
                tim = this.buscarTime(nome2);
                scanner.nextLine();
                if (tim != null ){
                tim.somarGols(golsVisitante);
                }
                
                
                

                // tim.addGols(golsVisitante);
                if (golsMandante > golsVisitante) {
                    vencedor = mandante;
                    tim = buscarTime(vencedor);
                    if (tim != null) {
                        tim.somarVitorias(+1);
                    }

                } else if (golsMandante < golsVisitante) {
                    vencedor = visitante;
                    tim = buscarTime(visitante);
                    if (tim != null) {
                        tim.somarVitorias(+1);
                    }
                } else {
                    vencedor = "empate";
                }
                PartidasJogadas ptdsJgds = new PartidasJogadas(mandante, visitante, golsMandante, golsVisitante,
                        vencedor);
                camp.addPtdJgds(ptdsJgds);
            } else {
                System.out.println("Partida não encontrada");
            }
        } else {
            System.out.println("Campeonato não encontrado!");
        }
    }

    /*public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }*/

    public Campeonato buscarCamp(String nome) {
        for (int i = 0; i < this.listCamp.size(); i++) {
            if (this.listCamp.get(i).getNome().equalsIgnoreCase(nome)) {
                return this.listCamp.get(i);
            }

        }
        return null;
    }

    public Jogadores buscarJogadores(String nome) {
        for (int i = 0; i < tim.listJogadores.size(); i++) {
            if (tim.listJogadores.get(i).getNome().equalsIgnoreCase(nome)) {
                return tim.listJogadores.get(i);
            }
        }
        return null;
    }

    public Partidas buscarPtds(int id) {
        for (int i = 0; i < camp.listPartidas.size(); i++) {

            if (camp.listPartidas.get(i).getId() == id) {

                return camp.listPartidas.get(i);

            }
        }
        return null;
    }

    public Time buscarTime(String nome) {
        for (int i = 0; i < camp.listTimes.size(); i++) {
            if (camp.listTimes.get(i).getNome().equalsIgnoreCase(nome)) {
                return camp.listTimes.get(i);
            }

        }
        return null;
    }

    public void geraListaPartida() {
        System.out.print("Digite o nome do campeonato: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        camp = this.buscarCamp(nome);
        if (camp != null) {
            camp.geraListaPtds();
        } else {
            System.out.println("Campeonato não encontrado");
        }
    }

    public void geraListaJogadas() {
        System.out.print("Digite o nome do campeonato: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        camp = this.buscarCamp(nome);
        if (camp != null) {
            camp.geraListaJogadas();
        } else {
            System.out.println("Campeonato não encontrado");
        }
    }

    public void geraListaClassificacao() {
        System.out.print("Digite o nome do campeonato: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        camp = this.buscarCamp(nome);
        if (camp != null) {
            camp.geraListaClassificacao();
        } else {
            System.out.println("Campeonato não encontrado");
        }
    }

    public void geraInfo() {
        System.out.print("Digite o nome do time: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        tim = this.buscarTime(nome);
        if (tim != null) {
            tim.geraInfo();
        } else {
            System.out.println("Time não encontrado!");
        }

    }

    public Campeonato getCamp() {
        return camp;
    }

    public void setCamp(Campeonato camp) {
        this.camp = camp;
    }

    public Partidas getPtds() {
        return ptds;
    }

    public void setPtds(Partidas ptds) {
        this.ptds = ptds;
    }

    public Time getTim() {
        return tim;
    }

    public void setTim(Time tim) {
        this.tim = tim;
    }

    public Jogadores getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogadores jogadores) {
        this.jogadores = jogadores;
    }

    public PartidasJogadas getPtdsJgds() {
        return ptdsJgds;
    }

    public void setPtdsJgds(PartidasJogadas ptdsJgds) {
        this.ptdsJgds = ptdsJgds;
    }

    public ArrayList<Campeonato> getListCamp() {
        return listCamp;
    }

    public void setListCamp(ArrayList<Campeonato> listCamp) {
        this.listCamp = listCamp;
    }


    public ArrayList<Estadio> getListEstadio() {
        return listEstadio;
    }

    public void setListEstadio(ArrayList<Estadio> listEstadio) {
        this.listEstadio = listEstadio;
    }
/*
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
*/
    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getTotalPtds() {
        return totalPtds;
    }

    public void setTotalPtds(int totalPtds) {
        this.totalPtds = totalPtds;
    }

}
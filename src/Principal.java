import java.text.ParseException;
import java.util.Scanner;

public class Principal {
    private Scanner scanner;
    private Processos processosSi;

    public Principal() {
        scanner = new Scanner(System.in);
        processosSi = new Processos();
    }

    public void iniciar() throws ParseException {

        int opcao = 0;
        String nome = "";
        do {
            System.out.println(" --- Menu ---");
            System.out.println("1 - Cadatrar Campeonato");
            System.out.println("2 - Cadatrar Time");
            System.out.println("3 - Cadastrar Estádio");
            System.out.println("4 - Cadastrar Jogadores");
            System.out.println("5 - Cadastrar partida");
            System.out.println("6 - Cadastrar resultado de partida");
            System.out.println("7 - Lista de partidas");
            System.out.println("8 - Lista de partidas jogadas");
            System.out.println("9- Lista de classificação");
            System.out.println("0- Sair");
            System.out.print("Digite a opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    this.processosSi.cadastrarCampeonato();
                    break;

                case 2:
                    System.out.println("Digite o nome do campeonato: ");
                    nome = this.scanner.nextLine();
                    scanner.nextLine();
                    Campeonato camp = this.processosSi.buscarCamp(nome);
                    if (camp != null) {
                        this.processosSi.cadastrarTime();
                    } else {
                        System.out.println("Campeonato não encontrado!");
                    }
                    break;

                case 3:
                    System.out.println("Digite o nome do time: ");
                    nome = this.scanner.nextLine();
                    scanner.nextLine();
                    Time tim = this.processosSi.buscarTime(nome);
                    if (tim != null) {
                        this.processosSi.cadastrarEstadio();
                    } else {
                        System.out.println("Time não encontrado!");
                    }
                    break;

                case 4:

                    System.out.println("Digite o nome do time: ");
                    nome = this.scanner.nextLine();
                    scanner.nextLine();
                    tim = this.processosSi.buscarTime(nome);
                    if (tim != null) {
                        this.processosSi.cadastrarJogadores();
                    } else {
                        System.out.println("Time não encontrado!");
                    }

                    break;

                case 5:
                        this.processosSi.cadastrarPartida();
                    break;

                case 6:
                    
                        this.processosSi.cadastrarResultado();
                        break;
                
                case 7:

                    this.processosSi.geraListaPartida();
                    break;
                case 8:

                    this.processosSi.geraListaJogadas();
                    break;
                case 9:
                    this.processosSi.geraListaClassificacao();
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida!");

            }

        } while (opcao != 0);

    }

    public static void main(String[] args) throws Exception {

        Principal principal = new Principal();
        principal.iniciar();
    }
}

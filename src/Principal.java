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
            System.out.println("10- Informações do time");
            System.out.println("0- Sair");
            System.out.print("Digite a opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                
                    this.processosSi.cadastrarCampeonato();
                    break;

                case 2:
                        this.processosSi.cadastrarTime();
                    break;

                case 3:
                        this.processosSi.cadastrarEstadio();
                    break;

                case 4:
                    
                this.processosSi.cadastrarJogadores();
                    

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

                case 10:
                    this.processosSi.geraInfo();
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

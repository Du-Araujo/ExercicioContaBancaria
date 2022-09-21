import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GerenciarConta {
    private List<Conta> contas = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciarConta gc = new GerenciarConta();
        int opcao = 0;
        do {
            opcao = getMenuPrincpal(scanner, gc);
        } while (opcao != 9);
    }



    private static int getMenuPrincpal(Scanner scanner, GerenciarConta gc) {
        int opcao;
        System.out.println("\n" + "    **** GERENCIAMENTO DE CONTAS ****");
        System.out.println("    --------------------------------");
        System.out.println("    1. Registrar Nova Conta");
        System.out.println("    2. Depositar");
        System.out.println("    3. Sacar");
        System.out.println("    4. Todas as Contas");
        System.out.println("    5. Ver Saldo de Uma Conta");
        System.out.println("    6. Apresentar Patrimonio do Banco");
        System.out.println("    9. Sair\n");
        System.out.println(     "Escolha a opcao Desejada: ");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1:
                gc.cadastrarNovaConta(scanner);
                break;
            case 2:
                gc.depositar(scanner);
                break;
            case 3:
                gc.sacar(scanner);
                break;
            case 4:
                gc.listarTodasContas();
                break;
            case 5:
                gc.exibirSaldoConta(scanner);
                break;
            case 6:
                gc.apresentarPatrimonio();
                break;
            case 9:
                System.out.println("Sistema Sendo Finalizado! \n");
                break;
            default:
                System.out.println("Opcao Invalida! \n");
        }
        return opcao;
    }

    public void cadastrarNovaConta(Scanner scanner) {
        Conta conta = new Conta();
        System.out.println("Digite a Conta Desejada");
        conta.setnConta(Integer.parseInt(scanner.nextLine()));
        System.out.println("Digite o Nome do Cliente");
        conta.setNome(scanner.nextLine());
        System.out.println("Digite a Cidade ");
        conta.setCidade(scanner.nextLine());



        System.out.println("\nCadastro Efetuado com Sucesso!\n");
        contas.add(conta);
    }

    public void depositar(Scanner scanner) {
        System.out.println("Digite Numero da Conta");
        int codigo = Integer.parseInt(scanner.nextLine());

        // varrer lista
        for (Conta c : contas) {
            if (codigo == c.getnConta()) {
                System.out.println(("Digite Valor do Deposito"));
                int entrada = Integer.parseInt(scanner.nextLine());
                boolean ok = c.registrarDeposito(entrada);
                if (ok) {
                    System.out.println("Deposito Efetuado com Sucesso! \n");
                } else {
                    System.out.println("Valor Invalido para Deposito!\n");
                }
                return;
            }
        }

        System.out.println("Conta Nao Encontrada!\n");

    }


    public void sacar(Scanner scanner) {
        System.out.println("Digite Numero da Conta");
        int codigo = Integer.parseInt(scanner.nextLine());
        // varrer lista procurando conta
        for (Conta c : contas) {
            if (codigo == c.getnConta()) {
                System.out.println("Digite Valor Desejado");
                int saida = Integer.parseInt(scanner.nextLine());
                boolean ok = c.registrarSaque(saida);
                if (ok) {
                    System.out.println("Saque Efetuado com Sucesso!\n");
                } else {
                    System.out.println("Valor Ivalido para Saque!\n");
                }
                return;
            }
        }

        System.out.println("Conta Nao Encontrada!\n");
    }

    public void listarTodasContas() {
        if (contas.isEmpty()){
            System.out.println("Nenhuma Conta Cadastrada");
        }else {
            for (Conta c : contas) {
                System.out.println(c.toString());
            }
        }
    }

    public void exibirSaldoConta(Scanner scanner) {
        System.out.println("Digite o Numero da Conta: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        // Varrer lista para exebir saldo

        for (Conta c : contas) {
            if (c.getnConta() == codigo) {
                System.out.println( "============================ \n" +
                                    "DADOS DA CONTA \n" +
                                    "Numero da Conta: " + c.getnConta() + "\n" +
                                    "Cliente: " + c.getNome() + "\n" +
                                    "Cidade: " + c.getCidade() + "\n" +
                                    "Saldo: R$ " + c.getValor() + "\n" +
                                    "============================ \n");
                return;
            }
        }
        System.out.println("Conta Nao Encontrada!\n");
    }



    public void apresentarPatrimonio() {
        double total = 0.0;
        for (Conta c : contas) {
            total = total + c.getValor();
            // total+= c.getValor();
        }
        System.out.println( "================================ \n" +
                            "Total Patrimonio R$: " + total + "\n" +
                            "================================ \n");
    }
}
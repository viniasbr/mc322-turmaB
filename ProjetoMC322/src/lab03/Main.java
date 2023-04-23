package lab03;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Main {
    public static void main(String args []) throws Exception
    {
        ArrayList<Integer> selecao = new ArrayList<Integer>();
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        selecao.add(0,0);
        while(selecao.get(0) != 4) //Camada 0 do menu
        {
            System.out.print(
                "Bem vindo ao Sistema das Seguradoras. Digite o número correspondente para:"
                +"\n    1 - Registrar Nova Seguradora"
                +"\n    2 - Acessar Sistema de Seguradora"
                +"\n    3 - Demonstração do Sistema"
                +"\n    4 - Sair"
                +"\nOpção: "
            );
            selecao.add(0,Integer.parseInt(entrada.nextLine()));
            switch(selecao.get(0))
            {
                case 1:
                    System.out.print("\nInsira o nome da seguradora: ");
                    String nomeseg = entrada.nextLine();
                    System.out.print("Insira o telefone da seguradora: ");
                    String telefoneseg = entrada.nextLine();
                    System.out.print("Insira o email da seguradora: ");
                    String emailseg = entrada.nextLine();
                    System.out.print("Insira o endereço da seguradora: ");
                    String enderecoseg = entrada.nextLine();
                    listaSeguradoras.add(new Seguradora(nomeseg, telefoneseg, emailseg, enderecoseg));
                    System.out.print("Seguradora " + listaSeguradoras.get(listaSeguradoras.size()-1).getNome() + " registrada.\n\n");
                    break;
                case 2: //Camada 1 do menu (listaSeguradoras.get(selecao.get(1)-1) retorna a seguradora escolhida)
                    if(listaSeguradoras.size() <= 0)
                    {
                        System.out.print("Nenhuma seguradora foi cadastrada.\n\n");
                        break;
                    }
                    String saida = "\nSelecione a Seguradora:";
                    for(int i = 0; i < listaSeguradoras.size(); i++)
                    {
                        saida = saida +"\n    "+ (i+1) +" - " + listaSeguradoras.get(i).getNome();
                    }
                    saida = saida +"\n    "+(listaSeguradoras.size()+1)+" - Retornar ao Menu Principal";
                    saida = saida +"\nOpção: ";
                    System.out.print(saida);
                    selecao.add(1,Integer.parseInt(entrada.nextLine()));
                    System.out.print("\n");
                    if(selecao.get(1)-1 < listaSeguradoras.size() && selecao.get(1)-1 >= 0)
                    {
                        selecao.add(2,0);
                        while(selecao.get(2) != 6)
                        {
                            System.out.print( //Camada 2 do menu
                                "Sistema da Seguradora " + listaSeguradoras.get(selecao.get(1)-1).getNome() + ". Digite o número correspondente para:"
                                +"\n    1 - Registrar Novo Cliente"
                                +"\n    2 - Resgatar Informações do Cliente"
                                +"\n    3 - Registrar Novo Veículo do Cliente"
                                +"\n    4 - Gerar Novo Sinistro"
                                +"\n    5 - Resgatar Sinistros"
                                +"\n    6 - Retornar ao Menu Principal"
                                +"\nOpção: "
                                );
                            selecao.add(2,Integer.parseInt(entrada.nextLine()));
                            System.out.print("\n");
                            switch(selecao.get(2))
                            {
                                case 1://Camada 3 do menu
                                    selecao.add(3,0);
                                    System.out.print(
                                        "Selecione o tipo de cliente:"
                                        +"\n    1 - Pessoa Física"
                                        +"\n    2 - Pessoa Jurídica"
                                        +"\n    3 - Retornar ao Menu da Seguradora"
                                        +"\nOpção: "
                                    );
                                    selecao.add(3,Integer.parseInt(entrada.nextLine()));
                                    switch(selecao.get(3))
                                    {
                                        case 1:
                                            System.out.print("\nInsira o nome do Cliente: ");
                                            String nomepf = entrada.nextLine();
                                            System.out.print("Insira o endereço do Cliente: ");
                                            String enderecopf = entrada.nextLine();
                                            System.out.print("Insira o CPF do Cliente: ");
                                            String cpf = entrada.nextLine();
                                            System.out.print("Insira o gênero do Cliente: ");
                                            String genero = entrada.nextLine();
                                            System.out.print("Insira a data da licença do Cliente (em formato dd/mm/aaaa): ");
                                            String datalpfstring = entrada.nextLine();
                                            System.out.print("Insira a educação do Cliente: ");
                                            String educacaopf = entrada.nextLine();
                                            System.out.print("Insira a data de nascimento do Cliente (em formato dd/mm/aaaa): ");
                                            String datanpfstring = entrada.nextLine();
                                            System.out.print("Insira a classe econômica do Cliente: ");
                                            String classeecono = entrada.nextLine();
                                            try {
                                                LocalDate.parse(datalpfstring, formatador);
                                                LocalDate.parse(datanpfstring, formatador);
                                            } catch (Exception e) {
                                                System.out.println("Erro: Data(s) inválida(s)");
                                                break;
                                            }
                                            LocalDate dataLicencaPF = LocalDate.parse(datalpfstring, formatador);
                                            LocalDate dataNascimentoPF = LocalDate.parse(datanpfstring, formatador);
                                            System.out.print("Insira a placa do veículo do Cliente: ");
                                            String placavpf = entrada.nextLine();
                                            System.out.print("Insira a marca do veículo do Cliente: ");
                                            String marcavpf = entrada.nextLine();
                                            System.out.print("Insira o modelo do veículo do Cliente: ");
                                            String modelovpf = entrada.nextLine();
                                            System.out.print("Insira o ano de fabricação do veículo do Cliente: ");
                                            int anofabvpf = Integer.parseInt(entrada.nextLine());
                                            ClientePF clientePF = new ClientePF(nomepf, enderecopf, new Veiculo(placavpf, marcavpf, modelovpf, anofabvpf), cpf, genero, dataLicencaPF, educacaopf, dataNascimentoPF, classeecono);
                                            if(!clientePF.validarCPF())
                                            {
                                                System.out.print("CPF do Cliente inválido.\n");
                                                break;
                                            }
                                            listaSeguradoras.get(selecao.get(1)-1).cadastrarCliente(clientePF);
                                            System.out.print("Cliente Pessoa Física cadastrado com sucesso.\n");
                                            break;
                                        case 2:
                                            System.out.print("\nInsira o nome do Cliente: ");
                                            String nomepj = entrada.nextLine();
                                            System.out.print("Insira o endereço do Cliente: ");
                                            String enderecopj = entrada.nextLine();
                                            System.out.print("Insira o CNPJ do Cliente: ");
                                            String cnpj = entrada.nextLine();
                                            System.out.print("Insira a data da fundação do Cliente (em formato dd/mm/aaaa): ");
                                            String datafpjstring = entrada.nextLine();
                                            try {
                                                LocalDate.parse(datafpjstring, formatador);
                                            } catch (Exception e) {
                                                System.out.println("Erro: Data(s) inválida(s)");
                                            break;
                                            }
                                            LocalDate dataFundacaoPJ = LocalDate.parse(datafpjstring, formatador);
                                            System.out.print("Insira a placa do veículo do Cliente: ");
                                            String placavpj = entrada.nextLine();
                                            System.out.print("Insira a marca do veículo do Cliente: ");
                                            String marcavpj = entrada.nextLine();
                                            System.out.print("Insira o modelo do veículo do Cliente: ");
                                            String modelovpj = entrada.nextLine();
                                            System.out.print("Insira o ano de fabricação do veículo do Cliente: ");
                                            int anofabvpj = Integer.parseInt(entrada.nextLine());
                                            ClientePJ clientePJ = new ClientePJ(nomepj, enderecopj, new Veiculo(placavpj, marcavpj, modelovpj, anofabvpj), cnpj, dataFundacaoPJ);
                                            if(!clientePJ.validarCNPJ())
                                            {
                                                System.out.print("CNPJ do Cliente inválido.\n");
                                                break;
                                            }
                                            listaSeguradoras.get(selecao.get(1)-1).cadastrarCliente(clientePJ);
                                            System.out.print("Cliente Pessoa Jurídica cadastrado com sucesso.\n");
                                            break;
                                        case 3://Volta ao menu da seguradora
                                            System.out.print("\n");
                                            break;
                                        default:
                                            System.out.println("Selecione uma opção válida.\n");
                                    }
                                    break;
                                case 2:
                                    //TODO: ToString Cliente
                                    break;
                                case 3:
                                    //TODO: Adicionar Veiculo ao Cliente
                                    break;
                                case 4:
                                    //TODO: Criar Sinistro
                                    break;
                                case 5:
                                    //TODO: ToString Sinistro
                                    break;
                                case 6: //Voltar ao menu
                                    System.out.print("\n");
                                    break;
                                default:
                                    System.out.println("Selecione uma opção válida.\n");
                            }
                        }
                    }
                    else if(selecao.get(1)-1 == listaSeguradoras.size()) //Voltar ao menu
                    {
                        System.out.print("\n");
                        break;
                    }
                    else
                    {
                        System.out.print("Selecione uma opção válida.\n");
                    }
                    break;
                case 3:
                    //TODO: Demo
                    break;
                case 4:
                    break; //Case 4 implica em selecao.get(0) = 4, o que sai do main loop.
                default:
                    System.out.println("Selecione uma opção válida.\n");
            }
        }
        entrada.close();
    }
}

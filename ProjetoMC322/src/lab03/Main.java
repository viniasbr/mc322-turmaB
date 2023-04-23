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
        String entradaTemp = "";
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
            entradaTemp = entrada.nextLine();
            Boolean erroOcorreu = false;
            try {
                Integer.parseInt(entradaTemp);
            } catch (Exception e) {
                erroOcorreu = true;
            }
            if(erroOcorreu)
            {
                selecao.add(0,0);
                erroOcorreu = false;
            }
            else
            {
                selecao.add(0,Integer.parseInt(entradaTemp));
            }
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
                    entradaTemp = entrada.nextLine();
                    try {
                        Integer.parseInt(entradaTemp);
                    } catch (Exception e) {
                        erroOcorreu = true;
                    }
                    if(erroOcorreu)
                    {
                        selecao.add(1, 0);
                        erroOcorreu = false;
                    }
                    else
                    {
                        selecao.add(1,Integer.parseInt(entradaTemp));
                    }
                    if(selecao.get(1)-1 < listaSeguradoras.size() && selecao.get(1)-1 >= 0)
                    {
                        selecao.add(2,0);
                        while(selecao.get(2) != 6)
                        {
                            System.out.print( //Camada 2 do menu
                                "\nSistema da Seguradora " + listaSeguradoras.get(selecao.get(1)-1).getNome() + ". Digite o número correspondente para:"
                                +"\n    1 - Registrar Novo Cliente"
                                +"\n    2 - Resgatar Informações do Cliente"
                                +"\n    3 - Registrar Novo Veículo do Cliente"
                                +"\n    4 - Gerar Novo Sinistro"
                                +"\n    5 - Resgatar Sinistros"
                                +"\n    6 - Retornar ao Menu Principal"
                                +"\nOpção: "
                                );
                            entradaTemp = entrada.nextLine();
                            try {
                                Integer.parseInt(entradaTemp);
                            } catch (Exception e) {
                                erroOcorreu = true;
                            }
                            if(erroOcorreu)
                            {
                                selecao.add(2, 0);
                                erroOcorreu = false;
                            }
                            else
                            {
                                selecao.add(2, Integer.parseInt(entradaTemp));
                            }
                            switch(selecao.get(2))
                            {
                                case 1://Camada 3 do menu
                                    selecao.add(3,0);
                                    System.out.print(
                                        "\nSelecione o tipo de cliente:"
                                        +"\n    1 - Pessoa Física"
                                        +"\n    2 - Pessoa Jurídica"
                                        +"\n    3 - Retornar ao Menu da Seguradora"
                                        +"\nOpção: "
                                    );
                                    entradaTemp = entrada.nextLine();
                                    try {
                                        Integer.parseInt(entradaTemp);
                                    } catch (Exception e) {
                                        erroOcorreu = true;
                                    }
                                    if(erroOcorreu)
                                    {
                                        selecao.add(3, 0);
                                    }
                                    else
                                    {
                                        selecao.add(3, Integer.parseInt(entradaTemp));
                                    }
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
                                                System.out.print("Erro: Data(s) inválida(s)\n");
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
                                            entradaTemp = entrada.nextLine();
                                            try {
                                                Integer.parseInt(entradaTemp);
                                            } catch (Exception e) {
                                                System.out.print("Ano de fabricação inválido.\n\n");
                                                break;
                                            }
                                            int anofabvpf = Integer.parseInt(entradaTemp);
                                            ClientePF clientePF = new ClientePF(nomepf, enderecopf, new Veiculo(placavpf, marcavpf, modelovpf, anofabvpf), cpf, genero, dataLicencaPF, educacaopf, dataNascimentoPF, classeecono);
                                            if(!clientePF.validarCPF())
                                            {
                                                System.out.print("CPF do Cliente inválido.\n");
                                                break;
                                            }
                                            listaSeguradoras.get(selecao.get(1)-1).cadastrarCliente(clientePF);
                                            System.out.print("Cliente Pessoa Física cadastrado com sucesso.\n\n");
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
                                                System.out.print("Erro: Data(s) inválida(s)\n");
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
                                            entradaTemp = entrada.nextLine();
                                            try {
                                                Integer.parseInt(entradaTemp);
                                            } catch (Exception e) {
                                                System.out.print("Ano de fabricação inválido.\n\n");
                                                break;
                                            }
                                            int anofabvpj = Integer.parseInt(entradaTemp);
                                            ClientePJ clientePJ = new ClientePJ(nomepj, enderecopj, new Veiculo(placavpj, marcavpj, modelovpj, anofabvpj), cnpj, dataFundacaoPJ);
                                            if(!clientePJ.validarCNPJ())
                                            {
                                                System.out.print("CNPJ do Cliente inválido\n\n");
                                                break;
                                            }
                                            listaSeguradoras.get(selecao.get(1)-1).cadastrarCliente(clientePJ);
                                            System.out.print("Cliente Pessoa Jurídica cadastrado com sucesso.\n\n");
                                            break;
                                        case 3://Volta ao menu da seguradora
                                            System.out.print("\n");
                                            break;
                                        default:
                                            System.out.print("Selecione uma opção válida.\n");
                                    }
                                    break;
                                case 2: //Camada 4 do menu.
                                    selecao.add(4, 0);
                                    if(listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size() <= 0)
                                    {
                                        System.out.print("Nenhum cliente cadastrado na seguradora " + listaSeguradoras.get(selecao.get(1)-1).getNome() + ".\n\n");
                                        break;
                                    }
                                    saida = "";
                                    saida = saida + "\nSelecione o cliente:";
                                    for(int i = 0; i < listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size(); i++)
                                    {
                                        saida = saida +"\n    " + (i+1) + " - " + listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(i).getNome();
                                        if(listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(i).tipoDeCliente() == "PF")
                                        {
                                            saida = saida + " (Pessoa Física)";
                                        }
                                        else if(listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(i).tipoDeCliente() == "PJ")
                                        {
                                            saida = saida + " (Pessoa Jurídica)";
                                        }
                                    }
                                    saida = saida + "\n    " + (listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size()+1) + " - Retornar ao Menu da Seguradora";
                                    saida = saida + "\nOpção: ";
                                    System.out.print(saida);
                                    entradaTemp = entrada.nextLine();
                                    try {
                                        Integer.parseInt(entradaTemp);
                                    } catch (Exception e) {
                                        erroOcorreu = true;
                                    }
                                    if(erroOcorreu)
                                    {
                                        selecao.add(4, 0);
                                        erroOcorreu = false;
                                    }
                                    else
                                    {
                                        selecao.add(4, Integer.parseInt(entradaTemp));
                                    }
                                    if(selecao.get(4)-1 < listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size() && selecao.get(4) - 1 >= 0)
                                    {
                                        System.out.print("\n"+listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).toString());
                                    }
                                    else if(selecao.get(4)-1 == listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size())
                                    {
                                        System.out.print("\n");
                                        break;
                                    }
                                    else
                                    {
                                        System.out.print("Selecione uma opção válida.\n");
                                        break;
                                    }
                                    break;
                                case 3: //Camada 4 do menu. selecao.get(4)-1 é o índice do cliente na lista da seguradora.
                                    selecao.add(4, 0);
                                    if(listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size() <= 0)
                                    {
                                        System.out.print("Nenhum cliente cadastrado na seguradora " + listaSeguradoras.get(selecao.get(1)-1).getNome() + ".\n\n");
                                        break;
                                    }
                                    saida = "";
                                    saida = saida + "\nSelecione o cliente:";
                                    for(int i = 0; i < listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size(); i++)
                                    {
                                        saida = saida +"\n    " + (i+1) + " - " + listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(i).getNome();
                                        if(listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(i).tipoDeCliente() == "PF")
                                        {
                                            saida = saida + " (Pessoa Física)";
                                        }
                                        else if(listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(i).tipoDeCliente() == "PJ")
                                        {
                                            saida = saida + " (Pessoa Jurídica)";
                                        }
                                    }
                                    saida = saida + "\n    " + (listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size()+1) + " - Retornar ao Menu da Seguradora";
                                    saida = saida + "\nOpção: ";
                                    System.out.print(saida);
                                    entradaTemp = entrada.nextLine();
                                    try {
                                        Integer.parseInt(entradaTemp);
                                    } catch (Exception e) {
                                        erroOcorreu = true;
                                    }
                                    if(erroOcorreu)
                                    {
                                        selecao.add(4, 0);
                                        erroOcorreu = false;
                                    }
                                    else
                                    {
                                        selecao.add(4, Integer.parseInt(entradaTemp));
                                    }
                                    if(selecao.get(4)-1 < listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size() && selecao.get(4) - 1 >= 0)
                                    {
                                        System.out.print("Insira a placa do veículo do Cliente: ");
                                        String placav = entrada.nextLine();
                                        System.out.print("Insira a marca do veículo do Cliente: ");
                                        String marcav = entrada.nextLine();
                                        System.out.print("Insira o modelo do veículo do Cliente: ");
                                        String modelov = entrada.nextLine();
                                        System.out.print("Insira o ano de fabricação do veículo do Cliente: ");
                                        entradaTemp = entrada.nextLine();
                                        try {
                                            Integer.parseInt(entradaTemp);
                                        } catch (Exception e) {
                                            System.out.print("Ano de fabricação inválido.\n\n");
                                            break;
                                        }
                                        int anofabv = Integer.parseInt(entradaTemp);
                                        listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).addVeiculo(new Veiculo(placav, marcav, modelov, anofabv));
                                        System.out.print("Veículo adicionado com sucesso.\n\n");
                                    }
                                    else if(selecao.get(4)-1 == listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size())
                                    {
                                        System.out.print("\n");
                                        break;
                                    }
                                    else
                                    {
                                        System.out.print("Selecione uma opção válida.\n");
                                        break;
                                    }
                                    break;
                                case 4:
                                    selecao.add(4, 0);
                                    if(listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size() <= 0)
                                    {
                                        System.out.print("Nenhum cliente cadastrado na seguradora " + listaSeguradoras.get(selecao.get(1)-1).getNome() + ".\n\n");
                                        break;
                                    }
                                    saida = "";
                                    saida = saida + "\nSelecione o cliente:";
                                    for(int i = 0; i < listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size(); i++)
                                    {
                                        saida = saida +"\n    " + (i+1) + " - " + listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(i).getNome();
                                        if(listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(i).tipoDeCliente() == "PF")
                                        {
                                            saida = saida + " (Pessoa Física)";
                                        }
                                        else if(listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(i).tipoDeCliente() == "PJ")
                                        {
                                            saida = saida + " (Pessoa Jurídica)";
                                        }
                                    }
                                    saida = saida + "\n    " + (listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size()+1) + " - Retornar ao Menu da Seguradora";
                                    saida = saida + "\nOpção: ";
                                    System.out.print(saida);
                                    entradaTemp = entrada.nextLine();
                                    try {
                                        Integer.parseInt(entradaTemp);
                                    } catch (Exception e) {
                                        erroOcorreu = true;
                                    }
                                    if(erroOcorreu)
                                    {
                                        selecao.add(4, 0);
                                        erroOcorreu = false;
                                    }
                                    else
                                    {
                                        selecao.add(4, Integer.parseInt(entradaTemp));
                                    }
                                    if(selecao.get(4)-1 < listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size() && selecao.get(4) - 1 >= 0)//Camada 5 do menu. selecao.get(5)-1 retorna o índice do veículo do cliente
                                    {
                                        selecao.add(5, 0);
                                        //listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos();
                                        saida = "";
                                        saida = saida + "Selecione o veículo:";
                                        for(int i = 0; i < listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos().size(); i++)
                                        {
                                            saida = saida +"\n    " + (i+1) + " - " + listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos().get(i).getMarca() + " "+ listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos().get(i).getModelo() + " " + + listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos().get(i).getAnoFabricacao() + ", Placa: "+ listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos().get(i).getPlaca();
                                        }
                                        saida = saida + "\n    " + (listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos().size()+1) + " - Retornar ao Menu da Seguradora";
                                        saida = saida + "\nOpção: ";
                                        System.out.print(saida);
                                        entradaTemp = entrada.nextLine();
                                        try {
                                            Integer.parseInt(entradaTemp);
                                        } catch (Exception e) {
                                            erroOcorreu = true;
                                        }
                                        if(erroOcorreu)
                                        {
                                            selecao.add(5, 0);
                                            erroOcorreu = false;
                                        }
                                        else
                                        {
                                            selecao.add(5, Integer.parseInt(entradaTemp));
                                        }
                                        if(selecao.get(5)-1 < listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos().size() && selecao.get(5) - 1 >= 0)
                                        {
                                            System.out.print("Insira a data do acidente (em formato dd/mm/aaaa):");
                                            String datasin = entrada.nextLine();
                                            System.out.print("Insira o endereço do local do acidente: ");
                                            String enderecosin = entrada.nextLine();
                                            listaSeguradoras.get(selecao.get(1)-1).gerarSinistro(new Sinistro(datasin, enderecosin, listaSeguradoras.get(selecao.get(1)-1), listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos().get(selecao.get(5)-1), listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1)));
                                            System.out.print("Sinistro gerado com sucesso.\n\n");
                                        }
                                        else if(selecao.get(5)-1 == listaSeguradoras.get(selecao.get(1)-1).getListaClientes().get(selecao.get(4)-1).getListaVeiculos().size())
                                        {
                                            System.out.print("\n\n");
                                            break;
                                        }
                                        else
                                        {
                                        System.out.print("Selecione uma opção válida.\n\n");
                                        break;
                                        }
                                    }
                                    else if(selecao.get(4)-1 == listaSeguradoras.get(selecao.get(1)-1).getListaClientes().size())
                                    {
                                        System.out.print("\n\n");
                                        break;
                                    }
                                    else
                                    {
                                        System.out.print("Selecione uma opção válida.\n\n");
                                        break;
                                    }
                                    break;
                                case 5:
                                    if(listaSeguradoras.get(selecao.get(1)-1).getListaSinistros().size() <= 0)
                                    {
                                        System.out.print("Nenhum sinistro foi gerado.\n\n");
                                    }
                                    else
                                    {
                                        System.out.print(listaSeguradoras.get(selecao.get(1)-1).listarSinistros());
                                    }
                                    break;
                                case 6: //Voltar ao menu
                                    System.out.print("\n");
                                    break;
                                default:
                                    System.out.print("Selecione uma opção válida.\n\n");
                            }
                        }
                    }
                    else if(selecao.get(1)-1 == listaSeguradoras.size()) //Voltar ao menu
                    {
                        break;
                    }
                    else
                    {
                        System.out.print("Selecione uma opção válida.\n\n");
                    }
                    break;
                case 3:
                    Seguradora seguradoraDemo = new Seguradora("Demo LTDA", "(00) 1234-5678", "demo@demo.com", "Rua Exemplo, 123");
                    Cliente aSerRemovido = new ClientePJ("Empresa que será removida", "Rua Teste, 456", new Veiculo("ABC1234", "MarcaExemplo", "ModeloExemplo", 2010) , "58.619.673/0001-04", LocalDate.parse("10/10/2010", formatador));
                    seguradoraDemo.cadastrarCliente(aSerRemovido);
                    System.out.print("\nCliente de teste adicionado:\n\n"+seguradoraDemo.listarClientes("PJ"));
                    seguradoraDemo.removerCliente(aSerRemovido);
                    System.out.print("Se a saída for vazio, o cliente foi removido:\n\n"+seguradoraDemo.listarClientes("PJ"));
                    Cliente exemploPF = new ClientePF("Ana Borges Carvalho", "Rua da Casa de Exemplo", new Veiculo("ABC1234", "MarcaExemplo", "ModeloExemplo", 2010), "999.166.140-91", "Feminino", LocalDate.parse("11/11/2011", formatador), "Ensino Médio Completo", LocalDate.parse("01/01/2001", formatador), "Classe Média");
                    ClientePJ exemploPJ = new ClientePJ("Empresa ABC", "Rua Teste, 789", new Veiculo("ABC1234", "MarcaExemplo", "ModeloExemplo", 2010) , "77.685.935/0001-83", LocalDate.parse("09/09/2009", formatador));
                    seguradoraDemo.cadastrarCliente(exemploPF);
                    seguradoraDemo.cadastrarCliente(exemploPJ);
                    System.out.print("\nCliente Pessoa Física de Teste:\n\n"+seguradoraDemo.listarClientes("PF"));
                    System.out.print("\nCliente Pessoa Jurídica de Teste:\n\n"+seguradoraDemo.listarClientes("PJ"));
                    Veiculo carroDoAcidente = new Veiculo("OPS1234", "WorstCarsEver", "Bumper", 2023);
                    seguradoraDemo.getListaClientes().get(1).addVeiculo(carroDoAcidente);
                    System.out.print("\nAgora, a Empresa ABC cadastrou um carro que irá bater. " + carroDoAcidente.toString());
                    System.out.print("\nO cadastro da Empresa ABC agora consta:\n\n "+ seguradoraDemo.getListaClientes().get(1).toString());
                    seguradoraDemo.gerarSinistro(new Sinistro("23/04/2023", "Rua do Azar, 1234", seguradoraDemo, seguradoraDemo.getListaClientes().get(1).getListaVeiculos().get(1), seguradoraDemo.getListaClientes().get(1)));
                    System.out.print("\nO carro bateu. O sinistro foi gerado? "+seguradoraDemo.visualizarSinistro("Empresa ABC"));
                    System.out.print("\n\nO sinistro gerado consta: "+seguradoraDemo.listarSinistros());
                    System.out.print("Por fim, será impresso um toString de cada classe.\n\n");
                    System.out.println(new Cliente("Nem PF nem PJ", "Rua que não existe", carroDoAcidente).toString());
                    System.out.println(seguradoraDemo.getListaClientes().get(0).toString());
                    System.out.println(seguradoraDemo.getListaClientes().get(1).toString());
                    System.out.println(seguradoraDemo.toString()); //TODO: toString da Seguradora
                    System.out.println(seguradoraDemo.getListaSinistros().get(0).toString());
                    System.out.println(seguradoraDemo.getListaClientes().get(1).getListaVeiculos().get(0).toString());
                    break;
                case 4:
                    break; //Case 4 implica em selecao.get(0) = 4, o que sai do main loop.
                default:
                    System.out.print("Selecione uma opção válida.\n\n");
            }
        }
        entrada.close();
    }
}

package lab04;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public enum MenuOperacoes {
    SAIR(0,0), CADASTRAR(1,0), LISTAR(2,0), EXCLUIR(3,0), GERAR_SINISTRO(4,0), TRANSFERIR_SEGURO(5,0), CALCULAR_RECEITA(6,0),
    CADASTRAR_CLIENTE(1,1), CADASTRAR_VEICULO(2,0) ,CADASTRAR_SEGURADORA(1,3), CADASTRAR_VOLTAR(1,4),
    LISTAR_CLIENTES(2, 1), LISTAR_SINISTROS_SEG(2, 2), LISTAR_SINISTROS_CLI(2, 3), LISTAR_VEICULOS_CLI(2, 4), LISTAR_VEICULOS_SEG(2, 5), LISTAR_VOLTAR(2, 6),
    EXCLUIR_CLIENTE(3,1), EXCLUIR_VEICULO(3,2), EXCLUIR_SINISTRO(3,3), EXCLUIR_VOLTAR(3,4);


    private final int c0;
    private final int c1;
    
    
    MenuOperacoes(int c0, int c1) {
        this.c0 = c0;
        this.c1 = c1;
    }
    public int getC0() {
        return c0;
    }
    public int getC1() {
        return c1;
    }

    public static MenuOperacoes getOperacao(int c0, int c1)
    {
        switch (c0) {
            case 0:
                return SAIR;
            case 1:
                switch (c1) {
                    case 0:
                        return CADASTRAR;
                    case 1:
                        return CADASTRAR_CLIENTE;
                    case 2:
                        return CADASTRAR_VEICULO;
                    case 3:
                        return CADASTRAR_SEGURADORA;
                    case 4:
                        return CADASTRAR_VOLTAR;
                    default:
                        return (MenuOperacoes)null;
                }
            case 2:
                switch (c1) {
                    case 0:
                        return LISTAR;
                    case 1:
                        return LISTAR_CLIENTES;
                    case 2:
                        return LISTAR_SINISTROS_SEG;
                    case 3:
                        return LISTAR_SINISTROS_CLI;
                    case 4:
                        return LISTAR_VEICULOS_CLI;
                    case 5:
                        return LISTAR_VEICULOS_SEG;
                    case 6:
                        return LISTAR_VOLTAR;
                    default:
                        return (MenuOperacoes)null;
                }
            case 3:
                switch (c1) {
                    case 0:
                        return EXCLUIR;
                    case 1:
                        return EXCLUIR_CLIENTE;
                    case 2:
                        return EXCLUIR_VEICULO;
                    case 3:
                        return EXCLUIR_SINISTRO;
                    case 4:
                        return CADASTRAR_VOLTAR;
                    default:
                        return (MenuOperacoes)null;
                }
            case 4:
                return GERAR_SINISTRO;
            case 5:
                return TRANSFERIR_SEGURO;
            case 6:
                return CALCULAR_RECEITA;
            default:
                return (MenuOperacoes)null;
        }
    }

    public static String iterarSeguradoras(ArrayList<Seguradora> seguradoras) //Falta o titulo e a possibilidade de selecionar opção
    {
        String saida = "";
        for(int i = 0; i < seguradoras.size(); i++)
        {
            saida += "\n    " + i + " - " + seguradoras.get(i).getNome();
        }
        //saida += "\n    " + seguradoras.size() + " - Voltar";
        return saida+"\n";
    }

    public static String iterarVeiculos(ArrayList<Veiculo> veiculos) //Falta o titulo e a possibilidade de selecionar opção
    {
        String saida = "";
        for(int i = 0; i < veiculos.size(); i++)
        {
            saida += "\n    " + i + " - " + veiculos.get(i).getMarca() + " " + veiculos.get(i).getModelo() + " " + veiculos.get(i).getAnoFabricacao() + ", Placa: " + veiculos.get(i).getPlaca();
        }
        //saida += "\n    " + veiculos.size() + " - Voltar";
        return saida+"\n";
    }

    public static String iterarClientes(ArrayList<Cliente> clientes) //Falta o titulo e a possibilidade de selecionar opção
    {
        String saida = "Pessoa Físca:\n";
        for(int i = 0; i < clientes.size(); i++)
        {
            if(clientes.get(i).tipoDeCliente().equals("PF"))
            {
                ClientePF cPF = (ClientePF) clientes.get(i);
                saida += "\n    " + i + " - " + cPF.getNome() + ", CPF: " + cPF.getCpf();
            }
        }
        saida += "\n\nPessoa Jurídica:\n";
        for(int i = 0; i < clientes.size(); i++)
        {
            if(clientes.get(i).tipoDeCliente().equals("PJ"))
            {
                ClientePJ cPJ = (ClientePJ) clientes.get(i);
                saida += "\n    " + i + " - " + cPJ.getNome() + ", CPF: " + cPJ.getCnpj();
            }
        }
        //saida += "\n    " + clientes.size() + " - Voltar";
        return saida + "\n";
    }

    public static void menuTextual(Scanner entrada)
    {
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        MenuOperacoes op = null;
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entradaTemp = "";
        int intTemp = 0;
        String menuPrincipal = "Menu Principal:\n"
        +"\n    1 - Cadastrar"
        +"\n    2 - Listar"
        +"\n    3 - Excluir"
        +"\n    4 - Gerar Sinistro"
        +"\n    5 - Transferir Seguro"
        +"\n    6 - Calcular Receita da Seguradora"
        +"\n    0 - Sair"
        +"\n    Digite a opção desejada: ";
        String menuCadastrar = "\nMenu para Cadastrar:\n"
        +"\n    1 - Cadastrar Cliente PF/PJ"
        +"\n    2 - Cadastrar Veículo"
        +"\n    3 - Cadastrar Seguradora"
        +"\n    4 - Voltar"
        +"\n    Digite a opção desejada: ";
        String menuListar = "\nMenu para Listar:\n"
        +"\n    1 - Listar Cliente (PF/PJ) por Seguradora"
        +"\n    2 - Listar Sinistro(s) por Seguradora"
        +"\n    3 - Listar Sinistro(s) por Cliente"
        +"\n    4 - Listar Veiculo(s) por Cliente"
        +"\n    5 - Listar Veiculo(s) por Seguradora"
        +"\n    6 - Voltar"
        +"\n    Digite a opção desejada: ";
        String menuExcluir = "\nMenu para Excluir:\n"
        +"\n    1 - Excluir Cliente (e Sinistro(s))"
        +"\n    2 - Excluir Veículo"
        +"\n    3 - Excluir Sinistro"
        +"\n    4 - Voltar"
        +"\n    Digite a opção desejada: ";
        while(op != SAIR)
        {
            System.out.print(menuPrincipal);
            entradaTemp = entrada.nextLine();
            if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, 7)))
            {
                System.out.println("\nInsira uma opção válida.\n");
                continue;
            }
            intTemp = Integer.parseInt(entradaTemp);
            op = MenuOperacoes.getOperacao(intTemp, 0);
            switch (op) {
                case CADASTRAR:
                    while(op != CADASTRAR_VOLTAR)
                    {
                        System.out.print(menuCadastrar);
                        entradaTemp = entrada.nextLine();
                        if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(1, 5)))
                        {
                            System.out.println("\nInsira uma opção válida.\n");
                            continue;
                        }
                        intTemp = Integer.parseInt(entradaTemp);
                        op = MenuOperacoes.getOperacao(1, intTemp);
                        switch (op) {
                            case CADASTRAR_CLIENTE:
                                System.out.print("\nSeguradora para o Cadastro do Cliente:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.size())
                                {
                                    break;
                                }
                                System.out.print("Insira as informações do cliente: \n\n    - Tipo (PF/PJ): ");
                                entradaTemp = entrada.nextLine();
                                if(!entradaTemp.equals("PF") && !entradaTemp.equals("PJ"))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                else if(entradaTemp.equals("PF"))
                                {
                                    System.out.print("    - Nome do Cliente: ");
                                    String nomeClientePF = entrada.nextLine();
                                    if(!Validacao.validaNome(nomeClientePF))
                                    {
                                        System.out.println("\nNome inválido.\n");
                                        break;
                                    }
                                    System.out.print("    - Endereço do Cliente: ");
                                    String endClientePF = entrada.nextLine();
                                    System.out.print("    - CPF do Cliente: ");
                                    String cpfClientePF = entrada.nextLine();
                                    if(!Validacao.validaCPF(cpfClientePF))
                                    {
                                        System.out.println("\nCPF inválido.\n");
                                        break;
                                    }
                                    System.out.print("    - Gênero do Cliente: ");
                                    String generoClientePF = entrada.nextLine();
                                    System.out.print("    - Data da Licença do Cliente (dd/mm/aaaa): ");
                                    String dataLicencaClientePF = entrada.nextLine();
                                    if(!Validacao.validaData(dataLicencaClientePF))
                                    {
                                        System.out.println("\nData inválida.\n");
                                        break;
                                    }
                                    System.out.print("    - Educação do Cliente: ");
                                    String educacaoClientePF = entrada.nextLine();
                                    System.out.print("    - Data de Nascimento do Cliente (dd/mm/aaaa): ");
                                    String dataNascimentoClientePF = entrada.nextLine();
                                    if(!Validacao.validaData(dataNascimentoClientePF))
                                    {
                                        System.out.println("\nData inválida.\n");
                                        break;
                                    }
                                    System.out.print("    - Classe Econômica do Cliente: ");
                                    String classeEconoClientePF = entrada.nextLine();
                                    System.out.print("\nAs informações do cliente foram preenchidas.\n\nInsira as informações do veículo do cliente:\n\n    - Placa do Veículo: ");
                                    String placaVeiculoPF = entrada.nextLine();
                                    System.out.print("    - Marca do Veículo: ");
                                    String marcaVeiculoPF = entrada.nextLine();
                                    System.out.print("    - Modelo do Veículo: ");
                                    String modeloVeiculoPF = entrada.nextLine();
                                    System.out.print("    - Ano de Fabricação do Veículo: ");
                                    String anoFabVeiculoPF = entrada.nextLine();
                                    if(!Validacao.validaInt(anoFabVeiculoPF))
                                    {
                                        System.out.println("\nAno inválido.\n");
                                        break;
                                    }
                                    listaSeguradoras.get(intTemp).cadastrarCliente(new ClientePF(nomeClientePF, endClientePF, new Veiculo(placaVeiculoPF, marcaVeiculoPF, modeloVeiculoPF, Integer.parseInt(anoFabVeiculoPF)), cpfClientePF, generoClientePF, LocalDate.parse(dataLicencaClientePF, formatador), educacaoClientePF, LocalDate.parse(dataNascimentoClientePF, formatador), classeEconoClientePF));
                                    System.out.println("\nCliente " + nomeClientePF + " cadastradx na seguradora "+ listaSeguradoras.get(intTemp).getNome() +" com sucesso.\n");
                                }
                                else if(entradaTemp.equals("PJ"))
                                {
                                    System.out.print("    - Nome do Cliente: ");
                                    String nomeClientePJ = entrada.nextLine();
                                    if(!Validacao.validaNome(nomeClientePJ))
                                    {
                                        System.out.println("\nNome inválido.\n");
                                        break;
                                    }
                                    System.out.print("    - Endereço do Cliente: ");
                                    String endClientePJ = entrada.nextLine();
                                    System.out.print("    - CNPJ do Cliente: ");
                                    String cnpjClientePJ = entrada.nextLine();
                                    if(!Validacao.validaCNPJ(cnpjClientePJ))
                                    {
                                        System.out.println("\nCNPJ inválido.\n");
                                        break;
                                    }
                                    System.out.print("    - Data da Fundação do Cliente (dd/mm/aaaa): ");
                                    String dataFundClientePJ = entrada.nextLine();
                                    if(!Validacao.validaData(dataFundClientePJ))
                                    {
                                        System.out.println("\nData inválida.\n");
                                        break;
                                    }
                                    System.out.print("    - Quantidade de Funcionários do Cliente: ");
                                    String qtdFuncPJ = entrada.nextLine();
                                    if(!Validacao.validaInt(qtdFuncPJ))
                                    {
                                        System.out.println("\nQuantidade inválida.\n");
                                        break;
                                    }
                                    System.out.print("\nAs informações do cliente foram preenchidas.\n\nInsira as informações do veículo do cliente:\n\n    - Placa do Veículo: ");
                                    String placaVeiculoPJ = entrada.nextLine();
                                    System.out.print("    - Marca do Veículo: ");
                                    String marcaVeiculoPJ = entrada.nextLine();
                                    System.out.print("    - Modelo do Veículo: ");
                                    String modeloVeiculoPJ = entrada.nextLine();
                                    System.out.print("    - Ano de Fabricação do Veículo: ");
                                    String anoFabVeiculoPJ = entrada.nextLine();
                                    if(!Validacao.validaInt(anoFabVeiculoPJ))
                                    {
                                        System.out.println("\nAno inválido.\n");
                                        break;
                                    }
                                    listaSeguradoras.get(intTemp).cadastrarCliente(new ClientePJ(nomeClientePJ, endClientePJ, new Veiculo(placaVeiculoPJ, marcaVeiculoPJ, modeloVeiculoPJ, Integer.parseInt(anoFabVeiculoPJ)), cnpjClientePJ, LocalDate.parse(dataFundClientePJ, formatador), Integer.parseInt(qtdFuncPJ)));
                                    System.out.println("\nCliente " + nomeClientePJ + " cadastrado na seguradora "+ listaSeguradoras.get(intTemp).getNome() +" com sucesso.\n");
                                }
                                break;
                            case CADASTRAR_VEICULO:
                            System.out.print("\nSeguradora para o Cadastro do Veículo:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                            entradaTemp = entrada.nextLine();
                            if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                            {
                                System.out.println("\nInsira uma opção válida.\n");
                                break;
                            }
                            intTemp = Integer.parseInt(entradaTemp);
                            if(intTemp == listaSeguradoras.size())
                            {
                                break;
                            }
                            int indiceSeg = intTemp;
                            System.out.print("\nCliente para o Cadastro do Veículo:\n" + MenuOperacoes.iterarClientes(listaSeguradoras.get(indiceSeg).getListaClientes()) +"    "+ listaSeguradoras.get(indiceSeg).getListaClientes().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                            entradaTemp = entrada.nextLine();
                            if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg).getListaClientes().size()+1)))
                            {
                                System.out.println("\nInsira uma opção válida.\n");
                                break;
                            }
                            intTemp = Integer.parseInt(entradaTemp);
                            if(intTemp == listaSeguradoras.get(indiceSeg).getListaClientes().size())
                            {
                                break;
                            }
                            int indiceCli = intTemp;
                            System.out.print("\nCliente selecionado.\n\nInsira as informações do veículo do cliente:\n\n    - Placa do Veículo: ");
                                    String placaVeiculo = entrada.nextLine();
                                    System.out.print("    - Marca do Veículo: ");
                                    String marcaVeiculo = entrada.nextLine();
                                    System.out.print("    - Modelo do Veículo: ");
                                    String modeloVeiculo = entrada.nextLine();
                                    System.out.print("    - Ano de Fabricação do Veículo: ");
                                    String anoFabVeiculo = entrada.nextLine();
                                    if(!Validacao.validaInt(anoFabVeiculo))
                                    {
                                        System.out.println("\nAno inválido.\n");
                                        break;
                                    }
                            listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli).addVeiculo(new Veiculo(placaVeiculo, marcaVeiculo, modeloVeiculo, Integer.parseInt(anoFabVeiculo)));
                            listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli).setValorSeguro(listaSeguradoras.get(indiceSeg).calcularPrecoSeguroCliente( listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli)));//atualiza o valor do seguro do cliente
                            System.out.print("\nVeículo cadastrado com sucesso.\n");
                                break;
                            case CADASTRAR_SEGURADORA:
                                System.out.print("\nInsira as informações da seguradora a ser cadastrada:"
                                +"\n"
                                +"\n    - Nome da Seguradora: ");
                                String nomeSeguradora = entrada.nextLine();
                                System.out.print("    - Telefone da Seguradora: ");
                                String telSeguradora = entrada.nextLine();
                                System.out.print("    - Email da Seguradora: ");
                                String emailSeguradora = entrada.nextLine();
                                System.out.print("    - Endereço da Seguradora: ");
                                String endSeguradora = entrada.nextLine();
                                listaSeguradoras.add(new Seguradora(nomeSeguradora, telSeguradora, emailSeguradora, endSeguradora));
                                System.out.print("\nSeguradora "+ nomeSeguradora +" cadastrada com sucesso.\n");
                                break;
                            case CADASTRAR_VOLTAR:
                                System.out.println();
                                break; //op = CADASTRAR_VOLTAR volta ao loop principal
                            default:
                                op = CADASTRAR_VOLTAR;
                                System.out.println("\nERRO!\n");
                                break;
                        }
                    }
                    break;
                case LISTAR:
                    while(op != LISTAR_VOLTAR)
                    {
                        System.out.print(menuListar);
                        entradaTemp = entrada.nextLine();
                        if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(1, 7)))
                        {
                            System.out.println("\nInsira uma opção válida.\n");
                            continue;
                        }
                        intTemp = Integer.parseInt(entradaTemp);
                        op = MenuOperacoes.getOperacao(2, intTemp);
                        switch (op) {
                            case LISTAR_CLIENTES:
                                System.out.print("\nSeguradora para Listar Clientes:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.size())
                                {
                                    break;
                                }
                                int indiceSeg1 = intTemp;
                                System.out.print("\nCliente para Mostrar Relatório:\n" + MenuOperacoes.iterarClientes(listaSeguradoras.get(indiceSeg1).getListaClientes()) + "    "+listaSeguradoras.get(indiceSeg1).getListaClientes().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg1).getListaClientes().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg1).getListaClientes().size())
                                {
                                    break;
                                }
                                int indiceCli = intTemp;
                                System.out.print("\n"+listaSeguradoras.get(indiceSeg1).getListaClientes().get(indiceCli).toString());
                                break;
                            case LISTAR_SINISTROS_SEG:
                                System.out.print("\nSeguradora para Listar Sinistros:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.size())
                                {
                                    break;
                                }
                                int indiceSeg2 = intTemp;
                                String menuListarSinistrosSeg = "\nSinistro para Mostrar Relatório\n";
                                for(int i = 0; i < listaSeguradoras.get(indiceSeg2).getListaSinistros().size(); i++)
                                {
                                    menuListarSinistrosSeg += "\n    " + i + " - " + listaSeguradoras.get(indiceSeg2).getListaSinistros().get(i).getData() + ": " + listaSeguradoras.get(indiceSeg2).getListaSinistros().get(i).getCliente().getNome() + ", id: " + listaSeguradoras.get(indiceSeg2).getListaSinistros().get(i).getId();
                                }
                                menuListarSinistrosSeg += "\n    " + listaSeguradoras.get(indiceSeg2).getListaSinistros().size() + " - Voltar\n    Selecione a opção desejada: ";
                                System.out.print(menuListarSinistrosSeg);
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg2).getListaSinistros().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg2).getListaSinistros().size())
                                {
                                    break;
                                }
                                int indiceSin1 = intTemp;
                                System.out.print("\n"+listaSeguradoras.get(indiceSeg2).getListaSinistros().get(indiceSin1).toString());
                                break;
                            case LISTAR_SINISTROS_CLI:
                                System.out.print("\nSeguradora para Listar Sinistros por Cliente:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.size())
                                {
                                    break;
                                }
                                int indiceSeg3 = intTemp;
                                System.out.print("\nCliente para Listar Sinistros:\n" + MenuOperacoes.iterarClientes(listaSeguradoras.get(indiceSeg3).getListaClientes()) +"    "+ listaSeguradoras.get(indiceSeg3).getListaClientes().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg3).getListaClientes().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg3).getListaClientes().size())
                                {
                                    break;
                                }
                                int indiceCli2 = intTemp;
                                String menuListarSinistrosCli = "\nSinistro para Mostrar Relatório\n";
                                for(int i = 0; i < listaSeguradoras.get(indiceSeg3).getListaSinistros().size(); i++)
                                {
                                    if(listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCli2).tipoDeCliente().equals("PF") && listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getCliente().tipoDeCliente().equals("PF"))
                                    {
                                        ClientePF clientePF = (ClientePF)listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCli2);
                                        ClientePF c = (ClientePF) listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getCliente();
                                        if(c.getCpf().equals(clientePF.getCpf()))
                                        {
                                            menuListarSinistrosCli += "\n    " + i + " - " + listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getData() + ": " + listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getCliente().getEndereco() + ", id: " + listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getId();
                                        }
                                    }
                                    else if(listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCli2).tipoDeCliente().equals("PJ") && listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getCliente().tipoDeCliente().equals("PJ"))
                                    {
                                        ClientePJ clientePJ = (ClientePJ)listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCli2);
                                        ClientePJ c = (ClientePJ) listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getCliente();
                                        if(c.getCnpj().equals(clientePJ.getCnpj()))
                                        {
                                            menuListarSinistrosCli += "\n    " + i + " - " + listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getData() + ": " + listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getCliente().getEndereco() + ", id: " + listaSeguradoras.get(indiceSeg3).getListaSinistros().get(i).getId();
                                        }
                                    }
                                }
                                menuListarSinistrosCli += "\n    " + listaSeguradoras.get(indiceSeg3).getListaSinistros().size() + " - Voltar\n    Selecione a opção desejada: ";
                                System.out.print(menuListarSinistrosCli);
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg3).getListaSinistros().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg3).getListaSinistros().size())
                                {
                                    break;
                                }
                                int indiceSin2 = intTemp;
                                System.out.print("\n"+listaSeguradoras.get(indiceSeg3).getListaSinistros().get(indiceSin2).toString());
                                break;
                            case LISTAR_VEICULOS_CLI:
                                System.out.print("\nSeguradora para Listar Veículos por Cliente:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.size())
                                {
                                    break;
                                }
                                int indiceSeg4 = intTemp;
                                System.out.print("\nCliente para Listar Veículos:\n" + MenuOperacoes.iterarClientes(listaSeguradoras.get(indiceSeg4).getListaClientes()) +"    " +listaSeguradoras.get(indiceSeg4).getListaClientes().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg4).getListaClientes().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg4).getListaClientes().size())
                                {
                                    break;
                                }
                                int indiceCli3 = intTemp;
                                System.out.print("\nVeiculo para Mostrar Relatório:\n" + MenuOperacoes.iterarVeiculos(listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos()) +"    "+ listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos().size())                        {
                                    System.out.println();
                                    break;
                                }
                                int indiceVei = intTemp;
                                System.out.print("\n"+listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos().get(indiceVei).toString());
                                break;
                            case LISTAR_VEICULOS_SEG:
                                System.out.print("\nSeguradora para Listar Veículos:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.size())
                                {
                                    break;
                                }
                                int indiceSeg5 = intTemp;
                                ArrayList<Veiculo> listaVeiculosSeguradora = new ArrayList<Veiculo>();
                                for(int i = 0; i < listaSeguradoras.get(indiceSeg5).getListaClientes().size(); i++)
                                    for(int j = 0; j < listaSeguradoras.get(indiceSeg5).getListaClientes().get(i).getListaVeiculos().size(); j++)
                                        listaVeiculosSeguradora.add(listaSeguradoras.get(indiceSeg5).getListaClientes().get(i).getListaVeiculos().get(j));
                                System.out.print("\nVeiculo para Mostrar Relatório:\n" + MenuOperacoes.iterarVeiculos(listaVeiculosSeguradora) +"    "+ listaVeiculosSeguradora.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaVeiculosSeguradora.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaVeiculosSeguradora.size())                        {
                                    System.out.println();
                                    break;
                                }
                                int indiceVei2 = intTemp;
                                System.out.print("\n"+listaVeiculosSeguradora.get(indiceVei2).toString());
                                break;
                            case LISTAR_VOLTAR:
                                System.out.println();
                                break;
                            default:
                                op = LISTAR_VOLTAR;
                                System.out.println("\nERRO!\n");
                                break;
                        }
                    }
                    break;
                case EXCLUIR:
                    while(op != EXCLUIR_VOLTAR)
                    {
                        System.out.print(menuExcluir);
                        entradaTemp = entrada.nextLine();
                        if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(1, 5)))
                        {
                            System.out.println("\nInsira uma opção válida.\n");
                            continue;
                        }
                        intTemp = Integer.parseInt(entradaTemp);
                        op = MenuOperacoes.getOperacao(3, intTemp);
                        switch (op) {
                            case EXCLUIR_CLIENTE:
                            System.out.print("\nSeguradora para Excluir Cliente:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.size())
                                {
                                    break;
                                }
                                int indiceSeg1 = intTemp;
                                System.out.print("\nCliente a ser Excluido:\n" + MenuOperacoes.iterarClientes(listaSeguradoras.get(indiceSeg1).getListaClientes()) + "    " +listaSeguradoras.get(indiceSeg1).getListaClientes().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg1).getListaClientes().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg1).getListaClientes().size())
                                {
                                    break;
                                }
                                int indiceCli = intTemp;
                                for(int i = 0; i < listaSeguradoras.get(indiceSeg1).getListaSinistros().size(); i++) //Remove os sinistros do cliente excluido
                                {
                                    if(listaSeguradoras.get(indiceSeg1).getListaClientes().get(indiceCli).tipoDeCliente().equals("PF") && listaSeguradoras.get(indiceSeg1).getListaSinistros().get(i).getCliente().tipoDeCliente().equals("PF"))
                                    {
                                        ClientePF clienteSinPF = (ClientePF)listaSeguradoras.get(indiceSeg1).getListaSinistros().get(i).getCliente();
                                        ClientePF clientePF = (ClientePF)listaSeguradoras.get(indiceSeg1).getListaClientes().get(indiceCli);
                                        if(clientePF.getCpf().equals(clienteSinPF.getCpf()))
                                        {
                                            listaSeguradoras.get(indiceSeg1).getListaSinistros().remove(i);
                                        }
                                    }
                                    else if(listaSeguradoras.get(indiceSeg1).getListaClientes().get(indiceCli).tipoDeCliente().equals("PJ") && listaSeguradoras.get(indiceSeg1).getListaSinistros().get(i).getCliente().tipoDeCliente().equals("PJ"))
                                    {
                                        ClientePJ clienteSinPJ = (ClientePJ)listaSeguradoras.get(indiceSeg1).getListaSinistros().get(i).getCliente();
                                        ClientePJ clientePJ = (ClientePJ)listaSeguradoras.get(indiceSeg1).getListaClientes().get(indiceCli);
                                        if(clientePJ.getCnpj().equals(clienteSinPJ.getCnpj()))
                                        {
                                            listaSeguradoras.get(indiceSeg1).getListaSinistros().remove(i);
                                        }
                                    }
                                }
                                listaSeguradoras.get(indiceSeg1).getListaClientes().remove(indiceCli);
                                System.out.print("\nCliente e seus sinistros foram excluidos com sucesso\n");
                                break;
                            case EXCLUIR_VEICULO:
                            System.out.print("\nSeguradora para Listar Excluir Veículo:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.size())
                                {
                                    break;
                                }
                                int indiceSeg4 = intTemp;
                                System.out.print("\nCliente à ter Veículo Excluido:\n" + MenuOperacoes.iterarClientes(listaSeguradoras.get(indiceSeg4).getListaClientes()) + "    "+listaSeguradoras.get(indiceSeg4).getListaClientes().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg4).getListaClientes().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg4).getListaClientes().size())
                                {
                                    break;
                                }
                                int indiceCli3 = intTemp;
                                System.out.print("\nVeiculo para ser Excluido:\n" + MenuOperacoes.iterarVeiculos(listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos()) +"    "+ listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos().size())                        {
                                    System.out.println();
                                    break;
                                }
                                int indiceVei = intTemp;
                                listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).getListaVeiculos().remove(indiceVei);
                                listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3).setValorSeguro(listaSeguradoras.get(indiceSeg4).calcularPrecoSeguroCliente(listaSeguradoras.get(indiceSeg4).getListaClientes().get(indiceCli3)));
                                System.out.print("\nVeiculo excluido com sucesso.\n");
                                break;
                            case EXCLUIR_SINISTRO:
                                System.out.print("\nSeguradora para Excluir Sinistro:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.size())
                                {
                                    break;
                                }
                                int indiceSeg2 = intTemp;
                                String menuListarSinistrosSeg = "\nSinistro à Ser Excluido\n";
                                for(int i = 0; i < listaSeguradoras.get(indiceSeg2).getListaSinistros().size(); i++)
                                {
                                    menuListarSinistrosSeg += "\n    " + i + " - " + listaSeguradoras.get(indiceSeg2).getListaSinistros().get(i).getData() + ": " + listaSeguradoras.get(indiceSeg2).getListaSinistros().get(i).getCliente().getNome() + ", id: " + listaSeguradoras.get(indiceSeg2).getListaSinistros().get(i).getId();
                                }
                                menuListarSinistrosSeg += "\n    " + listaSeguradoras.get(indiceSeg2).getListaSinistros().size() + " - Voltar\n    Selecione a opção desejada: ";
                                System.out.print(menuListarSinistrosSeg);
                                entradaTemp = entrada.nextLine();
                                if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg2).getListaSinistros().size()+1)))
                                {
                                    System.out.println("\nInsira uma opção válida.\n");
                                    break;
                                }
                                intTemp = Integer.parseInt(entradaTemp);
                                if(intTemp == listaSeguradoras.get(indiceSeg2).getListaSinistros().size())
                                {
                                    break;
                                }
                                int indiceSin1 = intTemp;
                                Cliente cliente = listaSeguradoras.get(indiceSeg2).getListaSinistros().get(indiceSin1).getCliente();
                                listaSeguradoras.get(indiceSeg2).getListaSinistros().remove(indiceSin1);
                                cliente.setValorSeguro(listaSeguradoras.get(indiceSeg2).calcularPrecoSeguroCliente(cliente));
                                System.out.print("\nSinistro excluido com sucesso.\n");
                                break;
                            case EXCLUIR_VOLTAR:
                                System.out.println();
                                break;
                            default:
                                op = EXCLUIR_VOLTAR;
                                System.out.print("\nERRO!\n");
                                break;
                        }
                    }
                    break;
                case GERAR_SINISTRO:
                    System.out.print("\nSeguradora para Gerar o Sinistro:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                    entradaTemp = entrada.nextLine();
                    if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                    {
                        System.out.println("\nInsira uma opção válida.\n");
                        break;
                    }
                    intTemp = Integer.parseInt(entradaTemp);
                    if(intTemp == listaSeguradoras.size())
                    {
                        System.out.println();
                        break;
                    }
                    int indiceSeg = intTemp;
                    System.out.print("\nCliente que Sofreu o Acidente:\n" + MenuOperacoes.iterarClientes(listaSeguradoras.get(indiceSeg).getListaClientes()) + "    "+listaSeguradoras.get(indiceSeg).getListaClientes().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                    entradaTemp = entrada.nextLine();
                    if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg).getListaClientes().size()+1)))
                    {
                        System.out.println("\nInsira uma opção válida.\n");
                        break;
                    }
                    intTemp = Integer.parseInt(entradaTemp);
                    if(intTemp == listaSeguradoras.get(indiceSeg).getListaClientes().size())                        {
                        System.out.println();
                        break;
                    }
                    int indiceCli = intTemp;
                    System.out.print("\nVeiculo que Sofreu o Acidente:\n" + MenuOperacoes.iterarVeiculos(listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli).getListaVeiculos()) +"    "+ listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli).getListaVeiculos().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                    entradaTemp = entrada.nextLine();
                    if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli).getListaVeiculos().size()+1)))
                    {
                        System.out.println("\nInsira uma opção válida.\n");
                        break;
                    }
                    intTemp = Integer.parseInt(entradaTemp);
                    if(intTemp == listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli).getListaVeiculos().size())                        {
                        System.out.println();
                        break;
                    }
                    int indiceVei = intTemp;
                    System.out.print("\nInsira as Informações do Acidente:\n\n"
                    +"    - Local do Acidente: ");
                    String endSinistro = entrada.nextLine();
                    System.out.print("    - Data do Acidente (dd/mm/aaaa): ");
                    String dataSinistro = entrada.nextLine();
                    if(!Validacao.validaData(dataSinistro))
                    {
                        System.out.println("\nData inválida.\n");
                        break;
                    }
                    listaSeguradoras.get(indiceSeg).gerarSinistro(new Sinistro(dataSinistro, endSinistro, listaSeguradoras.get(indiceSeg), listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli).getListaVeiculos().get(indiceVei), listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli)));
                    listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli).setValorSeguro(listaSeguradoras.get(indiceSeg).calcularPrecoSeguroCliente(listaSeguradoras.get(indiceSeg).getListaClientes().get(indiceCli)));
                    System.out.print("\nSinistro gerado com sucesso.\n");
                    break;
                case TRANSFERIR_SEGURO:
                    System.out.print("\nSeguradora em que Ocorrerá a Transferência:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                    entradaTemp = entrada.nextLine();
                    if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                    {
                        System.out.println("\nInsira uma opção válida.\n");
                        break;
                    }
                    intTemp = Integer.parseInt(entradaTemp);
                    if(intTemp == listaSeguradoras.size())
                    {
                        System.out.println();
                        break;
                    }
                    int indiceSeg3 = intTemp;
                    System.out.print("\nCliente Remetente da Transferência:\n" + MenuOperacoes.iterarClientes(listaSeguradoras.get(indiceSeg3).getListaClientes()) +"    " + listaSeguradoras.get(indiceSeg3).getListaClientes().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                    entradaTemp = entrada.nextLine();
                    if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg3).getListaClientes().size()+1)))
                    {
                        System.out.println("\nInsira uma opção válida.\n");
                        break;
                    }
                    intTemp = Integer.parseInt(entradaTemp);
                    if(intTemp == listaSeguradoras.get(indiceSeg3).getListaClientes().size())                        {
                        System.out.println();
                        break;
                    }
                    int indiceCliRemetente = intTemp;
                    System.out.print("\nCliente Destinatário da Transferência:\n" + MenuOperacoes.iterarClientes(listaSeguradoras.get(indiceSeg3).getListaClientes()) + "    "+listaSeguradoras.get(indiceSeg3).getListaClientes().size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                    entradaTemp = entrada.nextLine();
                    if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.get(indiceSeg3).getListaClientes().size()+1)))
                    {
                        System.out.println("\nInsira uma opção válida.\n");
                        break;
                    }
                    intTemp = Integer.parseInt(entradaTemp);
                    if(intTemp == listaSeguradoras.get(indiceSeg3).getListaClientes().size())                        {
                        System.out.println();
                        break;
                    }
                    int indiceCliDestinatário = intTemp;
                    if(indiceCliDestinatário == indiceCliRemetente)
                    {
                        System.out.println("\nUma transferência só pode ocorrer entre dois clientes distintos.\n");
                        break;
                    }
                    for(int i = listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCliRemetente).getListaVeiculos().size()-1; i >= 0 ; i--)
                    {
                        listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCliDestinatário).getListaVeiculos().add(listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCliRemetente).getListaVeiculos().get(i));
                        listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCliRemetente).getListaVeiculos().remove(i);
                    }
                    listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCliDestinatário).setValorSeguro(listaSeguradoras.get(indiceSeg3).calcularPrecoSeguroCliente(listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCliDestinatário)));
                    listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCliRemetente).setValorSeguro(listaSeguradoras.get(indiceSeg3).calcularPrecoSeguroCliente(listaSeguradoras.get(indiceSeg3).getListaClientes().get(indiceCliRemetente)));
                    System.out.print("\nTransferência realizada com sucesso.\n");
                    break;
                case CALCULAR_RECEITA:
                    System.out.print("\nSeguradora para Calcular a Receita:\n" + MenuOperacoes.iterarSeguradoras(listaSeguradoras) + "    " + listaSeguradoras.size() + " - Voltar" + "\n    Selecione a opção desejada: ");
                    entradaTemp = entrada.nextLine();
                    if(!Validacao.validaIntEntre(entradaTemp, Intervalo.definidoPor(0, listaSeguradoras.size()+1)))
                    {
                        System.out.println("\nInsira uma opção válida.\n");
                        break;
                    }
                    intTemp = Integer.parseInt(entradaTemp);
                    if(intTemp == listaSeguradoras.size())
                    {
                        System.out.println();
                        break;
                    }
                    String saida = "\nReceita da Seguradora "+listaSeguradoras.get(intTemp).getNome()+ ": R$" +String.format("%.2f", listaSeguradoras.get(intTemp).calcularReceita()+"\n");
                    System.out.println(saida);
                    break;
                case SAIR:
                    break; //op = SAIR sai do loop principal
                default:
                    op = SAIR;
                    System.out.println("\nERRO!\n");
                    break;
            }
        }
        entrada.close();
    }
}

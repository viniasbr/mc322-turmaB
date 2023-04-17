package lab03;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String args []) throws Exception
    {
        ArrayList<Integer> selecao = new ArrayList<Integer>();
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
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
                    String nome = entrada.nextLine();
                    System.out.print("Insira o telefone da seguradora: ");
                    String telefone = entrada.nextLine();
                    System.out.print("Insira o email da seguradora: ");
                    String email = entrada.nextLine();
                    System.out.print("Insira o endereço da seguradora: ");
                    String endereco = entrada.nextLine();
                    listaSeguradoras.add(new Seguradora(nome, telefone, email, endereco));
                    System.out.print("Seguradora " + listaSeguradoras.get(listaSeguradoras.size()-1).getNome() + " registrada.\n\n");
                    break;
                case 2: //Camada 1 do menu (listaSeguradoras.get(selecao.get(1)-1) retorna a seguradora escolhida)
                    String saida = "Selecione a Seguradora:";
                    for(int i = 0; i < listaSeguradoras.size(); i++)
                    {
                        saida = saida +"\n    "+ (i+1) +" - " + listaSeguradoras.get(i).getNome();
                    }
                    saida = saida +"\n    "+(listaSeguradoras.size()+1)+" - Retornar ao Menu Principal";
                    saida = saida +"\nOpção: ";
                    System.out.print(saida);
                    selecao.add(1,Integer.parseInt(entrada.nextLine()));
                    if(selecao.get(1)-1 < listaSeguradoras.size() && selecao.get(1)-1 >= 0)
                    {
                        selecao.add(2,0);
                        while(selecao.get(2) != 6)
                        {
                            System.out.print(
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
                            switch(selecao.get(2))
                            {
                                case 1:
                                    //Novo cliente
                                    break;
                                case 2:
                                    //ToString Cliente
                                    break;
                                case 3:
                                    //Adicionar Veiculo ao Cliente
                                    break;
                                case 4:
                                    //Criar Sinistro
                                    break;
                                case 5:
                                    //ToString Sinistro
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
                    //Demo
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

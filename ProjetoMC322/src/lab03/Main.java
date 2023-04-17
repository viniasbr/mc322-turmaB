package lab03;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args [])
    {
        ArrayList<Integer> selecao = new ArrayList<Integer>();
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        Scanner entrada = new Scanner(System.in);
        selecao.add(0,0);
        while(selecao.get(0) != 3) //Camada 0 do menu
        {
            System.out.print(
                "Bem vindo ao Sistema das Seguradoras. Digite o número correspondente para:"
                +"\n    1 - Registrar Nova Seguradora"
                +"\n    2 - Acessar Sistema de Seguradora"
                +"\n    3 - Sair"
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
                case 2:
                    //Acessar
                    break;
                case 3:
                    //Sair
                    break;
                default:
                    System.out.println("Selecione uma opção válida.\n");
            }
        }
        entrada.close();
    }
}

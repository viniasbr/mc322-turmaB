package lab04;
/* import java.util.ArrayList;
import java.util.Scanner; */
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Main {
    public static void main(String args [])
    {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Seguradora seguradora = new Seguradora("Exemplo Seguros LTDA.", "(12)3456-7890", "contato@exemploseguros.com", "Rua do Exemplo, 123");
        Veiculo veiculo1 = new Veiculo("ABC1234", "Volkswagen", "Fusca", 1998);
        Veiculo veiculo2 = new Veiculo("ACB1234", "Volkswagen", "Fusca", 1999);
        Veiculo veiculo3 = new Veiculo("BCA1234", "Volkswagen", "Fusca", 2000);
        Veiculo veiculo4 = new Veiculo("CBA1234", "Volkswagen", "Fusca", 2001);
        ClientePF cliente1 = new ClientePF("Ana Borges Carvalho", "Rua Residencial, 123", veiculo1, "600.366.860-18", "Feminino", LocalDate.parse("01/01/2021", formatador), "Ensino Superior Completo", LocalDate.parse("01/01/2000", formatador), "Classe Média");
        ClientePJ cliente2 = new ClientePJ("Firma Exemplo e CIA.", "Rua Comercial, 234", veiculo2, "81.808.861/0001-00", LocalDate.parse("10/10/2021", formatador));
        seguradora.cadastrarCliente(cliente1);
        seguradora.cadastrarCliente(cliente2);
        seguradora.gerarSinistro(new Sinistro("10/10/2022", "Rua do Azar, 4567", seguradora, veiculo1, cliente1));
        cliente1.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente1));
        seguradora.gerarSinistro(new Sinistro("11/11/2022", "Rua do Azar, 4567", seguradora, veiculo2, cliente2));
        cliente2.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente2));
        cliente1.addVeiculo(veiculo3);
        cliente1.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente1));
        cliente2.addVeiculo(veiculo4);
        cliente2.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente2));
        String listaClientes = seguradora.listarClientes("PF") + seguradora.listarClientes("PJ");
        boolean anaTemSinistros = seguradora.visualizarSinistro("600.366.860-18");
        String listaSinistros = seguradora.listarSinistros();
        double receita = seguradora.calcularReceita();
    }
}

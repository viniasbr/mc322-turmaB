package lab04;
import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, Veiculo veiculo, 
    String cpf, String genero, LocalDate dataLicenca,String educacao, 
    LocalDate dataNascimento, String classeEconomica) {
        super(nome, endereco, veiculo);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public LocalDate getDataLicenca() {
        return dataLicenca;
    }
    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
    }
    public String getEducacao() {
        return educacao;
    }
    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }
    public String getClasseEconomica() {
        return classeEconomica;
    }
    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }
    public String getCpf() {
        return cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    @Override
    public double calculaScore()
    {
        Period periodo = Period.between(dataNascimento, LocalDate.now());
        int idade = periodo.getYears();
        if(Intervalo.definidoPor(18, 30).contem(idade))
        {
            return CalcSeguro.FATOR_18_30.fator()* CalcSeguro.VALOR_BASE.fator()*getListaVeiculos().size();
        }
        else if(Intervalo.definidoPor(30, 60).contem(idade))
        {
            return CalcSeguro.FATOR_30_60.fator()* CalcSeguro.VALOR_BASE.fator()*getListaVeiculos().size();
        }
        else if(Intervalo.definidoPor(60, 90).contem(idade))
        {
            return CalcSeguro.FATOR_60_90.fator()* CalcSeguro.VALOR_BASE.fator()*getListaVeiculos().size();
        }
        return 0;
    }
    @Override
    public String toString() {
        String saida = "Informações do Cliente Pessoa Física:\n"
        +"\n    Nome: " + getNome()
        +"\n    Endereço: " + getEndereco()
        +"\n    Valor do Seguro: R$" + String.format("%.2f", getValorSeguro())
        +"\n    CPF: " + getCpf()
        +"\n    Gênero: " + getGenero()
        +"\n    Data da Licença: " + getDataLicenca().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        +"\n    Educação: " + getEducacao()
        +"\n    Data de Nascimento: " + getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        +"\n    Classe Econômica: " + getClasseEconomica()
        +"\n    Veiculo(s): ";
        for(Veiculo v: getListaVeiculos())
        {
            saida = saida + "\n         " + v.getMarca() +" "+ v.getModelo() + " " + v.getAnoFabricacao() + ", Placa: " + v.getPlaca();
        }
        return saida + "\n";
    }
    @Override
    public String tipoDeCliente()
    {
        return "PF";
    }
}

package lab03;
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
    public boolean validarCPF(){
        String cpflimpo;
        cpflimpo = cpf.replaceAll("[^0123456789]","");//Remove caracteres especiais do CPF
        if (cpflimpo.length() != 11) //Confere numero de caracteres
        {
            return false;
        }
        if (cpflimpo.equals("00000000000") || cpflimpo.equals("11111111111") 
        || cpflimpo.equals("22222222222") || cpflimpo.equals("33333333333") 
        || cpflimpo.equals("44444444444") || cpflimpo.equals("55555555555")
        || cpflimpo.equals("66666666666") || cpflimpo.equals("77777777777")
        || cpflimpo.equals("88888888888") || cpflimpo.equals("99999999999")) //Confere se os caracteres são iguais
        {
            return false;
        }
        int [] digitos = new int[11];
        for(int i = 0; i < 11; i++) //Transforma o CPF em um vetor de int
        {
            digitos[i] = Character.getNumericValue(cpflimpo.charAt(i));
        }
        int [] temp = new int[10];
        for(int i = 0; i < 9; i++) //Multiplica cada digito pelos fatores 
        {
            temp[i] = digitos[i]*(10-i);
        }
        int primeiroDividendo = 0;
        int primeiroDigito = -1; //dummy do primeiro digito
        for(int i = 0; i < 9; i++) //Produz o dividendo do primeiro digito verificador
        {
            primeiroDividendo = primeiroDividendo + temp[i];
        }
        if(primeiroDividendo % 11 < 2) //Define o primeiro digito verificador
        {
            primeiroDigito = 0;
        }
        else if(primeiroDividendo % 11 >= 2)
        {
            primeiroDigito = 11 - (primeiroDividendo % 11);
        }
        for(int i = 0; i < 9; i++) //Preenche temp com os digitos multiplicados por fatores
        {
            temp[i] = digitos[i]*(11-i);
        }
        temp[9] = primeiroDigito*2; //Adiciona o primeiro digito de verificação ja multiplicado
        int segundoDividendo = 0;
        int segundoDigito = -1; //dummy do segundo digito
        for(int i = 0; i < 10; i++) //Produz o dividendo do segundo digito
        {
            segundoDividendo = segundoDividendo + temp[i];
        }
        if(segundoDividendo % 11 < 2) //Define o segundo digito verificador
        {
            segundoDigito = 0;
        }
        else if(segundoDividendo % 11 >= 2)
        {
            segundoDigito = 11 - (segundoDividendo % 11);
        }
        if(digitos[9] == primeiroDigito && digitos[10] == segundoDigito) //Compara os digitos produzidos com os digitos do CPF
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public String toString() {
        String saida = "Informações do Cliente Pessoa Física:\n"
        +"\n    Nome: " + getNome()
        +"\n    Endereço: " + getEndereco()
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
        saida = saida + "\n    Validez do CPF: ";
        if(validarCPF())
        {
            saida = saida + "Válido\n\n";
        }
        else
        {
            saida = saida + "Inválido\n\n";
        }
        return saida;
    }
    @Override
    public String tipoDeCliente()
    {
        return "PF";
    }
}

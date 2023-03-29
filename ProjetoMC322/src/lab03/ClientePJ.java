package lab03;
import java.util.Date;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private Date dataFundacao;
    
    public ClientePJ(String nome, String endereco, Date dataLicenca,
            String classeEconomica, Veiculo veiculo, String cnpj, Date dataFundacao) {
        super(nome, endereco, dataLicenca, "N/A", "N/A", classeEconomica, veiculo);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }
    public String getCnpj() {
        return cnpj;
    }
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    public boolean validarCNPJ(){
        String cnpjlimpo;
        cnpjlimpo = cnpj.replaceAll("[^0123456789]","");//Remove caracteres especiais do CNPJ
        if(cnpjlimpo.length() != 14)
        {
            return false;
        }
        if(cnpjlimpo.equals("00000000000000")|| //Confere se os digitos são iguais
        cnpjlimpo.equals("11111111111111")||
        cnpjlimpo.equals("22222222222222")||
        cnpjlimpo.equals("33333333333333")||
        cnpjlimpo.equals("44444444444444")||
        cnpjlimpo.equals("55555555555555")||
        cnpjlimpo.equals("66666666666666")||
        cnpjlimpo.equals("77777777777777")||
        cnpjlimpo.equals("88888888888888")||
        cnpjlimpo.equals("99999999999999"))
        {
            return false;
        }
        int[] digitos = new int[14];
        for(int i = 0; i < 14; i++) //Transforma o CNPJ em um vetor de int
        {
            digitos[i] = Character.getNumericValue(cnpjlimpo.charAt(i));
        }
        int[] temp = new int[13];
        int[] fatores1 = {5,4,3,2,9,8,7,6,5,4,3,2};
        for(int i = 0; i < 12; i++) //Multiplica cada digito pelos fatores 
        {
            temp[i] = digitos[i]*fatores1[i];
        }
        int primeiroDividendo = 0;
        int primeiroDigito = -1; //dummy do primeiro digito
        for(int i = 0; i < 12; i++) //Produz o dividendo do primeiro digito verificador
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
        int[] fatores2 = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        for(int i = 0; i < 12; i++) //Preenche temp com os digitos multiplicados por fatores
        {
            temp[i] = digitos[i]*fatores2[i];
        }
        temp[12] = primeiroDigito*fatores2[12]; //Adiciona o primeiro digito de verificação ja multiplicado
        int segundoDividendo = 0;
        int segundoDigito = -1; //dummy do segundo digito
        for(int i = 0; i < 13; i++) //Produz o dividendo do segundo digito
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
        if(digitos[12] == primeiroDigito && digitos[13] == segundoDigito) //Compara os digitos produzidos com os digitos do CPF
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String toString() {
        String saida = "Informações do Cliente:\n"
        +"\n    Nome: " + getNome()
        +"\n    Endereço: " + getEndereco()
        +"\n    Data da Licença: " + getDataLicenca()
        +"\n    Educação: " + getEducacao()
        +"\n    Gênero: " + getGenero()
        +"\n    Classe Econômica: " + getClasseEconomica()
        +"\n    Veiculo(s): ";
        for(Veiculo v: getListaVeiculos())
        {
            saida = saida + "         " + v.getMarca() +" "+ v.getModelo() + " " + v.getAnoFabricacao() + ", Placa: " + v.getPlaca() +"\n";
        }
        saida = saida + "Validez do CNPJ: ";
        if(validarCNPJ())
        {
            saida = saida + "Válido\n\n";
        }
        else
        {
            saida = saida + "Inválido\n\n";
        }
        return saida;
    }
}

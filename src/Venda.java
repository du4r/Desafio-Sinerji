import java.util.Comparator;

public class Venda{
    String vendedor;
    int mes;
    int ano;
    double valor;

    public Venda(String vendedor, int mes, int ano, double valor) {
        this.vendedor = vendedor;
        this.mes = mes;
        this.ano = ano;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "vendedor='" + vendedor + '\'' +
                ", mes=" + mes +
                ", ano=" + ano +
                ", valor=" + valor +
                '}';
    }


}

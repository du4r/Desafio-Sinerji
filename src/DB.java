import java.util.Arrays;
import java.util.List;

public class DB {
    public List<Funcionario> funcionarios = Arrays.asList(
            new Funcionario("Jorge Carvalho", Cargo.Secretario, 01,2018),
            new Funcionario("Maria Souza", Cargo.Secretario, 02,2015),
            new Funcionario("Ana Silva", Cargo.Vendedor, 12,2021),
            new Funcionario("Joao Mendes", Cargo.Vendedor, 12,2021),
            new Funcionario("Juliana Alves", Cargo.Gerente, 07,2017),
            new Funcionario("Bento Albino", Cargo.Gerente, 03,2014)
    );

   public List<Venda> registroVendas = Arrays.asList(
            new Venda("Ana Silva",12,2021,5200),
            new Venda("Ana Silva",01,2022,4000),
            new Venda("Ana Silva",02,2022,4200),
            new Venda("Ana Silva",03,2022,5850),
            new Venda("Ana Silva",04,2022,7000),
            new Venda("Joao Mendes",12,2021,3400),
            new Venda("Joao Mendes",01,2022,7700),
            new Venda("Joao Mendes",02,2022,5000),
            new Venda("Joao Mendes",03,2022,5900),
            new Venda("Joao Mendes",04,2022,6500)
    );
}

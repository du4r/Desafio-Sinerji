import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        DB db = new DB();
        Empresa sinerji = new Empresa(db.funcionarios,db.registroVendas);
        
        System.out.println("Bem vind@!, favor retirar o comentario de um log por vez antes de testar");
        
        //1°
        //System.out.printf("Total pago = %.2f %n",sinerji.totalPago(db.funcionarios, 02,2022));

        //2°
        //System.out.printf("Total pago (SOMENTE SALARIOS) = %.2f %n", sinerji.totalPagoSomenteSalarios(db.funcionarios,01,2022) );

        //3°
        //System.out.printf("Total pago (SOMENTE BENEFICIOS) = %.2f %n", sinerji.totalPagoSomenteBeneficios(db.funcionarios,01,2022));

        //4°
        //System.out.println("Funcionario com o salario mais alto do mes = " + sinerji.funcionarioSalarioMaisAltoDoMes(db.funcionarios,12,2021));

        //5°
        //List<Funcionario> funcionariosBeneficiados = db.funcionarios
        //        .stream()
        //        .filter(funcionario -> funcionario.cargo != Cargo.Gerente)
        //        .collect(Collectors.toList());
        //System.out.println("Funcionario com o beneficio mais alto do mes = " + sinerji.funcionarioBeneficioMaisAltoDoMes(funcionariosBeneficiados, 12, 2021));


        //6° 
        //List<Funcionario> vendedores = db.funcionarios
        //        .stream()
        //        .filter(funcionario -> funcionario.cargo == Cargo.Vendedor)
        //        .collect(Collectors.toList());
        //System.out.println("Vendedor com o maior valor em vendas do mes = " + sinerji.vendedorComMaisVendas(vendedores,02,2022));

    }

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Empresa {

    List<Funcionario> funcionarios;
    List<Venda> vendas;

    public Empresa(List<Funcionario> funcionarios, List<Venda> vendas) {
        this.funcionarios = funcionarios;
        this.vendas = vendas;
    }

    // 1:
    public double totalPago(List<Funcionario> funcionarios, int mes, int ano){
        double totalPago = 0.0;

        for (Funcionario F: funcionarios){
            int anosNaCasa = ano - F.getAnoContratacao();
            if(anosNaCasa > 1){
                F.setExtraAnual(F.getExtraAnual()*anosNaCasa);
            }
            switch (F.cargo){
                case Secretario:
                    totalPago += F.getSalario() + F.getExtraAnual() + F.getBeneficio();
                    break;
                case Vendedor:

                    for(Venda v : vendas){
                        if (F.getNome().equals(v.vendedor) && v.mes == mes && v.ano == ano){
                            F.setBeneficio(( (v.valor/100) * 30) );
                        }
                    }
                    totalPago += F.getSalario() + F.getExtraAnual() + F.getBeneficio();
                    break;
                case Gerente:
                    totalPago += F.getSalario() + F.getExtraAnual();
                    break;
            }
        }

        return totalPago;
    }

    public double totalPagoSomenteSalarios(List<Funcionario> funcionarios, int mes, int ano){
        double totalPago = 0;

        for (Funcionario F: funcionarios){
            int anosNaCasa = ano - F.getAnoContratacao();
            if(anosNaCasa > 1){
                F.setExtraAnual(F.getExtraAnual()*anosNaCasa);
            }
            switch (F.cargo){
                case Secretario:
                    totalPago += F.getSalario() + F.getExtraAnual();
                    break;
                case Vendedor:
                    totalPago += F.getSalario() + F.getExtraAnual();
                    break;
                case Gerente:
                    totalPago += F.getSalario() + F.getExtraAnual();
                    break;
            }
        }

        return totalPago;
    }

    public double totalPagoSomenteBeneficios(List<Funcionario> funcionarios, int mes, int ano){
        double totalPago = 0;

        for (Funcionario F: funcionarios){
            int anosNaCasa = ano - F.getAnoContratacao();
            if(anosNaCasa > 1){
                F.setExtraAnual(F.getExtraAnual()*anosNaCasa);
            }
            switch (F.cargo){
                case Secretario:
                    totalPago += F.getBeneficio();
                    break;
                case Vendedor:
                    for(Venda v : vendas){
                        if (F.getNome().equals(v.vendedor) && v.mes == mes && v.ano == ano){
                            F.setBeneficio(((v.valor/100) * 30));
                        }
                    }
                    totalPago += F.getBeneficio();
                    break;
            }
        }

        return totalPago;
    }

    public Funcionario funcionarioSalarioMaisAltoDoMes(List<Funcionario> funcionarios, int mes, int ano){
        List<Funcionario> funcionariosMaisBemPagos = new ArrayList<>(){};

        for (Funcionario F: funcionarios){
            int anosNaCasa = ano - F.getAnoContratacao();
            if(anosNaCasa > 1){
                F.setExtraAnual(F.getExtraAnual()*anosNaCasa);
            }
            switch (F.cargo){
                case Vendedor:
                    for(Venda v : vendas){
                        if (F.getNome().equals(v.vendedor) && v.mes == mes && v.ano == ano){
                            F.setBeneficio(((v.valor/100) * 30));
                            F.setSalario(F.getSalario() + F.getExtraAnual() + F.getBeneficio());
                        }
                    }

                    if (funcionariosMaisBemPagos.isEmpty() || F.getSalario() > funcionariosMaisBemPagos.get(0).getSalario()){
                        funcionariosMaisBemPagos.add(0,F);
                    }
                    break;

                case Gerente:
                    F.setSalario(F.getSalario() + F.getExtraAnual());
                    if (funcionariosMaisBemPagos.isEmpty() || F.getSalario() > funcionariosMaisBemPagos.get(0).getSalario()){
                        funcionariosMaisBemPagos.add(0,F);
                    }
                    break;
            }
        }

        return funcionariosMaisBemPagos.get(0);
    }

    public String funcionarioBeneficioMaisAltoDoMes(List<Funcionario>funcionarios, int mes,int ano){

        List<Funcionario> funcionariosMaisBemPagos = new ArrayList<>(){};

        for (Funcionario F: funcionarios){
            switch (F.cargo){
                case Secretario:
                    if (funcionariosMaisBemPagos.isEmpty() || F.getBeneficio() > funcionariosMaisBemPagos.get(0).getBeneficio()){
                        funcionariosMaisBemPagos.add(0,F);
                    }
                    break;

                case Vendedor:

                    for(Venda v : vendas){
                        if (F.getNome().equals(v.vendedor) && v.mes == mes && v.ano == ano){
                            F.setBeneficio(((v.valor/100) * 30));
                        }
                    }

                    if (funcionariosMaisBemPagos.isEmpty() || F.getBeneficio() > funcionariosMaisBemPagos.get(0).getBeneficio()){
                        funcionariosMaisBemPagos.add(0,F);
                    }
                    break;
            }
        }
        
        return funcionariosMaisBemPagos.get(0).getNome();
    }

    public Funcionario vendedorComMaisVendas(List<Funcionario>vendedores, int mes, int ano){

        Funcionario funcDoMes = new Funcionario();

        for (Funcionario F: vendedores){
           for (Venda venda:vendas){
               if (venda.mes == mes && venda.ano == ano && venda.vendedor.equals(F.getNome())){
                   F.setBeneficio(((venda.valor/100) * 30));
               }
           }
        }

        Collections.sort(vendedores);
        if (vendedores.get(0).getBeneficio() != 0) { funcDoMes = vendedores.get(0); }

        return funcDoMes;
    }
    
}

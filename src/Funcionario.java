public class Funcionario implements Comparable<Funcionario> {
    private String nome;
    Cargo cargo;
    private int mesContratacao;
    private int AnoContratacao;
    private double salario;
    private double extraAnual;
    private double beneficio;

    public Funcionario(String nome, Cargo cargo, int mesContratacao, int anoContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.mesContratacao = mesContratacao;
        this.AnoContratacao = anoContratacao;

        switch (this.cargo) {
            case Secretario:
                this.setSalario(7000);
                this.setExtraAnual((1000.0 / 12));
                this.setBeneficio((this.salario / 100) * 20);
                break;
            case Vendedor:
                this.setSalario(12000);
                this.setExtraAnual((1800.0 / 12));
                break;
            case Gerente:
                this.setSalario(20000);
                this.setExtraAnual((3000.0 / 12));
                break;
            default:
                this.setSalario(0.0);
                this.setExtraAnual(0.0);
                this.setBeneficio(0.0);
                break;
        }
    }

    public Funcionario() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setMesContratacao(int mesContratacao) {
        this.mesContratacao = mesContratacao;
    }

    public void setAnoContratacao(int anoContratacao) {
        AnoContratacao = anoContratacao;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setExtraAnual(double extraAnual) {
        this.extraAnual = extraAnual;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public int getMesContratacao() {
        return mesContratacao;
    }

    public int getAnoContratacao() {
        return AnoContratacao;
    }

    public double getSalario() {
        return salario;
    }

    public double getExtraAnual() {
        return extraAnual;
    }

    public double getBeneficio() {
        return beneficio;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome= '" + nome + '\'' +
                ", cargo= " + cargo +
                '}';
    }

    @Override
    public int compareTo(Funcionario proximoFuncionario) {
        if (this.getBeneficio() > proximoFuncionario.getBeneficio()) {
            return -1;
        } else if (this.getBeneficio() < proximoFuncionario.getBeneficio()) {
            return 1;
        }
        return 0;
    }
}

enum Cargo {
    Secretario,
    Vendedor,
    Gerente
}
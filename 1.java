class Paciente {
    String nome;
    int idade;
    int senha;

    public Paciente(String nome, int idade, int senha) {
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Senha: " + senha + ", Nome: " + nome + ", Idade: " + idade;
    }
}

class NoPaciente {
    Paciente paciente;
    NoPaciente proximo;

    public NoPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.proximo = null;
    }
}

class FilaAtendimento {
    private NoPaciente inicio;

    public FilaAtendimento() {
        this.inicio = null;
    }

    public void inserirPaciente(Paciente paciente) {
        NoPaciente novoNo = new NoPaciente(paciente);

        if (paciente.idade > 60) {
            if (inicio == null || inicio.paciente.idade <= 60) {
                novoNo.proximo = inicio;
                inicio = novoNo;
            } else {
                NoPaciente atual = inicio;
                while (atual.proximo != null && atual.proximo.paciente.idade > 60) {
                    atual = atual.proximo;
                }
                novoNo.proximo = atual.proximo;
                atual.proximo = novoNo;
            }
        } else {
            if (inicio == null) {
                inicio = novoNo;
            } else {
                NoPaciente atual = inicio;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novoNo;
            }
        }
    }

    public Paciente chamarProximo() {
        if (inicio == null) {
            System.out.println("Fila vazia. Nenhum paciente para chamar.");
            return null;
        }
        Paciente pacienteChamado = inicio.paciente;
        inicio = inicio.proximo;
        return pacienteChamado;
    }

    public void listarPacientes() {
        if (inicio == null) {
            System.out.println("Nenhum paciente aguardando.");
            return;
        }
        System.out.println("--- Pacientes na Fila ---");
        NoPaciente atual = inicio;
        while (atual != null) {
            System.out.println(atual.paciente);
            atual = atual.proximo;
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();

        fila.inserirPaciente(new Paciente("João Silva", 35, 1));
        fila.inserirPaciente(new Paciente("Maria Oliveira", 65, 2));
        fila.inserirPaciente(new Paciente("Pedro Costa", 28, 3));
        fila.inserirPaciente(new Paciente("Ana Martins", 72, 4));

        System.out.println("Fila inicial:");
        fila.listarPacientes();

        System.out.println("\nChamando próximo paciente...");
        Paciente p1 = fila.chamarProximo();
        System.out.println("Paciente chamado: " + p1);
        
        System.out.println("\nFila atualizada:");
        fila.listarPacientes();
    }
}
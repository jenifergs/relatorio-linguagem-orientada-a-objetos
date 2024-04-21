package org.example;

import java.util.Scanner;

class Usuario {
    String nome;
    String sobrenome;
    String cpf;
    double saldo;

    public Usuario(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0; // Inicializa o saldo como zero
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void retirar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada de R$" + valor + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar a retirada.");
        }
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = null;

        // Exibição do menu
        int opcao;
        do {
            System.out.println("===== Menu =====");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Realizar depósito");
            System.out.println("4 - Realizar retirada");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o sobrenome:");
                    String sobrenome = scanner.nextLine();
                    System.out.println("Digite o CPF:");
                    String cpf = scanner.nextLine();
                    usuario = new Usuario(nome, sobrenome, cpf);
                    System.out.println("Usuário cadastrado com sucesso.");
                    break;
                case 2:
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro.");
                    } else {
                        usuario.consultarSaldo();
                    }
                    break;
                case 3:
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro.");
                    } else {
                        System.out.println("Digite o valor do depósito:");
                        double valorDeposito = scanner.nextDouble();
                        usuario.depositar(valorDeposito);
                    }
                    break;
                case 4:
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro.");
                    } else {
                        System.out.println("Digite o valor da retirada:");
                        double valorRetirada = scanner.nextDouble();
                        usuario.retirar(valorRetirada);
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
        scanner.close();
    }
}

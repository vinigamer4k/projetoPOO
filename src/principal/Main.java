package principal;

import controle.CentralDeInformacoes;
import modelo.Usuario;

public class Main {

    public static void main(String[] args) {
        CentralDeInformacoes central = new CentralDeInformacoes();

        System.out.println("=== Organizador de Campeonato de Forca ===");

        if (central.isPrimeiraExecucao()) {
            System.out.println("\n[Aviso] Sistema sem usuários. Iniciando cadastro de Administrador...");
            try {
                central.cadastrarAdministrador("admin", "admin@forca.com", "senhaAdmin123");
                System.out.println("Administrador cadastrado com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar administrador: " + e.getMessage());
            }
        }

        System.out.println("\n[Teste] Cadastrando novo jogador...");
        try {
            central.cadastrarJogador("jogador1", "jog@teste.com", "1234");
            System.out.println("Jogador 'jogador1' cadastrado com sucesso!");
            
            central.cadastrarJogador("jogador2", "jog@teste.com", "5678");
        } catch (Exception e) {
            System.out.println("Erro esperado (validação funcionando): " + e.getMessage());
        }

        System.out.println("\n[Teste] Realizando Login...");
        try {
            Usuario usuarioLogado = central.realizarLogin("jog@teste.com", "1234");
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioLogado.getLogin());
        } catch (Exception e) {
            System.out.println("Erro no login: " + e.getMessage());
        }
    }
}
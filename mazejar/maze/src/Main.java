import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] direcoesGabarito = {"Direita", "Trás", "Direita", "Trás", "Direita", "Frente", "Direita"};
        int[] passosGabarito = {6, 11, 8, 3, 3, 9, 7};
        int totalEtapas = direcoesGabarito.length;

        int cargaTotal = 100;
        int consumoPorPasso = 1;

        System.out.println("=== Simulador de Robô com Bateria ===");
        System.out.println("Carga inicial da bateria: " + cargaTotal + " unidades");
        System.out.println("Consumo por passo: " + consumoPorPasso + " unidade(s)");
        System.out.println("Digite seus comandos no formato: Direção Passos (ex: Direita 6)");

        int etapaAtual = 0;
        int passosRestantes = passosGabarito[etapaAtual];

        while (cargaTotal > 0 && etapaAtual < totalEtapas) {
            System.out.print("\nComando (etapa " + (etapaAtual + 1) + "): ");
            String linha = scanner.nextLine().trim();
            String[] partes = linha.split("\\s+");

            if (partes.length != 2) {
                System.out.println("Formato inválido. Use: Direção Passos");
                continue;
            }

            String direcaoUsuario = partes[0].trim();
            int passosUsuario;

            try {
                passosUsuario = Integer.parseInt(partes[1].trim());
                if (passosUsuario <= 0) {
                    System.out.println("Número de passos deve ser maior que zero.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Passos inválidos. Insira um número inteiro.");
                continue;
            }

            String direcaoCorreta = direcoesGabarito[etapaAtual];

            if (!direcaoUsuario.equalsIgnoreCase(direcaoCorreta)) {
                System.out.println("Direção incorreta! Tente novamente.");
                continue;
            }

            int passosExecutados = Math.min(passosUsuario, passosRestantes);
            passosExecutados = Math.min(passosExecutados, cargaTotal / consumoPorPasso);

            cargaTotal -= passosExecutados * consumoPorPasso;
            passosRestantes -= passosExecutados;

            System.out.println("Executado: " + passosExecutados + " passo(s) na direção " + direcaoUsuario);
            System.out.println("Bateria restante: " + cargaTotal + " unidade(s)");

            if (passosRestantes == 0) {
                System.out.println("Etapa " + (etapaAtual + 1) + " concluída!");
                etapaAtual++;
                if (etapaAtual < totalEtapas) {
                    passosRestantes = passosGabarito[etapaAtual];
                }
            } else {
                System.out.println("Passos restantes para concluir esta etapa: " + passosRestantes);
            }
        }

        if (etapaAtual == totalEtapas) {
            System.out.println("\nParabéns! Você completou todo o trajeto.");
        } else if (cargaTotal <= 0) {
            System.out.println("\nBateria esgotada! Robô parou na etapa " + (etapaAtual + 1));
        }

        scanner.close();
    }
}

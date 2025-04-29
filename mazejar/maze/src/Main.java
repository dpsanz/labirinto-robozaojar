import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Gabarito
        String[] direcoesGabarito = {"Direita", "Trás", "Direita", "Trás", "Direita", "Frente", "Direita"};
        int[] passosGabarito = {6, 11, 8, 3, 3, 9, 7};

        int quantidadeComandos = direcoesGabarito.length;

        System.out.println("Digite seus comandos corretamente (exemplo: Direita 6):");

        for (int i = 0; i < quantidadeComandos; ) { // Avança só se acertar
            System.out.print("Comando " + (i + 1) + ": ");
            String linha = scanner.nextLine().trim(); // Remove espaços extras
            String[] partes = linha.split("\\s+"); // Divide usando qualquer quantidade de espaço

            if (partes.length != 2) {
                System.out.println("Formato inválido! Use: Direção Passos (ex: Direita 6)");
                continue;
            }

            String direcaoUsuario = partes[0].trim();
            int passosUsuario;

            try {
                passosUsuario = Integer.parseInt(partes[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Número de passos inválido! Tente novamente.");
                continue;
            }

            boolean direcaoCorreta = direcaoUsuario.equalsIgnoreCase(direcoesGabarito[i]);
            boolean passosCorretos = passosUsuario == passosGabarito[i];

            if (direcaoCorreta && passosCorretos) {
                System.out.println("Comando correto!");
                i++; // Só avança se acertar
            } else {
                System.out.println("Comando errado! Tente novamente.");
                // Comentado para deixar mais difícil
                // System.out.println("  Esperado: " + direcoesGabarito[i] + " " + passosGabarito[i]);
            }
        }

        System.out.println("\nParabéns! Você completou todos os comandos corretamente!");
        scanner.close();
    }
}

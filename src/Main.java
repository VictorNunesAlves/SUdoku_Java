import java.util.*;
import java.util.Random;

import static java.util.stream.Collectors.toMap;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Tabuleiro tabuleiroGame;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;
        var continuar = true;
        while(continuar){
            System.out.println("Selecione uma das opções");
            System.out.println("[1] - Iniciar novo Jogo");
            System.out.println("[2] - Colocar novo número");
            System.out.println("[3] - Remover número");
            System.out.println("[4] - Visualizar Jogo Atual");
            System.out.println("[5] - Verificar status do jogo");
            System.out.println("[6] - Limpar jogo");
            System.out.println("[7] - Finalizar jogo");
            System.out.println("[8] - Sair");

            opcao = leiaAteValorValido(1,8);

            switch (opcao){
                case 1:
                    if(nonNull(tabuleiroGame)){
                        System.out.println("O jogo já foi iniciado!");
                        System.out.println("Deseja reiniciar?");
                        System.out.println("[1] - Sim");
                        System.out.println("[2] - Não");
                        if(leiaAteValorValido(1,2) == 2)break;
                    };
                    System.out.println("Escolha uma dificuldade:");
                    System.out.println("[1] - Fácil");
                    System.out.println("[2] - Médio");
                    System.out.println("[3] - Dificil");
                    switch (leiaAteValorValido(1,3)){
                        case 1 : iniciaJogo(1);
                        break;
                        case 2 : iniciaJogo(2);
                        break;
                        case 3 : iniciaJogo(3);
                        break;
                    }
                    imprimirTabuleiro();
                    break;
                case 2:
                    insereNumero();
                    break;
                case 3:
                    removeNumero();
                    break;
                case 4:
                    imprimirTabuleiro();
                    break;
                case 5:
                    verificaStatusJogo();
                    break;
                case 6:
                    System.out.println("Deseja Limpar?");
                    System.out.println("[1] - Sim");
                    System.out.println("[2] - Não");
                    if(leiaAteValorValido(1,2) == 2)break;
                    limparTabuleiro();
                    imprimirTabuleiro();
                    break;
                case 7:
                    terminarJogo();
                    break;
                case 8:
                    continuar =  false;
                    System.out.println("------------ Encerrado ---------------");
                    break;
            }
        }
    }

    private static void iniciaJogo(int dificuldade) {


        List<List<Espaço>> tabuleiro = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            List<Espaço> linha = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                linha.add(new Espaço(0, true));
            }
            tabuleiro.add(linha);
        }

        int chance = 0;
        switch(dificuldade){
            case 1:
                chance = 1;
                break;
            case 2:
                chance = 2;
                break;
            case 3:
                chance = 4;
                break;
        }

        tabuleiroGame = new Tabuleiro(tabuleiro);
        Random random = new Random();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (random.nextInt(10) < chance) {
                    int tentativas = 0;
                    boolean valorAtribuido = false;
                    while (tentativas < 10 && !valorAtribuido) {
                        int valor = random.nextInt(9) + 1;
                        if (tabuleiroGame.verificaSeValorPodeSerIncluido(i, j, valor)) {
                            tabuleiroGame.alteraValor(i, j, valor);
                            tabuleiro.get(i).get(j).setAlteravel(false);
                            valorAtribuido = true;
                        } else {
                            tentativas++;
                        }
                    }
                }
                else {
                    tabuleiroGame.alteraValor(i, j, 0);
                    tabuleiro.get(i).get(j).setAlteravel(true);
                }
            }
        }
    }

    private static void insereNumero(){
        if (isNull(tabuleiroGame)){
            System.out.println("Tabuleiro deve ser iniciado!");
            return;
        }

        imprimirTabuleiro();
            System.out.print("Informe a linha: ");
            int linha = leiaAteValorValido(1,9);
            System.out.print("Informe a Coluna: ");
            int coluna = leiaAteValorValido(1,9);
            System.out.print("Informe o Valor: ");
            int valor = leiaAteValorValido(1,9);
            System.out.println(" ");
            if (!tabuleiroGame.alteraValor(linha - 1, coluna - 1, valor)) {
                System.out.println("Este espaço não pode ser alterado!");
                return;
            } else {
                imprimirTabuleiro();
                return;
        }
    }

    private static void removeNumero(){
        if (isNull(tabuleiroGame)){
            System.out.println("Tabuleiro deve ser iniciado!");
            return;
        }

        imprimirTabuleiro();
        System.out.print("Informe a linha: ");
        int linha = leiaAteValorValido(1,9);
        System.out.print("\n Informe a Coluna: ");
        int coluna = leiaAteValorValido(1,9);
        System.out.println(" ");

        if(!tabuleiroGame.removeValor(linha-1, coluna-1)) {
            System.out.println("Este espaço não pode ser alterado!");
            return;
        }
        else {
            imprimirTabuleiro();
        }
    }

    private static void terminarJogo(){
        if (isNull(tabuleiroGame)){
            System.out.println("Tabuleiro deve ser iniciado!");
            return;
        }
        if(tabuleiroGame.hasZeros()){
            System.out.println("Existem valores a serem preenchidos!");
        }

        List<int[]> valoresErrados = new ArrayList<>(tabuleiroGame.verificaTabuleiro());
        if(!valoresErrados.isEmpty()){
            System.out.println("Existem valores errados!");

        };


    }

    private static void imprimirTabuleiro() {
        if(isNull(tabuleiroGame)){
            System.out.println("Tabuleiro deve ser iniciado!");
            return;
        }
        System.out.println("    1 2 3 | 4 5 6 | 7 8 9");
        System.out.println("   -------+-------+-------");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("  --------+-------+--------");
            }
            System.out.print((i + 1) + " | ");


            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                int valor = tabuleiroGame.getTabuleiro().get(i).get(j).getValor();
                System.out.print((valor == 0 ? "." : valor) + " ");
            }
            System.out.println("|");
        }
        System.out.println();
    }

    public static void verificaStatusJogo(){
        if (isNull(tabuleiroGame)){
            System.out.println("Tabuleiro deve ser iniciado!");
        }

        List<int[]> valoresErrados = new ArrayList<>(tabuleiroGame.verificaTabuleiro());
        if(valoresErrados.isEmpty()){
            System.out.println("Tabuleiro correto");
        }
        else {
            System.out.println("Valores Errados:");
            for (int[] valores : valoresErrados) {
                System.out.println("Linha/Coluna: " + (valores[0] + 1) + "/" + (valores[1] + 1));
            }
        }
    }

    public static void limparTabuleiro(){
        if (isNull(tabuleiroGame)){
            System.out.println("Tabuleiro deve ser iniciado!");
            return;
        }
        tabuleiroGame.limparTabuleiro();
        System.out.println("Tabuleiro limpo!");
    }

    public static int leiaAteValorValido(int i, int j){
        var atual = scanner.nextInt();
        scanner.nextLine();
        while(atual < i || atual > j){
            System.out.println("Informe um número entre "+ i +" e "+ j +"!");
            atual = scanner.nextInt();
        }
        return atual;
    }
}
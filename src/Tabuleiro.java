import java.util.*;

public class Tabuleiro {
    List<List<Espaço>> tabuleiro = Collections.singletonList(new ArrayList<Espaço>());

    public Tabuleiro(List<List<Espaço>> tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public List<List<Espaço>> getTabuleiro() {
        return tabuleiro;
    }

    public boolean alteraValor(int linha, int coluna, int valor) {
        var espaço = tabuleiro.get(linha).get(coluna);
        if (!espaço.getAlteravel()) {
            return false;
        }
        espaço.setValor(valor);
        return true;
    }

    public boolean removeValor(int linha, int coluna) {
        var espaço = tabuleiro.get(linha).get(coluna);
        if (!espaço.getAlteravel()) {
            return false;
        }
        espaço.setValor(0);
        return true;
    }

    public void limparTabuleiro() {
        for (int l = 0; l < 9; l++) {
            for (int c = 0; c < 9; c++) {
                if (tabuleiro.get(l).get(c).getAlteravel()){
                    tabuleiro.get(l).get(c).setValor(0);
                }
            }
        }
    }

    public boolean hasZeros(){
        for (int l = 0; l < 9; l++) {
            for (int c = 0; c < 9; c++) {
                if (tabuleiro.get(l).get(c).getValor() == 0){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean verificaSeValorPodeSerIncluido(int linha, int coluna, int valor) {
        for (int c = 0; c < 9; c++) {
            if (tabuleiro.get(linha).get(c).getValor() == valor) {
                return false;
            }
        }
        for (int l = 0; l < 9; l++) {
            if (tabuleiro.get(l).get(coluna).getValor() == valor) {
                return false;
            }
        }
        int quadranteInicialLinha = (linha / 3) * 3;
        int quadranteInicialColuna = (coluna / 3) * 3;
        for (int l = quadranteInicialLinha; l < quadranteInicialLinha + 3; l++) {
            for (int c = quadranteInicialColuna; c < quadranteInicialColuna + 3; c++) {
                if (tabuleiro.get(l).get(c).getValor() == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<int[]> verificaTabuleiro(){
        List<int[]> erros = new ArrayList<>();
        boolean jaAdicionado = false;
        for (int l = 0; l < 9; l++) {
            for (int c = 0; c < 9; c++) {
                if(tabuleiro.get(l).get(c).getAlteravel() == false) continue;
                jaAdicionado = false;
                if(tabuleiro.get(l).get(c).getValor() == 0){
                    continue;
                }
                for (int j = 0; j < 9; j++) {
                    if (tabuleiro.get(l).get(c).getValor() == tabuleiro.get(j).get(c).getValor() && !jaAdicionado) {
                        if(!(l == j)){
                            erros.add(new int[]{l,c});
                            jaAdicionado = true;
                            continue;
                        }
                    }
                }
                for (int i = 0; i < 9; i++) {
                    if (tabuleiro.get(l).get(c).getValor() == tabuleiro.get(l).get(i).getValor() && !jaAdicionado) {
                        if(!(c == i)){
                            erros.add(new int[]{l,c});
                            jaAdicionado = true;
                            continue;
                        }
                    }
                }

                int quadranteInicialLinha = (l / 3) * 3;
                int quadranteInicialColuna = (c / 3) * 3;
                for (int j = quadranteInicialLinha; j < quadranteInicialLinha + 3; j++) {
                    for (int i = quadranteInicialColuna; i < quadranteInicialColuna + 3; i++) {
                        if (tabuleiro.get(j).get(i).getValor() == tabuleiro.get(l).get(c).getValor() && !jaAdicionado) {
                            if(!(c == i && j == l)){
                                erros.add(new int[]{l,c});
                                jaAdicionado = true;
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return erros;
    }
}
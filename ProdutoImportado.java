
import java.io.ObjectInputStream;

public class ProdutoImportado {
    private String descricao;
    private int origem;
    private int categoria;
    private double valorMercadoria;
    private double valorFrete;
    private boolean usmca; 

    public ProdutoImportado(String descricao, int origem, int categoria, double valorMercadoria, double valorFrete, boolean usmca) {
        this.descricao = descricao;
        this.origem = origem;
        this.categoria = categoria;
        this.valorMercadoria = valorMercadoria;
        this.valorFrete = valorFrete;
        this.usmca = usmca;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getOrigem() {
        return origem;
    }

    public int getCategoria() {
        return categoria;
    }

    public double getValorMercadoria() {
        return valorMercadoria;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public boolean isUsmca() {
        return usmca;
    }

    public String getOrigemTexto() {
        switch (this.origem){
            case 1: return "China";
            case 2: return "União Europeia";
            case 3: return "Japão";
            case 4: return "Coreia do Sul";
            case 5: return "Vietnã";
            case 6: return "Tailândia";
            case 7: return "Canadá";
            case 8: return "México";
            case 9: return "Outros";
            case 10: return "Brasil";
            default: return "Desconhecido";
        }
    }

    public String getCategoriaTexto() {
        switch (this.categoria) {
            case 1: return "Geral";
            case 2: return "Fármacos";
            case 3: return "Semicondutores";
            case 4: return "Cobre";
            case 5: return "Madeira";
            case 6: return "Energia/Minerais";
            case 7: return "Bullion (Metais Preciosos)";
            default: return "Desconhecida";
        }
    }
}
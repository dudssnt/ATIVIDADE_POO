public class Calculadora {
    //CIF no caso é o custo + frete
        public double calcularCIF(ProdutoImportado produto) {
            return produto.getValorMercadoria() + produto.getValorFrete();
        }

        public double determinarAliquota(ProdutoImportado produto) {
        int origem = produto.getOrigem();
        int categoria = produto.getCategoria();

            //priodirdade pra USMCA
            if (origem == 7 || origem == 8) {
            if (produto.isUsmca()) {
                return 0.0;
            } else {
                if (categoria == 6) {
                    return 0.10; // categoria 6 (energia/minerais) e alíquota 10%
                } else {
                    return 0.25; // demais categorias = alíquota 25%
                }
            }
            }  

             // categorias especiais (2 a 7) têm alíquota fixa
            if (categoria >= 2 && categoria <= 7) {
            return 0.10; // alíquota de 10% para todas as categorias especiais
            }

            //categoria 1 (Geral) - alíquota varia por país
            if (categoria == 1) {
            switch (origem) {
                case 1: return 0.34; // China 34%
                case 2: return 0.20; // UE 20%
                case 3: return 0.24; // Japão 24%
                case 4: return 0.26; // Coreia do Sul 26%
                case 5: return 0.46; // Vietnã 46%
                case 6: return 0.37; // Tailândia 37%
                case 10: return 0.10; // Brasil 10%
                case 9: // Outros
                default:
                    return 0.10; // Outros 10%
            }
        }
        return 0.0;
    }

    public double calcularValorImposto(double cif, double aliquota) {
        return cif * aliquota;
}}

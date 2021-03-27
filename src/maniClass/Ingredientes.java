package maniClass;

/*TIPOS
    1 = montagem
    2 = chapa
    3 = rota
    0 = outros
*/



public class Ingredientes {
    String nome;
    int cod;
    int tipo;
    double preCompraPorcao;
    double preVendaPorcao;
    double quantEmEstoque;
    double minimoEstoque;
    double lucro;
    double quantGastaPorcao;
    int vendidos;

    public Ingredientes() {
        nome = null;
        cod = 0;
        preCompraPorcao = 0;
        preVendaPorcao = 0;
        quantEmEstoque= 0;
        minimoEstoque = 0;
        lucro= 0;
        quantGastaPorcao= 0;
        tipo = 0;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getPreCompraPorcao() {
        return preCompraPorcao;
    }

    public void setPreCompraPorcao(double preCompraPorcao) {
        this.preCompraPorcao = preCompraPorcao;
    }

    public double getPreVendaPorcao() {
        return preVendaPorcao;
    }

    public void setPreVendaPorcao(double preVendaPorcao) {
        this.preVendaPorcao = preVendaPorcao;
    }

    public double getQuantEmEstoque() {
        return quantEmEstoque;
    }

    public void setQuantEmEstoque(double quantEmEstoque) {
        this.quantEmEstoque = quantEmEstoque;
    }

    public double getMinimoEstoque() {
        return minimoEstoque;
    }

    public void setMinimoEstoque(double minimoEstoque) {
        this.minimoEstoque = minimoEstoque;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getQuantGastaPorcao() {
        return quantGastaPorcao;
    }

    public void setQuantGastaPorcao(double quantGastaPorcao) {
        this.quantGastaPorcao = quantGastaPorcao;
    }


    
    
}

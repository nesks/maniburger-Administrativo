package maniClass;

import java.util.ArrayList;

public class Lanche{
    String donoPedido;
    String donoLanche;
    double preco;   
    double lucro;
    double troco;
    double valorTaxaExtra;
    double taxaEntrega;
    int id;
    ArrayList< Ingredientes > ingredientes ;
    String taxaExtra;
    int formaPg;
    int numLanchesDaNoite;

    public int getFormaPg() {
        return formaPg;
    }

    public void setFormaPg(int formaPg) {
        this.formaPg = formaPg;
    }
    public String getDonoPedido() {
        return donoPedido;
    }

    public void setDonoPedido(String donoPedido) {
        this.donoPedido = donoPedido;
    }
    public ArrayList<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public String getTaxaExtra() {
        return taxaExtra;
    }

    public void setTaxaExtra(String taxaExtra) {
        this.taxaExtra = taxaExtra;
    }

    public double getValorTaxaExtra() {
        return valorTaxaExtra;
    }

    public void setValorTaxaExtra(double valortaxaExtra) {
        this.valorTaxaExtra = valortaxaExtra;
    }

    public Lanche(String donoLanche, int id, String donoPedido,int numLanchesDaNoite){
        this.donoPedido=donoPedido;
        this.donoLanche = donoLanche;
        this.id = id;
        ingredientes = new ArrayList();
        this.preco = 0;
        this.lucro = 0;
        this.troco = 0;
        this.taxaExtra = null;
        this.valorTaxaExtra = 0;
        this.taxaEntrega = 0;
        this.numLanchesDaNoite = numLanchesDaNoite;
    }
    


    public String getDonoLanche() {
        return donoLanche;
    }

    public void setDonoLanche(String donoLanche) {
        this.donoLanche = donoLanche;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double x) {
        this.troco = x-preco;
    }
    
    public void traduzir(){

    }
    
    
}

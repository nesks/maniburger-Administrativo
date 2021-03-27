package maniClass;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.dao.IngredientesDAO;

public class tradutor2_0 {

    private Cliente x;

    private String nomeHamb;
    private String nome2;
    private String hamburguer;
    private ArrayList<String> ingredientes;
    private ArrayList<Ingredientes> ingre;
    private String chapa;
    private String[] Ing;
    private double precoTotal = 3;
    private PrinterService printerService;
    private String formaPagamento;
    private double troco;
    private double entrega;
    private double desconto;
    private String data;
    private Ingredientes ing;
    String txtIngrediente;
    String txtResumo;
    String txtChapa;
    String txtCompleto;

    public tradutor2_0() {
        nomeHamb = new String();
        nome2 = new String();
        hamburguer = new String();
        ingredientes = new ArrayList<String>();
        ingre = new ArrayList<Ingredientes>();
        String chapa = new String();
        // ing = new
        precoTotal = 3;
        PrinterService printerService = new PrinterService();
        formaPagamento = new String();
        troco = 0;
        entrega = 0;
        desconto = 0;
        data = "";
        ing = new Ingredientes();
        printerService = new PrinterService();

    }

    public ArrayList<Ingredientes> listaIng(String x) {
        //TRANSFORMANDO STRING RECEBIDA EM VALORES PARA PODER TRADUZIR

        hamburguer = x;
        ArrayList<Ingredientes> ingre2 = new ArrayList<Ingredientes>();
        if (hamburguer.split("-").length != 1) {
            Ing = hamburguer.split("-");
        } else if (hamburguer.split(",").length != 1) {
            Ing = hamburguer.split(",");
        } else if (hamburguer.split(".").length != 1) {
            Ing = hamburguer.split(".");
        } else if (hamburguer.split(" ").length != 1) {
            Ing = hamburguer.split(" ");
        }
        ingredientes = new ArrayList();
        for (int i = 0; i < Ing.length; i++) {
            ingredientes.add(Ing[i]);
        }
        printerService = new PrinterService();
        Scanner copia = new Scanner(System.in);
        for (int a = 0; a < ingredientes.size(); a++) {
            IngredientesDAO ingbd = new IngredientesDAO();
            ing = ingbd.readCod(Integer.parseInt(ingredientes.get(a)));
            ingre2.add(ing);
        }
        System.out.println("temos x ingredientes " + ingre2.size());
        ingre = ingre2;
        return ingre2;
    }

    public String traduzTxt(ArrayList<Ingredientes> i) {
        //TRANSFORMA O ARRAY DE INGREDIENTES EM UMA STRING
        txtIngrediente = "\nValor inicial        -  R$3,00\n";
        precoTotal = 3;
        for (int a = 0; a < i.size(); a++) {
            ing = i.get(a);
            txtIngrediente += "" + ing.nome + "   - R$" + ing.preVendaPorcao + "\n";
        }
        return txtIngrediente;
    }

    public Double calculaPreco(Lanche l) {
        precoTotal = 3;
        for (int a = 0; a < l.ingredientes.size(); a++) {
            ing = l.ingredientes.get(a);
            precoTotal += ing.preVendaPorcao;
        }
        precoTotal += l.taxaEntrega + l.valorTaxaExtra;
        System.out.println("" + precoTotal);
        return precoTotal;
    }

    public Double calculaTroco(Double t, Lanche l) {
        double h;
        h = t - l.preco;
        return t;
    }

    public String txtResumo(Lanche l) {
        txtResumo = "\n\n\n\n\n\n";
        txtResumo += "DONO DO LANCHE: " + l.donoLanche + "\n\n";
        txtResumo += traduzTxt(l.ingredientes);
        if (l.valorTaxaExtra != 0) {
            txtResumo += "\n\n" + l.taxaExtra + "= " + l.valorTaxaExtra + "\n\n";
        }
        txtResumo += "\nTAXA DE ENTREGA= " + l.taxaEntrega + "\n\n" + "PRECO TOTAL= " + Double.toString(l.preco);
        txtChapa = "\n\n\n\n\n\n\n";
        txtResumo += "\n\n\n PODERIA ENVIAR A FORMA DE PAGAMENTO ?";
        return txtResumo;
    }

    public String txtChapa(Lanche l) {

        txtChapa = "\n\n\n\n\n\n\n";
        txtChapa += "DONO DO PEDIDO: " + l.donoPedido + "\n\n";
        txtChapa = "PEDIDO: " + l.numLanchesDaNoite + "A\n\n";

        txtChapa += "DONO DO LANCHE: " + l.donoLanche + "\n\n";
        for (int a = 0; a < l.ingredientes.size(); a++) {
            ing = l.ingredientes.get(a);
            System.out.println("" + ing.tipo);
            if (ing.tipo == 1) {
                txtChapa += "" + ing.nome + "  - R$" + ing.preVendaPorcao + "\n";
            }
        }
        txtChapa += "\n\n\n\n\n\n\n";
        return txtChapa;

    }

    public String txtMontagem(Lanche l) {

        txtChapa = "\n\n\n\n\n\n\n";
        txtChapa = "PEDIDO: " + l.numLanchesDaNoite + "A\n\n";
        txtChapa += "DONO DO PEDIDO: " + l.donoPedido + "\n\n";
        txtChapa += "DONO DO LANCHE: " + l.donoLanche + "\n\n+     -----CHAPA-----\n";
        for (int a = 0; a < l.ingredientes.size(); a++) {
            ing = l.ingredientes.get(a);
            System.out.println("" + ing.tipo);
            if (ing.tipo == 1) {
                System.out.println("ing add:" + ing.tipo);
                txtChapa += "" + ing.nome + "  - R$" + ing.preVendaPorcao + "\n";
            }
        }
        txtChapa += "\n\n     ----MONTAGEM----\n";
        for (int a = 0; a < l.ingredientes.size(); a++) {
            ing = l.ingredientes.get(a);
            System.out.println("" + ing.tipo);
            if (ing.tipo == 2) {
                txtChapa += "" + ing.nome + "  - R$" + ing.preVendaPorcao + "\n";
            }
        }
        txtChapa += "\n\n     -----OUTROS-----\n";
        for (int a = 0; a < l.ingredientes.size(); a++) {
            ing = l.ingredientes.get(a);
            System.out.println("" + ing.tipo);
            if (ing.tipo == 0) {
                txtChapa += "" + ing.nome + "  - R$" + ing.preVendaPorcao + "\n";
            }
        }
        
                txtChapa += "\n\n     -----ROTA-----\n";
        for (int a = 0; a < l.ingredientes.size(); a++) {
            ing = l.ingredientes.get(a);
            System.out.println("" + ing.tipo);
            if (ing.tipo == 3) {
                txtChapa += "" + ing.nome + "  - R$" + ing.preVendaPorcao + "\n";
            }
        }
        
        txtChapa += "\n\n\n\n\n\n\n";
        System.out.println(txtChapa);
        return txtChapa;
        
    }

    public String txtCompleto(Lanche l) {
        DecimalFormat df = new DecimalFormat("0.##");

        txtCompleto = "\n\n\n\n\n\n";
        txtCompleto += "      MANIBURGER DELIVERY \n\n\n";
        txtCompleto += "DONO DO PEDIDO: " + l.donoPedido + "\n\n";
        txtCompleto += "DONO DO LANCHE: " + l.donoLanche + "\n\n";
        txtCompleto += traduzTxt(l.ingredientes) + "\n\n";
        if (l.valorTaxaExtra != 0) {
            txtCompleto += "" + l.taxaExtra + ": R$" + l.valorTaxaExtra + "\n\n";
        }
        txtCompleto += "TAXA DE ENTREGA: R$" + l.taxaEntrega + "\n\n" + "PRECO TOTAL: R$" + df.format(l.preco);
        if ("Dinheiro".equals(l.formaPg)) {
            txtCompleto += "\n\nTROCO: R$" + df.format(l.troco);
        }
        txtCompleto += "\n\nFORMA DE PAGAMENTO: " + l.formaPg;
        txtCompleto += "\n\n\n\n AGRADECEMOS PELA PREFERENCIA!";
        txtCompleto += "\n\n\n\n\n\n\n\n\n\n";
        return txtCompleto;
    }

    public void impressora(String x) {
        printerService.printString("POS58 10.0.0.6", x);
    }

}

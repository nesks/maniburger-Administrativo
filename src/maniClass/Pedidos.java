package maniClass;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Pedidos {

    int codPedido;
    String nomeCliente;
    String endereco;
    ArrayList< Lanche> lanches;
    String horario;
    String rota;

    public Pedidos(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.endereco = "";
        this.lanches = new ArrayList();
    }

    public void addLanche(Lanche l) {
        lanches.add(l);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Lanche> getLanches() {
        return lanches;
    }

    public void setLanches(ArrayList<Lanche> lanches) {
        this.lanches = lanches;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        horario = sdf.format(new java.util.Date());
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }
}

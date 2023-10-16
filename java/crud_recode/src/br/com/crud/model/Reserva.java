package br.com.crud.model;

 
 
public class Reserva {

	
    private int id_reserva;
    private String origem;
    private String destino;
    private String data_de_ida;
    private String data_de_volta;
    private double preco;
    

    // Getters e setters  
    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
    
    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData_de_ida() {
        return data_de_ida;
    }

    public void setData_de_ida(String data_de_ida) {
        this.data_de_ida = data_de_ida;
    }

    public String getData_de_volta() {
        return data_de_volta;
    }

    public void setData_de_volta(String data_de_volta) {
        this.data_de_volta = data_de_volta;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}

package br.com.crud.model;

 
 
public class Passagem {

	
    private int id_passagem;
    private String destino;
    private String data_de_ida;
    private String data_de_volta;
    private String empresa;
    private String horario_da_ida;
    private String horario_da_volta;

    // Getters e setters  
    public int getId_passagem() {
        return id_passagem;
    }

    public void setId_passagem(int id_passagem) {
        this.id_passagem = id_passagem;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getHorario_da_ida() {
        return horario_da_ida;
    }

    public void setHorario_da_ida(String horario_da_ida) {
        this.horario_da_ida = horario_da_ida;
    }

    public String getHorario_da_volta() {
        return horario_da_volta;
    }

    public void setHorario_da_volta(String horario_da_volta) {
        this.horario_da_volta = horario_da_volta;
    }
}

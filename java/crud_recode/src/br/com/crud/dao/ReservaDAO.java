package br.com.crud.dao;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public void save(Reserva reserva) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.creatConnectionToMySQL();
            String sql = "INSERT INTO reserva(origem, destino,  data_de_ida, data_de_volta, preco) VALUES (?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, reserva.getOrigem());
            pstm.setString(2, reserva.getDestino());
            pstm.setString(3, reserva.getData_de_ida());
            pstm.setString(4, reserva.getData_de_volta());
            pstm.setDouble(5, reserva.getPreco());
 
     

            pstm.execute();
            System.out.println("Passagem salva com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByID(int id_reserva) {
        String sql = "DELETE FROM reserva WHERE id_reserva = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.creatConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_reserva);
            pstm.execute();
            System.out.println("Reserva deletada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Reserva> getReservas() {
        String sql = "SELECT * FROM reserva";
        List<Reserva> reservas = new ArrayList<Reserva>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.creatConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Reserva reserva = new Reserva();
                reserva.setId_reserva(rset.getInt("id_reserva"));
                reserva.setOrigem(rset.getString("origem")); 
                reserva.setDestino(rset.getString("destino"));
                reserva.setData_de_ida(rset.getString("data_de_ida"));
                reserva.setData_de_volta(rset.getString("data_de_volta"));
                double preco = rset.getDouble("preco");
                reserva.setPreco(preco);
                reservas.add(reserva);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return reservas;
    }

    public void update(Reserva reserva) {
    	String sql = "UPDATE reserva SET origem = ?, destino=?, data_de_ida = ?, data_de_volta = ?, preco = ? WHERE id_reserva = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.creatConnectionToMySQL();
            pstm = conn.prepareStatement(sql);


            pstm.setString(1, reserva.getOrigem());
            pstm.setString(2, reserva.getDestino());
            pstm.setString(3, reserva.getData_de_ida());
            pstm.setString(4, reserva.getData_de_volta());
            pstm.setDouble(5, reserva.getPreco());
            pstm.setInt(6, reserva.getId_reserva());  
            
            
            
            
            pstm.execute();
            System.out.println("Reserva atualizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

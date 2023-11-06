package br.com.crud.dao;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Passagem;
 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PassagemDAO {

	public void save(Passagem passagem) {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.creatConnectionToMySQL();
			String sql = "INSERT INTO passagem(destino, data_de_ida, data_de_volta, empresa, horario_da_ida, horario_da_volta) VALUES (?, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getDestino());
			pstm.setString(2, passagem.getData_de_ida());
			pstm.setString(3, passagem.getData_de_volta());
			pstm.setString(4, passagem.getEmpresa());
			pstm.setString(5, passagem.getHorario_da_ida());
			pstm.setString(6, passagem.getHorario_da_volta());

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

	public void deleteByID(int id_passagem) {
		String sql = "DELETE FROM passagem WHERE id_passagem = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.creatConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_passagem);
			pstm.execute();
			System.out.println("Passagem deletada com sucesso!");
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

	public List<Passagem> read() {
		String sql = "SELECT * FROM passagem";
		List<Passagem> passagens = new ArrayList<Passagem>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.creatConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Passagem passagem = new Passagem();
				passagem.setId_passagem(rset.getInt("id_passagem"));
				passagem.setDestino(rset.getString("destino"));
				passagem.setData_de_ida(rset.getString("data_de_ida"));
				passagem.setData_de_volta(rset.getString("data_de_volta"));
				passagem.setEmpresa(rset.getString("empresa"));
				passagem.setHorario_da_ida(rset.getString("horario_da_ida"));
				passagem.setHorario_da_volta(rset.getString("horario_da_volta"));
				
				
				
				System.out.println("ID da Passagem: " + passagem.getId_passagem());
	            System.out.println("Destino: " + passagem.getDestino());
	            System.out.println("Data de Ida: " + passagem.getData_de_ida());
	            System.out.println("Data de Volta: " + passagem.getData_de_volta());
	            System.out.println("Empresa: " + passagem.getEmpresa());
	            System.out.println("Horário de Ida: " + passagem.getHorario_da_ida());
	            System.out.println("Horário de Volta: " + passagem.getHorario_da_volta());

	            

				passagens.add(passagem);
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
		return passagens;
	}

	public Passagem readById(int id) {
		String sql = "SELECT * FROM passagem WHERE id_passagem = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.creatConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			if (rset.next()) {

				Passagem passagem = new Passagem();
				passagem.setId_passagem(rset.getInt("id_passagem"));
				passagem.setDestino(rset.getString("destino"));
				passagem.setData_de_ida(rset.getString("data_de_ida"));
				passagem.setData_de_volta(rset.getString("data_de_volta"));
				passagem.setEmpresa(rset.getString("empresa"));
				passagem.setHorario_da_ida(rset.getString("horario_da_ida"));
				passagem.setHorario_da_volta(rset.getString("horario_da_volta"));

	
				
				
				return passagem;

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
		return null;
	}

	public void update(Passagem passagem) {
		String sql = "UPDATE passagem SET destino = ?, data_de_ida = ?, data_de_volta = ?, empresa = ?, horario_da_ida = ?, horario_da_volta = ? WHERE id_passagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.creatConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getDestino());
			pstm.setString(2, passagem.getData_de_ida());
			pstm.setString(3, passagem.getData_de_volta());
			pstm.setString(4, passagem.getEmpresa());
			pstm.setString(5, passagem.getHorario_da_ida());
			pstm.setString(6, passagem.getHorario_da_volta());
			pstm.setInt(7, passagem.getId_passagem());

			pstm.execute();
			System.out.println("Passagem atualizada com sucesso!");
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

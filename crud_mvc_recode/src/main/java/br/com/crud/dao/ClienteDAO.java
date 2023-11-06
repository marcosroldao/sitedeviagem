package br.com.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Cliente;

public class ClienteDAO {

	public void save(Cliente cliente) {
		String sql = "INSERT INTO cliente(NomeCompleto, endereco, cep, cpf, e_mail, senha, telefone, dataCadastro) VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
		String cpfExistQuery = "SELECT COUNT(*) FROM cliente WHERE cpf = ?";
		String emailExistQuery = "SELECT COUNT(*) FROM cliente WHERE e_mail = ?";
		String telefoneExistQuery = "SELECT COUNT(*) FROM cliente WHERE telefone = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		PreparedStatement cpfExistStmt = null;
		PreparedStatement emailExistStmt = null;
		PreparedStatement telefoneExistStmt = null;

		try {
			conn = ConnectionFactory.creatConnectionToMySQL();

			// Verificar se o CPF já existe no banco
			cpfExistStmt = conn.prepareStatement(cpfExistQuery);
			cpfExistStmt.setString(1, cliente.getCpf());
			ResultSet cpfResult = cpfExistStmt.executeQuery();

			if (cpfResult.next() && cpfResult.getInt(1) > 0) {
				System.out.println("Cliente com o mesmo CPF já existe. Não foi possível salvar.");
				return; // Não insere o cliente
			}

			// Verificar se o e-mail já existe no banco
			emailExistStmt = conn.prepareStatement(emailExistQuery);
			emailExistStmt.setString(1, cliente.getE_mail());
			ResultSet emailResult = emailExistStmt.executeQuery();

			if (emailResult.next() && emailResult.getInt(1) > 0) {
				System.out.println("Cliente com o mesmo e-mail já existe. Não foi possível salvar.");
				return; // Não insere o cliente
			}

			// Verificar se o telefone já existe no banco
			telefoneExistStmt = conn.prepareStatement(telefoneExistQuery);
			telefoneExistStmt.setString(1, cliente.getTelefone());
			ResultSet telefoneResult = telefoneExistStmt.executeQuery();

			if (telefoneResult.next() && telefoneResult.getInt(1) > 0) {
				System.out.println("Cliente com o mesmo telefone já existe. Não foi possível salvar.");
				return; // Não insere o cliente
			}

			// Se o CPF e o e-mail não existem, prossegue com a inserção
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNomeCompleto());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getCep());
			pstm.setString(4, cliente.getCpf());
			pstm.setString(5, cliente.getE_mail());
			pstm.setString(6, cliente.getSenha());
			pstm.setString(7, cliente.getTelefone());
			pstm.setDate(8, new Date(cliente.getdataCadastro().getTime()));

			pstm.execute();
			System.out.println("Contato salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (cpfExistStmt != null) {
					cpfExistStmt.close();
				}
				if (emailExistStmt != null) {
					emailExistStmt.close();
				}
				if (telefoneExistStmt != null) {
					telefoneExistStmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteByID(int id_cliente) {
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.creatConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_cliente);
			pstm.execute();
			System.out.println("Contato deletado com sucesso!");
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

	public List<Cliente> read() {
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.creatConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(rset.getInt("id_cliente"));
				cliente.setNomeCompleto(rset.getString("NomeCompleto"));
				cliente.setEndereco(rset.getString("endereco"));
				cliente.setCep(rset.getString("cep"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setE_mail(rset.getString("e_mail"));
				cliente.setSenha(rset.getString("senha"));
				cliente.setTelefone(rset.getString("telefone"));
				cliente.setdataCadastro(rset.getDate("dataCadastro")); // verificar
				clientes.add(cliente);
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
		return clientes;
	}

	
	public Cliente readById(int id) {
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.creatConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			if (rset.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(rset.getInt("id_cliente"));
				cliente.setNomeCompleto(rset.getString("NomeCompleto"));
				cliente.setEndereco(rset.getString("endereco"));
				cliente.setCep(rset.getString("cep"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setE_mail(rset.getString("e_mail"));
				cliente.setSenha(rset.getString("senha"));
				cliente.setTelefone(rset.getString("telefone"));
				cliente.setdataCadastro(rset.getDate("dataCadastro"));
				return cliente;
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



	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET NomeCompleto = ?, endereco = ?, cep = ?, cpf = ?, e_mail = ?, senha = ?, telefone = ?, dataCadastro = ? WHERE id_cliente = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.creatConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// Adicionar valores para atualizar
			pstm.setString(1, cliente.getNomeCompleto());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getCep());
			pstm.setString(4, cliente.getCpf());
			pstm.setString(5, cliente.getE_mail());
			pstm.setString(6, cliente.getSenha());
			pstm.setString(7, cliente.getTelefone());
			pstm.setDate(8, new Date(cliente.getdataCadastro().getTime()));

			pstm.setInt(9, cliente.getId_cliente()); // id do registro a atualizar

			pstm.execute();
			System.out.println("Contato atualizado com sucesso!");
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

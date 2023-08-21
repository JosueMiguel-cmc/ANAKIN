package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import VO.ControleSessaoVO;

//precisa de modificação com fk do user
public class ControleSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;
	ResultSet rs;
	ArrayList<ControleSessaoVO> lista = new ArrayList<>();
	
	public void salvarInformacoes(ControleSessaoVO controle) {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into controle_sessao (nome_sessao, inventario_sessao, anotacoes_sessao) values (?,?,?)";
		try {

			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, controle.getNome_sessao());
			PSTM.setString(2, controle.getInventario_sessao());
			PSTM.setString(3, controle.getAnotacoes_sessao());
			PSTM.execute();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ControleSessaoDAO: " + erro);
		}	
	}
	public ArrayList<ControleSessaoVO> ListasSessoes(ControleSessaoVO objSessao){
		conn = new ConexaoDAO().conectabd();
		String sql = "selet nome_sessao from controle_sessao";
		try {
			PSTM = conn.prepareStatement(sql);
			rs =PSTM.executeQuery(sql);
			while(rs.next()){
				ControleSessaoVO objnomesessao = new ControleSessaoVO();
				objnomesessao.setNome_sessao("nome_sessao");
				lista.add(objnomesessao);
			}
		} catch (SQLException e) {
			
		}
		return lista;
		
		
	}
}
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import VO.UsuarioVO;

public class LoginDAO {
	Connection conn;
	PreparedStatement PSTM;
	
	public ResultSet autenticaUsuario(UsuarioVO autent) {
		conn = new ConexaoDAO().conectabd();
		try {
			String SQL = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
			PreparedStatement pstm = conn.prepareStatement(SQL);
			pstm.setString(1, autent.getNome_usuario());
			pstm.setString(2, autent.getSenha_usuario());
			ResultSet rs = pstm.executeQuery();
			return rs;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "LoginDAO: " + erro);
			return null;
		}

	}

}
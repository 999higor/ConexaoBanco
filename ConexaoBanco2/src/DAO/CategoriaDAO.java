package DAO;

import persistencia.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CategoriaDAO 
{

    public boolean inserir(String nome) 
    {
        String sql = "INSERT INTO categoria(nome) VALUES (?)";//define instrução SQL
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);//prepara instrução SQL
            ps.setString(1, nome);// primeiro parâmetro indica a ? correspondente, segundo parâmetro a variável que substituirá a ?
            ps.execute(); //executa SQL preparada
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) 
    {
        //crie um objeto da classe 
        CategoriaDAO dao = new CategoriaDAO();
        //chame o método inserir desse objeto
        boolean result = dao.inserir("Drama");
        if (result) 
        {
            JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Problemas com a inserção!");
        }
    }

    public boolean inserir(JTextField jtfnome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package projetointegrador.dao;

import java.awt.HeadlessException;
import java.awt.TrayIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projetointegrador.jdbc.ConnectionFactory;
import projetointegrador.model.Cliente;
import java.sql.ResultSet;

public class ClienteDAO {
    private Connection conexao;
    
    public ClienteDAO(){
        this.conexao = ConnectionFactory.getConnection(); 
    }
    
    public void cadastrarCliente(Cliente objCliente){
        try {
            String sql = "insert into Cliente(Nome_Cliente,Email,Cpf_Cliente,Telefone_Cliente) VALUES(?,?,?,?)";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, objCliente.getNome_Cliente());
            comando.setString(2, objCliente.getEmail());
            comando.setString(3, objCliente.getCpf_Cliente());
            comando.setString(4, objCliente.getTelefone_Cliente());
            
            comando.execute();
            comando.close();

            //Pegar o id gerado pelo banco de dados através do CPF
            sql = "SELECT Id_Cliente FROM cliente WHERE Cpf_Cliente = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, objCliente.getCpf_Cliente());
            
             //Com o comando preparado, executo o comando;
             //Esse comando é de leitura do BD, logo ele retorna um resultSet
             ResultSet rs = comando.executeQuery();
            
            //Percorro o resultado até achar o campo "ID" 
            while(rs.next()){
                objCliente.setId_Cliente(rs.getInt("Id_Cliente"));
            }
            JOptionPane.showMessageDialog(null, "Cadastro de cliente realizado com sucesso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public List<Cliente> listarCliente(){
        try {
            List<Cliente> listaCliente = new ArrayList<>();
            
            String sql = "SELECT * FROM Cliente";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Cliente obj = new Cliente();
                
                obj.setId_Cliente(rs.getInt("Id_Cliente"));
                obj.setNome_Cliente(rs.getString("Nome_Cliente"));
                obj.setEmail(rs.getString("Email"));
                obj.setCpf_Cliente(rs.getString("Cpf_Cliente"));
                obj.setTelefone_Cliente(rs.getString("Telefone_Cliente"));
                
                listaCliente.add(obj);
            }        
            return listaCliente;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    
    public void excluirCliente(Cliente objCliente){
        try {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente?","Excluir",JOptionPane.OK_CANCEL_OPTION);
            
            if(opcao == 0){
            String sql = "DELETE FROM cliente WHERE Id_Cliente = ?";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, objCliente.getId_Cliente());
           
            comando.execute();
            comando.close();
            
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void atualizarCliente(Cliente objCliente){
        try {
            
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja atualizar o cliente?","Excluir",JOptionPane.OK_CANCEL_OPTION);
            
            if(opcao == 0){
                String sql = "UPDATE Cliente SET Nome_Cliente = ?, Email =? ,Cpf_Cliente =?,Telefone_Cliente=? WHERE Id_Cliente = ?";

                PreparedStatement comando = conexao.prepareStatement(sql);

                comando.setString(1, objCliente.getNome_Cliente());
                comando.setString(2, objCliente.getEmail());
                comando.setString(3, objCliente.getCpf_Cliente());
                comando.setString(4, objCliente.getTelefone_Cliente());
                comando.setInt(5, objCliente.getId_Cliente());

                comando.execute();
                comando.close();

                JOptionPane.showMessageDialog(null, "Cadastro de cliente atualizado com sucesso");
            }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
    public List<Cliente> buscarCliente(String valorDeBusca){
        try {
            List<Cliente> listaCliente = new ArrayList<>();
            
            String sql = "SELECT * FROM Cliente WHERE CONCAT_WS(Id_Cliente,Nome_Cliente,Email,Cpf_Cliente,Telefone_Cliente) LIKE ?";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, "%"+valorDeBusca+"%");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Cliente obj = new Cliente();
                
                obj.setId_Cliente(rs.getInt("Id_Cliente"));
                obj.setNome_Cliente(rs.getString("Nome_Cliente"));
                obj.setEmail(rs.getString("Email"));
                obj.setCpf_Cliente(rs.getString("Cpf_Cliente"));
                obj.setTelefone_Cliente(rs.getString("Telefone_Cliente"));
                
                listaCliente.add(obj);
            }        
            return listaCliente;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

};
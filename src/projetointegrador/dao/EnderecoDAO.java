package projetointegrador.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetointegrador.jdbc.ConnectionFactory;
import projetointegrador.model.Endereco;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
//import projetointegrador.model.Endereco;

public class EnderecoDAO {
    //Atributos
    private Connection conexao;
    //Construtor
    public EnderecoDAO(){
        //Conexão com o Banco de Dados
        this.conexao = ConnectionFactory.getConnection();
    }
    
    //Métodos
    //Método para cadastrar os endereços - public boolean
    public void cadastrarEndereco(Endereco objEndereco){
        try {
            
            final String sql = "insert into Endereco(Rua,Numero,Complemento,Bairro,Cidade,UF,CEP,Id_Cliente) values(?,?,?,?,?,?,?,?)";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, objEndereco.getRua());
            comando.setInt(2, objEndereco.getNumero());
            comando.setString(3, objEndereco.getComplemento());
            comando.setString(4, objEndereco.getBairro());
            comando.setString(5, objEndereco.getCidade());
            comando.setString(6, objEndereco.getUF());
            comando.setString(7, objEndereco.getCEP());
            comando.setInt(8, objEndereco.getCliente().getId_Cliente());
            
            //Executar o comando e fechar a conexao
            comando.execute();
            comando.close();
            
            //Mensagem de Cadastro realizado
            JOptionPane.showMessageDialog(null, "Cadastro de endereço efetuado com sucesso");
                    
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //DAO = Util
    public List<Endereco> listarEndereco(){
        try {
            //Criar lista para armazenar os endereços
            List<Endereco> listaEndereco = new ArrayList<>();
            
            //Criar o comando sql que seleciona todos os itens da tabela de endereço
            //Pode particionar criando uma varíavel de soma em etapas
            String sql = "select * from endereco";
            
            //Preparar o comando colocando a conexao que será utilizada para executa-lo
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            //Quando usamos JDBC, o resultado de um comando select precisa ser armazenado em um objeto do tipo ResultSet
            //Executa e retorna seu objetivo
            ResultSet rs = comando.executeQuery();
            //System.out.println("Result set: " + rs);
            
            //Criar um laço de repetição para adicionar os itens do resultset na lista criada no passo 1
            while(rs.next()){
                Endereco obj = new Endereco();
                
                obj.setId(rs.getInt("id_Endereco"));
                obj.setCEP(rs.getString("cep"));
                obj.setRua(rs.getString("rua"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("Complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("Cidade"));
                
                //System.out.println("Objeto: " + obj);
                
                //Após todos os atributos serem inseridos dentro do objeto preciso adicionar esse objeto na minha lista de endereços
                listaEndereco.add(obj);
            }
            //System.out.println("Lista: " + listaEndereco);
            return listaEndereco;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;      
        } 
    }
}

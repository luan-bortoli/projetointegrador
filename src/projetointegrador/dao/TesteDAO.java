package projetointegrador.dao;

import projetointegrador.model.Cliente;
//import projetointegrador.model.Endereco;

public class TesteDAO {
    public static void main(String[] args) {
        Cliente clienteTeste = new Cliente();
        clienteTeste.setCpf_Cliente("123.456.890-00");
        clienteTeste.setNome_Cliente("João Silva");
        clienteTeste.setEmail("joao@email.com");
        clienteTeste.setTelefone_Cliente("(99)99999-9090");
        
        System.out.println(clienteTeste.getId_Cliente());
        
        ClienteDAO dao = new ClienteDAO();
        dao.cadastrarCliente(clienteTeste);
        
        System.out.println(clienteTeste.getId_Cliente());
//        
//
//        //Teste Cadastro Endereço
//        Endereco enderecoTeste = new Endereco();
//        
//        enderecoTeste.setCEP("99999-99");
//        enderecoTeste.setRua("Rua sem nome");
//        enderecoTeste.setNumero(888);
//        enderecoTeste.setComplemento("D");
//        enderecoTeste.setBairro("Centro");
//        enderecoTeste.setCidade("Chapecó");
//        enderecoTeste.setUF("SC");
//       
//        EnderecoDAO dao = new EnderecoDAO();
//        dao.cadastrarEndereco(enderecoTeste);

       //Teste do Listar Endereço
//       EnderecoDAO dao = new EnderecoDAO();
//       dao.listarEndereco();
    }
}

package projetointegrador.jdbc;

import javax.swing.JOptionPane;

public class TestaConexao {
    public static void main(String[] args){
        try {
            ConnectionFactory.getConnection();
            JOptionPane.showMessageDialog(null, "Conexão criada com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}

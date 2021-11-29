
package projetointegrador.model;

public class Cliente {
    private int Id_Cliente;
    private String Nome_Cliente;
    private String Email;
    private String Cpf_Cliente;
    private String Telefone_Cliente;
    
    //Getters e Settes
    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public String getNome_Cliente() {
        return Nome_Cliente;
    }

    public void setNome_Cliente(String Nome_Cliente) {
        this.Nome_Cliente = Nome_Cliente;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCpf_Cliente() {
        return Cpf_Cliente;
    }

    public void setCpf_Cliente(String Cpf_Cliente) {
        this.Cpf_Cliente = Cpf_Cliente;
    }

    public String getTelefone_Cliente() {
        return Telefone_Cliente;
    }

    public void setTelefone_Cliente(String Telefone_Cliente) {
        this.Telefone_Cliente = Telefone_Cliente;
    }

    
}

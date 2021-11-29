package projetointegrador.utilitarios;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilitarios {
    public static void limpar(JPanel painel){
        Component components[] = painel.getComponents();
        for (Component componente : components){
            if(componente instanceof JTextField){
               ((JTextField)componente).setText(null); 
            }
        }
    }
}

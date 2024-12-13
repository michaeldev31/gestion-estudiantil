package com.mycompany.sdge.controlador.entrar;


import com.mycompany.sdge.vistas.entrar.Login;
import com.mycompany.sdge.vistas.entrar.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlLogin implements ActionListener {

    Login log;

    public ControlLogin(Login flog) {
        log = flog;
        log.btnAcceder.addActionListener(this);
        log.setTitle("Login del sistema");
        log.setVisible(true);
        log.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (log.btnAcceder == e.getSource()) {
            boolean mostrar=true;
            if(log.txtUsuario.getText().isEmpty()  ){
                    Mostrar("Nombre de usario o contraseña vacio");
                    mostrar=false;
            }

            if (log.txtUsuario.getText().equals("admin") && log.txtContraseña.getText().equals("admin")) {
                    Menu men = new Menu();
                    ControlMenu cm = new ControlMenu(men);
                    men.setVisible(true);
                    String usu = log.txtUsuario.getText();
                    men.setTitle(usu.toUpperCase()+" : Menu del colegio");
                    log.setVisible(false);
                    mostrar=false;
             }

            if(mostrar){
               Mostrar("No existe el nombre o contraseña");
            }

        }
    }

    private void Mostrar(String msj) {
        //JOptionPane.showMessageDialog(null, msj);
        JOptionPane.showMessageDialog(null, msj, "ERROR", 0);
    }    

}

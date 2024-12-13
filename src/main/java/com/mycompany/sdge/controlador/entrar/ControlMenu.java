/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sdge.controlador.entrar;

import com.mycompany.sdge.vistas.entrar.Menu;
import com.mycompany.sdge.vistas.subAsig.VistaAsignatura;
import com.mycompany.sdge.vistas.subGE.EstudianteViewImpl;
import com.mycompany.sdge.vistas.subGE.VistaEstudiante;
import com.mycompany.sdge.vistas.subGP.VistaProfesor;
import com.mycompany.sdge.vistas.subRAC.VistaRecurso;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class ControlMenu implements ActionListener {

    Menu men;
    private Component originalContent2;  // Variable para guardar el contenido original

    public ControlMenu(Menu me) {
        men = me;
        men.setTitle("Menu del sistema");
        men.setVisible(true);
        men.btnAlumno.addActionListener(this);
        men.btnProfesor.addActionListener(this);
        men.btnRecursos.addActionListener(this);
        men.btnAsignatura.addActionListener(this);
        men.setLocationRelativeTo(null);
        // Guardar el componente original de dpsPrueba
        originalContent2 = men.dpsPrueba.getComponent(0);
    }

    private void MostrarFrame(JFrame frame) {
        men.dpsPrueba.removeAll();
        men.dpsPrueba.setLayout(new java.awt.BorderLayout());

        // Extraer el contenido del JFrame
        JPanel contenido = new JPanel(new BorderLayout());
        contenido.add(frame.getContentPane());

        // Añadir el contenido del JFrame al JPanel contenedor
        men.dpsPrueba.add(contenido, BorderLayout.CENTER);
        men.dpsPrueba.revalidate();
        men.dpsPrueba.repaint();

        // Opcional: Ocultar el JFrame para evitar confusión
        frame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == men.btnAlumno) {
            VistaEstudiante vistaEstudiante = new VistaEstudiante();
            MostrarFrame(vistaEstudiante);
        }

        if (e.getSource() == men.btnProfesor) {
            //el frame del profesor
            VistaProfesor vistaProfesor = new VistaProfesor();
            MostrarFrame(vistaProfesor);

        }
        if (e.getSource() == men.btnAsignatura) {
            //el frame de la asignatura
            VistaAsignatura vistaAsignatura = new VistaAsignatura();
            MostrarFrame(vistaAsignatura);
        }
        if (e.getSource() == men.btnRecursos) {
            //el frame de los recursos
            if (e.getSource() == men.btnRecursos) {
                try {
                    // el frame de los recursos
                    VistaRecurso vistaRecurso = new VistaRecurso();
                    MostrarFrame(vistaRecurso);
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Imprime el error en consola para depurar
                    JOptionPane.showMessageDialog(null, "Error al cargar los recursos: " + ex.getMessage());
                }
            }

        }

    }

}

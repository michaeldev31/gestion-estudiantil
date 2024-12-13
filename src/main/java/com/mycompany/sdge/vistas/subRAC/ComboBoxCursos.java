
package com.mycompany.sdge.vistas.subRAC;

import com.mycompany.sdge.modelo.recursoEducativo.recursosEducativosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class ComboBoxCursos {
    private JComboBox<String> comboBox;
    private recursosEducativosDAO recuDAO;
    
    public ComboBoxCursos(JComboBox<String> comboBox){
        this.comboBox = comboBox;
        this.recuDAO = new recursosEducativosDAO();
    }
    
    public void cargarCursos() throws SQLException{
        comboBox.removeAllItems();
        ArrayList<String> cursos = recuDAO.obtenerCursos();
        for (String curso : cursos){
            comboBox.addItem(curso);
        }
    }
}

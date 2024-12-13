
package com.mycompany.sdge.vistas.subGE;


import com.mycompany.sdge.controlador.subGE.EstudianteController;
import com.mycompany.sdge.modelo.estudiante.estudiante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EstudianteViewImpl extends JFrame implements EstudianteView {
    private JTextField tfId, tfDni, tfNombre, tfApellido, tfEmail, tfGrado, tfPromedio;
    private JButton btnAgregar, btnActualizar, btnEliminar, btnBuscar;
    private JTextArea taEstudiantes;
    private JTable tableEstudiantes;
    private DefaultTableModel tableModel;
    
    public EstudianteViewImpl() {
        
        
        setTitle("Gestión de Estudiantes");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        JLabel labelId = new JLabel("ID:");
        tfId = new JTextField();
        panel.add(labelId);
        panel.add(tfId);

        JLabel labelDni = new JLabel("DNI:");
        tfDni = new JTextField();
        panel.add(labelDni);
        panel.add(tfDni);

        JLabel labelNombre = new JLabel("Nombre:");
        tfNombre = new JTextField();
        panel.add(labelNombre);
        panel.add(tfNombre);

        JLabel labelApellido = new JLabel("Apellido:");
        tfApellido = new JTextField();
        panel.add(labelApellido);
        panel.add(tfApellido);

        JLabel labelEmail = new JLabel("Email:");
        tfEmail = new JTextField();
        panel.add(labelEmail);
        panel.add(tfEmail);

        JLabel labelGrado = new JLabel("Grado:");
        tfGrado = new JTextField();
        panel.add(labelGrado);
        panel.add(tfGrado);

        JLabel labelPromedio = new JLabel("Promedio:");
        tfPromedio = new JTextField();
        panel.add(labelPromedio);
        panel.add(tfPromedio);

        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");
        
        panel.add(btnAgregar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);

        

        taEstudiantes = new JTextArea();
        taEstudiantes.setEditable(false);
        taEstudiantes.setRows(5);
        taEstudiantes.setColumns(30);
        JScrollPane scrollPane = new JScrollPane(taEstudiantes);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Apellido", "DNI", "Email", "Grado", "Promedio"}, 0);
        tableEstudiantes = new JTable(tableModel);
        JScrollPane scrollPane1 = new JScrollPane(tableEstudiantes);
        add(scrollPane1, BorderLayout.CENTER);
        
        
        
        // Cargar estudiantes en la tabla al iniciar la vista
        actualizarTabla();
        
        // Eventos de los botones
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos del estudiante desde los campos de texto
                estudiante nuevoEstudiante = obtenerDatosEstudiante(); // Se crea la variable nuevoEstudiante

                // Crear el controlador y agregar el estudiante
                EstudianteController estudianteController = new EstudianteController();
                estudianteController.agregarEstudiante(nuevoEstudiante); // Llamar al controlador para agregar
                actualizarTabla();
                // Mostrar mensaje de éxito
                mostrarMensaje("Estudiante agregado: " + nuevoEstudiante.getNombre());
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar estudiante
                /*estudiante estudianteActualizado = obtenerDatosEstudiante();
                mostrarMensaje("Estudiante actualizado: " + estudianteActualizado.getNombre());*/
                estudiante estudianteActualizado = obtenerDatosEstudiante();
        
                if (estudianteActualizado != null) {
                    // Crear el controlador y actualizar el estudiante
                    EstudianteController estudianteController = new EstudianteController();
                    estudianteController.actualizarEstudiante(estudianteActualizado); // Llamar al controlador para actualizar

                    // Actualizar la tabla
                    actualizarTabla();
                    // Mostrar mensaje de éxito
                    mostrarMensaje("Estudiante actualizado: " + estudianteActualizado.getNombre());
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Eliminar estudiante por ID
                /*int id = obtenerIdEstudiante();
                mostrarMensaje("Estudiante con ID " + id + " eliminado.");*/
                int id = obtenerIdEstudiante();
        
                // Crear el controlador y eliminar el estudiante
                EstudianteController estudianteController = new EstudianteController();
                estudianteController.eliminarEstudiante(id); // Llamar al controlador para eliminar

                // Actualizar la tabla
                actualizarTabla();

                // Mostrar mensaje de éxito
                mostrarMensaje("Estudiante con ID " + id + " eliminado.");
                    }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Buscar estudiante por ID
                /*int id = obtenerIdEstudiante();
                mostrarMensaje("Buscando estudiante con ID: " + id);*/
                 int id = obtenerIdEstudiante();
        
                // Crear el controlador y buscar el estudiante
                EstudianteController estudianteController = new EstudianteController();
                estudiante est = estudianteController.buscarEstudiante(id); // Llamar al controlador para buscar
                
                if (est != null) {
                    // Mostrar los datos del estudiante en los campos de texto
                    mostrarEstudiante(est);
                } else {
                    // Si no se encuentra el estudiante, mostrar un mensaje de error
                    mostrarError("Estudiante no encontrado.");
                }
                
            }
        });
    }
    
    private void actualizarTabla() {
    EstudianteController estudianteController = new EstudianteController();
    List<estudiante> estudiantes = estudianteController.obtenerEstudiantes();

    // Limpiar la tabla actual
    tableModel.setRowCount(0);

    // Llenar la tabla con los estudiantes obtenidos
    for (estudiante est : estudiantes) {
        Object[] fila = {est.getId(), est.getNombre(), est.getApellido(), est.getDni(), est.getEmail(), est.getGrado(), est.getPromedio()};
        tableModel.addRow(fila);
    }
}
    
    

    
    @Override
    public void mostrarEstudiantes(List<estudiante> estudiantes) {
        taEstudiantes.setText("");
        for (estudiante est : estudiantes) {
            taEstudiantes.append(est.getId() + " - " + est.getNombre() + " " + est.getApellido() + "\n");
        }
    }

    @Override
    public void mostrarEstudiante(estudiante estudiante) {
        tfId.setText(String.valueOf(estudiante.getId()));
        tfDni.setText(estudiante.getDni());
        tfNombre.setText(estudiante.getNombre());
        tfApellido.setText(estudiante.getApellido());
        tfEmail.setText(estudiante.getEmail());
        tfGrado.setText(estudiante.getGrado());
        tfPromedio.setText(String.valueOf(estudiante.getPromedio()));
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public estudiante obtenerDatosEstudiante() {
        estudiante est = new estudiante();
    
    // Validar ID (si es un campo numérico)
    try {
        est.setId(Integer.parseInt(tfId.getText().trim())); // Trimming para evitar espacios en blanco
    } catch (NumberFormatException e) {
        mostrarError("Por favor, ingrese un ID válido.");
        return null; // Retornar null si la conversión falla
    }

    est.setDni(tfDni.getText().trim());
    est.setNombre(tfNombre.getText().trim());
    est.setApellido(tfApellido.getText().trim());
    est.setEmail(tfEmail.getText().trim());
    est.setGrado(tfGrado.getText().trim());

    // Validar Promedio (si es un campo numérico)
    try {
        est.setPromedio(Double.parseDouble(tfPromedio.getText().trim())); // Trimming para evitar espacios en blanco
    } catch (NumberFormatException e) {
        mostrarError("Por favor, ingrese un promedio válido.");
        return null; // Retornar null si la conversión falla
    }

    return est;
    }

    @Override
    public int obtenerIdEstudiante() {
        return Integer.parseInt(tfId.getText());
    }
    
    
    
}
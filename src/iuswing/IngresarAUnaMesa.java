package iuswing;

import dominio.EventoFachada;
import dominio.Fachada;
import static dominio.juego.EstadoMesa.ABIERTA;
import dominio.juego.EventoJuego;
import dominio.juego.Mesa;
import dominio.juego.SistemaJuegoException;
import dominio.usuario.UsuarioJugador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilidades.Observable;
import utilidades.Observador;

public class IngresarAUnaMesa extends javax.swing.JDialog implements Observador {

    private UsuarioJugador usuario;

    /**
     * Creates new form IngresarAUnaMesa
     */
    public IngresarAUnaMesa(java.awt.Frame parent, boolean modal, UsuarioJugador usuario) {
        super(parent, modal);
        initComponents();
        this.usuario = usuario;
        Fachada.getInstancia().agregar(this);
        mostrarNombre();
        mostrarTablaMesas();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIngresar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMesas = new javax.swing.JTable();
        txtJugador = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtIngresar.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtIngresar.setText("Ingresar a una Mesa");

        tableMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nº de Mesa", "Cant. Jugadores Requeridos", "Apuesta Base $", "Cant. Actual de Jugadores", "% Comisión de Mesa"
            }
        ));
        jScrollPane1.setViewportView(tableMesas);

        txtJugador.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btnJugar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnJugar.setForeground(new java.awt.Color(156, 0, 62));
        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(txtIngresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(txtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnJugar)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        jugarAlPoker();
    }//GEN-LAST:event_btnJugarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMesas;
    private javax.swing.JLabel txtIngresar;
    private javax.swing.JLabel txtJugador;
    // End of variables declaration//GEN-END:variables

    private void mostrarNombre() {
        String jugador = usuario.getNombreCompleto() + " - " + "Saldo actual: " + usuario.getSaldo();
        txtJugador.setText(jugador);
    }

    private void mostrarTablaMesas() {
        ArrayList<Mesa> mesas = Fachada.getInstancia().getMesas();

        String[] columnas = {"Nº de Mesa", "Cant. Jugadores Requeridos", "Apuesta Base $", "Cant. Actual de Jugadores", "% Comisión de Mesa"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        for (Mesa mesa : mesas) {
            if (mesa.getEstadoMesa() == ABIERTA) {
                Object[] fila = {mesa.getNumeroMesa(), mesa.getCantidadJugadoresRequerido(), mesa.getApuestaBase(), mesa.getCantidadJugadoresActual(), mesa.getPorcentajeComision()};
                modelo.addRow(fila);
            }
        }

        tableMesas.setModel(modelo);

    }

    private void jugarAlPoker() {

//        int fila = tableMesas.getSelectedRow();
//        if (fila < 0) {
//            JOptionPane.showMessageDialog(
//                    this,
//                    "Debe seleccionar una mesa",
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        } else {
//            int idMesaSeleccionada = (int) tableMesas.getModel().getValueAt(fila, 0); //columna 0 porque el nº de mesa esta en la primer columna
//            Mesa m = Fachada.getInstancia().unaMesa(idMesaSeleccionada);
//            if (m == null) {
//                JOptionPane.showMessageDialog(
//                        this,
//                        "No se encontró la mesa",
//                        "Error",
//                        JOptionPane.ERROR_MESSAGE);
//            } else {               
//                //ToDo: TENEMOS QUE VALIDAR EL SALDO CON EL METODO VALIDAR DE sITEMAJUEGO 
//                //     Traemos el validar de mesa
////                try {
//                // Ver si esto cumple experto
//                ArrayList<UsuarioJugador> listaJugadoresMesa = m.getListaJugadores();
//                listaJugadoresMesa.add(this.usuario);
//                m.actualizarJugadoresActualesIngreso();
//                int jugadoresRequeridos = m.getCantidadJugadoresRequerido();
//                int jugadoresActuales = m.getCantidadJugadoresActual();
//                int jugadoresFatantes = jugadoresRequeridos - jugadoresActuales;
//
//                if (jugadoresFatantes == 0) {
//
//                    m.iniciarMesa();
////                    DialogoEjemplo dialogo = new DialogoEjemplo(null, false, usuario, m);
////                    dialogo.setVisible(true);
//                    PanelCartasPoker panelCartasPoker = new PanelCartasPoker(null, false, usuario, m);
//                    panelCartasPoker.setVisible(true);
//                    //El saldo se valida antes en el try cathc que falta 
//
//                } else {
//
//                    VentanaEsperandoInicio ventanaEsperandoInicio = new VentanaEsperandoInicio(null, false, usuario, m);
//                    ventanaEsperandoInicio.setVisible(true);
//                }
//
//                
//// else {
////                        
////                    }
////                } catch (SistemaJuegoException sjex) {
////                    JOptionPane.showMessageDialog(
////                            this,
////                            sjex.getMessage(),
////                            "Error",
////                            JOptionPane.ERROR_MESSAGE);
////
////                }
//            }
//        }
//chat
        int fila = tableMesas.getSelectedRow();

        // Validar que se seleccione una mesa
        if (fila < 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar una mesa",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idMesaSeleccionada = (int) tableMesas.getModel().getValueAt(fila, 0);
        Mesa mesaSeleccionada = Fachada.getInstancia().unaMesa(idMesaSeleccionada);

        // Validar que la mesa existe
        if (mesaSeleccionada == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontró la mesa",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Validar saldo del jugador para la apuesta base
            int apuestaBase = mesaSeleccionada.getApuestaBase();
            int saldoJugador = usuario.getSaldo();

            mesaSeleccionada.validarSaldoInicial(saldoJugador);

//        if (saldoJugador < apuestaBase * 10) {
//            throw new SistemaJuegoException("Saldo insuficiente");
//        }
            // Añadir jugador a la mesa
            mesaSeleccionada.getListaJugadores().add(usuario);
            mesaSeleccionada.actualizarJugadoresActualesIngreso();

            // Comprobar si la mesa está lista para iniciar
            if (mesaSeleccionada.getCantidadJugadoresActual() == mesaSeleccionada.getCantidadJugadoresRequerido()) {
                mesaSeleccionada.iniciarMesa();

                // Mostrar la pantalla principal de juego
                PanelCartasPoker panelCartasPoker = new PanelCartasPoker(null, false, usuario, mesaSeleccionada);
                panelCartasPoker.setVisible(true);;
            } else {
                // Mostrar pantalla de espera
                VentanaEsperandoInicio ventanaEsperando = new VentanaEsperandoInicio(null, false, usuario, mesaSeleccionada);
                ventanaEsperando.setVisible(true);
            }

        } catch (SistemaJuegoException e) {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ocurrió un error inesperado: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void actualizar(Observable origen, Object evento) {

        if (evento.equals(EventoJuego.MESA_NUEVA)) {
            mostrarTablaMesas();
        }

        if (evento.equals(EventoJuego.MESA_INICIADA)) {
            //Para que desaparezca la mesa cuando deje de estar abierta
            mostrarTablaMesas();
        }

        if (evento.equals(EventoJuego.MESA_ACTUALIZARJUGADORES)) {
            mostrarTablaMesas();
        }

        if (evento.equals(EventoFachada.MESA_NUEVA)) {
            mostrarTablaMesas();
        }
        if (evento.equals(EventoFachada.MESA_INICIADA)) {
            mostrarTablaMesas();
        }
        if (evento.equals(EventoFachada.MESA_ACTUALIZARJUGADORES)) {
            mostrarTablaMesas();
        }

    }

}

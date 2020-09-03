package depreciacion;

import java.io.File;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//import javax.swing.text.Element;

public class Principal extends javax.swing.JFrame {

//Variables de formulario
    public String Codigo;
    public String nombre;
    public String ubicacion;
    public long ValorActivoFor;
    public long ValorRescateFor;
    public String Responsable;
    public int VidaUtilFor;

//Fin de Variables de formulario
//Variable Para tabla
    DefaultTableModel modelo, modelobuscar, modeloLinea;
    public String[] ListaATabla = new String[7];
    public String[] ListaATablaBuscar = new String[7];
    public String[] ListaATablaDepre = new String[3];
//Variables para llamar las clases
    ActivoClases ClaseActivo = new ActivoClases(Codigo, nombre, ubicacion, ValorActivoFor, ValorRescateFor, Responsable, VidaUtilFor);
    ArchivoClase ArchXML = new ArchivoClase();

    public Principal() throws ParserConfigurationException {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ubicación");
        modelo.addColumn("Valor Activo");
        modelo.addColumn("Valor Rescate");
        modelo.addColumn("Responsable");
        modelo.addColumn("Vida Útil");

        ArchXML.modeloClase = modelo;
        this.jTable1.setModel(modelo);
        modelobuscar = new DefaultTableModel();
        modelobuscar.addColumn("Código");
        modelobuscar.addColumn("Nombre");
        modelobuscar.addColumn("Ubicación");
        modelobuscar.addColumn("Valor Activo");
        modelobuscar.addColumn("Valor Rescate");
        modelobuscar.addColumn("Responsable");
        modelobuscar.addColumn("Vida Útil");
        this.jTableBuscar.setModel(modelobuscar);

        modeloLinea = new DefaultTableModel();
        modeloLinea.addColumn("Fechas");
        modeloLinea.addColumn("Depreciación");
        modeloLinea.addColumn("Depreciación Acumulada");
        this.jTableDepreciaciones.setModel(modeloLinea);

        rbLineaRecta.setSelected(true);
        cbIngresar.setSelected(true);
        this.setLocationRelativeTo(null);
        // UsandoDomXml t = new UsandoDomXml();

        ArchXML.readActivosXml();
        // Ingresa el arreglo a la tabla
        if (ArchXML.primera = false) {
            modelo = ArchXML.modeloClase;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDepreciaciones = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombreActivo = new javax.swing.JTextField();
        txtUbicacion = new javax.swing.JTextField();
        txtVActivo = new javax.swing.JTextField();
        txtVRescate = new javax.swing.JTextField();
        txtResponsable = new javax.swing.JTextField();
        txtVidaUtil = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbIngresar = new javax.swing.JCheckBox();
        cbModificar = new javax.swing.JCheckBox();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rbLineaRecta = new javax.swing.JRadioButton();
        rbSumaDA = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtCodigo1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBuscar = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmGuardarComo = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Control de Activos");
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Ubicación"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 1060, 150);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableDepreciaciones.setBackground(new java.awt.Color(204, 204, 255));
        jTableDepreciaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Ubicación"
            }
        ));
        jTableDepreciaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDepreciacionesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDepreciaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(510, 250, 490, 180);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Ubicación:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Valor Activo:");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Valor de Rescate:");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Responsable:");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("Vida Útil:");

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtNombreActivo)
                                    .addComponent(txtVActivo)
                                    .addComponent(txtUbicacion)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtResponsable, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtVidaUtil)
                                    .addComponent(txtVRescate)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtVRescate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtVidaUtil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addGap(107, 107, 107))
        );

        jLabel7.getAccessibleContext().setAccessibleName("Vida Útil");

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 250, 490, 260);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbIngresar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbIngresar.setText("Ingresar");
        cbIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIngresarActionPerformed(evt);
            }
        });

        cbModificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbModificar.setText("Modificar");
        cbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Registrar Activos ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(cbIngresar)
                .addGap(30, 30, 30)
                .addComponent(cbModificar)
                .addGap(27, 27, 27)
                .addComponent(btnEliminar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 190, 490, 50);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        rbLineaRecta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbLineaRecta.setText("Línea Recta");
        rbLineaRecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLineaRectaActionPerformed(evt);
            }
        });

        rbSumaDA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbSumaDA.setText("Suma Dígitos Anuales");
        rbSumaDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSumaDAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbLineaRecta, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(rbSumaDA, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLineaRecta)
                    .addComponent(rbSumaDA))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(510, 190, 490, 50);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Buscar Activo: ");

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(540, 450, 460, 50);

        jTableBuscar.setBackground(new java.awt.Color(204, 204, 255));
        jTableBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Ubicación"
            }
        ));
        jTableBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBuscarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableBuscar);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 520, 1030, 160);

        jMenu1.setText("Acerca De");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jmGuardarComo.setText("Guardar Como");
        jmGuardarComo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmGuardarComoMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmGuardarComo);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbSumaDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSumaDAActionPerformed
        //Se crea la restriccion de si esta activo el rblineaRecta este se desactive
        if (rbLineaRecta.isEnabled() == true) {
            rbLineaRecta.setSelected(false);
        }

    }//GEN-LAST:event_rbSumaDAActionPerformed

    private void rbLineaRectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLineaRectaActionPerformed
        //Se crea la restriccion de si esta activo el rbSumaDA este se desactive    
        if (rbSumaDA.isEnabled() == true) {
            rbSumaDA.setSelected(false);
        }


    }//GEN-LAST:event_rbLineaRectaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //Se Crea el modelo para la tabla
        //Si el resultado es 1 significa que esta selecionada una fila
        if (jTable1.getSelectedRowCount() == 1) {
            String ValorCodigo = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0); //Se pasa el valor de obj a string
            ClaseActivo.Activos.remove(ValorCodigo);
            modelo.removeRow(jTable1.getSelectedRow());  //y lo elimina de la tabla
            try {
                ArchXML.EliminarXML(ValorCodigo);
                //Si el resultado es 0 significa que esta selecionada una fila
            } catch (ParserConfigurationException ex) {
                JOptionPane.showMessageDialog(this, "Error al Eliminar");
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (jTable1.getSelectedRowCount() == 0)
            //manda un mensaje en pantalla
            JOptionPane.showMessageDialog(this, "Seleccione la fila del producto a eliminar");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbModificarActionPerformed
        //Se crea la restriccion de si esta activo el cbIngresar este se desactive
        if (cbModificar.isEnabled() == true) {
            cbIngresar.setSelected(false);
        }
        txtCodigo.setEditable(false);
        rbLineaRecta.setEnabled(false);
        rbSumaDA.setEnabled(false);

    }//GEN-LAST:event_cbModificarActionPerformed

    private void cbIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIngresarActionPerformed
        //Se crea la restriccion de si esta activo el cbModificar este se desactive    
        if (cbIngresar.isEnabled() == true) {
            cbModificar.setSelected(false);
        }
        txtCodigo.setEditable(true);
        rbLineaRecta.setEnabled(true);
        rbSumaDA.setEnabled(true);
        txtCodigo.setText("");
        txtNombreActivo.setText("");
        txtResponsable.setText("");
        txtUbicacion.setText("");
        txtVActivo.setText("");
        txtVRescate.setText("");
        txtVidaUtil.setText("");
    }//GEN-LAST:event_cbIngresarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String validacion = "";
        long[] listaAnnos = new long[6];
        int numecod;
        int vidacuatro;
        long depresiacion;
        long depreciacionacumulada = 0;
        try {

            if (cbIngresar.isSelected() == true) {
                //Validaciones
                for (int i = 0; i < modelo.getRowCount(); i++) {

                    if (txtCodigo.getText().equalsIgnoreCase(String.valueOf(modelo.getValueAt(i, 0)))) {

                        validacion = validacion + " Codigo ya existe";
                    }

                }

                validacion = validacion + ClaseActivo.validaciones(txtCodigo.getText(), txtNombreActivo.getText(), txtUbicacion.getText(), Long.parseLong(txtVActivo.getText()), Long.parseLong(txtVRescate.getText()), txtResponsable.getText(), Integer.parseInt(txtVidaUtil.getText()));

                if (validacion.isEmpty() != true) {
                    JOptionPane.showMessageDialog(this, validacion);
                } else {
                    Codigo = txtCodigo.getText();
                    nombre = txtNombreActivo.getText();
                    ubicacion = txtUbicacion.getText();
                    Responsable = txtResponsable.getText();
                    ValorActivoFor = Long.parseLong(txtVActivo.getText());
                    ValorRescateFor = Long.parseLong(txtVRescate.getText());
                    VidaUtilFor = Integer.parseInt(txtVidaUtil.getText());

                    //Ingresa los datos al arreglo
                    ListaATabla[0] = Codigo;
                    ListaATabla[1] = nombre;
                    ListaATabla[2] = ubicacion;
                    ListaATabla[3] = String.valueOf(ValorActivoFor);
                    ListaATabla[4] = String.valueOf(ValorRescateFor);
                    ListaATabla[5] = Responsable;
                    ListaATabla[6] = String.valueOf(VidaUtilFor);
                    //Ingresa el arreglo a la tabla

                    modelo.addRow(ListaATabla);

                    ClaseActivo.InsertarAMaps(Codigo, nombre, ubicacion, ValorActivoFor, ValorRescateFor, Responsable, VidaUtilFor);

                    depresiacion = ValorActivoFor - ValorRescateFor;
                    depresiacion = depresiacion / VidaUtilFor;

                    for (int j = 1; j < VidaUtilFor; j++) {

                        if (j == 6) {
                            break;
                        }

                        depreciacionacumulada = depreciacionacumulada + depresiacion;
                        listaAnnos[j] = (depreciacionacumulada);

                    }

                    if (VidaUtilFor < 5) {
                        for (int i = VidaUtilFor; i < 5; i++) {

                            listaAnnos[i] = (0);

                        }

                    }
                    ArchXML.Deprelista = listaAnnos;

                    ArchXML.saveActivos(Codigo, nombre, ubicacion, ValorActivoFor, ValorRescateFor, Responsable, VidaUtilFor, depresiacion);
                    //Se elimina los datos de los txt

                    txtCodigo.setText("");
                    txtNombreActivo.setText("");
                    txtResponsable.setText("");
                    txtUbicacion.setText("");
                    txtVActivo.setText("");
                    txtVRescate.setText("");
                    txtVidaUtil.setText("");

                }
            } else if (cbModificar.isSelected() == true) {
                //Validaciones

                validacion = validacion + ClaseActivo.validaciones(txtCodigo.getText(), txtNombreActivo.getText(), txtUbicacion.getText(), Long.parseLong(txtVActivo.getText()), Long.parseLong(txtVRescate.getText()), txtResponsable.getText(), Integer.parseInt(txtVidaUtil.getText()));

                Codigo = txtCodigo.getText();
                nombre = txtNombreActivo.getText();
                ubicacion = txtUbicacion.getText();
                Responsable = txtResponsable.getText();
                ValorActivoFor = Long.parseLong(txtVActivo.getText());
                ValorRescateFor = Long.parseLong(txtVRescate.getText());
                VidaUtilFor = Integer.parseInt(txtVidaUtil.getText());

                if (validacion.isEmpty() != true) {
                    JOptionPane.showMessageDialog(this, validacion);
                } else {

                    String ValorCodigo = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0); //Se pasa el valor de obj a string
                    ClaseActivo.Activos.remove(ValorCodigo);//se pasa de string a int    
                    ClaseActivo.InsertarAMaps(Codigo, nombre, ubicacion, ValorActivoFor, ValorRescateFor, Responsable, VidaUtilFor);
                    //Lo elimina de la tabla y lo vuelve a ingresar      
                    modelo.removeRow(jTable1.getSelectedRow());
                    ListaATabla[0] = String.valueOf(Codigo);
                    ListaATabla[1] = nombre;
                    ListaATabla[2] = ubicacion;
                    ListaATabla[3] = String.valueOf(ValorActivoFor);
                    ListaATabla[4] = String.valueOf(ValorRescateFor);
                    ListaATabla[5] = Responsable;
                    ListaATabla[6] = String.valueOf(VidaUtilFor);
                    //Ingresa el arreglo a la tabla
                    modelo.addRow(ListaATabla);

                    depresiacion = ValorActivoFor - ValorRescateFor;
                    depresiacion = depresiacion / VidaUtilFor;

                    for (int j = 1; j < VidaUtilFor; j++) {

                        if (j == 6) {
                            break;
                        }

                        depreciacionacumulada = depreciacionacumulada + depresiacion;
                        listaAnnos[j] = (depreciacionacumulada);

                    }

                    if (VidaUtilFor < 5) {
                        for (int i = VidaUtilFor; i < 5; i++) {

                            listaAnnos[i] = (0);

                        }

                    }
                    ArchXML.Deprelista = listaAnnos;

                    ArchXML.ModificarXML(Codigo, nombre, ubicacion, ValorActivoFor, ValorRescateFor, Responsable, VidaUtilFor, depresiacion);
                    txtCodigo.setText("");
                    txtNombreActivo.setText("");
                    txtResponsable.setText("");
                    txtUbicacion.setText("");
                    txtVActivo.setText("");
                    txtVRescate.setText("");
                    txtVidaUtil.setText("");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        double ValorActivo;
        double ValorRescate;
        int VidaUtil;
        int AnnoSelec;
        double depresiacion;
        int sumadedigtos = 0;
        double depresiacionAcumulada = 0;

        for (int i = modeloLinea.getRowCount() - 1; i >= 0; i--) {
            modeloLinea.removeRow(i);
        }

        String ValorCodigoSTRIN = (String) modelo.getValueAt(jTable1.getSelectedRow(), 3); //Se pasa el valor de obj a string
        ValorActivo = Double.parseDouble(ValorCodigoSTRIN);//Coge el valor Activo de la tabla
        String StriValorRescate = (String) modelo.getValueAt(jTable1.getSelectedRow(), 4);
        ValorRescate = Double.parseDouble(StriValorRescate);//Coge el valor Rescate de la tab
        String StriVidaUtil = (String) modelo.getValueAt(jTable1.getSelectedRow(), 6);
        VidaUtil = Integer.parseInt(StriVidaUtil);//Coge el vida Util de la tab
        String ValorCodigo = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0); //Se pasa el valor de obj a string

        if (rbLineaRecta.isSelected() == true) {

            depresiacion = ValorActivo - ValorRescate;
            depresiacion = depresiacion / VidaUtil;

            for (int j = 1; j <= VidaUtil; j++) {
                ListaATablaDepre[0] = String.valueOf(j); //Se pasa el valor de obj a string

                ListaATablaDepre[1] = String.valueOf(Math.round(depresiacion));
                depresiacionAcumulada = depresiacionAcumulada + depresiacion;
                ListaATablaDepre[2] = String.valueOf(Math.round(depresiacionAcumulada));
                modeloLinea.addRow(ListaATablaDepre);
            }

        } else {
            if (rbSumaDA.isSelected() == true) {

                for (int i = VidaUtil; i >= 0; i--) {
                    sumadedigtos = sumadedigtos + i;
                }

                for (int i = 1; i <= VidaUtil; i++) {

                    depresiacion = ValorActivo - ValorRescate;
                    ListaATablaDepre[0] = String.valueOf(i); //Se pasa el valor de obj a string
                    depresiacion = depresiacion * i / sumadedigtos;
                    ListaATablaDepre[1] = String.valueOf(Math.round(depresiacion));

                    depresiacionAcumulada = depresiacionAcumulada + depresiacion;
                    ListaATablaDepre[2] = String.valueOf(Math.round(depresiacionAcumulada));

                    modeloLinea.addRow(ListaATablaDepre);
                }
                //depresiacion=depresiacion*Integer.parseInt(añopedido)/sumadedigtos;
//         lbCodigo.setText(ValorCodigo); 
//         lbDepreciacionC.setText(String.valueOf(depresiacion)); 
            }
        }
        if (cbModificar.isSelected() == true) {

            String codigodemodi = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0); //Se pasa el valor de obj a string
            String nombremodi = (String) modelo.getValueAt(jTable1.getSelectedRow(), 1);
            String ubicamodi = (String) modelo.getValueAt(jTable1.getSelectedRow(), 2);
            String valoractivomodi = (String) modelo.getValueAt(jTable1.getSelectedRow(), 3);
            String valorescatemodi = (String) modelo.getValueAt(jTable1.getSelectedRow(), 4);
            String responmodi = (String) modelo.getValueAt(jTable1.getSelectedRow(), 5);
            String vidautilmodi = (String) modelo.getValueAt(jTable1.getSelectedRow(), 6);

            txtCodigo.setText(codigodemodi);
            txtNombreActivo.setText(nombremodi);
            txtResponsable.setText(responmodi);
            txtUbicacion.setText(ubicamodi);
            txtVActivo.setText(valoractivomodi);
            txtVRescate.setText(valorescatemodi);
            txtVidaUtil.setText(vidautilmodi);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        Creditos ver = new Creditos();
        ver.setTitle("Creditos");

        ver.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jmGuardarComoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmGuardarComoMouseClicked

        ArchXML.BuscarArchivo(false);


    }//GEN-LAST:event_jmGuardarComoMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked

        String buscardato = txtCodigo1.getText();

        int numero = jTable1.getRowCount();

        for (int i = modelobuscar.getRowCount() - 1; i >= 0; i--) {
            modelobuscar.removeRow(i);
        }

        String Codigo, nombre, ubicacion, responsable;
        for (int x = jTable1.getRowCount() - 1; x >= 0; x--) {

            Codigo = (String) jTable1.getValueAt(x, 0);
            nombre = (String) jTable1.getValueAt(x, 1);
            ubicacion = (String) jTable1.getValueAt(x, 2);
            responsable = (String) jTable1.getValueAt(x, 5);

            if (buscardato.equalsIgnoreCase(Codigo) || buscardato.equalsIgnoreCase(nombre) || buscardato.equalsIgnoreCase(ubicacion) || buscardato.equalsIgnoreCase(responsable)) {
                ListaATablaBuscar[0] = (String) jTable1.getValueAt(x, 0); //Se pasa el valor de obj a string
                ListaATablaBuscar[1] = (String) jTable1.getValueAt(x, 1);
                ListaATablaBuscar[2] = (String) jTable1.getValueAt(x, 2);
                ListaATablaBuscar[3] = (String) jTable1.getValueAt(x, 3);
                ListaATablaBuscar[4] = (String) jTable1.getValueAt(x, 4);
                ListaATablaBuscar[5] = (String) jTable1.getValueAt(x, 5);
                ListaATablaBuscar[6] = (String) jTable1.getValueAt(x, 6);

                //Ingresa el arreglo a la tabla
                modelobuscar.addRow(ListaATablaBuscar);
            }
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jTableBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBuscarMouseClicked

        double ValorActivo;
        double ValorRescate;
        int VidaUtil;
        int AnnoSelec;
        double depresiacion;
        int sumadedigtos = 0;
        double depresiacionAcumulada = 0;

        for (int i = modeloLinea.getRowCount() - 1; i >= 0; i--) {
            modeloLinea.removeRow(i);
        }

        String ValorCodigoSTRIN = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 3); //Se pasa el valor de obj a string
        ValorActivo = Double.parseDouble(ValorCodigoSTRIN);//Coge el valor Activo de la tabla
        String StriValorRescate = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 4);
        ValorRescate = Double.parseDouble(StriValorRescate);//Coge el valor Rescate de la tab
        String StriVidaUtil = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 6);
        VidaUtil = Integer.parseInt(StriVidaUtil);//Coge el vida Util de la tab

        String ValorCodigo = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 0); //Se pasa el valor de obj a string

        if (rbLineaRecta.isSelected() == true) {

            depresiacion = ValorActivo - ValorRescate;
            depresiacion = depresiacion / VidaUtil;

            for (int j = 1; j <= VidaUtil; j++) {
                ListaATablaDepre[0] = String.valueOf(j); //Se pasa el valor de obj a string

                ListaATablaDepre[1] = String.valueOf(Math.round(depresiacion));
                depresiacionAcumulada = depresiacionAcumulada + depresiacion;
                ListaATablaDepre[2] = String.valueOf(Math.round(depresiacionAcumulada));
                modeloLinea.addRow(ListaATablaDepre);
            }

        } else {
            if (rbSumaDA.isSelected() == true) {

                for (int i = VidaUtil; i >= 0; i--) {
                    sumadedigtos = sumadedigtos + i;
                }

                for (int i = 1; i <= VidaUtil; i++) {

                    depresiacion = ValorActivo - ValorRescate;
                    ListaATablaDepre[0] = String.valueOf(i); //Se pasa el valor de obj a string
                    depresiacion = depresiacion * i / sumadedigtos;
                    ListaATablaDepre[1] = String.valueOf(Math.round(depresiacion));

                    depresiacionAcumulada = depresiacionAcumulada + depresiacion;
                    ListaATablaDepre[2] = String.valueOf(Math.round(depresiacionAcumulada));

                    modeloLinea.addRow(ListaATablaDepre);
                }
                //depresiacion=depresiacion*Integer.parseInt(añopedido)/sumadedigtos;
//         lbCodigo.setText(ValorCodigo); 
//         lbDepreciacionC.setText(String.valueOf(depresiacion)); 
            }
        }
        if (cbModificar.isSelected() == true) {

            String codigodemodi = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 0); //Se pasa el valor de obj a string
            String nombremodi = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 1);
            String ubicamodi = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 2);
            String valoractivomodi = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 3);
            String valorescatemodi = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 4);
            String responmodi = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 5);
            String vidautilmodi = (String) modelobuscar.getValueAt(jTableBuscar.getSelectedRow(), 6);

            txtCodigo.setText(codigodemodi);
            txtNombreActivo.setText(nombremodi);
            txtResponsable.setText(responmodi);
            txtUbicacion.setText(ubicamodi);
            txtVActivo.setText(valoractivomodi);
            txtVRescate.setText(valorescatemodi);
            txtVidaUtil.setText(vidautilmodi);

        }
    }//GEN-LAST:event_jTableBuscarMouseClicked

    private void jTableDepreciacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDepreciacionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableDepreciacionesMouseClicked

    public static void main(String args[]) {


        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JCheckBox cbIngresar;
    private javax.swing.JCheckBox cbModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableBuscar;
    private javax.swing.JTable jTableDepreciaciones;
    private javax.swing.JMenu jmGuardarComo;
    private javax.swing.JRadioButton rbLineaRecta;
    private javax.swing.JRadioButton rbSumaDA;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtNombreActivo;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JTextField txtUbicacion;
    private javax.swing.JTextField txtVActivo;
    private javax.swing.JTextField txtVRescate;
    private javax.swing.JTextField txtVidaUtil;
    // End of variables declaration//GEN-END:variables
}

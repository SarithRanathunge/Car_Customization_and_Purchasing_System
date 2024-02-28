/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package viewPage;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.Node;
//import com.sun.jdi.connect.Transport;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import graph.DijkstraAlgorithm;
import java.awt.Color;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import nodeArray.ArrayNode;
import singlyLinkedList.LinkedListNode;
import singlyLinkedList.SinglyLinkedList;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

/**
 *
 * @author Sarith
 */
public class CustomizationPage extends javax.swing.JFrame {

    private boolean bodyColor;
    private boolean rimAndTyers;
    private boolean seats;
    private boolean lights;

    int[][] graph;
    String[] locations;
    int importDay;
    String Source;
    String carName;
    double carPrice = 0.0;

    DoublyLinkedList bodyColorlist = new DoublyLinkedList();
    DoublyLinkedList rimAndTyersList = new DoublyLinkedList();
    DoublyLinkedList seatsList = new DoublyLinkedList();
    DoublyLinkedList lightList = new DoublyLinkedList();

    SinglyLinkedList linkedList = new SinglyLinkedList();

    /**
     * Creates new form Car
     */
    public CustomizationPage() {
        initComponents();
        setDate();
        times();
        setIcon();
        reSizeTableColumn();

        this.bodyColor = false;
        this.rimAndTyers = false;
        this.seats = false;
        this.lights = false;

        updateTotalPrice();
        updateAdvacePrice();
        updatePrice();

        color();
        txtArea.setEditable(false);

//        insertBodyColor();
//        insertRimandTyers();
//        insertSeats();
//        insertLights();
        graph = new int[][]{
            {0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Vito Pizza
            {8, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Gallface
            {0, 7, 0, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Townhall
            {0, 0, 9, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Kollupitiya
            {0, 0, 3, 4, 0, 12, 5, 0, 0, 0, 0, 0, 0, 0, 0}, // Bambalapitya
            {0, 0, 0, 0, 12, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0}, // Dematagoda
            {0, 0, 0, 0, 5, 3, 0, 5, 5, 0, 0, 0, 0, 0, 0}, // Wellawatte
            {0, 0, 0, 0, 0, 3, 5, 0, 3, 0, 0, 0, 0, 0, 0}, // Havelock Road
            {0, 0, 0, 0, 0, 0, 5, 3, 0, 10, 5, 0, 0, 0, 0}, // Maharagama
            {0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 3, 3, 0, 0, 0}, // Nugegoda
            {0, 0, 0, 0, 0, 0, 0, 0, 5, 3, 0, 5, 3, 0, 0}, // Piliyandala
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 0, 12, 0, 0}, // Nawala
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 12, 0, 5, 0}, // Narahenpita
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 3}, // Borella
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0} // Galle
        };

        // Array of location names
        locations = new String[]{"Porsche Branch", "Gallface", "Townhall", "Kollupitiya", "Bambalapitya", "Dematagoda", "Wellawatte", "Havelock Road", "Maharagama", "Nugegoda", "Piliyandala", "Nawala", "Narahenpita", "Borella", "Galle"};

        tblSelectItem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    addToBill();
                }
            }
        });
    }

    public CustomizationPage(String name, double price, int importDay, String source, DoublyLinkedList bodyColorlist, DoublyLinkedList rimAndTyersList, DoublyLinkedList seatsList, DoublyLinkedList lightList, SinglyLinkedList linkedList) {
        initComponents();
        setVehical(name, price);
        setDate();
        times();
        setIcon();
        reSizeTableColumn();
        this.importDay = importDay;
        this.Source = source;
        txtArea.setText("Days to Import the car from " + source + " to Sri lanka " + importDay + " days.");

        this.linkedList = linkedList;

        this.bodyColorlist = bodyColorlist;
        this.rimAndTyersList = rimAndTyersList;
        this.seatsList = seatsList;
        this.lightList = lightList;

        this.bodyColor = false;
        this.rimAndTyers = false;
        this.seats = false;
        this.lights = false;

        updateTotalPrice();
        updateAdvacePrice();
        updatePrice();

        color();
        txtArea.setEditable(false);

//        insertBodyColor();
//        insertRimandTyers();
//        insertSeats();
//        insertLights();
        graph = new int[][]{
            {0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Porsche branch
            {8, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Gallface
            {0, 7, 0, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Townhall
            {0, 0, 9, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Kollupitiya
            {0, 0, 3, 4, 0, 12, 5, 0, 0, 0, 0, 0, 0, 0, 0}, // Bambalapitya
            {0, 0, 0, 0, 12, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0}, // Dematagoda
            {0, 0, 0, 0, 5, 3, 0, 5, 5, 0, 0, 0, 0, 0, 0}, // Wellawatte
            {0, 0, 0, 0, 0, 3, 5, 0, 3, 0, 0, 0, 0, 0, 0}, // Havelock Road
            {0, 0, 0, 0, 0, 0, 5, 3, 0, 10, 5, 0, 0, 0, 0}, // Maharagama
            {0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 3, 3, 0, 0, 0}, // Nugegoda
            {0, 0, 0, 0, 0, 0, 0, 0, 5, 3, 0, 5, 3, 0, 0}, // Piliyandala
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 0, 12, 0, 0}, // Nawala
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 12, 0, 5, 0}, // Narahenpita
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 3}, // Borella
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0} // Galle
        };

        // Array of location names
        locations = new String[]{"Porsche Branch", "Gallface", "Townhall", "Kollupitiya", "Bambalapitya", "Dematagoda", "Wellawatte", "Havelock Road", "Maharagama", "Nugegoda", "Piliyandala", "Nawala", "Narahenpita", "Borella", "Galle"};

        tblSelectItem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    addToBill();
                }
            }
        });

    }

    public void color() {
        tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tflName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tfnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tftelephone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tfCity.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tfAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void reSizeTableColumn() {
        TableColumnModel columnModel = tblSelectItem.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(50);

        TableColumnModel columnModel1 = tblBill.getColumnModel();
        columnModel1.getColumn(0).setPreferredWidth(150);
        columnModel1.getColumn(1).setPreferredWidth(100);
    }

    public final void setVehical(String name, double price) {
        DefaultTableModel tableModel = (DefaultTableModel) tblBill.getModel();
        tableModel.addRow(new Object[]{name, price});
    }

    public final void setDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        lblDate.setText(dd);
    }
    Timer t;
    SimpleDateFormat st;

    public final void times() {
        t = new Timer(0, (ActionEvent e) -> {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            Date dt = new Date();
            st = new SimpleDateFormat("HH:MM:ss a");

            String tt = st.format(dt);
            lblTime.setText(tt);
        });

        t.start();
    }

    public void addBodycolorToTable() {

        DefaultTableModel tableModel = (DefaultTableModel) tblSelectItem.getModel();
        tableModel.setRowCount(0);
        Node currentNode = bodyColorlist.head;
        Node tail = bodyColorlist.tail;

        while (currentNode != tail) {
            tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
            currentNode = currentNode.next;
        }
        tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
    }

    public void addRimAndTyerToTable() {

        DefaultTableModel tableModel = (DefaultTableModel) tblSelectItem.getModel();
        tableModel.setRowCount(0);
        Node currentNode = rimAndTyersList.head;
        Node tail = rimAndTyersList.tail;

        while (currentNode != tail) {
            tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
            currentNode = currentNode.next;
        }
        tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
    }

    public void addSeatsToTable() {

        DefaultTableModel tableModel = (DefaultTableModel) tblSelectItem.getModel();
        tableModel.setRowCount(0);
        Node currentNode = seatsList.head;
        Node tail = seatsList.tail;

        while (currentNode != tail) {
            tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
            currentNode = currentNode.next;
        }
        tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
    }

    public void addLightsToTable() {

        DefaultTableModel tableModel = (DefaultTableModel) tblSelectItem.getModel();
        tableModel.setRowCount(0);
        Node currentNode = lightList.head;
        Node tail = lightList.tail;

        while (currentNode != tail) {
            tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
            currentNode = currentNode.next;
        }
        tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
    }

    public void addToBill() {
        int selectedRow = tblSelectItem.getSelectedRow();
        if (selectedRow == -1) {
            // No row is selected, handle this case accordingly
            return;
        }

        String item = tblSelectItem.getValueAt(selectedRow, 0).toString();
        double price = Double.parseDouble(tblSelectItem.getValueAt(selectedRow, 1).toString());

        DefaultTableModel tableModel = (DefaultTableModel) tblBill.getModel();
        tableModel.addRow(new Object[]{item, price});

        // Optionally, you can update the total price after adding the row
        updateTotalPrice();
        updateAdvacePrice();
        updatePrice();
    }

    public void updateTotalPrice() {
        double total = 0.0;
        for (int row = 0; row < tblBill.getRowCount(); row++) {
            double price = Double.parseDouble(tblBill.getValueAt(row, 1).toString());
            total += price;
        }
        lblTotalPrice.setText(String.valueOf(total));
    }

    public void updateAdvacePrice() {
        double total = 0.0;
        double discount = 0.0;
        for (int row = 0; row < tblBill.getRowCount(); row++) {
            double price = Double.parseDouble(tblBill.getValueAt(row, 1).toString());
            discount = price * 0.3;
            total += discount;
        }
        lblAdvance.setText(String.valueOf(total));
    }

    public void updatePrice() {
        double total = 0.0;
        double discount = 0.0;
        double subTotal = 0.0;
        for (int row = 0; row < tblBill.getRowCount(); row++) {
            double price = Double.parseDouble(tblBill.getValueAt(row, 1).toString());
            total += price;
            discount = price * 0.3;
            subTotal = total - discount;
        }
        lblPrice.setText(String.valueOf(subTotal));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tflName = new javax.swing.JTextField();
        tfnic = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfCity = new javax.swing.JTextField();
        tfAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tffName = new javax.swing.JTextField();
        tftelephone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        lblAdvance = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnClearAll = new javax.swing.JButton();
        btnOrderNow1 = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnBodyColor = new javax.swing.JButton();
        btnSeats = new javax.swing.JButton();
        btnLights = new javax.swing.JButton();
        btnRimAndTyers = new javax.swing.JButton();
        rbtnMaxPrice = new javax.swing.JRadioButton();
        rbtnMinPrice = new javax.swing.JRadioButton();
        rbtnAtoZ = new javax.swing.JRadioButton();
        rbtnZtoA = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSelectItem = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car");
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));

        jPanel2.setPreferredSize(new java.awt.Dimension(1080, 25));

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTime.setText("Time");
        lblTime.setAlignmentY(0.0F);
        lblTime.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDate.setText("Date");
        lblDate.setAlignmentY(0.0F);
        lblDate.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 812, Short.MAX_VALUE)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setMaximumSize(new java.awt.Dimension(250, 679));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 673));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Personal Details");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("First Name : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Last Name : ");

        tflName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tflName.setMaximumSize(new java.awt.Dimension(236, 30));
        tflName.setMinimumSize(new java.awt.Dimension(236, 30));
        tflName.setPreferredSize(new java.awt.Dimension(232, 30));
        tflName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tflNameActionPerformed(evt);
            }
        });
        tflName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tflNameKeyTyped(evt);
            }
        });

        tfnic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfnic.setMaximumSize(new java.awt.Dimension(236, 30));
        tfnic.setMinimumSize(new java.awt.Dimension(236, 30));
        tfnic.setPreferredSize(new java.awt.Dimension(232, 30));
        tfnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnicActionPerformed(evt);
            }
        });
        tfnic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfnicKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("NIC No. : ");

        tfemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfemail.setMaximumSize(new java.awt.Dimension(236, 30));
        tfemail.setMinimumSize(new java.awt.Dimension(236, 30));
        tfemail.setPreferredSize(new java.awt.Dimension(232, 30));
        tfemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfemailActionPerformed(evt);
            }
        });
        tfemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfemailKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Email :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("City : ");

        tfCity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCity.setMaximumSize(new java.awt.Dimension(236, 30));
        tfCity.setMinimumSize(new java.awt.Dimension(236, 30));
        tfCity.setPreferredSize(new java.awt.Dimension(232, 30));
        tfCity.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tfCityInputMethodTextChanged(evt);
            }
        });
        tfCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCityActionPerformed(evt);
            }
        });
        tfCity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfCityPropertyChange(evt);
            }
        });
        tfCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCityKeyTyped(evt);
            }
        });

        tfAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfAddress.setMaximumSize(new java.awt.Dimension(236, 30));
        tfAddress.setMinimumSize(new java.awt.Dimension(236, 30));
        tfAddress.setPreferredSize(new java.awt.Dimension(232, 30));
        tfAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfAddressMouseClicked(evt);
            }
        });
        tfAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAddressActionPerformed(evt);
            }
        });
        tfAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAddressKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Address : ");

        tffName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tffName.setMaximumSize(new java.awt.Dimension(236, 30));
        tffName.setMinimumSize(new java.awt.Dimension(236, 30));
        tffName.setPreferredSize(new java.awt.Dimension(232, 30));
        tffName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffNameActionPerformed(evt);
            }
        });
        tffName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tffNameKeyTyped(evt);
            }
        });

        tftelephone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tftelephone.setMaximumSize(new java.awt.Dimension(236, 30));
        tftelephone.setMinimumSize(new java.awt.Dimension(236, 30));
        tftelephone.setPreferredSize(new java.awt.Dimension(232, 30));
        tftelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftelephoneActionPerformed(evt);
            }
        });
        tftelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tftelephoneKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Telephone No. : ");

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tflName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tftelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tflName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tftelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);
        jPanel4.setMaximumSize(new java.awt.Dimension(300, 679));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 673));

        jScrollPane3.setPreferredSize(new java.awt.Dimension(300, 402));

        tblBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblBill.setGridColor(new java.awt.Color(204, 204, 204));
        tblBill.setRowHeight(40);
        tblBill.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tblBill.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblBill.setShowGrid(true);
        tblBill.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tblBill);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Total Price : Rs.");
        jLabel8.setMaximumSize(new java.awt.Dimension(106, 35));
        jLabel8.setMinimumSize(new java.awt.Dimension(106, 35));
        jLabel8.setPreferredSize(new java.awt.Dimension(106, 35));

        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTotalPrice.setText("0.00");

        lblAdvance.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblAdvance.setText("0.00");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Advance     : Rs.");
        jLabel11.setMaximumSize(new java.awt.Dimension(106, 35));
        jLabel11.setMinimumSize(new java.awt.Dimension(106, 35));
        jLabel11.setPreferredSize(new java.awt.Dimension(106, 35));

        btnRemove.setBackground(new java.awt.Color(255, 51, 51));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoveMouseExited(evt);
            }
        });
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Bill Details");

        btnClearAll.setBackground(new java.awt.Color(255, 51, 51));
        btnClearAll.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClearAll.setForeground(new java.awt.Color(255, 255, 255));
        btnClearAll.setText("Clear All");
        btnClearAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClearAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearAllMouseExited(evt);
            }
        });
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });

        btnOrderNow1.setBackground(new java.awt.Color(0, 204, 51));
        btnOrderNow1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOrderNow1.setForeground(new java.awt.Color(255, 255, 255));
        btnOrderNow1.setText("Order Now");
        btnOrderNow1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrderNow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrderNow1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOrderNow1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOrderNow1MouseExited(evt);
            }
        });
        btnOrderNow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderNow1ActionPerformed(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPrice.setText("0.00");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Price           : Rs.");
        jLabel12.setMaximumSize(new java.awt.Dimension(106, 35));
        jLabel12.setMinimumSize(new java.awt.Dimension(106, 35));
        jLabel12.setPreferredSize(new java.awt.Dimension(106, 35));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOrderNow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdvance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnOrderNow1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setMaximumSize(new java.awt.Dimension(512, 679));
        jPanel5.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(512, 673));

        btnBodyColor.setBackground(new java.awt.Color(51, 51, 51));
        btnBodyColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBodyColor.setForeground(new java.awt.Color(255, 255, 255));
        btnBodyColor.setText("Body Color");
        btnBodyColor.setAlignmentY(0.0F);
        btnBodyColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBodyColor.setMaximumSize(new java.awt.Dimension(120, 40));
        btnBodyColor.setMinimumSize(new java.awt.Dimension(120, 40));
        btnBodyColor.setPreferredSize(new java.awt.Dimension(120, 40));
        btnBodyColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBodyColorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodyColorMouseExited(evt);
            }
        });
        btnBodyColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBodyColorActionPerformed(evt);
            }
        });

        btnSeats.setBackground(new java.awt.Color(51, 51, 51));
        btnSeats.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSeats.setForeground(new java.awt.Color(255, 255, 255));
        btnSeats.setText("Seats");
        btnSeats.setAlignmentY(0.0F);
        btnSeats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeats.setMaximumSize(new java.awt.Dimension(120, 40));
        btnSeats.setMinimumSize(new java.awt.Dimension(120, 40));
        btnSeats.setPreferredSize(new java.awt.Dimension(120, 40));
        btnSeats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSeatsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSeatsMouseExited(evt);
            }
        });
        btnSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeatsActionPerformed(evt);
            }
        });

        btnLights.setBackground(new java.awt.Color(51, 51, 51));
        btnLights.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLights.setForeground(new java.awt.Color(255, 255, 255));
        btnLights.setText("Lights");
        btnLights.setAlignmentY(0.0F);
        btnLights.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLights.setMaximumSize(new java.awt.Dimension(120, 40));
        btnLights.setMinimumSize(new java.awt.Dimension(120, 40));
        btnLights.setPreferredSize(new java.awt.Dimension(120, 40));
        btnLights.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLightsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLightsMouseExited(evt);
            }
        });
        btnLights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLightsActionPerformed(evt);
            }
        });

        btnRimAndTyers.setBackground(new java.awt.Color(51, 51, 51));
        btnRimAndTyers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRimAndTyers.setForeground(new java.awt.Color(255, 255, 255));
        btnRimAndTyers.setText("Rim & Tyers");
        btnRimAndTyers.setAlignmentY(0.0F);
        btnRimAndTyers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRimAndTyers.setMaximumSize(new java.awt.Dimension(120, 40));
        btnRimAndTyers.setMinimumSize(new java.awt.Dimension(120, 40));
        btnRimAndTyers.setPreferredSize(new java.awt.Dimension(120, 40));
        btnRimAndTyers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRimAndTyersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRimAndTyersMouseExited(evt);
            }
        });
        btnRimAndTyers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRimAndTyersActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnMaxPrice);
        rbtnMaxPrice.setText("Maximum Price");
        rbtnMaxPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnMaxPriceMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbtnMinPrice);
        rbtnMinPrice.setText("Minimum Price");
        rbtnMinPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnMinPriceMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbtnAtoZ);
        rbtnAtoZ.setText("A to Z ");
        rbtnAtoZ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnAtoZMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbtnZtoA);
        rbtnZtoA.setText("Z to A");
        rbtnZtoA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnZtoAMouseClicked(evt);
            }
        });

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblSelectItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSelectItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelectItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblSelectItem.setGridColor(new java.awt.Color(204, 204, 204));
        tblSelectItem.setRowHeight(40);
        tblSelectItem.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tblSelectItem.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblSelectItem.setShowGrid(true);
        tblSelectItem.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblSelectItem);

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Roof");
        jButton6.setAlignmentY(0.0F);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setMaximumSize(new java.awt.Dimension(120, 40));
        jButton6.setMinimumSize(new java.awt.Dimension(120, 40));
        jButton6.setPreferredSize(new java.awt.Dimension(120, 40));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Seat Color");
        jButton7.setAlignmentY(0.0F);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setMaximumSize(new java.awt.Dimension(120, 40));
        jButton7.setMinimumSize(new java.awt.Dimension(120, 40));
        jButton7.setPreferredSize(new java.awt.Dimension(120, 40));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("NOS");
        jButton8.setAlignmentY(0.0F);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setMaximumSize(new java.awt.Dimension(120, 40));
        jButton8.setMinimumSize(new java.awt.Dimension(120, 40));
        jButton8.setPreferredSize(new java.awt.Dimension(120, 40));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Gear Box");
        jButton9.setAlignmentY(0.0F);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setMaximumSize(new java.awt.Dimension(120, 40));
        jButton9.setMinimumSize(new java.awt.Dimension(120, 40));
        jButton9.setPreferredSize(new java.awt.Dimension(120, 40));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBodyColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnMaxPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnMinPrice)
                            .addComponent(btnRimAndTyers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnAtoZ, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnZtoA, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBodyColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRimAndTyers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnMaxPrice)
                    .addComponent(rbtnMinPrice)
                    .addComponent(rbtnAtoZ)
                    .addComponent(rbtnZtoA))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Car");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tflNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tflNameActionPerformed

    private void tfnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnicActionPerformed

    private void tfemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfemailActionPerformed

    private void tfCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCityActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfCityActionPerformed

    private void tfAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAddressActionPerformed

    private void tffNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tffNameActionPerformed

    private void rbtnMaxPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnMaxPriceMouseClicked
//        System.out.println("Max");
        if (bodyColor == true) {
            bodyColorlist.mergeSortMaxToMin();
            addBodycolorToTable();
        } else if (rimAndTyers == true) {
            rimAndTyersList.mergeSortMaxToMin();
            addRimAndTyerToTable();
        } else if (seats == true) {
            seatsList.mergeSortMaxToMin();
            addSeatsToTable();
        } else if (lights == true) {
            lightList.mergeSortMaxToMin();
            addLightsToTable();
        }
    }//GEN-LAST:event_rbtnMaxPriceMouseClicked

    private void rbtnMinPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnMinPriceMouseClicked
//        System.out.println("Min");
        if (bodyColor == true) {
            bodyColorlist.mergeSortMinToMax();
            addBodycolorToTable();
        } else if (rimAndTyers == true) {
            rimAndTyersList.mergeSortMinToMax();
            addRimAndTyerToTable();
        } else if (seats == true) {
            seatsList.mergeSortMinToMax();
            addSeatsToTable();
        } else if (lights == true) {
            lightList.mergeSortMinToMax();
            addLightsToTable();
        }
    }//GEN-LAST:event_rbtnMinPriceMouseClicked

    private void rbtnAtoZMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnAtoZMouseClicked
//        System.out.println("A to Z");
        if (bodyColor == true) {
            bodyColorlist.mergeSortAToZ();
            addBodycolorToTable();
        } else if (rimAndTyers == true) {
            rimAndTyersList.mergeSortAToZ();
            addRimAndTyerToTable();
        } else if (seats == true) {
            seatsList.mergeSortAToZ();
            addSeatsToTable();
        } else if (lights == true) {
            lightList.mergeSortAToZ();
            addLightsToTable();
        }
    }//GEN-LAST:event_rbtnAtoZMouseClicked

    private void rbtnZtoAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnZtoAMouseClicked
//        System.out.println("Z to A");
        if (bodyColor == true) {
            bodyColorlist.mergeSortZToA();
            addBodycolorToTable();
        } else if (rimAndTyers == true) {
            rimAndTyersList.mergeSortZToA();
            addRimAndTyerToTable();
        } else if (seats == true) {
            seatsList.mergeSortZToA();
            addSeatsToTable();
        } else if (lights == true) {
            lightList.mergeSortZToA();
            addLightsToTable();
        }
    }//GEN-LAST:event_rbtnZtoAMouseClicked

    private void btnBodyColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBodyColorActionPerformed
        addBodycolorToTable();
        bodyColor = true;
        rimAndTyers = false;
        seats = false;
        lights = false;
    }//GEN-LAST:event_btnBodyColorActionPerformed

    private void tftelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tftelephoneActionPerformed

    private void btnRimAndTyersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRimAndTyersActionPerformed
        // TODO add your handling code here:
        addRimAndTyerToTable();
        bodyColor = false;
        rimAndTyers = true;
        seats = false;
        lights = false;
    }//GEN-LAST:event_btnRimAndTyersActionPerformed

    private void btnSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeatsActionPerformed
        // TODO add your handling code here:
        addSeatsToTable();
        bodyColor = false;
        rimAndTyers = false;
        seats = true;
        lights = false;
    }//GEN-LAST:event_btnSeatsActionPerformed

    private void btnLightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLightsActionPerformed
        // TODO add your handling code here:
        addLightsToTable();
        bodyColor = false;
        rimAndTyers = false;
        seats = false;
        lights = true;
    }//GEN-LAST:event_btnLightsActionPerformed

    public final void setIcon() {
        ImageIcon icon = new ImageIcon("C:\\Users\\Sarith\\Pictures\\Icons\\left-arrow.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lblBack.getWidth(), lblBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        lblBack.setIcon(scaledIcon);
    }
    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        MainPage page = new MainPage(linkedList, bodyColorlist, rimAndTyersList, seatsList, lightList);
        page.setVisible(true);
        page.pack();
        page.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        DefaultTableModel model = (DefaultTableModel) tblBill.getModel();

        if (tblBill.getSelectedRowCount() == 1) {
            if (tblBill.getSelectedRow() != 0) {
                model.removeRow(tblBill.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(this, "Couldn't remove vehicle form the bill table.");
            }
        } else {
            if (tblBill.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "The table is empty.");
            } else {
                JOptionPane.showMessageDialog(this, "Please, Select any single row before remove it.");
            }
        }

        updateAdvacePrice();
        updatePrice();
        updateTotalPrice();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        // TODO add your handling code here:
        int numRows = tblBill.getRowCount();
        DefaultTableModel model1 = (DefaultTableModel) tblBill.getModel();

        if (tblBill.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "The table is empty.");
        } else {
            // Remove rows from the table model
            for (int i = numRows - 1; i >= 1; i--) {
                model1.removeRow(i);
            }

            lblAdvance.setText("0.00");
            lblPrice.setText("0.00");
            lblTotalPrice.setText("0.00");
        }

        updateTotalPrice();
        updateAdvacePrice();
        updatePrice();

    }//GEN-LAST:event_btnClearAllActionPerformed

    public String findshortpathAndPrint() {
        int distance = 0;
        String shortestPath = "null";
        if (graph != null) {
            // Destination location for which shortest path is to be found
            String destination = (String) tfCity.getText();

            // Create an instance of DijkstraAlgorithm
            DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

            // Find shortest path from branch to the destination city
            distance = dijkstraAlgorithm.findShortestDistanceToLocation(graph, locations, destination);
            shortestPath = dijkstraAlgorithm.findShortestPathToLocation(graph, locations, destination);

        } else {
            System.out.println("Graph is empty");
        }
        int km = 0;
        if (distance == 0) {
            km = 10;
        } else if (distance != 0) {
            km = 10 * distance;
        }

        txtArea.setText("Days to Import the car from " + Source + " to Sri lanka " + importDay + " days." + "\nShortest path root: " + shortestPath + "\nShortest path destination: " + km + "km");
        return ("\nShortest path root from branch to customer: " + shortestPath + "\nShortest path destination: " + km + "km");

    }

    private void btnOrderNow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderNow1ActionPerformed
        // TODO add your handling code here:
        String data = txtArea.getText();
        String firstName = tffName.getText();
        String lastName = tflName.getText();
        String fullName = firstName + " " + lastName;
        String nicNo = tfnic.getText();
        String telephone = tftelephone.getText();
        String email = tfemail.getText();
        String city = tfCity.getText();
        String address = tfAddress.getText();
        String place = address + ", " + city; // Added spaces between address parts
        String deliveryPath = findshortpathAndPrint(); // Changed to camelCase

        if (data.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || nicNo.isEmpty() || telephone.isEmpty() || email.isEmpty() || city.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Some of personal details are empty. Please, check again.");
        } else {
            int numRows = tblBill.getRowCount();
            String[][] totalItem = new String[numRows][2];

            for (int i = 0; i < numRows; i++) {
                String itemName = (String) tblBill.getValueAt(i, 0);
                String price = tblBill.getValueAt(i, 1).toString(); // Directly convert Object to String
                totalItem[i][0] = itemName;
                totalItem[i][1] = price;
            }

            String information = "Full name: " + fullName + "\n"
                    + "NIC no.: " + nicNo + "\n"
                    + "Telephone: " + telephone + "\n"
                    + "Email: " + email + "\n"
                    + "Address: " + place + "\n"
                    + deliveryPath + "\n";

            int response = JOptionPane.showConfirmDialog(this, "Are you sure to confirm your order?\n" + information, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("Full name: " + fullName + "\n"
                        + "NIC no.: " + nicNo + "\n"
                        + "Telephone: " + telephone + "\n"
                        + "Email: " + email + "\n"
                        + "Address: " + place + "\n"
                        + deliveryPath + "\n"
                );
                System.out.println("\t Item \t\t Price");
                for (int i = 0; i < numRows; i++) {
                    System.out.println(totalItem[i][0] + "\t" + totalItem[i][1]);
                }
                System.out.println("--------------------------------------------------------------------------------------------");
                JOptionPane.showMessageDialog(this, "Your order is confirmed. Thank you", "Message", JOptionPane.INFORMATION_MESSAGE);

                //send a email to customer about the order details
                String to_email = email;  //livirunavaratna@gmail.com
                String from_email = "poschecar0@gmail.com";
                String from_email_password = "banb ipbh ozof fukp";
                String subject = carName;
                String details = carName + "-------------" + carPrice + "\n"
                        + "Full name: " + fullName + "\n"
                        + "NIC no.: " + nicNo + "\n"
                        + "Telephone: " + telephone + "\n"
                        + "Email: " + email + "\n"
                        + "Address: " + place + "\n"
                        + deliveryPath + "\n";

                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.ssl.protocols", "TLSv1.2");


                Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from_email, from_email_password);
                    }
                });

                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from_email));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
                    message.setSubject(subject);
                    message.setText(details);
                    Transport.send(message);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //Store table values in a NodeArry
                ArrayNode[] array = new ArrayNode[numRows];
                for (int i = 0; i < numRows; i++) {
                    String itemName = (String) tblBill.getValueAt(i, 0);
                    double price = (double) tblBill.getValueAt(i, 1); // Directly convert Object to String
                    ArrayNode newNode = new ArrayNode(itemName, price);
                    array[i] = newNode;
                }

//            for(int i = 0;i<array.length;i++){
//                ArrayNode node = array[i];
//                System.out.println(node.item+" "+node.price);
//            }
                linkedList.insertAtBack(fullName, nicNo, telephone, email, address, data, array);
                linkedList.display();

                tffName.setText("");
                tflName.setText("");
                tfnic.setText("");
                tftelephone.setText("");
                tfemail.setText("");
                tfCity.setText("");
                tfAddress.setText("");
                int numRows1 = tblSelectItem.getRowCount();
                // Get the table model
                DefaultTableModel model = (DefaultTableModel) tblSelectItem.getModel();

                // Remove rows from the table model
                for (int i = numRows1 - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
                // Get the table model
                DefaultTableModel model1 = (DefaultTableModel) tblBill.getModel();

                // Remove rows from the table model
                for (int i = numRows - 1; i >= 1; i--) {
                    model1.removeRow(i);
                }
                lblTotalPrice.setText("0.00");
                lblAdvance.setText("0.00");

                MainPage page = new MainPage(linkedList, bodyColorlist, rimAndTyersList, seatsList, lightList);
                page.setVisible(true);
                page.pack();
                page.setLocationRelativeTo(null);
                this.dispose();
            }
        }

    }//GEN-LAST:event_btnOrderNow1ActionPerformed

    private void tfCityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfCityPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tfCityPropertyChange

    private void tfCityInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tfCityInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_tfCityInputMethodTextChanged

    private void tfAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfAddressMouseClicked
        // TODO add your handling code here:
        if (tfCity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add customer city before add the address.");
        } else {
            findshortpathAndPrint();
        }
    }//GEN-LAST:event_tfAddressMouseClicked

    private void tffNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tffNameKeyTyped
        // TODO add your handling code here:
//        char c = evt.getKeyChar();
//        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
//            evt.consume();
//            tffName.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
//            tflName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tftelephone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfCity.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else {
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        }
    }//GEN-LAST:event_tffNameKeyTyped

    private void tflNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tflNameKeyTyped
        // TODO add your handling code here:
//        char c = evt.getKeyChar();
//        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
//            evt.consume();
//            tflName.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tftelephone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfCity.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else {
//            tflName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        }
    }//GEN-LAST:event_tflNameKeyTyped

    private void tfCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCityKeyTyped
        // TODO add your handling code here:
//        char c = evt.getKeyChar();
//        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
//            evt.consume();
//            tfCity.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tftelephone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else {
//            tfCity.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        }
    }//GEN-LAST:event_tfCityKeyTyped

    private void tfnicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfnicKeyTyped
        // TODO add your handling code here:
//        if (tfnic.getText().length() <= 9) {
//            tfnic.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfCity.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tftelephone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else {
//            tfnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        }
    }//GEN-LAST:event_tfnicKeyTyped

    private void tftelephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftelephoneKeyTyped
        // TODO add your handling code here:
//        char c = evt.getKeyChar();
//
//        if (!Character.isDigit(c) && c != '.') {
//            evt.consume();
//            tftelephone.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
//            tflName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfCity.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else if (tftelephone.getText().length() < 9 || tftelephone.getText().length() >= 10) {
//            tftelephone.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
//            tflName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfCity.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else {
//            tftelephone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        }
    }//GEN-LAST:event_tftelephoneKeyTyped

    private void tfAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddressKeyTyped
        // TODO add your handling code here:
//        if (tfAddress.getText().length() <= 11) {
//            tfAddress.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfCity.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tftelephone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else {
//            tfAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        }
    }//GEN-LAST:event_tfAddressKeyTyped

    private void tfemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfemailKeyTyped
        // TODO add your handling code here:
//        String email = tfemail.getText();
//
//        // Regular expression pattern for basic email validation
//        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
//
//        Pattern pattern = Pattern.compile(emailRegex);
//        Matcher matcher = pattern.matcher(email);
//
//        if (tfemail.getText().isEmpty()) {
//            tfemail.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfCity.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tftelephone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tffName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            tfnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else {
//            tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        }
    }//GEN-LAST:event_tfemailKeyTyped

    private void btnBodyColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyColorMouseEntered
        // TODO add your handling code here:
        btnBodyColor.setBackground(Color.white);

        // Change text color
        btnBodyColor.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnBodyColorMouseEntered

    private void btnBodyColorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyColorMouseExited
        // TODO add your handling code here:
        btnBodyColor.setBackground(Color.darkGray);

        // Change text color
        btnBodyColor.setForeground(Color.white);
    }//GEN-LAST:event_btnBodyColorMouseExited

    private void btnRimAndTyersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRimAndTyersMouseEntered
        // TODO add your handling code here:
        btnRimAndTyers.setBackground(Color.white);

        // Change text color
        btnRimAndTyers.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnRimAndTyersMouseEntered

    private void btnRimAndTyersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRimAndTyersMouseExited
        // TODO add your handling code here:
        btnRimAndTyers.setBackground(Color.darkGray);

        // Change text color
        btnRimAndTyers.setForeground(Color.white);
    }//GEN-LAST:event_btnRimAndTyersMouseExited

    private void btnSeatsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeatsMouseEntered
        // TODO add your handling code here:
        btnSeats.setBackground(Color.white);

        // Change text color
        btnSeats.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnSeatsMouseEntered

    private void btnSeatsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeatsMouseExited
        // TODO add your handling code here:
        btnSeats.setBackground(Color.darkGray);

        // Change text color
        btnSeats.setForeground(Color.white);
    }//GEN-LAST:event_btnSeatsMouseExited

    private void btnLightsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLightsMouseEntered
        // TODO add your handling code here:
        btnLights.setBackground(Color.white);

        // Change text color
        btnLights.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnLightsMouseEntered

    private void btnLightsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLightsMouseExited
        // TODO add your handling code here:
        btnLights.setBackground(Color.darkGray);

        // Change text color
        btnLights.setForeground(Color.white);
    }//GEN-LAST:event_btnLightsMouseExited

    private void btnRemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseEntered
        // TODO add your handling code here:
        btnRemove.setBackground(Color.white);

        // Change text color
        btnRemove.setForeground(Color.red);
    }//GEN-LAST:event_btnRemoveMouseEntered

    private void btnRemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseExited
        // TODO add your handling code here:
        btnRemove.setBackground(Color.red);

        // Change text color
        btnRemove.setForeground(Color.white);
    }//GEN-LAST:event_btnRemoveMouseExited

    private void btnClearAllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearAllMouseEntered
        // TODO add your handling code here:
        btnClearAll.setBackground(Color.white);

        // Change text color
        btnClearAll.setForeground(Color.red);
    }//GEN-LAST:event_btnClearAllMouseEntered

    private void btnClearAllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearAllMouseExited
        // TODO add your handling code here:
        btnClearAll.setBackground(Color.red);

        // Change text color
        btnClearAll.setForeground(Color.white);
    }//GEN-LAST:event_btnClearAllMouseExited

    private void btnOrderNow1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderNow1MouseEntered
        // TODO add your handling code here:
        btnOrderNow1.setBackground(Color.white);

        // Change text color
        btnOrderNow1.setForeground(Color.green);
    }//GEN-LAST:event_btnOrderNow1MouseEntered

    private void btnOrderNow1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderNow1MouseExited
        // TODO add your handling code here:
        btnOrderNow1.setBackground(Color.green);

        // Change text color
        btnOrderNow1.setForeground(Color.white);
    }//GEN-LAST:event_btnOrderNow1MouseExited

    private void btnOrderNow1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderNow1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnOrderNow1MouseClicked

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setBackground(Color.white);

        // Change text color
        jButton6.setForeground(Color.darkGray);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
        jButton6.setBackground(Color.darkGray);

        // Change text color
        jButton6.setForeground(Color.white);
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        jButton7.setBackground(Color.white);

        // Change text color
        jButton7.setForeground(Color.darkGray);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
        jButton7.setBackground(Color.darkGray);

        // Change text color
        jButton7.setForeground(Color.white);
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        // TODO add your handling code here:
        jButton8.setBackground(Color.white);

        // Change text color
        jButton8.setForeground(Color.darkGray);
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        // TODO add your handling code here:
        jButton8.setBackground(Color.darkGray);

        // Change text color
        jButton8.setForeground(Color.white);
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
        jButton9.setBackground(Color.white);

        // Change text color
        jButton9.setForeground(Color.darkGray);
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        // TODO add your handling code here:
        jButton9.setBackground(Color.darkGray);

        // Change text color
        jButton9.setForeground(Color.white);
    }//GEN-LAST:event_jButton9MouseExited

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CustomizationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomizationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomizationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomizationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomizationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBodyColor;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnLights;
    private javax.swing.JButton btnOrderNow1;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRimAndTyers;
    private javax.swing.JButton btnSeats;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAdvance;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JRadioButton rbtnAtoZ;
    private javax.swing.JRadioButton rbtnMaxPrice;
    private javax.swing.JRadioButton rbtnMinPrice;
    private javax.swing.JRadioButton rbtnZtoA;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblSelectItem;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfCity;
    private javax.swing.JTextField tfemail;
    private javax.swing.JTextField tffName;
    private javax.swing.JTextField tflName;
    private javax.swing.JTextField tfnic;
    private javax.swing.JTextField tftelephone;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables

}

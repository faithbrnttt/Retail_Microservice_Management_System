/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fabsystems.main;

//package imports
import com.fabsystems.db.EmployeeIO;
import com.fabsystems.db.PayrollIO;
import com.fabsystems.db.ProductIO;
import com.fabsystems.login.AdminLoginForm;
import com.fabsystems.login.Bcrypt;

//general imports
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

//exception imports
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;

//swing imports
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author faith
 */
public class MainForm extends javax.swing.JFrame {

    DefaultTableModel productModel, employeeModel;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();

        //set icon
        Image logo = Toolkit.getDefaultToolkit().getImage("src/com/fabsystems/resources/appIcon.png");
        this.setIconImage(logo);

        //set location of frame on screen to center
        this.setLocationRelativeTo(null);

        //set background color of frame
        this.getContentPane().setBackground(new Color(51, 51, 51));

        //set company text for company news letter in txaHome
        txaHome.setText("""
                        The standard Lorem Ipsum passage, used since the 1500s
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                        
                        Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"
                        
                        1914 translation by H. Rackham
                        "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?"
                        
                        Section 1.10.33 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC
                        "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."
                        
                        1914 translation by H. Rackham
                        "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains."
                       """);

        //changing font size of table headers
        Font font = UIManager.getFont("TableHeader.font");
        font = font.deriveFont(20f);
        UIManager.put("TableHeader.font", font);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgPayType = new javax.swing.ButtonGroup();
        btgEmployeeType = new javax.swing.ButtonGroup();
        pnlMenu = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        btnEmployees = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        lblHomeHeader = new javax.swing.JLabel();
        scpHome = new javax.swing.JScrollPane();
        txaHome = new javax.swing.JTextArea();
        pnlInventory = new javax.swing.JPanel();
        lblInventoryHeader = new javax.swing.JLabel();
        scpInventory = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btnAddProduct = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        btnRemoveProduct = new javax.swing.JButton();
        pnlInventoryForm = new javax.swing.JPanel();
        lblInventoryFormHeader = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        lblProductSku = new javax.swing.JLabel();
        txtProductSku = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtProductDescription = new javax.swing.JTextField();
        lblProductSupplier = new javax.swing.JLabel();
        txtProductSupplier = new javax.swing.JTextField();
        lblProductUnitCost = new javax.swing.JLabel();
        txtProductUnitCost = new javax.swing.JTextField();
        lblProductSalePrice = new javax.swing.JLabel();
        txtProductSalePrice = new javax.swing.JTextField();
        lblProductQuantity = new javax.swing.JLabel();
        txtProductQuantity = new javax.swing.JTextField();
        lblProductTotalValue = new javax.swing.JLabel();
        txtProductTotalValue = new javax.swing.JTextField();
        btnSaveProduct = new javax.swing.JButton();
        btnSaveProductUpdate = new javax.swing.JButton();
        pnlEmployees = new javax.swing.JPanel();
        lblEmployeeHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        btnAddEmployee = new javax.swing.JButton();
        btnUpdateEmployee = new javax.swing.JButton();
        btnRemoveEmployee = new javax.swing.JButton();
        btnPreparePayroll = new javax.swing.JButton();
        pnlEmployeeForm = new javax.swing.JPanel();
        lblEmployeeFormHeader = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();
        lblLName = new javax.swing.JLabel();
        lblSSN = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblAptSuite = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblZip = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        lblHireDate = new javax.swing.JLabel();
        lblSalary = new javax.swing.JLabel();
        lblPayRate = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblBadge = new javax.swing.JLabel();
        chkEmployeeAdmin = new javax.swing.JCheckBox();
        rdoFullTime = new javax.swing.JRadioButton();
        rdoPartTime = new javax.swing.JRadioButton();
        rdoSalary = new javax.swing.JRadioButton();
        rdoHourly = new javax.swing.JRadioButton();
        txtEmployeePosition = new javax.swing.JTextField();
        txtEmployeePhone = new javax.swing.JTextField();
        txtEmployeeZip = new javax.swing.JTextField();
        txtEmployeeState = new javax.swing.JTextField();
        txtEmployeeCity = new javax.swing.JTextField();
        txtEmployeeAptSuite = new javax.swing.JTextField();
        txtEmployeeAddress = new javax.swing.JTextField();
        txtEmployeeSSN = new javax.swing.JTextField();
        txtEmployeeLastName = new javax.swing.JTextField();
        txtEmployeeFirstName = new javax.swing.JTextField();
        txtEmployeeSalary = new javax.swing.JTextField();
        txtEmployeePayRate = new javax.swing.JTextField();
        txtEmployeeUsername = new javax.swing.JTextField();
        pwfEmployeePassword = new javax.swing.JPasswordField();
        btnSaveEmployee = new javax.swing.JButton();
        btnEmployeeUpdate = new javax.swing.JButton();
        txtEmployeeHireDate = new javax.swing.JTextField();
        txtEmployeeBadge = new javax.swing.JTextField();
        pnlPayroll = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPayroll = new javax.swing.JTable();
        btnStubs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FAB Systems");
        setPreferredSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlMenu.setBackground(new java.awt.Color(51, 51, 51));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/home.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/home2.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/logout.png"))); // NOI18N
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/logout2.png"))); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/inventory.png"))); // NOI18N
        btnInventory.setBorderPainted(false);
        btnInventory.setContentAreaFilled(false);
        btnInventory.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/inventory2.png"))); // NOI18N
        btnInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryActionPerformed(evt);
            }
        });

        btnEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/employees.png"))); // NOI18N
        btnEmployees.setBorderPainted(false);
        btnEmployees.setContentAreaFilled(false);
        btnEmployees.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/employees2.png"))); // NOI18N
        btnEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesActionPerformed(evt);
            }
        });

        btnReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/reports.png"))); // NOI18N
        btnReports.setBorderPainted(false);
        btnReports.setContentAreaFilled(false);
        btnReports.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fabsystems/resources/reports2.png"))); // NOI18N
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Dialog.plain", 1, 20)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInventory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmployees)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReports)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout)
                .addGap(189, 189, 189))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEmployees, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnHome)
                                .addComponent(btnInventory)))
                        .addComponent(btnReports))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        getContentPane().add(pnlMenu);

        pnlMain.setBackground(new java.awt.Color(51, 51, 51));
        pnlMain.setLayout(new java.awt.CardLayout());

        pnlHome.setBackground(new java.awt.Color(51, 51, 51));

        lblHomeHeader.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        lblHomeHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHomeHeader.setText("Welcome to FAB Systems");

        txaHome.setEditable(false);
        txaHome.setColumns(20);
        txaHome.setLineWrap(true);
        txaHome.setRows(5);
        scpHome.setViewportView(txaHome);

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(622, 622, 622)
                .addComponent(lblHomeHeader)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHomeLayout.createSequentialGroup()
                .addContainerGap(403, Short.MAX_VALUE)
                .addComponent(scpHome, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(378, 378, 378))
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblHomeHeader)
                .addGap(59, 59, 59)
                .addComponent(scpHome, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(408, Short.MAX_VALUE))
        );

        pnlMain.add(pnlHome, "card2");

        pnlInventory.setBackground(new java.awt.Color(51, 51, 51));

        lblInventoryHeader.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        lblInventoryHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblInventoryHeader.setText("Inventory Management");

        scpInventory.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N

        tblProducts.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Sku", "Description", "Supplier", "Unit Cost", "Sale Price", "Quantity", "Total Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        scpInventory.setViewportView(tblProducts);

        btnAddProduct.setBackground(new java.awt.Color(18, 185, 150));
        btnAddProduct.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnAddProduct.setText("Add Product");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnUpdateProduct.setBackground(new java.awt.Color(18, 185, 150));
        btnUpdateProduct.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnUpdateProduct.setText("Update Product");
        btnUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProductActionPerformed(evt);
            }
        });

        btnRemoveProduct.setBackground(new java.awt.Color(18, 185, 150));
        btnRemoveProduct.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnRemoveProduct.setText("Remove Product");
        btnRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInventoryLayout = new javax.swing.GroupLayout(pnlInventory);
        pnlInventory.setLayout(pnlInventoryLayout);
        pnlInventoryLayout.setHorizontalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addGap(635, 635, 635)
                .addComponent(lblInventoryHeader)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInventoryLayout.createSequentialGroup()
                .addContainerGap(403, Short.MAX_VALUE)
                .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInventoryLayout.createSequentialGroup()
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(btnUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(btnRemoveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(393, 393, 393))
        );
        pnlInventoryLayout.setVerticalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblInventoryHeader)
                .addGap(39, 39, 39)
                .addComponent(scpInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduct)
                    .addComponent(btnUpdateProduct)
                    .addComponent(btnRemoveProduct))
                .addContainerGap(379, Short.MAX_VALUE))
        );

        pnlMain.add(pnlInventory, "card3");

        pnlInventoryForm.setBackground(new java.awt.Color(51, 51, 51));

        lblInventoryFormHeader.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        lblInventoryFormHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblInventoryFormHeader.setText("Add/Update Inventory Items");

        lblProductName.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblProductName.setForeground(new java.awt.Color(255, 255, 255));
        lblProductName.setText("Name");

        lblProductSku.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblProductSku.setForeground(new java.awt.Color(255, 255, 255));
        lblProductSku.setText("Sku");

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Description");

        lblProductSupplier.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblProductSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lblProductSupplier.setText("Supplier");

        lblProductUnitCost.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblProductUnitCost.setForeground(new java.awt.Color(255, 255, 255));
        lblProductUnitCost.setText("Unit Cost");

        lblProductSalePrice.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblProductSalePrice.setForeground(new java.awt.Color(255, 255, 255));
        lblProductSalePrice.setText("Sale Price");

        lblProductQuantity.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblProductQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblProductQuantity.setText("Quantity");

        lblProductTotalValue.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblProductTotalValue.setForeground(new java.awt.Color(255, 255, 255));
        lblProductTotalValue.setText("Total Value");

        btnSaveProduct.setBackground(new java.awt.Color(18, 185, 150));
        btnSaveProduct.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnSaveProduct.setText("Save Product");
        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductActionPerformed(evt);
            }
        });

        btnSaveProductUpdate.setBackground(new java.awt.Color(18, 185, 150));
        btnSaveProductUpdate.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnSaveProductUpdate.setText("Save Update");
        btnSaveProductUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInventoryFormLayout = new javax.swing.GroupLayout(pnlInventoryForm);
        pnlInventoryForm.setLayout(pnlInventoryFormLayout);
        pnlInventoryFormLayout.setHorizontalGroup(
            pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryFormLayout.createSequentialGroup()
                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInventoryFormLayout.createSequentialGroup()
                        .addGap(618, 618, 618)
                        .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInventoryFormLayout.createSequentialGroup()
                                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblProductTotalValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProductUnitCost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProductSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProductSku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProductName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProductSalePrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProductQuantity)
                                    .addComponent(txtProductTotalValue)
                                    .addComponent(txtProductUnitCost)
                                    .addComponent(txtProductSalePrice)
                                    .addComponent(txtProductName)
                                    .addComponent(txtProductDescription)
                                    .addComponent(txtProductSku)
                                    .addComponent(txtProductSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlInventoryFormLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSaveProductUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlInventoryFormLayout.createSequentialGroup()
                        .addGap(588, 588, 588)
                        .addComponent(lblInventoryFormHeader)))
                .addContainerGap(595, Short.MAX_VALUE))
        );
        pnlInventoryFormLayout.setVerticalGroup(
            pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryFormLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblInventoryFormHeader)
                .addGap(80, 80, 80)
                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductSku)
                    .addComponent(txtProductSku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductSupplier)
                    .addComponent(txtProductSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductUnitCost)
                    .addComponent(txtProductUnitCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductSalePrice)
                    .addComponent(txtProductSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductQuantity)
                    .addComponent(txtProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInventoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductTotalValue)
                    .addComponent(txtProductTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnSaveProduct)
                .addGap(18, 18, 18)
                .addComponent(btnSaveProductUpdate)
                .addContainerGap(369, Short.MAX_VALUE))
        );

        pnlMain.add(pnlInventoryForm, "card4");

        pnlEmployees.setBackground(new java.awt.Color(51, 51, 51));

        lblEmployeeHeader.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        lblEmployeeHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeHeader.setText("Employee Management");

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "SSN", "Address", "Apt/Suite", "City", "State", "Zip", "Phone", "Position", "Type", "Hire Date", "Pay Type", "Salary", "Pay Rate", "Username", "Password", "Badge", "Admin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployees);

        btnAddEmployee.setBackground(new java.awt.Color(18, 185, 150));
        btnAddEmployee.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnAddEmployee.setText("Add Employee");
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        btnUpdateEmployee.setBackground(new java.awt.Color(18, 185, 150));
        btnUpdateEmployee.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnUpdateEmployee.setText("Update Employee");
        btnUpdateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEmployeeActionPerformed(evt);
            }
        });

        btnRemoveEmployee.setBackground(new java.awt.Color(18, 185, 150));
        btnRemoveEmployee.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnRemoveEmployee.setText("Remove Employee");
        btnRemoveEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveEmployeeActionPerformed(evt);
            }
        });

        btnPreparePayroll.setBackground(new java.awt.Color(18, 185, 150));
        btnPreparePayroll.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnPreparePayroll.setText("Prepare Payroll");
        btnPreparePayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreparePayrollActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEmployeesLayout = new javax.swing.GroupLayout(pnlEmployees);
        pnlEmployees.setLayout(pnlEmployeesLayout);
        pnlEmployeesLayout.setHorizontalGroup(
            pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeesLayout.createSequentialGroup()
                .addGap(636, 636, 636)
                .addComponent(lblEmployeeHeader)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmployeesLayout.createSequentialGroup()
                .addGap(0, 389, Short.MAX_VALUE)
                .addGroup(pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEmployeesLayout.createSequentialGroup()
                        .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnUpdateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnPreparePayroll, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(379, 379, 379))
        );
        pnlEmployeesLayout.setVerticalGroup(
            pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblEmployeeHeader)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddEmployee)
                    .addComponent(btnRemoveEmployee)
                    .addComponent(btnUpdateEmployee)
                    .addComponent(btnPreparePayroll))
                .addContainerGap(379, Short.MAX_VALUE))
        );

        pnlMain.add(pnlEmployees, "card5");

        pnlEmployeeForm.setBackground(new java.awt.Color(51, 51, 51));

        lblEmployeeFormHeader.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        lblEmployeeFormHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeFormHeader.setText("Add/Update Employee");

        lblFName.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblFName.setForeground(new java.awt.Color(255, 255, 255));
        lblFName.setText("First Name:");

        lblLName.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblLName.setForeground(new java.awt.Color(255, 255, 255));
        lblLName.setText("Last Name:");

        lblSSN.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblSSN.setForeground(new java.awt.Color(255, 255, 255));
        lblSSN.setText("SSN:");

        lblAddress.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Address:");

        lblAptSuite.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblAptSuite.setForeground(new java.awt.Color(255, 255, 255));
        lblAptSuite.setText("Apt/Suite:");

        lblCity.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblCity.setForeground(new java.awt.Color(255, 255, 255));
        lblCity.setText("City:");

        lblState.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblState.setForeground(new java.awt.Color(255, 255, 255));
        lblState.setText("State:");

        lblZip.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblZip.setForeground(new java.awt.Color(255, 255, 255));
        lblZip.setText("Zip:");

        lblPhone.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setText("Phone:");

        lblPosition.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblPosition.setForeground(new java.awt.Color(255, 255, 255));
        lblPosition.setText("Position:");

        lblHireDate.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblHireDate.setForeground(new java.awt.Color(255, 255, 255));
        lblHireDate.setText("Hire Date:");

        lblSalary.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblSalary.setForeground(new java.awt.Color(255, 255, 255));
        lblSalary.setText("Salary:");

        lblPayRate.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblPayRate.setForeground(new java.awt.Color(255, 255, 255));
        lblPayRate.setText("Pay Rate:");

        lblUsername.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username:");

        lblPassword.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password:");

        lblBadge.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        lblBadge.setForeground(new java.awt.Color(255, 255, 255));
        lblBadge.setText("Badge:");

        chkEmployeeAdmin.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        chkEmployeeAdmin.setForeground(new java.awt.Color(255, 255, 255));
        chkEmployeeAdmin.setText("Admin");

        btgEmployeeType.add(rdoFullTime);
        rdoFullTime.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        rdoFullTime.setForeground(new java.awt.Color(255, 255, 255));
        rdoFullTime.setText("Full-Time");
        rdoFullTime.setNextFocusableComponent(rdoPartTime);

        btgEmployeeType.add(rdoPartTime);
        rdoPartTime.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        rdoPartTime.setForeground(new java.awt.Color(255, 255, 255));
        rdoPartTime.setSelected(true);
        rdoPartTime.setText("Part-Time");
        rdoPartTime.setNextFocusableComponent(rdoSalary);

        btgPayType.add(rdoSalary);
        rdoSalary.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        rdoSalary.setForeground(new java.awt.Color(255, 255, 255));
        rdoSalary.setText("Salary");
        rdoSalary.setNextFocusableComponent(rdoHourly);
        rdoSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSalaryActionPerformed(evt);
            }
        });

        btgPayType.add(rdoHourly);
        rdoHourly.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        rdoHourly.setForeground(new java.awt.Color(255, 255, 255));
        rdoHourly.setText("Hourly");
        rdoHourly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHourlyActionPerformed(evt);
            }
        });

        txtEmployeePosition.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeePosition.setNextFocusableComponent(rdoFullTime);

        txtEmployeePhone.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeePhone.setNextFocusableComponent(txtEmployeePosition);

        txtEmployeeZip.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeZip.setNextFocusableComponent(txtEmployeePhone);

        txtEmployeeState.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeState.setNextFocusableComponent(txtEmployeeZip);

        txtEmployeeCity.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeCity.setNextFocusableComponent(txtEmployeeState);

        txtEmployeeAptSuite.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeAptSuite.setNextFocusableComponent(txtEmployeeCity);

        txtEmployeeAddress.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeAddress.setNextFocusableComponent(txtEmployeeAptSuite);

        txtEmployeeSSN.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeSSN.setNextFocusableComponent(txtEmployeeAddress);

        txtEmployeeLastName.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeLastName.setNextFocusableComponent(txtEmployeeSSN);

        txtEmployeeFirstName.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeFirstName.setNextFocusableComponent(txtEmployeeLastName);

        txtEmployeeSalary.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeSalary.setNextFocusableComponent(txtEmployeeUsername);

        txtEmployeePayRate.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeePayRate.setNextFocusableComponent(txtEmployeeUsername);

        txtEmployeeUsername.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        txtEmployeeUsername.setNextFocusableComponent(pwfEmployeePassword);

        pwfEmployeePassword.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        pwfEmployeePassword.setNextFocusableComponent(chkEmployeeAdmin);

        btnSaveEmployee.setBackground(new java.awt.Color(18, 185, 150));
        btnSaveEmployee.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnSaveEmployee.setText("Save Employee");
        btnSaveEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEmployeeActionPerformed(evt);
            }
        });

        btnEmployeeUpdate.setBackground(new java.awt.Color(18, 185, 150));
        btnEmployeeUpdate.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnEmployeeUpdate.setText("Update Employee");

        txtEmployeeHireDate.setEditable(false);
        txtEmployeeHireDate.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N

        txtEmployeeBadge.setEditable(false);
        txtEmployeeBadge.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N

        javax.swing.GroupLayout pnlEmployeeFormLayout = new javax.swing.GroupLayout(pnlEmployeeForm);
        pnlEmployeeForm.setLayout(pnlEmployeeFormLayout);
        pnlEmployeeFormLayout.setHorizontalGroup(
            pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                        .addGap(636, 636, 636)
                        .addComponent(lblEmployeeFormHeader))
                    .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblZip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSSN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAptSuite, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmployeePosition)
                            .addComponent(txtEmployeePhone)
                            .addComponent(txtEmployeeZip)
                            .addComponent(txtEmployeeState)
                            .addComponent(txtEmployeeCity)
                            .addComponent(txtEmployeeAptSuite)
                            .addComponent(txtEmployeeAddress)
                            .addComponent(txtEmployeeSSN)
                            .addComponent(txtEmployeeLastName)
                            .addComponent(txtEmployeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(178, 178, 178)
                        .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoFullTime)
                                    .addComponent(rdoSalary))
                                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(rdoPartTime))
                                    .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(rdoHourly))))
                            .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEmployeeFormLayout.createSequentialGroup()
                                    .addComponent(lblHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEmployeeHireDate))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEmployeeFormLayout.createSequentialGroup()
                                    .addComponent(lblSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPayRate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmployeePayRate, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblBadge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pwfEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmployeeBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(chkEmployeeAdmin)
                            .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                                .addComponent(btnSaveEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEmployeeUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        pnlEmployeeFormLayout.setVerticalGroup(
            pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeeFormLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblEmployeeFormHeader)
                .addGap(37, 37, 37)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFName)
                    .addComponent(txtEmployeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoFullTime)
                    .addComponent(rdoPartTime))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLName)
                    .addComponent(txtEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHireDate)
                    .addComponent(txtEmployeeHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSSN)
                    .addComponent(txtEmployeeSSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoSalary)
                    .addComponent(rdoHourly))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtEmployeeAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalary)
                    .addComponent(txtEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAptSuite)
                    .addComponent(txtEmployeeAptSuite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPayRate)
                    .addComponent(txtEmployeePayRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCity)
                    .addComponent(txtEmployeeCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername)
                    .addComponent(txtEmployeeUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pwfEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblState)
                        .addComponent(txtEmployeeState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZip)
                    .addComponent(txtEmployeeZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBadge)
                    .addComponent(txtEmployeeBadge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtEmployeePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkEmployeeAdmin))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition)
                    .addComponent(txtEmployeePosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveEmployee)
                    .addComponent(btnEmployeeUpdate))
                .addContainerGap(438, Short.MAX_VALUE))
        );

        pnlMain.add(pnlEmployeeForm, "card6");

        pnlPayroll.setBackground(new java.awt.Color(51, 51, 51));

        tblPayroll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "SSN", "Address", "Apt/Suite", "City", "State", "Zip", "Start Date", "End Date", "Pay Type", "Salary", "Hourly Rate", "Hours Worked", "Gross", "MedicareTax", "Social Security", "FederalTax", "StateTax", "Deductions", "Net Pay"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPayroll);

        btnStubs.setBackground(new java.awt.Color(18, 185, 150));
        btnStubs.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnStubs.setText("Print Stubs");

        javax.swing.GroupLayout pnlPayrollLayout = new javax.swing.GroupLayout(pnlPayroll);
        pnlPayroll.setLayout(pnlPayrollLayout);
        pnlPayrollLayout.setHorizontalGroup(
            pnlPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPayrollLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addGroup(pnlPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStubs, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        pnlPayrollLayout.setVerticalGroup(
            pnlPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPayrollLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnStubs)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        pnlMain.add(pnlPayroll, "card7");

        getContentPane().add(pnlMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //creating navigation by calling addPanel method to display panels on button clicks
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        pnlMain.removeAll();
        pnlMain.repaint();
        pnlMain.add(pnlHome);
        pnlMain.revalidate();
        pnlMain.validate();
    }//GEN-LAST:event_btnHomeActionPerformed

    //when menu button inventory pressed if user has admin privileges they will be redirected to the inventory page
    private void btnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryActionPerformed
        pnlMain.removeAll();
        pnlMain.repaint();
        pnlMain.add(pnlInventory);
        pnlMain.revalidate();
        pnlMain.validate();

        //create table model 
        DefaultTableModel productModel = (DefaultTableModel) tblProducts.getModel();
        //clear table rows to display fresh data set
        productModel.setRowCount(0);
        //read data records
        ProductIO pio = new ProductIO();
        try {
            ArrayList<Product> products = pio.getProductList();

            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);

                Object[] row = {p.getProductID(), p.getProductName(), p.getProductSku(), p.getProductDescription(),
                    p.getProductSupplier(), p.getProductUnitCost(), p.getProductSalePrice(), p.getProductQuantity(),
                    p.getProductTotalValue()};
                productModel.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error. Database driver not found.", "Driver not found.", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error." + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnInventoryActionPerformed

    //when add product button pressed the user will be redirected to the inventory form page to save product to database and display in table
    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        pnlMain.removeAll();
        pnlMain.add(pnlInventoryForm);
        pnlMain.revalidate();
        pnlMain.validate();
        
        btnSaveProductUpdate.setVisible(false);
        btnSaveProduct.setVisible(true);
    }//GEN-LAST:event_btnAddProductActionPerformed

    //when update product button pressed the user will be redirected to the inventory form page to update product and save changes to database and table
    private void btnUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProductActionPerformed
        pnlMain.removeAll();
        pnlMain.add(pnlInventoryForm);
        pnlMain.revalidate();
        pnlMain.validate();
        
        btnSaveProductUpdate.setVisible(true);
        btnSaveProduct.setVisible(false);

    }//GEN-LAST:event_btnUpdateProductActionPerformed

    //when menu button employees is pressed if user has admin privileges they will be redirected to the              employees page
    private void btnEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesActionPerformed
        pnlMain.removeAll();
        pnlMain.repaint();
        pnlMain.add(pnlEmployees);
        pnlMain.revalidate();
        pnlMain.validate();
        //create table model
        employeeModel = (DefaultTableModel) tblEmployees.getModel();
        //clear table rows to display fresh data set
        employeeModel.setRowCount(0);
        //read data records
        EmployeeIO eio = new EmployeeIO();
        try {
            ArrayList<Employee> employees = eio.getEmployeeList();

            for (int i = 0; i < employees.size(); i++) {
                Employee e = employees.get(i);

                Object[] row = {e.getEmpId(), e.getEmpFName(), e.getEmpLName(), e.getEmpSsec(), e.getEmpAddress(), e.getEmpAddress2(),
                    e.getEmpCity(), e.getEmpState(), e.getEmpZip(), e.getEmpPhone(), e.getEmpPosition(), e.getEmpType(), e.getEmpHireDate(),
                    e.getEmpPayType(), e.getEmpSalary(), e.getEmpPayRate(), e.getEmpUsername(), e.getEmpPassword(), e.getEmpBadge(), e.getEmpAdmin()};
                employeeModel.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error. Database driver not found.", "Driver not found.", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error." + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_btnEmployeesActionPerformed

    //when menu button reports is pressed if user has admin privileges they will be redirected to the reports page
    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
//        addPanel(pnlReports);
    }//GEN-LAST:event_btnReportsActionPerformed

    //when logout button pressed the window will close and a new login window will show for a new session
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        AdminLoginForm alf = new AdminLoginForm();
        alf.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    //when save product button pressed textfield data is retrieved and saved to table and database
    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed
        if (validateProductInputs() == false) {
            return;
        }
        Product p = createProduct();
        ProductIO pio = new ProductIO();
        try {
            pio.addProducts(p, txtProductName);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Driver Error.", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        }

        displayProductData(p, pio);
    }//GEN-LAST:event_btnSaveProductActionPerformed

    //when table row selected it will auto-fill textfields/ used for updating product data
    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        productModel = (DefaultTableModel) tblProducts.getModel();
        txtProductName.setText(productModel.getValueAt(tblProducts.getSelectedRow(), 1).toString());
        txtProductSku.setText(productModel.getValueAt(tblProducts.getSelectedRow(), 2).toString());
        txtProductDescription.setText(productModel.getValueAt(tblProducts.getSelectedRow(), 3).toString());
        txtProductSupplier.setText(productModel.getValueAt(tblProducts.getSelectedRow(), 4).toString());
        txtProductUnitCost.setText(productModel.getValueAt(tblProducts.getSelectedRow(), 5).toString());
        txtProductSalePrice.setText(productModel.getValueAt(tblProducts.getSelectedRow(), 6).toString());
        txtProductQuantity.setText(productModel.getValueAt(tblProducts.getSelectedRow(), 7).toString());
        txtProductTotalValue.setText(productModel.getValueAt(tblProducts.getSelectedRow(), 8).toString());
    }//GEN-LAST:event_tblProductsMouseClicked

    //when save product update button pressed the changes you made to the textfields will update in the table and database
    private void btnSaveProductUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductUpdateActionPerformed
        if (validateProductInputs() == false) {
            return;
        }
        Product p = createProduct();
        ProductIO pio = new ProductIO();
        try {
            pio.updateProduct(p);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Driver Error.", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        }

        displayProductData(p, pio);
    }//GEN-LAST:event_btnSaveProductUpdateActionPerformed

    //when remove product button is pressed the selected row will be deleted from inventory as well as the database
    private void btnRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProductActionPerformed
        int row = tblProducts.getSelectedRow();
        String value = tblProducts.getModel().getValueAt(row, 1).toString();

        ProductIO pio = new ProductIO();
        try {
            pio.removeProduct(value);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error." + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error. Database driver not found.", "Driver not found.", JOptionPane.ERROR_MESSAGE);
        }

        productModel.removeRow(tblProducts.getSelectedRow());
    }//GEN-LAST:event_btnRemoveProductActionPerformed

    private void btnPreparePayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreparePayrollActionPerformed
       pnlMain.removeAll();
       pnlMain.add(pnlPayroll);
       pnlMain.revalidate();
       pnlMain.validate();
       
       PayrollIO pio = new PayrollIO();
       
        try {
            pio.addPayroll();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }//GEN-LAST:event_btnPreparePayrollActionPerformed

    private void btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeeActionPerformed
        pnlMain.removeAll();
        pnlMain.add(pnlEmployeeForm);
        pnlMain.revalidate();
        pnlMain.validate();
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd MMM yyyy HH:mm:ss z");
        String date = simpleDateFormat.format(new Date());
        txtEmployeeHireDate.setText(date);
        
        txtEmployeeBadge.setText(generateString());
        
        txtEmployeeSalary.setVisible(false);
        txtEmployeePayRate.setVisible(false);
        lblSalary.setVisible(false);
        lblPayRate.setVisible(false);
        
        btnSaveEmployee.setVisible(true);
        btnEmployeeUpdate.setVisible(false);
    }//GEN-LAST:event_btnAddEmployeeActionPerformed

    private void btnUpdateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEmployeeActionPerformed
        pnlMain.removeAll();
        pnlMain.add(pnlEmployeeForm);
        pnlMain.revalidate();
        pnlMain.validate();
        
        btnSaveEmployee.setVisible(false);
        btnEmployeeUpdate.setVisible(true);
    }//GEN-LAST:event_btnUpdateEmployeeActionPerformed

    private void btnRemoveEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveEmployeeActionPerformed
        int row = tblEmployees.getSelectedRow();
        int value = (int) tblEmployees.getModel().getValueAt(row, 1);

        EmployeeIO eio = new EmployeeIO();
        try {
            eio.removeEmployee(value);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error." + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error. Database driver not found.", "Driver not found.", JOptionPane.ERROR_MESSAGE);
        }

        employeeModel.removeRow(tblEmployees.getSelectedRow());
    }//GEN-LAST:event_btnRemoveEmployeeActionPerformed

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked
        employeeModel = (DefaultTableModel) tblEmployees.getModel();
        txtEmployeeFirstName.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 1).toString());
        txtEmployeeLastName.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 2).toString());
        txtEmployeeSSN.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 3).toString());
        txtEmployeeAddress.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 4).toString());
        txtEmployeeAptSuite.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 5).toString());
        txtEmployeeCity.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 6).toString());
        txtEmployeeState.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 7).toString());
        txtEmployeeZip.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 8).toString());
        txtEmployeePhone.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 9).toString());
        txtEmployeePosition.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 10).toString());
        if(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 11).toString().equals("Full-Time")){
            rdoFullTime.setSelected(true);
        }else{
            rdoPartTime.setSelected(true);
        }
        txtEmployeeHireDate.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 12).toString());
        if(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 13).toString().equals("Salary")){
            rdoSalary.setSelected(true);
        }else{
            rdoHourly.setSelected(true);
        }
        txtEmployeeSalary.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 14).toString());
        txtEmployeePayRate.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 15).toString());
        txtEmployeeUsername.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 16).toString());
        pwfEmployeePassword.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 17).toString());
        txtEmployeeBadge.setText(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 18).toString());
        if(employeeModel.getValueAt(tblEmployees.getSelectedRow(), 19).equals(true)){
            chkEmployeeAdmin.setSelected(true);
            
        }else{
            chkEmployeeAdmin.setSelected(false);
        }
    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void btnSaveEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEmployeeActionPerformed
        if (validateEmployeeInputs() == false) {
            return;
        }
        
        Employee e = new Employee();
        EmployeeIO eio = new EmployeeIO();

        try {
            e = createEmployee();
            eio.addEmployees(e, txtEmployeeFirstName);
            clearEmployeeFields();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Driver Error.", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        displayEmployeeData(e, eio);
    }//GEN-LAST:event_btnSaveEmployeeActionPerformed

    private void rdoSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSalaryActionPerformed
        lblSalary.setVisible(true);
        txtEmployeeSalary.setVisible(true);
        lblPayRate.setVisible(false);
        txtEmployeePayRate.setVisible(false);
        
        txtEmployeeSalary.requestFocus();
    }//GEN-LAST:event_rdoSalaryActionPerformed

    private void rdoHourlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHourlyActionPerformed
        lblPayRate.setVisible(true);
        txtEmployeePayRate.setVisible(true);
        lblSalary.setVisible(false);
        txtEmployeeSalary.setVisible(false);
        
        txtEmployeePayRate.requestFocus();
    }//GEN-LAST:event_rdoHourlyActionPerformed

    
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgEmployeeType;
    private javax.swing.ButtonGroup btgPayType;
    private javax.swing.JButton btnAddEmployee;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnEmployeeUpdate;
    private javax.swing.JButton btnEmployees;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPreparePayroll;
    private javax.swing.JButton btnRemoveEmployee;
    private javax.swing.JButton btnRemoveProduct;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnSaveEmployee;
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JButton btnSaveProductUpdate;
    private javax.swing.JButton btnStubs;
    private javax.swing.JButton btnUpdateEmployee;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JCheckBox chkEmployeeAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAptSuite;
    private javax.swing.JLabel lblBadge;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblEmployeeFormHeader;
    private javax.swing.JLabel lblEmployeeHeader;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblHireDate;
    private javax.swing.JLabel lblHomeHeader;
    private javax.swing.JLabel lblInventoryFormHeader;
    private javax.swing.JLabel lblInventoryHeader;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPayRate;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblProductQuantity;
    private javax.swing.JLabel lblProductSalePrice;
    private javax.swing.JLabel lblProductSku;
    private javax.swing.JLabel lblProductSupplier;
    private javax.swing.JLabel lblProductTotalValue;
    private javax.swing.JLabel lblProductUnitCost;
    private javax.swing.JLabel lblSSN;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblZip;
    private javax.swing.JPanel pnlEmployeeForm;
    private javax.swing.JPanel pnlEmployees;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlInventory;
    private javax.swing.JPanel pnlInventoryForm;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPayroll;
    private javax.swing.JPasswordField pwfEmployeePassword;
    private javax.swing.JRadioButton rdoFullTime;
    private javax.swing.JRadioButton rdoHourly;
    private javax.swing.JRadioButton rdoPartTime;
    private javax.swing.JRadioButton rdoSalary;
    private javax.swing.JScrollPane scpHome;
    private javax.swing.JScrollPane scpInventory;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTable tblPayroll;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextArea txaHome;
    private javax.swing.JTextField txtEmployeeAddress;
    private javax.swing.JTextField txtEmployeeAptSuite;
    private javax.swing.JTextField txtEmployeeBadge;
    private javax.swing.JTextField txtEmployeeCity;
    private javax.swing.JTextField txtEmployeeFirstName;
    private javax.swing.JTextField txtEmployeeHireDate;
    private javax.swing.JTextField txtEmployeeLastName;
    private javax.swing.JTextField txtEmployeePayRate;
    private javax.swing.JTextField txtEmployeePhone;
    private javax.swing.JTextField txtEmployeePosition;
    private javax.swing.JTextField txtEmployeeSSN;
    private javax.swing.JTextField txtEmployeeSalary;
    private javax.swing.JTextField txtEmployeeState;
    private javax.swing.JTextField txtEmployeeUsername;
    private javax.swing.JTextField txtEmployeeZip;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductQuantity;
    private javax.swing.JTextField txtProductSalePrice;
    private javax.swing.JTextField txtProductSku;
    private javax.swing.JTextField txtProductSupplier;
    private javax.swing.JTextField txtProductTotalValue;
    private javax.swing.JTextField txtProductUnitCost;
    // End of variables declaration//GEN-END:variables

    //method that works with login variable to display username in menu
    public void username(String user) {
        lblUser.setText(user);
    }

    //clears product fields for next entry
    public void clearProductFields() {
        txtProductName.setText("");
        txtProductSku.setText("");
        txtProductDescription.setText("");
        txtProductSupplier.setText("");
        txtProductUnitCost.setText("");
        txtProductSalePrice.setText("");
        txtProductQuantity.setText("");
        txtProductTotalValue.setText("");
    }

    //clears employee fields
    public void clearEmployeeFields() {
        txtEmployeeFirstName.setText("");
        txtEmployeeLastName.setText("");
        txtEmployeeSSN.setText("");
        txtEmployeeAddress.setText("");
        txtEmployeeAptSuite.setText("");
        txtEmployeeCity.setText("");
        txtEmployeeState.setText("");
        txtEmployeeZip.setText("");
        txtEmployeePhone.setText("");
        txtEmployeePosition.setText("");
        txtEmployeeHireDate.setText("");
        txtEmployeeSalary.setText("");
        txtEmployeePayRate.setText("");
        txtEmployeeUsername.setText("");
        pwfEmployeePassword.setText("");
        chkEmployeeAdmin.setSelected(false);
        btgEmployeeType.clearSelection();
        btgPayType.clearSelection();
        txtEmployeeSSN.setText("");
    }

    //validates product input fields for correct data
    private boolean validateProductInputs() {
        // get textfield input
        String name = txtProductName.getText();
        String sku = txtProductSku.getText();
        String description = txtProductDescription.getText();
        String supplier = txtProductSupplier.getText();
        String unitCost = txtProductUnitCost.getText();
        String salePrice = txtProductSalePrice.getText();
        String quantity = txtProductQuantity.getText();
        String totalValue = txtProductTotalValue.getText();

        // account for name being empty
        if (name.isBlank()) {
            JOptionPane.showMessageDialog(this, "Name cannot be blank.",
                    "Name Error", JOptionPane.ERROR_MESSAGE);
            txtProductName.requestFocusInWindow();
            return false;
        }

        // account for sku being empty
        if (sku.isBlank()) {
            JOptionPane.showMessageDialog(this, "Sku cannot be blank.",
                    "Sku Error", JOptionPane.ERROR_MESSAGE);
            txtProductSku.requestFocusInWindow();
            return false;
        }
        //account for description being empty
        if (description.isBlank()) {
            JOptionPane.showMessageDialog(this, "Description cannot be blank.",
                    "Description Error", JOptionPane.ERROR_MESSAGE);
            txtProductDescription.requestFocusInWindow();
            return false;
        }
        //account for supplier being empty
        if (supplier.isBlank()) {
            JOptionPane.showMessageDialog(this, "Supplier cannot be blank.",
                    "Supplier Error", JOptionPane.ERROR_MESSAGE);
            txtProductSupplier.requestFocusInWindow();
            return false;
        }
        //account for unit cost being empty
        if (unitCost.isBlank()) {
            JOptionPane.showMessageDialog(this, "Unit cost cannot be blank.",
                    "Unit Cost Error", JOptionPane.ERROR_MESSAGE);
            txtProductUnitCost.requestFocusInWindow();
            return false;
        }

        // make sure unit cost is a valid number
        try {
            Double.parseDouble(unitCost);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Unit cost must be a number.",
                    "Unit Cost Error", JOptionPane.ERROR_MESSAGE);
            txtProductUnitCost.setText("");
            txtProductUnitCost.requestFocusInWindow();
            return false;
        }
        //make sure unit cost is greater than 0
        if (Double.parseDouble(unitCost) <= 0) {
            JOptionPane.showMessageDialog(this, "Unit cost must be a number greater than 0.",
                    "Unit Cost Error", JOptionPane.ERROR_MESSAGE);
            txtProductUnitCost.setText("");
            txtProductUnitCost.requestFocusInWindow();
            return false;
        }
        //account for sale price being empty
        if (salePrice.isBlank()) {
            JOptionPane.showMessageDialog(this, "Sale price cannot be blank.",
                    "Sale Price Error", JOptionPane.ERROR_MESSAGE);
            txtProductSalePrice.requestFocusInWindow();
            return false;
        }
        //make sure sale price is a number
        try {
            Double.parseDouble(salePrice);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sale price must be a number.",
                    "Sale Price Error", JOptionPane.ERROR_MESSAGE);
            txtProductSalePrice.setText("");
            txtProductSalePrice.requestFocusInWindow();
            return false;
        }
        //make sure sale price is greater than 0
        if (Double.parseDouble(salePrice) <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Sale price must be a number greater than 0.",
                    "Sale Price Error", JOptionPane.ERROR_MESSAGE);
            txtProductSalePrice.setText("");
            txtProductSalePrice.requestFocusInWindow();
            return false;
        }
        //account for quantity being empty
        if (quantity.isBlank()) {
            JOptionPane.showMessageDialog(this, "Quantity cannot be blank.", "Quantity Error", JOptionPane.ERROR_MESSAGE);
            txtProductQuantity.requestFocusInWindow();
            return false;
        }
        //make sure quantity is a number
        try {
            Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a number.",
                    "Quantity Error", JOptionPane.ERROR_MESSAGE);
            txtProductQuantity.setText("");
            txtProductQuantity.requestFocusInWindow();
            return false;
        }
        //make sure quantity is greater than 0
        if (Integer.parseInt(quantity) <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Quantity must be a number greater than 0.",
                    "Quantity Error", JOptionPane.ERROR_MESSAGE);
            txtProductQuantity.setText("");
            txtProductQuantity.requestFocusInWindow();
            return false;
        }
        //account for total value being empty
        if (totalValue.isBlank()) {
            JOptionPane.showMessageDialog(this, "Total value cannot be blank.",
                    "Total Value Error", JOptionPane.ERROR_MESSAGE);
            txtProductTotalValue.requestFocusInWindow();
            return false;
        }
        //make sure total value is a number
        try {
            Double.parseDouble(totalValue);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Total value must be a number.",
                    "Total Value Error", JOptionPane.ERROR_MESSAGE);
            txtProductTotalValue.setText("");
            txtProductTotalValue.requestFocusInWindow();
            return false;
        }
        //make sure total value is greater than 0
        if (Double.parseDouble(totalValue) <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Total value must be a number greater than 0.",
                    "Total Value Error", JOptionPane.ERROR_MESSAGE);
            txtProductTotalValue.setText("");
            txtProductTotalValue.requestFocusInWindow();
            return false;
        }

        // all is good so return true
        return true;
    }

    //validates employee fields for correct data
    private boolean validateEmployeeInputs() {
        String fname = txtEmployeeFirstName.getText();
        String lname = txtEmployeeLastName.getText();
        String address = txtEmployeeAddress.getText();
        String city = txtEmployeeCity.getText();
        String state = txtEmployeeState.getText();
        String zip = txtEmployeeZip.getText();
        String phone = txtEmployeePhone.getText();
        String position = txtEmployeePosition.getText();
        ButtonModel empType = btgEmployeeType.getSelection();
        ButtonModel payType = btgPayType.getSelection();
        String salary = txtEmployeeSalary.getText();
        String payRate = txtEmployeePayRate.getText();
        String username = txtEmployeeUsername.getText();
        String password = pwfEmployeePassword.getText();

        // account for first name being empty
        if (fname.isBlank()) {
            JOptionPane.showMessageDialog(this, "First name cannot be blank.",
                    "Name Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeeFirstName.requestFocusInWindow();
            return false;
        }

        // account for last name being empty
        if (lname.isBlank()) {
            JOptionPane.showMessageDialog(this, "Last name cannot be blank.",
                    "Name Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeeLastName.requestFocusInWindow();
            return false;
        }

        //account for address being empty
        if (address.isBlank()) {
            JOptionPane.showMessageDialog(this, "Address cannot be blank.",
                    "Address Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeeAddress.requestFocusInWindow();
            return false;
        }

        //account for city being empty
        if (city.isBlank()) {
            JOptionPane.showMessageDialog(this, "City cannot be blank.",
                    "Address Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeeCity.requestFocusInWindow();
            return false;
        }

        //account for state being empty
        if (state.isBlank()) {
            JOptionPane.showMessageDialog(this, "State cannot be blank.",
                    "Address Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeeState.requestFocusInWindow();
            return false;
        }

        //account for zip being empty
        if (zip.isBlank()) {
            JOptionPane.showMessageDialog(this, "Zip cannot be blank.",
                    "Address Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeeZip.requestFocusInWindow();
            return false;
        }

        //account for phone being empty
        if (phone.isBlank()) {
            JOptionPane.showMessageDialog(this, "Phone cannot be blank.",
                    "Phone Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeePhone.requestFocusInWindow();
            return false;
        }

        //account for position being empty
        if (position.isBlank()) {
            JOptionPane.showMessageDialog(this, "Position cannot be blank.",
                    "Position Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeePosition.requestFocusInWindow();
            return false;
        }

        if (empType == null) {
            JOptionPane.showMessageDialog(this, "Employee Type cannot be unselected.",
                    "Employee Type Error", JOptionPane.ERROR_MESSAGE);
            rdoFullTime.requestFocusInWindow();
            return false;
        }

        if (payType == null) {
            JOptionPane.showMessageDialog(this, "Pay Type cannot be unselected.",
                    "Pay Type Error", JOptionPane.ERROR_MESSAGE);
            rdoHourly.requestFocusInWindow();
            return false;
        }

        if (salary.isBlank() && payRate.isBlank()) {
            JOptionPane.showMessageDialog(this, "Salary and Pay rate cannot both be blank.",
                    "Salary/Pay Rate Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeePosition.requestFocusInWindow();
            return false;
        }

        if (salary.isBlank()) {
            try {
                Double.parseDouble(payRate);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Pay rate must be a number.",
                        "Pay rate Error", JOptionPane.ERROR_MESSAGE);
                txtEmployeePayRate.setText("");
                txtEmployeePayRate.requestFocusInWindow();
                return false;
            }
            //make sure total value is greater than 0
            if (Double.parseDouble(payRate) <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Pay rate must be a number greater than 0.",
                        "Pay Rate Error", JOptionPane.ERROR_MESSAGE);
                txtEmployeePayRate.setText("");
                txtEmployeePayRate.requestFocusInWindow();
                return false;
            }
        }

        if (payRate.isBlank()) {
            try {
                Double.parseDouble(salary);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Salary must be a number.",
                        "Salary Error", JOptionPane.ERROR_MESSAGE);
                txtEmployeeSalary.setText("");
                txtEmployeeSalary.requestFocusInWindow();
                return false;
            }
            //make sure total value is greater than 0
            if (Double.parseDouble(salary) <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Salary must be a number greater than 0.",
                        "Salary Error", JOptionPane.ERROR_MESSAGE);
                txtEmployeeSalary.setText("");
                txtEmployeeSalary.requestFocusInWindow();
                return false;
            }
        }

        //account for username being empty
        if (username.isBlank()) {
            JOptionPane.showMessageDialog(this, "Username cannot be blank.",
                    "Username Error", JOptionPane.ERROR_MESSAGE);
            txtEmployeeUsername.requestFocusInWindow();
            return false;
        }

        //account for password being empty
        if (password.isBlank()) {
            JOptionPane.showMessageDialog(this, "Password cannot be blank.",
                    "Password Error", JOptionPane.ERROR_MESSAGE);
            pwfEmployeePassword.requestFocusInWindow();
            return false;
        }

        return true;
    }

    //creates an instance of the Product object
    private Product createProduct() {
        String pName = txtProductName.getText();
        String pSku = txtProductSku.getText();
        String pDesc = txtProductDescription.getText();
        String pSupp = txtProductSupplier.getText();
        Double pUC = Double.parseDouble(txtProductUnitCost.getText());
        Double pSP = Double.parseDouble(txtProductSalePrice.getText());
        int pQ = Integer.parseInt(txtProductQuantity.getText());
        Double pTV = Double.parseDouble(txtProductTotalValue.getText());

        Product p = new Product(0, pName, pSku, pDesc, pSupp, pUC, pSP, pQ, pTV);

        return p;

    }

    //process to clear panel and display newest data for product table
    public void displayProductData(Product p, ProductIO pio) {
        productModel = (DefaultTableModel) tblProducts.getModel();
        clearProductFields();

        int rows = tblProducts.getRowCount();
        for (int j = rows - 1; j >= 0; j--) {
            productModel.removeRow(j);
        }
        pnlMain.removeAll();
        pnlMain.add(pnlInventory);
        pnlMain.revalidate();
        pnlMain.validate();

        //read data records
        try {
            ArrayList<Product> products = pio.getProductList();

            for (int i = 0; i < products.size(); i++) {
                p = products.get(i);

                Object[] row = {p.getProductID(), p.getProductName(), p.getProductSku(), p.getProductDescription(),
                    p.getProductSupplier(), p.getProductUnitCost(), p.getProductSalePrice(), p.getProductQuantity(),
                    p.getProductTotalValue()};

                productModel.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error. Database driver not found.", "Driver not found.", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error." + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String generateString() {
        String uuid = UUID.randomUUID().toString().substring(0, 6);
        return uuid;
    }

    //process to clear panel and display newest data for product table
    public void displayEmployeeData(Employee e, EmployeeIO eio) {
        employeeModel = (DefaultTableModel) tblEmployees.getModel();
        clearEmployeeFields();

        int rows = tblEmployees.getRowCount();
        for (int j = rows - 1; j >= 0; j--) {
            employeeModel.removeRow(j);
        }
        pnlMain.removeAll();
        pnlMain.add(pnlEmployees);
        pnlMain.revalidate();
        pnlMain.validate();

        //read data records
        try {
            ArrayList<Employee> employees = eio.getEmployeeList();

            for (int i = 0; i < employees.size(); i++) {
                e = employees.get(i);

                Object[] row = {e.getEmpId(), e.getEmpFName(), e.getEmpLName(), e.getEmpSsec(), e.getEmpAddress(), e.getEmpAddress2(),
                    e.getEmpCity(), e.getEmpState(), e.getEmpZip(), e.getEmpPhone(), e.getEmpPosition(), e.getEmpType(), e.getEmpHireDate(),
                    e.getEmpPayType(), e.getEmpSalary(), e.getEmpPayRate(), e.getEmpUsername(), e.getEmpPassword(), e.getEmpBadge(),
                    e.getEmpAdmin()};

                employeeModel.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error. Database driver not found.", "Driver not found.", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error." + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        }
    }

    //create instance of employee object
    private Employee createEmployee() throws NoSuchAlgorithmException, InvalidKeySpecException, ParseException {
//        Bcrypt b = new Bcrypt();
//        String phoneMask = "###-###-####";
        String eType = "";
        String pType = "";
//        MaskFormatter maskFormatter = new MaskFormatter(phoneMask);
//        maskFormatter.setValueContainsLiteralCharacters(false);

        String eFName = txtEmployeeFirstName.getText();
        String eLName = txtEmployeeLastName.getText();
        String eSsec = txtEmployeeSSN.getText();
        String eAdrss = txtEmployeeAddress.getText();
        String eAdrss2 = txtEmployeeAptSuite.getText();
        String eCity = txtEmployeeCity.getText();
        String eState = txtEmployeeState.getText();
        String eZip = txtEmployeeZip.getText();
        String ePhone = txtEmployeePhone.getText();
        String ePosition = txtEmployeePosition.getText();
        if (rdoFullTime.isSelected()) {
            eType = "Full-Time";
        } else if (rdoPartTime.isSelected()) {
            eType = "Part-Time";
        } else {
            return null;
        }
        String eHireDate = txtEmployeeHireDate.getText();

        if (rdoHourly.isSelected()) {
            pType = "Hourly";
        } else if (rdoSalary.isSelected()) {
            pType = "Salary";
        } else {
            return null;
        }
        Employee emp = new Employee();
        Double ePayRate = 0.0;
        Double eSalary = 0.0;

        try {
            if (txtEmployeePayRate.getText().equals("")) {
                ePayRate = emp.getEmpPayRate();
            } else {
                ePayRate = Double.parseDouble(txtEmployeePayRate.getText());
            }

            if (txtEmployeeSalary.getText().equals("")) {
                eSalary = emp.getEmpSalary();
            } else {
                eSalary = Double.parseDouble(txtEmployeeSalary.getText());
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Cannot format given object as a number.");
        }

        String eUName = txtEmployeeUsername.getText();
        String ePwd = pwfEmployeePassword.getText();
        String eBadge = txtEmployeeBadge.getText();
        Boolean eAdmin = chkEmployeeAdmin.isSelected();

        Employee e = new Employee(0, eFName, eLName, eSsec, eAdrss,
                eAdrss2, eCity, eState, eZip, ePhone,
                ePosition, eType, eHireDate, pType, eSalary, ePayRate, eUName,
                ePwd, eBadge, eAdmin);

        return e;
    }
    
    //process to clear panel and display newest data for product table
    public void displayPayrollData(Payroll p, PayrollIO pio) {
        DefaultTableModel payrollModel = (DefaultTableModel) tblPayroll.getModel();
        

        int rows = tblPayroll.getRowCount();
        for (int k = rows - 1; k >= 0; k--) {
            payrollModel.removeRow(k);
        }
        pnlMain.removeAll();
        pnlMain.add(pnlPayroll);
        pnlMain.revalidate();
        pnlMain.validate();

        //read data records
//        try {
//            ArrayList<Payroll> payrolls = pio.getPayrollList();
//
//            for (int i = 0; i < payrolls.size(); i++) {
//                p = payrolls.get(i);
//
//                Object[] row = {p.getPayrollId(), p.getPayrollFirstName(), p.getPayrollLastName(), p.getPayrollSsec(), p.getPayrollAddress(), p.getPayrollAddress2(), p.getPayrollCity(), p.getPayrollState(), p.getPayrollZip(), p.getPayrollBegin(), p.getPayrollEnd(), p.getPayrollType(), p.getSalary(), p.getHourlyRate(), p.getHoursWorked(), p.getGross(), p.getMed(), p.getSs(), p.getFedTax(), p.getStateTax(), p.getDeductions(), p.getNetPay()};
//
//                payrollModel.addRow(row);
//            }
//        } catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(this, "Error. Database driver not found.", "Driver not found.", JOptionPane.ERROR_MESSAGE);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Database Error." + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
//        }
    }
}

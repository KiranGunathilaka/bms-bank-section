/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banksection;

import java.awt.Image;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class MainMenu extends javax.swing.JFrame {

    int id, age;
    String username, password, name, address, NIC, teleNumber, date, gender, interestRateFD;
    Connection conn = null;
    ImageIcon img = new ImageIcon(getClass().getResource("/icons/C.jpg"));

    /**
     * Creates new form SignIn
     */
    public MainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        conn = dbConfig.getConn();

        userDetailsPanel.setVisible(true);
        transactionsPanel.setVisible(false);
        accountsPanel.setVisible(false);
        loanPanel.setVisible(false);
        FDPanel.setVisible(false);
        interestRatePanel.setVisible(false);
        inquiriesPanel.setVisible(false);
        statisticsPanel.setVisible(false);

        maleButton.setEnabled(false);
        femaleButton.setEnabled(false);
        nonBinaryButton.setEnabled(false);
        usernameLable2.setVisible(false);

        accountsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        accountsTable.getColumnModel().getColumn(3).setPreferredWidth(150);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        accountsTable.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

        String query1 = "SELECT * FROM `savingsaccounts`";
        PreparedStatement pst;
        ResultSet rs;
        double balance;
        String occupation;
        String email;
        int accountNumber;
        int index;
        try {
            pst = conn.prepareStatement(query1);
            rs = pst.executeQuery();

            while (rs.next()) {
                accountNumber = rs.getInt(1);
                index = rs.getInt(2);
                email = rs.getString(3);
                occupation = rs.getString(4);
                balance = rs.getDouble(5);

                String tableData1[] = {String.valueOf(accountNumber), String.valueOf(index), email, occupation, String.valueOf(balance)};
                DefaultTableModel tableModel1 = (DefaultTableModel) accountsTable.getModel();
                tableModel1.addRow(tableData1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        loanTableUpdater();

        String query2 = "SELECT * FROM `transactions`";
        double amount;
        int transactionID;
        String date, type, fundsFrom, fundsTo;

        try {
            pst = conn.prepareStatement(query2);
            rs = pst.executeQuery();

            while (rs.next()) {
                transactionID = rs.getInt(1);
                date = rs.getString(3);
                type = rs.getString(4);
                fundsFrom = rs.getString(5);
                fundsTo = rs.getString(6);
                amount = rs.getDouble(7);
                String tableData1[] = {String.valueOf(transactionID), date, type, fundsFrom, fundsTo, String.valueOf(amount)};
                DefaultTableModel tableModel1 = (DefaultTableModel) transactionsTable.getModel();
                tableModel1.addRow(tableData1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        String query3 = "SELECT * FROM `fixeddeposits`";
        int depositNum;
        String duration, occasion;

        try {
            pst = conn.prepareStatement(query3);
            rs = pst.executeQuery();

            while (rs.next()) {
                depositNum = rs.getInt(1);
                index = rs.getInt(2);
                amount = rs.getDouble(3);
                duration = rs.getString(5);
                occasion = rs.getString(6);
                date = rs.getString(7);
                String tableData1[] = {String.valueOf(depositNum), String.valueOf(index), String.valueOf(amount), duration, occasion, date};
                DefaultTableModel tableModel1 = (DefaultTableModel) FDTable.getModel();
                tableModel1.addRow(tableData1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        interestSavingsUpdater();

        inquiryLoader();

        interestFDUpdater();

        interestLoanUpdater();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        layeredPanel = new javax.swing.JLayeredPane();
        transactionsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionsTable = new javax.swing.JTable();
        accountsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountsTable = new javax.swing.JTable();
        loanPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        loanTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        remainingLoanLable = new javax.swing.JLabel();
        remainingLoanField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        loanUserIndexField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        loanIDField = new javax.swing.JTextField();
        statusField = new javax.swing.JTextField();
        approveLoanButton = new javax.swing.JButton();
        cancelLoanButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        loanAmountField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        durationField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        installmentField = new javax.swing.JTextField();
        loanDateLable = new javax.swing.JLabel();
        approvedDateField = new javax.swing.JTextField();
        FDPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        FDTable = new javax.swing.JTable();
        userDetailsPanel = new javax.swing.JPanel();
        imageLable = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nicField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        maleButton = new javax.swing.JRadioButton();
        femaleButton = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        usernameLable2 = new javax.swing.JLabel();
        usernameLable = new javax.swing.JLabel();
        indexField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        teleNumberField = new javax.swing.JTextField();
        nonBinaryButton = new javax.swing.JRadioButton();
        interestRatePanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        interestRateSavingsField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        interestRateFDField = new javax.swing.JTextField();
        durationFDCombo = new javax.swing.JComboBox<>();
        occasionFDCombo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        interestRateLoanField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        durationLoanSpinner = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        inquiriesPanel = new javax.swing.JPanel();
        messageLable = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        messageTable = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        userIndexField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        telephoneNumberField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        nameInquiryField = new javax.swing.JTextField();
        responseMarkerBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        messageTArea = new javax.swing.JTextArea();
        statisticsPanel = new javax.swing.JPanel();
        jTextField16 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        userDetailsButton = new javax.swing.JButton();
        accountsButton = new javax.swing.JButton();
        loansButton = new javax.swing.JButton();
        FDButton = new javax.swing.JButton();
        transactionsButton = new javax.swing.JButton();
        interestRateButton = new javax.swing.JButton();
        inquiriesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CBank");
        setIconImage(img.getImage());
        setName("JFrame1"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panel.setBackground(new java.awt.Color(51, 51, 51));

        transactionsPanel.setPreferredSize(new java.awt.Dimension(626, 498));

        transactionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ReferenceID", "Date & Time", "Type", "Funds From", "Funds To", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactionsTable.setEnabled(false);
        transactionsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(transactionsTable);
        if (transactionsTable.getColumnModel().getColumnCount() > 0) {
            transactionsTable.getColumnModel().getColumn(0).setResizable(false);
            transactionsTable.getColumnModel().getColumn(1).setResizable(false);
            transactionsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            transactionsTable.getColumnModel().getColumn(2).setResizable(false);
            transactionsTable.getColumnModel().getColumn(3).setResizable(false);
            transactionsTable.getColumnModel().getColumn(4).setResizable(false);
            transactionsTable.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout transactionsPanelLayout = new javax.swing.GroupLayout(transactionsPanel);
        transactionsPanel.setLayout(transactionsPanelLayout);
        transactionsPanelLayout.setHorizontalGroup(
            transactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        transactionsPanelLayout.setVerticalGroup(
            transactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        accountsPanel.setPreferredSize(new java.awt.Dimension(626, 498));

        accountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account No.", "User Index", "Email", "Occupation", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accountsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(accountsTable);
        if (accountsTable.getColumnModel().getColumnCount() > 0) {
            accountsTable.getColumnModel().getColumn(0).setResizable(false);
            accountsTable.getColumnModel().getColumn(1).setResizable(false);
            accountsTable.getColumnModel().getColumn(2).setResizable(false);
            accountsTable.getColumnModel().getColumn(3).setResizable(false);
            accountsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout accountsPanelLayout = new javax.swing.GroupLayout(accountsPanel);
        accountsPanel.setLayout(accountsPanelLayout);
        accountsPanelLayout.setHorizontalGroup(
            accountsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        accountsPanelLayout.setVerticalGroup(
            accountsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        loanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LoanID", "User Index", "Amount", "Duration", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loanTable.getTableHeader().setReorderingAllowed(false);
        loanTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loanTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(loanTable);
        if (loanTable.getColumnModel().getColumnCount() > 0) {
            loanTable.getColumnModel().getColumn(0).setResizable(false);
            loanTable.getColumnModel().getColumn(1).setResizable(false);
            loanTable.getColumnModel().getColumn(2).setResizable(false);
            loanTable.getColumnModel().getColumn(3).setResizable(false);
            loanTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel3.setText("Status");
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);

        remainingLoanLable.setText("Remaining Loan         ");

        remainingLoanField.setEditable(false);

        jLabel14.setText("User Index");

        loanUserIndexField.setEditable(false);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Loan ID                       ");

        loanIDField.setEditable(false);

        statusField.setEditable(false);

        approveLoanButton.setBackground(new java.awt.Color(102, 255, 0));
        approveLoanButton.setForeground(new java.awt.Color(0, 0, 0));
        approveLoanButton.setText("Approve Loan");
        approveLoanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveLoanButtonActionPerformed(evt);
            }
        });

        cancelLoanButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelLoanButton.setForeground(new java.awt.Color(0, 0, 0));
        cancelLoanButton.setText("Cancel Loan");
        cancelLoanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelLoanButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Amount");

        loanAmountField.setEditable(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Duration                  ");

        durationField.setEditable(false);

        jLabel12.setText("Monthly Installment");

        installmentField.setEditable(false);

        loanDateLable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loanDateLable.setText("Approved Date          ");

        approvedDateField.setEditable(false);

        javax.swing.GroupLayout loanPanelLayout = new javax.swing.GroupLayout(loanPanel);
        loanPanel.setLayout(loanPanelLayout);
        loanPanelLayout.setHorizontalGroup(
            loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
            .addGroup(loanPanelLayout.createSequentialGroup()
                .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loanPanelLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(approveLoanButton)
                        .addGap(100, 100, 100)
                        .addComponent(cancelLoanButton))
                    .addGroup(loanPanelLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loanPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loanAmountField)
                            .addComponent(loanUserIndexField, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(installmentField)
                            .addComponent(durationField))
                        .addGap(18, 18, 18)
                        .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loanDateLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(remainingLoanLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(approvedDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loanIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remainingLoanField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loanPanelLayout.setVerticalGroup(
            loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loanPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loanUserIndexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loanIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loanAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(approvedDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loanDateLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(installmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remainingLoanLable)
                    .addComponent(remainingLoanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(durationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelLoanButton)
                    .addComponent(approveLoanButton))
                .addContainerGap())
        );

        FDTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Deposit No.", "User Index", "Amount", "Duration", "Occasion", "Opened Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FDTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(FDTable);
        if (FDTable.getColumnModel().getColumnCount() > 0) {
            FDTable.getColumnModel().getColumn(0).setResizable(false);
            FDTable.getColumnModel().getColumn(1).setResizable(false);
            FDTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            FDTable.getColumnModel().getColumn(2).setResizable(false);
            FDTable.getColumnModel().getColumn(3).setResizable(false);
            FDTable.getColumnModel().getColumn(4).setResizable(false);
            FDTable.getColumnModel().getColumn(5).setResizable(false);
            FDTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        javax.swing.GroupLayout FDPanelLayout = new javax.swing.GroupLayout(FDPanel);
        FDPanel.setLayout(FDPanelLayout);
        FDPanelLayout.setHorizontalGroup(
            FDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        FDPanelLayout.setVerticalGroup(
            FDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        imageLable.setText("            No Image");
        imageLable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("User Index");

        jLabel6.setText("Name");

        jLabel7.setText("Address");

        nameField.setEditable(false);

        addressField.setEditable(false);

        jLabel8.setText("NIC");

        nicField.setEditable(false);

        jLabel9.setText("Age");

        ageField.setEditable(false);

        jLabel10.setText("Gender");

        maleButton.setText("Male");

        femaleButton.setText("Female");

        jLabel11.setText("Telephone Number");

        usernameLable2.setText("Username");

        usernameLable.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N

        indexField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                indexFieldKeyTyped(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        teleNumberField.setEditable(false);

        nonBinaryButton.setText("Non Binary");

        javax.swing.GroupLayout userDetailsPanelLayout = new javax.swing.GroupLayout(userDetailsPanel);
        userDetailsPanel.setLayout(userDetailsPanelLayout);
        userDetailsPanelLayout.setHorizontalGroup(
            userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userDetailsPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField)
                    .addComponent(addressField)
                    .addComponent(nicField)
                    .addComponent(ageField)
                    .addGroup(userDetailsPanelLayout.createSequentialGroup()
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(usernameLable2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(indexField)
                            .addGroup(userDetailsPanelLayout.createSequentialGroup()
                                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(userDetailsPanelLayout.createSequentialGroup()
                        .addComponent(maleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(femaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nonBinaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(teleNumberField))
                .addGap(27, 27, 27))
        );
        userDetailsPanelLayout.setVerticalGroup(
            userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userDetailsPanelLayout.createSequentialGroup()
                .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userDetailsPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(indexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchButton))
                    .addGroup(userDetailsPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imageLable, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(usernameLable2)
                                .addComponent(usernameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maleButton)
                            .addComponent(femaleButton)
                            .addComponent(nonBinaryButton))
                        .addGap(18, 18, 18)
                        .addGroup(userDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teleNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jLabel16.setText("Savings Account Interest");

        interestRateSavingsField.setEditable(false);
        interestRateSavingsField.setToolTipText("");

        jLabel17.setText("Fixed Deposit Interest");

        interestRateFDField.setEditable(false);
        interestRateFDField.setToolTipText("");

        durationFDCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6 Months", "1 Year", "2 Years", "3 Years", "5 Years", "10 Years" }));
        durationFDCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                durationFDComboItemStateChanged(evt);
            }
        });

        occasionFDCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "On Maturity", "Monthly", "Annually" }));
        occasionFDCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                occasionFDComboItemStateChanged(evt);
            }
        });

        jLabel18.setText("Duration");

        jLabel19.setText("Interest Receiving");

        jLabel20.setText("Loan Interest");

        jLabel21.setText("Duration");

        interestRateLoanField.setEditable(false);

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        applyButton.setText("Apply Changes");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        durationLoanSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));
        durationLoanSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                durationLoanSpinnerStateChanged(evt);
            }
        });
        durationLoanSpinner.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                durationLoanSpinnerPropertyChange(evt);
            }
        });

        jLabel13.setText("Years");

        javax.swing.GroupLayout interestRatePanelLayout = new javax.swing.GroupLayout(interestRatePanel);
        interestRatePanel.setLayout(interestRatePanelLayout);
        interestRatePanelLayout.setHorizontalGroup(
            interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, interestRatePanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(interestRatePanelLayout.createSequentialGroup()
                        .addComponent(durationLoanSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(occasionFDCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(interestRateLoanField)
                        .addComponent(interestRateFDField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addComponent(interestRateSavingsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addComponent(durationFDCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(57, 57, 57)
                .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(applyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        interestRatePanelLayout.setVerticalGroup(
            interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interestRatePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interestRateSavingsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationFDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(applyButton))
                .addGap(18, 18, 18)
                .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(occasionFDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interestRateFDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton))
                .addGap(91, 91, 91)
                .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(durationLoanSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(interestRatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interestRateLoanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        inquiriesPanel.setPreferredSize(new java.awt.Dimension(626, 498));

        messageLable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        messageLable.setForeground(new java.awt.Color(0, 0, 0));
        messageLable.setText("*  Unresponded Messages");

        messageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MessageID", "User Index", "Time", "Responded"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        messageTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                messageTableMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(messageTable);

        jLabel24.setText("User Index");

        userIndexField.setEditable(false);

        jLabel25.setText("Telephone Number");

        telephoneNumberField.setEditable(false);

        jLabel26.setText("Name");

        nameInquiryField.setEditable(false);

        responseMarkerBtn.setText("Mark as Responded");
        responseMarkerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responseMarkerBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Message");

        messageTArea.setEditable(false);
        messageTArea.setColumns(20);
        messageTArea.setRows(5);
        jScrollPane6.setViewportView(messageTArea);

        javax.swing.GroupLayout inquiriesPanelLayout = new javax.swing.GroupLayout(inquiriesPanel);
        inquiriesPanel.setLayout(inquiriesPanelLayout);
        inquiriesPanelLayout.setHorizontalGroup(
            inquiriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(inquiriesPanelLayout.createSequentialGroup()
                .addGroup(inquiriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inquiriesPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(inquiriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageLable, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(inquiriesPanelLayout.createSequentialGroup()
                                .addGroup(inquiriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                .addGap(24, 24, 24)
                                .addGroup(inquiriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(inquiriesPanelLayout.createSequentialGroup()
                                        .addComponent(userIndexField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(telephoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nameInquiryField)
                                    .addComponent(jScrollPane6)))))
                    .addGroup(inquiriesPanelLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(responseMarkerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        inquiriesPanelLayout.setVerticalGroup(
            inquiriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inquiriesPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(messageLable, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inquiriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(userIndexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(telephoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inquiriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(nameInquiryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inquiriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inquiriesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(responseMarkerBtn)
                .addGap(12, 12, 12))
        );

        jLabel23.setText("Credit");

        javax.swing.GroupLayout statisticsPanelLayout = new javax.swing.GroupLayout(statisticsPanel);
        statisticsPanel.setLayout(statisticsPanelLayout);
        statisticsPanelLayout.setHorizontalGroup(
            statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticsPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        statisticsPanelLayout.setVerticalGroup(
            statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticsPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(444, Short.MAX_VALUE))
        );

        layeredPanel.setLayer(transactionsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(accountsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(loanPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(FDPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(userDetailsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(interestRatePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(inquiriesPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(statisticsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredPanelLayout = new javax.swing.GroupLayout(layeredPanel);
        layeredPanel.setLayout(layeredPanelLayout);
        layeredPanelLayout.setHorizontalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(userDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(loanPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(transactionsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(accountsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(inquiriesPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(interestRatePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(statisticsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layeredPanelLayout.setVerticalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FDPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(userDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(loanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(transactionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(accountsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(inquiriesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(interestRatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(statisticsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userDetailsButton.setText("User Details");
        userDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDetailsButtonActionPerformed(evt);
            }
        });

        accountsButton.setText("Savings Accounts");
        accountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsButtonActionPerformed(evt);
            }
        });

        loansButton.setText("Loans");
        loansButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loansButtonActionPerformed(evt);
            }
        });

        FDButton.setText("Fixed Deposits");
        FDButton.setToolTipText("");
        FDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FDButtonActionPerformed(evt);
            }
        });

        transactionsButton.setText("Transactions");
        transactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsButtonActionPerformed(evt);
            }
        });

        interestRateButton.setText("Interest Rates");
        interestRateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interestRateButtonActionPerformed(evt);
            }
        });

        inquiriesButton.setText("Inquiries");
        inquiriesButton.setToolTipText("");
        inquiriesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inquiriesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userDetailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(loansButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FDButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(interestRateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inquiriesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(layeredPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPanel)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(userDetailsButton)
                .addGap(18, 18, 18)
                .addComponent(accountsButton)
                .addGap(18, 18, 18)
                .addComponent(loansButton)
                .addGap(18, 18, 18)
                .addComponent(FDButton)
                .addGap(18, 18, 18)
                .addComponent(transactionsButton)
                .addGap(18, 18, 18)
                .addComponent(interestRateButton)
                .addGap(18, 18, 18)
                .addComponent(inquiriesButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDetailsButtonActionPerformed
        // TODO add your handling code here:

        userDetailsPanel.setVisible(true);
        transactionsPanel.setVisible(false);
        accountsPanel.setVisible(false);
        loanPanel.setVisible(false);
        FDPanel.setVisible(false);
        interestRatePanel.setVisible(false);
        inquiriesPanel.setVisible(false);
        statisticsPanel.setVisible(false);

        maleButton.setEnabled(false);
        femaleButton.setEnabled(false);
        nonBinaryButton.setEnabled(false);
        usernameLable2.setVisible(false);

    }//GEN-LAST:event_userDetailsButtonActionPerformed

    private void accountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsButtonActionPerformed
        // TODO add your handling code here:     

        userDetailsPanel.setVisible(false);
        transactionsPanel.setVisible(false);
        accountsPanel.setVisible(true);
        loanPanel.setVisible(false);
        FDPanel.setVisible(false);
        interestRatePanel.setVisible(false);
        inquiriesPanel.setVisible(false);
        statisticsPanel.setVisible(false);

    }//GEN-LAST:event_accountsButtonActionPerformed

    private void loansButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loansButtonActionPerformed
        // TODO add your handling code here:

        userDetailsPanel.setVisible(false);
        transactionsPanel.setVisible(false);
        accountsPanel.setVisible(false);
        loanPanel.setVisible(true);
        FDPanel.setVisible(false);
        interestRatePanel.setVisible(false);
        inquiriesPanel.setVisible(false);

    }//GEN-LAST:event_loansButtonActionPerformed

    private void FDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FDButtonActionPerformed
        // TODO add your handling code here:

        userDetailsPanel.setVisible(false);
        transactionsPanel.setVisible(false);
        accountsPanel.setVisible(false);
        loanPanel.setVisible(false);
        FDPanel.setVisible(true);
        interestRatePanel.setVisible(false);
        inquiriesPanel.setVisible(false);
        statisticsPanel.setVisible(false);

    }//GEN-LAST:event_FDButtonActionPerformed

    private void transactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsButtonActionPerformed
        // TODO add your handling code here:
//        transactionsTable.getColumnModel().getColumn(3).setPreferredWidth(20);

        userDetailsPanel.setVisible(false);
        transactionsPanel.setVisible(true);
        accountsPanel.setVisible(false);
        loanPanel.setVisible(false);
        FDPanel.setVisible(false);
        interestRatePanel.setVisible(false);
        inquiriesPanel.setVisible(false);
        statisticsPanel.setVisible(false);

    }//GEN-LAST:event_transactionsButtonActionPerformed

    private void interestRateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interestRateButtonActionPerformed
        // TODO add your handling code here:

        userDetailsPanel.setVisible(false);
        transactionsPanel.setVisible(false);
        accountsPanel.setVisible(false);
        loanPanel.setVisible(false);
        FDPanel.setVisible(false);
        interestRatePanel.setVisible(true);
        inquiriesPanel.setVisible(false);
        statisticsPanel.setVisible(false);

    }//GEN-LAST:event_interestRateButtonActionPerformed

    private void inquiriesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inquiriesButtonActionPerformed
        // TODO add your handling code here:

        userDetailsPanel.setVisible(false);
        transactionsPanel.setVisible(false);
        accountsPanel.setVisible(false);
        loanPanel.setVisible(false);
        FDPanel.setVisible(false);
        interestRatePanel.setVisible(false);
        inquiriesPanel.setVisible(true);
        statisticsPanel.setVisible(false);

    }//GEN-LAST:event_inquiriesButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
        try {
            id = Integer.valueOf(indexField.getText());
            String query1 = "SELECT * FROM `users` WHERE `IndexNo` = ?";
            PreparedStatement pst;
            ResultSet rs;
            try {
                pst = conn.prepareStatement(query1);
                pst.setInt(1, id);
                rs = pst.executeQuery();
                if (rs.next()) {
                    usernameLable2.setVisible(true);
                    imageLable.setText("");
                    name = rs.getString(2);
                    nameField.setText(name);
                    username = rs.getString(8);
                    usernameLable.setText(username);
                    address = rs.getString(3);
                    addressField.setText(address);
                    NIC = rs.getString(4);
                    nicField.setText(NIC);
                    age = rs.getInt(5);
                    ageField.setText(String.valueOf(age));
                    gender = rs.getString(6);
                    if (gender.equals("Male")) {
                        maleButton.setSelected(true);
                        femaleButton.setSelected(false);
                        nonBinaryButton.setSelected(false);
                        maleButton.setEnabled(true);
                        femaleButton.setEnabled(false);
                        nonBinaryButton.setEnabled(false);
                    }
                    if (gender.equals("Female")) {
                        maleButton.setSelected(false);
                        femaleButton.setSelected(true);
                        nonBinaryButton.setSelected(false);
                        maleButton.setEnabled(false);
                        femaleButton.setEnabled(true);
                        nonBinaryButton.setEnabled(false);
                    }
                    if (gender.equals("Non Binary")) {
                        maleButton.setSelected(false);
                        femaleButton.setSelected(false);
                        nonBinaryButton.setSelected(true);
                        maleButton.setEnabled(false);
                        femaleButton.setEnabled(false);
                        nonBinaryButton.setEnabled(true);
                    }
                    teleNumber = rs.getString(7);
                    teleNumberField.setText(teleNumber);
                    Blob blob = rs.getBlob(10);
                    byte[] byteImage = blob.getBytes(1, (int) blob.length());
                    ImageIcon image = new ImageIcon(byteImage);
                    ImageIcon finalImage = new ImageIcon((Image) image.getImage().getScaledInstance(132, 144, Image.SCALE_DEFAULT));
                    imageLable.setIcon(finalImage);
                } else {
                    JOptionPane.showMessageDialog(null, "There is no record associated with the User Index " + id, "Error", 2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Index can not be Empty", "Error", 2);
            Logger.getLogger(MainMenu.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void indexFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_indexFieldKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_indexFieldKeyTyped

    private void loanTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loanTableMouseClicked
        // TODO add your handling code here:
        loanFieldsLoad();
    }//GEN-LAST:event_loanTableMouseClicked

    private void approveLoanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveLoanButtonActionPerformed
        // TODO add your handling code here:
        if (loanTable.isRowSelected(loanTable.getSelectedRow())) {
            int row = loanTable.getSelectedRow();
            int loanID = Integer.parseInt(String.valueOf(loanTable.getValueAt(row, 0)));

            String query3 = "UPDATE `loans` SET `Approved/CancelledDate` = ?, `Status` = 'Approved' WHERE `loans`.`LoanID` = ?";
            PreparedStatement pst;

            try {
                pst = conn.prepareStatement(query3);
                pst.setString(1, CurrentDateTime.time());
                pst.setInt(2, loanID);
                if (pst.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Loan Approved", "Message", 1);
                    loanFieldsLoad();
                    loanTableUpdater();
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong", "Error", 2);
                }

            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row has seleceted", "Error", 2);
        }
    }//GEN-LAST:event_approveLoanButtonActionPerformed

    private void cancelLoanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelLoanButtonActionPerformed
        // TODO add your handling code here:
        if (loanTable.isRowSelected(loanTable.getSelectedRow())) {
            int row = loanTable.getSelectedRow();
            int loanID = Integer.parseInt(String.valueOf(loanTable.getValueAt(row, 0)));

            String query3 = "UPDATE `loans` SET `Approved/CancelledDate` = ?, `Status` = 'Cancelled' WHERE `loans`.`LoanID` = ?";
            PreparedStatement pst;

            try {
                pst = conn.prepareStatement(query3);
                pst.setString(1, CurrentDateTime.time());
                pst.setInt(2, loanID);
                if (pst.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Loan Cancelled", "Message", 1);
                    loanFieldsLoad();
                    loanTableUpdater();
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong", "Error", 2);
                }

            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row has seleceted", "Error", 2);
        }
    }//GEN-LAST:event_cancelLoanButtonActionPerformed

    private void durationFDComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_durationFDComboItemStateChanged
        // TODO add your handling code here:
        interestFDUpdater();
    }//GEN-LAST:event_durationFDComboItemStateChanged

    private void occasionFDComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_occasionFDComboItemStateChanged
        // TODO add your handling code here:
        interestFDUpdater();
    }//GEN-LAST:event_occasionFDComboItemStateChanged

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        interestRateSavingsField.setEditable(true);
        interestRateFDField.setEditable(true);
        interestRateLoanField.setEditable(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        // TODO add your handling code here:

        interestRateSavingsField.setEditable(false);
        interestRateFDField.setEditable(false);
        interestRateLoanField.setEditable(false);

        String savingsRate = interestRateSavingsField.getText();
        StringBuffer tmp = new StringBuffer(savingsRate);
        String savingsFinal = tmp.deleteCharAt(tmp.length() - 1).toString();

        String fdRate = interestRateFDField.getText();
        tmp = new StringBuffer(fdRate);
        String fdFinal = tmp.deleteCharAt(tmp.length() - 1).toString();

        String loanRate = interestRateLoanField.getText();
        tmp = new StringBuffer(loanRate);
        String loanFinal = tmp.deleteCharAt(tmp.length() - 1).toString();

        try {
            double loanTmp = Double.valueOf(loanFinal);
            if (!String.valueOf(durationFDCombo.getSelectedItem()).equals("6 Months") || !String.valueOf(occasionFDCombo.getSelectedItem()).equals("Annually")) {
                double fdTmp = Double.valueOf(fdFinal);
            }
            double savingsTmp = Double.valueOf(savingsFinal);

            try {
                String query1 = "UPDATE `interest_rates` SET `Interest` = ? WHERE `interest_rates`.`ID` = 1";
                PreparedStatement pst;

                pst = conn.prepareStatement(query1);
                pst.setString(1, savingsRate);
                pst.executeUpdate();

                if (!String.valueOf(durationFDCombo.getSelectedItem()).equals("6 Months") || !String.valueOf(occasionFDCombo.getSelectedItem()).equals("Annually")) {
                    String query2 = "UPDATE `interest_rates` SET `Interest` = ? WHERE `interest_rates`.`Duration` = ? AND `interest_rates`.`Occasion`= ?";

                    pst = conn.prepareStatement(query2);
                    pst.setString(1, fdRate);
                    pst.setString(2, String.valueOf(durationFDCombo.getSelectedItem()));
                    pst.setString(3, String.valueOf(occasionFDCombo.getSelectedItem()));
                    pst.executeUpdate();

                }

                String query3 = "UPDATE `interest_rates` SET `Interest` = ? WHERE `interest_rates`.`Duration` = ?";

                pst = conn.prepareStatement(query3);
                pst.setString(1, loanRate);
                pst.setString(2, String.valueOf(durationLoanSpinner.getValue()));
                pst.executeUpdate();

                if (!String.valueOf(durationFDCombo.getSelectedItem()).equals("6 Months") || !String.valueOf(occasionFDCombo.getSelectedItem()).equals("Annually")) {
                    JOptionPane.showMessageDialog(null, "Interest rates are Updated", "Message", 1);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", 2);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "One or multiple interest rates you have updated are Unacceptable", "Warning", 2);
        }

        interestSavingsUpdater();
        interestFDUpdater();
        interestLoanUpdater();
    }//GEN-LAST:event_applyButtonActionPerformed

    private void messageTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_messageTableMouseEntered

    private void messageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageTableMouseClicked
        // TODO add your handling code here:
        int index, row = messageTable.getSelectedRow();
        int messageID = Integer.parseInt(String.valueOf(messageTable.getValueAt(row, 0)));

        String query1 = "SELECT * FROM `user_messages` WHERE `MessageID` = ?";
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(query1);
            pst.setInt(1, messageID);
            rs = pst.executeQuery();

            if (rs.next()) {
                index = rs.getInt(2);
                userIndexField.setText(String.valueOf(index));
                messageTArea.setLineWrap(true);
                messageTArea.setWrapStyleWord(true);
                messageTArea.setText(rs.getString(4));

                String query2 = "SELECT * FROM `users` WHERE `IndexNo` = ?";
                try {
                    pst = conn.prepareStatement(query2);
                    pst.setInt(1, index);
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        nameInquiryField.setText(rs.getString(2));
                        telephoneNumberField.setText(rs.getString(7));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_messageTableMouseClicked

    private void durationLoanSpinnerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_durationLoanSpinnerPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_durationLoanSpinnerPropertyChange

    private void durationLoanSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_durationLoanSpinnerStateChanged
        // TODO add your handling code here:
        interestLoanUpdater();
    }//GEN-LAST:event_durationLoanSpinnerStateChanged

    private void responseMarkerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responseMarkerBtnActionPerformed
        // TODO add your handling code here:   
        if (messageTable.isRowSelected(messageTable.getSelectedRow())) {
            int row = messageTable.getSelectedRow();
            int messageID = Integer.parseInt(String.valueOf(messageTable.getValueAt(row, 0)));
            String actionTaken;

            String query1 = "SELECT * FROM `user_messages` WHERE `MessageID` = ?";
            PreparedStatement pst;
            ResultSet rs;
            try {
                pst = conn.prepareStatement(query1);
                pst.setInt(1, messageID);
                rs = pst.executeQuery();

                if (rs.next()) {
                    actionTaken = rs.getString(5);

                    if (actionTaken.equals("No")) {
                        String query2 = "UPDATE `user_messages` SET `ActionTaken` = 'Yes' WHERE `user_messages`.`MessageID` = ?";
                        try {
                            pst = conn.prepareStatement(query2);
                            pst.setInt(1, messageID);

                            if (pst.executeUpdate() == 1) {
                                JOptionPane.showMessageDialog(null, "The message is now marked as responded", "Message", 1);
                                DefaultTableModel dtm = (DefaultTableModel) messageTable.getModel();
                                dtm.setRowCount(0);
                                inquiryLoader();
                            } else {
                                JOptionPane.showMessageDialog(null, "Unable to mark this message as responded", "Error", 2);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "This message have already marked as responded", "Error", 2);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row has selected", "Error", 2);
        }
    }//GEN-LAST:event_responseMarkerBtnActionPerformed

    public void loanFieldsLoad() {
        int row = loanTable.getSelectedRow();
        int loanID = Integer.parseInt(String.valueOf(loanTable.getValueAt(row, 0)));
        loanIDField.setText(String.valueOf(loanID));
        loanUserIndexField.setText(String.valueOf(loanTable.getValueAt(row, 1)));
        loanAmountField.setText(String.valueOf(loanTable.getValueAt(row, 2)));
        durationField.setText(String.valueOf(loanTable.getValueAt(row, 3)));

        String query2 = "SELECT * FROM `loans` WHERE `LoanID` = ?";
        ResultSet rs;
        PreparedStatement pst;

        try {
            pst = conn.prepareStatement(query2);
            pst.setInt(1, loanID);
            rs = pst.executeQuery();
            if (rs.next()) {
                installmentField.setText(String.valueOf(rs.getDouble(6)));
                statusField.setText(rs.getString(9));
                if (rs.getString(9).equals("Approved")) {
                    approveLoanButton.setVisible(false);
                    cancelLoanButton.setVisible(false);

                    loanDateLable.setVisible(true);
                    loanDateLable.setText("Approved Date");
                    approvedDateField.setVisible(true);
                    remainingLoanField.setVisible(true);
                    remainingLoanLable.setVisible(true);

                    approvedDateField.setText(String.valueOf(rs.getString(1)));
                    remainingLoanField.setText(String.valueOf(rs.getDouble(8)));
                } else if (rs.getString(9).equals("Pending")) {
                    approveLoanButton.setVisible(true);
                    cancelLoanButton.setVisible(true);

                    loanDateLable.setVisible(false);
                    approvedDateField.setVisible(false);
                    remainingLoanField.setVisible(false);
                    remainingLoanLable.setVisible(false);

                } else if (rs.getString(9).equals("Cancelled")) {
                    approveLoanButton.setVisible(false);
                    cancelLoanButton.setVisible(false);

                    loanDateLable.setVisible(true);
                    loanDateLable.setText("Cancelled Date");
                    approvedDateField.setVisible(true);
                    remainingLoanLable.setVisible(false);
                    remainingLoanField.setVisible(false);

                    approvedDateField.setText(String.valueOf(rs.getString(1)));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loanTableUpdater() {
        DefaultTableModel dtm = (DefaultTableModel) loanTable.getModel();
        dtm.setRowCount(0);
        String query2 = "SELECT * FROM `loans`";
        ResultSet rs;
        PreparedStatement pst;
        double amount;
        String duration, status;
        int loanID, index;
        try {
            pst = conn.prepareStatement(query2);
            rs = pst.executeQuery();

            while (rs.next()) {
                loanID = rs.getInt(2);
                index = rs.getInt(3);
                amount = rs.getInt(4);
                duration = rs.getString(5);
                status = rs.getString(9);

                String tableData1[] = {String.valueOf(loanID), String.valueOf(index), String.valueOf(amount), duration, status};
                DefaultTableModel tableModel1 = (DefaultTableModel) loanTable.getModel();
                if (status.equals("Pending")) {
                    tableModel1.insertRow(0, tableData1);
                } else {
                    tableModel1.addRow(tableData1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void interestSavingsUpdater() {
        String query4 = "SELECT * FROM `interest_rates` WHERE `ID` = 1";
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(query4);
            rs = pst.executeQuery();
            if (rs.next()) {
                interestRateSavingsField.setText(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inquiryLoader() {
        String query5 = "SELECT * FROM `user_messages`";
        String actionTaken;
        int messageID, index, count = 0;
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(query5);
            rs = pst.executeQuery();

            while (rs.next()) {
                messageID = rs.getInt(1);
                index = rs.getInt(2);
                date = rs.getString(3);
                actionTaken = rs.getString(5);
                String tableData1[] = {String.valueOf(messageID), String.valueOf(index), date, actionTaken};
                DefaultTableModel tableModel1 = (DefaultTableModel) messageTable.getModel();
                if (actionTaken.equals("No")) {
                    tableModel1.insertRow(0, tableData1);
                    count++;
                } else {
                    tableModel1.addRow(tableData1);
                }
            }

            messageLable.setText(count + " Unresponded Messages");
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void interestFDUpdater() {
        String query2 = "SELECT * FROM `interest_rates` WHERE `Duration` = ? AND `Occasion` = ?";
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(query2);
            pst.setString(1, (String) durationFDCombo.getSelectedItem());
            pst.setString(2, (String) occasionFDCombo.getSelectedItem());
            rs = pst.executeQuery();
            if (rs.next()) {
                interestRateFDField.setText(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void interestLoanUpdater() {
        String query2 = "SELECT * FROM `interest_rates` WHERE `Duration` = ?";
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(query2);
            pst.setString(1, String.valueOf(durationLoanSpinner.getValue()));
            rs = pst.executeQuery();
            if (rs.next()) {
                interestRateLoanField.setText(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FDButton;
    private javax.swing.JPanel FDPanel;
    private javax.swing.JTable FDTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JButton accountsButton;
    private javax.swing.JPanel accountsPanel;
    private javax.swing.JTable accountsTable;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField ageField;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton approveLoanButton;
    private javax.swing.JTextField approvedDateField;
    private javax.swing.JButton cancelLoanButton;
    private javax.swing.JComboBox<String> durationFDCombo;
    private javax.swing.JTextField durationField;
    private javax.swing.JSpinner durationLoanSpinner;
    private javax.swing.JButton editButton;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.JLabel imageLable;
    private javax.swing.JTextField indexField;
    private javax.swing.JButton inquiriesButton;
    private javax.swing.JPanel inquiriesPanel;
    private javax.swing.JTextField installmentField;
    private javax.swing.JButton interestRateButton;
    private javax.swing.JTextField interestRateFDField;
    private javax.swing.JTextField interestRateLoanField;
    private javax.swing.JPanel interestRatePanel;
    private javax.swing.JTextField interestRateSavingsField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JLayeredPane layeredPanel;
    private javax.swing.JTextField loanAmountField;
    private javax.swing.JLabel loanDateLable;
    private javax.swing.JTextField loanIDField;
    private javax.swing.JPanel loanPanel;
    private javax.swing.JTable loanTable;
    private javax.swing.JTextField loanUserIndexField;
    private javax.swing.JButton loansButton;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JLabel messageLable;
    private javax.swing.JTextArea messageTArea;
    private javax.swing.JTable messageTable;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nameInquiryField;
    private javax.swing.JTextField nicField;
    private javax.swing.JRadioButton nonBinaryButton;
    private javax.swing.JComboBox<String> occasionFDCombo;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField remainingLoanField;
    private javax.swing.JLabel remainingLoanLable;
    private javax.swing.JButton responseMarkerBtn;
    private javax.swing.JPanel statisticsPanel;
    private javax.swing.JTextField statusField;
    private javax.swing.JTextField teleNumberField;
    private javax.swing.JTextField telephoneNumberField;
    private javax.swing.JButton transactionsButton;
    private javax.swing.JPanel transactionsPanel;
    private javax.swing.JTable transactionsTable;
    private javax.swing.JButton userDetailsButton;
    private javax.swing.JPanel userDetailsPanel;
    private javax.swing.JTextField userIndexField;
    private javax.swing.JLabel usernameLable;
    private javax.swing.JLabel usernameLable2;
    // End of variables declaration//GEN-END:variables
}

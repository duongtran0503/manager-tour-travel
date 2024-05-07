/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class FormOrderTour extends javax.swing.JFrame {

    /**
     * Creates new form FormOrderTour
     */
    public FormOrderTour() {
        initComponents();
        addEventButtonCancel();
    }
  public ButtonRadius getButtonCancel() {
   return  this.buttonCancel;
  }
  public ButtonRadius getButtonPayment(){
   return this.buttonPayment;
  }
  public JPanel getInFoContainer() {
   return this.infoTour;
  }
  
  private void addEventButtonCancel(){
    buttonCancel.addActionListener(new ActionListener(){
     

        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(null, "hủy hóa đơn", "thông báo", JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION) {
              dispose();
            }
        }
     
    });
    
  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @return 
     */
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoTour = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField3 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        errorQuantity = new javax.swing.JLabel();
        errorAddress = new javax.swing.JLabel();
        errorName = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalPerson = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        totalPerson2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totalPerson3 = new javax.swing.JLabel();
        buttonCancel = new GUI.components.ButtonRadius();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        errorPhone = new javax.swing.JLabel();
        buttonPayment = new GUI.components.ButtonRadius();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        totalPrice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalPerson1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoTour.setBackground(new java.awt.Color(255, 255, 255));
        infoTour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        infoTour.setLayout(new java.awt.CardLayout());
        getContentPane().add(infoTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 320));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thông tin đăng ký tour");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 30));

        jTextField1.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("1");
        jTextField1.setBorder(null);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 190, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 200, 10));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel6.setText("số người đăng ký:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        jTextField2.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setText("tp.hcm");
        jTextField2.setBorder(null);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 590, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 590, 20));

        jTextField3.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(153, 153, 153));
        jTextField3.setText("nguyen van a");
        jTextField3.setBorder(null);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 280, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 280, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel7.setText("Người tạo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, 30));
        jPanel1.add(errorQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 230, 30));
        jPanel1.add(errorAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 560, 30));
        jPanel1.add(errorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel11.setText("Họ&Tên");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        totalPerson.setText("nhan vien a");
        jPanel1.add(totalPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 300, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel12.setText("Hóa đơn số:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 30));

        totalPerson2.setText("sdfjlsdjflsd");
        jPanel1.add(totalPerson2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 300, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel13.setText("Ngày tạo:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 30));

        totalPerson3.setText("06/21/2344");
        jPanel1.add(totalPerson3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 310, 30));

        buttonCancel.setBackground(new java.awt.Color(255, 128, 146));
        buttonCancel.setText("  Thoát");
        buttonCancel.setBorderColor(new java.awt.Color(255, 255, 255));
        buttonCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonCancel.setRadius(20);
        jPanel1.add(buttonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 170, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 280, 20));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 280, 20));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 280, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel14.setText("Địa chỉ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        jTextField4.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(153, 153, 153));
        jTextField4.setText("0123456778");
        jTextField4.setBorder(null);
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 280, 30));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 280, 10));

        errorPhone.setText(" ");
        jPanel1.add(errorPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 280, 30));

        buttonPayment.setBackground(new java.awt.Color(125, 45, 255));
        buttonPayment.setForeground(new java.awt.Color(255, 255, 255));
        buttonPayment.setText("Thanh Toán");
        buttonPayment.setBorderColor(new java.awt.Color(255, 255, 255));
        buttonPayment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonPayment.setRadius(20);
        jPanel1.add(buttonPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 630, 520));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thông  tin Tour");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 300, 30));

        jLabel3.setText("Tổng số tiên :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, 30));

        jLabel4.setText("Số người đăng kí:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));
        jPanel2.add(totalPerson1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 300, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 440, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.ButtonRadius buttonCancel;
    private GUI.components.ButtonRadius buttonPayment;
    private javax.swing.JLabel errorAddress;
    private javax.swing.JLabel errorName;
    private javax.swing.JLabel errorPhone;
    private javax.swing.JLabel errorQuantity;
    private javax.swing.JPanel infoTour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel totalPerson;
    private javax.swing.JLabel totalPerson1;
    private javax.swing.JLabel totalPerson2;
    private javax.swing.JLabel totalPerson3;
    private javax.swing.JLabel totalPrice;
    // End of variables declaration//GEN-END:variables
}
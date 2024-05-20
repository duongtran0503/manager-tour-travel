/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.components;
import BUS.UserBUS;
import BUS.RandomIdGenerator;
import DTO.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import BUS.CheckError;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Acer
 */
public class Formadd extends javax.swing.JFrame {
RandomIdGenerator random = new RandomIdGenerator();
List<User> datalist;
UserBUS bus = new UserBUS();
CheckError check = new CheckError();
    public Formadd() {
        initComponents();
        addEventsave();
        addEventButtonCancel();
    }
      private void addEventsave() {
       save.addActionListener(new  ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               if(!check.CheckEmail(mail.getText())){
                   JOptionPane.showMessageDialog(null, "Email khong hop le");
               }
               else if(check.isNumber(ten.getText())){
                   JOptionPane.showMessageDialog(null, "ten khong hop le");
               }
               else if(!check.checkphonenumber(sdt.getText()) || !check.isNumber(sdt.getText())){
                   JOptionPane.showMessageDialog(null, "so dien thoai khong hop le");
               }
               else{
           User user = new User();
           user.setUser_id(random.generateRandomId());
           user.setName(ten.getText());
           user.setEmail(mail.getText());
           user.setPhone_number(sdt.getText());
           user.setAddress(address.getText());
           bus.addcustomer(user);
           JOptionPane.showMessageDialog(null, "Da them khach hang khach hang");
           dispose();          
           }
    }
          
       });
    }
 private void addEventButtonCancel(){
       cancel.addActionListener(new ActionListener(){
   
       @Override
       public void actionPerformed(ActionEvent e) {
             int result = JOptionPane.showConfirmDialog(null, "bạn muốn hủy thao tác", "thông báo", JOptionPane.YES_NO_OPTION);
            if(result ==JOptionPane.OK_OPTION) {
                SwingUtilities.getWindowAncestor(jPanel1).dispose();
            }
            
       }
   });
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        sdt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        errorQuantity = new javax.swing.JLabel();
        errorAddress = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cancel = new GUI.components.ButtonRadius();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        errorPhone = new javax.swing.JLabel();
        save = new GUI.components.ButtonRadius();
        ten = new javax.swing.JTextField();
        address = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thông tin khach hang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 620, 30));

        mail.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        mail.setForeground(new java.awt.Color(153, 153, 153));
        mail.setBorder(null);
        jPanel1.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 590, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 590, 10));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel6.setText("Địa chỉ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 20));

        sdt.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        sdt.setForeground(new java.awt.Color(153, 153, 153));
        sdt.setBorder(null);
        sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtActionPerformed(evt);
            }
        });
        jPanel1.add(sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 590, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 590, 20));
        jPanel1.add(errorQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 230, 30));
        jPanel1.add(errorAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 560, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel11.setText("Họ&Tên");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 128, 146));
        cancel.setText("  Thoát");
        cancel.setBorderColor(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancel.setRadius(20);
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 170, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 600, 20));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 590, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel14.setText("Email");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        errorPhone.setText(" ");
        jPanel1.add(errorPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 280, 30));

        save.setBackground(new java.awt.Color(125, 45, 255));
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Thêm ");
        save.setBorderColor(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        save.setRadius(20);
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 170, 30));

        ten.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        ten.setForeground(new java.awt.Color(153, 153, 153));
        ten.setBorder(null);
        jPanel1.add(ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 600, 30));

        address.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        address.setForeground(new java.awt.Color(153, 153, 153));
        address.setBorder(null);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 590, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private GUI.components.ButtonRadius cancel;
    private javax.swing.JLabel errorAddress;
    private javax.swing.JLabel errorPhone;
    private javax.swing.JLabel errorQuantity;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField mail;
    private GUI.components.ButtonRadius save;
    private javax.swing.JTextField sdt;
    private javax.swing.JTextField ten;
    // End of variables declaration//GEN-END:variables
}
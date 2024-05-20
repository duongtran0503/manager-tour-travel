/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.components;
/**
 *
 * @author Acer
 */
import DTO.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import BUS.UserBUS;
import BUS.CheckError;
public class Forminfor extends javax.swing.JFrame {
UserBUS bus = new UserBUS();
CheckError check = new CheckError();
    /**
     * Creates new form formaddcustommer
     */
    public Forminfor(User user) {
        
        initComponents();
        ten.setText(user.getName());
        sdt.setText(user.getPhone_number());
        mail.setText(user.getEmail());
        diachi.setText(user.getAddress());
        addEventButtonsave (user);
        addEventButtonCancel();
    }
 private void addEventButtonsave(User user){
       save.addActionListener(new ActionListener(){
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
           user.setName(ten.getText());
           user.setPhone_number(sdt.getText());
           user.setEmail(mail.getText());
           user.setAddress(diachi.getText());
           bus.update(user);
           JOptionPane.showMessageDialog(null, "Da thay doi thong tin khach hang");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        diachi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        sdt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        cancel = new GUI.components.ButtonRadius();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        errorPhone = new javax.swing.JLabel();
        ten = new javax.swing.JTextField();
        save = new GUI.components.ButtonRadius();
        mail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thông tin khach hang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 620, 30));

        diachi.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        diachi.setForeground(new java.awt.Color(153, 153, 153));
        diachi.setBorder(null);
        jPanel1.add(diachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 590, 30));

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
        jLabel6.setText("Địa Chỉ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 20));

        sdt.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        sdt.setForeground(new java.awt.Color(153, 153, 153));
        sdt.setBorder(null);
        sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtActionPerformed(evt);
            }
        });
        jPanel1.add(sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 590, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 590, 20));

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
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 590, 20));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 590, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel14.setText("Email");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        errorPhone.setText(" ");
        jPanel1.add(errorPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 280, 30));

        ten.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        ten.setForeground(new java.awt.Color(153, 153, 153));
        ten.setBorder(null);
        jPanel1.add(ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 590, 30));

        save.setBackground(new java.awt.Color(125, 45, 255));
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Lưu");
        save.setBorderColor(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        save.setRadius(20);
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 170, 30));

        mail.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        mail.setForeground(new java.awt.Color(153, 153, 153));
        mail.setBorder(null);
        jPanel1.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 590, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.ButtonRadius cancel;
    private javax.swing.JTextField diachi;
    private javax.swing.JLabel errorPhone;
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

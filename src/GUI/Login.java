/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

/**
 *
 * @author ACER
 */
public class Login extends javax.swing.JFrame {
   public TaiKhoanBUS tkbus;
   public TaiKhoanDTO  user;
   private boolean  statusInput = false;
    public Login() {
        this.tkbus = new TaiKhoanBUS();
        this.user = new TaiKhoanDTO();
        initComponents();
        inputUserNameEvent();
        inputPasswordEvent();
        buttonLoginEnvent();
        setButtonHidenORShowPassword();
    }

    @Override
    public Graphics getGraphics() {
        return super.getGraphics(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    // thêm event vào ô input user name 
     private void inputUserNameEvent(){
        // add focus 
        this.jTextField1.addFocusListener(new FocusListener(){
           // add focus event
            @Override
            public void focusGained(FocusEvent e) {
                jTextField1.setText("");
             jTextField1.setForeground(Color.BLACK);
            }
              // nếu người dùng không nhập sẽ báo lỗi
            @Override
            public void focusLost(FocusEvent e) {
                if(jTextField1.getText().length()==0){
                    jTextField1.setText("trường này không được để trống");
             jTextField1.setForeground(Color.red); 
                }
            }
        });
        
     }
     // thêm event vào ô password
      private void inputPasswordEvent(){
        this.jPasswordField1.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                jPasswordField1.setText("");
                jPasswordField1.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(jPasswordField1.getPassword().length==0) {
                 jLabel4.setText("password không được để trống");
                 statusInput = false;
                 return;
                }
                if(jPasswordField1.getPassword().length!=0 && jTextField1.getText().length()!=0){
                 statusInput = true;
                }
            }
          
        });
      }
   // thêm event button 
      private void buttonLoginEnvent(){
                buttonRadius1.addActionListener((ActionEvent e) -> {
                     if(jPasswordField1.getPassword().length!=0 && jTextField1.getText().length()!=0){
                 statusInput = true;
                }
                    if(!statusInput) {
                        
                        String ErrorString = "thông tin đăng nhập không hợp lệ vui lòng kiểm tra lại";
                        jLabel4.setText("<html>"+ ErrorString +"</html>");
                        return;
                    }
                    String PassWrodString = new String(jPasswordField1.getPassword());
                    System.out.println(jTextField1.getText()+ " "+ PassWrodString);
                    user.passWord = PassWrodString;
                    user.Email = jTextField1.getText();
                    TaiKhoanBUS.ErrorMessage errorMessage =  tkbus.checkAcount(user);
                   if( !errorMessage.getStatus()){
                     jLabel4.setText(errorMessage.getMessage());
                             
                   } else {
                     App.status = user;
                     App.routes();
                   }
                });
      }
      private void setButtonHidenORShowPassword(){
         this.jLabel5.addMouseListener(new MouseAdapter()  
                               {  
    @Override
    public void mouseClicked(MouseEvent e)  
    {  
     if(jPasswordField1.getEchoChar()!='\u0000'){
       jPasswordField1.setEchoChar('\u0000');
     } else {
       jPasswordField1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));  jPasswordField1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
     }
       

    }  
});
         
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        buttonRadius1 = new GUI.components.ButtonRadius();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel1.setText("Mật khẩu");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel2.setText("Tên đăng nhập");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));

        buttonRadius1.setBorder(null);
        buttonRadius1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRadius1.setText("Đăng nhập");
        buttonRadius1.setBorderColor(new java.awt.Color(0, 0, 0));
        buttonRadius1.setColor(new java.awt.Color(0, 0, 0));
        buttonRadius1.setColorClick(new java.awt.Color(102, 102, 102));
        buttonRadius1.setColorOver(new java.awt.Color(204, 204, 204));
        buttonRadius1.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        buttonRadius1.setRadius(20);
        buttonRadius1.setRequestFocusEnabled(false);

        jTextField1.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("nhập tên người dùng");
        jTextField1.setBorder(null);

        jPasswordField1.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jPasswordField1.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/showPasssword.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttonRadius1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPasswordField1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(buttonRadius1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        jTextField1.getAccessibleContext().setAccessibleName("inputUserName");
        jLabel4.getAccessibleContext().setAccessibleName("boxErrorMessage");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 380, 540));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-login.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.ButtonRadius buttonRadius1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

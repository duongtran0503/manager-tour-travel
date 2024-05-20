/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import raven.toast.Notifications;

/**
 *
 * @author ACER
 */
public class Home extends javax.swing.JFrame {

  public static Home homeElement ;
    public Home() {
        homeElement = this;
        initComponents();
      
       ImageIcon img = new ImageIcon(App.globalPathApp+"\\image\\Frame.png");
       getContentPane().setBackground(Color.black);
       this.setIconImage(img.getImage());
       this.pack();
        initToast();
       setNameUser();
       
    }
  // lấy main from 
   public JTabbedPane getMainFrom(){
    return this.mainForm1.getContainM();
   }
   // toast config
   private void initToast(){
        Notifications.getInstance().setJFrame(this);
   }
  public void showToast(String message){
    Notifications.getInstance().show(Notifications.Type.SUCCESS,Notifications.Location.TOP_RIGHT,message);
  }
  // controll layout
  private void setNameUser(){
   this.header1.getTitle().setText(App.status.getUserName());
      System.out.println(App.status.getUserName());
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menu1 = new GUI.components.Menu();
        header1 = new GUI.components.Header();
        mainForm1 = new GUI.components.MainForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tour manager");
        setBackground(new java.awt.Color(33, 33, 33));
        setForeground(java.awt.Color.black);
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setModalExclusionType(null);
        setSize(new java.awt.Dimension(1220, 700));

        jPanel1.setBackground(new java.awt.Color(33, 33, 33));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));
        jPanel1.add(mainForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, 660));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.Header header1;
    private javax.swing.JPanel jPanel1;
    private GUI.components.MainForm mainForm1;
    private GUI.components.Menu menu1;
    // End of variables declaration//GEN-END:variables

   
}

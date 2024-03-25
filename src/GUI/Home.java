/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author ACER
 */
public class Home extends javax.swing.JFrame {

  public static Home homeElement ;
    public Home() {
        homeElement = this;
        initComponents();
       ImageIcon img = new ImageIcon("D:\\JAVA\\travel\\src\\image\\Frame.png");
       this.setIconImage(img.getImage());
    }
  // lấy main from 
   public JTabbedPane getMainFrom(){
    return this.mainForm1.getContainM();
   }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainForm1 = new GUI.components.MainForm();
        menu1 = new GUI.components.Menu();
        header1 = new GUI.components.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tour manager");
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 725));
        setSize(new java.awt.Dimension(1200, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(mainForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 990, 640));
        getContentPane().add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.Header header1;
    private GUI.components.MainForm mainForm1;
    private GUI.components.Menu menu1;
    // End of variables declaration//GEN-END:variables

   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.components;

import GUI.App;
import GUI.Home;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

       // Getter và Setter cho jLabel1
    public JLabel getJLabel1() {
        return jLabel1;
    }

    public void setJLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    // Getter và Setter cho jLabel2
    public JLabel getJLabel2() {
        return jLabel2;
    }

    public void setJLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    // Getter và Setter cho jLabel5
    public JLabel getJLabel5() {
        return jLabel5;
    }

    public void setJLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    // Getter và Setter cho jLabel6
    public JLabel getJLabel6() {
        return jLabel6;
    }

    public void setJLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    // Getter và Setter cho jPanel1
    public JPanel getJPanel1() {
        return jPanel1;
    }

    public void setJPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    // Getter và Setter cho jPanel2
    public JPanel getJPanel2() {
        return jPanel2;
    }

    public void setJPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    // Getter và Setter cho panelRadius1
    public PanelRadius getPanelRadius1() {
        return panelRadius1;
    }

    public void setPanelRadius1(PanelRadius panelRadius1) {
        this.panelRadius1 = panelRadius1;
    }

    // Getter và Setter cho panelRadius2
    public PanelRadius getPanelRadius2() {
        return panelRadius2;
    }

    public void setPanelRadius2(PanelRadius panelRadius2) {
        this.panelRadius2 = panelRadius2;
    }

    // Getter và Setter cho panelRadius3
    public PanelRadius getPanelRadius3() {
        return panelRadius3;
    }

    public void setPanelRadius3(PanelRadius panelRadius3) {
        this.panelRadius3 = panelRadius3;
    }

    // Getter và Setter cho panelRadius4
    public PanelRadius getPanelRadius4() {
        return panelRadius4;
    }

    public void setPanelRadius4(PanelRadius panelRadius4) {
        this.panelRadius4 = panelRadius4;
    }

    // Getter và Setter cho panelRadius5
    public PanelRadius getPanelRadius5() {
        return panelRadius5;
    }

    public void setPanelRadius5(PanelRadius panelRadius5) {
        this.panelRadius5 = panelRadius5;
    }

    // Getter và Setter cho panelRadius6
    public PanelRadius getPanelRadius6() {
        return panelRadius6;
    }

    public void setPanelRadius6(PanelRadius panelRadius6) {
        this.panelRadius6 = panelRadius6;
    }

    // Getter và Setter cho panelRadius7
    public PanelRadius getPanelRadius7() {
        return panelRadius7;
    }

    public void setPanelRadius7(PanelRadius panelRadius7) {
        this.panelRadius7 = panelRadius7;
    }

    // Getter và Setter cho panelRadius8
    public PanelRadius getPanelRadius8() {
        return panelRadius8;
    }

    public void setPanelRadius8(PanelRadius panelRadius8) {
        this.panelRadius8 = panelRadius8;
    }
    public void setColorUnOnClick(){
      this.panelRadius1.setBackground(new Color(102, 102, 102));
            this.panelRadius2.setBackground(new Color(102, 102, 102));
      this.panelRadius3.setBackground(new Color(102, 102, 102));
      this.panelRadius4.setBackground(new Color(102, 102, 102));
      this.panelRadius5.setBackground(new Color(102, 102, 102));
      this.panelRadius6.setBackground(new Color(102, 102, 102));
      this.panelRadius7.setBackground(new Color(102, 102, 102));
     

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelRadius1 = new GUI.components.PanelRadius();
        jLabel3 = new javax.swing.JLabel();
        panelRadius2 = new GUI.components.PanelRadius();
        jLabel2 = new javax.swing.JLabel();
        panelRadius3 = new GUI.components.PanelRadius();
        jLabel4 = new javax.swing.JLabel();
        panelRadius4 = new GUI.components.PanelRadius();
        panelRadius5 = new GUI.components.PanelRadius();
        panelRadius6 = new GUI.components.PanelRadius();
        panelRadius7 = new GUI.components.PanelRadius();
        panelRadius8 = new GUI.components.PanelRadius();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 51));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setPreferredSize(new java.awt.Dimension(220, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 220, 80));

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Main menu");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 86, 210, 20));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 110));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRadius1.setBackground(new java.awt.Color(255, 156, 39));
        panelRadius1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Thống Kê");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setIconTextGap(12);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        panelRadius1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 35));

        jPanel2.add(panelRadius1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 35));

        panelRadius2.setBackground(new java.awt.Color(102, 102, 102));
        panelRadius2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Khách hàng");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setIconTextGap(12);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        panelRadius2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 35));

        jPanel2.add(panelRadius2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, 35));

        panelRadius3.setBackground(new java.awt.Color(102, 102, 102));
        panelRadius3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tour Du Lịch");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setIconTextGap(12);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panelRadius3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 35));

        jPanel2.add(panelRadius3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 200, 35));

        panelRadius4.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRadius5.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRadius4.add(panelRadius5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 35));

        jPanel2.add(panelRadius4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 35));

        panelRadius6.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(panelRadius6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, 35));

        panelRadius7.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(panelRadius7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 200, 35));

        panelRadius8.setBackground(new java.awt.Color(51, 51, 51));
        panelRadius8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logout.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panelRadius8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 190, 25));

        jPanel2.add(panelRadius8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 200, 35));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       Home.homeElement.getMainFrom().setSelectedIndex(1);
       setColorUnOnClick();
       this.panelRadius2.setBackground(new Color(255, 156, 39));
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.out.println("home close window run ");
        App.status = null;
        Home.homeElement.dispose();
       App.routes();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Home.homeElement.getMainFrom().setSelectedIndex(0);
       setColorUnOnClick();
       this.panelRadius1.setBackground(new Color(255, 156, 39));
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Home.homeElement.getMainFrom().setSelectedIndex(2);
       setColorUnOnClick();
       this.panelRadius3.setBackground(new Color(255, 156, 39));
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private GUI.components.PanelRadius panelRadius1;
    private GUI.components.PanelRadius panelRadius2;
    private GUI.components.PanelRadius panelRadius3;
    private GUI.components.PanelRadius panelRadius4;
    private GUI.components.PanelRadius panelRadius5;
    private GUI.components.PanelRadius panelRadius6;
    private GUI.components.PanelRadius panelRadius7;
    private GUI.components.PanelRadius panelRadius8;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.components;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author ACER
 */
public class MainForm extends javax.swing.JPanel {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    // Getter và Setter cho containM
    public  JTabbedPane getContainM() {
        return containM;
    }

    public void setContainM(JTabbedPane containM) {
        this.containM = containM;
    }

    // Getter và Setter cho jPanel3
    public JPanel getJPanel3() {
        return jPanel3;
    }

    public void setJPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    // Getter và Setter cho m1
    public JPanel getM1() {
        return m1;
    }

    public void setM1(JPanel m1) {
        this.m1 = m1;
    }

    // Getter và Setter cho m2
    public JPanel getM2() {
        return m2;
    }

    public void setM2(JPanel m2) {
        this.m2 = m2;
    }

    // Getter và Setter cho m3
    public JPanel getM3() {
        return m3;
    }

    public void setM3(JPanel m3) {
        this.m3 = m3;
    }

    // Getter và Setter cho m4
    public JPanel getM4() {
        return m4;
    }

    public void setM4(JPanel m4) {
        this.m4 = m4;
    }

    // Getter và Setter cho m5
    public JPanel getM5() {
        return m5;
    }

    public void setM5(JPanel m5) {
        this.m5 = m5;
    }

    // Getter và Setter cho m6
    public JPanel getM6() {
        return m6;
    }

    public void setM6(JPanel m6) {
        this.m6 = m6;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        containM = new javax.swing.JTabbedPane();
        m1 = new javax.swing.JPanel();
        thongKe1 = new GUI.panel.ThongKe();
        m2 = new javax.swing.JPanel();
        nguoiDung1 = new GUI.panel.NguoiDung();
        m3 = new javax.swing.JPanel();
        tourDuLich1 = new GUI.panel.TourDuLich();
        m4 = new javax.swing.JPanel();
        m5 = new javax.swing.JPanel();
        m6 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(33, 33, 33));
        setMaximumSize(new java.awt.Dimension(995, 2147483647));
        setMinimumSize(new java.awt.Dimension(980, 640));
        setPreferredSize(new java.awt.Dimension(980, 640));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(33, 33, 33));

        containM.setBackground(new java.awt.Color(33, 33, 33));

        m1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        m1.add(thongKe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        containM.addTab("tab1", m1);

        m2.setBackground(new java.awt.Color(255, 255, 255));
        m2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        m2.add(nguoiDung1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        containM.addTab("tab2", m2);

        m3.setPreferredSize(new java.awt.Dimension(970, 562));
        m3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        m3.add(tourDuLich1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        containM.addTab("tab3", m3);
        containM.addTab("tab4", m4);
        containM.addTab("tab5", m5);
        containM.addTab("tab6", m6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containM, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(containM, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -28, 980, 680));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane containM;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel m1;
    private javax.swing.JPanel m2;
    private javax.swing.JPanel m3;
    private javax.swing.JPanel m4;
    private javax.swing.JPanel m5;
    private javax.swing.JPanel m6;
    private GUI.panel.NguoiDung nguoiDung1;
    private GUI.panel.ThongKe thongKe1;
    private GUI.panel.TourDuLich tourDuLich1;
    // End of variables declaration//GEN-END:variables
}

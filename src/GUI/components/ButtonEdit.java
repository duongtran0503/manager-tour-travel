/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.components;

/**
 *
 * @author ACER
 */
public class ButtonEdit extends javax.swing.JPanel {

    /**
     * Creates new form ButtonEdit
     */
    public ButtonEdit() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonRadius1 = new GUI.components.ButtonRadius();

        setMinimumSize(new java.awt.Dimension(80, 40));
        setPreferredSize(new java.awt.Dimension(50, 30));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonRadius1.setBackground(new java.awt.Color(0, 51, 204));
        buttonRadius1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRadius1.setText("Edit");
        buttonRadius1.setBorderColor(new java.awt.Color(0, 51, 204));
        buttonRadius1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonRadius1.setRadius(10);
        add(buttonRadius1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.ButtonRadius buttonRadius1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.panel;

import java.util.List;
import DTO.User;
import javax.swing.table.DefaultTableModel;
import BUS.UserBUS;
import DTO.Tour;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import GUI.components.Formadd;
import javax.swing.JFrame;
import GUI.components.Forminfor;
/**
 *
 * @author ACER
 */
public class nguoidung extends javax.swing.JPanel {
DefaultTableModel tableModel;
List<User> datalist;
int currentPos = -1;
UserBUS bus = new UserBUS();
    /**
     * Creates new form NguoiDung
     */
    public nguoidung() {
        
        initComponents();
        datalist = bus.getcustomer();
        tableModel = (DefaultTableModel) bang.getModel();  
        showData();
        
         bang.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentPos = bang.getSelectedRow();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });   
         addEventButtonxoa();
         addEventButtonsearch();
         addEventButtonrefresh();
         addEventButtonadd();
         addEventButtonupdate();
    }
    private void showData() {
        this.tableModel.setRowCount(0);
        for (User user : datalist) {
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                user.getUser_id(),
                user.getName(),
                user.getPhone_number(),
                user.getAddress()
            });
        }
    }
    private void addEventButtonxoa()  {
       xoa.addActionListener(new  ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
             if (currentPos == -1) {
            JOptionPane.showMessageDialog(null, "Chua chon khach hang can xoa, vui long kiem tra lai");
            return;
        }
               else{
                 int option = JOptionPane.showConfirmDialog(null, "Ban chac chan muon xoa khac hang nay khong?");
        if (option == 0) {
            bus.delete(datalist.get(currentPos).getUser_id());
            datalist.remove(currentPos);
            currentPos = -1;
            showData();
        }

             }
           }
          
       });
       
    }
        private void addEventButtonsearch()  {
       search.addActionListener(new  ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
        String s = searchtext.getText();
        if (s != null){
            s = "%" + s + "%";
        }
         else {
            JOptionPane.showMessageDialog(null, "chua nhap ten tin khach hang");
            s=null;
               }
        datalist = bus.search(s);
        searchtext.setText("");
        showData();
    }
          
       });
    }
         private void addEventButtonrefresh() {
       refresh.addActionListener(new  ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               datalist=bus.getcustomer();
               showData();
    }
          
       });
    }
                  private void addEventButtonadd() {
       them.addActionListener(new  ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               Formadd box = new Formadd();
               box.setVisible(true);
               box.setLocationRelativeTo(null);
               box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               
    }
          
       });
    }
                  
    private void addEventButtonupdate()  {
       sua.addActionListener(new  ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
             if (currentPos == -1) {
            JOptionPane.showMessageDialog(null, "Chua chon khach hang can xem, vui long kiem tra lai");
            return;
        }
               else{
                 Forminfor box = new Forminfor(datalist.get(currentPos));
                 box.setVisible(true);
                 box.setLocationRelativeTo(null);
                 box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 
                 
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

        panelRadius3 = new GUI.components.PanelRadius();
        panelRadius1 = new GUI.components.PanelRadius();
        jLabel1 = new javax.swing.JLabel();
        panelRadius2 = new GUI.components.PanelRadius();
        searchtext = new javax.swing.JTextField();
        search = new GUI.components.ButtonRadius();
        jScrollPane1 = new javax.swing.JScrollPane();
        bang = new javax.swing.JTable();
        them = new GUI.components.ButtonRadius();
        xoa = new GUI.components.ButtonRadius();
        refresh = new GUI.components.ButtonRadius();
        sua = new GUI.components.ButtonRadius();
        panelRadius5 = new GUI.components.PanelRadius();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRadius1.setForeground(new java.awt.Color(255, 255, 255));
        panelRadius1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thông kê người dùng");
        panelRadius1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        panelRadius2.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchtext.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        searchtext.setForeground(new java.awt.Color(153, 153, 153));
        searchtext.setBorder(null);
        panelRadius2.add(searchtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2, 360, 30));

        search.setText("Tìm Kiếm");
        search.setBorderColor(new java.awt.Color(0, 0, 0));
        search.setRadius(10);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        panelRadius2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 110, 40));

        panelRadius1.add(panelRadius2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 5, 490, 40));

        add(panelRadius1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 970, 50));

        bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Tên", "Số điện thoại", "Địa chỉ"
            }
        ));
        jScrollPane1.setViewportView(bang);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 960, 490));

        them.setText("Thêm");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });
        add(them, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 100, 40));

        xoa.setText("Xóa");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });
        add(xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 110, 40));

        refresh.setText("Làm mới");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 110, 40));

        sua.setText("Thông Tin");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });
        add(sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 110, 40));
        add(panelRadius5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 960, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
          
    }//GEN-LAST:event_searchActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        
    }//GEN-LAST:event_themActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed

        
    }//GEN-LAST:event_xoaActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.components.PanelRadius panelRadius1;
    private GUI.components.PanelRadius panelRadius2;
    private GUI.components.PanelRadius panelRadius3;
    private GUI.components.PanelRadius panelRadius5;
    private GUI.components.ButtonRadius refresh;
    private GUI.components.ButtonRadius search;
    private javax.swing.JTextField searchtext;
    private GUI.components.ButtonRadius sua;
    private GUI.components.ButtonRadius them;
    private GUI.components.ButtonRadius xoa;
    // End of variables declaration//GEN-END:variables
}

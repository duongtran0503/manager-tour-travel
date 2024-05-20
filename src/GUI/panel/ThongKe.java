/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.panel;

import BUS.ThongKeBUS;
import DTO.Orders;
import DTO.Payment;
import DTO.Revenue;
import GUI.components.chart.ModelChart;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ThongKe extends javax.swing.JPanel {

    /**
     * Creates new form ThongKe
     */
    
    private ThongKeBUS thongKeBUS;
    private  ArrayList<DTO.Tour> TourData = new ArrayList<>();
            public ThongKe() {
        this.thongKeBUS = new ThongKeBUS();
        initComponents();
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         setWidtScroll();
            jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
            jScrollPane1.getViewport().setBackground(Color.BLACK);
            initTailValueOfDate();
           initChart();
            initRefreshData();
            setTitleTotailCustomer();
            setTitleTotailOrder();
            setTitleTotailPrice();
            viewTopTour();
      
       
             
    }
    
    private void setWidtScroll(){
     int verticalScrollBarWidthCoefficient =2 ;

jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(
        (int) jScrollPane1.getVerticalScrollBar().getPreferredSize()
                .getWidth() / verticalScrollBarWidthCoefficient,
        (int) jScrollPane1.getVerticalScrollBar().getPreferredSize().getHeight()
     
));
    }
   // ============= initail value month and year chooser ===================
    private void initTailValueOfDate() {
     yearChooser1.setYear(2024);
     monthChooser1.setMonth(4);
    }
    //===========  init chart ===================================
    private void initChart() {
    
       
        curveLineChart1.addLegend("Doanh thu", new Color(135, 189, 245), new Color(245, 189, 135));
        curveLineChart1.addLegend("khách hàng",new Color(255, 0, 0), new Color(255, 214, 0));
        curveLineChart1.addLegend("đặt tour", new Color(186, 85, 211), new Color(75, 0, 130));
        setData(monthChooser1.getMonth(), yearChooser1.getYear());
    
    
    }
    // =============== init button refresh data ===========================
 private void initRefreshData() {
    this.buttonRefresh.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
          
          
           setTitleTotailCustomer();
           setTitleTotailOrder();
           setTitleTotailPrice();
           curveLineChart1.clear();
         
            setData(monthChooser1.getMonth(),yearChooser1.getYear());
           DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
           model.setRowCount(0);
           viewTopTour();
        }
    
    });
 }
 // ====================== function set data of chart =======================
 
  private void setData(int moth , int year) {
      ArrayList<Payment> payList = this.thongKeBUS.getPayment(moth, year);
      ArrayList<Orders> orders = this.thongKeBUS.getOrders(moth, year);
      ArrayList<Revenue> revenues = this.thongKeBUS.getRevenueOFDay(moth, year);
      if(payList.isEmpty()) {return;}
      for(int i = 0;i<payList.size();i++){
       
         curveLineChart1.addData(new ModelChart(payList.get(i).getTime_payment().toString(), new double[]{revenues.get(i).getPrice(),payList.get(i).getNumber(),orders.get(i).getQuantity()}));
      }
     curveLineChart1.start();
              
  }
  // =================== set data totol price ==========
  private void setTitleTotailPrice() {
      double price=this.thongKeBUS.getRevenue(monthChooser1.getMonth(),yearChooser1.getYear());
      String totalPrie=this.thongKeBUS.formatPrice(price)+"";
      this.jLabel2.setText(totalPrie+"");
  }
  // =================== set data totail customer ============================
  private void setTitleTotailCustomer() {
       int totalCustomer = this.thongKeBUS.getTotalCusTomer(monthChooser1.getMonth(),yearChooser1.getYear());
      this.jLabel5.setText(totalCustomer+" Khách hàng"); 
  }
  // ========== set data title totail order =================
   private void setTitleTotailOrder() {
       int totalOrder = this.thongKeBUS.getTotalOrder(monthChooser1.getMonth(), yearChooser1.getYear());
      
      this.jLabel6.setText(totalOrder+" lượt"); 
  }
private void viewTopTour() {
    ArrayList<DTO.Tour> listTour = this.thongKeBUS.getTopTour(monthChooser1.getMonth(), yearChooser1.getYear());
     this.TourData = listTour;
    // Ensure listTour is not empty before accessing its elements
    if (listTour.isEmpty()) {
      return;
    }

    tourInfo.getButtonDelete().setVisible(false);
    tourInfo.getButtonEdit().setVisible(false);
    tourInfo.getButtonOrder().setVisible(false);
    tourInfo.setInfo(listTour.get(0));

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear existing rows
    int index = 1;
    for (DTO.Tour tour : listTour) {
        String row[] = {
            String.valueOf(index),
            "<html>"+tour.getTitle()+"</html>",
            this.thongKeBUS.formatPrice(tour.getPrice_one_person()),
            this.thongKeBUS.formatPrice(tour.getExpense()),
            tour.getQuantity()+""
        };
        model.addRow(row);
        index++;
    }

    jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    
                    int tourIndex = Integer.parseInt((String) jTable1.getValueAt(selectedRow, 0))-1;
                   
                    if (tourIndex >= 0 && tourIndex < listTour.size()) {
                       tourInfo.setInfo(TourData.get(tourIndex));
                    }
                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelRadius1 = new GUI.components.PanelRadius();
        jLabel6 = new javax.swing.JLabel();
        panelRadius10 = new GUI.components.PanelRadius();
        jLabel12 = new javax.swing.JLabel();
        panelRadius2 = new GUI.components.PanelRadius();
        jLabel2 = new javax.swing.JLabel();
        panelRadius8 = new GUI.components.PanelRadius();
        jLabel1 = new javax.swing.JLabel();
        panelRadius3 = new GUI.components.PanelRadius();
        jLabel5 = new javax.swing.JLabel();
        panelRadius9 = new GUI.components.PanelRadius();
        jLabel11 = new javax.swing.JLabel();
        panelRadius4 = new GUI.components.PanelRadius();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelRadius11 = new GUI.components.PanelRadius();
        curveLineChart1 = new GUI.components.chart.CurveLineChart();
        panelRadius5 = new GUI.components.PanelRadius();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelRadius6 = new GUI.components.PanelRadius();
        jLabel9 = new javax.swing.JLabel();
        panelInfoTour = new javax.swing.JPanel();
        tourInfo = new GUI.components.CartItem();
        panelRadius7 = new GUI.components.PanelRadius();
        jLabel4 = new javax.swing.JLabel();
        yearChooser1 = new GUI.components.YearChooser();
        monthChooser1 = new GUI.components.MonthChooser();
        jLabel7 = new javax.swing.JLabel();
        buttonRefresh = new GUI.components.ButtonRadius();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(985, 660));
        setPreferredSize(new java.awt.Dimension(985, 660));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(980, 950));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 1500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRadius1.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("350 lược đặt tour");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRadius1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 280, 60));

        panelRadius10.setBackground(new java.awt.Color(126, 221, 1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Booking");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRadius10.add(jLabel12);

        panelRadius1.add(panelRadius10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 290, 30));

        jPanel1.add(panelRadius1, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 80, 320, 130));

        panelRadius2.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 51, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("100.000.000 đ");
        jLabel2.setToolTipText("");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRadius2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 280, 60));

        panelRadius8.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Doanh thu");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRadius8.add(jLabel1);

        panelRadius2.add(panelRadius8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 290, 30));

        jPanel1.add(panelRadius2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, 320, 130));

        panelRadius3.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("1000 người");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRadius3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 280, 60));

        panelRadius9.setBackground(new java.awt.Color(102, 107, 218));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tổng khách hàng");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRadius9.add(jLabel11);

        panelRadius3.add(panelRadius9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 290, 30));

        jPanel1.add(panelRadius3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 320, 130));

        panelRadius4.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Thống kế trong tháng");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, 10));

        panelRadius4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 910, 40));

        panelRadius11.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRadius11.add(curveLineChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 920, 380));

        panelRadius4.add(panelRadius11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 950, 390));

        jPanel1.add(panelRadius4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 250, 970, 450));

        panelRadius5.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Top tour được đặt đi nhiều ");
        panelRadius5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Tour", "Giá", "tri phí tổ chức", "lược đặt tour"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setMinimumSize(new java.awt.Dimension(100, 0));
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTable1);

        panelRadius5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 530, 310));

        jPanel1.add(panelRadius5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 530, 350));

        panelRadius6.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Thông tin tour");
        panelRadius6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        panelInfoTour.setBackground(new java.awt.Color(255, 255, 255));
        panelInfoTour.add(tourInfo);

        panelRadius6.add(panelInfoTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 40, 420, 300));

        jPanel1.add(panelRadius6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 720, 430, 350));

        panelRadius7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Chọn năm:");
        panelRadius7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 15, 90, -1));

        yearChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yearChooser1PropertyChange(evt);
            }
        });
        panelRadius7.add(yearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 15, -1, -1));

        monthChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                monthChooser1PropertyChange(evt);
            }
        });
        panelRadius7.add(monthChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 15, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Chọn tháng :");
        panelRadius7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 15, 90, -1));

        buttonRefresh.setText("Làm mới");
        buttonRefresh.setRadius(10);
        panelRadius7.add(buttonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 12, 90, 28));

        jPanel1.add(panelRadius7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 970, 50));

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 1090));
    }// </editor-fold>//GEN-END:initComponents

    private void monthChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_monthChooser1PropertyChange
       monthChooser1.setMonth(monthChooser1.getMonth());
    }//GEN-LAST:event_monthChooser1PropertyChange

    private void yearChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yearChooser1PropertyChange
       yearChooser1.setYear(yearChooser1.getYear());
    }//GEN-LAST:event_yearChooser1PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.ButtonRadius buttonRefresh;
    private GUI.components.chart.CurveLineChart curveLineChart1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private GUI.components.MonthChooser monthChooser1;
    private javax.swing.JPanel panelInfoTour;
    private GUI.components.PanelRadius panelRadius1;
    private GUI.components.PanelRadius panelRadius10;
    private GUI.components.PanelRadius panelRadius11;
    private GUI.components.PanelRadius panelRadius2;
    private GUI.components.PanelRadius panelRadius3;
    private GUI.components.PanelRadius panelRadius4;
    private GUI.components.PanelRadius panelRadius5;
    private GUI.components.PanelRadius panelRadius6;
    private GUI.components.PanelRadius panelRadius7;
    private GUI.components.PanelRadius panelRadius8;
    private GUI.components.PanelRadius panelRadius9;
    private GUI.components.CartItem tourInfo;
    private GUI.components.YearChooser yearChooser1;
    // End of variables declaration//GEN-END:variables
}

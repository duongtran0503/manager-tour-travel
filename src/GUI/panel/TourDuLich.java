/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.panel;

import BUS.QLTourBUS;
import DTO.Tour;

import GUI.App;
import GUI.components.CartItem;
import GUI.components.FormAddTour;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import BUS.ObjectType.MessageDAL;
import GUI.components.FormEditTour;
import GUI.components.FormOrderTour;

/**
 *
 * @author ACER
 */
public class TourDuLich extends javax.swing.JPanel  {

    /**
     * Creates new form TourDuLich
     */
    private final QLTourBUS qltbus;
    public TourDuLich() {
        qltbus = new QLTourBUS();
        initComponents();
        addValueTable();
        addEventButtonAddTOur();
        addEventButtonRefresh();
        addEventButtonSearch();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void addEventButtonAddTOur(){
      this.buttonAddTour.addActionListener((ActionEvent e) -> {
          FormAddTour box = new FormAddTour();
          box.setVisible(true);
          box.setLocationRelativeTo(null);
          box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      });
     }
  
    private  String formatPriceVND(double amount) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnam);
        return currencyFormatter.format(amount);
    }

 //============= function add value table  =======================    
    private void addValueTable(){
     ArrayList<Tour> lists = qltbus.getAllTour();

    
    jPanel2.removeAll();
    FlowLayout layout = new FlowLayout(1, 10, 10);
    jPanel2.setLayout(layout);
    
    for (Tour tour : lists) {
        CartItem cart = new CartItem();
        cart.setTour(tour);
        String path = App.globalPathApp + "\\Store_img\\" + tour.getImgUrl();
        cart.setImage(path);
        cart.setAddress("<html>"+ "địa chỉ:"+tour.getAddress()+"</html>");
        cart.setNameTour("tên:"+tour.getTitle());
        cart.setPrice(formatPriceVND(tour.getPrice_one_person() * 1000));
        cart.setDesciption("<html>"+ "mô tả:"+tour.getDestination_description()+"</html>");
          cart.setCartIid(tour.getTour_id());
          cart.setDateStart("thòi gian bắt đầu:"+tour.getTime_book_start());
          cart.setDateEnd("thời gian kết thúc:"+tour.getTime_book_end());
          cart.setQuantity(tour.getQuantity());
        cart.getButtonDelete().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             
             int result = JOptionPane.showConfirmDialog(null, "xóa tour:"+cart.getName(),"thông báo", JOptionPane.YES_NO_OPTION);
             if(result ==JOptionPane.YES_OPTION) {
               MessageDAL state = qltbus.deleteTour(cart.getCartId());
                JOptionPane.showMessageDialog(null, state.getMessage());
                if(state.getStatus()) {
                    addValueTable();
                }
             } 
                     
          } 
         
          
        });
        cart.getButtonEdit().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
              FormEditTour form = new FormEditTour();
               form.setVisible(true);
               form.setLocationRelativeTo(null);
               form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               Tour tourEdit  = cart.getTour();
               form.setTour(tourEdit);
               form.setValueEdit(tourEdit.getTitle(),tourEdit.getAddress()
                               
  , tourEdit.getPrice_one_person(),tourEdit.getDestination_description(), tourEdit.getTime_book_start(),tourEdit.getTime_book_end(), tourEdit.getExpense(),tourEdit.getImgUrl(),tourEdit
               .getQuantity());
           }
           
        });
       cart.getButtonOrder().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cart.getTour().getQuantity()==0){
                 JOptionPane.showMessageDialog(null, "tour đã hết lược đặt chuyển đi");
                } else {
                 FormOrderTour form =new FormOrderTour();
                   CartItem cartTemp = cart;
              if ( cartTemp.getButtonDelete() != null && cartTemp.getButtonEdit() != null && cartTemp.getButtonOrder() != null) {
    cartTemp.getButtonDelete().setVisible(false);
    cartTemp.getButtonEdit().setVisible(false);
    cartTemp.getButtonOrder().setVisible(false);}
             
               
              
             
    form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  
    form.getInFoContainer().add(cartTemp);
    form.setVisible(true);
    form.setLocationRelativeTo(null);
                
              
                }
                
            }
             
       });
       
        
        
          
       
        jPanel2.add(cart); 
      
    } 
   
    }
    private void addEventButtonRefresh(){
      buttonRefresh.addActionListener(new  ActionListener(){
        @Override
        public void actionPerformed( ActionEvent e
        ){
           addValueTable();
        }
      });
      
    }
      private  void searchResult(ArrayList<Tour> lists) {
      
    jPanel2.removeAll();
    FlowLayout layout = new FlowLayout(1, 10, 10);
    jPanel2.setLayout(layout);
    
    for (Tour tour : lists) {
        CartItem cart = new CartItem();
        cart.setTour(tour);
        String path = App.globalPathApp + "\\Store_img\\" + tour.getImgUrl();
        cart.setImage(path);
        cart.setAddress("<html>"+ "địa chỉ:"+tour.getAddress()+"</html>");
        cart.setNameTour("tên:"+tour.getTitle());
        cart.setPrice(formatPriceVND(tour.getPrice_one_person() * 1000));
        cart.setDesciption("<html>"+ "mô tả:"+tour.getDestination_description()+"</html>");
          cart.setCartIid(tour.getTour_id());
          cart.setDateStart("thòi gian bắt đầu:"+tour.getTime_book_start());
          cart.setDateEnd("thời gian kết thúc:"+tour.getTime_book_end());
          cart.setQuantity(tour.getQuantity());
        cart.getButtonDelete().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             
             int result = JOptionPane.showConfirmDialog(null, "xóa tour:"+cart.getName(),"thông báo", JOptionPane.YES_NO_OPTION);
             if(result ==JOptionPane.YES_OPTION) {
               MessageDAL state = qltbus.deleteTour(cart.getCartId());
                JOptionPane.showMessageDialog(null, state.getMessage());
                if(state.getStatus()) {
                    addValueTable();
                }
             } 
                     
          } 
         
          
        });
        cart.getButtonEdit().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
              FormEditTour form = new FormEditTour();
               form.setVisible(true);
               form.setLocationRelativeTo(null);
               form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               Tour tourEdit  = cart.getTour();
               form.setTour(tourEdit);
               form.setValueEdit(tourEdit.getTitle(),tourEdit.getAddress()
                               
  , tourEdit.getPrice_one_person(),tourEdit.getDestination_description(), tourEdit.getTime_book_start(),tourEdit.getTime_book_end(), tourEdit.getExpense(),tourEdit.getImgUrl(),tourEdit.getQuantity());
           }
           
        });
       cart.getButtonOrder().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FormOrderTour form =new FormOrderTour();
                form.setVisible(true);
                form.setLocationRelativeTo(null);
                form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
             
       });
       
        
        
          
       
        jPanel2.add(cart); 
      
    } 
    }
    private void addEventButtonSearch()  {
       buttonSearch.addActionListener(new  ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               String keySearch = inputSearch.getText();
               if(keySearch.length() !=0) {
                   ArrayList <Tour> result = qltbus.searchTour(keySearch);
                   if(result.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "không có kết quả nào trong database");
                   } else {
                      searchResult(result);
                   }
               }
           }
          
       });
       
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRadius1 = new GUI.components.PanelRadius();
        jLabel1 = new javax.swing.JLabel();
        panelRadius2 = new GUI.components.PanelRadius();
        inputSearch = new javax.swing.JTextField();
        buttonSearch = new GUI.components.ButtonRadius();
        buttonRefresh = new GUI.components.ButtonRadius();
        buttonAddTour = new GUI.components.ButtonRadius();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(980, 186));
        setPreferredSize(new java.awt.Dimension(980, 660));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRadius1.setForeground(new java.awt.Color(255, 255, 255));
        panelRadius1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thống Kê Tour du lịch");
        panelRadius1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        panelRadius2.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputSearch.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        inputSearch.setBorder(null);
        panelRadius2.add(inputSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2, 360, 30));

        buttonSearch.setText("Tìm Kiếm");
        buttonSearch.setBorderColor(new java.awt.Color(0, 0, 0));
        buttonSearch.setRadius(10);
        panelRadius2.add(buttonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 110, 40));

        panelRadius1.add(panelRadius2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 5, 490, 40));

        buttonRefresh.setText("làm mới");
        buttonRefresh.setBorderColor(new java.awt.Color(0, 0, 204));
        buttonRefresh.setColorOver(new java.awt.Color(102, 102, 255));
        buttonRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonRefresh.setIconTextGap(8);
        buttonRefresh.setRadius(8);
        panelRadius1.add(buttonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 5, 110, 40));

        buttonAddTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon-add.png"))); // NOI18N
        buttonAddTour.setText("Thêm");
        buttonAddTour.setBorderColor(new java.awt.Color(0, 0, 204));
        buttonAddTour.setColorOver(new java.awt.Color(102, 102, 255));
        buttonAddTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonAddTour.setIconTextGap(8);
        buttonAddTour.setRadius(8);
        panelRadius1.add(buttonAddTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(845, 5, 120, 40));

        add(panelRadius1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 970, 50));

        jPanel2.setPreferredSize(new java.awt.Dimension(980, 2000));
        jScrollPane1.setViewportView(jPanel2);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 980, 1090));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.ButtonRadius buttonAddTour;
    private GUI.components.ButtonRadius buttonRefresh;
    private GUI.components.ButtonRadius buttonSearch;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.components.PanelRadius panelRadius1;
    private GUI.components.PanelRadius panelRadius2;
    // End of variables declaration//GEN-END:variables
}

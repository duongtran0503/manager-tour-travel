/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.components;

import BUS.CheckError;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import DTO.Tour;
import BUS.ObjectType.MessageDAL;
import BUS.QLTourBUS;
import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import GUI.App;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 *
 * @author ACER
 */

public class FormAddTour extends javax.swing.JFrame {

    /**
     * Creates new form FormAddTour
     */
    private QLTourBUS qLTourBUS;
    private boolean isValid = false;
    private  java.sql.Date dStart ;
      private  java.sql.Date dEnd ;
      private String nameImage = "";
    public FormAddTour() {
        this.qLTourBUS  = new QLTourBUS();
        initComponents();
        formValidation();
        submit();
        addEventButtonCancel();
        addEventButtonChangeImage();
    }
 private void formValidation() {
     this.inputName.addFocusListener(new FocusListener(){
           // add focus event
            @Override
            public void focusGained(FocusEvent e) {
                 errorMessageName.setText("");
            }
              // nếu người dùng không nhập sẽ báo lỗi
            @Override
            public void focusLost(FocusEvent e) {
               if(inputName.getText().length()==0) {
                 errorMessageName.setText("lôi");
                 errorMessageName.setForeground(Color.red);
                 isValid = false;
               } else {
                isValid = true;
               }
                
            }
        });
     this.iinputAddress.addFocusListener(new FocusListener(){
        @Override
        public void focusGained(FocusEvent e) {
          errorMessageAddress.setText("");
        }
        @Override
        public void focusLost(FocusEvent e) {
           if(iinputAddress.getText().length()==0) {
            errorMessageAddress.setText("lỗi");
            errorMessageAddress.setForeground(Color.red);
            isValid =false;
           } else {
            isValid = true;
           }
         }
     });
     
     this.inputDescription.addFocusListener(new FocusListener(){
        @Override
        public void focusGained(FocusEvent e) {
         errorDesciption.setText("");
        }
        @Override
        public void focusLost(FocusEvent e) {
           if(inputDescription.getText().length()==0) {
            errorDesciption.setText("lỗi");
            errorDesciption.setForeground(Color.red);
            isValid  = false;
           } else {
             isValid = true;
           }
         }
     });
       this.inputPrice_on_one_persion1.addFocusListener(new FocusListener(){
       @Override
         public void focusGained(FocusEvent e) {
                inputPrice_on_one_persion1.setText("");
                 errorPrice1.setText("");
             }

         @Override
         public void focusLost(FocusEvent e) {
             String inputValue =inputPrice_on_one_persion1.getText();
             if(!CheckError.isNumber(inputValue) && inputValue.length() >0) {
               errorPrice1.setText("không hợp lệ!");
               
               errorPrice1.setForeground(Color.red);
               isValid = false;
             } else {
              isValid = true;
             }
            if(inputValue.length()==0) {
               inputPrice_on_one_persion1.setText("không được để trống!");
               errorPrice1.setForeground(Color.red);
               isValid = false;
            } else {
             isValid =  true;
            }
         }
     }
     );
     this.inputQuantity.addFocusListener(new FocusListener(){
       @Override
         public void focusGained(FocusEvent e) {
                inputQuantity.setText("");
                 errorQuantity.setText("");
             }

         @Override
         public void focusLost(FocusEvent e) {
             String inputValue =inputQuantity.getText();
             if(!CheckError.isNumber(inputValue) && inputValue.length() >0) {
               errorQuantity.setText("không hợp lệ!");
               
               errorQuantity.setForeground(Color.red);
               isValid = false;
             } else {
              isValid = true;
             }
            if(inputValue.length()==0) {
               errorQuantity.setText("không được để trống!");
               errorQuantity.setForeground(Color.red);
               isValid = false;
            } else {
             isValid =  true;
            }
         }
     }
     );
     this.inpuExpense.addFocusListener(new FocusListener(){
       @Override
         public void focusGained(FocusEvent e) {
             inpuExpense.setText("");
               errorExpense.setText("");
             }

         @Override
         public void focusLost(FocusEvent e) {
             String inputValue =inpuExpense.getText();
             if(!CheckError.isNumber(inputValue) && inputValue.length() >0) {
               errorExpense.setText("không hợp lệ!");
               errorExpense.setForeground(Color.red);
               isValid = false;
             } else {
               isValid = true;
             }
            if(inputValue.length()==0) {
              errorExpense.setText("không được để trống!");
              errorExpense.setForeground(Color.red);
              isValid = false;
            } else {
             isValid =true;
            }
         }
     }
     );
     
     
     
    
 }
  private Image resizeImg(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            throw new IllegalArgumentException("Failed to load image from path: " + filePath);
        }
        return icon.getImage().getScaledInstance(280, 300, Image.SCALE_SMOOTH);
    }
    public void setImagePreView(String filePath) {
         
       if (filePath == null || filePath.isEmpty()) {
           
        }
        Image img = resizeImg(filePath);
        ImageIcon icon = new ImageIcon(img);
        // Ensuring the UI update is done on the Event Dispatch Thread
      this.previewImgae.setIcon(icon);
    
    }
 private void submit() {
     buttonSubmit.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             if(isValid) {
                 Tour tour = new Tour();
                 String valueInputPrice = inputQuantity.getText();
                 String valueInputExpense = inpuExpense.getText();
                 double price_one_person = Double.parseDouble(valueInputPrice);
                 double expense = Double.parseDouble(valueInputExpense);
                 tour.setAddress(iinputAddress.getText());
                 tour.setDestination_description(inputDescription.getText());
                 tour.setTitle(inputName.getText());
                 tour.setTime_book_end(dEnd);
                 tour.setTime_book_start(dStart);
                 tour.setPrice_one_person(price_one_person);
                 tour.setExpense(expense);
                 tour.setImgUrl(nameImage);
                 tour.setQuantity(Integer.parseInt(inputQuantity.getText()));
                 MessageDAL state  = qLTourBUS.createNewTour(tour);
                 if(state.getStatus()) {
                   JOptionPane.showMessageDialog(null, state.getMessage(),"thông báo", JOptionPane.INFORMATION_MESSAGE);
                  
                     dispose();
                 
                 } else {
                 JOptionPane.showMessageDialog(null, state.Message, "Error", JOptionPane.ERROR_MESSAGE);
                 }
                 
                         
             } else {
                 JOptionPane.showMessageDialog(null, "thông tin nhập không hợp lệ!","thông báo", JOptionPane.ERROR_MESSAGE);
             }
             
             
         }
     });
 
 }
 private void addEventButtonCancel(){
   this.buttonCancel.addActionListener(new ActionListener(){
   
       @Override
       public void actionPerformed(ActionEvent e) {
             int result = JOptionPane.showConfirmDialog(null, "bạn muốn hủy thao tác", "thông báo", JOptionPane.YES_NO_OPTION);
            if(result ==JOptionPane.OK_OPTION) {
                SwingUtilities.getWindowAncestor(jPanel1).dispose();
            }
            
       }
   });
 }
 private  void addEventButtonChangeImage() {
       this.buttonChangeImage.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JFileChooser fileChooser = new JFileChooser();
             fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
             int result = fileChooser.showOpenDialog(null);
             if(result == JFileChooser.APPROVE_OPTION) {
               File file = fileChooser.getSelectedFile();
                File directory = new File(App.globalPathApp +"\\Store_img");
                 if (!directory.exists()) {
                directory.mkdirs(); 
            }
                   File destinationFile = new File(directory,file.getName());
                  try {
                      Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                 } catch (IOException ex) {
                      System.out.println("lỗi thêm file" + ex.getMessage());
                 }
                BufferedImage image;
                try {
                    image =ImageIO.read(file);
                    Image img = image.getScaledInstance(280, 300, Image.SCALE_SMOOTH);
                    previewImgae.setIcon(new ImageIcon(img));
                 }
                catch(IOException exception) {
                    System.out.println("lỗi đọc file ảnh");
                }
                nameImage  =  file.getName();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inpuExpense = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        inputQuantity = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        inputDescription = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        iinputAddress = new javax.swing.JTextField();
        errorExpense = new javax.swing.JLabel();
        dateEnd = new GUI.components.DateChooser();
        jLabel9 = new javax.swing.JLabel();
        dateStart = new GUI.components.DateChooser();
        jLabel10 = new javax.swing.JLabel();
        errorMessageName = new javax.swing.JLabel();
        errorMessageAddress = new javax.swing.JLabel();
        errorQuantity = new javax.swing.JLabel();
        errorDesciption = new javax.swing.JLabel();
        errorMessageDate = new javax.swing.JLabel();
        inputPrice_on_one_persion1 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        errorPrice1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        previewImgae = new javax.swing.JLabel();
        buttonChangeImage = new GUI.components.ButtonRadius();
        buttonCancel = new GUI.components.ButtonRadius();
        buttonSubmit = new GUI.components.ButtonRadius();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel2.setText("chi phí thực hiện");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 160, 35));

        inpuExpense.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        inpuExpense.setForeground(new java.awt.Color(153, 153, 153));
        inpuExpense.setText("100 ~ 100.000 đ");
        inpuExpense.setBorder(null);
        inpuExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpuExpenseActionPerformed(evt);
            }
        });
        jPanel2.add(inpuExpense, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 301, 32));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 330, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel3.setText("Thông tin Tour du lịch");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 210, 35));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 330, 10));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel4.setText("Địa chỉ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 70, 35));

        inputName.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        inputName.setForeground(new java.awt.Color(153, 153, 153));
        inputName.setBorder(null);
        inputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameActionPerformed(evt);
            }
        });
        jPanel2.add(inputName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 301, 32));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, 330, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel5.setText("số lượng ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 80, 35));

        inputQuantity.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        inputQuantity.setForeground(new java.awt.Color(153, 153, 153));
        inputQuantity.setBorder(null);
        inputQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputQuantityActionPerformed(evt);
            }
        });
        jPanel2.add(inputQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 330, 40));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 330, 10));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel6.setText("mô tả Tour du lịch");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 160, 35));

        inputDescription.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        inputDescription.setForeground(new java.awt.Color(153, 153, 153));
        inputDescription.setBorder(null);
        inputDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDescriptionActionPerformed(evt);
            }
        });
        jPanel2.add(inputDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 330, 40));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 330, 10));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel7.setText("Ngày kết thúc");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 120, 35));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 330, 20));

        iinputAddress.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        iinputAddress.setForeground(new java.awt.Color(153, 153, 153));
        iinputAddress.setBorder(null);
        iinputAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iinputAddressActionPerformed(evt);
            }
        });
        jPanel2.add(iinputAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 320, 32));

        errorExpense.setBackground(new java.awt.Color(255, 255, 255));
        errorExpense.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jPanel2.add(errorExpense, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 170, 30));

        dateEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateEndPropertyChange(evt);
            }
        });
        jPanel2.add(dateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 150, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel9.setText("Ngày bắt đầu");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 120, 35));

        dateStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateStartPropertyChange(evt);
            }
        });
        jPanel2.add(dateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 150, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel10.setText("Tên Tour");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, 35));

        errorMessageName.setBackground(new java.awt.Color(255, 255, 255));
        errorMessageName.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jPanel2.add(errorMessageName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 240, 30));

        errorMessageAddress.setBackground(new java.awt.Color(255, 255, 255));
        errorMessageAddress.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jPanel2.add(errorMessageAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 240, 30));

        errorQuantity.setBackground(new java.awt.Color(255, 255, 255));
        errorQuantity.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jPanel2.add(errorQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 250, 30));

        errorDesciption.setBackground(new java.awt.Color(255, 255, 255));
        errorDesciption.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jPanel2.add(errorDesciption, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 160, 30));

        errorMessageDate.setBackground(new java.awt.Color(255, 255, 255));
        errorMessageDate.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jPanel2.add(errorMessageDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 340, 30));

        inputPrice_on_one_persion1.setFont(new java.awt.Font("JetBrains Mono NL Medium", 0, 14)); // NOI18N
        inputPrice_on_one_persion1.setForeground(new java.awt.Color(153, 153, 153));
        inputPrice_on_one_persion1.setText("100 ~ 100.000 đ");
        inputPrice_on_one_persion1.setBorder(null);
        inputPrice_on_one_persion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPrice_on_one_persion1ActionPerformed(evt);
            }
        });
        jPanel2.add(inputPrice_on_one_persion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 330, 40));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 285, 330, 10));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        jLabel8.setText("Giá tiền");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, 35));

        errorPrice1.setBackground(new java.awt.Color(255, 255, 255));
        errorPrice1.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jPanel2.add(errorPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 230, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 390, 680));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(previewImgae, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 300));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 280, 300));

        buttonChangeImage.setBackground(new java.awt.Color(206, 9, 103));
        buttonChangeImage.setForeground(new java.awt.Color(255, 255, 255));
        buttonChangeImage.setText("Thay đổi hình ảnh");
        buttonChangeImage.setToolTipText("");
        buttonChangeImage.setBorderColor(new java.awt.Color(0, 0, 0));
        buttonChangeImage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonChangeImage.setRadius(20);
        jPanel1.add(buttonChangeImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 150, 30));

        buttonCancel.setBackground(new java.awt.Color(195, 215, 255));
        buttonCancel.setText("Hủy Thao tác");
        buttonCancel.setBorderColor(new java.awt.Color(0, 0, 0));
        buttonCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonCancel.setRadius(20);
        jPanel1.add(buttonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 120, 30));

        buttonSubmit.setBackground(new java.awt.Color(255, 147, 98));
        buttonSubmit.setText("Thêm Tour");
        buttonSubmit.setBorderColor(new java.awt.Color(0, 0, 0));
        buttonSubmit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonSubmit.setRadius(20);
        jPanel1.add(buttonSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inpuExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpuExpenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpuExpenseActionPerformed

    private void inputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameActionPerformed

    private void inputQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputQuantityActionPerformed

    private void inputDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDescriptionActionPerformed

    private void iinputAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iinputAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iinputAddressActionPerformed

    private void dateStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateStartPropertyChange
      java.util.Date d = dateStart.getDate();
if (d == null) {
   errorMessageDate.setText("ngày không hợp lệ");
    errorMessageDate.setForeground(Color.red);
} else {
    java.sql.Date sqldate = new java.sql.Date(d.getTime());
    this.dStart = sqldate;
      isValid = true;
}
    }//GEN-LAST:event_dateStartPropertyChange

    private void dateEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateEndPropertyChange
      java.util.Date d = dateStart.getDate();
if (d == null) {
   errorMessageDate.setText("không được bỏ trông");
   errorMessageDate.setForeground(Color.red);
} else {
    java.sql.Date sqldate = new java.sql.Date(d.getTime());
    this.dEnd = sqldate;
     isValid = true;
      long diffMillis = dateEnd.getDate().getTime() - dateStart.getDate().getTime();


long diffDays = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
    if(diffDays <0){
          isValid =false;
           errorMessageDate.setText("lỗi ngày kết thúc!");
            errorMessageDate.setForeground(Color.red);
    } else{
     errorMessageDate.setText("");
    }
}
 
    
    }//GEN-LAST:event_dateEndPropertyChange

    private void inputPrice_on_one_persion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPrice_on_one_persion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPrice_on_one_persion1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.components.ButtonRadius buttonCancel;
    private GUI.components.ButtonRadius buttonChangeImage;
    private GUI.components.ButtonRadius buttonSubmit;
    private GUI.components.DateChooser dateEnd;
    private GUI.components.DateChooser dateStart;
    private javax.swing.JLabel errorDesciption;
    private javax.swing.JLabel errorExpense;
    private javax.swing.JLabel errorMessageAddress;
    private javax.swing.JLabel errorMessageDate;
    private javax.swing.JLabel errorMessageName;
    private javax.swing.JLabel errorPrice1;
    private javax.swing.JLabel errorQuantity;
    private javax.swing.JTextField iinputAddress;
    private javax.swing.JTextField inpuExpense;
    private javax.swing.JTextField inputDescription;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputPrice_on_one_persion1;
    private javax.swing.JTextField inputQuantity;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel previewImgae;
    // End of variables declaration//GEN-END:variables
}

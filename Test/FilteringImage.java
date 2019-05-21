package Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.RadioButton;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import static javax.swing.SwingConstants.BOTTOM;
public class FilteringImage extends javax.swing.JFrame{
    private static final String path="src/mergeJson/merged_file_TEST.json";
    Connect conn = new Connect();
    public String[] getImage() {
        //set image from as file name
        File file=new File(getClass().getResource("/resizedImage/").getFile());
        String[]imageList=file.list();    
        return imageList;
    }
        // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "png", "jpeg" // and other formats you need
    };
    public String selectedImageName(int index){
        //get image by index
        String[] imageList=getImage();
        String imageName=null;
        for(String name:imageList){
            imageName=imageList[index];
        }
        return imageName;
    }
    public int selectedImageIndex(String name){
        //get index by image name
        String[] imageList=getImage();
        int index=0;    
        for(int i=0;i<imageList.length;i++){
            while(imageList[i].equals(name)){
                return index;    
            }
            index++;  
            } 
        return 0;
    }
    public void ShowImage(int index,JLabel name) {
        // tHİS METHOD SHOWS THE İMAGES GİVEN 
        String[] imageList=getImage();    
        String imageName=imageList[index];
        ImageIcon icon=new ImageIcon(getClass().getResource("/resizedImage/"+imageName));
        Image image=icon.getImage().getScaledInstance(name.getWidth(),name.getHeight(), Image.SCALE_SMOOTH);
        name.setIcon(new ImageIcon(image));
        }
    Component[] comp;
    JLabel label1;
    List<JsonModel> jsonModelList;
    ArrayList<JsonModel> resultFilter;
    JRadioButton radio;
    int minAge;
    int maxAge;
    String[] imageName;
    public FilteringImage() {
        initComponents();
        
        //initialize part
         MaleRadioButton.setName("male");
         FemaleRadioButton.setName("female");
        ImagePanel.setVisible(false);
        
        try{
              Gson gson = new Gson();
              java.lang.reflect.Type jsonModelListType = new TypeToken<ArrayList<JsonModel>>(){}.getType();
              jsonModelList = gson.fromJson(new FileReader(path),jsonModelListType);
              resultFilter = new ArrayList<>();
              for(int i=0;i<jsonModelList.size();i++){
              resultFilter.add(jsonModelList.get(i));
            }               
        }catch(FileNotFoundException ex){
              ex.printStackTrace();
        } 
        getImagePanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        for (int i = 0; i < resultFilter.size(); i++) {
            //get name for labels and add label into panel
            label1=new JLabel(selectedImageName(i));
            label1.setSize(100, 100);
         getImagePanel.add(label1);
        }
        //comp array to add into panel
        comp=getImagePanel.getComponents();
         for(int i=0;i<comp.length;i++){
             comp[i].setName(selectedImageName(i));
             //each label 
             comp[i].addMouseListener(new MouseAdapter(){
                 public void mouseClicked(MouseEvent e){
                     DisplayingInformation frame2=new DisplayingInformation();
                    FilteringImage.this.setVisible(false);
                     frame2.setVisible(true);
                            frame2.setTitle(selectedImageName(selectedImageIndex(e.getComponent().getName())));
                            frame2.resizedShowImage(selectedImageIndex(e.getComponent().getName()),frame2.resizedImage1);
                            frame2.SegmentationShowImage(selectedImageIndex(e.getComponent().getName()), frame2.segmentationImage);
                            for(int i=0;i<resultFilter.size();i++){
                                while(e.getComponent().getName().equals(resultFilter.get(i).getName()+".jpeg")){
                                    frame2.jTextArea1.setText(resultFilter.get(selectedImageIndex(e.getComponent().getName())).getMeta().toStringClinical()+"\n DataSet : \n"+resultFilter.get(selectedImageIndex(e.getComponent().getName())).getDataset().toStringDataSet());
                                    break;
                                }
                            }   
                 }
             });     
         }
         for(int i=0;i<comp.length;i++){
             if(comp[i] instanceof JLabel){
                 JLabel lbl=(JLabel)getImagePanel.getComponent(i);
                 ShowImage(i, lbl);
             }
         }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FilterPanel = new javax.swing.JPanel();
        FilterButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MaleRadioButton = new javax.swing.JRadioButton();
        FemaleRadioButton = new javax.swing.JRadioButton();
        minText = new javax.swing.JTextField();
        maxText = new javax.swing.JTextField();
        FilterLabel = new javax.swing.JLabel();
        FindImagePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FindNameText = new javax.swing.JTextField();
        FindByNameButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        getImagePanel = new javax.swing.JPanel();
        ImagePanel = new javax.swing.JPanel();
        AllImageText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        FilterImages = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MELANOMA");

        FilterButton.setText("Find");
        FilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255), 3));

        jLabel2.setText("Age :");

        jLabel3.setText("to");

        jLabel4.setText("Sex :");

        MaleRadioButton.setText("Male");

        FemaleRadioButton.setText("Female");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FemaleRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(MaleRadioButton)
                    .addComponent(FemaleRadioButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        MaleRadioButton.getAccessibleContext().setAccessibleName("male");

        FilterLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 14)); // NOI18N
        FilterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FilterLabel.setText("Filter");
        FilterLabel.setToolTipText("");
        FilterLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        FilterLabel.setAlignmentX(10.0F);
        FilterLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 3));

        javax.swing.GroupLayout FilterPanelLayout = new javax.swing.GroupLayout(FilterPanel);
        FilterPanel.setLayout(FilterPanelLayout);
        FilterPanelLayout.setHorizontalGroup(
            FilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilterPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(FilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FilterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        FilterPanelLayout.setVerticalGroup(
            FilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilterPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FilterLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FilterButton)
                .addGap(6, 6, 6))
        );

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel1.setText("FindByImage Name :");

        FindNameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FindNameTextKeyPressed(evt);
            }
        });

        FindByNameButton.setText("Find");
        FindByNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindByNameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FindImagePanelLayout = new javax.swing.GroupLayout(FindImagePanel);
        FindImagePanel.setLayout(FindImagePanelLayout);
        FindImagePanelLayout.setHorizontalGroup(
            FindImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FindImagePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FindNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FindByNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        FindImagePanelLayout.setVerticalGroup(
            FindImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FindImagePanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(FindImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FindNameText)
                    .addComponent(FindByNameButton))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("----Melanoma Project----");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout getImagePanelLayout = new javax.swing.GroupLayout(getImagePanel);
        getImagePanel.setLayout(getImagePanelLayout);
        getImagePanelLayout.setHorizontalGroup(
            getImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        getImagePanelLayout.setVerticalGroup(
            getImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(getImagePanel);

        ImagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));

        javax.swing.GroupLayout ImagePanelLayout = new javax.swing.GroupLayout(ImagePanel);
        ImagePanel.setLayout(ImagePanelLayout);
        ImagePanelLayout.setHorizontalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        ImagePanelLayout.setVerticalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        AllImageText.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        AllImageText.setForeground(new java.awt.Color(255, 0, 0));
        AllImageText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AllImageText.setText("----ALL IMAGES----");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout FilterImagesLayout = new javax.swing.GroupLayout(FilterImages);
        FilterImages.setLayout(FilterImagesLayout);
        FilterImagesLayout.setHorizontalGroup(
            FilterImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        FilterImagesLayout.setVerticalGroup(
            FilterImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(FilterImages);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("----Filter Images----");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AllImageText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(FilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FindImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FindImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AllImageText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void FindByNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindByNameButtonActionPerformed
        try{
             Gson gson = new Gson();
            java.lang.reflect.Type jsonModelListType = new TypeToken<ArrayList<JsonModel>>(){}.getType();
            List<JsonModel> jsonModelList = gson.fromJson(new FileReader(path),jsonModelListType);
            resultFilter = new ArrayList<JsonModel>();
            ImagePanel.setVisible(true);
            for(int i=0;i<jsonModelList.size();i++){
              resultFilter.add(jsonModelList.get(i));
                if(FindNameText.getText().equals(resultFilter.get(i).getName()+".jpeg")){
                        label1=new JLabel(FindNameText.getText());
                        label1.setSize(100, 100);
                        ImagePanel.add(label1);
                }  
            }
             comp=ImagePanel.getComponents();
               for(int i=0;i<comp.length;i++){
                   comp[i].setName(FindNameText.getText());
                   if(comp[i] instanceof JLabel){
                       JLabel label=(JLabel) ImagePanel.getComponent(i);
                       ShowImage(selectedImageIndex(label.getName()),label);
                       comp[i].addMouseListener(new MouseAdapter(){
                 public void mouseClicked(MouseEvent e){
                     DisplayingInformation frame2=new DisplayingInformation();
                    FilteringImage.this.setVisible(false);
                     frame2.setVisible(true);
                            frame2.setTitle(selectedImageName(selectedImageIndex(e.getComponent().getName())));
                            frame2.resizedShowImage(selectedImageIndex(e.getComponent().getName()),frame2.resizedImage1);
                            frame2.SegmentationShowImage(selectedImageIndex(e.getComponent().getName()), frame2.segmentationImage);
                            for(int i=0;i<resultFilter.size();i++){
                                while(e.getComponent().getName().equals(resultFilter.get(i).getName()+".jpeg")){
                                    frame2.jTextArea1.setText(resultFilter.get(selectedImageIndex(e.getComponent().getName())).getMeta().toStringClinical()+"\n DataSet : \n"+resultFilter.get(selectedImageIndex(e.getComponent().getName())).getDataset().toStringDataSet());
                                    break;
                                }
                            }   
                 }
             });     
                   }
               }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_FindByNameButtonActionPerformed

    private void FindNameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FindNameTextKeyPressed
//NOT TO ANYTHİNG
    }//GEN-LAST:event_FindNameTextKeyPressed

    private void FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterButtonActionPerformed
        try{
           Gson gson=new Gson();
           java.lang.reflect.Type jsonModelListType=new TypeToken<ArrayList<JsonModel>>(){}.getType();
           List<JsonModel> jsonModel=gson.fromJson(new FileReader(path), jsonModelListType);
           resultFilter=new ArrayList<>();
           ArrayList<JsonModel>res=new ArrayList<>();
            FilterImages.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
           for (int i = 0; i < jsonModel.size(); i++) {
               resultFilter.add(jsonModel.get(i));
              if(minText.getText().equals("")&&maxText.getText().equals("")){
               if((MaleRadioButton.isSelected()==true)){  
                   //when button is selected ,button name match with resultfilter getSex() metod gives us value
                        if(MaleRadioButton.getName().equals(resultFilter.get(i).getMeta().getClinical().getSex())){
                            label1=new JLabel(resultFilter.get(i).getName());
                            label1.setSize(100,100);
                            FilterImages.add(label1);
                            System.out.println(resultFilter.get(i).getMeta().toStringClinical()+"\nImage Name : "+resultFilter.get(i).getName()+"\n");
                        }
               }
               else if(FemaleRadioButton.isSelected()==true){
                   if(FemaleRadioButton.getName().equals(resultFilter.get(i).getMeta().getClinical().getSex())){
                            label1=new JLabel(resultFilter.get(i).getName());
                            label1.setSize(100,100);
                            FilterImages.add(label1);
                            System.out.println(resultFilter.get(i).getMeta().toStringClinical()+"\nImage Name : "+resultFilter.get(i).getName()+"\n");

                   }
               }
               else if(MaleRadioButton.isSelected()==true&&FemaleRadioButton.isSelected()==true){
                    JOptionPane.showMessageDialog(FilteringImage.this,
                    "Please select only one radiobutton");
               }
               else{
                   JOptionPane.showMessageDialog(FilteringImage.this,
                    "Please select only one radiobutton");
                   break;
               }
           }
              if((!minText.getText().equals(""))&&(!maxText.getText().equals(""))){
               minAge=Integer.parseInt(minText.getText());
               maxAge=Integer.parseInt(maxText.getText());
                   /* if(resultFilter.get(i).getMeta().getClinical().getAge_approx()>=minAge&&resultFilter.get(i).getMeta().getClinical().getAge_approx()<=maxAge){
                            label1=new JLabel(resultFilter.get(i).getName());
                            label1.setSize(100,100);
                            FilterImages.add(label1);
                    }*/
                     if((resultFilter.get(i).getMeta().getClinical().getAge_approx()>=minAge&&resultFilter.get(i).getMeta().getClinical().getAge_approx()<=maxAge &&MaleRadioButton.isSelected()==true&&MaleRadioButton.getName().equals(resultFilter.get(i).getMeta().getClinical().getSex()))){
                       label1=new JLabel(resultFilter.get(i).getName());
                       label1.setSize(100,100);
                       FilterImages.add(label1);
                      System.out.println(resultFilter.get(i).getMeta().toStringClinical()+"\nImage Name : "+resultFilter.get(i).getName()+"\n");

                    }
                    else if((resultFilter.get(i).getMeta().getClinical().getAge_approx()>=minAge&&resultFilter.get(i).getMeta().getClinical().getAge_approx()<=maxAge &&FemaleRadioButton.isSelected()==true&&FemaleRadioButton.getName().equals(resultFilter.get(i).getMeta().getClinical().getSex()))){
                            label1=new JLabel(resultFilter.get(i).getName());
                            label1.setSize(100,100);
                            FilterImages.add(label1);
                            System.out.println(resultFilter.get(i).getMeta().toStringClinical()+"\nImage Name : "+resultFilter.get(i).getName()+"\n");
               } 
           }
        }
           //gets all components into from filterImages Panel
                     comp=FilterImages.getComponents();
                        for(int i=0;i<comp.length;i++){
                comp[i].setName(resultFilter.get(i).getName()+".jpeg");      
                if(comp[i] instanceof JLabel){
                       JLabel label=(JLabel) FilterImages.getComponent(i);
                       ShowImage(selectedImageIndex(label.getName()),label);
                       comp[i].addMouseListener(new MouseAdapter(){
                 public void mouseClicked(MouseEvent e){
                     //mouse event create
                     DisplayingInformation frame2=new DisplayingInformation();
                    FilteringImage.this.setVisible(false);
                     frame2.setVisible(true);
                            frame2.setTitle(selectedImageName(selectedImageIndex(e.getComponent().getName())));
                            frame2.resizedShowImage(selectedImageIndex(e.getComponent().getName()),frame2.resizedImage1);
                            frame2.SegmentationShowImage(selectedImageIndex(e.getComponent().getName()), frame2.segmentationImage);
                            for(int i=0;i<resultFilter.size();i++){
                                if(e.getComponent().getName().equals(resultFilter.get(i).getName()+".jpeg")){
                                    frame2.jTextArea1.setText(resultFilter.get(selectedImageIndex(e.getComponent().getName())).getMeta().toStringClinical()+"\n DataSet : \n"+resultFilter.get(selectedImageIndex(e.getComponent().getName())).getDataset().toStringDataSet());
                                    break;
                                }
                            }   
                 }
             });     
                   }
                         }
           }
         catch(IOException ex){
           ex.printStackTrace();
       }
    }//GEN-LAST:event_FilterButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FilteringImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilteringImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilteringImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilteringImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FilteringImage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AllImageText;
    private javax.swing.JRadioButton FemaleRadioButton;
    private javax.swing.JButton FilterButton;
    private javax.swing.JPanel FilterImages;
    private javax.swing.JLabel FilterLabel;
    private javax.swing.JPanel FilterPanel;
    private javax.swing.JButton FindByNameButton;
    private javax.swing.JPanel FindImagePanel;
    private javax.swing.JTextField FindNameText;
    private javax.swing.JPanel ImagePanel;
    private javax.swing.JRadioButton MaleRadioButton;
    private javax.swing.JPanel getImagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField maxText;
    private javax.swing.JTextField minText;
    // End of variables declaration//GEN-END:variables

     
}

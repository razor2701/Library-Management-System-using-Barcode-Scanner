package gui;


import controller.IconSetter;
import com.jtattoo.plaf.aero.AeroDefaultTheme;
import com.jtattoo.plaf.hifi.HiFiDefaultTheme;
import com.jtattoo.plaf.noire.NoireDefaultTheme;
import com.toedter.plaf.JCalendarTheme;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Necil Dabre, Preet Dabre, Glen Dabre, Chris Carvalho
 */
public class AdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminFrame
     */
    public void changeTheme(){
        String defaulttheme = "";
            File configfile = new File("config.properties");
            FileInputStream fis = null;
            Properties config = new Properties();
        try {
            fis = new FileInputStream(configfile);
            config.load(fis);
             defaulttheme = config.getProperty("defaulttheme");
             System.out.println("Read from file "+defaulttheme);
        } catch (Exception e) {
        }
        if(defaulttheme.equals("false")){
             try {
                    //MetalLookAndFeel.setCurrentTheme(new HiFiDefaultTheme());
                    MetalLookAndFeel.setCurrentTheme(new NoireDefaultTheme());
                    UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(this);
                    this.pack();
                        config.setProperty("defaulttheme", "true");
                          System.out.println("Set property to "+config.getProperty("defaulttheme"));
                        config.store(new FileOutputStream(configfile), "Program Setting ");
                    
                    fis.close();
                } catch (Exception e) {
                    System.err.printf(""+e);
                }
        }
        else{ 
                try {
                    MetalLookAndFeel.setCurrentTheme(new AeroDefaultTheme());
                    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                   /* setDefaultLookAndFeelDecorated(true);
                    setUndecorated(false);*/
                    SwingUtilities.updateComponentTreeUI(this);
                    this.pack();
                        config.setProperty("defaulttheme", "false");
                          System.out.println("Set property to "+config.getProperty("defaulttheme"));
                        config.store(new FileOutputStream(configfile), "Program Setting ");
                   
                    
                    fis.close();
                } catch (Exception e) {
                    System.out.println(""+e);
                }
            
        }
    }
    public void setTheme(boolean change){
        
             String defaulttheme = "";
             System.out.println("New try with hange "+change);
            File configfile = new File("config.properties");
            FileInputStream fis = null;
            Properties config = new Properties();
        try {
            fis = new FileInputStream(configfile);
            config.load(fis);
             defaulttheme = config.getProperty("defaulttheme");
             System.out.println("Read from file "+defaulttheme);
        } catch (Exception e) {
        }
        if(defaulttheme.equals("true")){
             try {
                    MetalLookAndFeel.setCurrentTheme(new NoireDefaultTheme());
                    UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(this);
                    this.pack();
                    if(change){
                        config.setProperty("defaulttheme", "false");
                          System.out.println("Set property to "+config.getProperty("defaulttheme"));
                        config.store(new FileOutputStream(configfile), "Program Setting ");
                    }
                    fis.close();
                } catch (Exception e) {
                    System.err.printf(""+e);
                }
        }
        else{ 
                try {
                    MetalLookAndFeel.setCurrentTheme(new AeroDefaultTheme());
                    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                   /* setDefaultLookAndFeelDecorated(true);
                    setUndecorated(false);*/
                    SwingUtilities.updateComponentTreeUI(this);
                    this.pack();
                    if(change){
                        config.setProperty("defaulttheme", "true");
                          System.out.println("Set property to "+config.getProperty("defaulttheme"));
                        config.store(new FileOutputStream(configfile), "Program Setting ");
                    }
                    
                    fis.close();
                } catch (Exception e) {
                    System.out.println(""+e);
                }
            
        }
    }
    public AdminFrame() {
        initComponents();
        IconSetter.setIcon(this);
        setTheme(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        bookDetails = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        generateReport = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        memberDetails = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        borrowBooks = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        shortHandToolBar = new javax.swing.JToolBar();
        bksrtbtn = new javax.swing.JButton();
        memsrtbtn = new javax.swing.JButton();
        excsrtbtn = new javax.swing.JButton();
        reportsrtbtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        changeTheme = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin - Library Management System");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setForeground(new java.awt.Color(240, 240, 240));

        bookDetails.setText("Book Details");
        bookDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookDetailsActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bookdetails128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bookDetails)
                .addContainerGap())
        );

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        generateReport.setText("Generate Report");
        generateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(generateReport)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generateReport)
                .addGap(18, 18, 18))
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        memberDetails.setText("Member Details");
        memberDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberDetailsActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/manageuser128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(memberDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(memberDetails)
                .addGap(18, 18, 18))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        borrowBooks.setText("Borrow Books");
        borrowBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowBooksActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exchange128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(borrowBooks))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(borrowBooks)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        shortHandToolBar.setRollover(true);

        bksrtbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bookdetails32.png"))); // NOI18N
        bksrtbtn.setFocusable(false);
        bksrtbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bksrtbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bksrtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bksrtbtnActionPerformed(evt);
            }
        });
        shortHandToolBar.add(bksrtbtn);

        memsrtbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/members32.png"))); // NOI18N
        memsrtbtn.setFocusable(false);
        memsrtbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        memsrtbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        memsrtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memsrtbtnActionPerformed(evt);
            }
        });
        shortHandToolBar.add(memsrtbtn);

        excsrtbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exchange32.png"))); // NOI18N
        excsrtbtn.setFocusable(false);
        excsrtbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excsrtbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excsrtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excsrtbtnActionPerformed(evt);
            }
        });
        shortHandToolBar.add(excsrtbtn);

        reportsrtbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report32.png"))); // NOI18N
        reportsrtbtn.setFocusable(false);
        reportsrtbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportsrtbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reportsrtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsrtbtnActionPerformed(evt);
            }
        });
        shortHandToolBar.add(reportsrtbtn);

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        logoutBtn.setFocusable(false);
        logoutBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        shortHandToolBar.add(logoutBtn);

        changeTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eye32.png"))); // NOI18N
        changeTheme.setFocusable(false);
        changeTheme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        changeTheme.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        changeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeThemeActionPerformed(evt);
            }
        });
        shortHandToolBar.add(changeTheme);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Library Management Sytem");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Admin Console");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shortHandToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(shortHandToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bookDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookDetailsActionPerformed
        // TODO add your handling code here:
        
        new BookFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_bookDetailsActionPerformed

    private void memberDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberDetailsActionPerformed
        // TODO add your handling code here:
        new MemberUserFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_memberDetailsActionPerformed

    private void borrowBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowBooksActionPerformed
        // TODO add your handling code here:
        new BorrowBookFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_borrowBooksActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void bksrtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bksrtbtnActionPerformed
        // TODO add your handling code here:
        new BookFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_bksrtbtnActionPerformed

    private void memsrtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memsrtbtnActionPerformed
        // TODO add your handling code here:
        new MemberUserFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_memsrtbtnActionPerformed

    private void excsrtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excsrtbtnActionPerformed
        // TODO add your handling code here:
        new BorrowBookFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_excsrtbtnActionPerformed

    private void generateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportActionPerformed
        // TODO add your handling code here:
        new ReportFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_generateReportActionPerformed

    private void reportsrtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsrtbtnActionPerformed
        // TODO add your handling code here:
         new ReportFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_reportsrtbtnActionPerformed

    private void changeThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeThemeActionPerformed
        // TODO add your handling code here:
        changeTheme();
    }//GEN-LAST:event_changeThemeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bksrtbtn;
    private javax.swing.JButton bookDetails;
    private javax.swing.JButton borrowBooks;
    private javax.swing.JButton changeTheme;
    private javax.swing.JButton excsrtbtn;
    private javax.swing.JButton generateReport;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton memberDetails;
    private javax.swing.JButton memsrtbtn;
    private javax.swing.JButton reportsrtbtn;
    private javax.swing.JToolBar shortHandToolBar;
    // End of variables declaration//GEN-END:variables
}

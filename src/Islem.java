/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author canerkoskos
 */
public class Islem extends javax.swing.JFrame {
    int h;
    /**
     * Creates new form Islem
     */
    public Islem() {
        initComponents();
    }
    public Islem(int hno) {
        initComponents();
        this.h=hno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        paracekme = new javax.swing.JButton();
        parayatırma = new javax.swing.JButton();
        sifredegistirme = new javax.swing.JButton();
        bakiyeogrenme = new javax.swing.JButton();
        paratransferi = new javax.swing.JButton();
        faturaodeme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Yapmak istediğiniz işlemi seçiniz");

        paracekme.setText("Para çekme");
        paracekme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paracekmeActionPerformed(evt);
            }
        });

        parayatırma.setText("Para yatırma ");
        parayatırma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parayatırmaActionPerformed(evt);
            }
        });

        sifredegistirme.setText("Şifre değiştirme");
        sifredegistirme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sifredegistirmeActionPerformed(evt);
            }
        });

        bakiyeogrenme.setText("Bakiye öğrenme");
        bakiyeogrenme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bakiyeogrenmeActionPerformed(evt);
            }
        });

        paratransferi.setText("Para transferi");
        paratransferi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paratransferiActionPerformed(evt);
            }
        });

        faturaodeme.setText("Fatura ödeme");
        faturaodeme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faturaodemeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bakiyeogrenme, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(paracekme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parayatırma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(faturaodeme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paratransferi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sifredegistirme, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paratransferi, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(bakiyeogrenme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faturaodeme, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paracekme, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sifredegistirme, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(parayatırma, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void paracekmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paracekmeActionPerformed
        // TODO add your handling code here:
        new Paracekme(h).setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_paracekmeActionPerformed

    private void bakiyeogrenmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bakiyeogrenmeActionPerformed
        // TODO add your handling code here:
        new Bakiyeogrenme(h).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bakiyeogrenmeActionPerformed

    private void parayatırmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parayatırmaActionPerformed
        // TODO add your handling code here:
        new Parayatırma(h).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_parayatırmaActionPerformed

    private void paratransferiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paratransferiActionPerformed
        // TODO add your handling code here:
        new Paratransferi(h).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_paratransferiActionPerformed

    private void faturaodemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faturaodemeActionPerformed
        // TODO add your handling code here:
        new Faturaodeme(h).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_faturaodemeActionPerformed

    private void sifredegistirmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sifredegistirmeActionPerformed
        // TODO add your handling code here:
        new Sifredegistirme(h,1).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sifredegistirmeActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Islem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Islem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Islem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Islem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Islem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bakiyeogrenme;
    private javax.swing.JButton faturaodeme;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton paracekme;
    private javax.swing.JButton paratransferi;
    private javax.swing.JButton parayatırma;
    private javax.swing.JButton sifredegistirme;
    // End of variables declaration//GEN-END:variables
}

/*
 */
package view;

/**
 *
 * @author aluno02
 */
public class inst extends javax.swing.JFrame {

    static int etapa = 1;
    String inst1 = "<html><p style=\"font-size:24px; color:white; text-align:justify\">Bem-vindo ao remake do jogo <i>Show do Milhão</i> de Mega Drive! Antes de começar a jogar, lembre-se de instalar o MySQL em seu dispositivo e de executar o script SQL perguntas.sql, que pode ser encontrado na pasta de instalação do jogo ou junto com o instalador. " +
"Este script é responsável por criar a base de dados que contém as perguntas do jogo! Por padrão, ele cria 100 perguntas (30 fáceis, 30 médias, 30 difíceis e 10 expert!).<br><br>Clique em próximo para continuar.</p></html>";
    
    String inst2 = "<html><p style=\"font-size:24px; color:white; text-align:justify\">O objetivo deste jogo é transmitir as emoções do programa <i>Show do Milhão</i> para o seu dispositivo, onde os prêmios são fictícios e meramente ilustrativos, não existindo de forma alguma real premiação ou gratificação aos jogadores.<br><br>Clique em próximo para continuar.</p></html>";
    
    String inst3 = "<html><p style=\"font-size:24px; color:white; text-align:justify\">Regras:<br><br>1 - Cada pergunta tem um tempo de 40 segundos para ser respondida e quatro opções de resposta. Apenas uma é correta.<br><br>2 - As perguntas têm quatro níveis de dificuldade: Fácil (1ª a 5ª pergunta), médio (6ª a 10ª pergunta), difícil (11ª a 15ª pergunta) e expert (16ª pergunta, valendo R$1.000.000,00).<br><br>Clique em próximo para continuar.</p></html>";
    
    String inst4 = "<html><p style=\"font-size:24px; color:white; text-align:justify\">3 - Ao parar, você ganha o prêmio atual. Ao acertar, aumenta seu dinheiro e passa para a próxima pergunta. Ao errar ou o tempo acabar, perde metade do seu dinheiro. <b style='color:red'>Se você estiver na última pergunta e errar ou o tempo acabar, você perde todo seu dinheiro.</b><br><br>4 - Você pode pular até 3 questões no jogo.<br><br>Clique em próximo para continuar.</p></html>";
    
    String inst5 = "<html><p style=\"font-size:24px; color:white; text-align:justify\">5 - Você pode pedir ajuda as cartas uma vez. Ao pedir ajuda às cartas, você terá de escolher entre quatro cartas. Se tirar a carta do rei, não ganha nada. Se tirar o ás, uma das alternativas incorretas se apagará. Se tirar o dois, duas das alternativas incorretas se apagarão. Se tirar o três, três das alternativas incorretas se apagarão.<br><br>Clique em próximo para continuar.</p></html>";
    
    String inst6 = "<html><p style=\"font-size:24px; color:white; text-align:justify\">6 - Você pode pedir ajuda as placas uma vez. Ao pedir ajuda às placas, a plateia dará sua opinião sobre qual alternativa acha ser correta e lhe será mostrado a porcentagem de pessoas que escolheram cada alternativa.<br><br>Clique em próximo para continuar.</p></html>";
    
    String inst7 = "<html><p style=\"font-size:24px; color:white; text-align:justify\">7 - Você pode pedir ajuda aos convidados uma vez. Ao pedir ajuda aos convidados, os três convidados darão sua opinião sobre qual alternativa acreditam ser correta.<br><br><b style='color:red'>8 - Você não pode pedir ajuda ou pular a pergunta do milhão.</b><br><br>Volte ao menu para começar a jogar! Boa sorte!<br>Dica: Clique no botão \"Cadastrar pergunta\" no menu para cadastrar suas própias perguntas!</p></html>";
    /**
     * Creates new form menu
     */
    public inst() {
        initComponents();
        etapa = 1;
        jButton1.setVisible(false);
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 53, 101));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 43, 94));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("<html>Anterior</html>");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(50, 510, 190, 70);

        jLabel1.setText(inst1);
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 20, 700, 480);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("<html>Voltar ao menu</html>");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(500, 510, 280, 70);

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("<html>Próximo</html>");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(260, 510, 190, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 600);

        setSize(new java.awt.Dimension(800, 599));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        etapa -=1;
        if (etapa == 1) {
        jLabel1.setText(inst1); 
        jButton1.setVisible(false);
        } else if (etapa == 2) {
        jLabel1.setText(inst2);    
        } else if (etapa == 3) {
        jLabel1.setText(inst3);    
        } else if (etapa == 4) {
        jLabel1.setText(inst4);    
        } else if (etapa == 5) {
        jLabel1.setText(inst5);    
        } else if (etapa == 6) {
        jLabel1.setText(inst6);    
        } else if (etapa == 7) {
            jLabel1.setText(inst7); 
        }
    jButton3.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

            
        etapa +=1;
        
        if (etapa == 1) {
        jLabel1.setText(inst1);    
        } else if (etapa == 2) {
        jLabel1.setText(inst2);    
        } else if (etapa == 3) {
        jLabel1.setText(inst3);    
        } else if (etapa == 4) {
        jLabel1.setText(inst4);    
        } else if (etapa == 5) {
        jLabel1.setText(inst5);    
        } else if (etapa == 6) {
        jLabel1.setText(inst6);    
        } else if (etapa == 7) {
            jButton3.setVisible(false);
            jLabel1.setText(inst7); 
        }
        jButton1.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(inst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inst().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

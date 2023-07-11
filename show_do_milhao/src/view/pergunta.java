package view;

import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane; 
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;


public class pergunta extends javax.swing.JFrame {

    static int cod, corretav = 5, pulando = 0, ajudadas = 0, tempoc = 2, z = 0, tempop = 5;
    static int contar, terp = 40;
    static int feitas = 0, premio = 0, tem = 0, codigo = 0;
    static boolean clicador = false;
    ArrayList<Integer> cartinhas = new ArrayList<>();
    ArrayList<Integer> retiradas = new ArrayList<>();
 public Statement stm;
 public Connection conn;
 String perguntafazer, resp1v, resp2v, resp3v, resp4v, correta;
 
 JDialog dialog = new JDialog();
    
  String url2 = "jdbc:mysql://localhost/perguntas";
  String username = "root";
  String password = "";
  
  String dificuldade = "facil";
  
  ArrayList<Integer> repetidas = new ArrayList<>();
  ArrayList<Integer> puladas = new ArrayList<>();
  
  Timer tempor;
  Timer tempocc;
  Timer tempopp;
  
  String[] options = {"Cartas", "Placas", "Convidados"};
  
    public pergunta() {
        initComponents();
        int cocarta = (int )(Math.random() * 4 + 1);
        
        while (cartinhas.size()<4){
        while(cartinhas.contains(cocarta)){
                    cocarta = (int )(Math.random() * 4 + 1);
                }
        cartinhas.add(cocarta);
        }
       /* cartinhas.forEach((s) -> {
            System.out.println(s);
        }); */
        
        tempor = new Timer();
        corretav = 5;
        ajudadas = 0;
        clicador = false;
        feitas = 0;
        premio = 0;
        gerarpergunta();
        dificuldade = "facil";
    }
    
     public void gerarpergunta() {
          
         resp1.setVisible(true);
         resp2.setVisible(true);
         resp3.setVisible(true);
         resp4.setVisible(true);
         jInternalFrame1.setVisible(false);
         jInternalFrame2.setVisible(false);
         jInternalFrame3.setVisible(false);
         jInternalFrame4.setVisible(false);
         
            if (premio == 1000){
                new vencedor().setVisible(true);
                this.dispose();
                return;
            }
         
            controller.Driver.carregaDriver();
            try {
                
                Connection conn;
            
                terp = 41;
                
        tempor = new Timer();

                if(repetidas.size()==5){
                    Collections.fill(repetidas, 0);
                    Collections.fill(puladas, 0);
                    dificuldade = "medio";
                }
                
                if(repetidas.size()==10){
                    Collections.fill(repetidas, 0);
                    Collections.fill(puladas, 0);
                    dificuldade = "dificil";
                }
                
                if(repetidas.size()==15){
                    Collections.fill(repetidas, 0);
                    Collections.fill(puladas, 0);
                    dificuldade = "expert";
                }
        
                    conn = DriverManager.getConnection(url2, username, password);
                
                    stm = (Statement) conn.createStatement();
                
                ResultSet rs3;
                rs3 = stm.executeQuery("SELECT COUNT(*) AS 'count' FROM " + dificuldade + ";");
                if(rs3 != null && rs3.next()){
                    String contarr = rs3.getString("count");
                contar = Integer.parseInt(contarr);
                }

                codigo = (int )(Math.random() * contar + 1);
                
                if((contar<=repetidas.size()+puladas.size()) && (dificuldade.equals("facil"))){
                    tempor.cancel();
                    JOptionPane.showMessageDialog(null, "<html><center><h1 style='color:red; font-size:16px;'>Não há mais perguntas disponíveis no banco de dados!<br>O jogo vai ter que terminar por aqui :(</h1></center></html>", "Fim de jogo", -1);
                    new menu().setVisible(true);
                    this.dispose();
                    return;
                } else if((contar<=repetidas.size()-5+puladas.size()) && (dificuldade.equals("medio"))){
                    tempor.cancel();
                    JOptionPane.showMessageDialog(null, "<html><center><h1 style='color:red; font-size:16px;'>Não há mais perguntas disponíveis no banco de dados!<br>O jogo vai ter que terminar por aqui :(</h1></center></html>", "Fim de jogo", -1);
                    new menu().setVisible(true);
                    this.dispose();
                    return;
                } else if((contar<=repetidas.size()-10+puladas.size()) && (dificuldade.equals("dificil"))){
                    tempor.cancel();
                    JOptionPane.showMessageDialog(null, "<html><center><h1 style='color:red; font-size:16px;'>Não há mais perguntas disponíveis no banco de dados!<br>O jogo vai ter que terminar por aqui :(</h1></center></html>", "Fim de jogo", -1);
                    new menu().setVisible(true);
                    this.dispose();
                    return;
                } else if((contar<=repetidas.size()-15+puladas.size()) && (dificuldade.equals("expert"))){
                    tempor.cancel();
                    JOptionPane.showMessageDialog(null, "<html><center><h1 style='color:red; font-size:16px;'>Não há mais perguntas disponíveis no banco de dados!<br>O jogo vai ter que terminar por aqui :(</h1></center></html>", "Fim de jogo", -1);
                    new menu().setVisible(true);
                    this.dispose();
                    return;
                } else
                
                while(repetidas.contains(codigo) || puladas.contains(codigo)){
                    codigo = (int )(Math.random() * contar + 1);
                }
                
                if (pulando == 0){ 
                repetidas.add(codigo);
                }
                
                try{ 
                    ResultSet rs5 = stm.executeQuery("SELECT * FROM " + dificuldade + " where id = '"+codigo+"';");

                        if(rs5 != null && rs5.next()){
                        perguntafazer = rs5.getString("pergunta");
                        resp1v = rs5.getString("resp1");
                        resp2v = rs5.getString("resp2");
                        resp3v = rs5.getString("resp3");
                        resp4v = rs5.getString("resp4");
                        correta = rs5.getString("cor");
                        corretav = Integer.parseInt(correta);
                        perguntalabel.setText("<html><p style='background:yellow; padding:5px; width:100%;'>" + perguntafazer + "</p></html>");
                        
                        resp1.setText("<html><b style='width: 25px;color:blue; background:white; border: 2px solid #666; border-radius:50%;'>1</b> " + resp1v + "</html>");
                        resp2.setText("<html><b style='width: 25px;color:blue; background:white; border: 2px solid #666; border-radius:50%;'>2</b> " + resp2v + "</html>");
                        resp3.setText("<html><b style='width: 25px;color:blue; background:white; border: 2px solid #666; border-radius:50%;'>3</b> " + resp3v + "</html>");
                        resp4.setText("<html><b style='width: 25px;color:blue; background:white; border: 2px solid #666; border-radius:50%;'>4</b> " + resp4v + "</html>");
                        
                        feitas++;
                        perguntan.setText("<html><center>PERGUNTA:<br><h1 style=\"color:red; font-size:32px;\">" + Integer.toString(repetidas.size()) + "</h1></center></html>");
                        
                        if (pulando == 0) {
                        tem = premio * 1000;
                        
                        if(repetidas.size() <= 5){
                            premio +=1;
                        } else if(repetidas.size() <= 6){
                            premio +=5;
                        } else if(repetidas.size() <= 10){
                            premio +=10;
                        } else if(repetidas.size() <= 11){
                            premio +=50;
                        } else if(repetidas.size() <= 15){
                            premio +=100;
                        } else if(repetidas.size() <= 16){
                            premio +=500;
                            jButton6.setVisible(false);
                            jButton5.setVisible(false);
                        }}
                        
                        pulando = 0;
                        
                        premiolabel.setText("<html><center>ACERTAR:<br><h1 style=\"color:lime; font-size:16px;\">R$" + premio * 1000 + ",00</h1></center></html>");
                        pararlabel.setText("<html><center>PARAR:<br><h1 style=\"color:lime; font-size:16px;\">R$" + tem + ",00</h1></center></html>");
                        
                        if(tem==500000){
                        errarlabel.setText("<html><center>ERRAR:<br><h1 style=\"color:red; font-size:16px;\">PERDE TUDO</h1></center></html>");
                        }else{
                        errarlabel.setText("<html><center>ERRAR:<br><h1 style=\"color:lime; font-size:16px;\">R$" + tem/2 + ",00</h1></center></html>");
                        }
                        
                        tempor = new Timer();
                        TimerTask timerTask = new TimerTask() { 
      
          public void run() { 
              terp-=1;
                    tempolabel.setText("<html><center>TEMPO<br>RESTANTE:<h1 style=\'color:red; font-size:32px;\'>" + terp + "</h1></center></html>");
              
              if (terp<=0){
                  tempor.cancel();
                  if(tem==500000){
                    tem = 0;
                  }
                  jInternalFrame1.setVisible(false);
                  jInternalFrame2.setVisible(false);
                  jInternalFrame3.setVisible(false);
                  jInternalFrame4.setVisible(false);
                  JOptionPane.showMessageDialog(null, "<html><center><h1 style='color:red; font-size:16px;'>O tempo acabou! Você ganhou R$" + tem/2 + ",00</h1></center></html>", "Fim de jogo", -1);
                  new menu().setVisible(true);
                  dispose();
              }
                    
              }
          };
      tempor.schedule(timerTask, 0, 1000*1);   
                        }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Erro ao acessar o banco de dados! Certifique-se de executar o script perguntas.sql!","Erro",0);
                    new menu().setVisible(true);
                    dispose();
                    return;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao acessar o banco de dados! Certifique-se de executar o script perguntas.sql!","Erro!",0);
                new menu().setVisible(true);
                dispose();
                return;
            } 

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
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        resp4 = new javax.swing.JButton();
        tempolabel = new javax.swing.JLabel();
        perguntalabel = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        resp1 = new javax.swing.JButton();
        resp2 = new javax.swing.JButton();
        resp3 = new javax.swing.JButton();
        errarlabel = new javax.swing.JLabel();
        perguntan = new javax.swing.JLabel();
        premiolabel = new javax.swing.JLabel();
        pararlabel = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 53, 101));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jDesktopPane1.setOpaque(false);

        jInternalFrame4.setBackground(new java.awt.Color(0, 43, 94));
        jInternalFrame4.setClosable(true);
        jInternalFrame4.setMaximumSize(new java.awt.Dimension(600, 400));
        jInternalFrame4.setMinimumSize(new java.awt.Dimension(600, 400));
        jInternalFrame4.setPreferredSize(new java.awt.Dimension(600, 400));
        jInternalFrame4.setVisible(false);
        jInternalFrame4.getContentPane().setLayout(null);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/person.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        jInternalFrame4.getContentPane().add(jLabel9);
        jLabel9.setBounds(390, 50, 180, 180);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/person.png"))); // NOI18N
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jInternalFrame4.getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 50, 180, 180);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/person.png"))); // NOI18N
        jInternalFrame4.getContentPane().add(jLabel11);
        jLabel11.setBounds(200, 50, 180, 180);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>1</h1></center></html>");
        jInternalFrame4.getContentPane().add(jLabel12);
        jLabel12.setBounds(390, 240, 180, 40);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>1</h1></center></html>");
        jInternalFrame4.getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 240, 180, 40);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>1</h1></center></html>");
        jInternalFrame4.getContentPane().add(jLabel14);
        jLabel14.setBounds(200, 240, 180, 40);

        jDesktopPane1.add(jInternalFrame4);
        jInternalFrame4.setBounds(110, 100, 590, 390);

        jInternalFrame3.setBackground(new java.awt.Color(0, 43, 94));
        jInternalFrame3.setClosable(true);
        jInternalFrame3.setMaximumSize(new java.awt.Dimension(600, 400));
        jInternalFrame3.setMinimumSize(new java.awt.Dimension(600, 400));
        jInternalFrame3.setPreferredSize(new java.awt.Dimension(600, 400));
        jInternalFrame3.setVisible(false);
        jInternalFrame3.getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><center><h1 style=\"font-size:72px;color:white;background:cyan;\">4</h1></center></html>");
        jInternalFrame3.getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 50, 140, 230);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html><center><h1 style=\"font-size:72px;color:white;background:cyan;\">1</h1></center></html>");
        jInternalFrame3.getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 60, 130, 210);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html><center><h1 style=\"font-size:72px;color:white;background:cyan;\">2</h1></center></html>");
        jInternalFrame3.getContentPane().add(jLabel7);
        jLabel7.setBounds(150, 50, 140, 230);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html><center><h1 style=\"font-size:72px;color:white;background:cyan;\">3</h1></center></html>");
        jInternalFrame3.getContentPane().add(jLabel8);
        jLabel8.setBounds(300, 50, 140, 230);

        jDesktopPane1.add(jInternalFrame3);
        jInternalFrame3.setBounds(110, 100, 590, 390);

        jInternalFrame2.setBackground(new java.awt.Color(0, 43, 94));
        jInternalFrame2.setClosable(true);
        jInternalFrame2.setMaximumSize(new java.awt.Dimension(600, 400));
        jInternalFrame2.setMinimumSize(new java.awt.Dimension(600, 400));
        jInternalFrame2.setPreferredSize(new java.awt.Dimension(600, 400));
        jInternalFrame2.setVisible(false);
        jInternalFrame2.getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verso.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jLabel2);
        jLabel2.setBounds(440, 100, 120, 160);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verso.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 100, 120, 160);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verso.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 100, 120, 160);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verso.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jLabel5);
        jLabel5.setBounds(300, 100, 120, 160);

        jDesktopPane1.add(jInternalFrame2);
        jInternalFrame2.setBounds(110, 100, 590, 390);

        jInternalFrame1.setBackground(new java.awt.Color(0, 43, 94));
        jInternalFrame1.setClosable(true);
        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame1.setMaximumSize(new java.awt.Dimension(600, 400));
        jInternalFrame1.setMinimumSize(new java.awt.Dimension(600, 400));
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(600, 400));
        jInternalFrame1.setVisible(false);
        jInternalFrame1.getContentPane().setLayout(null);

        jButton7.setBackground(new java.awt.Color(255, 255, 0));
        jButton7.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton7.setText("<html><h1 style=\"color:red; font-size:36px;\">Convidados</h1></html>");
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton7);
        jButton7.setBounds(130, 240, 310, 70);

        jButton8.setBackground(new java.awt.Color(255, 255, 0));
        jButton8.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton8.setText("<html><h1 style=\"color:red; font-size:36px;\">Cartas</h1></html>");
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton8);
        jButton8.setBounds(130, 60, 310, 70);

        jButton9.setBackground(new java.awt.Color(255, 255, 0));
        jButton9.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton9.setText("<html><h1 style=\"color:red; font-size:36px;\">Placas</h1></html>");
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton9);
        jButton9.setBounds(130, 150, 310, 70);

        jDesktopPane1.add(jInternalFrame1);
        jInternalFrame1.setBounds(110, 100, 590, 390);

        jPanel1.setBackground(new java.awt.Color(0, 43, 94));
        jPanel1.setLayout(null);

        resp4.setBackground(new java.awt.Color(255, 0, 0));
        resp4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        resp4.setText("<html><b style=\"width: 25px;color:blue; background:white; border: 2px solid #666; border-radius:50%;\">4</b></html>");
        resp4.setFocusPainted(false);
        resp4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        resp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp4ActionPerformed(evt);
            }
        });
        jPanel1.add(resp4);
        resp4.setBounds(30, 350, 590, 70);

        tempolabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tempolabel.setForeground(new java.awt.Color(255, 255, 255));
        tempolabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempolabel.setText("<html><center>TEMPO<br>RESTANTE:<h1 style=\"color:red; font-size:32px;\">40</h1></center></html>");
        tempolabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(tempolabel);
        tempolabel.setBounds(30, 440, 140, 120);

        perguntalabel.setBackground(new java.awt.Color(255, 255, 0));
        perguntalabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        perguntalabel.setText("<html><p style=\"background:yellow; padding:5px; width:100%;\">PERGUNTA</p></html>");
        perguntalabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        perguntalabel.setOpaque(true);
        jPanel1.add(perguntalabel);
        perguntalabel.setBounds(30, 20, 750, 80);

        jButton4.setBackground(new java.awt.Color(255, 255, 0));
        jButton4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton4.setText("<html><h1 style=\"color:red; font-size:36px;\">Parar</h1></html>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(600, 500, 180, 70);

        resp1.setBackground(new java.awt.Color(255, 0, 0));
        resp1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        resp1.setText("<html><b style=\"width: 25px;color:blue; background:white; border: 2px solid #666; border-radius:50%;\">1</b></html>");
        resp1.setFocusPainted(false);
        resp1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        resp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp1ActionPerformed(evt);
            }
        });
        jPanel1.add(resp1);
        resp1.setBounds(30, 110, 590, 70);

        resp2.setBackground(new java.awt.Color(255, 0, 0));
        resp2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        resp2.setText("<html><b style=\"width: 25px;color:blue; background:white; border: 2px solid #666; border-radius:50%;\">2</b></html>");
        resp2.setFocusPainted(false);
        resp2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        resp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp2ActionPerformed(evt);
            }
        });
        jPanel1.add(resp2);
        resp2.setBounds(30, 190, 590, 70);

        resp3.setBackground(new java.awt.Color(255, 0, 0));
        resp3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        resp3.setText("<html><b style=\"width: 25px;color:blue; background:white; border: 2px solid #666; border-radius:50%;\">3</b></html>");
        resp3.setFocusPainted(false);
        resp3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        resp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp3ActionPerformed(evt);
            }
        });
        jPanel1.add(resp3);
        resp3.setBounds(30, 270, 590, 70);

        errarlabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        errarlabel.setForeground(new java.awt.Color(255, 255, 255));
        errarlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errarlabel.setText("<html><center>ERRAR:<br><h1 style=\"color:lime; font-size:32px;\">R$0,00</h1></center></html>");
        errarlabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(errarlabel);
        errarlabel.setBounds(640, 390, 140, 80);

        perguntan.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        perguntan.setForeground(new java.awt.Color(255, 255, 255));
        perguntan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perguntan.setText("<html><center>PERGUNTA:<br><h1 style=\"color:red; font-size:32px;\">1</h1></center></html>");
        perguntan.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(perguntan);
        perguntan.setBounds(640, 110, 140, 80);

        premiolabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        premiolabel.setForeground(new java.awt.Color(255, 255, 255));
        premiolabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        premiolabel.setText("<html><center>ACERTAR:<br><h1 style=\"color:lime; font-size:32px;\">R$0,00</h1></center></html>");
        premiolabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(premiolabel);
        premiolabel.setBounds(640, 210, 140, 80);

        pararlabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        pararlabel.setForeground(new java.awt.Color(255, 255, 255));
        pararlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pararlabel.setText("<html><center>PARAR:<br><h1 style=\"color:lime; font-size:32px;\">R$0,00</h1></center></html>");
        pararlabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(pararlabel);
        pararlabel.setBounds(640, 300, 140, 80);

        jButton5.setBackground(new java.awt.Color(255, 255, 0));
        jButton5.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton5.setText("<html><h1 style=\"color:red; font-size:36px;\">Pular</h1></html>");
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(400, 500, 180, 70);

        jButton6.setBackground(new java.awt.Color(255, 255, 0));
        jButton6.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton6.setText("<html><h1 style=\"color:red; font-size:36px;\">Ajuda</h1></html>");
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(200, 500, 180, 70);

        jDesktopPane1.add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 600);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 800, 600);

        setSize(new java.awt.Dimension(800, 602));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resp4ActionPerformed
        // TODO add your handling code here:
        if(corretav == 4){
            tempor.cancel();
            JOptionPane.showMessageDialog(null, "Correto!", "Correto!", 1);
            gerarpergunta();
        } else if(corretav == 5){
            gerarpergunta();
        } else {
            tempor.cancel();
            if(tem==500000){
                tem = 0;
            }
            JOptionPane.showMessageDialog(null, "Você errou!  Você ganhou R$" + tem/2 + ",00", "Fim de jogo!", 0);
            new menu().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_resp4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tempor.cancel();
        JOptionPane.showMessageDialog(null, "<html><center><h1 style='color:green; font-size:16px;'>Você parou! Você ganhou R$" + tem + ",00</h1></center></html>", "Fim de jogo", -1);
        new menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void resp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resp1ActionPerformed
        // TODO add your handling code here:
        if(corretav == 1){
            tempor.cancel();
            JOptionPane.showMessageDialog(null, "Correto!", "Correto!", 1);
            gerarpergunta();
        } else if(corretav == 5){
            gerarpergunta();
        } else {
            tempor.cancel();
            if(tem==500000){
                tem = 0;
            }
            JOptionPane.showMessageDialog(null, "Você errou! Você ganhou R$" + tem/2 + ",00", "Fim de jogo!", 0);
            new menu().setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_resp1ActionPerformed

    private void resp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resp2ActionPerformed
        // TODO add your handling code here:
        if(corretav == 2){
            tempor.cancel();
            JOptionPane.showMessageDialog(null, "Correto!", "Correto!", 1);
            gerarpergunta();
        } else if(corretav == 5){
            gerarpergunta();
        } else {
            tempor.cancel();
            if(tem==500000){
                tem = 0;
            }
            JOptionPane.showMessageDialog(null, "Você errou! Você ganhou R$" + tem/2 + ",00", "Fim de jogo!", 0);
            new menu().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_resp2ActionPerformed

    private void resp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resp3ActionPerformed
        // TODO add your handling code here:
        if(corretav == 3){
            tempor.cancel();
            JOptionPane.showMessageDialog(null, "Correto!", "Correto!", 1);
            gerarpergunta();
        } else if(corretav == 5){
            gerarpergunta();
        } else {
            tempor.cancel();
            if(tem==500000){
                tem = 0;
            }
            JOptionPane.showMessageDialog(null, "Você errou! Você ganhou R$" + tem/2 + ",00", "Fim de jogo!", 0);
            new menu().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_resp3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       
            puladas.add(codigo);
            pulando = 1;
            tempor.cancel();
            JOptionPane.showMessageDialog(null, "<html><center><h1 style='color:blue; font-size:16px;'>Você pulou a pergunta!</h1></center></html>", "Pulou!", -1);
            gerarpergunta();
       if(puladas.size()>=3){
           jButton5.setVisible(false);
       }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
jInternalFrame1.setVisible(true);
jInternalFrame2.setVisible(false);
jInternalFrame3.setVisible(false);
jInternalFrame4.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
if (corretav == 1) {
    jLabel13.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>1</h1></center></html>");
    jLabel14.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>3</h1></center></html>");
    jLabel12.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>1</h1></center></html>");
    resp1.requestFocus();
} else if (corretav == 2) {
    jLabel13.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>2</h1></center></html>");
    jLabel14.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>2</h1></center></html>");
    jLabel12.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>1</h1></center></html>");
    resp2.requestFocus();
} else if (corretav == 3) {
        jLabel13.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>4</h1></center></html>");
    jLabel14.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>3</h1></center></html>");
    jLabel12.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>3</h1></center></html>");
    resp3.requestFocus();
} else if (corretav == 4) {
        jLabel13.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>4</h1></center></html>");
    jLabel14.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>2</h1></center></html>");
    jLabel12.setText("<html><center><h1 style='font-size:36px;color:white;background:cyan;'>4</h1></center></html>");
    resp4.requestFocus();
}
        jInternalFrame4.setVisible(true);
        jInternalFrame1.setVisible(false);
jButton7.setVisible(false);
ajudadas += 1;
        tempop = 5;
            tempopp = new Timer();
                        TimerTask timerTask = new TimerTask() {
           public void run() { 
              tempop-=1;
              if (tempop<=0){
                  tempopp.cancel();
        jInternalFrame4.setVisible(false);  
        if (ajudadas == 3){
            jButton6.setVisible(false);
        }
              }
                  
              }
           };
      tempopp.schedule(timerTask, 0, 500*1);  

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
jInternalFrame2.setVisible(true);
jInternalFrame1.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
if (corretav == 1) {
    jLabel6.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>1</h1><h1 style='font-size:36px;color:green;background:cyan;'>81%</h1></center></html>");
    jLabel7.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>2</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>3%</h1></center></html>");
    jLabel8.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>3</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>9%</h1></center></html>");
    jLabel1.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>4</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>7%</h1></center></html>");
    resp1.requestFocus();
} else if (corretav == 2) {
    jLabel6.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>1</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>12%</h1></center></html>");
    jLabel7.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>2</h1><h1 style='font-size:36px;color:green;background:cyan;'>85%</h1></center></html>");
    jLabel8.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>3</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>1%</h1></center></html>");
    jLabel1.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>4</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>2%</h1></center></html>");
    resp2.requestFocus();
} else if (corretav == 3) {
    jLabel6.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>1</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>6%</h1></center></html>");
    jLabel7.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>2</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>7%</h1></center></html>");
    jLabel8.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>3</h1><h1 style='font-size:36px;color:green;background:cyan;'>79%</h1></center></html>");
    jLabel1.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>4</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>8%</h1></center></html>");
    resp3.requestFocus();
} else if (corretav == 4) {
    jLabel6.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>1</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>3%</h1></center></html>");
    jLabel7.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>2</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>15%</h1></center></html>");
    jLabel8.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>3</h1><h1 style='font-size:36px;color:yellow;background:cyan;'>6%</h1></center></html>");
    jLabel1.setText("<html><center><h1 style='font-size:72px;color:white;background:cyan;'>4</h1><h1 style='font-size:36px;color:green;background:cyan;'>76%</h1></center></html>");
    resp4.requestFocus();
}
        jInternalFrame3.setVisible(true);
        jInternalFrame1.setVisible(false);
jButton9.setVisible(false);
ajudadas += 1;
        tempop = 5;
            tempopp = new Timer();
                        TimerTask timerTask = new TimerTask() {
           public void run() { 
              tempop-=1;
              if (tempop<=0){
                  tempopp.cancel();
        jInternalFrame3.setVisible(false);  
        if (ajudadas == 3){
            jButton6.setVisible(false);
        }
              }
                  
              }
           };
      tempopp.schedule(timerTask, 0, 500*1);  

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if (!clicador){
        int x = cartinhas.get(0);
        int y = 3;
        baralho(x, y);
        clicador = true;
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if (!clicador){
        int x = cartinhas.get(1);
        int y = 4;
        baralho(x, y);
        clicador = true;
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if (!clicador){
        int x = cartinhas.get(2);
        int y = 5;
        baralho(x, y);
        clicador = true;
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (!clicador){
        int x = cartinhas.get(3);
        int y = 2;
        baralho(x, y);
        clicador = true;
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered
       
    public void baralho(int x, int y){
        jInternalFrame2.setEnabled(false);
        z = 0;
        ImageIcon valid = new ImageIcon(getClass().getResource("/img/kpaus.png"));
    if (x == 1){
        valid = new ImageIcon(getClass().getResource("/img/kpaus.png"));
    } else  if (x == 2){
        valid = new ImageIcon(getClass().getResource("/img/apaus.png"));
        z = 1;
    } else if (x == 3){
        valid = new ImageIcon(getClass().getResource("/img/2paus.png"));
        z = 2;
    } else if (x == 4){
        valid = new ImageIcon(getClass().getResource("/img/3paus.png"));
        z = 3;
    }
            if (y == 3){
        jLabel3.setIcon(valid);
    } else if (y == 4){
        jLabel4.setIcon(valid);
    } else if (y == 5){
        jLabel5.setIcon(valid);
    } else if (y == 2){
        jLabel2.setIcon(valid);
    }
            
            tempoc = 2;
            tempocc = new Timer();
                        TimerTask timerTask = new TimerTask() {
           public void run() { 
              tempoc-=1;
              if (tempoc<=0){
                  tempocc.cancel();
                  
                  int cocarta = (int )(Math.random() * 4 + 1);
        
        while (retiradas.size()<z){
        while(retiradas.contains(cocarta) || cocarta == corretav){
                    cocarta = (int )(Math.random() * 4 + 1);
                }
        if (cocarta == 1){
            resp1.setVisible(false);
        }
         if (cocarta == 2){
            resp2.setVisible(false);
        }
          if (cocarta == 3){
            resp3.setVisible(false);
        }
           if (cocarta == 4){
            resp4.setVisible(false);
        }
           retiradas.add(cocarta);
        }
        jInternalFrame2.setVisible(false); 
        jButton8.setVisible(false); 
        ajudadas+=1;
        if (ajudadas == 3){
            jButton6.setVisible(false);
        }
              }
                  
              }
           };
      tempocc.schedule(timerTask, 0, 1000*1);  
            
        
        
}
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
            java.util.logging.Logger.getLogger(pergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pergunta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errarlabel;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pararlabel;
    private javax.swing.JLabel perguntalabel;
    private javax.swing.JLabel perguntan;
    private javax.swing.JLabel premiolabel;
    private javax.swing.JButton resp1;
    private javax.swing.JButton resp2;
    private javax.swing.JButton resp3;
    private javax.swing.JButton resp4;
    private javax.swing.JLabel tempolabel;
    // End of variables declaration//GEN-END:variables
}

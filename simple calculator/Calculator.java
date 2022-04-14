
import java.awt.Color;
import javax.swing.JOptionPane;

public class Calculator extends javax.swing.JFrame {

    /**
     * Creates new form Calculator
     */
    private String operations;
    
    public Calculator() {
        initComponents();
        this.operations = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        buttonSeeResult = new javax.swing.JButton();
        buttonPlus = new javax.swing.JButton();
        buttonMinus = new javax.swing.JButton();
        buttonDivide = new javax.swing.JButton();
        buttonMultiply = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonParanthesisOpen = new javax.swing.JButton();
        buttonParanthesisClose = new javax.swing.JButton();
        button0 = new javax.swing.JButton();
        buttonDot = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setMinimumSize(new java.awt.Dimension(520, 520));
        setResizable(false);
        setSize(new java.awt.Dimension(580, 580));

        button1.setBackground(new java.awt.Color(0, 204, 153));
        button1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button1.setText("1");
        button1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        button1.setBorderPainted(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        textPane.setEditable(false);
        textPane.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        textPane.setToolTipText("enter operations");
        jScrollPane2.setViewportView(textPane);

        button2.setBackground(new java.awt.Color(0, 204, 153));
        button2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button2.setText("2");
        button2.setBorderPainted(false);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(0, 204, 153));
        button3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button3.setText("3");
        button3.setBorderPainted(false);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button5.setBackground(new java.awt.Color(0, 204, 153));
        button5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button5.setText("5");
        button5.setBorderPainted(false);
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setBackground(new java.awt.Color(0, 204, 153));
        button6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button6.setText("6");
        button6.setBorderPainted(false);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(0, 204, 153));
        button4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button4.setText("4");
        button4.setBorderPainted(false);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button8.setBackground(new java.awt.Color(0, 204, 153));
        button8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button8.setText("8");
        button8.setBorderPainted(false);
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.setBackground(new java.awt.Color(0, 204, 153));
        button9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button9.setText("9");
        button9.setBorderPainted(false);
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        button7.setBackground(new java.awt.Color(0, 204, 153));
        button7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button7.setText("7");
        button7.setBorderPainted(false);
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        buttonSeeResult.setBackground(new java.awt.Color(153, 153, 255));
        buttonSeeResult.setFont(new java.awt.Font("Tahoma", 0, 52)); // NOI18N
        buttonSeeResult.setText("=");
        buttonSeeResult.setToolTipText("");
        buttonSeeResult.setBorderPainted(false);
        buttonSeeResult.setPreferredSize(new java.awt.Dimension(70, 70));
        buttonSeeResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeeResultActionPerformed(evt);
            }
        });

        buttonPlus.setBackground(new java.awt.Color(153, 153, 255));
        buttonPlus.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        buttonPlus.setText("+");
        buttonPlus.setBorderPainted(false);
        buttonPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlusActionPerformed(evt);
            }
        });

        buttonMinus.setBackground(new java.awt.Color(153, 153, 255));
        buttonMinus.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        buttonMinus.setText("-");
        buttonMinus.setBorderPainted(false);
        buttonMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMinusActionPerformed(evt);
            }
        });

        buttonDivide.setBackground(new java.awt.Color(153, 153, 255));
        buttonDivide.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        buttonDivide.setText("/");
        buttonDivide.setBorderPainted(false);
        buttonDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDivideActionPerformed(evt);
            }
        });

        buttonMultiply.setBackground(new java.awt.Color(153, 153, 255));
        buttonMultiply.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        buttonMultiply.setText("*");
        buttonMultiply.setAlignmentY(0.0F);
        buttonMultiply.setBorderPainted(false);
        buttonMultiply.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonMultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMultiplyActionPerformed(evt);
            }
        });

        buttonClear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonClear.setText("TEMİZLE");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonDelete.setText("< Sil");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonParanthesisOpen.setBackground(new java.awt.Color(204, 153, 255));
        buttonParanthesisOpen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonParanthesisOpen.setText("(");
        buttonParanthesisOpen.setBorderPainted(false);
        buttonParanthesisOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonParanthesisOpenActionPerformed(evt);
            }
        });

        buttonParanthesisClose.setBackground(new java.awt.Color(204, 153, 255));
        buttonParanthesisClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonParanthesisClose.setText(")");
        buttonParanthesisClose.setBorderPainted(false);
        buttonParanthesisClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonParanthesisCloseActionPerformed(evt);
            }
        });

        button0.setBackground(new java.awt.Color(0, 204, 153));
        button0.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        button0.setText("0");
        button0.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        button0.setBorderPainted(false);
        button0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button0ActionPerformed(evt);
            }
        });

        buttonDot.setBackground(new java.awt.Color(204, 153, 255));
        buttonDot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonDot.setText(".");
        buttonDot.setBorderPainted(false);
        buttonDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(button0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonParanthesisOpen)
                                        .addGap(19, 19, 19)
                                        .addComponent(buttonParanthesisClose)
                                        .addGap(32, 32, 32)
                                        .addComponent(buttonDot)))))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(buttonDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(buttonMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(buttonSeeResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(buttonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button0)
                            .addComponent(buttonParanthesisOpen)
                            .addComponent(buttonParanthesisClose)
                            .addComponent(buttonDot))
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addComponent(buttonSeeResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        updateText("1");
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        updateText("2");
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        updateText("3");
    }//GEN-LAST:event_button3ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        updateText("5");
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        updateText("6");
    }//GEN-LAST:event_button6ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        updateText("4");
    }//GEN-LAST:event_button4ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        updateText("8");
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        updateText("9");
    }//GEN-LAST:event_button9ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        updateText("7");
    }//GEN-LAST:event_button7ActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        clearText();
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if(! this.operations.isEmpty()){
            this.operations = this.operations.substring(0, this.operations.length()-1);
            this.textPane.setText(this.operations);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonDivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDivideActionPerformed
        enterOperator("/");
    }//GEN-LAST:event_buttonDivideActionPerformed

    private void buttonMultiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMultiplyActionPerformed
        enterOperator("*");
    }//GEN-LAST:event_buttonMultiplyActionPerformed

    private void buttonMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMinusActionPerformed
        if(this.operations.isBlank()){
            updateText("-");
        }else if(this.operations.charAt(operations.length()-1) == '('){
            updateText("-");
        }else{
            enterOperator("-");
        }
        
    }//GEN-LAST:event_buttonMinusActionPerformed

    private void button0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button0ActionPerformed
        updateText("0");
    }//GEN-LAST:event_button0ActionPerformed

    private void buttonDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDotActionPerformed
        enterOperator(".");
    }//GEN-LAST:event_buttonDotActionPerformed

    private void buttonPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlusActionPerformed
        enterOperator("+");
    }//GEN-LAST:event_buttonPlusActionPerformed

    private void buttonSeeResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeeResultActionPerformed

        // DO calculation
        CalculatorBrain brain = new CalculatorBrain();
        brain.parseToPostfix(operations);
        clearText();
        // enterOperator("=");
        updateText(brain.calculate());
    }//GEN-LAST:event_buttonSeeResultActionPerformed

    private void buttonParanthesisOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonParanthesisOpenActionPerformed
        updateText("(");
    }//GEN-LAST:event_buttonParanthesisOpenActionPerformed

    private void buttonParanthesisCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonParanthesisCloseActionPerformed
        updateText(")");
    }//GEN-LAST:event_buttonParanthesisCloseActionPerformed

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
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button0;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonDivide;
    private javax.swing.JButton buttonDot;
    private javax.swing.JButton buttonMinus;
    private javax.swing.JButton buttonMultiply;
    private javax.swing.JButton buttonParanthesisClose;
    private javax.swing.JButton buttonParanthesisOpen;
    private javax.swing.JButton buttonPlus;
    private javax.swing.JButton buttonSeeResult;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane textPane;
    // End of variables declaration//GEN-END:variables

    private void updateText(String value) {
        int len = this.operations.length();
        if(len<16){
            this.operations += value;
            this.textPane.setText(operations);
        }else {
            System.out.println("too long!");
            JOptionPane.showMessageDialog(this, "Do not exceed the character limit, 16.", "ops too long!", HEIGHT);
        }
    }
    
    private void enterOperator(String value) {
        char last = this.operations.isEmpty()? 0 : this.operations.charAt(this.operations.length()-1);
        if(! this.operations.isEmpty() && !(last=='/' || last=='*' || last=='=' || last=='-' || last=='+')){
            this.operations += value;
            this.textPane.setText(operations);
        }
    }
    
    private void clearText(){
        this.operations = "";
        this.textPane.setText(this.operations);
    }
}

          import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/*     */ import java.io.PrintStream;

/*     */ import javax.swing.JButton;
import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;

import java.math.BigDecimal;  
/*     */ public class CoreOptionsDialog extends JDialog
/*     */ {
/*  30 */   JPanel buttons = new JPanel();
/*     */   private LabelTextFieldSlider panels=new LabelTextFieldSlider("Signature","0.05",0.0D,1.0D);
/*  36 */   private JButton ok = new JButton("OK");
/*     */ 
/*  38 */   private JButton cancel = new JButton("Cancel");
/*     */   private JFrame owner;
            private JComboBox lst1;
            private JComboBox lst2;
            private Object kmer[]={"2","3","4","5"};
            private Object diedai[]={"1","2","3","4","5","6","7","8"};
            private JLabel lb1=new JLabel("mer数");
            private JLabel lb2=new JLabel("迭代次数");
            private int canshu_kmer=4;
            private int canshu_diedai=5;

/*     */   public CoreOptionsDialog(JFrame paramJFrame)
/*     */   {
/*  56 */     super(paramJFrame, "Advanced Options", true);
/*  57 */     this.owner = paramJFrame;
/*  59 */     initialize();
/*     */   }
/*     */ 

            public double getsig()
            {
            	return(Double.parseDouble(this.panels.getText()));
            }
            
            public int getkmer()
            {
            	return  this.canshu_kmer;
            	
            }
            
            public int getdiedai()
            {
            	return this.canshu_diedai;
            	
            }
            
            
            
///*     */   public void setVisible(boolean paramBoolean)
///*     */   {
//
///*     */ 
///*  77 */     super.setVisible(paramBoolean);
///*     */   }
/*     */ private void updateSettings()
		/*     */     throws NumberFormatException
		/*     */   {
                   try {
	             double sig= Double.parseDouble(this.panels.getText());
		           BigDecimal sig1 = new BigDecimal(sig); 
		           BigDecimal data1 = new BigDecimal(0.0D); 
		           BigDecimal data2 = new BigDecimal(1.0D); 

		/*     */ 
		/* 111 */       if (sig1.compareTo(data1)<0 || data2.compareTo(sig1)<0)
		/* 112 */         JOptionPane.showMessageDialog(null, "Please enter a valid number! " + sig1, "Error", 0);
		/*     */       else
			         
		/* 114 */         setVisible(false);
		/*     */     }
		/*     */     catch (NumberFormatException localNumberFormatException) {
		/* 117 */       throw localNumberFormatException;
		/*     */     }
		/*     */   }

/*     */ 

/*     */ 
/*     */   private void initialize()
/*     */   {
/* 126 */     this.buttons.add(this.ok);
/* 127 */     this.buttons.add(this.cancel);
/*     */    
             lst1=new JComboBox(kmer);  
             lst2=new JComboBox(diedai);
             lst2.setMaximumRowCount(4);
             lst1.setSelectedIndex(2);
             lst2.setSelectedIndex(4);

/* 130 */     this.ok.setActionCommand("OK");
/* 131 */     this.cancel.setActionCommand("Cancel");
/*     */ 
/* 134 */     this.ok.addActionListener(new CoreOptionsDialogListener());
/* 135 */     this.cancel.addActionListener(new CoreOptionsDialogListener());
/*     */     this.lst1.addItemListener(new handler1()); 
              this.lst1.addItemListener(new handler1()); 


/* 138 */     this.ok.setToolTipText("Save settings");
/* 139 */     this.cancel.setToolTipText("Cancel and discard changes");
/* 164 */    
                
				getContentPane().add(lb1);
				getContentPane().add(this.lst1);
				getContentPane().add(lb2);
                 getContentPane().add(this.lst2);
               getContentPane().add(this.panels);
               getContentPane().add(this.buttons);
/*     */     
/* 167 */     getContentPane().setLayout(new FlowLayout(1));
/*     */ 
/* 170 */     setSize(600, (this.panels.getTextField().getSize().height + 40) + 130);
/* 171 */     Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
/* 172 */     setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2);
/*     */   }
/*     */ 
/*     */   private class CoreOptionsDialogListener
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent paramActionEvent)
/*     */     {
/* 188 */       String str = paramActionEvent.getActionCommand();
/*     */ 
/* 190 */       if (str.equals("OK")) {
/* 191 */         System.out.println("OK");
/*     */         try
/*     */         {
/* 194 */            CoreOptionsDialog.this.updateSettings();
/*     */         } catch (NumberFormatException localNumberFormatException) {
/* 196 */           JOptionPane.showMessageDialog(null, "Please enter a valid number! " + localNumberFormatException.getMessage(), "Error", 0);
/*     */         }
               
/*     */       }
/* 199 */       else if (str.equals("Cancel")) {
/* 200 */         System.out.println("Cancel");
/* 201 */         CoreOptionsDialog.this.setVisible(false);
/*     */       }
/*     */     }
/*     */   }

			public class  handler1 implements ItemListener{
				public void itemStateChanged(ItemEvent e)
				{
					if (e.getSource()==lst1)
					CoreOptionsDialog.this.canshu_kmer=Integer.parseInt((lst1.getSelectedItem()).toString());
					if (e.getSource()==lst2)
					CoreOptionsDialog.this.canshu_diedai=Integer.parseInt((lst2.getSelectedItem()).toString());
					
					
					
					  
				}
					
			}












/*     */ }

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     gui.CoreOptionsDialog
 * JD-Core Version:    0.5.3
 */
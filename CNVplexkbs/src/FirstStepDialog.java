          import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
/*     */ import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
import javax.swing.JSpinner;
/*     */ import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/*     */ 
/*     */ public class FirstStepDialog extends JDialog
/*     */ {
	 		private JPanel  JcomboPane=new JPanel();
	 		private JPanel zj=new JPanel();
	 		private JPanel jpanel1=new JPanel();
	 		private JPanel jpanel2=new JPanel();
/*  30 */   private JPanel buttons = new JPanel();
	        private JPanel  upPanel2=new JPanel();	
	        private JPanel  downPanel2=new JPanel();	
            private JLabel temp=new JLabel();
            private JLabel temp1=new JLabel();
/*     */   private LabelTextFieldSlider panels;
/*  36 */   private MyButton ok = new MyButton(" OK");
/*     */   private ImageIcon tu1=new ImageIcon(this.getClass().getResource("/images/name2.gif"));
            private JLabel title1=new JLabel();
            private JLabel title2=new JLabel();
/*  38 */   private MyButton cancel = new MyButton("Reset");
/*     */   private JFrame owner;
            private JComboBox lst1;
            private JComboBox lst2;
            private JTextField lst3;
            private SpinnerNumberModel model3 = new SpinnerNumberModel(256, 1, 256, 10);
            private JSpinner spinner3 = new JSpinner(model3);
            private JComboBox lst4;
            private JComboBox lst5;
            private JCheckBox cb1;
            private Object kmer[]={"2","3","4","5"};
            private Object diedai[]={"1","2","3","4","5","6","7","8","9","10"};
            private Object eyewin[]={"1","2","3","4","5","6"};
            private Object ww[]={"1","2","3","4","5"};
            private JLabel lb1=new JLabel("Word size:");
            private JLabel lb2=new JLabel("Iteration time:");
            private JLabel lb3=new JLabel("Core feature size:");
            private JLabel lb4=new JLabel("Eye window size:");
            private JLabel lb5=new JLabel("Transformed window:");
            private int canshu_kmer;
            private int canshu_diedai;
            private int canshu_ww;
            private int canshu_eyewin;
            private int canshu_upstream;
            private int canshu_downstream;
            private int canshu_slidewin;
            private int canshu_feasize;
            private boolean isbound;
            private LabelTextField upPanel = new LabelTextField("Upstream of 'raw' genomic islands:", "");
            private LabelTextField downPanel = new LabelTextField("Downstream of 'raw' genomic islands:", "");
            private LabelTextField slidewinPanel = new LabelTextField("Sliding window size:", "");

/*     */   public FirstStepDialog(JFrame paramJFrame)
/*     */   {
/*  56 */     super(paramJFrame, "IST-LFS", true);
/*  57 */     this.owner = paramJFrame;
/* 108 */     setSize(600, 580);
/*  47 */     Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
/*  48 */     setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2);
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
            
            public int getww()
            {
            	return this.canshu_ww;
            }
            
            public int getdiedai()
            {
            	return this.canshu_diedai;
            	
            }
            
            public int geteyewin()
            {
            	return this.canshu_eyewin;
            	
            }      
            
            public int getfeasize()
            {
            	return this.canshu_feasize;
            	
            }  
            
                       
            public int getupstream()
            {
            	return this.canshu_upstream;
            	
            }  
            
            public int getdownstream()
            {
            	return this.canshu_downstream;
            	
            }  
            
            public int getslidewin()
            {
            	return this.canshu_slidewin;
            	
            }  
            public boolean getisbound()
            {
            	return this.isbound;
            }
            
            private void enableFileSelection(boolean paramBoolean)
            /*     */   {
               this.upPanel.getTextField().setEnabled(paramBoolean);
               this.downPanel.getTextField().setEnabled(paramBoolean);
           	  this.slidewinPanel.getTextField().setEnabled(paramBoolean);

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
                  this.canshu_feasize=Integer.parseInt(lst3.getText());
                  if (this.isbound==true){
                  this.canshu_upstream=Integer.parseInt( upPanel.getTextField().getText());
                  this.canshu_downstream=Integer.parseInt(downPanel.getTextField().getText());
                  this.canshu_slidewin=Integer.parseInt(slidewinPanel.getTextField().getText());	   
                  }
                  double sig= Double.parseDouble(this.panels.getText());
		           BigDecimal sig1 = new BigDecimal(sig); 
		           BigDecimal data1 = new BigDecimal(0.0D); 
		           BigDecimal data2 = new BigDecimal(1.0D); 

		/*     */ 
		/* 111 */       if (sig1.compareTo(data1)<0 || data2.compareTo(sig1)<0)
		/* 112 */         JOptionPane.showMessageDialog(null, "Please enter a valid number for Time standard error!   " + sig1, "Error", 0);
		/*     */       else if (this.canshu_feasize<1 || this.canshu_feasize>Math.pow(4, canshu_kmer))
			           JOptionPane.showMessageDialog(null, "The size of core feature size should between 1 and 4^(word size)!   " + this.canshu_feasize, "Error", 0);
		                 else if( (this.isbound==true && this.canshu_upstream<0) || (this.isbound==true && this.canshu_downstream<0) || (this.isbound==true && this.canshu_slidewin<0) )
		               JOptionPane.showMessageDialog(null, "The part of CG-MJSD should be put positive numbers!   " , "Error", 0);
		                else
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

             this.canshu_kmer=4;
             this.canshu_diedai=5;
             this.canshu_ww=1;
             this.canshu_eyewin=2;
             this.canshu_feasize=256;
             this.canshu_upstream=5;
             this.canshu_downstream=5;
             this.canshu_slidewin=100;
             this.isbound=false;
             this.panels=new LabelTextFieldSlider("Time standard error","0.01",0.0D,1.0D);
          	this.tu1.setImage(tu1.getImage().getScaledInstance(600, 40, Image.SCALE_DEFAULT));
	        this.title1.setIcon(tu1);
	        this.title2.setText("<html><font color='red'>IST-LFS</font><font color='black'>: An iteration of small-scale t-test with large-scale feature selection</font></html>");
	        this.title2.setFont(new Font("ËÎÌו", Font.BOLD, 12));
	        this.title2.setVerticalAlignment(JLabel.CENTER);
	        this.ok.setPreferredSize(new Dimension(65,28));
	   	    this.cancel.setPreferredSize(new Dimension(65,28));
	   	    this.temp1.setPreferredSize(new Dimension(70,28));
	   	       this.buttons.add(this.temp1);
/* 126 */     this.buttons.add(this.ok);
/* 127 */     this.buttons.add(this.cancel);
/*     */     this.buttons.setLayout(new FlowLayout(1,60,0));
             lst1=new JComboBox(kmer);  
             lst2=new JComboBox(diedai);
             lst3=new JTextField();
             lst3.setText("256");
           //  lst3.getDocument().addDocumentListener(new TextFieldListener());
           //  upPanel.getTextField().getDocument().addDocumentListener(new TextFieldListener());
             lst4=new JComboBox(eyewin);
             lst5=new JComboBox(ww);
             cb1=new JCheckBox("Boundary Detection");
             cb1.setSelected(false);
             enableFileSelection(false);
             lst2.setMaximumRowCount(4);
             lst1.setSelectedIndex(2);
             lst2.setSelectedIndex(4);
             lst4.setSelectedIndex(1);
             lst5.setSelectedIndex(0);
             upPanel.getTextField().setText(Integer.toString(canshu_upstream));
             downPanel.getTextField().setText(Integer.toString(canshu_downstream));
             slidewinPanel.getTextField().setText(Integer.toString(canshu_slidewin));
             
/* 130 */     this.ok.setActionCommand("OK");
/* 131 */     this.cancel.setActionCommand("Cancel");
/*     */ 
/* 134 */     this.ok.addActionListener(new CoreOptionsDialogListener());
/* 135 */     this.cancel.addActionListener(new CoreOptionsDialogListener());
/*     */     this.lst1.addItemListener(new handler1()); 
              this.lst2.addItemListener(new handler1()); 
           // this.lst3.addActionListener(new handler1()); 
              this.lst4.addItemListener(new handler1()); 
              this.lst5.addItemListener(new handler1()); 
              this.cb1.addItemListener(new handler2());
              ChangeListener listener = new ChangeListener() {
            	    public void stateChanged(ChangeEvent e) {
            	      SpinnerModel source = (SpinnerModel)e.getSource();
            	
            	    }
            	  };
            	  model3.addChangeListener(listener);
            	  JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner3, "0%");
           
              
              
              
/* 138 */     this.ok.setToolTipText("Save settings");
/* 139 */     this.cancel.setToolTipText("Reset parameters");
/* 164 */    
                 JcomboPane.add(lb1);
                 JcomboPane.add(this.lst1);
                 JcomboPane.add(lb5);
                 JcomboPane.add(this.lst5);
                 JcomboPane.add(lb2);
                 JcomboPane.add(this.lst2);
                 JcomboPane.add(lb3);
                 JcomboPane.add(this.lst3);
                 //JcomboPane.add(spinner3);
                 JcomboPane.add(lb4);
                 JcomboPane.add(this.lst4);
                 JcomboPane.setLayout(new GridLayout(3,2,5,5));
                 // JcomboPane.setBorder(BorderFactory.createEtchedBorder());
                 downPanel.getLabel().setPreferredSize(new Dimension(400,40));
                 upPanel.getLabel().setPreferredSize(new Dimension(400,40)); 
                slidewinPanel.getLabel().setPreferredSize(new Dimension(440,30)); 
                downPanel.getTextField().setPreferredSize(new Dimension(100,30));
                upPanel.getTextField().setPreferredSize(new Dimension(100,30)); 
               slidewinPanel.getTextField().setPreferredSize(new Dimension(100,30));
             
             //  lst3.setHorizontalAlignment(JTextField.CENTER);
               
               upPanel.getTextField().setHorizontalAlignment(JTextField.CENTER);
               downPanel.getTextField().setHorizontalAlignment(JTextField.CENTER);
               slidewinPanel.getTextField().setHorizontalAlignment(JTextField.CENTER);
               
                
                
//                upPanel.getTextField().setInputVerifier (new InputVerifier(){
//                	public boolean verify(JComponent comp){
//                		JTextField field=(JTextField)comp;
//                		boolean passed=false;
//                		try{
//                			int n=Integer.parseInt(field.getText());
//                			passed=(1<=n);               			
//                		}catch(NumberFormatException e){}
//                		if(! passed){
//                		comp.getToolkit().beep();
//                		field.selectAll();
//                		}
//                		return passed;
//                	}
//                });

                InputVerifier verifier = new InputVerifier() {
                	public boolean verify(JComponent comp){
                		JTextField field=(JTextField)comp;
                		boolean passed=false;
                		try{
                			int n=Integer.parseInt(field.getText());
                			passed=(1<=n);               			
                		}catch(NumberFormatException e){}
                		if(! passed){
                		comp.getToolkit().beep();
                		field.selectAll();
                		}
                		return passed;
                	}
                };
                upPanel.getTextField().setInputVerifier(verifier);
                downPanel.getTextField().setInputVerifier(verifier);
                slidewinPanel.getTextField().setInputVerifier(verifier);
                lst3.setInputVerifier(new InputVerifier(){
                	public boolean verify(JComponent comp){
                		JTextField field=(JTextField)comp;
                		boolean passed=false;
                		try{
                			int n=Integer.parseInt(field.getText());
                			int temp=getkmer();
                			int temp1=(int) Math.pow(4, temp);
                			passed=(1<=n&& n<=temp1);      
                		}catch(NumberFormatException e){}
                		if(! passed){
                		comp.getToolkit().beep();
                		field.selectAll();
                        }
                		return passed;
                }});
                
                ShowMovedDottedLine show = new ShowMovedDottedLine();
                ShowMovedDottedLine show1 = new ShowMovedDottedLine();
                ShowMovedDottedLine show2 = new ShowMovedDottedLine();
                show.setBackground(new Color(235,244,252));
                show.setPreferredSize(new Dimension(600,5));
                show1.setBackground(new Color(235,244,252));
                show1.setPreferredSize(new Dimension(600,5)); 
                show2.setBackground(new Color(235,244,252));
                show2.setPreferredSize(new Dimension(600,5));              
                
                jpanel1.add(this.JcomboPane);
                jpanel1.add(panels);
                //jpanel1.add(show);               
                jpanel1.setPreferredSize(new Dimension(575,175));
               TitledBorder border=BorderFactory.createTitledBorder( "IST-LFS");
               border.setTitleFont(new Font("IST-LFS",Font.ITALIC,12)); 
               border.setTitleColor(Color.BLUE);
                jpanel1.setBorder(border);
                
                

                JLabel kb=new JLabel("kb");
                JLabel kb2=new JLabel("kb");
                upPanel2.add(upPanel);
                upPanel2.add(kb);
                upPanel2.setLayout(new FlowLayout(0));
                upPanel2.setBackground(new Color(235,244,252));
              //  upPanel2.setPreferredSize(new Dimension(560,40));
                
                downPanel2.add(downPanel);
                downPanel2.add(kb2);
                downPanel2.setLayout(new FlowLayout(0));
                downPanel2.setBackground(new Color(235,244,252));
            //    downPanel2.setPreferredSize(new Dimension(560,40));
                
                
                
                jpanel2.add(cb1);
                jpanel2.add(upPanel2);
                jpanel2.add(downPanel2);
               // jpanel2.add(slidewinPanel);
                jpanel2.setPreferredSize(new Dimension(575,170));
                TitledBorder border2=BorderFactory.createTitledBorder("CG-MJSD");
                border2.setTitleFont(new Font("CG-MJSD",Font.ITALIC,12)); 
                border2.setTitleColor(Color.BLUE);
                 jpanel2.setBorder(border2);
                 jpanel1.setBackground(new Color(235,244,252));
                 jpanel2.setBackground(new Color(235,244,252));
                jpanel1.setLayout(new FlowLayout(0));
                jpanel2.setLayout(new FlowLayout(0));
                temp.setPreferredSize(new Dimension(575,20));
                
               getContentPane().add(this.title1); 
               getContentPane().add(this.title2); 
               getContentPane().add(show1);
               getContentPane().add(jpanel1);  
               getContentPane().add(show);
               getContentPane().add(jpanel2);
               getContentPane().add(show2);
               getContentPane().add(temp);
               getContentPane().add(this.buttons);
/*     */      
/* 167 */     getContentPane().setLayout(new FlowLayout(0));
/*     */   // ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
/* 170 */     
              this.JcomboPane.setBackground(new Color(235,244,252));
              cb1.setBackground(new Color(235,244,252));
              this.buttons.setBackground(new Color(235,244,252));
              getContentPane().setBackground(new Color(235,244,252));
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
/* 191 */         //System.out.println("OK");
/*     */         try
/*     */         {
/* 194 */            FirstStepDialog.this.updateSettings();

	             ((ISEWMainFrame) FirstStepDialog.this.owner).setff1();
	
/*     */         } catch (NumberFormatException localNumberFormatException) {
/* 196 */           JOptionPane.showMessageDialog(null, "Please enter a valid number!   " + localNumberFormatException.getMessage(), "Error", 0);
/*     */         }
               
/*     */       }
/* 199 */       else if (str.equals("Cancel")) {
	                 FirstStepDialog.this.lst1.setSelectedIndex(2);
	                 FirstStepDialog.this.lst2.setSelectedIndex(4);
	                 lst3.setText("256");
	                 FirstStepDialog.this.lst4.setSelectedIndex(1);
	                 FirstStepDialog.this.lst5.setSelectedIndex(0);
	                 FirstStepDialog.this.panels.getJSlider().setValue(1);
	                 FirstStepDialog.this.panels.setText(Double.toString(0.01));
	                 upPanel.getTextField().setText(Integer.toString(5));
	                 downPanel.getTextField().setText(Integer.toString(5));
	                 slidewinPanel.getTextField().setText(Integer.toString(canshu_slidewin));
	                 
/*     */       }
/*     */     }
/*     */   }

			public class  handler1 implements ItemListener{
				public void itemStateChanged(ItemEvent e)
				{
					if (e.getSource()==lst1)
						FirstStepDialog.this.canshu_kmer=Integer.parseInt((lst1.getSelectedItem()).toString());
					if (e.getSource()==lst2){
					if (((lst2.getSelectedItem()).toString()).equals("default")==true)
						FirstStepDialog.this.canshu_diedai=8;
				   else
						FirstStepDialog.this.canshu_diedai=Integer.parseInt((lst2.getSelectedItem()).toString());

					}
					if (e.getSource()==lst4){
						FirstStepDialog.this.canshu_eyewin=Integer.parseInt((lst4.getSelectedItem()).toString());
				}
					if (e.getSource()==lst5){
						FirstStepDialog.this.canshu_ww=Integer.parseInt((lst5.getSelectedItem()).toString());
				}	
			}
			}
			public class handler2 implements ItemListener{
				public void  itemStateChanged(ItemEvent e) {
				  Object source = e.getItemSelectable();
				if(source==cb1){
					//System.out.println("5");
					//getContentPane().add(FirstStepDialog.this.buttons);
					enableFileSelection(true);
					isbound=true;
					//FirstStepDialog.this.buttons.setVisible(true);
				}
				
				 if(e.getStateChange() == ItemEvent.DESELECTED)
				 {
					 enableFileSelection(false);
					 isbound=false;
					 //FirstStepDialog.this.buttons.setVisible(false);
			     }
				}
			}	
			
//			/*     */   private class TextFieldListener
//			/*     */     implements DocumentListener
//			/*     */   {
//			/*     */     public void changedUpdate(DocumentEvent paramDocumentEvent)
//			/*     */     {
//			           if(  paramDocumentEvent.getDocument()== lst3.getDocument())
//			                         System.out.println(lst3.getText());
//			           if(  paramDocumentEvent.getDocument()== upPanel.getTextField().getDocument())
//			        	             System.out.println(77);
//			/* 190 */       
//			/*     */     }
//			/*     */ 
//			/*     */     public void removeUpdate(DocumentEvent paramDocumentEvent) {
//			               	 if(  paramDocumentEvent.getDocument()== lst3.getDocument())
//                System.out.println(lst3.getText());
//			                 if(  paramDocumentEvent.getDocument()== upPanel.getTextField().getDocument())
//		        	             System.out.println(77);
//			/*     */     }
//			/*     */ 
//			/*     */     public void insertUpdate(DocumentEvent paramDocumentEvent) {
//		        		 if(  paramDocumentEvent.getDocument()== lst3.getDocument())
//                    System.out.println(lst3.getText());
//		        		   if(  paramDocumentEvent.getDocument()== upPanel.getTextField().getDocument())
//		        	             System.out.println(77);
//			/*     */     }
//			/*     */   }
				
				
			
			
}












/*     */ 

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     gui.AllOptionDialog
 * JD-Core Version:    0.5.3
 */
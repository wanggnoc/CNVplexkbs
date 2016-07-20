          import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
/*     */ import java.io.PrintStream;

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
/*     */ import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.math.BigDecimal;  
/*     */ public class AllStepDialog extends JDialog
/*     */ {
	 		private JPanel  JcomboPane=new JPanel();
	 		private JPanel  JcomboPane1=new JPanel();
	 		private JPanel  JcomboPane2=new JPanel();	
	 		private JPanel  JcomboPane3=new JPanel();	
	 		private JPanel  JcomboPane4=new JPanel();	
	 		private JPanel  upPanel2=new JPanel();	
	 		private JPanel  downPanel2=new JPanel();		 		
	 		private JPanel zj=new JPanel();
/*  30 */   private JPanel buttons = new JPanel();
/*     */   private LabelTextFieldSlider panels=new LabelTextFieldSlider("Time standard error","0.05",0.0D,1.0D);
			private LabelTextFieldSlider panels2=new LabelTextFieldSlider("Time standard error","0.3",0.0D,1.0D);
/*  36 */   private MyButton ok = new MyButton(" OK");
/*     */   private ImageIcon tu1=new ImageIcon(this.getClass().getResource("/images/name2.gif"));
            private JLabel title1=new JLabel();
            private JLabel title2=new JLabel();
            private JLabel temp1=new JLabel();
/*  38 */   private MyButton cancel = new MyButton("Reset");
/*     */   private JFrame owner;
            private JComboBox lst1;
            private JComboBox lst2;
            private JTextField lst3;
            private JComboBox lst5;
            private JComboBox lst4;
            private JComboBox lst21;
            private JComboBox lst22;
            private JComboBox lst23;
            private JComboBox lst24;
            private JComboBox lst25;
            private JCheckBox cb1;
            private JCheckBox cb2;
            private Object kmer[]={"2","3","4","5"};
            private Object diedai[]={"1","2","3","4","5","6","7","8","9","10"};
            private Object width[]={"1","2","3","4","5"};
            private Object eyewin[]={"1","2","3","4","5","6"};
            private Object gisizemin[]={"1kb","2kb","3kb","4kb","5kb","6kb","7kb","8kb","9kb","10kb"};//"11","12","13","14","15","16","17","18","19","20"};
            private Object diedai1[]={"1","2","3","4","5","6","7","8","9","10"};
            private Object coresize[]={"1","2","3","4","5"};
            private Object ww[]={"1","2","3","4","5"};
            private Object scalesize[]={"5","10","15","20","25","30","35","40","45","50"};
            private JLabel lb1=new JLabel("Word size:");
            private JLabel lb2=new JLabel("Iteration time:");
            private JLabel lb3=new JLabel("Core feature size:");
            private JLabel lb4=new JLabel("Eye window size:");
            private JLabel lb5=new JLabel("Transformed window:");
            private JLabel lb22=new JLabel("Minimum GI size:");
         //   private JLabel lb22=new JLabel("Iteration time:");
         //   private JLabel lb23=new JLabel("Dynamic feature size:");
            private JLabel lb21=new JLabel("Total scale:");
       //   private JLabel lb24=new JLabel("Time standard error:");  
            private int canshu_kmer;
            private int canshu_diedai;
            private int canshu_eyewin;
            private int canshu_upstream;
            private int canshu_downstream;
            private int canshu_slidewin;
            private int canshu_feasize;
            private int canshu_lslidewin;
            private int canshu_diedai1;
            private int canshu_coresize;
            private int canshu_ww;
            private int canshu_neib;
            private int intera=5;
            private int canshu_scal;
            private int canshu_gisize;
         //   private int slidestep=10;
         //   private int dynamic=5;
            private int scal=30;
            private int gisize=10;
         //   private boolean isbound;
            private boolean isbound1;
            private LabelTextField upPanel = new LabelTextField("Upstream of 'raw' genomic islands:", "");
            private LabelTextField downPanel = new LabelTextField("Downstream of 'raw' genomic islands:", "");
            private LabelTextField slidewinPanel = new LabelTextField("Sliding window size:", "");

            public AllStepDialog(JFrame paramJFrame)
            {
              
              super(paramJFrame, "MTGIpick", true);
              this.owner = paramJFrame;
     
              initialize();
            }
   
            public AllStepDialog(JFrame paramJFrame , int scall,int gisizee)
            {
              super(paramJFrame, "MTGIpick", true);
              this.owner = paramJFrame;
             this.scal=scall;this.gisize=gisizee;
              initialize();
            }

            public AllStepDialog(JFrame paramJFrame , int scall,int gisizee,int large)
            {
              super(paramJFrame, "MTGIpick", true);
              this.owner = paramJFrame;
              this.scal=scall;this.gisize=gisizee;
              initialize();
            }

            

			public double getsig()
            {
            	return(Double.parseDouble(this.panels.getText()));
            }
            
            public double getsig2()
            {
            	return(Double.parseDouble(this.panels2.getText()));
            }
            
            
            public int getkmer()
            {
            	return  this.canshu_kmer;
            	
            }
            
            public int getww()
            {
            	return this.canshu_ww;
            }
            
            public int getneib()
            {
            	return this.canshu_neib;
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
            
            public int getscal()
            {
            	return this.canshu_scal;
            	
            } 
            
            public int getgisize()
            {
            	return this.canshu_gisize;
            	
            } 
            
            public int getdiedai1()
            {
            	return this.canshu_diedai1;
            	
            } 
            
            public int getcoresize()
            {
            	return this.canshu_coresize;
            	
            } 
            
           
//            public boolean getisbound()
//            {
//            	return this.isbound;
//            }
            
            public boolean getisbound1()
            {
            	return this.isbound1;
            }
            
//            private void enableFileSelection(boolean paramBoolean)
//            /*     */   {
//               this.lst21.setEnabled(paramBoolean);
//               this.lst22.setEnabled(paramBoolean);
//           	   this.lst23.setEnabled(paramBoolean);
//           	   this.panels2.getTextField().setEnabled(paramBoolean);
//           	   this.panels2.getJSlider().setEnabled(paramBoolean);	
//            }
            
            private void enableFileSelection2(boolean paramBoolean)
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
                	   if (this.isbound1==true){
                       this.canshu_upstream=Integer.parseInt( upPanel.getTextField().getText())*1000;
                       this.canshu_downstream=Integer.parseInt(downPanel.getTextField().getText())*1000;
                       this.canshu_slidewin=Integer.parseInt(slidewinPanel.getTextField().getText());	
                	   }
                	   
    //            	 if (this.isbound==true) {
                	        double sig2= Double.parseDouble(this.panels2.getText());
         		           BigDecimal sig21 = new BigDecimal(sig2); 
         		           BigDecimal data21 = new BigDecimal(0.0D); 
         		           BigDecimal data22 = new BigDecimal(1.0D);  
         		          if (sig21.compareTo(data21)<0 || data22.compareTo(sig21)<0)
                       JOptionPane.showMessageDialog(null, "Please enter a valid number! " + sig21, "Error", 0);	 
    //            	 } 
                	 
	             double sig= Double.parseDouble(this.panels.getText());
		           BigDecimal sig1 = new BigDecimal(sig); 
		           BigDecimal data1 = new BigDecimal(0.0D); 
		           BigDecimal data2 = new BigDecimal(1.0D); 

		
	              if (sig1.compareTo(data1)<0 || data2.compareTo(sig1)<0)
		           JOptionPane.showMessageDialog(null, "Please enter a valid number! " + sig1, "Error", 0);
		          else if (this.canshu_feasize<1 || this.canshu_feasize>Math.pow(4, canshu_kmer))
	                JOptionPane.showMessageDialog(null, "The size of core feature size should between 1 and 4^(word size)!   " + this.canshu_feasize, "Error", 0);
                  else if( (this.isbound1==true && this.canshu_upstream<0) || (this.isbound1==true && this.canshu_downstream<0) || (this.isbound1==true && this.canshu_slidewin<0) )
                       JOptionPane.showMessageDialog(null, "The part of CG-MJSD should be put positive numbers!   " , "Error", 0);
		          else
                       setVisible(false);
		             }
	                   catch (NumberFormatException localNumberFormatException) {
		                      throw localNumberFormatException;
		                }
		           }


   private void initialize()
         {
    this.canshu_kmer=4;
    this.canshu_ww=1;
    this.canshu_neib=4;
    this.canshu_diedai=this.intera;
    this.canshu_eyewin=5;
    this.canshu_feasize=256;
    this.canshu_upstream=5;
    this.canshu_downstream=5;
    this.canshu_slidewin=100;
   // this.canshu_lslidewin=this.slidestep;
    this.canshu_scal=scal;
    this.canshu_gisize=gisize*1000;
    this.canshu_diedai1=10;
    //this.canshu_coresize=this.dynamic;
  //  this.isbound=true;
    this.isbound1=false;
    ShowMovedDottedLine show = new ShowMovedDottedLine();
    ShowMovedDottedLine show1 = new ShowMovedDottedLine();
    ShowMovedDottedLine show2 = new ShowMovedDottedLine();
    show.setBackground(new Color(235,244,252));
    show.setPreferredSize(new Dimension(600,1));
    show1.setBackground(new Color(235,244,252));
    show1.setPreferredSize(new Dimension(600,1)); 
    show2.setBackground(new Color(235,244,252));
    show2.setPreferredSize(new Dimension(600,1));           
          	this.tu1.setImage(tu1.getImage().getScaledInstance(600, 40, Image.SCALE_DEFAULT));
	        this.title1.setIcon(tu1);
	        this.ok.setPreferredSize(new Dimension(65,28));
	   	    this.cancel.setPreferredSize(new Dimension(65,28));
	        this.temp1.setPreferredSize(new Dimension(70,28));
	        this.buttons.add(this.temp1);
/* 126 */   this.buttons.add(this.ok);
/* 127 */   this.buttons.add(this.cancel);
            this.buttons.setBackground(new Color(235,244,252));
/*     */   this.buttons.setLayout(new FlowLayout(1,60,0));
             lst1=new JComboBox(kmer);  
             lst2=new JComboBox(diedai);
             lst3=new JTextField();
             lst3.setText("256");
             lst4=new JComboBox(eyewin);
             lst5=new JComboBox(ww);
             lst21=new JComboBox(scalesize);  
             lst22=new JComboBox(gisizemin);
         //  lst24=new JComboBox(delewin);
           cb1=new JCheckBox("Iteration Accumulative Score Method based on Dynamic Signal from Sliding Windows");
             cb2=new JCheckBox("Boundary Detection");
            cb1.setSelected(true);
             cb2.setSelected(false);
             enableFileSelection2(false);
             cb2.setBackground(new Color(235,244,252));
            cb1.setBackground(new Color(235,244,252));    
             lst2.setMaximumRowCount(4);
             lst1.setSelectedIndex(2);
             lst2.setSelectedIndex(intera-1);
             //lst3.setSelectedIndex(0);
             lst4.setSelectedIndex(4);
             lst5.setSelectedIndex(0);
             lst21.setSelectedIndex(this.scal/5-1);
             lst22.setSelectedIndex(this.gisize-1);

/* 130 */     this.ok.setActionCommand("OK");
/* 131 */     this.cancel.setActionCommand("Cancel");
/*     */ 
/* 134 */     this.ok.addActionListener(new CoreOptionsDialogListener());
/* 135 */     this.cancel.addActionListener(new CoreOptionsDialogListener());
/*     */     this.lst1.addItemListener(new handler1()); 
              this.lst2.addItemListener(new handler1()); 
              this.lst4.addItemListener(new handler1()); 
              this.lst5.addItemListener(new handler1()); 
              this.lst21.addItemListener(new handler1()); 
              this.lst22.addItemListener(new handler1()); 
  //            this.lst23.addItemListener(new handler1());             
  //            this.lst25.addItemListener(new handler1()); 
 //             this.cb1.addItemListener(new handler2());
              this.cb2.addItemListener(new handler3());
              
/* 138 */     this.ok.setToolTipText("Save settings");
/* 139 */     this.cancel.setToolTipText("Reset");

              upPanel.getTextField().setText(Integer.toString(canshu_upstream));
             downPanel.getTextField().setText(Integer.toString(canshu_downstream));
             slidewinPanel.getTextField().setText(Integer.toString(canshu_slidewin));   
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

                 //this.lb21.setPreferredSize(new Dimension(200,18));
                // this.lst21.setPreferredSize(new Dimension(50,18));
			     
                 JcomboPane.add(lb1);JcomboPane.add(this.lst1);
                 JcomboPane.add(lb5);
                 JcomboPane.add(this.lst5);
                 JcomboPane.add(lb2);JcomboPane.add(this.lst2);
                 JcomboPane.add(lb3);JcomboPane.add(this.lst3);
                 JcomboPane.add(lb4);JcomboPane.add(this.lst4);
                 JcomboPane.setBackground(new Color(235,244,252));
                 JcomboPane.setLayout(new GridLayout(3,2,5,5));
                 JcomboPane.setPreferredSize(new Dimension(555,85));
                 JcomboPane1.add(JcomboPane);
                 JcomboPane1.add(panels);
                 JcomboPane1.setPreferredSize(new Dimension(575,160));
                 TitledBorder border=BorderFactory.createTitledBorder("IST-LFS");
                 border.setTitleFont(new Font("IST-LFS",Font.ITALIC,12)); 
                 border.setTitleColor(Color.BLUE);
                 JcomboPane1.setBorder(border);
                 JcomboPane1.setBackground(new Color(235,244,252));
                 JcomboPane1.setLayout(new FlowLayout(0));
                 
                 //JcomboPane3.add(this.cb2);
                // this.lb21.setPreferredSize(new Dimension(lb1.getWidth(),lb1.getHeight()));
               //  this.lb22.setPreferredSize(new Dimension(lb1.getWidth(),lb1.getHeight()));
                 this.lst21.setPreferredSize(new Dimension(lst1.getWidth(),lst1.getHeight()));
                 this.lst22.setPreferredSize(new Dimension(lst1.getWidth(),lst1.getHeight()));
                 
                  JcomboPane2.add(lb21); JcomboPane2.add(this.lst21);
                 JcomboPane2.add(lb22); JcomboPane2.add(this.lst22);
                 JcomboPane2.setPreferredSize(new Dimension(555,28));
                 // this.lb1.setPreferredSize(new Dimension(25,lb1.getHeight()));
              //   JcomboPane2.add(lb22); JcomboPane2.add(this.lst22);
              //   JcomboPane2.add(lb23); JcomboPane2.add(this.lst23);
                
                 
                 JcomboPane2.setBackground(new Color(235,244,252)); 
               JcomboPane2.setLayout(new GridLayout(1,2,5,5));
           //      JcomboPane2.setLayout(new FlowLayout(1,4,0));
                // JcomboPane.setBorder(BorderFactory.createEtchedBorder());
             //  JcomboPane3.add(cb1);
                JcomboPane3.add(JcomboPane2);
                JcomboPane3.add(panels2);
                JcomboPane3.setLayout(new FlowLayout(0));
                JcomboPane3.setPreferredSize(new Dimension(575,110));
                JcomboPane3.setBackground(new Color(235,244,252));    
                TitledBorder border1=BorderFactory.createTitledBorder("MSA");
                border1.setTitleFont(new Font("MSA",Font.ITALIC,12)); 
                border1.setTitleColor(Color.BLUE);
                JcomboPane3.setBorder(border1);
                

                 downPanel.getLabel().setPreferredSize(new Dimension(410,25));
                 upPanel.getLabel().setPreferredSize(new Dimension(410,25)); 
                slidewinPanel.getLabel().setPreferredSize(new Dimension(440,25)); 
                downPanel.getTextField().setPreferredSize(new Dimension(100,25));
                upPanel.getTextField().setPreferredSize(new Dimension(100,25)); 
               slidewinPanel.getTextField().setPreferredSize(new Dimension(90,25)); 
                 upPanel.getTextField().setHorizontalAlignment(JTextField.CENTER);
                downPanel.getTextField().setHorizontalAlignment(JTextField.CENTER);
                slidewinPanel.getTextField().setHorizontalAlignment(JTextField.CENTER);
                
                JLabel kb=new JLabel("kb");
                JLabel kb2=new JLabel("kb");
            //    kb.setPreferredSize(new Dimension(30,25)); 
                upPanel2.add(upPanel);
                upPanel2.add(kb);
                upPanel2.setLayout(new FlowLayout(0));
                upPanel2.setBackground(new Color(235,244,252));
                upPanel2.setPreferredSize(new Dimension(560,40));
                
                downPanel2.add(downPanel);
                downPanel2.add(kb2);
                downPanel2.setLayout(new FlowLayout(0));
                downPanel2.setBackground(new Color(235,244,252));
                downPanel2.setPreferredSize(new Dimension(560,40));
                
                JcomboPane4.add(cb2);
                JcomboPane4.add(upPanel2);
                JcomboPane4.add(downPanel2);
             //   JcomboPane4.add(slidewinPanel);
                JcomboPane4.setPreferredSize(new Dimension(575,150));
                TitledBorder border2=BorderFactory.createTitledBorder("CG-MJSD");
                border2.setTitleFont(new Font("CG-MJSD",Font.ITALIC,12)); 
                border2.setTitleColor(Color.BLUE);
                JcomboPane4.setBorder(border2);
                JcomboPane4.setBackground(new Color(235,244,252));
                JcomboPane4.setLayout(new FlowLayout(0));
               
               getContentPane().add(this.title1);   
               getContentPane().add(show);
               getContentPane().add(this.JcomboPane1);  
               getContentPane().add(show1);
               getContentPane().add(this.JcomboPane3);
               getContentPane().add(show2);
               getContentPane().add(this.JcomboPane4);
               getContentPane().add(this.buttons);
/*     */               setSize(600, 580);
Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2);
   
/* 167 */     setLayout(new FlowLayout(0));
/*     */    ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 3));
/* 170 */ 
              getContentPane().setBackground(new Color(235,244,252));

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
/* 191 */       
/*     */         try
/*     */         {

/* 194 */            AllStepDialog.this.updateSettings();
   //                  if(AllStepDialog.this.isbound==true)
                         ( (ISEWMainFrame)AllStepDialog.this.owner).setff2();
  //                   else	 
  //                  	 ((ISEWMainFrame) AllStepDialog.this.owner).setff1();
                     
                     
/*     */         } catch (NumberFormatException localNumberFormatException) {
/* 196 */           JOptionPane.showMessageDialog(null, "Please enter a valid number!   " + localNumberFormatException.getMessage(), "Error", 0);
/*     */         }
               
/*     */       }
/* 199 */       else if (str.equals("Cancel")) {
/* 200 */        
/* 201 */           lst1.setSelectedIndex(2);
lst2.setSelectedIndex(intera-1);
//lst3.setSelectedIndex(0);
lst4.setSelectedIndex(4);
lst5.setSelectedIndex(3);
lst21.setSelectedIndex(5);
lst22.setSelectedIndex(9);
//lst23.setSelectedIndex(4);
//lst25.setSelectedIndex(3);
lst3.setText("256");
panels.setText(Double.toString(0.05));
panels2.setText(Double.toString(0.3));
upPanel.getTextField().setText(Integer.toString(5));
downPanel.getTextField().setText(Integer.toString(5));
/*     */       }
/*     */     }
/*     */   }

			public class  handler1 implements ItemListener{
				public void itemStateChanged(ItemEvent e)
				{
					if (e.getSource()==lst1)
						AllStepDialog.this.canshu_kmer=Integer.parseInt((lst1.getSelectedItem()).toString());
					if (e.getSource()==lst2)
						AllStepDialog.this.canshu_diedai=Integer.parseInt((lst2.getSelectedItem()).toString());
                    if (e.getSource()==lst4)
						AllStepDialog.this.canshu_eyewin=Integer.parseInt((lst4.getSelectedItem()).toString());
                    if (e.getSource()==lst5)
                    	AllStepDialog.this.canshu_ww=Integer.parseInt((lst5.getSelectedItem()).toString());	
                    if (e.getSource()==lst25)
                    	AllStepDialog.this.canshu_neib=Integer.parseInt((lst25.getSelectedItem()).toString());	
                    if (e.getSource()==lst21)
						AllStepDialog.this.canshu_scal=Integer.parseInt((lst21.getSelectedItem()).toString());
                    if (e.getSource()==lst22){
  
 						AllStepDialog.this.canshu_gisize=(lst22.getSelectedIndex()+1)*1000;
                    }
                    if (e.getSource()==lst23)
 						AllStepDialog.this.canshu_coresize=Integer.parseInt((lst23.getSelectedItem()).toString());
                     
					  
				}
					
			}

			
//			public class handler2 implements ItemListener{
//				public void  itemStateChanged(ItemEvent e) {
//				  Object source = e.getItemSelectable();
//				if(source==cb1){
//					enableFileSelection(true);
//					isbound=true;
//				}
//				 if(e.getStateChange() == ItemEvent.DESELECTED)
//				 {
//					 enableFileSelection(false);
//					 isbound=false;
//			     }
//				}
//			}	
			
			public class handler3 implements ItemListener{
				public void  itemStateChanged(ItemEvent e) {
				  Object source = e.getItemSelectable();
				if(source==cb2){
					enableFileSelection2(true);
					isbound1=true;
				
				}
				 if(e.getStateChange() == ItemEvent.DESELECTED)
				 {
					 enableFileSelection2(false);
					 isbound1=false;
					// System.out.println(isbound1);
			     }
				}
			}
			
			
}












/*     */ 

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     gui.CoreOptionsDialog
 * JD-Core Version:    0.5.3
 */
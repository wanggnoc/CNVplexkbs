		  import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
import java.awt.GridLayout;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;





 public class notee extends JDialog
 {
	 public JFrame owner;
	 private ImageIcon mainframeIcon=new ImageIcon(this.getClass().getResource("/images/right.png"));
	 private JLabel warn1=new JLabel("数据分析完成，是否打开文件?");
     private JLabel warn2=new JLabel("ok");
    
      private JLabel warn4=new JLabel(" After clicking OK button, a View button will appear between Predict and Help button. If the View");
      private JLabel warn5=new JLabel(" button does not work, open html files in the same directory where the input file is stored, and ");
      private JLabel warn6=new JLabel(" view the predicted GIs with conserved scores directly.");
	 private MyButton okk= new MyButton("是");
     private MyButton cancell=new MyButton("否");
  
	 private JLabel info =null; 
   private JPanel buttons = new JPanel();
   private JPanel labels = new JPanel();
   public String openFile;
	 public notee(JFrame paramJFrame,String fillo)
	 /*     */   {
	 /*  44 */     super(paramJFrame,"数据分析完成，是否打开文件?",true);
	 /*     */ this.owner = paramJFrame;
	 setIconImage(this.mainframeIcon.getImage());
	 /*  46 */     setSize(300, 80);
	 /*  47 */     Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
	 /*  48 */     setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2);
	 /*     */ this.openFile=fillo;
	    initialize();
	   }
	 private void initialize()
	 /*     */   {

	 /*  66 */     this.okk.setPreferredSize(new Dimension(65,27));
	 			   this.okk.setBorderPainted(false);
	 			  
	 			  this.cancell.setPreferredSize(new Dimension(65,27));
	 			   this.cancell.setBorderPainted(false);
	 			   
	 			   this.labels.setLayout(new GridLayout(6,1));
	 			   //this.labels.add(this.warn1);
	 	
	 			  
	 			   this.buttons.add(this.okk);  
	 			   this.buttons.add(this.cancell);
	 			   this.buttons.setLayout(new FlowLayout(1,30,0));
	 			   
	               this.buttons.setBackground(Color.WHITE);

	               this.labels.setBackground(Color.WHITE);
	               
             	  this.cancell.addActionListener(new OkActionListener());
	               this.okk.addActionListener(new OkActionListener());
	              
	 /*     */ 
	               this.okk.setActionCommand("okk");
	          	   this.cancell.setActionCommand("cancell");
	               
	 /*  77 */     //getContentPane().add(this.labels, "Center");
	 /*  78 */     getContentPane().add(this.buttons);
	 /*     */   }
	 /*     */ 
	 /*     */   private class OkActionListener
	 /*     */     implements ActionListener
	 /*     */   {
	

	/*     */     public void actionPerformed(ActionEvent paramActionEvent)
	 /*     */     {
		       String str = paramActionEvent.getActionCommand();
		 /*     */ 
		 /* 104 */       if (str.equals("okk"))
		 /*     */       {
	 /* 127 */       notee.this.setVisible(false);
	                try {
	                	Desktop.getDesktop().open(new File(notee.this.openFile));
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 /*     */     }
		           if ((str.equals("cancell")))
		           {
		        	   
		        	    notee.this.setVisible(false);
		        	   
		           }
	}
	
	
	 /*     */   }
	 
//	 /*     */   private class CancelActionListener
//	 /*     */     implements ActionListener
//	 /*     */   {
//	 /*     */     public void actionPerformed(ActionEvent paramActionEvent)
//	 /*     */     {
//
//	 /* 127 */      
//	 /*     */     }
//	 /*     */   }
	 
	 
	 
	 
	 
	 /*     */ }


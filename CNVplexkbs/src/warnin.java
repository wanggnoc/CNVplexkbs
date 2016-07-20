
/*     */ import java.awt.Color;
import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
import java.awt.Insets;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;






 public class warnin extends JDialog
 {
	 private JFrame owner;
	 private ImageIcon mainframeIcon=new ImageIcon(this.getClass().getResource("/images/war.png"));
	// private MyButton choose1 = new MyButton("Assemble and predict!");
	//private MyButton choose2 = new MyButton("Predict each seqence separately!");
	 private JLabel info =null; 
	 private MyButton okk= new MyButton("OK");
   private JPanel buttons = new JPanel();
   private JPanel labels = new JPanel();
   private String ErrA="";
	 public warnin(JFrame paramJFrame,String erra)
	 /*     */   {
	 /*  44 */     super(paramJFrame,"Noting",true);
	 /*     */ this.owner = paramJFrame;
	 setIconImage(this.mainframeIcon.getImage());
	 /*  46 */     setSize(600, 110);
	 /*  47 */     Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
	 /*  48 */     setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2);
	 /*     */ ErrA=erra;
	    initialize();
	   }
	 private void initialize()
	 /*     */   {
		 if(!(ErrA==null))
		  {info=new JLabel("正常对照样本有问题，探针"+ErrA+"不存在，程序停止运行，请核对后重新运行！");
		  }else{
		   info=new JLabel("正常对照样本有问题，CONTROL组出现空探针，程序停止运行，请核对后重新运行！");
		  }
		  /*  66 */     this.okk.setPreferredSize(new Dimension(65,27));
			   this.okk.setBorderPainted(false);
		//  this.choose1.setFocusPainted(false);
		 // this.choose1.setMargin(new Insets(0,0,0,0));
		//  this.choose1.setContentAreaFilled(false);
		//  this.choose2.setContentAreaFilled(false);
		//  this.choose1.setBorderPainted(false);
	 /*  66 */ //    this.choose1.setPreferredSize(new Dimension(260,26));
	           //    this.choose2.setPreferredSize(new Dimension(260,26));
	 			   this.labels.add(this.info);
	 /*  67 */  //   this.buttons.add(this.choose1);
	 /*  68 */   //  this.buttons.add(this.choose2);
	 /*  69 */     this.buttons.setLayout(new FlowLayout(1));
	               this.buttons.setBackground(Color.WHITE);
	               this.buttons.add(this.okk);  
	 /*  72 */   //  this.choose1.setActionCommand("choo1");
	 /*  73 */   //  this.choose2.setActionCommand("choo2");
	             //  this.choose1.setBackground(new Color(235,244,252));
	             //  this.choose2.setBackground(new Color(235,244,252));
	               this.labels.setBackground(Color.WHITE);
	               this.okk.addActionListener(new OkActionListener());
	 /*  74 */   //  this.choose1.addActionListener(new ButtonLeisteActionListener());
	 /*  75 */   //  this.choose2.addActionListener(new ButtonLeisteActionListener());
	 /*     */ 
	 /*  77 */     getContentPane().add(this.labels, "Center");
	 /*  78 */     getContentPane().add(this.buttons, "South");
	 /*     */   }
	 /*     */ 
	 /*     */   private class ButtonLeisteActionListener implements ActionListener
	 /*     */  
	 /*     */   {
	 /*     */     public void actionPerformed(ActionEvent paramActionEvent)
	 /*     */     {
	 /* 102 */       String str = paramActionEvent.getActionCommand();
	 /*     */ 
	 /* 104 */       if (str.equals("choo1"))
	 /*     */       {
		           ((ISEWMainFrame)warnin.this.owner).setm(0);
		           ((ISEWMainFrame)warnin.this.owner).shuchu0();
	 /* 106 */         warnin.this.setVisible(false);
	 /*     */       } else {
	 /* 108 */         if ((str.equals("choo2")))
	 /*     */       ((ISEWMainFrame)warnin.this.owner).setm(1);
	                 ((ISEWMainFrame)warnin.this.owner).shuchu1();
	 /* 110 */         warnin.this.setVisible(false);
	 /*     */       }
	 /*     */     }
	 /*     */   }
	 /*     */   private class OkActionListener
	 /*     */     implements ActionListener
	 /*     */   {
	 /*     */     public void actionPerformed(ActionEvent paramActionEvent)
	 /*     */     {

	 /* 127 */       warnin.this.setVisible(false);
	 /*     */     }
	 /*     */   }
	 /*     */ }


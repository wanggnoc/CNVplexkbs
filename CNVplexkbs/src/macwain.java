		  import java.awt.Color;
import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
import java.awt.GridLayout;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;



public class macwain extends JDialog
{
	 private JFrame owner;
	 private ImageIcon mainframeIcon=new ImageIcon(this.getClass().getResource("/images/war.png"));
	 private JLabel warn1=new JLabel("  Mac does not support DJNativeSwing used for interactive visualization tool and, therefore,");
     private JLabel warn2=new JLabel("does not support interactive visualization of predicted genomic  islands in MTGIpick. ");
	 private JLabel warn3=new JLabel("MTGIpick has generated a number of html files in the same directory where the input file is stored,");
	 private JLabel warn4=new JLabel("you can open them directly and view  the predicted GIs with conserved scores.");
	 private MyButton okk= new MyButton("OK");

	 private JLabel info =null; 
   private JPanel buttons = new JPanel();
   private JPanel labels = new JPanel();
	 public macwain(JFrame paramJFrame)
	 /*     */   {
	 /*  44 */     super(paramJFrame,"Noting",true);
	 /*     */ this.owner = paramJFrame;
	 setIconImage(this.mainframeIcon.getImage());
	 /*  46 */     setSize(600, 200);
	 /*  47 */     Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
	 /*  48 */     setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2);
	 /*     */ 
	    initialize();
	   }
	 private void initialize()
	 /*     */   {

	 /*  66 */     this.okk.setPreferredSize(new Dimension(65,27));
	 			   this.okk.setBorderPainted(false);
	 			  
	 			   this.labels.setLayout(new GridLayout(4,1));
	 			   this.labels.add(this.warn1);
	 			  this.labels.add(this.warn2);
	 			 this.labels.add(this.warn3);
	 			this.labels.add(this.warn4);
	 			  
	 			   this.buttons.add(this.okk);  
	               this.buttons.setBackground(Color.WHITE);

	               this.labels.setBackground(Color.WHITE);
	 
	               this.okk.addActionListener(new OkActionListener());
	 /*     */ 
	 /*  77 */     getContentPane().add(this.labels, "Center");
	 /*  78 */     getContentPane().add(this.buttons, "South");
	 /*     */   }
	 /*     */ 
	 /*     */   private class OkActionListener
	 /*     */     implements ActionListener
	 /*     */   {
	 /*     */     public void actionPerformed(ActionEvent paramActionEvent)
	 /*     */     {

	 /* 127 */       macwain.this.setVisible(false);
	 /*     */     }
	 /*     */   }

}

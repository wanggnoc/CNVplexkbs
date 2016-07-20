
          import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
import java.io.IOException;
/*     */ import java.io.PrintStream;

/*     */ import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class ButtonBar extends JPanel
/*     */ {
	       private ImageIcon icon1=new ImageIcon(this.getClass().getResource("/images/button1.jpg"));
/*  31 */  public  MyButton predict = new MyButton("Predict");
///*  33 */   public MyButton beenden = new MyButton(" View");
            public  MyButton help =new  MyButton("  运行");
            public  MyButton  exist=new MyButton("Exit");
            public  MyButton  helptrue=new MyButton("使用说明 ");
            
            
/*     */   private ISEWMainFrame owner;

/*     */   public ButtonBar(ISEWMainFrame paramISEWMainFrame)
/*     */   {
/*  51 */     this.owner = paramISEWMainFrame;
/*  52 */     initialisierung();
/*     */   }
/*     */ 
/*     */   private void initialisierung()
/*     */   {
	
	//Image temp = icon1.getImage().getScaledInstance(75,28, icon1.getImage().SCALE_DEFAULT);  
	//this.predict.setIcon(new ImageIcon(temp));  
	// this.predict.setPreferredSize(new Dimension(28,28));
	 this.predict.setPreferredSize(new Dimension(75,28));
//	 this.beenden.setPreferredSize(new Dimension(65,28));
	 this.help.setPreferredSize(new Dimension(75,28));
	 this.exist.setPreferredSize(new Dimension(65,28));
	 
	 this.helptrue.setPreferredSize(new Dimension(85,28));
	/*  76 */     this.predict.setActionCommand("Predict");
///*  78 */     this.beenden.setActionCommand("Exit");
/*     */    this.help.setActionCommand("Help");
             this.exist.setActionCommand("ExitT");
             this.helptrue.setActionCommand("Helptrue");

/*  81 */     this.predict.addActionListener(new ButtonLeisteActionListener());
///*  83 */     this.beenden.addActionListener(new ButtonLeisteActionListener());
/*     */    this.help.addActionListener(new ButtonLeisteActionListener());
              this.exist.addActionListener(new ButtonLeisteActionListener());
              this.helptrue.addActionListener(new ButtonLeisteActionListener());
/*     */ 
/*  88 */     this.predict.setToolTipText("Initiates prediction of the selected data.");
///*  93 */     this.beenden.setToolTipText("View the picture of predicted genomic islands.");
/*  97 */   //  add(this.predict);
///*  99 */     add(this.beenden);
              add(this.help);
           //   add(this.exist);
             // add(this.helptrue);
/*     */    
//             beenden.setVisible(false);
              
/* 102 */     setLayout(new FlowLayout(1,30,0));
/* 103 */    // setBorder(BorderFactory.createEtchedBorder());
              setBackground(Color.white);
/*     */   }
/*     */ 
/*     */   public void setEnabledPredict(boolean paramBoolean)
/*     */   {
/* 108 */     this.predict.setEnabled(paramBoolean);
/*     */   }
/*     */ 
/*     */   private class ButtonLeisteActionListener
/*     */     implements ActionListener
/*     */   {


public void actionPerformed(ActionEvent paramActionEvent)
/*     */     {
/* 136 */       String str = paramActionEvent.getActionCommand();
/*     */ 
/* 139 */       if  (str.equals("Predict"))
/*     */       {     
					if (predict.getContext().equals("Predict"))
				    {
				     predict.setContext("Pause");
//					 ButtonBar.this.owner.evaluate();

				
				    }
					else{
					
					ButtonBar.this.owner.stopper();
					predict.setContext("Predict");
					
					}
					
           
/*     */       }
/* 150 */       else if ((str.equals("Exit")))
               {
//	ButtonBar.this.owner.showmacwain(ButtonBar.this.owner);
	
	
    			           	try {
	Writehtml pichtml=new Writehtml(ButtonBar.this.owner);
} catch (IOException e) {
	e.printStackTrace();
}
	ButtonBar.this.owner.showPic(ButtonBar.this.owner);
       //    //ButtonBar.this.owner.exit();
          }
				else if((str.equals("Help")))
				{
					
				
//					 Object localObject;
//					
//				      localObject = new ReadmeDialog(ButtonBar.this.owner);
//				       ((ReadmeDialog)localObject).setVisible(true);
					
					ButtonBar.this.owner.classify();
					
					
					 
				}
				else if((str.equals("Helptrue")))
				{
					
				
					 Object localObject;
				
				      localObject = new ReadmeDialog(ButtonBar.this.owner);
				       ((ReadmeDialog)localObject).setVisible(true);
					
					
					
					
					 
				}
				else if((str.equals("ExitT")))
				{
					
					ButtonBar.this.owner.exit();
					 
				}
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     gui.ButtonBar
 * JD-Core Version:    0.5.3
 */
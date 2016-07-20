 
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class ExitDialog extends JDialog
/*     */ {
/*  24 */   private JButton ok = new JButton("OK");
/*  25 */   private JButton cancel = new JButton("Cancel");
/*  26 */   private JLabel info = new JLabel("Do you really want to exit this application ?");
/*     */ 
/*  29 */   private JPanel buttons = new JPanel();
/*  30 */   private JPanel labels = new JPanel();
/*     */ 
/*     */   public ExitDialog(JFrame paramJFrame)
/*     */   {
/*  44 */     super(paramJFrame, "Exit application", true);
/*     */ 
/*  46 */     setSize(400, 110);
/*  47 */     Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
/*  48 */     setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2);
/*     */ 
/*  51 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*  66 */     this.labels.add(this.info);
/*  67 */     this.buttons.add(this.ok);
/*  68 */     this.buttons.add(this.cancel);
/*  69 */     this.buttons.setLayout(new FlowLayout(1));
/*     */ 
/*  72 */     this.ok.setActionCommand("OK");
/*  73 */     this.cancel.setActionCommand("Cancel");
/*  74 */     this.ok.addActionListener(new ExitActionListener());
/*  75 */     this.cancel.addActionListener(new ExitActionListener());
/*     */ 
/*  77 */     getContentPane().add(this.labels, "Center");
/*  78 */     getContentPane().add(this.buttons, "South");
/*     */   }
/*     */ 
/*     */   private class ExitActionListener
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent paramActionEvent)
/*     */     {
/* 102 */       String str = paramActionEvent.getActionCommand();
/*     */ 
/* 104 */       if (str.equals("OK"))
/*     */       {
	
/* 106 */         System.exit(0);
/*     */       } else {
/* 108 */         if (!(str.equals("Cancel")))
/*     */           return;
/* 110 */         ExitDialog.this.setVisible(false);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     gui.ExitDialog
 * JD-Core Version:    0.5.3
 */
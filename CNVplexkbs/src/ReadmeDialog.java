
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
//import org.apache.pdfbox.pdmodel.PDPage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JViewport;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
/*     */ 
/*     */ public class ReadmeDialog extends JFrame
/*     */ {
/*  27 */   private JEditorPane readmeText = new JEditorPane();
/*  28 */   private MyButton ok = new MyButton("¹Ø±Õ");
/*  29 */   private JPanel buttons = new JPanel();
/*  30 */   private JScrollPane scrollReadmeText = new JScrollPane();
/*     */   private JFrame owner;
private ImageIcon mainframeIcon=new ImageIcon(this.getClass().getResource("/images/zd.png"));
/*     */ //  private PdfDecoder pdfText=new PdfDecoder(); 

/*     */   public ReadmeDialog(JFrame paramJFrame)
/*     */   {
/*  45 */     super("N9002 Readme");
/*     */ setIconImage(this.mainframeIcon.getImage());
/*  47 */     this.owner = paramJFrame;
this.ok.setPreferredSize(new Dimension(65,27));
/* 108 */     setSize(600, 600);
/*  47 */     Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
/*  48 */     setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2);
/*  48 */     initialisierung();
/*     */   }
/*     */ 
/*     */   private void initialisierung()
/*     */   {
/*  62 */     this.ok.addActionListener(new ReadmeActionListener());
/*     */ 
/*  65 */     this.buttons.add(this.ok);
/*     */ 
/*  68 */     getContentPane().add(this.scrollReadmeText, "Center");
/*  69 */     getContentPane().add(this.buttons, "South");
/*     */ 
/*  72 */     URL localURL = null;
/*     */     try
/*     */     {
/*  75 */       localURL = new URL("file:help.htm");
/*     */     }
/*     */     catch (MalformedURLException localMalformedURLException)
/*     */     {
/*  79 */       JOptionPane.showMessageDialog(null, "Unable to read \"readme.txt\" !", "Error", 0);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  89 */       this.readmeText.setPage(localURL);
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/*  93 */       JOptionPane.showMessageDialog(null, "Unable to read \"readme.txt\" !", "Error", 0);
/*     */     }

			
          
///*     */     MyPanel mp=new MyPanel();
//mp.setPreferredSize(new Dimension(714, 1011));
//this.scrollReadmeText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

/* 100 */     this.scrollReadmeText.getViewport().add(this.readmeText);
/* 101 */     this.readmeText.setEditable(false);
     




/* 104 */     this.buttons.setLayout(new FlowLayout(1));
/*     */ 



/*     */   }
/*     */ 
/*     */   private class ReadmeActionListener
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent paramActionEvent)
/*     */     {
/* 127 */       ReadmeDialog.this.setVisible(false);
/*     */     }
/*     */   }


//class MyPanel extends JPanel{
//    
//    Image image=null;
//     
//    public void paint(Graphics g){
//        try {
//            image=ImageIO.read(new File("D:\\1.jpg"));
//            g.drawImage(image, 0, 0, 2560, 1400, null);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}

/*     */ }

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     gui.ReadmeDialog
 * JD-Core Version:    0.5.3
 */
          import java.awt.Color;
import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;

/*     */ import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
/*     */ import javax.swing.JTextField;
import javax.swing.SwingConstants;
/*     */ import javax.swing.Timer;
import javax.swing.border.TitledBorder;


/*     */ 
/*     */ public class OverviewPanel extends JPanel
/*     */ {
	private JPanel  JcomboPane=new JPanel();
           public  int ff ; //ff=1代表第一步   ff=2代表前两步  ff=3代表前三部	
/*     */   private JPanel outputGroupPanel = new JPanel();
/*  33 */   private JLabel outputGroupLabel = new JLabel("Output:");
private JComboBox lst1;
private JComboBox lst2;
private JLabel lb1=new JLabel("固定的标题行数:");
private JLabel lb2=new JLabel("检测编号所属列:");
public int canshu_title=1;
public int canshu_test=2;
private Object title[]={"1","2","3","4","5"};
private Object test[]={"1","2","3","4","5"};
private JLabel llab3=new JLabel("输出文件格式:");
private JLabel llab4=new JLabel("  dasdsadas      ");
private JLabel llab5=new JLabel("  sadasda    ");


	            public JRadioButton jr1=new JRadioButton("xls");//IST-LFS

	        public JRadioButton jr3=new JRadioButton("txt");//MTGIpick
		    public ButtonGroup group=new ButtonGroup();
		  //  private JLabel ffxz=new JLabel("method selection");
/*     */   private JPanel quickoption=new JPanel();

            private LabelTextField inputPanel = new LabelTextField("数据文件A1(.txt):", "");
            private LabelTextField inputPanel2 = new LabelTextField("数据文件A2(.txt):", "");
            private LabelTextField inputPanel3 = new LabelTextField("数据文件B1(.txt):", "");
            private LabelTextField inputPanel4 = new LabelTextField("数据文件B2(.txt):", "");
            private LabelTextField inputPanel5 = new LabelTextField("数据文件C1(.txt):", "");
            private LabelTextField inputPanel6 = new LabelTextField("数据文件C2(.txt):", "");
            private LabelTextField inputPanel7 = new LabelTextField("数据文件D1(.txt):", "");
            private LabelTextField inputPanel8 = new LabelTextField("数据文件D2(.txt):", "");



/*  38 */   private LabelTextField outputPanel = new LabelTextField("输出结果:", "");

/*     */   private LabelTextField signaPanel =new LabelTextField("Genomic signatures: ","");

            private LabelTextField scorePanel = new LabelTextField("Conserved score: ", "");
/*     */ 
/*  42 */   private LabelTextField predictPanel = new LabelTextField("Predicted GIs: ", "");
/*     */ 
/*  47 */   private ImageIcon openIcon = new ImageIcon(this.getClass().getResource("/images/open.gif"));
/*     */ 
/*  49 */   private ImageIcon saveIcon = new ImageIcon(this.getClass().getResource("/images/save.gif"));
/*     */ 
            private JButton openInput = new JButton(this.openIcon);
            private JButton openInput2 = new JButton(this.openIcon);
            private JButton openInput3 = new JButton(this.openIcon);
            private JButton openInput4 = new JButton(this.openIcon);
            private JButton openInput5 = new JButton(this.openIcon);
            private JButton openInput6 = new JButton(this.openIcon);
            private JButton openInput7 = new JButton(this.openIcon);
            private JButton openInput8 = new JButton(this.openIcon);
            

/*  56 */   private JButton setOutput = new JButton(this.saveIcon);
			
            private JButton setSigna = new JButton(this.saveIcon);
             
/*  58 */   private JButton setScore = new JButton(this.saveIcon);
/*     */ 
/*  60 */   private JButton setPredict = new JButton(this.saveIcon);
/*     */ 
            private JLabel progressLabel = new JLabel("Status:  ");
/*     */      
/*  73 */   private JPanel progressPanel = new JPanel();
/*     */ 
/*  75 */   private JProgressBar progressBar = new JProgressBar();
/*     */ 
/*  77 */   private Timer timer = new Timer(1000, new ProgressTimerListener());
/*     */   private ISEWMainFrame owner;
/*     */ 
/*     */   public OverviewPanel(ISEWMainFrame paramColomboMainFrame)
/*     */   {
/*  93 */     this.owner = paramColomboMainFrame;
/*  94 */     initialisierung();
/*     */   }
/*     */ 
public int getTitle(){
	return canshu_title;
}
public int getTest(){
  return canshu_test;
}
/*     */   public void setInput(String paramString)
/*     */   {
/* 104 */     this.inputPanel.setText(paramString);
/*     */   }
/*     */ /*     */   public void setInput2(String paramString)
/*     */   {
/* 104 */     this.inputPanel2.setText(paramString);
/*     */   }

/*     */ /*     */   public void setInput3(String paramString)
/*     */   {
/* 104 */     this.inputPanel3.setText(paramString);
/*     */   }
/*     */ /*     */   public void setInput4(String paramString)
/*     */   {
/* 104 */     this.inputPanel4.setText(paramString);
/*     */   }
/*     */ /*     */   public void setInput5(String paramString)
/*     */   {
/* 104 */     this.inputPanel5.setText(paramString);
/*     */   }
/*     */ /*     */   public void setInput6(String paramString)
/*     */   {
/* 104 */     this.inputPanel6.setText(paramString);
/*     */   }
/*     */ /*     */   public void setInput7(String paramString)
/*     */   {
/* 104 */     this.inputPanel7.setText(paramString);
/*     */   }
/*     */ /*     */   public void setInput8(String paramString)
/*     */   {
/* 104 */     this.inputPanel8.setText(paramString);
/*     */   }








/*     */   public void setOutput(String paramString)
/*     */   {
/* 114 */     this.outputPanel.setText(paramString);
/*     */   }
/*     */   public void setSigna(String paramString)
            {
			  this.signaPanel.setText(paramString);
            }

            public void setScore(String paramString)
/*     */   {
/* 124 */     this.scorePanel.setText(paramString);
/*     */   }
/*     */ 
/*     */   public void setPredict(String paramString)
/*     */   {
/* 134 */     this.predictPanel.setText(paramString);
/*     */   }
           
/*     */ 
/*     */   public String getInput()
/*     */   {
/* 143 */     return this.inputPanel.getText();
/*     */   }
			
/*     */   public String getInput2()
/*     */   {
/* 143 */     return this.inputPanel2.getText();
/*     */   }
/*     */   public String getInput3()
/*     */   {
/* 143 */     return this.inputPanel3.getText();
/*     */   }
			
/*     */   public String getInput4()
/*     */   {
/* 143 */     return this.inputPanel4.getText();
/*     */   }
/*     */   public String getInput5()
/*     */   {
/* 143 */     return this.inputPanel5.getText();
/*     */   }
			
/*     */   public String getInput6()
/*     */   {
/* 143 */     return this.inputPanel6.getText();
/*     */   }
/*     */   public String getInput7()
/*     */   {
/* 143 */     return this.inputPanel7.getText();
/*     */   }
			
/*     */   public String getInput8()
/*     */   {
/* 143 */     return this.inputPanel8.getText();
/*     */   }

/*     */   public String getOutput()
/*     */   {
/* 152 */     return this.outputPanel.getText();
/*     */   }
			
/*     */   public String getSigna()
            {
               return this.signaPanel.getText();
            }
          
/*     */    public String getScore()
/*     */   {
/* 124 */     return scorePanel.getText();
/*     */   }
/*     */ 
/*     */   public String getPredict()
/*     */   {
/* 134 */     return predictPanel.getText();
/*     */   }

            public int getff()
             {
            	
            	return this.ff;
            }
/*     */ 
            public void setff(int ha){
            	this.ff=ha;
            }
            
/*     */   public void setProgressBarMaximum(int paramInt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setProgressBar(boolean paramBoolean) {
/* 168 */     this.progressBar.setIndeterminate(paramBoolean);
/*     */ 
/* 170 */     if (paramBoolean) {
/* 171 */       this.progressBar.setValue(this.progressBar.getMinimum());
/* 172 */       enableFileSelection(false);
/* 173 */       this.timer.start();
/*     */     } else {
/* 175 */       this.timer.stop();
/* 176 */       enableFileSelection(true);
/* 177 */       this.progressBar.setString("Ready");
/* 178 */       this.progressBar.setValue(this.progressBar.getMaximum());
/*     */     }
/*     */   }
/*     */ 
/*     */   private void enableFileSelection(boolean paramBoolean)
/*     */   {
/* 188 */     this.inputPanel.getTextField().setEnabled(paramBoolean);
/* 189 */     this.outputPanel.getTextField().setEnabled(paramBoolean);
			  this.signaPanel.getTextField().setEnabled(paramBoolean);
/* 188 */     this.scorePanel.getTextField().setEnabled(paramBoolean);
/* 189 */     this.predictPanel.getTextField().setEnabled(paramBoolean);

        

/* 194 */     this.openInput.setEnabled(paramBoolean);
   			  this.setPredict.setEnabled(paramBoolean);	
   			  this.setScore.setEnabled(paramBoolean);	
   			  this.setSigna.setEnabled(paramBoolean);	
/* 195 */     this.setOutput.setEnabled(paramBoolean);
              this.signaPanel.setEnabled(paramBoolean);
              this.scorePanel.setEnabled(paramBoolean);
/* 189 */     this.predictPanel.setEnabled(paramBoolean);
              this.jr1.setEnabled(paramBoolean);
//              this.jr2.setEnabled(paramBoolean);
              this.jr3.setEnabled(paramBoolean);
/*     */ }

/*     */ 

/*     */ 
/*     */   private void initialisierung()
/*     */   {
	   //           this.ff=1;
    lst1=new JComboBox(title);  
    lst2=new JComboBox(test);
    lst1.setSelectedIndex(0);
    lst2.setSelectedIndex(1);
    this.lst1.addItemListener(new handler1()); 
    this.lst2.addItemListener(new handler1()); 
    
	ShowMovedDottedLine show = new ShowMovedDottedLine();
	show.setPreferredSize(new Dimension(600,1));
	ShowMovedDottedLine show1 = new ShowMovedDottedLine();
	show1.setPreferredSize(new Dimension(600,1));
	
/* 271 */     Dimension localDimension1 = this.progressLabel.getPreferredSize();
/*     */ 
/* 273 */     this.inputPanel.getLabel().setPreferredSize(new Dimension(115, 30));
             this.inputPanel2.getLabel().setPreferredSize(new Dimension(115, 30));
             this.inputPanel3.getLabel().setPreferredSize(new Dimension(115, 30));
             this.inputPanel4.getLabel().setPreferredSize(new Dimension(115, 30));
             this.inputPanel5.getLabel().setPreferredSize(new Dimension(115, 30));
             this.inputPanel6.getLabel().setPreferredSize(new Dimension(115, 30));
             this.inputPanel7.getLabel().setPreferredSize(new Dimension(115, 30));
             this.inputPanel8.getLabel().setPreferredSize(new Dimension(115, 30));
/* 274 */     this.outputPanel.getLabel().setPreferredSize(new Dimension(115, 30));
             // this.scorePanel.getLabel().setPreferredSize(localDimension1);
/* 274 */   //  this.predictPanel.getLabel().setPreferredSize(localDimension1);

/* 277 */     this.progressLabel.setPreferredSize(localDimension1);
/*     */// openInput.setBackground(new Color(235,244,252));
//           openInput.setBorderPainted(false);
               this.inputPanel.add(this.openInput);
               this.inputPanel2.add(this.openInput2);
               this.inputPanel3.add(this.openInput3);
               this.inputPanel4.add(this.openInput4);
               this.inputPanel5.add(this.openInput5);
               this.inputPanel6.add(this.openInput6);
               this.inputPanel7.add(this.openInput7);
               this.inputPanel8.add(this.openInput8);
               
             // this.outputPanel.add(this.setOutput);
             this.signaPanel.add(this.setSigna);
              this.scorePanel.add(this.setScore);
              this.predictPanel.add(this.setPredict);

              progressLabel.setForeground(Color.red);
              this.progressPanel.setBackground(Color.WHITE);
/* 292 */    // this.progressPanel.add(this.progressLabel);
              this.progressBar.setBackground(new Color(235,244,252));
/* 293 */     //this.progressPanel.add(this.progressBar);
/*     */ 
   TitledBorder border1=BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "   ");
  // border1.setTitleColor(Color.BLUE);
  // border1.setTitleFont(new Font(getFont().getName(),Font.ITALIC,getFont().getSize())); 
   TitledBorder border12=BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "样本信息:");
   // border1.setTitleColor(Color.BLUE);
  //  border12.setTitleFont(new Font(getFont().getName(),Font.ITALIC,getFont().getSize())); 
   //this.inputPanel.setBorder(border1);
  // this.inputPanel2.setBorder(border12);

/* 296 */     Dimension localDimension2 = this.inputPanel.getPreferredSize();
/*     */ 
/* 299 */ //    this.inputPanel.setPreferredSize(new Dimension(localDimension2.width+10,localDimension2.height));
/* 300 */  //   this.inputPanel2.setPreferredSize(new Dimension(localDimension2.width+10,localDimension2.height-10));

//this.outputPanel.setPreferredSize(localDimension2);
            //  this.scorePanel.setPreferredSize(new Dimension(localDimension2.width+40,localDimension2.height+10));
          //   this.predictPanel.setPreferredSize(new Dimension(localDimension2.width+40,localDimension2.height+10));
              this.progressPanel.setPreferredSize(new Dimension(localDimension2.width+45,localDimension2.height-20));
/*     */ 
/* 306 */    // this.progressPanel.setBorder(BorderFactory.createEtchedBorder());
/* 307 */     this.progressPanel.setLayout(new FlowLayout(1));
/*     */ 
/* 310 */     this.progressBar.setStringPainted(true);
/* 311 */     this.progressBar.setBorderPainted(true);
            //  this.progressBar.setForeground(new Color(22,73,131));
/* 312 */     this.progressBar.setString("Ready");
/* 313 */     this.progressBar.setPreferredSize(new Dimension(this.progressPanel.getPreferredSize().width - this.progressLabel.getPreferredSize().width - 18, this.progressPanel.getPreferredSize().height - 14));
/*     */ 
             this.openInput.setActionCommand("OpenInput");
             this.openInput2.setActionCommand("OpenInput2");
             this.openInput3.setActionCommand("OpenInput3");
             this.openInput4.setActionCommand("OpenInput4");
             this.openInput5.setActionCommand("OpenInput5");
             this.openInput6.setActionCommand("OpenInput6");
             this.openInput7.setActionCommand("OpenInput7");
             this.openInput8.setActionCommand("OpenInput8");
              
              
/* 318 */     this.setOutput.setActionCommand("SetOutput");
			  this.setSigna.setActionCommand("setSigna");
              this.setScore.setActionCommand("SetScore");
              this.setPredict.setActionCommand("SetPredict");




/*     */ 
             this.openInput.addActionListener(new OverviewPanelListener());
             this.openInput2.addActionListener(new OverviewPanelListener());
             this.openInput3.addActionListener(new OverviewPanelListener());
             this.openInput4.addActionListener(new OverviewPanelListener());
             this.openInput5.addActionListener(new OverviewPanelListener());
             this.openInput6.addActionListener(new OverviewPanelListener());
             this.openInput7.addActionListener(new OverviewPanelListener());
             this.openInput8.addActionListener(new OverviewPanelListener());
/* 328 */     this.setOutput.addActionListener(new OverviewPanelListener());
			  this.setSigna.addActionListener(new OverviewPanelListener());
              this.setScore.addActionListener(new OverviewPanelListener());
              this.setPredict.addActionListener(new OverviewPanelListener());
/*     */ 
             this.openInput.setToolTipText("Open file ...");
             this.openInput2.setToolTipText("Open file ...");
             this.openInput3.setToolTipText("Open file ...");
             this.openInput4.setToolTipText("Open file ...");
             this.openInput5.setToolTipText("Open file ...");
             this.openInput6.setToolTipText("Open file ...");
             this.openInput7.setToolTipText("Open file ...");
             this.openInput8.setToolTipText("Open file ...");
/* 338 */     this.setOutput.setToolTipText("Save as ...");
			  this.setSigna.setToolTipText("Save as ...");
/* 341 */     this.setScore.setToolTipText("Save as ...");
/* 342 */     this.setPredict.setToolTipText("Save as ...");
/*     */ 
/* 348 */     Dimension localDimension3 = this.inputPanel.getPreferredSize();
/*     */ 
            //  this.outputPanel.setPreferredSize(new Dimension(localDimension3.width, localDimension3.height-10));
          //    this.scorePanel.setPreferredSize(new Dimension(localDimension3.width-6, localDimension3.height));
          //    this.predictPanel.setPreferredSize(new Dimension(localDimension3.width-6, localDimension3.height));
              this.signaPanel.getLabel().setPreferredSize(new Dimension(140, 35));
              this.signaPanel.getTextField().setPreferredSize(new Dimension(315,30));
              this.scorePanel.getLabel().setPreferredSize(new Dimension(140, 35));
              this.scorePanel.getTextField().setPreferredSize(new Dimension(315,30));
              this.predictPanel.getLabel().setPreferredSize(new Dimension(140, 35));
              this.predictPanel.getTextField().setPreferredSize(new Dimension(315,30));
             // this.ffxz.setPreferredSize(new Dimension(120, 35));
/* 358 *///    this.outputGroupLabel.setPreferredSize(new Dimension(localDimension3.width, localDimension3.height - 10));
/*     */  //   this.warn1.setPreferredSize(new Dimension(500, 20));
/* 361 */    // this.outputGroupPanel.add(this.outputGroupLabel);
           //   this.outputGroupPanel.add(this.warn1);
            //  this.outputGroupPanel.add(this.warn2);
            //  this.outputGroupPanel.add(this.signaPanel);
/* 362 */  //   this.outputGroupPanel.add(this.scorePanel);
/* 363 */   //  this.outputGroupPanel.add(this.predictPanel);
 			//  this.outputGroupPanel.add(this.warn3);
//         this.outputGroupPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Training"));
/* 365 */     this.outputGroupPanel.setPreferredSize(new Dimension(this.inputPanel.getPreferredSize().width, 200));
/*     */ 	  this.quickoption.setPreferredSize(new Dimension(this.inputPanel.getPreferredSize().width,this.inputPanel.getPreferredSize().height-45));
/* 367 */   
             Color c=new Color(164,197,242);//BorderFactory.createMatteBorder(10,0,10,0,c)
             TitledBorder border2=BorderFactory.createTitledBorder( BorderFactory.createEmptyBorder(),"Output");
             border2.setTitleColor(Color.BLUE);
             border2.setTitleFont(new Font(getFont().getName(),Font.ITALIC,getFont().getSize())); 
             this.outputGroupPanel.setBorder(border2);
    
         //     this.outputGroupPanel.setBorder(BorderFactory.createEtchedBorder());
/* 368 */     this.outputGroupPanel.setLayout(new FlowLayout(0));

              this.inputPanel.setBackground(new Color(235,244,252));
              this.inputPanel2.setBackground(new Color(235,244,252));
             // this.outputGroupPanel.setBackground(new Color(206,240,249));
              this.outputGroupPanel.setBackground(new Color(235,244,252));
              this.quickoption.setBackground(new Color(235,244,252));
              jr1.setBackground(new Color(235,244,252));  jr3.setBackground(new Color(235,244,252));
              this.group.add(this.jr1);this.group.add(this.jr3);
            //  this.jr1.setSelected(true);
              this.quickoption.add(llab3);
              this.quickoption.add(this.jr1);this.quickoption.add(this.jr3);
              this.quickoption.add(llab4);
              this.quickoption.add(llab5);
              llab4.setVisible(false);
              llab5.setVisible(false);
              this.quickoption.setLayout(new GridLayout(1,6,20,64));
              
            //  TitledBorder border3=BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "输出文本格式");
            //  border3.setTitleColor(Color.BLUE);border3.setTitleFont(new Font(getFont().getName(),Font.ITALIC,getFont().getSize())); 
          //    this.quickoption.setBorder(border3);
              this.jr1.addItemListener(new GroupListener());
              this.jr3.addItemListener(new GroupListener());
              

              JcomboPane.add(lb1);
              JcomboPane.add(this.lst1);
              JcomboPane.add(lb2);
              JcomboPane.add(this.lst2);
              JcomboPane.setLayout(new GridLayout(1,2,64,64));
              JcomboPane.setBackground(new Color(235,244,252));
              
             add(this.inputPanel);
             add(this.inputPanel2);
             add(this.inputPanel3);
             add(this.inputPanel4);
             add(this.inputPanel5);
             add(this.inputPanel6);
             add(this.inputPanel7);
             add(this.inputPanel8);
             add(this.outputPanel);
           //    add(show);
/*     *///   add(this.quickoption);
           //   add(show1);
 		//  add(this.JcomboPane);
/* 376 */ //    add(this.progressPanel);

			
/*     */     setBackground(Color.white);
/* 379 */     setLayout(new FlowLayout(0));
/*     */   }
/*     */ 
/*     */   private class ProgressTimerListener
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent paramActionEvent)
/*     */     {
/* 446 */       OverviewPanel.this.progressBar.setString(OverviewPanel.this.owner.getProgressString());
/* 447 */       OverviewPanel.this.progressBar.setValue(OverviewPanel.this.owner.getProgressValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   private class OverviewPanelListener
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent paramActionEvent)
/*     */     {
/* 395 */       String str = paramActionEvent.getActionCommand();
 
                if (str.equals("OpenInput")) {
               //   System.out.println("OpenInput");
                try {
					OverviewPanel.this.owner.setInputFile(OverviewPanel.this.openInput);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 } else if (str.equals("setSigna")) {
                   OverviewPanel.this.owner.setSigna(OverviewPanel.this.setSigna);
                 }  else if (str.equals("SetScore")) {
	              OverviewPanel.this.owner.setScore(OverviewPanel.this.setScore);
	            } else if (str.equals("SetPredict")) {
	              OverviewPanel.this.owner.setPredict(OverviewPanel.this.setPredict);
                 }else  if (str.equals("OpenInput2")) {
                     try {
						OverviewPanel.this.owner.setInputFile2(OverviewPanel.this.openInput2);
					} catch (Exception e) {				
						e.printStackTrace();
					}
                 }else  if (str.equals("OpenInput3")) {
                     try {
						OverviewPanel.this.owner.setInputFile3(OverviewPanel.this.openInput3);
					} catch (Exception e) {				
						e.printStackTrace();
					}
                 }else  if (str.equals("OpenInput4")) {
                     try {
						OverviewPanel.this.owner.setInputFile4(OverviewPanel.this.openInput4);
					} catch (Exception e) {				
						e.printStackTrace();
					}
                 }else  if (str.equals("OpenInput5")) {
                     try {
						OverviewPanel.this.owner.setInputFile5(OverviewPanel.this.openInput5);
					} catch (Exception e) {				
						e.printStackTrace();
					}
                 }else  if (str.equals("OpenInput6")) {
                     try {
						OverviewPanel.this.owner.setInputFile6(OverviewPanel.this.openInput6);
					} catch (Exception e) {				
						e.printStackTrace();
					}
                 }else  if (str.equals("OpenInput7")) {
                     try {
						OverviewPanel.this.owner.setInputFile7(OverviewPanel.this.openInput7);
					} catch (Exception e) {				
						e.printStackTrace();
					}
                 }else  if (str.equals("OpenInput8")) {
                     try {
						OverviewPanel.this.owner.setInputFile8(OverviewPanel.this.openInput8);
					} catch (Exception e) {				
						e.printStackTrace();
					}
                 }

/*     */     }
/*     */   }

			public class GroupListener implements ItemListener
			{
				public void itemStateChanged(ItemEvent e)
				{
				if(e.getSource()==jr1){
					if(jr1.isSelected()){
					//	scorePanel.setLabel("Score of each regions: ");
					//	if(OverviewPanel.this.owner.getmzhen()==0 || OverviewPanel.this.owner.ismult==1){
					//	OverviewPanel.this.owner.shuchu2();}
						setff(1);
				//	System.out.println(ff);
				 //   OverviewPanel.this.owner.getSmallDialog();}
				}}
//				else if(e.getSource()==jr2){
//					if(jr2.isSelected()){
//					ff=2;
				//	System.out.println(ff);
//					  OverviewPanel.this.owner.getNormalDialog();
//				}
				else if(e.getSource()==jr3){
					if(jr3.isSelected()){
				//		scorePanel.setLabel("Conserved score: ");	
				//	 if(OverviewPanel.this.owner.getmzhen()==0 || OverviewPanel.this.owner.ismult==1){
				//	    OverviewPanel.this.owner.shuchu0();}	
					setff(3);
				//	System.out.println(ff);
				//	  OverviewPanel.this.owner.getLargeDialog();}
				}
				}
				}	
			
//		    @Override
//		    protected void paintComponent(Graphics g) {
//		        super.paintComponent(g);
//		        g.drawImage((new ImageIcon(this.getClass().getResource("/images/tu5.jpg"))).getImage(),0,0,null); //用G 把Image画出来 
//		    }
			}
			public class  handler1 implements ItemListener{
				public void itemStateChanged(ItemEvent e)
				{
					if (e.getSource()==lst1)
					OverviewPanel.this.canshu_title=Integer.parseInt((lst1.getSelectedItem()).toString());
					if (e.getSource()==lst2){
			
						OverviewPanel.this.canshu_test=Integer.parseInt((lst2.getSelectedItem()).toString());

					}
					
		}
		}

/*     */ }
			



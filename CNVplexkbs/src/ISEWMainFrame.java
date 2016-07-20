import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

//import org.biojava3.core.sequence.DNASequence;
//import org.biojava3.core.sequence.io.FastaReaderHelper;

//import MSS24window6.Class1; 
//MSS_macNew.Class1;
//mss_linux326.Class1;
////import sy106.Class2;
//import MSS24window6.Class2;
//import MSS24window6.Class4;
//import wdwin32new2.Class2;
//import MSS24window6.Class3;
//import wdwin32new2.Class4;
//import ismulti.Class0;

//import chrriis.common.UIUtils;
//import chrriis.dj.nativeswing.swtimpl.NativeInterface;


//import chrriis.common.UIUtils;
//import chrriis.dj.nativeswing.swtimpl.NativeInterface;
//import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


public class ISEWMainFrame extends JFrame {
	//private StatusBar statusbar=new StatusBar("ISEW");
	public int aa=0;
	public   int ff=1;
    private String fastadirectory;
	private ImageIcon mainframeIcon=new ImageIcon(this.getClass().getResource("/images/zd.png"));
	private ImageIcon titletu=new ImageIcon(this.getClass().getResource("/images/tt.png"));
	private JLabel title=new JLabel();
	 private StatusBar statusBar = new StatusBar("KTGpick");
	 private ButtonBar buttonBar = new ButtonBar(this);
     private String progressString = "Done";
     private int progressValue = 0;
	 private OverviewPanel overviewPanel = new OverviewPanel(this);
	 private FirstStepDialog firststepdialog=new FirstStepDialog(this);
	 private ExitDialog exitDialog = new ExitDialog(this);
	private AllStepDialog allstepdialog=new AllStepDialog(this);
	private warnin war1;
	private notee notee1;
    private ShowHtml hehe; 
     
     public double sig;
	private Object EmptyBorder;
	public SwingWorker local1;
	public int ismult;
	private File file1;
	private File file2;
	private File file3;
	private int m=0;
	private String out1;
	private String out2;
	private String out3;
	private String outJson=new File("jsonFile"+File.separator+"part1.html").getAbsolutePath();
    private String outHtml;
    private String outD3;
	private String time_temp;
    private String outXls;
	private String benlai;
public ISEWMainFrame () throws IOException
{
 super("CNVplex微缺失微重复拷贝数判定");
 setIconImage(this.mainframeIcon.getImage());
 

 
 initialize();


}

public void initialize()
{

	
	setSize(1200,400);
	 Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2); //放在中间
	setResizable(false);
		
	this.titletu.setImage(titletu.getImage().getScaledInstance(1200, 100, Image.SCALE_DEFAULT));
	this.title.setIcon(titletu);
	this.title.setBorder(BorderFactory.createMatteBorder(0, 1,0,1,Color.white));
	getContentPane().add(this.title, "North");
	getContentPane().add(this.overviewPanel, "Center");
	getContentPane().add(this.buttonBar, "South");
	((BorderLayout) getLayout()).setHgap(0);
	((BorderLayout) getLayout()).setVgap(0);
	
	((JComponent) getContentPane()).setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
	this.setBackground(new Color(164,197,242));

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

public void setm(int m3){
	   this.m=m3;
}

public int getmzhen(){
	   return this.m;
}
public int getm(){
	   return this.ismult;
}
//////
/*     */   public void evaluate()
/*     */   {
/* 102 */    final ISEWMainFrame localISEWMainFrame = this;
/* 103 */     this.progressValue = 0;



/* 116 */  /* 116 */    this.local1 = new SwingWorker()
/*     */     {
/*     */       public Object construct()
/*     */       {

/* 133 */         long l = System.currentTimeMillis();

/* 138 */          try {


    cnvplexkbs tr=new cnvplexkbs(ISEWMainFrame.this.overviewPanel.getInput(),ISEWMainFrame.this.overviewPanel.getInput2(),ISEWMainFrame.this.overviewPanel.getInput3(),ISEWMainFrame.this.overviewPanel.getInput4(),ISEWMainFrame.this.overviewPanel.getInput5(),ISEWMainFrame.this.overviewPanel.getInput6(),ISEWMainFrame.this.overviewPanel.getInput7(),ISEWMainFrame.this.overviewPanel.getInput8(),ISEWMainFrame.this.overviewPanel.getOutput());

	


                  ///////////////////////////////////////
                       } catch (Exception e) {
                     	// TODO Auto-generated catch block
                    	 //  ISEWMainFrame.this.exitDialog.setVisible(true);
	                 e.printStackTrace();
                     }
///*     */ 
///* 183 */           ColomboMainFrame.access$202(ColomboMainFrame.this, "Done");
/*     */ 
/* 186 */           l = System.currentTimeMillis() - l;
           
//this.notee1=new notee(this);
//	 this.notee1.setVisible(true);	  ISEWMainFrame.this.outXls
File file =new File(ISEWMainFrame.this.overviewPanel.getOutput());
if(file.exists()){       
        notee not1=new notee(ISEWMainFrame.this,ISEWMainFrame.this.overviewPanel.getOutput());
        not1.setVisible(true);
}
/* 195 */         return null;
/*     */       }
/*     */     };
/* 200 */    this.local1.start();
/*     */   }


/////
public void stopper(){
	

	this.local1.interrupt();
  ISEWMainFrame.copyvalue(ISEWMainFrame.this, "Ready");
        ISEWMainFrame.this.overviewPanel.setProgressBar(false);

}


public String getProgressString()
/*     */   {
/* 210 */     return this.progressString;
/*     */   }
/*     */ 
/////
/*     */   public int getProgressValue() {
/* 233 */     return this.progressValue;
/*     */   }
/////
/*     */   public void setLabelStatus(String paramString)
/*     */   {
/* 250 */     this.statusBar.setLabelStatus(paramString);
/*     */   }

protected static  void copyvalue(ISEWMainFrame isewMainFrame,
		String string) {
	// TODO Auto-generated method stub
	isewMainFrame.progressString=string;
}
/////
///////////////////////////////////////////////////////////

//
//}
//////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////
    public void setInputFile(Component paramComponent) throws Exception
   {  
    //	 ISEWMainFrame.this.buttonBar.beenden.setVisible(false);
    	this.m=0;
    	//this.overviewPanel.group.clearSelection();
    	//this.ff=1;
              String str1 = this.overviewPanel.getInput();
              String str22 = this.overviewPanel.getInput2();
       //       System.out.println(str1);
              JFileChooser fastafile=new JFileChooser();
           
            fastafile.setFileFilter(new FileNameExtensionFilter(".txt","txt"));
           //  fastafile.showOpenDialog(this);  
      //       fastafile.setCurrentDirectory(new File("~"));  
             File localFile = null;
/*     */ 
/* 311 */     if (str22.length() > 0) {
/* 312 */      fastafile.setCurrentDirectory(new File(str22));
/*     */     }
/*     */   int result=fastafile.showOpenDialog(paramComponent);
/* 316 */     if (result == JFileChooser.APPROVE_OPTION) {
/* 317 */       localFile = fastafile.getSelectedFile();
/*     */   
/* 319 */       if (localFile != null) {
	/////////////////////////////////////////
/* 320 */       this.overviewPanel.setInput(localFile.getAbsolutePath());

/*     */        SimpleDateFormat df = new SimpleDateFormat("HH.mm");//设置日期格式
//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

/* 323 */         String str2 = localFile.getName();
/* 324 */         int i = str2.lastIndexOf(".");
/* 325 */         String str3 = this.overviewPanel.getInput();
                  String str4=fastafile.getSelectedFile().toString();
/* 326 */         int j = str3.lastIndexOf(".");
				  int jj =str3.lastIndexOf(File.separator);
                  if(str3.lastIndexOf("A")>0){
				  int jb=str3.lastIndexOf("A"); int jb2=str3.lastIndexOf("1");
                  String strj1=str3.substring(0,jb);String strj11=str3.substring(0,jb); String strj22=str3.substring(jb+1,jb2);
                  String strj2=str3.substring(jb+1,str3.length());String strj33=str3.substring(jb2+1,str3.length());
                  this.overviewPanel.setInput2(strj11+"A"+strj22+"2"+strj33); this.overviewPanel.setInput3(strj11+"B"+strj22+"1"+strj33);this.overviewPanel.setInput4(strj11+"B"+strj22+"2"+strj33);
                  this.overviewPanel.setInput5(strj11+"C"+strj22+"1"+strj33); this.overviewPanel.setInput6(strj11+"C"+strj22+"2"+strj33);this.overviewPanel.setInput7(strj11+"D"+strj22+"1"+strj33);this.overviewPanel.setInput8(strj11+"D"+strj22+"2"+strj33);
                
                  }
//                  if(str3.lastIndexOf("a")>0){
//    				  int jb=str3.lastIndexOf("a"); int jb2=str3.lastIndexOf("1");
//                      String strj1=str3.substring(0,jb);String strj11=str3.substring(0,jb); String strj22=str3.substring(jb+1,jb2);
//                      String strj2=str3.substring(jb+1,str3.length());String strj33=str3.substring(jb2+1,str3.length());
//                      this.overviewPanel.setInput2(strj11+"a"+strj22+"2"+strj33); this.overviewPanel.setInput3(strj11+"b"+strj22+"1"+strj33);this.overviewPanel.setInput4(strj11+"b"+strj22+"2"+strj33);
//                      this.overviewPanel.setInput5(strj11+"c"+strj22+"1"+strj33); this.overviewPanel.setInput6(strj11+"c"+strj22+"2"+strj33);this.overviewPanel.setInput7(strj11+"d"+strj22+"1"+strj33);this.overviewPanel.setInput8(strj11+"d"+strj22+"2"+strj33);
//                      }
				  this.outD3=str3.substring(0, jj)+File.separator+"D3"+File.separator;

                 this.outXls=str3.substring(0, jj+1)+"All_out.xls";
                 this.overviewPanel.setOutput(this.outXls);
                 
/* 327 */       if (j >= 0)
	                this.benlai="_"+str3.substring(jj+1, j);
                   time_temp = df.format(new Date());
                   this.out1=str3.substring(0, j) + "_signa_"+time_temp;
                   this.out2=str3.substring(0, j) + "_score_"+time_temp;
                   this.out3=str3.substring(0, j) + "_predict_"+time_temp;
                   this.outHtml=str3.substring(0,j)+"_"+time_temp;
                   /////////////////////////////////////////////

/*     */       } 
/*     */   }

              this.fastadirectory=this.overviewPanel.getInput();

/*     */   }
/////////////////222222222222222222222222222222222222////////////////////////////////////////////////////////
    public void setInputFile2(Component paramComponent) throws Exception
    {  
     //	 ISEWMainFrame.this.buttonBar.beenden.setVisible(false);
     	this.m=0;
     	//this.overviewPanel.group.clearSelection();
     	//this.ff=1;
               String str1 = this.overviewPanel.getInput();
        //       System.out.println(str1);
               JFileChooser fastafile=new JFileChooser();
            
             fastafile.setFileFilter(new FileNameExtensionFilter(".txt","txt"));
            //  fastafile.showOpenDialog(this);  
       //       fastafile.setCurrentDirectory(new File("~"));  
              File localFile = null;
 /*     */ 
 /* 311 */     if (str1.length() > 0) {
 /* 312 */      fastafile.setCurrentDirectory(new File(str1));
 /*     */     }
 /*     */   int result=fastafile.showOpenDialog(paramComponent);
 /* 316 */     if (result == JFileChooser.APPROVE_OPTION) {
 /* 317 */       localFile = fastafile.getSelectedFile();
 /*     */   
 /* 319 */       if (localFile != null) {
 	/////////////////////////////////////////
 	
 	/////////////////////////////////////////

 	
 	
 	
 	
 	////////////////////////////////////////
 /* 320 */       this.overviewPanel.setInput2(localFile.getAbsolutePath());

 /*     */        SimpleDateFormat df = new SimpleDateFormat("HH.mm");//设置日期格式
 //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

 /* 323 */         String str2 = localFile.getName();
 /* 324 */         int i = str2.lastIndexOf(".");
 /* 325 */         String str3 = this.overviewPanel.getInput();
                   String str4=fastafile.getSelectedFile().toString();
 /* 326 */         int j = str3.lastIndexOf(".");
 				  int jj =str3.lastIndexOf(File.separator);

 			//	  this.outD3=str3.substring(0, jj)+File.separator+"D3"+File.separator;

                  //this.outXls=str3.substring(0, jj)+File.separator;
                 
 /* 327 */       if (j >= 0)
 	                this.benlai="_"+str3.substring(jj+1, j);
                    time_temp = df.format(new Date());
                    this.out1=str3.substring(0, j) + "_signa_"+time_temp;
                    this.out2=str3.substring(0, j) + "_score_"+time_temp;
                    this.out3=str3.substring(0, j) + "_predict_"+time_temp;
                    this.outHtml=str3.substring(0,j)+"_"+time_temp;
                    /////////////////////////////////////////////
                    if(ISEWMainFrame.this.overviewPanel.getInput().length()>1&&ISEWMainFrame.this.overviewPanel.getInput2().length()>1)
                    {
 
                       	
                          }

 /*     */       } 
 /*     */   }

               this.fastadirectory=this.overviewPanel.getInput();

 /*     */   }
/////////////////////////////////////////////////////////////////////////
    public void setInputFile3(Component paramComponent) throws Exception
    {            String str1 = this.overviewPanel.getInput();  
    	JFileChooser fastafile=new JFileChooser();
            fastafile.setFileFilter(new FileNameExtensionFilter(".txt","txt"));
              File localFile = null;
         if (str1.length() > 0) {    fastafile.setCurrentDirectory(new File(str1));     }
 /*     */   int result=fastafile.showOpenDialog(paramComponent);
 /* 316 */     if (result == JFileChooser.APPROVE_OPTION) {
 /* 317 */       localFile = fastafile.getSelectedFile();  
 /* 319 */       if (localFile != null) {
 /* 320 */       this.overviewPanel.setInput3(localFile.getAbsolutePath());   }  }
               this.fastadirectory=this.overviewPanel.getInput();  }
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
public void setInputFile4(Component paramComponent) throws Exception
{            String str1 = this.overviewPanel.getInput();  
JFileChooser fastafile=new JFileChooser();
fastafile.setFileFilter(new FileNameExtensionFilter(".txt","txt"));
File localFile = null;
if (str1.length() > 0) {    fastafile.setCurrentDirectory(new File(str1));     }
/*     */   int result=fastafile.showOpenDialog(paramComponent);
/* 316 */     if (result == JFileChooser.APPROVE_OPTION) {
/* 317 */       localFile = fastafile.getSelectedFile();  
/* 319 */       if (localFile != null) {
/* 320 */       this.overviewPanel.setInput4(localFile.getAbsolutePath());   }  }
this.fastadirectory=this.overviewPanel.getInput();  }
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
public void setInputFile5(Component paramComponent) throws Exception
{            String str1 = this.overviewPanel.getInput();  
JFileChooser fastafile=new JFileChooser();
fastafile.setFileFilter(new FileNameExtensionFilter(".txt","txt"));
File localFile = null;
if (str1.length() > 0) {    fastafile.setCurrentDirectory(new File(str1));     }
/*     */   int result=fastafile.showOpenDialog(paramComponent);
/* 316 */     if (result == JFileChooser.APPROVE_OPTION) {
/* 317 */       localFile = fastafile.getSelectedFile();  
/* 319 */       if (localFile != null) {
/* 320 */       this.overviewPanel.setInput5(localFile.getAbsolutePath());   }  }
this.fastadirectory=this.overviewPanel.getInput();  }
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
public void setInputFile6(Component paramComponent) throws Exception
{            String str1 = this.overviewPanel.getInput();  
JFileChooser fastafile=new JFileChooser();
fastafile.setFileFilter(new FileNameExtensionFilter(".txt","txt"));
File localFile = null;
if (str1.length() > 0) {    fastafile.setCurrentDirectory(new File(str1));     }
/*     */   int result=fastafile.showOpenDialog(paramComponent);
/* 316 */     if (result == JFileChooser.APPROVE_OPTION) {
/* 317 */       localFile = fastafile.getSelectedFile();  
/* 319 */       if (localFile != null) {
/* 320 */       this.overviewPanel.setInput6(localFile.getAbsolutePath());   }  }
this.fastadirectory=this.overviewPanel.getInput();  }
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
public void setInputFile7(Component paramComponent) throws Exception
{            String str1 = this.overviewPanel.getInput();  
JFileChooser fastafile=new JFileChooser();
fastafile.setFileFilter(new FileNameExtensionFilter(".txt","txt"));
File localFile = null;
if (str1.length() > 0) {    fastafile.setCurrentDirectory(new File(str1));     }
/*     */   int result=fastafile.showOpenDialog(paramComponent);
/* 316 */     if (result == JFileChooser.APPROVE_OPTION) {
/* 317 */       localFile = fastafile.getSelectedFile();  
/* 319 */       if (localFile != null) {
/* 320 */       this.overviewPanel.setInput7(localFile.getAbsolutePath());   }  }
this.fastadirectory=this.overviewPanel.getInput();  }
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
public void setInputFile8(Component paramComponent) throws Exception
{            String str1 = this.overviewPanel.getInput();  
JFileChooser fastafile=new JFileChooser();
fastafile.setFileFilter(new FileNameExtensionFilter(".txt","txt"));
File localFile = null;
if (str1.length() > 0) {    fastafile.setCurrentDirectory(new File(str1));     }
/*     */   int result=fastafile.showOpenDialog(paramComponent);
/* 316 */     if (result == JFileChooser.APPROVE_OPTION) {
/* 317 */       localFile = fastafile.getSelectedFile();  
/* 319 */       if (localFile != null) {
/* 320 */       this.overviewPanel.setInput8(localFile.getAbsolutePath());   }  }
this.fastadirectory=this.overviewPanel.getInput();  }
/////////////////////////////////////////////////////////////////////////
   public void classify(){
	   
	   evaluate();
	   
	   
	   
//	   if(this.overviewPanel.getff()==1){
//	   Classify2 th2=new Classify2(this.overviewPanel.getTitle(),this.overviewPanel.getTest(),this.overviewPanel.getInput(),this.outXls,this.benlai);
//	   this.notee1=new notee(this);
//		 this.notee1.setVisible(true);
//	   }else{
//		   Classify3 th3=new Classify3(this.overviewPanel.getTitle(),this.overviewPanel.getTest(),this.overviewPanel.getInput(),this.outXls,this.benlai);
//		   this.notee1=new notee(this);
//			 this.notee1.setVisible(true);	  
//	   }
//	   
	   
	   
	   
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
/////////////////////////////////////////////////////////////////////////////
public void shuchu0(){
 	   this.overviewPanel.setScore(this.out2+".jpg");                    //str3.substring(0, j) + "_score"+df.format(new Date())+".txt");
        this.overviewPanel.setPredict(this.out3+".txt");//str3.substring(0, j) + "_predict"+df.format(new Date())+".txt");
        this.overviewPanel.setSigna(this.out1+".txt");//str3.substring(0, j) + "_signa"+df.format(new Date())+".txt");                                                               
  
 	   
}    
    
    
    
    
//////////////////////////////////////////////////////////////////////////    
public void shuchu1(){    
    this.overviewPanel.setScore(this.out2+".zip");                    //str3.substring(0, j) + "_score"+df.format(new Date())+".txt");
    this.overviewPanel.setPredict(this.out3+".zip");//str3.substring(0, j) + "_predict"+df.format(new Date())+".txt");
    this.overviewPanel.setSigna(this.out1+".zip");//str3.substring(0, j) + "_signa"+df.format(new Date())+".txt");                 
    
    
   }   
    
    
/////////////////////////////////////////////////////////////////////////
public void shuchu2(){    
    this.overviewPanel.setScore(this.out2+".txt");                    //str3.substring(0, j) + "_score"+df.format(new Date())+".txt");
    this.overviewPanel.setPredict(this.out3+".txt");//str3.substring(0, j) + "_predict"+df.format(new Date())+".txt");
    this.overviewPanel.setSigna(this.out1+".txt");//str3.substring(0, j) + "_signa"+df.format(new Date())+".txt");                 
    
    
   }  


/////////////////////////////////////////////////////////////////////////
    public void setSigna(Component paramComponent)
   {    		
//        String str = this.overviewPanel.getSigna();
//     //   System.out.println(str);
//        JFileChooser localfile=new JFileChooser();
//        if (str.length() > 0) {
//      	  localfile.setCurrentDirectory(new File(str));
//       }
//        int result= localfile.showOpenDialog(paramComponent);
//      if (result == JFileChooser.APPROVE_OPTION) {                                         
//        if (localfile != null) {
//         this.overviewPanel.setSigna(localfile.getSelectedFile().getAbsolutePath()); 
//       }
//     }
    	try { 
            String str = this.overviewPanel.getSigna();
            JFileChooser localfile=new JFileChooser();
             localfile.setCurrentDirectory(this.file3);
               localfile.setSelectedFile(this.file3);
               int n = localfile.showSaveDialog(null);
               String filename2 = localfile.getSelectedFile().toString();
//               if(filename2.indexOf(".")!=-1){
//                filename2=filename2.substring(0,filename2.lastIndexOf("."));
//               }
//               filename2=filename2+".zip";
//               System.out.println(filename2);
               FileInputStream input = new FileInputStream(this.overviewPanel.getSigna());
               FileOutputStream output = new FileOutputStream(filename2);
               int in = input.read();
               while (in != -1) {
                output.write(in);
                in = input.read();
               }
               input.close();
               output.close();

          } catch (Exception x) {
        	   System.out.println(x);
         }
    	
    }   
/////////////////////////////////////////////////////////////////////////


                  public void setScore(Component paramComponent)
                 {

//                      String str = this.overviewPanel.getScore();
//                 //     System.out.println(str);
//                      JFileChooser localfile=new JFileChooser();
//                      if (str.length() > 0) {
//                    	  localfile.setCurrentDirectory(new File(str));
//                     }
//                      int result= localfile.showOpenDialog(paramComponent);
//                    if (result == JFileChooser.APPROVE_OPTION) {                                         
//                      if (localfile != null) {
//                       this.overviewPanel.setScore(localfile.getSelectedFile().getAbsolutePath()); 
//                     }
//    	           }
                	  
                      try { 
                          String str = this.overviewPanel.getScore();
                          JFileChooser localfile=new JFileChooser();
                          localfile.setCurrentDirectory(this.file1);
                          localfile.setSelectedFile(this.file1);
                          int n = localfile.showSaveDialog(null);
                          String filename2 = localfile.getSelectedFile().toString();
//                          if(filename2.indexOf(".")!=-1){
//                           filename2=filename2.substring(0,filename2.lastIndexOf("."));
//                          }
//                          filename2=filename2+".zip";
//                          System.out.println(filename2);
                          FileInputStream input = new FileInputStream(this.overviewPanel.getScore());
                          FileOutputStream output = new FileOutputStream(filename2);
                          int in = input.read();
                          while (in != -1) {
                           output.write(in);
                           in = input.read();
                          }
                          input.close();
                          output.close();
                        }catch (Exception x) {
        	        	   System.out.println(x);
        	           }
                  }
///////////////////////////////////////////////////////////////////////////////////////////////////////

                  public void setPredict(Component paramComponent)
                 {

//                      String str = this.overviewPanel.getPredict();
//              //        System.out.println(str);
//                      JFileChooser localfile=new JFileChooser();
//                      if (str.length() > 0) {
//                    	  localfile.setCurrentDirectory(new File(str));
//                     }
//                      int result= localfile.showOpenDialog(paramComponent);
//                    if (result == JFileChooser.APPROVE_OPTION) {                                         
//                      if (localfile != null) {
//                       this.overviewPanel.setPredict(localfile.getSelectedFile().getAbsolutePath()); 
//                     }
//    	           }
                	  
                	  try { 
                          String str = this.overviewPanel.getPredict();
                          JFileChooser localfile=new JFileChooser();
                          localfile.setCurrentDirectory(this.file2);
                          localfile.setSelectedFile(this.file2);
                          int n = localfile.showSaveDialog(null);
                          String filename2 = localfile.getSelectedFile().toString();
//                          if(filename2.indexOf(".")!=-1){
//                           filename2=filename2.substring(0,filename2.lastIndexOf("."));
//                          }
//                         filename2=filename2+".zip";
//                          System.out.println(filename2);
                          FileInputStream input = new FileInputStream(this.overviewPanel.getPredict());
                          FileOutputStream output = new FileOutputStream(filename2);
                          int in = input.read();
                          while (in != -1) {
                           output.write(in);
                           in = input.read();
                          }
                          input.close();
                          output.close();
                    	  } catch (Exception x) {
                       	   System.out.println(x);
                        }
                  }
///////////////////////////////////////////////////////////////////////////////////////////////////////                
                    public void exit()
                 {
                    	
                   this.exitDialog.setVisible(true);
                }               
 //////////////////////////////////////////////////////////////////////////////////////////////////////
                    /*     */   public void showAllStepDialog() {
                    
                  	  this.overviewPanel.group.clearSelection(); 
                       	  this.aa=0;
                    	     this.allstepdialog=new AllStepDialog(this);
                    	/* 280 */     if (this.allstepdialog != null)
                    	/* 281 */       this.allstepdialog.setVisible(true);
     
                    	/*     */   }              
////////////////////////////////////////////////////////////////////                    
                    public void showFirstStepDialog(){
                    	  this.overviewPanel.group.clearSelection(); 
        
                      this.firststepdialog.setVisible(true);
                    }
                    
/////////////////////////////////////////////////////////////////////////
       public void setff1(){
    	   this.ff=1;
    	 
  //  	   System.out.println(this.ff);
      }             
       public void setff2(){
    	   this.ff=2+this.aa;
  //  	   System.out.println(this.ff);
      } 
       public void setff3(){
    	   this.ff=3;
   // 	   System.out.println(this.ff);
      } 
//////////////////////////////////////////////////////////////////////////

       
   public void getSmallDialog()
   {
	   this.firststepdialog.setVisible(true);
	   
   }

   public void getNormalDialog()
   {
	   this.aa=0;
	   this.allstepdialog=new AllStepDialog(this,30,10);
	   this.allstepdialog.setVisible(true);
   }

   public void getLargeDialog()
   {
	   this.aa=1;
	   this.allstepdialog=new AllStepDialog(this,30,10,1);
	   this.allstepdialog.setVisible(true);
   }

   
   public String getoutHtml()
   {
	   
	 return this.outHtml;   
   }
   
   
   public String getoutD3() 
   {
     return this.outD3;
   }
   
   public void showPic(JFrame paramJFrame)
   {

          
		    	   ISEWMainFrame.this.hehe= new ShowHtml(paramJFrame);
		    	   this.hehe.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    	   ISEWMainFrame.this.hehe.setVisible(true);
 
		 
  
	   
   }
   
   public void showmacwain(JFrame paramJFrame)
   {
	   
	   macwain not1=new macwain(paramJFrame);
       not1.setVisible(true);
   }
   
   //压缩文件 删除原文件
   public void chuli() throws IOException
   {
	   byte[] buffer = new byte[1024];   

	

	    String strZipName1 =this.out1+".zip";   
	    String strZipName2 =this.out2+".zip";
	    String strZipName3 =this.out3+".zip";
	    
	    
	    ZipOutputStream outt = new ZipOutputStream(new FileOutputStream(strZipName1));   
	    ZipOutputStream outt2 = new ZipOutputStream(new FileOutputStream(strZipName2));
	    ZipOutputStream outt3 = new ZipOutputStream(new FileOutputStream(strZipName3));  
	    //需要同时下载的两个文件result.txt ，source.txt   
        ///////////
	    File[] filee1 =new File[this.ismult];
	    for (int i=0;i<this.ismult;i++){
	    	int j=i+1;
	    	filee1[i]=new File(this.out1+"_sequence"+j+".txt");
	    }
	    ///////////
	    File[] filee2 =new File[this.ismult];
	    for (int i=0;i<this.ismult;i++){
	    	int j=i+1;
	    	if(this.ff==3){
	    	filee2[i]=new File(this.out2+"_sequence"+j+".jpg");}
	    	else{
	        filee2[i]=new File(this.out2+"_sequence"+j+".txt");	
	    	}
	    }
	    ///////////
	    File[] filee3 =new File[this.ismult];
	    for (int i=0;i<this.ismult;i++){
	    	int j=i+1;
	    	filee3[i]=new File(this.out3+"_sequence"+j+".txt");
	    }
	    ///////////////////////
	    
	    for(int i=0;i<filee1.length;i++) {   

	        FileInputStream fis = new FileInputStream(filee1[i]);   

	        outt.putNextEntry(new ZipEntry(filee1[i].getName()));   

	        int len;   

	        //读入需要下载的文件的内容，打包到zip文件   

	       while((len = fis.read(buffer))>0) {   

	        outt.write(buffer,0,len);    

	       }   

	        outt.closeEntry();   

	        fis.close();   

	    }   

	     outt.close();   

	    //////////////////////////
		    for(int i=0;i<filee2.length;i++) {   

		        FileInputStream fis = new FileInputStream(filee2[i]);   

		        outt2.putNextEntry(new ZipEntry(filee2[i].getName()));   

		        int len;   

		        //读入需要下载的文件的内容，打包到zip文件   

		       while((len = fis.read(buffer))>0) {   

		        outt2.write(buffer,0,len);    

		       }   

		        outt2.closeEntry();   

		        fis.close();   

		    }   

		     outt2.close();
		/////////////////////////////
			    for(int i=0;i<filee3.length;i++) {   

			        FileInputStream fis = new FileInputStream(filee3[i]);   

			        outt3.putNextEntry(new ZipEntry(filee3[i].getName()));   

			        int len;   

			        //读入需要下载的文件的内容，打包到zip文件   

			       while((len = fis.read(buffer))>0) {   

			        outt3.write(buffer,0,len);    

			       }   

			        outt3.closeEntry();   

			        fis.close();   

			    }   

			     outt3.close();
	//////////////////////////////////////////////////////////////////////////
	 for(int i=0;i<filee1.length;i++) {  
		 filee1[i].delete();
	 }
	 
	 for(int i=0;i<filee2.length;i++) {  
		 filee2[i].delete();
	 }
	 
	 for(int i=0;i<filee3.length;i++) {  
		 filee3[i].delete();
	 }
	 
    }

}

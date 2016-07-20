import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JFrame;

public class Writehtml {
  public String srcFile1 = "jsonFile"+File.separator+"part1.html";	
  public String srcFile2;	//File file = new File("src/index1.html");String filepath = "resource/train.txt";
  public String srcFile3 = "jsonFile"+File.separator+"part2.html";
  public  int diedai; 
  public String toFile;
  
  public String Sourced3="jsonFile"+File.separator+"D3";
  public String toD3;
  public JFrame owner;
    public Writehtml(JFrame paramJFrame) throws IOException
    {
        try {
        	this.owner=paramJFrame;   
        	diedai=((ISEWMainFrame) Writehtml.this.owner).getm();
        if (((ISEWMainFrame) Writehtml.this.owner).getmzhen()>0){	
        	for (int dd=1;dd<diedai+1;dd++)
        	{
        	this.srcFile2= "jsonFile"+File.separator+"flare"+dd+".json";
        	toFile= ((ISEWMainFrame) Writehtml.this.owner).getoutHtml()+"_sequence"+dd+".html";
            String result1= read(srcFile1);
            String result2= read(srcFile2);
            String result3 =read(srcFile3);
            write1(result1, toFile);
            write(result2, toFile);
            write(result3, toFile);
        	}
         }else{
        	 this.srcFile2= "jsonFile"+File.separator+"flare.json"; 
        	 toFile= ((ISEWMainFrame) Writehtml.this.owner).getoutHtml()+".html";
        	 String result1= read(srcFile1);
             String result2= read(srcFile2);
             String result3 =read(srcFile3);
             write1(result1, toFile);
             write(result2, toFile);
             write(result3, toFile); 
        	        	 
         }
         ///����d3
            //Դ�ļ���
           // static String url1="D:/d3/d3";
            //Ŀ���ļ���
          //  static String url2="E:/d3/";
            toD3=((ISEWMainFrame) Writehtml.this.owner).getoutD3();
            //����Ŀ���ļ���
            (new File(toD3)).mkdirs();
            //��ȡԴ�ļ��е�ǰ�µ��ļ���Ŀ¼
             File[] file=(new File(Sourced3)).listFiles();
             for (int i = 0; i < file.length; i++) {
              if(file[i].isFile()){
                  //�����ļ�
                  copyFile(file[i],new File(toD3+file[i].getName()));
              }
              if(file[i].isDirectory()){
                  //����Ŀ¼
                  String sorceDir=Sourced3+File.separator+file[i].getName();
                  String targetDir=toD3+File.separator+file[i].getName();
                  copyDirectiory(sorceDir, targetDir);
              }
          }
          
            
        } catch (Exception e) {
            e.printStackTrace();
              
            
            
            
        }
	}



    private static String read(String srcFile) throws FileNotFoundException {
 
        Scanner in = new Scanner(new File(srcFile));
        String result = "";
 
        while (in.hasNextLine()) {
            result += in.nextLine() + "\r\n";
        }
 
        in.close();
 
        return result;
    }
 
    private static void write(String result, String toFile) throws Exception {
 
        Writer w = new FileWriter(new File(toFile),true);
 
        w.append(result);
        w.flush();
        w.close();
    }
    private static void write1(String result, String toFile) throws Exception {
    	 
        Writer w = new FileWriter(new File(toFile),false);
 
        w.append(result);
        w.flush();
        w.close();
    }
    
    
    
    
    ////////����d3Ŀ¼
  public static void copyFile(File sourcefile,File targetFile) throws IOException{
        
        //�½��ļ����������������л���
        FileInputStream input=new FileInputStream(sourcefile);
        BufferedInputStream inbuff=new BufferedInputStream(input);
        
        //�½��ļ���������������л���
        FileOutputStream out=new FileOutputStream(targetFile);
        BufferedOutputStream outbuff=new BufferedOutputStream(out);
        
        //��������
        byte[] b=new byte[1024*5];
        int len=0;
        while((len=inbuff.read(b))!=-1){
            outbuff.write(b, 0, len);
        }
        
        //ˢ�´˻���������
        outbuff.flush();
        
        //�ر���
        inbuff.close();
        outbuff.close();
        out.close();
        input.close();
        
        
    }
    
    public static void copyDirectiory(String sourceDir,String targetDir) throws IOException{
        
        //�½�Ŀ��Ŀ¼
        
        (new File(targetDir)).mkdirs();
        
        //��ȡԴ�ļ��е��µ��ļ���Ŀ¼
        File[] file=(new File(sourceDir)).listFiles();
        
        for (int i = 0; i < file.length; i++) {
            if(file[i].isFile()){
                //Դ�ļ�
                File sourceFile=file[i];
                    //Ŀ���ļ�
                File targetFile=new File(new File(targetDir).getAbsolutePath()+File.separator+file[i].getName());
                
                copyFile(sourceFile, targetFile);
            
            }
            
            
            if(file[i].isDirectory()){
                //׼�����Ƶ�Դ�ļ���
                String dir1=sourceDir+file[i].getName();
                //׼�����Ƶ�Ŀ���ļ���
                String dir2=targetDir+File.separator+file[i].getName();
                
                copyDirectiory(dir1, dir2);
            }
        }
        
    }
    
    
}

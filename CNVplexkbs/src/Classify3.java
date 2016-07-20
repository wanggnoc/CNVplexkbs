import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Classify3 {
	 public Classify3(int mm1,int mm2,String lujing,String xlslj,String benlai){
	 
		 int biaoti=mm1;//标题行数
			int bianhao=mm2;//编号所在列数
			String[] nameText=new String[biaoti];
		
			Set<String>  testSet=new HashSet<String>();
			List<String>  testList=new ArrayList<String>();
			List<String> hang=new ArrayList<String>();
			FileWriter wwb = null;
			// WritableSheet ws=null;
			 try {
		    Scanner in = new Scanner(new File(lujing));
		    for (int k=0;k<biaoti;k++){
		    	nameText[k]=in.nextLine();
		    }
		   
	        while (in.hasNextLine()) {
	            String str = in.nextLine();
			    hang.add(str);
			   String[] aa=str.split("\t");
			  
			// System.out.println(aa[1]);		   
			  testSet.add(aa[bianhao-1]);
			  testList.add(aa[bianhao-1]);
		        }
	    
	        in.close();
	       
	        
	     
	        
	                
	        Iterator it = testSet.iterator(); 
	  
	        while(it.hasNext()){
	            int i=biaoti; 
	        	String temp=it.next().toString();
	        	List<Integer> shuchu=new ArrayList<Integer>();
	        	int ii=0;
	        	 Scanner in2 = new Scanner(new File(lujing)); 
	        	 for(int k=0;k<biaoti;k++)
	        	 {
	        		 in2.nextLine();
	        	 }
	        	 
	            while (in2.hasNextLine()) {
	                String str = in2.nextLine();
	                String[] aa2=str.split("\t");
	                 if(aa2[bianhao-1].equals(temp))
	                 {
	                	shuchu.add(ii); 
	                 }
	                 ii++;	
	    		
	    	        }
	            in2.close();
	        	
	        	Iterator it_shuchu=shuchu.iterator();
	//////////    
	            try {  
	                //首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象  
	          	  String outputFile=xlslj+temp+benlai+".txt";
	                wwb = new FileWriter(outputFile);
	                //Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置  
	          
	             } catch (IOException e) {  
	                e.printStackTrace();  
	            } 
	            ////写标题////////////////////////////////////////////////////////////
	            for (int k=0;k<biaoti;k++)
	            {
	            		wwb.write(nameText[k]+"\r\n");
	            }
	            
	           
	            /////write-end/////////////////////////////////////////////////////////////////
	        	while(it_shuchu.hasNext()){
	        		String temp2=hang.get((Integer) it_shuchu.next());
	        		
	        	//   String[] bb  = temp2.split("\t");
	         // System.out.println("\n\n");
	         //int lieshu=aa.length;
	        
	          
	   
	          if(wwb!=null){  
	              //创建一个可写入的工作表  
	        
	                
	              //下面开始添加单元格  

	        	  
	        	  wwb.write(temp2+"\r\n");

	                i++;
	            
	 
	          }  
	          
	          
	        }
	            try {  
	                //从内存中写入文件中  
	                wwb.flush();  
	                //关闭资源，释放内存  
	                wwb.close();  
	             } catch (IOException e) {  
	                e.printStackTrace();  
	  
	  ////////////////////////// 
	        }
	        
	        } 

			 }catch (IOException e) {
		            e.printStackTrace();
		}
	}
	 
	 
	 
	 }


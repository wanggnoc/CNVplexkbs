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
	 
		 int biaoti=mm1;//��������
			int bianhao=mm2;//�����������
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
	                //����Ҫʹ��Workbook��Ĺ�����������һ����д��Ĺ�����(Workbook)����  
	          	  String outputFile=xlslj+temp+benlai+".txt";
	                wwb = new FileWriter(outputFile);
	                //Workbook��createSheet������������������һ���ǹ���������ƣ��ڶ����ǹ������ڹ������е�λ��  
	          
	             } catch (IOException e) {  
	                e.printStackTrace();  
	            } 
	            ////д����////////////////////////////////////////////////////////////
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
	              //����һ����д��Ĺ�����  
	        
	                
	              //���濪ʼ��ӵ�Ԫ��  

	        	  
	        	  wwb.write(temp2+"\r\n");

	                i++;
	            
	 
	          }  
	          
	          
	        }
	            try {  
	                //���ڴ���д���ļ���  
	                wwb.flush();  
	                //�ر���Դ���ͷ��ڴ�  
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


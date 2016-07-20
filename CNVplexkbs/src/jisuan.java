import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class jisuan {
	public ArrayList yanben;
    public ArrayList sample;
    public ArrayList sample0;
    public ArrayList sample1;
    public ArrayList Xb;
	public ArrayList Xbnum;

    
	public ArrayList getSample()
	{
		return this.sample;
	}
	public ArrayList getSample0()
	{
		return this.sample0;
	}
	
	public ArrayList getSample1()
	{
		return this.sample1;
	}
	
	public ArrayList getYanben()
	{
		return this.yanben;
	}
	
	public ArrayList getXb()
	{
		return this.Xb;
	}
	
	public ArrayList getXbnum()
	{
		return this.Xbnum;
	}
	

 public HashMap calc(File file2,File file1) throws Exception
   {	//File file2=new File("F:/perl/7.7/一代微缺失微重复分析所用文件/一代微缺失微重复分析所用文件/原始数据/A1.txt");
	 //set记录有哪些group
	 Set refGroup=new HashSet();
		HashMap zhong=new HashMap();
		ArrayList jiade=new ArrayList();
		//读取数据检测文件
 		BufferedReader br2=new BufferedReader(new FileReader(file2));
 	   String s=null;
 		String tmp=br2.readLine();
			Pattern patternn = Pattern.compile("\t");
			String[] biaoti = patternn.split(tmp); //标题记录对应位置
        ArrayList biaotiList=new ArrayList();
        for(int uu=0;uu<biaoti.length;uu++){
        	biaotiList.add(biaoti[uu]);
        }
     	
        int male_female;
 		 yanben=new ArrayList();Xb=new ArrayList();Xbnum=new ArrayList();
 	    sample=new ArrayList(); sample0=new ArrayList(); sample1=new ArrayList();
 		ArrayList control=new ArrayList();ArrayList control0=new ArrayList();ArrayList control1=new ArrayList();
  		///
 			while((s=br2.readLine())!=null){
 				Pattern patternn2 = Pattern.compile("\t");
 				String[] strs = patternn2.split(s);
 				String s1=strs[0];
 				String s11=s1.toLowerCase();
 				if(s11.indexOf("control")>=0){
 				//control.add( strs);
 				if(strs[3].equals("0")){control0.add(strs);Xb.add("女");Xbnum.add(4);}else{control1.add(strs);Xb.add("男");Xbnum.add(5);}	
 				sample.add(strs[1]+"/"+strs[2]);sample0.add(strs[1]);sample1.add(strs[2]);
 				yanben.add(strs);
 				}else{
 				if(strs[3].equals("0")){Xb.add("女");Xbnum.add(4);}else{Xb.add("男");Xbnum.add(5);}	
 				sample.add(strs[1]+"/"+strs[2]);sample0.add(strs[1]);sample1.add(strs[2]);
 				yanben.add(strs);
 				}
 			}
 		br2.close();
 		//无control则用样本的
		if(control0.size()<1 && control1.size()<1)
		{
			for(int ca=0;ca<yanben.size() ;ca++)
			{   String[] mp=(String[])yanben.get(ca);
			    if(mp[3].equals("0")){control0.add(yanben.get(ca));}else{control1.add(yanben.get(ca));}	
				
			}
		}
	
		if(control0.size()>control1.size())
		{
			control=control0;
			male_female=4;
			
		}else
		{
			control=control1;
			male_female=5;
		}
		//
	//读取文件一information
	//	File file1=new File("1-14R0328A_information-PA-ty.txt");
		BufferedReader brmz=new BufferedReader(new FileReader(file1));
		String sn=null;
		String yih=brmz.readLine();
		HashMap target=new HashMap();
		HashMap ref=new HashMap();
		HashMap meizu=new HashMap();
		HashMap chrom=new HashMap();
		while((sn=brmz.readLine())!=null)
		{

			Pattern pattenn = Pattern.compile("\t");
			String[] strs = pattenn.split(sn);

			meizu.put(strs[0],strs[3]);
			chrom.put(strs[0], strs[6]);
		}
		brmz.close();
		//计算校正样本该位点的正常拷贝数
		 File file_wz=new File("微缺失体系探针染色体位置拷贝数.txt");
		 HashMap zckb=new HashMap();
			BufferedReader brwz=new BufferedReader(new FileReader(file_wz));
				 sn=null;
				 brwz.readLine();
				while((sn=brwz.readLine())!=null)
				{
					Pattern patern3 = Pattern.compile("\t");
					String[] strs = patern3.split(sn);
			        zckb.put(strs[0],strs[male_female]);
			     
			        
				}
				brwz.close();
		
		//对ref循环，记录有哪些组
		Iterator iter = meizu.entrySet().iterator();
		  while (iter.hasNext()) { 			  
			Map.Entry entry = (Map.Entry) iter.next();
			refGroup.add(entry.getValue());
		  }
  
		//  System.out.println(yanben.size());
		  
		  
		   HashMap zhiR=new HashMap();
		  for(int numy=0;numy<yanben.size() ;numy++){//对每一样本进行计算
			 
			  HashMap zhiR2=new HashMap();
	    String[] mei_zu=(String[]) yanben.get(numy);
	    String[] mei=new String[biaotiList.size()];
	    if(mei_zu.length<biaotiList.size()){
	    	for(int bb=0;bb<mei_zu.length;bb++)
	    		mei[bb]=mei_zu[bb];
	    	for(int bb=mei_zu.length;bb<biaotiList.size();bb++)
	    		mei[bb]="0";
	    }else{ mei=mei_zu;}
	    
	    
		Iterator refite= refGroup.iterator(); //对每一group进行计算
		  while(refite.hasNext())
		  {
			  Object grou=refite.next();		
			  ////
			  Iterator taget1=meizu.entrySet().iterator();
			  ArrayList locu=new ArrayList();//记录同一组的locu
			  while(taget1.hasNext())
			  {
				  Map.Entry entry2=(Map.Entry) taget1.next();
					if(entry2.getValue().equals(grou)&&biaotiList.indexOf(entry2.getKey())>=0&& !(mei[biaotiList.indexOf(entry2.getKey())]).equals("")) //同一组的locu
					{
						locu.add(entry2.getKey());//同一组的locu
					}
			  }
			  //读取file2对数据文件 locu的每个值都除以参考的每个值，取其中值
			  //hashMap 			  
			   String zhit;
			   String zhir;
			 // System.out.println(grou+"=="+locu.size());
                 for(int i=0;i<locu.size();i++)
                 {     
         		//计算每个locu的ref
      			  Iterator ref1=meizu.entrySet().iterator();
      			  ArrayList cankao=new ArrayList();//记录同一组每个locu的ref
      			  while (ref1.hasNext()) { 			  
      					Map.Entry entry1 = (Map.Entry) ref1.next();
      					if(entry1.getValue().equals(grou) && (!chrom.get(entry1.getKey()).equals(chrom.get(locu.get(i))) )&& biaotiList.indexOf(entry1.getKey())>=0 && !(mei[biaotiList.indexOf(entry1.getKey())].toString()).equals(""))//同一组的ref
      					{
      						cankao.add(entry1.getKey());
      					}
      				  }
    			  ArrayList[] zhi =new ArrayList[cankao.size()];
    			  for(int wd=0; wd<zhi.length; wd++)
    			  {
    				  zhi[wd]=new ArrayList();
    			  }

    			  ArrayList[] zhiRm =new ArrayList[cankao.size()];
    			  for(int wd=0; wd<zhiRm.length; wd++)
    			  {
    				  zhiRm[wd]=new ArrayList();
    			  }
 	               //找位置计算R值
                	    for(int j=0;j<cankao.size();j++)//j是参考位点数目
                	    { 
                	       
                	    Double R	=Double.parseDouble(mei[biaotiList.indexOf(locu.get(i))])/Double.parseDouble(mei[biaotiList.indexOf(cankao.get(j))]);
                   	    zhi[j].add(R);
                	    
                	    }
                  //计算Rm值	    
	                    for(int j=0 ;j<cankao.size();j++)
	                    {	                    	
	                    	ArrayList<Double> zhongT1=new ArrayList();
	                    	for(int m=0;m<control.size();m++)
	                	    {
	                    		String[] contrRm = (String[]) control.get(m);
	                    		Double  R  =Double.parseDouble(contrRm[biaotiList.indexOf(locu.get(i))])/Double.parseDouble(contrRm[biaotiList.indexOf(cankao.get(j))]);
	                    		zhongT1.add(R);
	                    			
	                	    }
	           		        //取中位数
	   	   			        double tempz;
	   	   			        int leng=zhongT1.size();
	   	   			        Collections.sort(zhongT1);	      
	   	   			        if(zhongT1.size()%2==0){
	   	   			        	tempz=(zhongT1.get(leng/2-1)+zhongT1.get(leng/2))/2;	   	   			            
	   	   			        }else{
	   	   			        	tempz=zhongT1.get(leng/2) ;	   	   			            
	   	   			        }
	                    	
	   	   			         zhiRm[j].add(tempz); 
             	
	                	}	//end Rm
	
	                    //R/Rm
	                    ArrayList[]  RRm =new ArrayList[cankao.size()];
	      			  for(int wd=0; wd<RRm.length; wd++)
	      			  {
	      				  RRm[wd]=new ArrayList();
	      			  }
	                   
	                        for(int jj=0;jj<cankao.size();jj++)
	                        {
	                       	 for(int zz=0;zz<zhiRm[0].size();zz++)
	                           {
	                   	   RRm[jj].add((Double)(zhi[jj].get(zz))/(Double)(zhiRm[jj].get(zz))*(Double.parseDouble(zckb.get(locu.get(i)).toString())));
	                   	 
	                           }
	                        }
	     //取中位数，得到CN值
	                      
	   		            for (int jj=0;jj<1;jj++ )    	    
	   		            {
	   		            	ArrayList<Double> tpp=new ArrayList();
	   		            	for(int j3=0;j3<cankao.size();j3++)
	   		            	{
	   		            	 	tpp.add((Double)(RRm[j3].get(jj)));
	   		            	}
	   		            	 //取中位数
	      	   			        double tempz;
	      	   			        Collections.sort(tpp);	      
	      	   			        if(tpp.size()%2==0){
	      	   			        	tempz=(tpp.get(cankao.size()/2-1)+tpp.get(cankao.size()/2))/2;	   	   			            
	      	   			        }else{
	      	   			        	tempz=tpp.get(cankao.size()/2) ;	   	   			            
	      	   			        }
	      	   			     
	   		            	zhiR.put(mei[1]+"/"+mei[2]+"/"+locu.get(i),tempz); //得到CN值
	   		         
	   				   
	   		            }//end-CN值                  
	                    
	                                     	                    
	                    }//end-locu

		  }//end-每一group

	 
		    
	   //////////////////		  
			  
//			  Iterator itzhiR3 = zhiR.entrySet().iterator();
//			  while (itzhiR3.hasNext()) {
//				Map.Entry entry = (Map.Entry) itzhiR3.next();
//				Object key = entry.getKey();
//				Object val = entry.getValue();
//		        
//		        zhong.put(mei[0]+"/"+mei[1]+"/"+key, val);//得到最终值
//			  }//得到E值
//			  
			  
			  
		  
		  }//end每一样本
	
	   return zhiR;
   }
}

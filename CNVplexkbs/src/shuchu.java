import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class shuchu {
public ArrayList lvse=new ArrayList();
public ArrayList getLvse()
{
	return this.lvse;
}


public String[] getQue(ArrayList male_female,ArrayList sample0,ArrayList sample1,HashMap zhong ) throws Exception   //d表示第几个样本
{
	  double bj;
	  String[] out=new String[sample0.size()];		  
	  for(int wd=0;wd<out.length;wd++)
	  {
		  out[wd]="";
	  }
	  String[] outQue=new String[sample0.size()];		  
	  for(int wd=0;wd<outQue.length;wd++)
	  {
		  outQue[wd]="";
	  }
	  String[] outChong=new String[sample0.size()];		  
	  for(int wd=0;wd<outChong.length;wd++)
	  {
		  outChong[wd]="";
	  }
	  double bz;
	
	 for(int d=0;d<sample0.size();d++)
		  {
	 //读取探针位置
	 String outString;int start;int end;
	 HashMap weizhi3=new HashMap();
	 HashMap rst =new HashMap();
	 HashMap zckb=new HashMap();
	 HashMap shuchu=new HashMap();
	 File file_wz=new File("微缺失体系探针染色体位置拷贝数.txt");
	BufferedReader brwz=new BufferedReader(new FileReader(file_wz));
		String sn=null;
		 brwz.readLine();
		while((sn=brwz.readLine())!=null)
		{
			Pattern patern3 = Pattern.compile("\t");
			String[] strs = patern3.split(sn);
	        weizhi3.put(strs[0],strs[2]+"-"+strs[3]);
	        rst.put(strs[0], strs[1]);
	        zckb.put(strs[0],strs[Integer.parseInt(male_female.get(d).toString())]);
	        shuchu.put(strs[0], strs[1]+":"+strs[2]+"-"+strs[3]);
	        
		}
		brwz.close();
		//对每个染色体的处理
	    ArrayList all_chro = new ArrayList();
	    for(int x=1;x<23;x++)
	    {
	    	all_chro.add(x);
	    }
	    all_chro.add("X");
	    all_chro.add("Y");
		for (int v=1;v<25;v++)
		{
			HashMap<String,String> weizhi2=new HashMap(); 
			Iterator iterst=rst.entrySet().iterator();
			while(iterst.hasNext())  //  for(int vv=0;vv<rst.size();vv++)
			{
				Map.Entry entry = (Map.Entry) iterst.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if((val.toString()).equals(all_chro.get(v-1).toString()))
				{
					weizhi2.put(key.toString(),weizhi3.get(key).toString());
				}
			}
			//同一染色体的探针按位置排序
			List<Map.Entry<String, String>> list_weizhi2 = new ArrayList<Map.Entry<String, String>>(weizhi2.entrySet());  
			Collections.sort(list_weizhi2, new Comparator<Map.Entry<String, String>>()  
			    {    
			  public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)  
			  {  
				  String[] h1=o1.getValue().split("-");
				  String[] h2=o2.getValue().split("-");
				  	
			    if (Double.parseDouble(h2[0])-Double.parseDouble(h1[0])<0)  
			      return 1;  
			    else if(Double.parseDouble(h2[0])-Double.parseDouble(h1[0])==0)
			    {
			  	       return 0;
				    	    	  
			    }
			    else   
			      return -1;  
			  }  
				
			    });
	//对每个样本的运算
 ArrayList lsa=new ArrayList();
	    ArrayList lsay=new ArrayList();
	for(int v3=0;v3<list_weizhi2.size();v3++)
	{
		if(zhong.containsKey(sample0.get(d)+"/"+sample1.get(d)+"/"+list_weizhi2.get(v3).getKey())){
	 bz=Double.parseDouble(zckb.get(list_weizhi2.get(v3).getKey()).toString());	 //标准
	 bj=Double.parseDouble(zhong.get(sample0.get(d)+"/"+sample1.get(d)+"/"+list_weizhi2.get(v3).getKey()).toString());
	// double bj2 =bj*Double.parseDouble(zckb.get(list_weizhi2.get(v3).getKey()).toString());
	// zhong.put(sample.get(d)+list_weizhi2.get(v3).getKey(),bj2);
	 if(bj<bz-0.5 )	
	 {  lsa.add(1);lsay.add(1);}//1缺失
	 else if(bj>=bz+0.5)
	 { lsa.add(3);lsay.add(3);}//2重复
	 else
	 { lsa.add(0);lsay.add(0);}//0标准
	 }
	}
	while(lsa.indexOf(1)>=0)
		{
			outString="";
			start=lsa.indexOf(1);
			lsa.set(start,2);
			end=start;
			//outString +=mz.get(start)+",";
			 while(lsa.indexOf(1)==end+1)
			 {
				 end=lsa.indexOf(1);
			//	outString +=mz.get(end)+",";
				 lsa.set(end,2);
			 }
			 if(end-start+1>=3)
			 {
				
				 int inde=0;
				 for(int inde1=0;inde1<end-start;inde1++){
				
				String fg=weizhi3.get(list_weizhi2.get(start+inde1).getKey()).toString();
				String fg2=weizhi3.get(list_weizhi2.get(start+1+inde1).getKey()).toString();
				String[] f1= fg.split("-");
				String[] f2= fg2.split("-");	 	 				
				if(Double.parseDouble(f2[0])-Double.parseDouble(f1[1])+1>1000000)
				{
					
					inde=1;

				}
			   }
				 
				 if(inde==0)
				 {
					//满足条件 
					//输出结果
	 					for(int ss=start;ss<=end;ss++)
	 					{
	 						outString+=shuchu.get(list_weizhi2.get(ss).getKey())+",";
	 						this.lvse.add(list_weizhi2.get(ss).getKey());
	 					}
	 					if(outString.endsWith(",")){outString=outString.substring(0, outString.length()-1);}
	 					outQue[d]+=outString+";"; 
				 }
				 
				 
				 
			 }
			 
			 if(end-start+1==2 && start>1 && end<lsa.size()-2)
			 {
				String A=weizhi3.get(list_weizhi2.get(start-2).getKey()).toString();
				String B=weizhi3.get(list_weizhi2.get(start-1).getKey()).toString();
				String C=weizhi3.get(list_weizhi2.get(start).getKey()).toString();
				String D=weizhi3.get(list_weizhi2.get(end).getKey()).toString();
				String E=weizhi3.get(list_weizhi2.get(end+1).getKey()).toString();
				String F=weizhi3.get(list_weizhi2.get(end+2).getKey()).toString();
				String[] a= A.split("-");String[] b= B.split("-");String[] c= C.split("-");
				String[] dd= D.split("-");String[] e= E.split("-");String[] f= F.split("-");	 
				double cd=Double.parseDouble(dd[0])-Double.parseDouble(c[1])+1;
				double bc=Double.parseDouble(c[0])-Double.parseDouble(b[1])+1;
				double de=Double.parseDouble(e[0])-Double.parseDouble(dd[1])+1;
				double ac=Double.parseDouble(c[0])-Double.parseDouble(a[1])+1;
				double df=Double.parseDouble(f[0])-Double.parseDouble(dd[1])+1;
				
				if(cd<1000000)
				{
				 if(bc>2*cd && de>2*cd)
				   {
					//输出结果
	 					for(int ss=start;ss<=end;ss++)
	 					{
	 						outString+=shuchu.get(list_weizhi2.get(ss).getKey())+",";
	 						this.lvse.add(list_weizhi2.get(ss).getKey());
	 					}
	 					if(outString.endsWith(",")){outString=outString.substring(0, outString.length()-1);}
	 					outQue[d]+=outString+";"; 
				   }
				 if(ac<=cd && lsay.get(start-2).equals(1) )
				   {
					//输出结果
	 					for(int ss=start-2;ss<=end;ss++)
	 					{
	 						if(!(outString.indexOf(shuchu.get(list_weizhi2.get(ss).getKey()).toString())>=0))
	 						{outString+=shuchu.get(list_weizhi2.get(ss).getKey())+",";
	 						this.lvse.add(list_weizhi2.get(ss).getKey());}
	 						
	 					}
	 					if(outString.endsWith(",")){outString=outString.substring(0, outString.length()-1);}
	 					outQue[d]+=outString+";"; 
				   }
				 if(df<=cd && lsay.get(end+2).equals(1) )
				   {
					//输出结果
	 					for(int ss=start;ss<end+2;ss++)
	 					{
	 						if(!(outString.indexOf(shuchu.get(list_weizhi2.get(ss).getKey()).toString())>=0)){
	 						outString+=shuchu.get(list_weizhi2.get(ss).getKey())+",";
	 						this.lvse.add(list_weizhi2.get(ss).getKey());}
	 						
	 					}
	 					if(outString.endsWith(",")){outString=outString.substring(0, outString.length()-1);}
	 					outQue[d]+=outString+";"; 
				   }
				 
				}
			 }
			 
		}
		
		 //if(outQue[d].equals("")){out[d]="正常";} 
		
}  //end-sample

 if(outQue[d].endsWith(";")){outQue[d]=outQue[d].substring(0, outQue[d].length()-1);}





}
   return outQue;
   }



//////////////获取outChong
public String[] getChong(ArrayList male_female,ArrayList sample0,ArrayList sample1,HashMap zhong ) throws Exception
{
	  double bj;
	  String[] out=new String[sample0.size()];		  
	  for(int wd=0;wd<out.length;wd++)
	  {
		  out[wd]="";
	  }

	  String[] outChong=new String[sample0.size()];		  
	  for(int wd=0;wd<outChong.length;wd++)
	  {
		  outChong[wd]="";
	  }
		
	  
		 for(int d=0;d<sample0.size();d++)
		  {
	 //读取探针位置
	 String outString;int start;int end;
	 HashMap weizhi3=new HashMap();
	 HashMap rst =new HashMap();
	 HashMap zckb=new HashMap();
	 HashMap shuchu=new HashMap();
	 File file_wz=new File("微缺失体系探针染色体位置拷贝数.txt");
	BufferedReader brwz=new BufferedReader(new FileReader(file_wz));
		String sn=null;
		 brwz.readLine();
		while((sn=brwz.readLine())!=null)
		{
			Pattern patern3 = Pattern.compile("\t");
			String[] strs = patern3.split(sn);
	        weizhi3.put(strs[0],strs[2]+"-"+strs[3]);
	        rst.put(strs[0], strs[1]);
	        zckb.put(strs[0],strs[Integer.parseInt(male_female.get(d).toString())]);
	        shuchu.put(strs[0], strs[1]+":"+strs[2]+"-"+strs[3]);
	        
		}
		brwz.close();
		//对每个染色体的处理
	    ArrayList all_chro = new ArrayList();
	    for(int x=1;x<23;x++)
	    {
	    	all_chro.add(x);
	    }
	    all_chro.add("X");
	    all_chro.add("Y");
		for (int v=1;v<25;v++)
		{
			HashMap<String,String> weizhi2=new HashMap(); 
			Iterator iterst=rst.entrySet().iterator();
			while(iterst.hasNext())  //  for(int vv=0;vv<rst.size();vv++)
			{
				Map.Entry entry = (Map.Entry) iterst.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if((val.toString()).equals(all_chro.get(v-1).toString()))
				{
					weizhi2.put(key.toString(),weizhi3.get(key).toString());
				}
			}
			//同一染色体的探针按位置排序
			List<Map.Entry<String, String>> list_weizhi2 = new ArrayList<Map.Entry<String, String>>(weizhi2.entrySet());  
			Collections.sort(list_weizhi2, new Comparator<Map.Entry<String, String>>()  
			    {    
			  public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)  
			  {  
				  String[] h1=o1.getValue().split("-");
				  String[] h2=o2.getValue().split("-");
				  	
			    if (Double.parseDouble(h2[0])-Double.parseDouble(h1[0])<0)  
			      return 1;  
			    else if(Double.parseDouble(h2[0])-Double.parseDouble(h1[0])==0)
			    {
			  	       return 0;
				    	    	  
			    }
			    else   
			      return -1;  
			  }  
				
			    });
	//对每个样本的运算
	double bz;
	// for(int d=0;d<sample.size();d++)
	  { ArrayList lsa=new ArrayList();
	    ArrayList lsay=new ArrayList();
	for(int v3=0;v3<list_weizhi2.size();v3++)
	{
		if(zhong.containsKey(sample0.get(d)+"/"+sample1.get(d)+"/"+list_weizhi2.get(v3).getKey())){
			 bz=Double.parseDouble(zckb.get(list_weizhi2.get(v3).getKey()).toString());	 //标准
			 bj=Double.parseDouble(zhong.get(sample0.get(d)+"/"+sample1.get(d)+"/"+list_weizhi2.get(v3).getKey()).toString());
			// double bj2 =bj*Double.parseDouble(zckb.get(list_weizhi2.get(v3).getKey()).toString());
			// zhong.put(sample.get(d)+list_weizhi2.get(v3).getKey(),bj2);
	 if(bj<bz-0.5 )	
	 {  lsa.add(1);lsay.add(1);}//1缺失
	 else if(bj>=bz+0.5)
	 { lsa.add(3);lsay.add(3);}//2重复
	 else
	 { lsa.add(0);lsay.add(0);}//0标准
	}
	
	while(lsa.indexOf(3)>=0)
		{
			outString="";
			start=lsa.indexOf(3);
			lsa.set(start,2);
			end=start;
			//outString +=mz.get(start)+",";
			 while(lsa.indexOf(3)==end+1)
			 {
				 end=lsa.indexOf(3);
			//	outString +=mz.get(end)+",";
				 lsa.set(end,2);
			 }
			 if(end-start+1>=3)
			 {
				
				 int inde=0;
				 for(int inde1=0;inde1<end-start;inde1++){
				
				String fg=weizhi3.get(list_weizhi2.get(start+inde1).getKey()).toString();
				String fg2=weizhi3.get(list_weizhi2.get(start+1+inde1).getKey()).toString();
				String[] f1= fg.split("-");
				String[] f2= fg2.split("-");	 	 				
				if(Double.parseDouble(f2[0])-Double.parseDouble(f1[1])+1>1000000)
				{
					
					inde=1;

				}
			   }
				 
				 if(inde==0)
				 {
					//满足条件 
					//输出结果
	 					for(int ss=start;ss<=end;ss++)
	 					{
	 						outString+=shuchu.get(list_weizhi2.get(ss).getKey())+",";
	 						this.lvse.add(list_weizhi2.get(ss).getKey());
	 					}
	 					if(outString.endsWith(",")){outString=outString.substring(0, outString.length()-1);}
	 					outChong[d]+=outString+";"; 
				 }
				 
				 
				 
			 }
			 
			 if(end-start+1==2 && start>1 && end<lsa.size()-2)
			 {
				String A=weizhi3.get(list_weizhi2.get(start-2).getKey()).toString();
				String B=weizhi3.get(list_weizhi2.get(start-1).getKey()).toString();
				String C=weizhi3.get(list_weizhi2.get(start).getKey()).toString();
				String D=weizhi3.get(list_weizhi2.get(end).getKey()).toString();
				String E=weizhi3.get(list_weizhi2.get(end+1).getKey()).toString();
				String F=weizhi3.get(list_weizhi2.get(end+2).getKey()).toString();
				String[] a= A.split("-");String[] b= B.split("-");String[] c= C.split("-");
				String[] dd= D.split("-");String[] e= E.split("-");String[] f= F.split("-");	 
				double cd=Double.parseDouble(dd[0])-Double.parseDouble(c[1])+1;
				double bc=Double.parseDouble(c[0])-Double.parseDouble(b[1])+1;
				double de=Double.parseDouble(e[0])-Double.parseDouble(dd[1])+1;
				double ac=Double.parseDouble(c[0])-Double.parseDouble(a[1])+1;
				double df=Double.parseDouble(f[0])-Double.parseDouble(dd[1])+1;
				
				if(cd<1000000)
				{
				 if(bc>2*cd && de>2*cd)
				   {
					//输出结果
	 					for(int ss=start;ss<=end;ss++)
	 					{
	 						outString+=shuchu.get(list_weizhi2.get(ss).getKey())+",";
	 						this.lvse.add(list_weizhi2.get(ss).getKey());
	 					}
	 					if(outString.endsWith(",")){outString=outString.substring(0, outString.length()-1);}
	 					outChong[d]+=outString+";"; 
				   }
				 if(ac<=cd && lsay.get(start-2).equals(3) )
				   {
					//输出结果
	 					for(int ss=start-2;ss<=end;ss++)
	 					{
	 						if(!(outString.indexOf(shuchu.get(list_weizhi2.get(ss).getKey()).toString())>=0))
	 						{outString+=shuchu.get(list_weizhi2.get(ss).getKey())+",";
	 						this.lvse.add(list_weizhi2.get(ss).getKey());}
	 						
	 					}
	 					if(outString.endsWith(",")){outString=outString.substring(0, outString.length()-1);}
	 					outChong[d]+=outString+";"; 
				   }
				 if(df<=cd && lsay.get(end+2).equals(3) )
				   {
					//输出结果
	 					for(int ss=start;ss<end+2;ss++)
	 					{
	 						if(!(outString.indexOf(shuchu.get(list_weizhi2.get(ss).getKey()).toString())>=0)){
	 						outString+=shuchu.get(list_weizhi2.get(ss).getKey())+",";
	 						this.lvse.add(list_weizhi2.get(ss).getKey());}
	 						
	 					}
	 					if(outString.endsWith(",")){outString=outString.substring(0, outString.length()-1);}
	 					outChong[d]+=outString+";"; 
				   }
				 
				}
			 }
			 
		}
		
		 //if(outQue[d].equals("")){out[d]="正常";} 
		 if(outChong[d].endsWith(";")){outChong[d]=outChong[d].substring(0, outChong[d].length()-1);}
}  //end-sample





	  }

}
		  }
   return outChong;
   


}
}
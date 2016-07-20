import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
  

public class cnvplexkbs {
	
	public cnvplexkbs(String fil1,String fil2,String fil3,String fil4,String fil5,String fil6,String fil7,String fil8,String fifiout) throws Exception{
	{
		
		//File file1=new File("F:/perl/6.29/线粒体CNV-information-1.txt" );
		//File file2=new File("F:/perl/6.29/线粒体CNV检测结果.txt" );
		File file2=new File(fil1);//F:/perl/7.7/一代微缺失微重复分析所用文件/一代微缺失微重复分析所用文件/原始数据/A1.txt");
		File fileA2=new File(fil2);//"F:/perl/7.7/一代微缺失微重复分析所用文件/一代微缺失微重复分析所用文件/原始数据/A2.txt");
		File fileB1=new File(fil3);//"F:/perl/7.7/一代微缺失微重复分析所用文件/一代微缺失微重复分析所用文件/原始数据/B1.txt");
		File fileB2=new File(fil4);//"F:/perl/7.7/一代微缺失微重复分析所用文件/一代微缺失微重复分析所用文件/原始数据/B2.txt");
		File fileC1=new File(fil5);//"F:/perl/7.7/一代微缺失微重复分析所用文件/一代微缺失微重复分析所用文件/原始数据/C1.txt");
		File fileC2=new File(fil6);//"F:/perl/7.7/一代微缺失微重复分析所用文件/一代微缺失微重复分析所用文件/原始数据/C2.txt");
		File fileD1=new File(fil7);//"F:/perl/7.7/一代微缺失微重复分析所用文件/一代微缺失微重复分析所用文件/原始数据/D1.txt");
		File fileD2=new File(fil8);//"F:/perl/7.7/一代微缺失微重复分析所用文件/一代微缺失微重复分析所用文件/原始数据/D2.txt");
		File file3=new File("线粒体CNV位置.txt");
		//读取八个info文件
		File file1=new File("1-14R0328A_information-PA-ty.txt");
		File infoB1=new File("1-14R0328A_information-PB-ty.txt");
		File infoC1=new File("1-14R0328A_information-PC-ty.txt");
		File infoD1=new File("1-14R0328A_information-PD-ty.txt");
		
		File infoA2=new File("2-PanelAinformation-new-ty.txt");
		File infoB2=new File("2-PanelBinformation-new-ty.txt");
		File infoC2=new File("2-PanelCinformation-new-ty.txt");
		File infoD2=new File("2-PanelDinformation-new-ty.txt");
		
		
		HashMap zhongAll=new HashMap(); //总的
		jisuan  js1=new jisuan();jisuan  js2=new jisuan();
		jisuan  js3=new jisuan();jisuan  js4=new jisuan();
		jisuan  js5=new jisuan();jisuan  js6=new jisuan();
		jisuan  js7=new jisuan();jisuan  js8=new jisuan();
		HashMap zong1=js1.calc(file2, file1);
		HashMap zong2=js2.calc(fileA2, infoA2);
		HashMap zong3=js3.calc(fileB1, infoB1);
		HashMap zong4=js4.calc(fileB2, infoB2);
		HashMap zong5=js5.calc(fileC1, infoC1);
		HashMap zong6=js6.calc(fileC2, infoC2);
		HashMap zong7=js7.calc(fileD1, infoD1);
		HashMap zong8=js8.calc(fileD2, infoD2);
		
		zhongAll.putAll(zong1);
		zhongAll.putAll(zong2);
		zhongAll.putAll(zong3);
		zhongAll.putAll(zong4);
		zhongAll.putAll(zong5);
		zhongAll.putAll(zong6);
		zhongAll.putAll(zong7);
		zhongAll.putAll(zong8);
		
		
		//得到样本
		ArrayList sample=js1.getYanben();
		ArrayList sample0=js1.getSample0();
		ArrayList sample1=js1.getSample1();
		ArrayList Xb=js1.getXb();
		
		//结果判定
		ArrayList Xbnum=js1.getXbnum();
		shuchu getOut =new shuchu();
		String[] outQue=getOut.getQue(Xbnum,sample0,sample1,zhongAll);
        String[] outChong=getOut.getChong(Xbnum,sample0,sample1,zhongAll);
		ArrayList ls=getOut.getLvse();
		
		
		
		
		//得到标题
	//	Set yanben=new HashSet();
		ArrayList biaoti1=new ArrayList();
		ArrayList biaoti2=new ArrayList();
		Iterator iter = zhongAll.entrySet().iterator();
		  while (iter.hasNext()) { 			  
			Map.Entry entry = (Map.Entry) iter.next();
			String tmp=entry.getKey().toString();
			String[] tmp2=tmp.split("/");
	//		yanben.add(tmp2[2]);
		  }
		//排序
			 
			 HashMap weizhi3=new HashMap();
			 HashMap rst =new HashMap();
			 HashMap zckb0=new HashMap();
			 HashMap zckb1=new HashMap();
			 HashMap shuchuwz=new HashMap();
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
			        zckb0.put(strs[0],strs[4]);
			        zckb1.put(strs[0],strs[5]);
			        shuchuwz.put(strs[0], strs[1]+":"+strs[2]+"-"+strs[3]);
			        
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
					Iterator itrst=rst.entrySet().iterator();
					while(itrst.hasNext())//for(int vv=0;vv<rst.size();vv++)
					{
						Map.Entry entry = (Map.Entry) itrst.next();
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
					list_weizhi2.iterator();
					for(int j=0;j<list_weizhi2.size();j++)
					{
						if(zhongAll.keySet().contains(sample0.get(0)+"/"+sample1.get(0)+"/"+list_weizhi2.get(j).getKey())){
						biaoti1.add(list_weizhi2.get(j).getKey());
						biaoti2.add(shuchuwz.get(list_weizhi2.get(j).getKey()));}
					}
					
				}
		
		
	//	System.out.println(biaoti1.size());
		//输出的标题
		//System.out.println(zhongAll.size());
		//set记录有哪些group
		// Set refGroup=new HashSet();
		//HashMap记录 目标(参照位点)、组、locus
		
		
		
		//从file1中得到locus，在file2的对应位置进行计算，file2的每个locus都有值，用HashMap存取
		
//		HashMap zhong=new HashMap();
//		ArrayList jiade=new ArrayList();
//		//读取数据检测文件
// 		BufferedReader br2=new BufferedReader(new FileReader(file2));
// 	   String s=null;
// 		String tmp=br2.readLine();
//			Pattern patternn = Pattern.compile("\t");
//			String[] biaoti = patternn.split(tmp); //标题记录对应位置
//        ArrayList biaotiList=new ArrayList();
//        for(int uu=0;uu<biaoti.length;uu++){
//        	biaotiList.add(biaoti[uu]);
//        }
//     	
//        int male_female;
// 		ArrayList yanben=new ArrayList();
// 		ArrayList sample=new ArrayList();ArrayList sample0=new ArrayList();ArrayList sample1=new ArrayList();
// 		ArrayList control=new ArrayList();ArrayList control0=new ArrayList();ArrayList control1=new ArrayList();
//  		///
// 			while((s=br2.readLine())!=null){
// 				Pattern patternn2 = Pattern.compile("\t");
// 				String[] strs = patternn2.split(s);
// 				String s1=strs[0];
// 				String s11=s1.toLowerCase();
// 				if(s11.indexOf("control")>=0){
// 				//control.add( strs);
// 				if(strs[3]=="0"){control0.add(strs);}else{control1.add(strs);}	
// 				sample.add(strs[0]+"/"+strs[1]+"/");sample0.add(strs[0]);sample1.add(strs[1]);
// 				yanben.add(strs);
// 				}else{
// 				sample.add(strs[0]+"/"+strs[1]+"/");sample0.add(strs[0]);sample1.add(strs[1]);
// 				yanben.add(strs);
// 				}
// 			}
// 		br2.close();
// 		//无control则用样本的
//		if(control0.size()<1 && control1.size()<1)
//		{
//			for(int ca=0;ca<yanben.size() ;ca++)
//			{   String[] mp=(String[])yanben.get(ca);
//			    if(mp[3]=="0"){control0.add(yanben.get(ca));}else{control1.add(yanben.get(ca));}	
//				
//			}
//		}
//		if(control0.size()>control1.size())
//		{
//			control=control0;
//			male_female=4;
//			
//		}else
//		{
//			control=control1;
//			male_female=5;
//		}
		//
		//读取文件一information
//		BufferedReader brmz=new BufferedReader(new FileReader(file1));
//		String sn=null;
//		String yih=brmz.readLine();
//		HashMap target=new HashMap();
//		HashMap ref=new HashMap();
//		HashMap meizu=new HashMap();
//		HashMap chrom=new HashMap();
//		while((sn=brmz.readLine())!=null)
//		{
//
//			Pattern pattenn = Pattern.compile("\t");
//			String[] strs = pattenn.split(sn);
//
//			meizu.put(strs[0],strs[3]);
//			chrom.put(strs[0], strs[6]);
//		}
//		brmz.close();
//		//对ref循环，记录有哪些组
//		Iterator iter = meizu.entrySet().iterator();
//		  while (iter.hasNext()) { 			  
//			Map.Entry entry = (Map.Entry) iter.next();
//			refGroup.add(entry.getValue());
//		  }
//  
//		  
//		  for(int numy=0;numy<yanben.size() ;numy++){//对每一样本进行计算
//			  HashMap zhiR=new HashMap();
//			  HashMap zhiR2=new HashMap();
//	    String[] mei=(String[]) yanben.get(numy);
//		Iterator refite= refGroup.iterator(); //对每一group进行计算
//		  while(refite.hasNext())
//		  {
//			  Object grou=refite.next();		
//			  ////
//			  Iterator taget1=meizu.entrySet().iterator();
//			  ArrayList locu=new ArrayList();//记录同一组的locu
//			  while(taget1.hasNext())
//			  {
//				  Map.Entry entry2=(Map.Entry) taget1.next();
//					if(entry2.getValue().equals(grou)&&biaotiList.indexOf(entry2.getKey())>=0) //同一组的locu
//					{
//						locu.add(entry2.getKey());//同一组的locu
//					}
//			  }
//			  //读取file2对数据文件 locu的每个值都除以参考的每个值，取其中值
//			  //hashMap 			  
//			   String zhit;
//			   String zhir;
//			  
//                 for(int i=0;i<locu.size();i++)
//                 {     
//         		//计算每个locu的ref
//      			  Iterator ref1=meizu.entrySet().iterator();
//      			  ArrayList cankao=new ArrayList();//记录同一组每个locu的ref
//      			  while (ref1.hasNext()) { 			  
//      					Map.Entry entry1 = (Map.Entry) ref1.next();
//      					if(entry1.getValue().equals(grou) && (!chrom.get(entry1.getKey()).equals(chrom.get(locu.get(i))) )&& biaotiList.indexOf(entry1.getKey())>=0)//同一组的ref
//      					{
//      						cankao.add(entry1.getKey());
//      					}
//      				  }
//    			  ArrayList[] zhi =new ArrayList[cankao.size()];
//    			  for(int wd=0; wd<zhi.length; wd++)
//    			  {
//    				  zhi[wd]=new ArrayList();
//    			  }
//
//    			  ArrayList[] zhiRm =new ArrayList[cankao.size()];
//    			  for(int wd=0; wd<zhiRm.length; wd++)
//    			  {
//    				  zhiRm[wd]=new ArrayList();
//    			  }
// 	               //找位置计算R值
//                	    for(int j=0;j<cankao.size();j++)//j是参考位点数目
//                	    { 
//                	    Double R	=Double.parseDouble(mei[biaotiList.indexOf(locu.get(i))])/Double.parseDouble(mei[biaotiList.indexOf(cankao.get(j))]);
//                   	    zhi[j].add(R);
//                	    
//                	    }
//                  //计算Rm值	    
//	                    for(int j=0 ;j<cankao.size();j++)
//	                    {	                    	
//	                    	ArrayList<Double> zhongT1=new ArrayList();
//	                    	for(int m=0;m<control.size();m++)
//	                	    {
//	                    		String[] contrRm = (String[]) control.get(m);
//	                    		Double  R  =Double.parseDouble(contrRm[biaotiList.indexOf(locu.get(i))])/Double.parseDouble(contrRm[biaotiList.indexOf(cankao.get(j))]);
//	                    		zhongT1.add(R);
//	                    			
//	                	    }
//	           		        //取中位数
//	   	   			        double tempz;
//	   	   			        int leng=zhongT1.size();
//	   	   			        Collections.sort(zhongT1);	      
//	   	   			        if(zhongT1.size()%2==0){
//	   	   			        	tempz=(zhongT1.get(leng/2-1)+zhongT1.get(leng/2))/2;	   	   			            
//	   	   			        }else{
//	   	   			        	tempz=zhongT1.get(leng/2) ;	   	   			            
//	   	   			        }
//	                    	
//	   	   			         zhiRm[j].add(tempz); 
//             	
//	                	}	//end Rm
//	
//	                    //R/Rm
//	                    ArrayList[]  RRm =new ArrayList[cankao.size()];
//	      			  for(int wd=0; wd<RRm.length; wd++)
//	      			  {
//	      				  RRm[wd]=new ArrayList();
//	      			  }
//	                   
//	                        for(int jj=0;jj<cankao.size();jj++)
//	                        {
//	                       	 for(int zz=0;zz<zhiRm[0].size();zz++)
//	                           {
//	                   	   RRm[jj].add((Double)(zhi[jj].get(zz))/(Double)(zhiRm[jj].get(zz)));
//	                   	 
//	                           }
//	                        }
//	     //取中位数，得到CN值
//	                      
//	   		            for (int jj=0;jj<1;jj++ )    	    
//	   		            {
//	   		            	ArrayList<Double> tpp=new ArrayList();
//	   		            	for(int j3=0;j3<cankao.size();j3++)
//	   		            	{
//	   		            	 	tpp.add((Double)(RRm[j3].get(jj)));
//	   		            	}
//	   		            	 //取中位数
//	      	   			        double tempz;
//	      	   			        Collections.sort(tpp);	      
//	      	   			        if(tpp.size()%2==0){
//	      	   			        	tempz=(tpp.get(cankao.size()/2-1)+tpp.get(cankao.size()/2))/2;	   	   			            
//	      	   			        }else{
//	      	   			        	tempz=tpp.get(cankao.size()/2) ;	   	   			            
//	      	   			        }
//	   		            	zhiR.put(locu.get(jj),tempz); //得到CN值
//	   		            	
//	   				  
//	   		            }//end-CN值                  
//	                    
//	                                     	                    
//	                    }//end-locu
//
//		  }//end-每一group

	 
		    
	   //////////////////		  
			  
//			  Iterator itzhiR3 = zhiR.entrySet().iterator();
//			  while (itzhiR3.hasNext()) {
//				Map.Entry entry = (Map.Entry) itzhiR3.next();
//				Object key = entry.getKey();
//				Object val = entry.getValue();
//		        
//		        zhong.put(mei[0]+"/"+mei[1]+"/"+key, val);//得到最终值
//			  }//得到E值
			  
			  
			  
		  
//		  }//end每一样本

		  //CNVplex线粒体判定
		  //对每个样本做判定
//		  double bj;
//		  String[] out=new String[sample.size()];		  
//		  for(int wd=0;wd<out.length;wd++)
//		  {
//			  out[wd]="";
//		  }
//		  String[] outQue=new String[sample.size()];		  
//		  for(int wd=0;wd<outQue.length;wd++)
//		  {
//			  outQue[wd]="";
//		  }
//		  String[] outChong=new String[sample.size()];		  
//		  for(int wd=0;wd<outChong.length;wd++)
//		  {
//			  outChong[wd]="";
//		  }
//		 for(int d=0;d<sample.size();d++)
//		   {
//		            //读取文件三
//	 		BufferedReader br33=new BufferedReader(new FileReader(file3));
//	 	 		 s=null;
//	 	 		br33.readLine();	 	 		
//	 	 		///开始每kb的计算
//	 	 	int  start=1; int end=0; ArrayList<Double> pd=new ArrayList();int end2=1;String outString="";
//	 	 			while((s=br33.readLine())!=null){
//	 	 				Pattern patern3 = Pattern.compile("\t");
//	 	 				String[] strs = patern3.split(s);
//	 	 				jiade.add(strs[3]);
//	 	 				 end=Integer.parseInt(strs[2]); 
//	 	 			   if(end-start+1<1000 || pd.size()<4)  {
//	 	 				  // System.out.println(zhong.size()+"-"+(sample.get(d)+strs[0]));
//	 	 				   bj=Double.parseDouble(zhong.get(sample.get(d)+strs[0]).toString());
//	 	 				   if(bj>=0.5){
//	 	 				   pd.add(bj);}
//	 	 				 end2=Integer.parseInt(strs[2]); 
//	 	 				 outString +=strs[0]+",";
//	 	 				   continue;}
//	 	 			   
//          		        //取中位数
//  	   			        double tempz;
//  	   			        int leng=pd.size();//System.out.println(pd.size());
//  	   			        Collections.sort(pd);	      
//  	   			        if(pd.size()%2==0){
//  	   			        	tempz=(pd.get(leng/2-1)+pd.get(leng/2))/2;	   	   			            
//  	   			        }else{
//  	   			        	tempz=pd.get(leng/2);	   	   			            
//  	   			        }//end中位数
//  	   			       // System.out.println("中值"+tempz);
//	 	 			if(tempz<0.8)
//	 	 			 {   if(outString.endsWith(",")){outString=outString.substring(0, outString.length()-1);}
//	 	 				out[d]+=outString+";"; //start+"-"+end2+";"+
//	 	 			 }
//	 	 			  pd=new ArrayList();
//	 	 			  bj=Double.parseDouble(zhong.get(sample.get(d)+strs[0]).toString());
//	 				   if(bj>=0.5){
//	 				   pd.add(bj);}
//	 				   outString="";
//	 				   outString+=strs[0]+',';
//	 	 			  start=Integer.parseInt(strs[1]);
//	 	 			end=Integer.parseInt(strs[2]);
//	 	 			}//文件三读取结束
//	 	 		br33.close();
//		  		 if(out[d].equals("")){out[d]="Normal";} 
//		  		 if(out[d].endsWith(";")){out[d]=out[d].substring(0, out[d].length()-1);}
//		   }  //end-sample
	
	  //读取探针位置
//		 String outString;int start;int end;
//		 HashMap weizhi3=new HashMap();
//		 HashMap rst =new HashMap();
//		 HashMap zckb=new HashMap();
//		 HashMap shuchu=new HashMap();
//		 File file_wz=new File("微缺失体系探针染色体位置拷贝数.txt");
//		BufferedReader brwz=new BufferedReader(new FileReader(file_wz));
//			String sn=null;
//			 brwz.readLine();
//			while((sn=brwz.readLine())!=null)
//			{
//				Pattern patern3 = Pattern.compile("\t");
//	 			String[] strs = patern3.split(sn);
//		        weizhi3.put(strs[0],strs[2]+"-"+strs[3]);
//		        rst.put(strs[0], strs[1]);
//		        zckb.put(strs[0],strs[male_female]);
//		        shuchu.put(strs[0], strs[1]+":"+strs[2]+"-"+strs[3]);
//		        
//			}
//			brwz.close();
//			//对每个染色体的处理
//			for (int v=1;v<23;v++)
//			{
//				HashMap<String,String> weizhi2=new HashMap(); 
//				for(int vv=0;vv<rst.size();vv++)
//				{
//					Map.Entry entry = (Map.Entry) rst.get(vv);
//					Object key = entry.getKey();
//					Object val = entry.getValue();
//					if(Integer.parseInt(val.toString())==v)
//					{
//						weizhi2.put(key.toString(),weizhi3.get(key).toString());
//					}
//				}
//				//同一染色体的探针按位置排序
//				List<Map.Entry<String, String>> list_weizhi2 = new ArrayList<Map.Entry<String, String>>(weizhi2.entrySet());  
//				Collections.sort(list_weizhi2, new Comparator<Map.Entry<String, String>>()  
//				    {    
//				  public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)  
//				  {  
//					  String[] h1=o1.getValue().split("-");
//					  String[] h2=o2.getValue().split("-");
//					  	
//				    if (Double.parseDouble(h2[0])-Double.parseDouble(h1[0])<0)  
//				      return 1;  
//				    else if(Double.parseDouble(h2[0])-Double.parseDouble(h1[0])==0)
//				    {
//				  	       return 0;
//					    	    	  
//				    }
//				    else   
//				      return -1;  
//				  }  
//					
//				    });
//			
				
				
//			}
	 //end读取位置
		//输出结果

	 String outputFile=fifiout;
		//写入excel
		Workbook wwb = null;
		
    wwb = new XSSFWorkbook();
    //Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置  
    Sheet ws = wwb.createSheet("sheet1");   
    XSSFCellStyle style = (XSSFCellStyle) wwb.createCellStyle();  
    style.setAlignment(XSSFCellStyle.ALIGN_CENTER); 
    Font fontx= wwb.createFont(); 
    fontx.setFontName("宋体");
    fontx.setColor(HSSFColor.RED.index); 
    
    Font fontd= wwb.createFont(); 
    fontd.setFontName("宋体");
    fontd.setColor(HSSFColor.GREEN.index); 
    
    XSSFCellStyle stylex = (XSSFCellStyle) wwb.createCellStyle();
    stylex.setFont(fontx);
    
    XSSFCellStyle styled = (XSSFCellStyle) wwb.createCellStyle();
    styled.setFont(fontd);
    
    XSSFCellStyle stylexb = (XSSFCellStyle) wwb.createCellStyle();
    stylexb.setFillForegroundColor(HSSFColor.GREEN.index);
    stylexb.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    
    XSSFCellStyle styledb = (XSSFCellStyle) wwb.createCellStyle();
    styledb.setFillForegroundColor(HSSFColor.RED.index);
    styledb.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    
    XSSFCellStyle stylexbd = (XSSFCellStyle) wwb.createCellStyle();
    stylexbd.setFont(fontx);
    stylexbd.setFillForegroundColor(HSSFColor.GREEN.index);
    stylexbd.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    
    XSSFCellStyle styledbd = (XSSFCellStyle) wwb.createCellStyle();
    styledbd.setFont(fontd);
    styledbd.setFillForegroundColor(HSSFColor.RED.index);
    styledbd.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    
    Row row0 = ws.createRow(0);
//    ws.setColumnView(0,19 );
//    ws.setColumnView(1,13 );
//    ws.setColumnView(2,10 );
//    for (int ls=60;ls<94;ls++){
//    ws.setColumnView(ls, 12);}
//    ws.getSettings().setDefaultColumnWidth(9); 
//    WritableCellFormat cellFormjz = new WritableCellFormat(); 
//    cellFormjz.setAlignment(Alignment.CENTRE);
//    
//    WritableFont font1 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE);  
//    WritableCellFormat cellFormat1 = new WritableCellFormat(font1);//cellFormat1.setWrap(true);
//    cellFormat1.setAlignment(Alignment.CENTRE);  
//    cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);  
    Cell c00=row0.createCell(0,Cell.CELL_TYPE_STRING);
    c00.setCellValue("检测编号");
    Cell c01=row0.createCell(1, Cell.CELL_TYPE_STRING);
    c01.setCellValue("样本");
    Cell c02=row0.createCell(2, Cell.CELL_TYPE_STRING);
    c02.setCellValue("性别");
    Cell c03=row0.createCell(3, Cell.CELL_TYPE_STRING);
    c03.setCellValue("缺失");
    Cell c04=row0.createCell(4, Cell.CELL_TYPE_STRING);
    c04.setCellValue("重复");	
    for(int tt=5;tt<biaoti1.size()+5;tt++)
	{  
	  Cell cc02=row0.createCell(tt,Cell.CELL_TYPE_STRING);cc02.setCellValue(biaoti2.get(tt-5).toString());  
	
	}
    for(int hb=0;hb<5;hb++){
    	  CellRangeAddress cra=new CellRangeAddress(0, 1, hb, hb);         
    	  //在sheet里增加合并单元格  
    	  ws.addMergedRegion(cra);} 
  int rowNum;Row row1;Row row3;
  row1=ws.createRow(1);
//  Cell c1=row1.createCell(0,Cell.CELL_TYPE_STRING);c1.setCellValue((sample0.get(0)).toString());
//  Cell c2=row1.createCell(1,Cell.CELL_TYPE_STRING);c2.setCellValue((sample1.get(0)).toString());
//  Cell c3=row1.createCell(2,Cell.CELL_TYPE_STRING);c3.setCellValue((Xb.get(0)).toString());
  for(int tt=5;tt<biaoti1.size()+5;tt++)
	{  
	  Cell cc02=row1.createCell(tt,Cell.CELL_TYPE_STRING);cc02.setCellValue(biaoti1.get(tt-5).toString());  
	
	}
  

     Row row2 = null;
	for( rowNum=2;rowNum<sample.size()+2 ;rowNum++)    	
          
	{
           
     row2=ws.createRow(rowNum);
  	
        	 Cell c1=row2.createCell(0,Cell.CELL_TYPE_STRING);c1.setCellValue((sample0.get(rowNum-2)).toString());
             Cell c2=row2.createCell(1,Cell.CELL_TYPE_STRING);c2.setCellValue((sample1.get(rowNum-2)).toString());
             Cell c3=row2.createCell(2,Cell.CELL_TYPE_STRING);c3.setCellValue((Xb.get(rowNum-2)).toString());c3.setCellStyle(style); 
             if(outQue[rowNum-2].equals("") && outChong[rowNum-2].equals("")){ Cell ct=row2.createCell(3,Cell.CELL_TYPE_STRING);ct.setCellValue("正常");	  CellRangeAddress cra=new CellRangeAddress(rowNum, rowNum, 3, 4);   ws.addMergedRegion(cra); ct.setCellStyle(style);    }
             else{
            	if(outQue[rowNum-2].length()>0){ Cell ct1=row2.createCell(3,Cell.CELL_TYPE_STRING);ct1.setCellValue(outQue[rowNum-2]);ct1.setCellStyle(stylexb);}	
            	if(outChong[rowNum-2].length()>0){ Cell ct2=row2.createCell(4,Cell.CELL_TYPE_STRING);ct2.setCellValue(outChong[rowNum-2]);ct2.setCellStyle(styledb);	}
             }
             for(int tt=5;tt<biaoti1.size()+5;tt++)
     		{ 
            	 if(zhongAll.containsKey(sample0.get(rowNum-2)+"/"+sample1.get(rowNum-2)+"/"+biaoti1.get(tt-5))){
            		 double ys=Double.parseDouble(zhongAll.get(sample0.get(rowNum-2)+"/"+sample1.get(rowNum-2)+"/"+biaoti1.get(tt-5)).toString());
                 	BigDecimal   doutpp   =   new   BigDecimal(ys);  
                 	Double   dout   =   doutpp.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  	
            		HashMap linshi; 
                 	if((Xb.get(rowNum-2)).toString().equals("女")){linshi=zckb0;}else{linshi=zckb1;}  
                 	if(ls.contains(biaoti1.get(tt-5)) && (dout<Double.parseDouble(linshi.get(biaoti1.get(tt-5)).toString())-0.5 ))
                 	{ Cell c4=row2.createCell(tt,Cell.CELL_TYPE_NUMERIC);c4.setCellValue(dout);c4.setCellStyle(stylexbd); }
                 	else if(ls.contains(biaoti1.get(tt-5)) && (dout>=Double.parseDouble(linshi.get(biaoti1.get(tt-5)).toString())+0.5 ))
                 	{ Cell c4=row2.createCell(tt,Cell.CELL_TYPE_NUMERIC);c4.setCellValue(dout);c4.setCellStyle(styledbd);}
                 	else if( !ls.contains(biaoti1.get(tt-5))&&dout<Double.parseDouble(linshi.get(biaoti1.get(tt-5)).toString())-0.5 )
                 	{Cell c4=row2.createCell(tt,Cell.CELL_TYPE_NUMERIC);c4.setCellValue(dout);c4.setCellStyle(stylex);}
                 	else if( !ls.contains(biaoti1.get(tt-5)) && dout>=Double.parseDouble(linshi.get(biaoti1.get(tt-5)).toString())+0.5)
                 	{Cell c4=row2.createCell(tt,Cell.CELL_TYPE_NUMERIC);c4.setCellValue(dout);c4.setCellStyle(styled);}
                   	else{Cell c4=row2.createCell(tt,Cell.CELL_TYPE_NUMERIC);c4.setCellValue(dout);}
            	 }
		}
         
	}    
//		ws.mergeCells(0, 0, 0, 1);ws.mergeCells(1, 0, 1, 1);ws.mergeCells(2, 0, 2, 1);ws.mergeCells(3, 0, 3, 1);ws.mergeCells(4, 0, 4, 1);
//	    WritableFont font11 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.RED);  
//	    WritableCellFormat cellFormat11 = new WritableCellFormat(font11); 
//	    cellFormat11.setAlignment(Alignment.CENTRE);
//	    
//	    WritableFont font22 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.GREEN);  
//	    WritableCellFormat cellFormat22 = new WritableCellFormat(font22); 
//	    cellFormat22.setAlignment(Alignment.CENTRE);
	    
//        for(int t2=0;t2<sample.size();t2++)
//        {     
//        	Label c20=new Label(0,t2+2,sample0.get(t2).toString(),cellFormjz);
//        	ws.addCell(c20);
//        	Label c21=new Label(1,t2+2,sample1.get(t2).toString(),cellFormjz);
//        	ws.addCell(c21);
//        	Label c21a=new Label(2,t2+2,Xb.get(t2).toString(),cellFormjz);
//        	ws.addCell(c21a);
//        	//Label c22=new Label(3,t2+2,out[t2],cellFormjz);
//        	//ws.addCell(c22);
//        	for(int t3=0;t3<10 ;t3++)
//        	{   
//        		double ys=Double.parseDouble(zhongAll.get(sample0.get(t2)+"/"+sample1.get(t2)+"/"+biaoti1.get(t3)).toString());
//        	BigDecimal   doutpp   =   new   BigDecimal(ys);  
//        	Double   dout   =   doutpp.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  	
//        	//if(ys<0.8 && ys>=0.5){
//        	//Label c2n =new Label(t3+1,t2+2,Double.toString(dout),cellFormat11);	
//        	//ws.addCell(c2n);	
//        	//	}else if(ys<0.5){
//        	//Label c2n =new Label(t3+1,t2+2,Double.toString(dout),cellFormat22);
//        	//ws.addCell(c2n);}else{
//            	Label c2n =new Label(t3+5,t2+2,Double.toString(dout),cellFormjz);
//            	ws.addCell(c2n);	
//        	//}
//        	
//        	}
//
//        }
//		 try {  
// 		     //从内存中写入文件中  
// 		     wwb.write();  
// 		     //关闭资源，释放内存  
// 		     wwb.close();  
// 		  } catch (IOException e) {  
// 		     e.printStackTrace();  
// 		  } catch (WriteException e) {  
// 		     e.printStackTrace();  
// 		 } 		
         OutputStream stream = new FileOutputStream(outputFile);

         wwb.write(stream);

         stream.close();
    
	
	}//end-main
}	

}


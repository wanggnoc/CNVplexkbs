
/*    */ public class BasicTextbox
/*    */ {
/*    */   private String label;
/*    */   private String value;
/*    */   private String tooltip;
/*    */   private boolean slider;
/* 10 */   private double min = 0.0D;
/* 11 */   private double max = 0.0D;
/*    */   private int index;
/*    */ 
/*    */   public BasicTextbox(String paramString1, String paramString2, String paramString3)
/*    */   {
/* 17 */     this.label = paramString1;
/* 18 */     this.tooltip = paramString2;
/* 19 */     this.value = paramString3;
/* 20 */     this.slider = false;
/*    */   }
/*    */ 
/*    */   public void setLabel(String paramString)
/*    */   {
/* 25 */     this.label = paramString;
/*    */   }
/*    */ 
/*    */   public void setValue(String paramString)
/*    */   {
/* 30 */     this.value = paramString;
/*    */   }
/*    */ 
/*    */   public void setToolTip(String paramString)
/*    */   {
/* 35 */     this.tooltip = paramString;
/*    */   }
/*    */ 
/*    */   public void setIndex(int paramInt)
/*    */   {
/* 40 */     this.index = paramInt;
/*    */   }
/*    */ 
/*    */   public void setSlider(boolean paramBoolean)
/*    */   {
/* 45 */     this.slider = paramBoolean;
/*    */   }
/*    */ 
/*    */   public void setMax(double paramDouble)
/*    */   {
/* 50 */     this.max = paramDouble;
/*    */   }
/*    */ 
/*    */   public void setMin(double paramDouble)
/*    */   {
/* 55 */     this.min = paramDouble;
/*    */   }
/*    */ 
/*    */   public String getLabel()
/*    */   {
/* 60 */     return this.label;
/*    */   }
/*    */ 
/*    */   public String getValue()
/*    */   {
/* 65 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getToolTip()
/*    */   {
/* 70 */     return this.tooltip;
/*    */   }
/*    */ 
/*    */   public int getIndex()
/*    */   {
/* 75 */     return this.index;
/*    */   }
/*    */ 
/*    */   public boolean getSlider()
/*    */   {
/* 80 */     return this.slider;
/*    */   }
/*    */ 
/*    */   public double getMax()
/*    */   {
/* 85 */     return this.max;
/*    */   }
/*    */ 
/*    */   public double getMin()
/*    */   {
/* 90 */     return this.min;
/*    */   }
/*    */ }

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     core.BasicTextbox
 * JD-Core Version:    0.5.3
 */
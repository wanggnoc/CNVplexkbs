
/*     */ import java.io.File;
/*     */ import javax.swing.filechooser.FileFilter;
/*     */ 
/*     */ public class FileFilterStore extends FileFilter
/*     */ {
/*     */   private String[] validEndings;
/*     */ 
/*     */   public FileFilterStore(String[] paramArrayOfString)
/*     */   {
/*  27 */     if (paramArrayOfString == null)
/*     */     {
/*  29 */       this.validEndings = new String[0];
/*  30 */       return;
/*     */     }
/*     */ 
/*  33 */     this.validEndings = new String[paramArrayOfString.length];
/*     */ 
/*  35 */     for (int i = 0; i < paramArrayOfString.length; ++i)
/*     */     {
/*  37 */       this.validEndings[i] = paramArrayOfString[i].toLowerCase();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean accept(File paramFile)
/*     */   {
/*  49 */     String str1 = null;
/*     */ 
/*  52 */     if (paramFile.isDirectory())
/*     */     {
/*  54 */       return true;
/*     */     }
/*     */ 
/*  58 */     String str2 = paramFile.getName();
/*  59 */     int i = str2.lastIndexOf(46);
/*     */ 
/*  62 */     if ((i > 0) && (i < str2.length() - 1))
/*     */     {
/*  64 */       str1 = str2.substring(i + 1).toLowerCase();
/*     */     }
/*     */ 
/*  68 */     if (this.validEndings.length == 0)
/*     */     {
/*  70 */       return true;
/*     */     }
/*     */ 
/*  73 */     for (int j = 0; j < this.validEndings.length; ++j)
/*     */     {
/*  76 */       if ((str1 != null) && (str1.equals(this.validEndings[j])))
/*     */       {
/*  78 */         return true;
/*     */       }
/*     */     }
/*     */ 
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */   public String getDescription()
/*     */   {
/*  93 */     String str = "";
/*     */ 
/*  95 */     for (int i = 0; i < this.validEndings.length; ++i)
/*     */     {
/*  97 */       str = str + "." + this.validEndings[i] + " ";
/*     */     }
/*     */ 
/* 100 */     return str;
/*     */   }
/*     */ }

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     gui.FileFilterStore
 * JD-Core Version:    0.5.3
 */
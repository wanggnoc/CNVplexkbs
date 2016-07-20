
/*     */ import javax.swing.SwingUtilities;
/*     */ 
/*     */ public abstract class SwingWorker
/*     */ {
/*     */   private Object value;
/*     */   private Thread thread;
/*     */   private ThreadVar threadVar;
/*     */ 
/*     */   protected synchronized Object getValue()
/*     */   {
/*  39 */     return this.value;
/*     */   }
/*     */ 
/*     */   private synchronized void setValue(Object paramObject)
/*     */   {
/*  46 */     this.value = paramObject;
/*     */   }
/*     */ 
/*     */   public abstract Object construct();
/*     */ 
/*     */   public void finished()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void interrupt()
/*     */   {
/*  66 */     Thread localThread = this.threadVar.get();
/*  67 */     if (localThread != null) {
/*  68 */       localThread.interrupt();
/*     */     }
/*  70 */     this.threadVar.clear();
/*     */   }
/*     */ 
/*     */   public Object get()
/*     */   {
/*     */     while (true)
/*     */     {
/*  82 */       Thread localThread = this.threadVar.get();
/*  83 */       if (localThread == null)
/*  84 */         return getValue();
/*     */       try
/*     */       {
/*  87 */         localThread.join();
/*     */       }
/*     */       catch (InterruptedException localInterruptedException) {
/*  90 */         Thread.currentThread().interrupt();
/*  91 */         return null;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public SwingWorker()
/*     */   {
/* 102 */     Runnable local1 = new Runnable() {
/*     */       public void run() { SwingWorker.this.finished();
/*     */       }
/*     */     };
/* 106 */     Runnable local2 = new Runnable() {
/*     */       public void run() {
/*     */         try {
/* 109 */           SwingWorker.this.setValue(SwingWorker.this.construct());
/*     */         }
/*     */         finally {
/* 112 */           SwingWorker.this.threadVar.clear();
/*     */         }
/*     */ 
/* 115 */      //   SwingUtilities.invokeLater(this.val$doFinished);
/*     */       }
/*     */     };
/* 119 */     Thread localThread = new Thread(local2);
/* 120 */     this.threadVar = new ThreadVar(localThread);
/*     */   }
/*     */ 
/*     */   public void start()
/*     */   {
/* 127 */     Thread localThread = this.threadVar.get();
/* 128 */     if (localThread != null)
/* 129 */       localThread.start();
/*     */   }
/*     */ 
/*     */   private static class ThreadVar
/*     */   {
/*     */     private Thread thread;
/*     */ 
/*     */     ThreadVar(Thread paramThread)
/*     */     {
/*  27 */       this.thread = paramThread; } 
/*     */     synchronized Thread get() { return this.thread; } 
/*     */     synchronized void clear() { this.thread = null;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     gui.SwingWorker
 * JD-Core Version:    0.5.3
 */
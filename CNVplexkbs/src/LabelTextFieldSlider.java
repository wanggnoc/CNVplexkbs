
/*     */ import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;

/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JSlider;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
/*     */ import javax.swing.text.Document;
/*     */ 
/*     */ public class LabelTextFieldSlider extends LabelTextField
/*     */ {
/*     */   private JSlider slider;
/*  32 */   private int minimum = 0;
/*  33 */   private int maximum = 1;
/*     */ 
/*  35 */   private int precision = 100;
/*     */ 
/*     */   public LabelTextFieldSlider(String paramString1, String paramString2, double paramDouble1, double paramDouble2)
/*     */   {
/*  48 */     super(paramString1, paramString2);
/*     */ 
/*  50 */     this.minimum = (int)(this.precision * paramDouble1);
/*  51 */     this.maximum = (int)(this.precision * paramDouble2);
/*     */ 
/*  53 */     if (paramDouble1 >= paramDouble2)
/*     */     {
/*  55 */       paramDouble1 = 0.0D;
/*  56 */       paramDouble2 = 0.0D;
/*     */     }
/*     */ 
/*  59 */     initialize();
/*     */   }
/*     */ 
/*     */   public LabelTextFieldSlider(String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2)
/*     */   {
/*  64 */     super(paramString1, paramString2, paramBoolean);
/*     */ 
/*  66 */     this.minimum = (int)(this.precision * paramDouble1);
/*  67 */     this.maximum = (int)(this.precision * paramDouble2);
/*     */ 
/*  69 */     if (paramDouble1 >= paramDouble2)
/*     */     {
/*  71 */       paramDouble1 = 0.0D;
/*  72 */       paramDouble2 = 0.0D;
/*     */     }
/*     */ 
/*  75 */     initialize();
/*     */   }
/*     */ 
/*     */   public void setToolTipText(String paramString)
/*     */   {
/*  80 */     super.getTextField().setToolTipText(paramString);
/*  81 */     this.slider.setToolTipText(paramString);
/*     */   }
/*     */ 
/*     */   public void setMin(double paramDouble)
/*     */   {
/*  86 */     this.minimum = (int)(this.precision * paramDouble);
/*     */   }
/*     */ 
/*     */   public void setMax(double paramDouble)
/*     */   {
/*  91 */     this.maximum = (int)(this.precision * paramDouble);
/*     */   }
/*     */ 
/*     */   private String updateSliderValue()
/*     */   {
/*  96 */     String str = super.getText();
/*     */     try
/*     */     {
/* 100 */       int i = (int)(this.precision * Double.parseDouble(str));
/*     */ 
/* 102 */       if ((i >= this.minimum) && (i <= this.maximum))
/*     */       {
/* 104 */         this.slider.setValue(i);
/*     */       }
/*     */       else
/*     */       {
/* 108 */         this.slider.setValue(5);
/* 109 */         return "Only values between " + (this.minimum / this.precision) + " and " + (this.maximum / this.precision) + " are recommended.\nLarger values might cause odd results, use at your own risk.";
/*     */       }
/*     */     }
/*     */     catch (NumberFormatException localNumberFormatException)
/*     */     {
/* 114 */       this.slider.setValue(0);
/* 115 */       return "Only numbers are valid in this box.";
/*     */     }
/*     */ 
/* 118 */     return "";
/*     */   }
/*     */ 
/*     */   private String updateTextFieldValue()
/*     */   {
/* 123 */     double d = (double)(this.slider.getValue()) / this.precision;
/* 124 */     super.setText(Double.toString(d));
/*     */    
/* 126 */     return "";
/*     */   }
/*     */   public JSlider getJSlider()
            {
		       return this.slider;
            }

/*     */   private void initialize()
/*     */   {
/* 132 */     this.slider = new JSlider(this.minimum, this.maximum);
/*     */
/* 134 */     this.slider.addChangeListener(new SliderListener());
/* 135 */     this.slider.setPreferredSize(new Dimension(300, 23));
              this.slider.setBackground(new Color(235,244,252));
/* 136 */     updateSliderValue();
/*     */ 
/* 138 */     super.getTextField().addActionListener(new TextFieldActionListener());
/* 139 */     super.getTextField().getDocument().addDocumentListener(new TextFieldListener());
/*     */ 
/* 141 */     super.getTextField().setPreferredSize(new Dimension(100, 26));
/*     */     super.getLabel().setPreferredSize(new Dimension(140, 23));
/* 143 */     super.add(this.slider);
              //super.setLayout(new FlowLayout(0,10,3));

/*     */   }
/*     */ 
/*     */   private boolean showErrorMessage(String paramString)
/*     */   {
/* 148 */     if (paramString.length() == 0)
/*     */     {
/* 150 */       return false;
/*     */     }
/*     */ 
/* 153 */     JOptionPane.showMessageDialog(getParent(), paramString, "Error", 0);
/*     */ 
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean showInfoMessage(String paramString)
/*     */   {
/* 163 */     if (paramString.length() == 0)
/*     */     {
/* 165 */       return false;
/*     */     }
/*     */ 
/* 168 */     JOptionPane.showMessageDialog(getParent(), paramString, "Information", 2);
/*     */ 
/* 173 */     return true;
/*     */   }
/*     */ 
/*     */   private class SliderListener implements ChangeListener
/*     */      
/*     */   {
/*     */     public void stateChanged(ChangeEvent paramChangeEvent)
/*     */     {
/*     */       try
/*     */       {
/* 208 */         LabelTextFieldSlider.this.updateTextFieldValue();
/*     */       }
/*     */       catch (IllegalStateException localIllegalStateException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private class TextFieldListener
/*     */     implements DocumentListener
/*     */   {
/*     */     public void changedUpdate(DocumentEvent paramDocumentEvent)
/*     */     {
/* 190 */       LabelTextFieldSlider.this.updateSliderValue();
/*     */     }
/*     */ 
/*     */     public void removeUpdate(DocumentEvent paramDocumentEvent) {
/* 194 */       LabelTextFieldSlider.this.updateSliderValue();
/*     */     }
/*     */ 
/*     */     public void insertUpdate(DocumentEvent paramDocumentEvent) {
/* 198 */       LabelTextFieldSlider.this.updateSliderValue();
/*     */     }
/*     */   }
/*     */ 
/*     */   private class TextFieldActionListener
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent paramActionEvent)
/*     */     {
/* 180 */       JTextField localJTextField = (JTextField)paramActionEvent.getSource();
/*     */ 
/* 182 */       LabelTextFieldSlider.this.showInfoMessage( LabelTextFieldSlider.this.updateSliderValue());//LabelTextFieldSlider.access$300(LabelTextFieldSlider.this));
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\1\Documents\Tencent Files\819601560\FileRecv\Colombo_3.8\
 * Qualified Name:     gui.LabelTextFieldSlider
 * JD-Core Version:    0.5.3
 */
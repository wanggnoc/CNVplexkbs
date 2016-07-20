import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabelTextField extends JPanel
 {
 private JLabel label;
 private JTextField textField;
 private boolean etchedBorder = true;
 private boolean lockSize;

public LabelTextField(String paramString1, String paramString2)
 {
this.label = new JLabel(paramString1);
 this.textField = new JTextField(paramString2);
this.lockSize = false;

 initialisierung();
 }

public LabelTextField(String paramString1, String paramString2, boolean paramBoolean)
{
this.label = new JLabel(paramString1);
 this.textField = new JTextField(paramString2);
 this.lockSize = paramBoolean;

  initialisierung();
 }
 public LabelTextField(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
 {
 this.label = new JLabel(paramString1);
 this.textField = new JTextField(paramString2);
 this.lockSize = paramBoolean1;
this.etchedBorder = paramBoolean2;

 initialisierung();
 }
public JTextField getTextField()
  {
    return this.textField;
  }

public JLabel getLabel()
 {
    return this.label;
  }

  public void setText(String paramString)
  {
   this.textField.setText(paramString);
  }
  
  public void setLabel(String paramString)
  {
   this.label.setText(paramString);
  }

  public void setToolTipText(String paramString)
 {
   this.textField.setToolTipText(paramString);
  }

   public String getText()
 {
   return this.textField.getText();
  }

  public void setEtchedBorder(boolean paramBoolean)
  {
  this.etchedBorder = paramBoolean;
 }

 private void initialisierung()
 {
  if (this.lockSize)
{
this.label.setPreferredSize(new Dimension(250, 30));
 this.textField.setPreferredSize(new Dimension(150,30));
setLayout(new FlowLayout());
 add(this.label);
 add(this.textField);
 }
else
 {
 add(this.label);
  add(this.textField);

this.textField.setPreferredSize(new Dimension(400,30));
  setLayout(new FlowLayout(0));
}
  if (!(this.etchedBorder))
 return;
 //setBorder(BorderFactory.createEtchedBorder());
 setBackground(new Color(235,244,252));
 }
}
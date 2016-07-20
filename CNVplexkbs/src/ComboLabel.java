import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComboLabel extends JPanel
 {
 private JLabel label=new JLabel("kb");
 private JComboBox combo;



public ComboLabel (Object paramString1[])
 {
this.combo = new JComboBox(paramString1); 

 initialisierung();
 }


 private void initialisierung()
 {

this.label.setPreferredSize(new Dimension(150, 30));
 this.combo.setPreferredSize(new Dimension(400,30));
setLayout(new FlowLayout());
 add(this.combo);
 add(this.label);
 

 //setBorder(BorderFactory.createEtchedBorder());

}
 }
 import java.awt.FlowLayout;
 import javax.swing.BorderFactory;
 import javax.swing.BoxLayout;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
public class StatusBar extends JPanel{
       private JPanel lichtPanel = new JPanel();
	   private JPanel statusPanel = new JPanel();
	   private JLabel status;
	 
	  public StatusBar(String paramString)
   {
	  initialize(paramString);
	}
	 public void setLabelStatus(String paramString)
	{
	this.status.setText(paramString);
	}
	private void initialize(String paramString)
	 {
	  this.status = new JLabel(paramString);
	  this.statusPanel.add(this.status);
	  this.statusPanel.setLayout(new FlowLayout(1));
      add(this.statusPanel);
      setBorder(BorderFactory.createEtchedBorder());
	 setLayout(new BoxLayout(this, 0));
	 }
	}



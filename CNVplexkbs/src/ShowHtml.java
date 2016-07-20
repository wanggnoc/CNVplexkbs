

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


//import chrriis.common.UIUtils;
//import chrriis.dj.nativeswing.swtimpl.NativeInterface;
//import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

//import org.eclipse.swt.SWT; 
/**
 * @author Christopher Deckers
 */
public class ShowHtml extends JDialog {
	  public JFrame owner;
	  public String outhtml;
	  public String outhtml_temp;
	  public int xh;
	  public int dq=1;    //µ±Ç°
	//  final JWebBrowser webBrowser;
	  public JButton b1;
	  public JButton b2;
	  public JLabel l1;
	  
  public ShowHtml(JFrame paramJFrame) {
	    super(paramJFrame, "The picture to present information of the genome!", true);
    	this.owner=paramJFrame;  
    	xh=((ISEWMainFrame) ShowHtml.this.owner).getm();
    	
    	if (((ISEWMainFrame) ShowHtml.this.owner).getmzhen()==0){
    	outhtml= ((ISEWMainFrame) ShowHtml.this.owner).getoutHtml()+".html";
    	}else{
    	outhtml= ((ISEWMainFrame) ShowHtml.this.owner).getoutHtml()+"_sequence1.html";
    	outhtml_temp=((ISEWMainFrame) ShowHtml.this.owner).getoutHtml();
    	}
    	setSize(1200, 700);
	  Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((localDimension.width - getSize().width) / 2, (localDimension.height - getSize().height) / 2);
   // super("The picture of genome to present the prediction results.");
    JPanel webBrowserPanel = new JPanel(new BorderLayout());
   // webBrowserPanel.setBorder(BorderFactory.createTitledBorder("Native Web Browser component"));
  
  //  webBrowser = new JWebBrowser();
  //  webBrowser.navigate(outhtml);
 //   webBrowser.setButtonBarVisible(false);
 //   webBrowser.setMenuBarVisible(false);
 //   webBrowser.setBarsVisible(false);
 //   webBrowser.setStatusBarVisible(false);
   // webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
//   add(webBrowser, BorderLayout.CENTER);

    // Create an additional bar allowing to show/hide the menu bar of the web browser.
   JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
//   JCheckBox menuBarCheckBox = new JCheckBox("Menu Bar", webBrowser.isMenuBarVisible());
        this.b1=new JButton("Previous"); b1.setEnabled(false);
        this.b2=new JButton("Next");
        this.l1=new JLabel("Genome");
   buttonPanel.add(b1);buttonPanel.add(new JLabel());buttonPanel.add(l1);buttonPanel.add(new JLabel());buttonPanel.add(b2);
   b1.setActionCommand("b1");b2.setActionCommand("b2");
    b1.addActionListener(new ButtonLeisteActionListener());b2.addActionListener(new ButtonLeisteActionListener());
  
   add(buttonPanel, BorderLayout.SOUTH);
 
   
   
   if(((ISEWMainFrame) ShowHtml.this.owner).getmzhen()==0)
	   buttonPanel.setVisible(false);
   
   
   
  }

  private class ButtonLeisteActionListener
  implements ActionListener
{
public void actionPerformed(ActionEvent paramActionEvent)
 {
String str = paramActionEvent.getActionCommand();
if  (str.equals("b1"))
  {     
	b2.setEnabled(true);
	if (dq==2){
	b1.setEnabled(false);
		dq=dq-1;
	}else{
		dq=dq-1;
	}
	l1.setText("Genome "+dq);
//	webBrowser.navigate(outhtml_temp+"_sequence"+dq+".html");	
		
	
  }
else if(str.equals("b2")){
	b1.setEnabled(true);
	if (dq==xh-1){
	b2.setEnabled(false);
	    dq=dq+1;
	}else{
		dq=dq+1;
	}
	l1.setText("Genome"+dq);
	//webBrowser.navigate(outhtml_temp+"_sequence"+dq+".html");	
		
	

  }
 }
} 

}
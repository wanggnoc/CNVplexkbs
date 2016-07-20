
import java.awt.event.*;
import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.BevelBorder;

//import com.mathworks.toolbox.javabuilder.MWException;
public class MenuBar extends JMenuBar {
	private ISEWMainFrame owner;
	 ImageIcon openIcon = new ImageIcon(this.getClass().getResource("/images/open.gif"));
	 ImageIcon saveIcon = new ImageIcon(this.getClass().getResource("/images/save.gif"));
     ImageIcon exitIcon = new ImageIcon(this.getClass().getResource("/images/exit.gif"));
	 ImageIcon readmeIcon = new ImageIcon(this.getClass().getResource("/images/readme.gif"));
	 ImageIcon infoIcon = new ImageIcon(this.getClass().getResource("/images/info.gif"));
	 private JMenu fileMenu = new JMenu("File");
	 private JMenuItem openInput = new JMenuItem("Open Input", this.openIcon);
	 private JMenuItem setOutput = new JMenuItem("Set Output", this.saveIcon);
	 private JMenuItem exit = new JMenuItem("Exit", this.exitIcon);
	 private JMenu methodMenu = new JMenu("Method");
	 private JMenuItem yibu=new JMenuItem("IST-LFS");
	 private JMenuItem twobu = new JMenuItem("MTGIpick");
	 private JMenuItem threebu = new JMenuItem("threebu");
	 private JMenu helpMenu = new JMenu("Help");
	 private JMenuItem readme = new JMenuItem("Readme", this.readmeIcon);
	 private JMenuItem info = new JMenuItem("Info", this.infoIcon);
 
	 public MenuBar(ISEWMainFrame paramISEWMainFrame)
	  {
	   //setBorder(new BevelBorder(BevelBorder.RAISED));
	   this.owner = paramISEWMainFrame;
	   initialise();
	  }
		
	 public void initialise()
	  {
		 this.fileMenu.add(this.openInput);
	//	 this.fileMenu.add(this.setOutput);
		 this.fileMenu.add(this.exit);
		 this.methodMenu.add(this.yibu);
		 this.methodMenu.add(this.twobu);
		 //this.methodMenu.add(this.threebu);
		 this.helpMenu.add(this.readme);
		 this.helpMenu.add(this.info);
		 this.openInput.addActionListener(new MenuActionListener());
		 this.setOutput.addActionListener(new MenuActionListener());
		 this.exit.addActionListener(new MenuActionListener());
		 this.yibu.addActionListener(new MenuActionListener());
		 this.twobu.addActionListener(new MenuActionListener());
		 this.threebu.addActionListener(new MenuActionListener());
		 this.readme.addActionListener(new MenuActionListener());
		 this.info.addActionListener(new MenuActionListener());
		 add(this.fileMenu);
		 add(this.methodMenu);
		 add(this.helpMenu);
	     setBackground(Color.WHITE);
	  }
		
	 private class MenuActionListener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
		 if(e.getSource()==openInput){
			 try {
				MenuBar.this.owner.setInputFile(MenuBar.this.openInput);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 }else if (e.getSource()==exit){
			 MenuBar.this.owner.exit();
		 }else if (e.getSource()==yibu){
             MenuBar.this.owner.showFirstStepDialog();
		 }else if (e.getSource()==twobu){
			 MenuBar.this.owner.showAllStepDialog();
		 }else if (e.getSource()==threebu){
			 
		 }else
		  {
			 Object localObject;
			 if (e.getSource()==readme){
		      localObject = new ReadmeDialog(MenuBar.this.owner);
		       ((ReadmeDialog)localObject).setVisible(true);
			 }
			else if (e.getSource()==info){
			 
		     }
	      }
		 }
	 }
}
	  
	 
	
	
	
	



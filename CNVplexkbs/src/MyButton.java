import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyButton extends JButton {
	private String text;

	MyButton(String text) {
	 Shape shape;
	 this.text = text;  
	 Dimension preferredSize = getPreferredSize();  
     Dimension preferredSizeNew = new Dimension(preferredSize.width,  
             preferredSize.height);  
     setPreferredSize(preferredSizeNew);  
     
 }  
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; //
		int width = this.getPreferredSize().width;  
        int height = this.getPreferredSize().height;  
		int li_beginx = (int) g2.getClipBounds().getX(); //
		int li_beginy = (int) g2.getClipBounds().getY(); //
		int li_width = getSize().width;
		int li_height =  getSize().height;
		g2.setColor(new Color(54,173,237));
    	g2.drawOval(0,0,getSize().width,getSize().height);
		g2.setColor(Color.WHITE); //
		g2.drawRect(li_beginx, li_beginy,74, 27); //画边框
    	Color colors = new Color(60,167,255);
    	setBackground(colors);
		Color bgColor = this.getBackground(); //
		int[] li_fromcolor = new int[] { bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue() }; //传入的背景颜色的RGB的值!
		int[][] li_delcolors = getDelColors(li_fromcolor, li_height - 2); //关键计算,根据高度，计算出每帧高度的渐变颜色!!!
		for (int i = 0; i < li_delcolors.length; i++) {  //循环画出每一帧！！
			int li_r = li_fromcolor[0] + (int)(0.9*li_delcolors[i][0]); //R
			int li_g = li_fromcolor[1] + (int)0.6*li_delcolors[i][1]; //G
			int li_b = li_fromcolor[2] + (int)0.8*li_delcolors[i][2]; //B
			if (li_r > 255) {  //如果溢出255,则当255,否则报错!
				li_r = 255;
			}
			if (li_g > 255) {
				li_g = 255;
			}
			if (li_b > 255) {
				li_b = 255;
			}
			g2.setColor(new Color(li_r, li_g, li_b)); //设置颜色!!
			g2.fillRect(0 + 1, i + 1, li_width - 2, 1); //
		}

		g2.setColor(Color.WHITE); //
		//g2.setFont(new Font("宋体", Font.PLAIN, 18)); //
		g2.drawString(text, 19, 17); //
	}

	//颜色递减!!! 即要有一个算法,呈某种递减速度就会出现不同效果!!!
	//出现光感效果的原理是上半部
	private int[][] getDelColors(int[] _fromColor, int _height) {
		int[][] delColor = new int[_height][3]; //
		int li_half = _height / 2; //一半!
		if (li_half == 0) {
			li_half = 1;
		}
		int li_d1 = 100 / li_half; //如果是10,则递减10,如果是100,则递减1
		if (li_d1 == 0) {
			li_d1 = 1;
		}
		int li_prefix = 87; //有个前辍,可以随便设个值,就看你想渐变得白的还是黑的!
		for (int i = li_half - 1; i >= 0; i--) { //
			delColor[i][0] = li_prefix + (li_half - 1 - i) * li_d1;
			delColor[i][1] = li_prefix + (li_half - 1 - i) * li_d1;
			delColor[i][2] = li_prefix + (li_half - 1 - i) * li_d1;
		}
		int li_d2 = (int) ((100 / li_half) * 0.3); //关键这里有个系数变化,才会出现光感，水波等效果
		if (li_d2 == 0) {
			li_d2 = 1;
		}
		for (int i = li_half; i < _height; i++) {
			delColor[i][0] = (i - li_half) * li_d2; //
			delColor[i][1] = (i - li_half) * li_d2; //
			delColor[i][2] = (i - li_half) * li_d2; //
		}
		return delColor;
	}
	
	public void setContext(String text)
	{
		 this.text = text;  
		
	}
	
	public String getContext()
	{
		 return this.text;  
		
	}

}

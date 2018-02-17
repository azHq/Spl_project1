package mouseAd;

import javax.swing.JFrame;

public class MainClass {
	
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("MD.EZAZUL HAQUE");
		SholoGuti sl=new SholoGuti();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1900,1000);
		frame.add(sl);
		frame.setVisible(true);
		
	}

}

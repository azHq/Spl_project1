package mouseAd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SholoGuti extends JPanel implements ActionListener,MouseListener {
	
	

	
		private int[][] arr= {{80,245,1},{80,480,1},{80,730,1},{210,330,1},{210,475,1},{210,630,1},   {435,135,1},{435,295,1},{435,475,1},{435,655,1},{435,835,1},  {680,135,1},{680,295,1},{680,475,1},{680,655,1},{680,835,1}, {930,135,0},{930,295,0},{930,475,0},{930,655,0},{930,835,0}, 
						
						 {1180,135,2},{1180,295,2},{1180,475,2},{1180,655,2},{1180,835,2},  {1430,135,2},{1430,295,2},{1430,475,2},{1430,655,2},{1430,835,2},  {1645,330,2},{1645,480,2},{1645,630,2},{1780,245,2},{1780,475,2},{1780,730,2}};
			
		private int x=940,y=485;  //940,485,
		private Timer timer;
		private int delay=6;
		private int f=1,g,h=1,a;
		private String team1,team2;
		private int totalpawn1=16,totalpawn2=16;
		
		public boolean Atflag=false;
			
		public int temp;
			
		int[][] path=new int[37][8];
			
		int[][] bestWay=new int[8][2];
		int[][] firstTwoMax=new int[2][2];
			
			
			
		ArrayList<Integer> arraylist=new  ArrayList<Integer>();

		private boolean mouse,team1Move=true,team2Move=true;
		int mouseClickCount=0;
		
		private int mouseTemp;
	
	
	
		public SholoGuti() {
			
			addMouseListener(this);
			setPreferredSize(new Dimension(1900,1000));
			
			timer=new Timer(delay,this);
			timer.start();
			
			
			Scanner scr=new Scanner(System.in);
			
			team1=scr.nextLine();
			team2=scr.nextLine();
			
			
			//artificial intelligence
			
			
			
			for(int i=0;i<37;i++) {
				
				for(int j=0;j<8;j++) {
					
					path[i][j]=-1;
					
				}
			}
			
			//0
			temp=0;
			
			path[temp][5]=3;
			path[temp][6]=1;
			
			

			
			
			//1
			temp=1;
			path[temp][2]=0;
			path[temp][4]=4;
			path[temp][6]=2;
			
			
			
			
			//2
			temp=2;
			path[temp][2]=1;
			path[temp][3]=5;
			
			//3
			temp=3;
			path[temp][1]=0;
			path[temp][6]=4;
			path[temp][5]=8;
			
			
			
			//4
			temp=4;
			path[temp][0]=1;
			path[temp][2]=3;
			path[temp][4]=8;
			path[temp][6]=5;
			
			
			
			
			//5
			temp=5;
			path[temp][7]=2;
			path[temp][2]=4;
			path[temp][3]=8;
			
			
			
			
			
			//6
			temp=6;
			path[temp][6]=7;
			path[temp][4]=11;
			path[temp][5]=12;
			
			
			
			
			//7
			temp=7;
			path[temp][2]=6;
			path[temp][6]=8;
			path[temp][4]=12;
			
			
			
			
			
			//8
			temp=8;
			path[temp][0]=4;
			path[temp][1]=3;
			path[temp][2]=7;
			path[temp][3]=12;
			path[temp][4]=13;
			path[temp][5]=14;
			path[temp][6]=9;
			path[temp][7]=5;
			
			
			
			//9
			temp=9;
			path[temp][2]=8;
			path[temp][6]=10;
			path[temp][4]=14;
			
			
			
			

			//10
			temp=10;
			path[temp][2]=9;
			path[temp][3]=14;
			path[temp][4]=15;
		
			
			
			
			//11
			temp=11;
			path[temp][0]=6;
			path[temp][6]=12;
			path[temp][4]=16;
			
			
			
			
			
			//12
			temp=12;
			path[temp][0]=7;
			path[temp][1]=6;
			path[temp][2]=11;
			path[temp][3]=16;
			path[temp][4]=17;
			path[temp][5]=18;
			path[temp][6]=13;
			path[temp][7]=8;
			
			
			
			//complete
			
			
			
			//13
			temp=13;
			path[temp][0]=8;
			path[temp][2]=12;
			path[temp][6]=14;
			path[temp][4]=18;
			
			
			
			
			//14
			temp=14;
			path[temp][0]=9;
			path[temp][1]=8;
			path[temp][2]=13;
			path[temp][3]=18;
			path[temp][4]=19;
			path[temp][5]=20;
			path[temp][6]=15;
			path[temp][7]=10;
			
			
			
			
			//15
			temp=15;
			path[temp][0]=10;
			path[temp][2]=14;
			path[temp][4]=20;
			
			
			//16
			temp=16;
			path[temp][0]=11;
			path[temp][7]=12;
			path[temp][6]=17;
			path[temp][4]=21;
			path[temp][5]=22;
		
			
			
			
			//17
			temp=17;
			path[temp][0]=12;
			path[temp][2]=16;
			path[temp][6]=18;
			path[temp][4]=22;
			
			
			
			
			//18
			temp=18;
			path[temp][0]=13;
			path[temp][1]=12;
			path[temp][2]=17;
			path[temp][3]=22;
			path[temp][4]=23;
			path[temp][5]=24;
			path[temp][6]=19;
			path[temp][7]=14;

			
			
			
			//19
			temp=19;
			path[temp][0]=14;
			path[temp][2]=18;
			path[temp][6]=20;
			path[temp][4]=24;
			
			
			
			
			//20
			temp=20;
			path[temp][0]=15;
			path[temp][1]=14;
			path[temp][2]=19;
			path[temp][3]=24;
			path[temp][4]=25;
		
			
			
		
			
			//21
			temp=21;
			path[temp][0]=16;
			path[temp][6]=22;
			path[temp][4]=26;
			
			
			
			
			//22
			temp=22;
			path[temp][0]=17;
			path[temp][1]=16;
			path[temp][2]=21;
			path[temp][3]=26;
			path[temp][4]=27;
			path[temp][5]=28;
			path[temp][6]=23;
			path[temp][7]=18;
			
			
			//23
			temp=23;
			path[temp][0]=18;
			path[temp][2]=22;
			path[temp][6]=24;
			path[temp][4]=28;
			
			
			
			
			//24
			temp=24;
			path[temp][0]=19;
			path[temp][1]=18;
			path[temp][2]=23;
			path[temp][3]=28;
			path[temp][4]=29;
			path[temp][5]=30;
			path[temp][6]=25;
			path[temp][7]=20;
			
			
			//25
			temp=25;
			path[temp][0]=20;
			path[temp][2]=24;
			path[temp][4]=30;
		
			
			
			
			//26
			temp=26;
			path[temp][0]=21;
			path[temp][7]=22;
			path[temp][6]=27;
		
			
			
			
			//27
			temp=27;
			path[temp][0]=22;
			path[temp][2]=26;
			path[temp][6]=28;
			
			
			
			
			//28
			temp=28;
			path[temp][0]=23;
			path[temp][1]=22;
			path[temp][2]=27;
			path[temp][3]=31;
			path[temp][4]=32;
			path[temp][5]=33;
			path[temp][6]=29;
			path[temp][7]=24;

			
			
			
			//29
			temp=29;
			path[temp][0]=24;
			path[temp][2]=28;
			path[temp][6]=30;
		
			
			
			
			//30
			temp=30;
			path[temp][0]=25;
			path[temp][1]=24;
			path[temp][2]=29;
			
			
			
		
			//31
			temp=31;
			path[temp][7]=28;
			path[temp][6]=32;
			path[temp][3]=34;
			
			
			
			
			//32
			temp=32;
			path[temp][0]=28;
			path[temp][2]=31;
			path[temp][6]=33;
			path[temp][4]=35;
			
			
			
			
			//33
			temp=33;
			path[temp][1]=28;
			path[temp][2]=32;
			path[temp][5]=36;
			
			
			
			
			//34
			temp=34;
			path[temp][7]=31;
			path[temp][6]=35;
			
			
			
			
			//35
			temp=35;
			path[temp][0]=32;
			path[temp][2]=34;
			path[temp][6]=36;
			
			
			
			
			//36
			temp=36;
			path[temp][1]=33;
			path[temp][2]=35;
			
			
			
			
			

			
			
			
		}
		
		protected void paintComponent(Graphics g) {
			
			
			g.setColor(Color.black);
			g.fillRect(0,0,2000,1050);
			
			g.setColor(Color.green);
			g.fillRect(0,0,2000,10);
			
			g.setColor(Color.green);
			g.fillRect(0,990,2000,10);
			
			g.setColor(Color.green);
			g.fillRect(1910,0,10,1050);
			
			g.setColor(Color.green);
			g.fillRect(0,0,10,1050);
			
			
			g.setColor(Color.red);
			g.drawLine(450,150, 1450,150);
			
			g.setColor(Color.red);
			g.drawLine(450,850, 1450,850);
			
			g.setColor(Color.red);
			g.drawLine(450,150,450,850);
			
			g.setColor(Color.red);
			g.drawLine(1450,150,1450,850);
			
			
			//ghor
			int a=450,b=150;
			for(int i=0;i<3;i++) {
				a=a+250;
				b=b+175;
				
				g.setColor(Color.red);
				g.drawLine(a,150,a,850);
				
				g.setColor(Color.red);
				g.drawLine(450,b, 1450,b);
				
				
			
			}
			
			g.setColor(Color.red);
			g.drawLine(950,150, 95,750);
			
			g.setColor(Color.red);
			g.drawLine(950,850, 95,250);
			
			g.setColor(Color.red);
			g.drawLine(950,150, 1805,750);
			
			g.setColor(Color.red);
			g.drawLine(950,850, 1805,250);
			
			g.setColor(Color.red);
			g.drawLine(95,250, 95,750);
			
			g.setColor(Color.red);
			g.drawLine(1805,250, 1805,750);
			
			g.setColor(Color.red);
			g.drawLine(230,345,230,655);
			
			g.setColor(Color.red);
			g.drawLine(1670,345,1670,655);
			
			g.setColor(Color.red);
			g.drawLine(95,500,450,500);
			
			g.setColor(Color.red);
			g.drawLine(1450,500,1805,500);
			
			
			
			g.setColor(Color.red);
			g.drawLine(450,150,1450,850);
			
			
			g.setColor(Color.red);
			g.drawLine(450,850,1450,150);
			
			
			g.setColor(Color.blue);
			
			for(int i=0;i<37;i++) {
				
					if(arr[i][2]>0) {
						if(arr[i][2]==1) g.setColor(Color.blue);
						else g.setColor(Color.yellow);
					
						
						g.fillOval(arr[i][0],arr[i][1],40,40);
						
						
					}
				
			}
			
			
			g.setColor(Color.blue);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString(team1,55,70);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("TOTAL PAWN",45,110);
			g.drawString(team1,840,50);
			
			g.setColor(Color.red);
			g.drawString(": "+totalpawn1,250,110);
			
		
			
			g.setColor(Color.green);
			g.drawString("VS",930,50);
			
			g.setColor(Color.yellow);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString(team2,1600,70);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("TOTAL PAWN",1600,110);
			g.drawString(team2,990,50);
			
			g.setColor(Color.red);
			g.drawString(" : "+totalpawn2,1800,110);
			
		
			
			
			
			//guti
			g.setColor(Color.red);
			
			
			//g.fillOval(x,y,25,25);
			
			
			
			
		}
		
		
	
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
			
			
			
			//select
			if(SwingUtilities.isLeftMouseButton(e)) {
				
					int check;
					int x1=e.getX();
					int y1=e.getY();
					for(int i=0;i<37;i++) {
						
						if((x1>=(arr[i][0]-40)&&x1<=arr[i][0]+40)&&((y1>=(arr[i][1]-40)&&y1<=arr[i][1]+40))&&arr[i][2]==1) {
							
							
							mouseTemp=i;
							
							
							
							/*team2Move=true;
							team1Move=false;
							
							for(int j=0;j<8;j++) {
							
									check=path[mouseTemp][j];
									if(check!=-1&&path[check][j]!=-1) {
									
											if((arr[check][2]==2&&arr[mouseTemp][2]==1&&arr[path[check][j]][2]==0)) {
										
												team1Move=true;
											}
									}
							}*/
									
							
							mouse=true;
							System.out.println(mouse);
							
						}
						if((x1>=(arr[i][0]-40)&&x1<=arr[i][0]+40)&&((y1>=(arr[i][1]-40)&&y1<=arr[i][1]+40))&&arr[i][2]==2) {
							
							mouseTemp=i;
							
							
							/*team1Move=true;
							team2Move=false;
							
							for(int j=0;j<8;j++) {
									
									check=path[mouseTemp][j];
									if(check!=-1&&path[check][j]!=-1) {
									
											if((arr[check][2]==1&&arr[mouseTemp][2]==2&&arr[path[check][j]][2]==0)) {
											
												team2Move=true;
											}
									}
							}*/
											
							mouse=true;
							System.out.println(mouse);
							
						}
						
						
						
					}
				
				
				
			}
			
			
			//move
			
			if(SwingUtilities.isLeftMouseButton(e)&&mouse==true) {
				
					int x2=e.getX();
					int y2=e.getY();
					
					for(int i=0;i<8;i++) {
						
						
						if(path[mouseTemp][i]!=-1) {
							
								if((x2>=(arr[path[mouseTemp][i]][0]-40)&&x2<=arr[path[mouseTemp][i]][0]+40)&&((y2>=(arr[path[mouseTemp][i]][1]-40)&&y2<=arr[path[mouseTemp][i]][1]+40))
									&&(arr[path[mouseTemp][i]][2]==0&&arr[mouseTemp][2]==1)&&team1Move==true) {
									
									
										if(arr[mouseTemp][2]==1) {
											
											arr[path[mouseTemp][i]][2]=1;
											
											
										}
										
										
										arr[mouseTemp][2]=0;
										
										//mouse1=true;
										team1Move=false;
										team2Move=true;
										
										mouse=false;
										System.out.println(mouse);
										
								}
								
								
								if((x2>=(arr[path[mouseTemp][i]][0]-40)&&x2<=arr[path[mouseTemp][i]][0]+40)&&((y2>=(arr[path[mouseTemp][i]][1]-40)&&y2<=arr[path[mouseTemp][i]][1]+40))
									&&(arr[path[mouseTemp][i]][2]==0&&arr[mouseTemp][2]==2)&&team2Move==true) {
									
									
										
										if(arr[mouseTemp][2]==2) {
										
											arr[path[mouseTemp][i]][2]=2;
									
										}
										
										arr[mouseTemp][2]=0;
										
										//mouse1=true;
										team1Move=true;
										team2Move=false;
										mouse=false;
										System.out.println(mouse);
										
								}
								
								
								
								
								
								
								int next=path[mouseTemp][i];
								if(path[next][i]!=-1) {
										
										if((x2>=(arr[path[next][i]][0]-40)&&x2<=arr[path[next][i]][0]+40)&&((y2>=(arr[path[next][i]][1]-40)&&y2<=arr[path[next][i]][1]+40))
											&&((arr[next][2]==2&&arr[mouseTemp][2]==1&&arr[path[next][i]][2]==0))) {
											
											//System.out.println("mouseTemp:"+mouseTemp+"  "+"next:"+next+" "+"next2:"+path[next][i]);
											if(arr[mouseTemp][2]==1) {
												totalpawn2--;
												arr[path[next][i]][2]=1;
												
												
											}
											
											arr[mouseTemp][2]=0;
											arr[next][2]=0;
											
											team1Move=false;
											team2Move=true;
											mouse=false;
											System.out.println("hello azaz");

											
										}
										
										
										
										 if((x2>=(arr[path[next][i]][0]-40)&&x2<=arr[path[next][i]][0]+40)&&((y2>=(arr[path[next][i]][1]-40)&&y2<=arr[path[next][i]][1]+40))
											&&((arr[next][2]==1&&arr[mouseTemp][2]==2&&arr[path[next][i]][2]==0))) {
												
												//System.out.println("mouseTemp:"+mouseTemp+"  "+"next:"+next+" "+"next2:"+path[next][i]);
												
												if(arr[mouseTemp][2]==2) {
													totalpawn1--;
													arr[path[next][i]][2]=2;
											
												}
												arr[mouseTemp][2]=0;
												arr[next][2]=0;
												
												team2Move=false;
												team1Move=true;
											
												mouse=false;
												System.out.println("hello azaz");

												
										}
									
										
										
										
										
										
								}
								
								
						}
						
							
				}
					
			}
			
			
			
			
			
			
		}
	
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			repaint();
			
		}

}

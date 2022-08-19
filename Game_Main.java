import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class Game_Main 
{
	private ArrayList<Integer> clickUp;
	private ArrayList<Double> clickMoney;
	private ArrayList<Integer> PassiveUP;
	private int paperClips;
	private int upgradeLevelClick;
	private double money;
	private int gains;
	private double perClip;
	private JLabel clips;
	private JLabel moneyMade;
	private JButton sell;
	private JButton clickUpgrade;
	private JButton passiveUpgrade;
	private JButton rateUpgrade;
	private JLabel  clipsPerClick;
	
	public Game_Main()
	{
		
		paperClips = 0;
		perClip = 0.03;
		upgradeLevelClick = 0; 
		money = 10; 
		gains = 1;
		
		
		clickUp = new ArrayList<>(Arrays.asList(2, 5, 10, 15, 25, 35, 60, 80, 100, 130, 170, 240, 300, 370, 430, 500, 590, 700, 850, 1000, 1200, 1700, 2500, 3900, 5000, 7500, 9000, 13000));
		clickMoney = new ArrayList<>(Arrays.asList(10.00, 20.00, 35.00, 50.00, 70.00, 95.00, 110.00, 140.00, 170.00, 220.00, 290.00, 380.00, 480.00, 600.00, 800.00, 1200.00, 1370.00, 1570.00, 1800.00, 2200.00, 2700.00, 3200.00, 4000.00, 5000.00, 6500.00, 9000.00, 15000.00, 30000.00));
		
		
		JFrame mainFrame = new JFrame("PaperClip Factory");
  
		JMenuBar menu = new JMenuBar();
		JMenu Backgroundoptions = new JMenu("Background Settings");
		JMenuItem Blue = new JMenuItem("Blue");
		JMenuItem Green = new JMenuItem("Green");
		JMenuItem Yellow = new JMenuItem("Yellow");
		JMenuItem Gray = new JMenuItem("Gray");
		JMenuItem White = new JMenuItem("White");
		JMenuItem Cyan = new JMenuItem("Cyan");
		JMenuItem Magenta = new JMenuItem("Magenta");
		Backgroundoptions.add(Blue);
		Backgroundoptions.add(Green);
		Backgroundoptions.add(Yellow);
		Backgroundoptions.add(Gray);
		Backgroundoptions.add(White);
		Backgroundoptions.add(Cyan);
		Backgroundoptions.add(Magenta);
		
		menu.add(Backgroundoptions);
		
		mainFrame.setJMenuBar(menu);
		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clips = new JLabel("You Have: " + paperClips + " Paper Clips!");
		clips.setFont(new Font("Arial", Font.BOLD, 40));
		JButton maker = new JButton("Make Clips");
		sell = new JButton("sell for " + perClip * paperClips + " ?");
		moneyMade = new JLabel("You have: " + money + " dollars");
		clickUpgrade = new JButton("Upgrade your click to make " + clickUp.get(upgradeLevelClick) + " paper clips ? " + '\n' + "this costs: $" + clickMoney.get(upgradeLevelClick));
		passiveUpgrade = new JButton("Passive");
		rateUpgrade = new JButton("rate");
		
		maker.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					paperClips += gains;
					update();
					
				}
		}
				);
		
		
		sell.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				money += perClip * paperClips;
				System.out.println(money);
				paperClips = 0;
				update();
				
			}
	}
			);
		
		clickUpgrade.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(money < clickMoney.get(upgradeLevelClick))
				{
					JOptionPane.showMessageDialog(mainFrame, "you don't have enough money for this upgrade!");
				}
				
				else 
				{
					
				gains = clickUp.get(upgradeLevelClick);
				money -= clickMoney.get(upgradeLevelClick);
				upgradeLevelClick += 1;
				update();
				
				}
			}
	}
			);
		
	
		
			
		
		
		
		JPanel top = new JPanel();
		top.setOpaque(true);
		
		JPanel bottom = new JPanel();
		bottom.setOpaque(true);
		JPanel left = new JPanel();
		left.setOpaque(true);
		JPanel center = new JPanel();
		center.setOpaque(true);
		JPanel right = new JPanel();
		right.setOpaque(true);
				
		mainFrame.add(top, BorderLayout.NORTH);
		mainFrame.add(bottom, BorderLayout.SOUTH);
		mainFrame.add(left, BorderLayout.WEST);
		mainFrame.add(center, BorderLayout.CENTER);
		mainFrame.add(right, BorderLayout.EAST);
		
		//Top
		top.setLayout(new FlowLayout());
		
		top.add(clips, FlowLayout.LEFT);
		top.add(sell);
		//left
	
		left.setLayout(new BoxLayout(left, BoxLayout.X_AXIS));
		left.add(maker);
        left.add(moneyMade);
		
        //CENTER
        center.setLayout(new GridLayout(3,1));
        center.add(clickUpgrade);
        center.add(passiveUpgrade);  
        center.add(rateUpgrade);
        
        //right
        clipsPerClick = new JLabel("you get " + gains + " paper clips per click");
        right.add(clipsPerClick);
        JLabel moneyPerClip = new JLabel("you get $" + perClip + " per paperclip");
        moneyPerClip.setFont(new Font("Arial", Font.BOLD, 40));
        
        
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		
		Blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				top.setBackground(Color.BLUE);
				left.setBackground(Color.BLUE);
				right.setBackground(Color.BLUE);
				center.setBackground(Color.BLUE);
				bottom.setBackground(Color.BLUE);
				
			}
	}
			);
		
		Green.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				top.setBackground(Color.GREEN);
				left.setBackground(Color.GREEN);
				right.setBackground(Color.GREEN);
				center.setBackground(Color.GREEN);
				bottom.setBackground(Color.GREEN);
				
			}
	}
			);
		
		Yellow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				top.setBackground(Color.YELLOW);
				left.setBackground(Color.YELLOW);
				right.setBackground(Color.YELLOW);
				center.setBackground(Color.YELLOW);
				bottom.setBackground(Color.YELLOW);
				
			}
	}
			);
		
		Gray.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				top.setBackground(Color.GRAY);
				left.setBackground(Color.GRAY);
				right.setBackground(Color.GRAY);
				center.setBackground(Color.GRAY);
				bottom.setBackground(Color.GRAY);
				
			}
	}
			);
		
		White.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				top.setBackground(Color.WHITE);
				left.setBackground(Color.WHITE);
				right.setBackground(Color.WHITE);
				center.setBackground(Color.WHITE);
				bottom.setBackground(Color.WHITE);
				
			}
	}
			);
		
		Cyan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				top.setBackground(Color.CYAN);
				left.setBackground(Color.CYAN);
				right.setBackground(Color.CYAN);
				center.setBackground(Color.CYAN);
				bottom.setBackground(Color.CYAN);
				
			}
	}
			);
		
		Magenta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				top.setBackground(Color.MAGENTA);
				left.setBackground(Color.MAGENTA);
				right.setBackground(Color.MAGENTA);
				center.setBackground(Color.MAGENTA);
				bottom.setBackground(Color.MAGENTA);
				
			}
	}
			);
		
		
			
//		JMenuItem Blue = new JMenuItem("Blue");
//		JMenuItem Green = new JMenuItem("Green");
//		JMenuItem Yellow = new JMenuItem("Yellow");
//		JMenuItem Gray = new JMenuItem("Gray");
//		JMenuItem White = new JMenuItem("White");
//		JMenuItem Cyan = new JMenuItem("Cyan");
//		JMenuItem Magenta = new JMenuItem("Magenta");
		
	}
	
	
	
		
		public static void main( String arg[])
		{
			
			new Game_Main();
		
		}


		public void update()
		{
			clips.setText("You Have: " + paperClips + " Paper Clips!");
			double moola = perClip * paperClips;
			Math.round(moola);
			sell.setText("sell for " + moola + " ?");
			moneyMade.setText("You have: " + money + " dollars");
			clickUpgrade.setText("Upgrade your click to make " + clickUp.get(upgradeLevelClick) + " paper clips ? " + '\n' + "this costs: $" + clickMoney.get(upgradeLevelClick));
			 clipsPerClick.setText("you get " + gains + " paper clips per click");
		}

	
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickerGameGUI implements ActionListener {

    private int score = 0;
    private int clickPower = 1;
    private int autoClickers = 0;
    private int autoClickerCost = 10;
    private int powerUpCost = 20;
    private int powerUpDuration = 10;
    private boolean powerUpActive = false;

    private JLabel scoreLabel;
    private JLabel clickPowerLabel;
    private JLabel autoClickersLabel;
    private JLabel autoClickerCostLabel;
    private JLabel powerUpCostLabel;
    private JButton clickButton;
    private JButton buyAutoClickerButton;
    private JButton buyPowerUpButton;
    private JButton tradeForPowerUpButton;
    private Timer autoClickerTimer;

    public ClickerGameGUI() {
        JFrame frame = new JFrame("Idle Clicker Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        scoreLabel = new JLabel("Score: " + score);
        clickPowerLabel = new JLabel("Click Power: " + clickPower);
        autoClickersLabel = new JLabel("Auto-Clickers: " + autoClickers);
        autoClickerCostLabel = new JLabel("Auto-Clicker Cost: " + autoClickerCost);
        powerUpCostLabel = new JLabel("Power-Up Cost: " + powerUpCost);

        clickButton = new JButton("Click");
        clickButton.addActionListener(this);

        buyAutoClickerButton = new JButton("Buy Auto-Clicker");
        buyAutoClickerButton.addActionListener(this);

        buyPowerUpButton = new JButton("Buy Power-Up");
        buyPowerUpButton.addActionListener(this);

        tradeForPowerUpButton = new JButton("Trade for Power-Up");
        tradeForPowerUpButton.addActionListener(this);

        panel.add(scoreLabel);
        panel.add(clickPowerLabel);
        panel.add(autoClickersLabel);
        panel.add(autoClickerCostLabel);
        panel.add(powerUpCostLabel);
        panel.add(clickButton);
        panel.add(buyAutoClickerButton);
        panel.add(buyPowerUpButton);
        panel.add(tradeForPowerUpButton);

        frame.add(panel);
        frame.setVisible(true);

        autoClickerTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autoClick();
            }
        });
        autoClickerTimer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clickButton) {
            click();
        } else if (e.getSource() == buyAutoClickerButton) {
            buyAutoClicker();
        } else if (e.getSource() == buyPowerUpButton) {
            buyPowerUp();
        } else if (e.getSource() == tradeForPowerUpButton) {
            tradeForPowerUp();
        }
    }

    private void click() {
        score += clickPower;
        updateLabels();
    }

    private void buyAutoClicker() {
        if (score >= autoClickerCost) {
            autoClickers++;
            score -= autoClickerCost;
            autoClickerCost *= 2;
            updateLabels();
        } else {
            JOptionPane.showMessageDialog(null, "Not enough score.");
        }
    }

    private void autoClick() {
        score += autoClickers * clickPower;
        updateLabels();
    }

    private void buyPowerUp() {
        if (score == powerUpCost) {
        	powerUpActive = true;
        	score -= powerUpCost;
        	powerUpCost *= 2;
        	updateLabels();
        	Timer powerUpTimer = new Timer(powerUpDuration * 1000, new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	powerUpActive = false;
        	updateLabels();
        	}
        	});
        	powerUpTimer.setRepeats(false);
        	powerUpTimer.start();
        	} else {
        	JOptionPane.showMessageDialog(null, "Not enough score.");
        	}
        	}
    
    private void tradeForPowerUp() {
        int input = JOptionPane.showConfirmDialog(null, "Trade 10 auto-clickers for a power-up?");
        if (input == JOptionPane.YES_OPTION) {
            if (autoClickers >= 10) {
                autoClickers -= 10;
                score += powerUpCost;
                powerUpCost *= 2;
                updateLabels();
            } else {
                JOptionPane.showMessageDialog(null, "Not enough auto-clickers.");
            }
        }
    }

    private void updateLabels() {
        scoreLabel.setText("Score: " + score);
        clickPowerLabel.setText("Click Power: " + clickPower);
        autoClickersLabel.setText("Auto-Clickers: " + autoClickers);
        autoClickerCostLabel.setText("Auto-Clicker Cost: " + autoClickerCost);
        powerUpCostLabel.setText("Power-Up Cost: " + powerUpCost);
        if (powerUpActive) {
            buyPowerUpButton.setEnabled(false);
            tradeForPowerUpButton.setEnabled(false);
            Timer powerUpActiveTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buyPowerUpButton.setEnabled(true);
                    tradeForPowerUpButton.setEnabled(true);
                }
            });
            
            powerUpActiveTimer.setRepeats(false);
            powerUpActiveTimer.start();
        } else {
            buyPowerUpButton.setEnabled(true);
            tradeForPowerUpButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        new ClickerGameGUI();
    }
}




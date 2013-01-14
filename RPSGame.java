import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//rock paper scissors game
public class RPSGame extends JFrame implements ActionListener{
	
	JPanel rpsP, imageP, scoreP;
	JButton rockB, paperB, scissorsB;
	JLabel player, computer;
	String imgArray[] = {"rock.jpg", "paper.jpg", "scissors.jpg"};
	String imgWon = "rps.jpg";
	int compScore = 0;
	int playerScore = 0;
	
	public static void main(String[] args){
		
		RPSGame gui = new RPSGame();
		gui.go();
	}
	
	public void go() {
		
		setTitle("Rock Paper and Scissors!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(new Dimension(500,500));
		setResizable(false);
		
		rockB = new JButton("ROCK!");
		rockB.addActionListener(this);
		
		paperB = new JButton("PAPER!");
		paperB.addActionListener(this);
		
		scissorsB = new JButton("SCISSORS!");
		scissorsB.addActionListener(this);
		
		rpsP = new JPanel();
		rpsP.setLayout(new GridLayout(1,3));
		
		rpsP.add(rockB);
		rpsP.add(scissorsB);
		rpsP.add(paperB);
		add(rpsP, BorderLayout.NORTH);
		
		imagePanel();
		scorePanel();
		
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(3); //randomly select picture
		imgWon = imgArray[randomInt];
		
		if(e.getSource() == rockB) {
			if(imgWon == imgArray[0]){
				//tie
			}
			if(imgWon == imgArray[1]){
				//lose
				compScore = compScore + 1;
			}
			if(imgWon == imgArray[2]){
				//win
				playerScore = playerScore + 1;
			}
			
		}
		if(e.getSource() == paperB) {
			if(imgWon == imgArray[0]){
				//win
				playerScore = playerScore + 1;
			}
			if(imgWon == imgArray[1]){
				//tie
			}
			if(imgWon == imgArray[2]){
				//lose
				compScore = compScore + 1;
			}
		}
		if(e.getSource() == scissorsB) {
			if(imgWon == imgArray[0]){
				//lose
				compScore = compScore + 1;
			}
			if(imgWon == imgArray[1]){
				//win
				playerScore = playerScore + 1;
			}
			if(imgWon == imgArray[2]){
				//tie
			}
		}
		scorePanel(); //call scorePanel class to update score
		imagePanel(); //call imagePanel to update pictures
	}
	
	public void imagePanel() {
		
		
		
		ImageIcon icon = new ImageIcon(imgWon);
		Image img = icon.getImage(); //get image from directory
		
		//resizes the image
		Image newImg = img.getScaledInstance(200,200, java.awt.Image.SCALE_SMOOTH);
		
		JLabel image = new JLabel();
		ImageIcon newIcon = new ImageIcon(newImg); //convert image to icon
		image.setIcon(newIcon);
		
		imageP = new JPanel();
		imageP.add(image); //add icon to panel
		
		add(imageP, BorderLayout.CENTER);
		
		imageP.revalidate();
	}
	
	public void scorePanel() {
		//updates the score
		player = new JLabel("Player: " + playerScore);
		computer = new JLabel("Computer "+ compScore);
		
		scoreP = new JPanel();
		scoreP.setLayout(new GridLayout(1,2));
		scoreP.add(player);
		scoreP.add(computer);
		
		add(scoreP, BorderLayout.SOUTH);
	}
}

package tictactoe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class tictactoe implements ActionListener {
	
	Random random=new Random();
	JFrame frame=new JFrame();
	JPanel title_panel=new JPanel();
	JButton[] buttons=new JButton[9];
	JPanel button_panel=new JPanel();
	JLabel textfield = new JLabel();
	boolean player1_turn ;
	boolean player2_turn ;
	String play1;
	String play2;
	int x=0;


	
    tictactoe(){
		
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(Color.pink);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.black);
		textfield.setForeground(Color.green);
		textfield.setFont(new Font("Agency FB",Font.PLAIN,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic Tac Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.pink);
		
		for(int i =0;i<9;i++) {
			buttons[i]=new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Agency FB",Font.PLAIN,100));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstturn();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if (x==0) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.magenta);
					    buttons[i].setText("X");
					    if (player1_turn) {
						player1_turn=false;
						textfield.setText("player 2's turn");

					    }
					    else {
						player1_turn=true;
						textfield.setText("player 1's turn");

					    }
					}
				}
				else if(player1_turn) {
					
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.magenta);
						buttons[i].setText(play1);
						player1_turn=false;
						textfield.setText("player 2's turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.magenta);
						buttons[i].setText(play2);
						player1_turn=true;
						textfield.setText("player 1's turn");
						check();
					}
				}
			}			
		}
		x++;
		
	}
	
	public void firstturn(){
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		if (random.nextInt(2)==0) {
			player1_turn=true;
			play1="X";
			play2="O";
			textfield.setText("player 1 plays X");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			textfield.setText("player 1's turn");
			
		}
		else {
			player1_turn=false;
			play1="O";
			play2="X";
			textfield.setText("player 2 plays X");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			textfield.setText("player 2's turn");
		}
		
	}
	
	public void check() {
		//check X win conditions
				if(
						(buttons[0].getText()=="X") &&
						(buttons[1].getText()=="X") &&
						(buttons[2].getText()=="X")
						) {
					xWins(0,1,2);
				}
				if(
						(buttons[3].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[5].getText()=="X")
						) {
					xWins(3,4,5);
				}
				if(
						(buttons[6].getText()=="X") &&
						(buttons[7].getText()=="X") &&
						(buttons[8].getText()=="X")
						) {
					xWins(6,7,8);
				}
				if(
						(buttons[0].getText()=="X") &&
						(buttons[3].getText()=="X") &&
						(buttons[6].getText()=="X")
						) {
					xWins(0,3,6);
				}
				if(
						(buttons[1].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[7].getText()=="X")
						) {
					xWins(1,4,7);
				}
				if(
						(buttons[2].getText()=="X") &&
						(buttons[5].getText()=="X") &&
						(buttons[8].getText()=="X")
						) {
					xWins(2,5,8);
				}
				if(
						(buttons[0].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[8].getText()=="X")
						) {
					xWins(0,4,8);
				}
				if(
						(buttons[2].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[6].getText()=="X")
						) {
					xWins(2,4,6);
				}
				//check O win conditions
				if(
						(buttons[0].getText()=="O") &&
						(buttons[1].getText()=="O") &&
						(buttons[2].getText()=="O")
						) {
					oWins(0,1,2);
				}
				if(
						(buttons[3].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[5].getText()=="O")
						) {
					oWins(3,4,5);
				}
				if(
						(buttons[6].getText()=="O") &&
						(buttons[7].getText()=="O") &&
						(buttons[8].getText()=="O")
						) {
					oWins(6,7,8);
				}
				if(
						(buttons[0].getText()=="O") &&
						(buttons[3].getText()=="O") &&
						(buttons[6].getText()=="O")
						) {
					oWins(0,3,6);
				}
				if(
						(buttons[1].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[7].getText()=="O")
						) {
					oWins(1,4,7);
				}
				if(
						(buttons[2].getText()=="O") &&
						(buttons[5].getText()=="O") &&
						(buttons[8].getText()=="O")
						) {
					oWins(2,5,8);
				}
				if(
						(buttons[0].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[8].getText()=="O")
						) {
					oWins(0,4,8);
				}
				if(
						(buttons[2].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[6].getText()=="O")
						) {
					oWins(2,4,6);
				}
			
		
	}
	
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.cyan);
		buttons[b].setBackground(Color.cyan);
		buttons[c].setBackground(Color.cyan);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		if(play1=="X") {
			textfield.setText("player1 wins");
		}
		else {
			textfield.setText("player2 wins");
		}
	}
	
	public void oWins(int a,int b, int c) {
		buttons[a].setBackground(Color.cyan);
		buttons[b].setBackground(Color.cyan);
		buttons[c].setBackground(Color.cyan);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		if(play1=="O") {
			textfield.setText("player1 wins");
		}
		else {
			textfield.setText("player2 wins");
		}
		
	}
    
}

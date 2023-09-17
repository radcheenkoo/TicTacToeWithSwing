import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    private Random random = new Random();
    private JFrame frame = new JFrame();
    private JPanel titlePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JButton[] buttons = new JButton[9];
    private JLabel textField = new JLabel();
    private boolean playerOneTurn;

    public TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.black);
        textField.setForeground(Color.red);
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(Color.gray);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]){

                if (playerOneTurn){
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.yellow);
                        buttons[i].setText("X");
                        playerOneTurn = false;
                        textField.setText("0 turn");
                        check();
                    }
                }else {
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("0");
                        playerOneTurn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e);
        }
        int randNum = random.nextInt(2);
        if (randNum == 0){
            playerOneTurn = true;
            textField.setText("X turn");
        }else{
            playerOneTurn = false;
            textField.setText("O turn");

        }
    }
    public void check(){
        //check X win conditions
        if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X"){
            xWins(0,1,2);
        }
        if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
        xWins(3,4,5);
        }
        if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X"){
            xWins(6,7,8);
        }

        if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X"){
            xWins(0,3,6);
        }
        if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X"){
            xWins(1,4,7);
        }
        if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X"){
            xWins(2,5,8);
        }

        if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X"){
            xWins(0,4,8);
        }
        if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X"){
            xWins(2,4,6);
        }
        //check O win conditions

        if (buttons[0].getText() == "0" && buttons[1].getText() == "0" && buttons[2].getText() == "0"){
            oWins(0,1,2);
        }
        if (buttons[3].getText() == "0" && buttons[4].getText() == "0" && buttons[5].getText() == "0"){
            oWins(0,1,2);
        }
        if (buttons[6].getText() == "0" && buttons[7].getText() == "0" && buttons[8].getText() == "0"){
            oWins(0,1,2);
        }

        if (buttons[0].getText() == "0" && buttons[3].getText() == "0" && buttons[6].getText() == "0"){
            oWins(0,1,2);
        }
        if (buttons[1].getText() == "0" && buttons[4].getText() == "0" && buttons[7].getText() == "0"){
            oWins(0,1,2);
        }
        if (buttons[2].getText() == "0" && buttons[5].getText() == "0" && buttons[8].getText() == "0"){
            oWins(0,1,2);
        }

        if (buttons[0].getText() == "0" && buttons[4].getText() == "0" && buttons[8].getText() == "0"){
            oWins(0,1,2);
        }
        if (buttons[2].getText() == "0" && buttons[4].getText() == "0" && buttons[6].getText() == "0"){
            oWins(0,1,2);
        }

    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(new Color(20,130,0));
        buttons[b].setBackground(new Color(20,130,0));
        buttons[c].setBackground(new Color(20,130,0));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
            textField.setText("X win");
        }

    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(new Color(20,130,0));
        buttons[b].setBackground(new Color(20,130,0));
        buttons[c].setBackground(new Color(20,130,0));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
            textField.setText("O win");
        }
    }
}

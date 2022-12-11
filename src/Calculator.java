import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JDesktopPane;

public class Calculator {
	private JFrame frmMycalculator;
	private JTextField Expression;
	private JTextField Answer;
	private JButton btnErase;
	private JButton btnPower;
	private JButton btnDivide;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnMultiply;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnMinus;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btnPlus;
	private JButton btnPoint;
	private JButton btn0;
	private JButton btnAns;
	private JButton btnEqual;
	private JButton btnClear;
	private JButton btnBracket1;
	private JButton btnBracket2;
	private JButton btnScientific;
	private JButton btnPercent;
	private boolean flag = false; //btnEqual pressed
	private int flag3 = 0; //specialkeytyped
	private double answer; 
	private String expression;
	private int caretPosition;
	boolean flag2 = false; //keytyped

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmMycalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMycalculator = new JFrame();
		frmMycalculator.setTitle("MyCalculator");
		frmMycalculator.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hazrul\\OneDrive\\Pictures\\Saved Pictures\\Apps-Calc-icon.png"));
		frmMycalculator.setResizable(false);
		frmMycalculator.getContentPane().setBackground(Color.BLACK);
		frmMycalculator.setBounds(100, 100, 385, 464);
		frmMycalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMycalculator.getContentPane().setLayout(null);
		
		//textField expression
		Expression = new JTextField("");
		Expression.setEditable(true);
		Expression.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(Expression.getText().length() > e.getDot() && Expression.getText().charAt(e.getDot()) == 's' && flag3 != KeyEvent.VK_LEFT) {
					Expression.setCaretPosition(Expression.getCaretPosition()+1);
				}
				else if(Expression.getText().length() > e.getDot() && Expression.getText().charAt(e.getDot()) == 'n' && flag3 != KeyEvent.VK_RIGHT){
					Expression.setCaretPosition(Expression.getCaretPosition()-1);
				}
				flag3 = 0;
				flag=false;
			}
		});
		Expression.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch(e.getKeyChar()) {
					case '0': {
						btn0.doClick();
						break;
					}
					case '1':{
						btn1.doClick();
						break;
					}
					case '2':{
						btn2.doClick();
						break;
					}
					case '3':{
						btn3.doClick();
						break;
					}
					case '4':{
						btn4.doClick();
						break;
					}
					case '5':{
						btn5.doClick();
						break;
					}
					case '6':{
						btn6.doClick();
						break;
					}
					case '7':{
						btn7.doClick();
						break;
					}
					case '8':{
						btn8.doClick();
						break;
					}
					case '9':{
						btn9.doClick();
						break;
					}
					case '/':{
						btnDivide.doClick();
						break;
					}
					case '*':{
						btnMultiply.doClick();
						break;
					}
					case 'x':{
						btnMultiply.doClick();
						break;
					}
					case '-':{
						btnMinus.doClick();
						break;
					}
					case '+':{
						btnPlus.doClick();
						break;
					}
					case '.':{
						btnPoint.doClick();
						break;
					}
					case '^':{
						btnPower.doClick();
						break;
					}
					case 'c':{
						btnClear.doClick();
						break;
					}
					case '(':{
						btnBracket1.doClick();
						break;
					}
					case ')':{
						btnBracket2.doClick();
						break;
					}
					case 'E':{
						btnScientific.doClick();
						break;
					}
					case 'e':{
						btnScientific.doClick();
						break;
					}
					case '%':{
						btnPercent.doClick();
						break;
					}
					case 'a':{
						btnAns.doClick();
						break;
					}
					case 'A':{
						btnAns.doClick();
						break;
					}
				}
				
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					btnClear.doClick();
				}
				else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && flag3 == 0) {
					flag3 = e.getKeyCode();
					btnErase.doClick();
				}
				else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEqual.doClick();
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					if(Expression.getCaretPosition()!=0) {
						if(Expression.getText().charAt(Expression.getCaretPosition()-1) == 's' && flag3 == 0) {
							flag3 = e.getKeyCode();
							Expression.setCaretPosition(Expression.getCaretPosition()-1);
						}
					}
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(Expression.getCaretPosition()!=Expression.getText().length()) {
						if(Expression.getText().charAt(Expression.getCaretPosition()) == 'A' && flag3 == 0) {
							flag3 = e.getKeyCode();
							Expression.setCaretPosition(Expression.getCaretPosition()+1);
						}
					}
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				flag2 = true;
				e.consume();
			}
		});
		Expression.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Expression.setHorizontalAlignment(SwingConstants.LEFT);
		Expression.setBackground(SystemColor.activeCaptionBorder);
		Expression.setBounds(20, 23, 330, 38);
		Expression.setFocusable(true);
		Expression.setCaretColor(Color.BLACK);
		frmMycalculator.getContentPane().add(Expression);
		Expression.setColumns(10);
		
		//textField answer
		Answer = new JTextField("0");
		Answer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Answer.setHorizontalAlignment(SwingConstants.RIGHT);
		Answer.setEditable(false);
		Answer.setBackground(SystemColor.activeCaptionBorder);
		Answer.setColumns(10);
		Answer.setBounds(20, 60, 330, 38);
		Answer.setFocusable(false);
		frmMycalculator.getContentPane().add(Answer);
		
		//btnClear
		btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Expression.setText("");
				Answer.setText("0");
				flag=false;
			}
		});
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnClear.setFocusable(false);
		btnClear.setBackground(new Color(192, 192, 192));
		btnClear.setBounds(20, 116, 75, 40);
		frmMycalculator.getContentPane().add(btnClear);
		
		//button erase
		btnErase = new JButton("\uF0D5");
		btnErase.setForeground(new Color(0, 0, 0));
		btnErase.setBackground(new Color(192, 192, 192));
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Expression.getText().equals("Syntax ERROR")) {
					if(flag3 == KeyEvent.VK_BACK_SPACE) {
						Expression.setText(expression+" ");
						flag3 = 0; 
					}
					else
						Expression.setText(expression);
					
					Answer.setText("0");
					flag = false;
					return;
				}
				else if(Expression.getText().length() > 0) {
					if(flag3 == KeyEvent.VK_BACK_SPACE) {
						if(Expression.getText().charAt(Expression.getCaretPosition()-1) == 's'){
							StringBuilder str = new StringBuilder(Expression.getText());
							caretPosition = Expression.getCaretPosition();
							for(int i=0; i<2; i++) {
								str.deleteCharAt(--caretPosition);
								Expression.setText(str.toString());
							}
							Expression.setCaretPosition(caretPosition);
						}
						flag3=0;
					}
					else {
						if(Expression.getText().charAt(Expression.getCaretPosition()-1) == 's') {
							StringBuilder str = new StringBuilder(Expression.getText());
							caretPosition = Expression.getCaretPosition();
							for(int i=0; i<3; i++) {
								str.deleteCharAt(--caretPosition);
								Expression.setText(str.toString());
							}
							Expression.setCaretPosition(caretPosition);
						}
						else {
							StringBuilder str = new StringBuilder(Expression.getText());
							caretPosition = Expression.getCaretPosition();
							str.deleteCharAt(--caretPosition);
							Expression.setText(str.toString());
							Expression.setCaretPosition(caretPosition);
						}
					}
					flag = false;
				}
			}
		});
		btnErase.setFont(new Font("Wingdings", Font.PLAIN, 22));
		btnErase.setBounds(105, 116, 75, 40);
		btnErase.setFocusable(false);
		frmMycalculator.getContentPane().add(btnErase);
		
		//button percent
		btnPercent = new JButton("%");
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+btnPercent.getText());
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnPercent.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btnPercent.setForeground(new Color(0, 0, 0));
		btnPercent.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPercent.setFocusable(false);
		btnPercent.setBackground(new Color(192, 192, 192));
		btnPercent.setBounds(190, 116, 75, 40);
		frmMycalculator.getContentPane().add(btnPercent);
		
		//button power
		btnPower = new JButton("^");
		btnPower.setForeground(new Color(255, 255, 255));
		btnPower.setBackground(new Color(255, 153, 51));
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+btnPower.getText());
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnPower.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btnPower.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPower.setBounds(275, 116, 75, 40);
		btnPower.setFocusable(false);
		frmMycalculator.getContentPane().add(btnPower);
		
		//button bracket "("
		btnBracket1 = new JButton("(");
		btnBracket1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+btnBracket1.getText());
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnBracket1.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btnBracket1.setForeground(new Color(255, 255, 255));
		btnBracket1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBracket1.setFocusable(false);
		btnBracket1.setBackground(SystemColor.textInactiveText);
		btnBracket1.setBounds(20, 166, 75, 40);
		frmMycalculator.getContentPane().add(btnBracket1);
		
		//button bracket ")"
		btnBracket2 = new JButton(")");
		btnBracket2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+btnBracket2.getText());
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnBracket2.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btnBracket2.setForeground(new Color(255, 255, 255));
		btnBracket2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBracket2.setFocusable(false);
		btnBracket2.setBackground(SystemColor.textInactiveText);
		btnBracket2.setBounds(105, 166, 75, 40);
		frmMycalculator.getContentPane().add(btnBracket2);
		
		//button Exponent
		btnScientific = new JButton("10*");
		btnScientific.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+"E");
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, "E");
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1, 1);
		frmMycalculator.getContentPane().add(desktopPane);
		btnScientific.setForeground(new Color(255, 255, 255));
		btnScientific.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnScientific.setFocusable(false);
		btnScientific.setBackground(SystemColor.textInactiveText);
		btnScientific.setBounds(190, 166, 75, 40);
		frmMycalculator.getContentPane().add(btnScientific);
		
		//button divide
		btnDivide = new JButton("/");
		btnDivide.setForeground(new Color(255, 255, 255));
		btnDivide.setBackground(new Color(255, 153, 51));
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+btnDivide.getText());
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnDivide.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnDivide.setBounds(275, 166, 75, 40);
		btnDivide.setFocusable(false);
		frmMycalculator.getContentPane().add(btnDivide);
		
		//7
		btn7 = new JButton("7");
		btn7.setForeground(new Color(255, 255, 255));
		btn7.setBackground(SystemColor.textInactiveText);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn7.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn7.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn7.setBounds(20, 216, 75, 40);
		btn7.setFocusable(false);
		frmMycalculator.getContentPane().add(btn7);
		
		//8
		btn8 = new JButton("8");
		btn8.setForeground(new Color(255, 255, 255));
		btn8.setBackground(SystemColor.textInactiveText);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn8.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn8.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn8.setBounds(105, 216, 75, 40);
		btn8.setFocusable(false);
		frmMycalculator.getContentPane().add(btn8);
		
		//9
		btn9 = new JButton("9");
		btn9.setForeground(new Color(255, 255, 255));
		btn9.setBackground(SystemColor.textInactiveText);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn9.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn9.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn9.setBounds(190, 216, 75, 40);
		btn9.setFocusable(false);
		frmMycalculator.getContentPane().add(btn9);
		
		//button multiply
		btnMultiply = new JButton("x");
		btnMultiply.setForeground(new Color(255, 255, 255));
		btnMultiply.setBackground(new Color(255, 153, 51));
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+btnMultiply.getText());
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnMultiply.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnMultiply.setBounds(275, 216, 75, 40);
		btnMultiply.setFocusable(false);
		frmMycalculator.getContentPane().add(btnMultiply);
		
		//4
		btn4 = new JButton("4");
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setBackground(SystemColor.textInactiveText);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn4.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn4.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn4.setBounds(20, 266, 75, 40);
		btn4.setFocusable(false);
		frmMycalculator.getContentPane().add(btn4);
		
		//5
		btn5 = new JButton("5");
		btn5.setForeground(new Color(255, 255, 255));
		btn5.setBackground(SystemColor.textInactiveText);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn5.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn5.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn5.setBounds(105, 266, 75, 40);
		btn5.setFocusable(false);
		frmMycalculator.getContentPane().add(btn5);
		
		//6
		btn6 = new JButton("6");
		btn6.setForeground(new Color(255, 255, 255));
		btn6.setBackground(SystemColor.textInactiveText);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn6.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn6.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn6.setBounds(190, 266, 75, 40);
		btn6.setFocusable(false);
		frmMycalculator.getContentPane().add(btn6);
		
		//button minus
		btnMinus = new JButton("-");
		btnMinus.setForeground(new Color(255, 255, 255));
		btnMinus.setBackground(new Color(255, 153, 51));
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+btnMinus.getText());
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnMinus.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnMinus.setBounds(275, 266, 75, 40);
		btnMinus.setFocusable(false);
		frmMycalculator.getContentPane().add(btnMinus);
		
		//1
		btn1 = new JButton("1");
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setBackground(SystemColor.textInactiveText);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn1.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn1.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn1.setBounds(20, 316, 75, 40);
		btn1.setFocusable(false);
		frmMycalculator.getContentPane().add(btn1);
		
		//2
		btn2 = new JButton("2");
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setBackground(SystemColor.textInactiveText);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn2.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn2.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn2.setBounds(105, 316, 75, 40);
		btn2.setFocusable(false);
		frmMycalculator.getContentPane().add(btn2);
		
		//3
		btn3 = new JButton("3");
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setBackground(SystemColor.textInactiveText);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn3.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn3.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn3.setBounds(190, 316, 75, 40);
		btn3.setFocusable(false);
		frmMycalculator.getContentPane().add(btn3);
		
		//button plus
		btnPlus = new JButton("+");
		btnPlus.setForeground(new Color(255, 255, 255));
		btnPlus.setBackground(new Color(255, 153, 51));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+btnPlus.getText());
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnPlus.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPlus.setBounds(275, 316, 75, 40);
		btnPlus.setFocusable(false);
		frmMycalculator.getContentPane().add(btnPlus);
		
		//button point
		btnPoint = new JButton(".");
		btnPoint.setForeground(new Color(255, 255, 255));
		btnPoint.setBackground(SystemColor.textInactiveText);
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText("Ans"+btnPoint.getText());
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnPoint.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btnPoint.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPoint.setBounds(20, 366, 75, 40);
		btnPoint.setFocusable(false);
		frmMycalculator.getContentPane().add(btnPoint);
		
		//0
		btn0 = new JButton("0");
		btn0.setForeground(new Color(255, 255, 255));
		btn0.setBackground(SystemColor.textInactiveText);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btn0.getText());
					Expression.setCaretPosition(1);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btn0.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+1);
				}
			}
		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn0.setBounds(105, 366, 75, 40);
		btn0.setFocusable(false);
		frmMycalculator.getContentPane().add(btn0);
		
		//button Ans
		btnAns = new JButton("Ans");
		btnAns.setForeground(new Color(255, 255, 255));
		btnAns.setBackground(SystemColor.textInactiveText);
		btnAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				
				flag2 = false;
				
				if(flag) {
					Expression.setText(btnAns.getText());
					Expression.setCaretPosition(3);
					flag=false;
				}
				else {
					caretPosition = Expression.getCaretPosition();
					StringBuffer tempString = new StringBuffer(Expression.getText());
					tempString.insert(caretPosition, btnAns.getText());
					Expression.setText(tempString.toString());
					Expression.setCaretPosition(caretPosition+3);
				}
			}
		});
		btnAns.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAns.setBounds(190, 366, 75, 40);
		btnAns.setFocusable(false);
		frmMycalculator.getContentPane().add(btnAns);
		
		//button equal
		btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(!Expression.getText().equals("") && !Expression.getText().equals("Syntax ERROR")) {
					expression = Expression.getText();
					Number num = new Number();
					StringBuffer tempString = new StringBuffer();
					
					//change symbol '+-' to '-', '-+' to '-', '++' to '+', and '--' to '+'
					for(int i = 0; i < expression.length(); i++) { 
						if(i + 1 < expression.length() && expression.charAt(i) == '+' && expression.charAt(i + 1) == '-') {
							tempString = new StringBuffer(expression);
							tempString.deleteCharAt(i);
							expression = tempString.toString();
							i--;
						}
						else if(i + 1 < expression.length() && expression.charAt(i) == '-' && expression.charAt(i + 1) == '+') {
							tempString = new StringBuffer(expression);
							tempString.deleteCharAt(i + 1);
							expression = tempString.toString();
							i--;
						}
						else if(i + 1 < expression.length() && expression.charAt(i) == '+' && expression.charAt(i + 1) == '+') {
							tempString = new StringBuffer(expression);
							tempString.deleteCharAt(i);
							expression = tempString.toString();
							i--;
						}
						else if(i + 1 < expression.length() && expression.charAt(i) == '-' && expression.charAt(i + 1) == '-') {
							tempString = new StringBuffer(expression);
							tempString.delete(i, i + 2);
							tempString.insert(i, "+");
							expression = tempString.toString();
							i--;
						}
					}
					
					//find errors
					if(expression.contains("..") || expression.contains("^^") || expression.contains("xx") || expression.contains("//") || expression.contains("%%") || expression.contains("EE")) {
						//if there has duplication symbol '.', '^', 'x', '/', '%' and 'E' in the expression
						Expression.setText("Syntax ERROR");
						Answer.setText("");
						return;
					}
					else if(expression.contains("+/") || expression.contains("+x") || expression.contains("+^") || expression.contains("+%")) {
						//if there has symbol '+' before '/', 'x' '^' and '%' in the expression
						Expression.setText("Syntax ERROR");
						Answer.setText("");
						return;
					}
					else if(expression.contains("-/") || expression.contains("-x") || expression.contains("-^") || expression.contains("-%")) {
						//if there has symbol '-' before '/', 'x' '^' and '%' in the expression
						Expression.setText("Syntax ERROR");
						Answer.setText("");
						return;
					}
					else if(expression.contains("x/") || expression.contains("/x") || expression.contains("x%") || expression.contains("/%") || expression.contains("Ex") || expression.contains("E/") || expression.contains("E%")) {
						//if there has 'x/' or '/x' or 'x%' or '/%' or 'Ex' or 'E/' or 'E%'
						Expression.setText("Syntax ERROR");
						Answer.setText("");
						return;
					}
					else if(expression.contains("x^") || expression.contains("/^") || expression.contains("^%") || expression.contains("E^") || expression.contains("^x") || expression.contains("^/") || expression.contains("^%")) {
						//if there has '^' before 'x', '/', '%' or '^' after 'x', 'E'
						Expression.setText("Syntax ERROR");
						Answer.setText("");
						return;
					}
					else if(expression.contains("()") || expression.contains("(%") || expression.contains(")%")) {
						//if there has '()' in the expression
						Expression.setText("Syntax ERROR");
						Answer.setText("");
						return;
					}
					for(int i = 0; i < expression.length(); i++) { //find if there is two points separated by number in the expression
						if(expression.charAt(i) == '.') {
							int j = i+1;
							while(j<expression.length() && Character.isDigit(expression.charAt(j)) || j<expression.length() && expression.charAt(j) == '.') {
								if(expression.charAt(j) =='.') {
									Expression.setText("Syntax ERROR");
									Answer.setText("");
									return;
								}
								j++;
							}
						}
					}
					for(int i = 0; i < expression.length(); i++) { 
						if(expression.charAt(i) == 'A') {
							if(i + 3 < expression.length() && expression.charAt(i + 3) == '.' || i + 3 < expression.length() && Character.isDigit(expression.charAt(i + 3))) {
								//find if there is point or number after "Ans"
								Expression.setText("Syntax ERROR");
								Answer.setText("");
								return;
							}
							else if(i - 1 >= 0 && expression.charAt(i - 1) == '.') {
								//if there is point before "Ans"
								tempString = new StringBuffer(expression);
								tempString.insert(i, "0");
								expression = tempString.toString();
							}
						}
					}
					
					for(int i = 0; i < expression.length(); i++) { //find if there is no number before point
						if(i == 0 && expression.charAt(i) == '.' || i > 0 && expression.charAt(i) == '.' && !Character.isDigit(expression.charAt(i - 1))) {
							tempString = new StringBuffer(expression);
							tempString.insert(i, "0");
							expression = tempString.toString();
						}
					}
					
					for(int i = 0; i < expression.length(); i++) { 
						if(i > 0 && expression.charAt(i) == 'A' && expression.charAt(i - 1) == ')') {
							//if there is 'Ans' after ')' 
							tempString = new StringBuffer(expression);
							tempString.insert(i, "x");
							expression = tempString.toString();
						}
						if(i + 3 < expression.length() && expression.charAt(i) == 'A' && expression.charAt(i + 3) == '(') {
							//if there is 'Ans' before '('
							tempString = new StringBuffer(expression);
							tempString.insert(i + 3, "x");
							expression = tempString.toString();
						}
					}
					
					for(int i = 0; i < expression.length(); i++) { //find if there is no number between '%' and 'E'
						if(i - 1 >= 0 && expression.charAt(i) == 'E' && expression.charAt(i - 1) == '%') {
							tempString = new StringBuffer(expression);
							tempString.insert(i, "x");
							expression = tempString.toString();
						}
					}
					
					for(int i = 0; i < expression.length(); i++) { //find if there is '+' after 'E'
						if(i + 1 < expression.length() && expression.charAt(i) == 'E' && expression.charAt(i + 1) == '+') {
							tempString = new StringBuffer(expression);
							tempString.deleteCharAt(i + 1);
							expression = tempString.toString();
						}
					}
					
					if(expression.contains("E(") || expression.contains("EAns")) { //if there is 'E(' or 'EAns' in the expression
						Expression.setText("Syntax ERROR");
						Answer.setText("");
						return;
					}
					
					for(int i = 0; i < expression.length(); i++) {
						if(expression.charAt(i) == 'E') {
							i++;
							while(i < expression.length() && Character.isDigit(expression.charAt(i)) || i < expression.length() && expression.charAt(i) == '.') {
								if(expression.charAt(i) == '.') { 
									//if there is number with point after 'E'
									Expression.setText("Syntax ERROR");
									Answer.setText("");
									return;
								}
								i++;
								
							}
							if(i < expression.length() && expression.charAt(i) == 'E' || i < expression.length() && expression.charAt(i) == '%') { 
								//if the number after 'E' has 'E' or '%'
								Expression.setText("Syntax ERROR");
								Answer.setText("");
								return;
							}
						}
					}
					
					if(expression.contains("(")) {
						//if there are brackets, check if the brackets are in the correct position
						int l = 0;
						int r = 0;
						
						for(int i = 0; i < expression.length(); i++) {
							if(expression.charAt(i) == '(')
								l++;
							else if(expression.charAt(i) == ')')
								r++;
							
							if(r == 1 && l == 0) { //if the bracket starts with ')'
								Expression.setText("Syntax ERROR");
								Answer.setText("");
								return;
							}
						}
						
						if( l != r) { //if quantity of left bracket and right bracket are not equal
							Expression.setText("Syntax ERROR");
							Answer.setText("");
							return;
						}
						
						for(int i = expression.length() - 1; i >= 0; i--) {
							if(expression.charAt(i) == '(')
								l--;
							else if(expression.charAt(i) == ')')
								r--;
							
							if(r > l) { //if the bracket ends with '('
								Expression.setText("Syntax ERROR");
								Answer.setText("");
								return;
							}
						}
					}
					
					for(int i = 0; i < expression.length(); i++) {
						if(i + 1 < expression.length() && expression.charAt(i) == ')' && Character.isDigit(expression.charAt(i + 1))) {
							Expression.setText("Syntax ERROR");
							Answer.setText("");
							return;
						}
						if(i - 1 >= 0 && expression.charAt(i) == ')' && !Character.isDigit(expression.charAt(i - 1)) && expression.charAt(i - 1) != '%' && expression.charAt(i - 1) != ')') {
							Expression.setText("Syntax ERROR");
							Answer.setText("");
							return;
						}
					}
					
					if(expression.endsWith("x") || expression.endsWith("/") || expression.endsWith("-") || expression.endsWith("+") || expression.endsWith("^") || expression.endsWith("E") || expression.endsWith("(")) {
						//if expression ends with 'x', '/', '-', '+', '^', 'E' or '('
						Expression.setText("Syntax ERROR");
						Answer.setText("");
						return;
					}
					else if(expression.charAt(0) == 'x' || expression.charAt(0) == '/' || expression.charAt(0) == '^' || expression.charAt(0) == '%' || expression.charAt(0) == ')') {
						//if expression starts with 'x', '/', '-', '+', '^', '%' or ')'
						Expression.setText("Syntax ERROR");
						Answer.setText("");
						return;
					}
					else {
						for(int i = 0; i < expression.length(); i++) { 
							if(expression.charAt(i) == 'A') {
								if(i > 0 && Character.isDigit(expression.charAt(i-1))) {
									//replace "Ans?" to "Ansx?"
									tempString = new StringBuffer(expression);
									tempString.insert(i, "x");
									expression = tempString.toString();
									i++;
								}
								if(i + 3 < expression.length() && expression.charAt(i +3) == 'A') {
									//replace "AnsAns" to "AnsxAns"
									tempString = new StringBuffer(expression);
									tempString.insert(i+3, "x");
									expression = tempString.toString();
								}
								
								//replace "Ans" to numbers
								tempString = new StringBuffer(expression);
								tempString.delete(i, i+3);
								tempString.insert(i, String.valueOf(answer));
								expression = tempString.toString();
							}
						}
						
						for(int i = 0; i < expression.length(); i++) { //find if there is no number before 'E'
							if(i == 0 && expression.charAt(i) == 'E' || i > 0 && expression.charAt(i) == 'E' && !Character.isDigit(expression.charAt(i - 1))) {
								tempString = new StringBuffer(expression);
								tempString.insert(i, "1");
								expression = tempString.toString();
							}
						}
						
						//replace "?%" to "(?/100)"
						for(int i = 0; i < expression.length(); i++) {
							if(expression.charAt(i) == '%') {
								int stop = i;
								i--;
								while (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.' || expression.charAt(i) == 'E' || i - 1 >= 0 && expression.charAt(i) == '-' && expression.charAt(i - 1) == 'E') {
									i--;
									if(i == -1) {
										break;
									}
								}
								i++;
								
								int start = i;
								double number = num.separateNumber(i, expression);
								
								tempString = new StringBuffer(expression);
								
								for(int j = start; j <= stop; j++) {
									tempString.deleteCharAt(start);
								}
								tempString.insert(start, "(" + String.valueOf(number) + "/100)");
								expression = tempString.toString();
							}
						}
						
						for(int i = 0; i < expression.length(); i++) { //find if there is ')(', insert 'x' in the middle
							if(i + 1 < expression.length() && expression.charAt(i) == ')' && expression.charAt(i + 1) == '(') {
								tempString = new StringBuffer(expression);
								tempString.insert(i + 1, "x");
								expression = tempString.toString();
							}
						}
						
						for(int i = 0; i < expression.length(); i++) {
							if(i + 1 < expression.length() && Character.isDigit(expression.charAt(i)) && expression.charAt(i + 1) == '(') {
								tempString = new StringBuffer(expression);
								tempString.insert(i + 1, "x");
								expression = tempString.toString();
							}
							if(i - 1 >= 0 && expression.charAt(i) == '(' && Character.isDigit(expression.charAt(i))) {
								tempString = new StringBuffer(expression);
								tempString.insert(i - 1, "x");
								expression = tempString.toString();
							}
						}
						
						while(expression.contains("(")) { //do operation for expression in bracket first
							int start1 = 0;
							int stop1 = 0;
							
							for(int i = 0; i < expression.length(); i++) {
								if(expression.charAt(i) == '(') {
									start1 = i;
								}
								else if(expression.charAt(i) == ')') {
									stop1 = i;
									break;
								}
							}
							
							String exp = num.separateExpression(start1, expression);
							
							double number = num.operation(exp);
							
							tempString = new StringBuffer(expression);
							
							for(int j = start1; j <= stop1; j++) {
								tempString.deleteCharAt(start1);
								expression = tempString.toString();
							}
							tempString = new StringBuffer(expression);
							tempString.insert(start1, String.valueOf(number));
							expression = tempString.toString();
							
						}
						
						//after there is no more bracket
						answer = num.operation(expression); //operation
						
						String ans = String.valueOf(answer);
						
						//if ans is more than 1, round the ans to 9 decimal places
						if(!ans.contains("E-")) {
							BigDecimal round = new BigDecimal(Double.parseDouble(ans)).setScale(9, RoundingMode.HALF_UP);
							ans = String.valueOf(round.doubleValue());
						}
						if(ans.contains("E")) {
							for(int i = 0; i < ans.length(); i++) {
								if(ans.charAt(i) == '.') {
									i++;
									int start = i;
									while(Character.isDigit(ans.charAt(i))) {
										i++;
									}
									int stop = i;
									if(stop-start>9) {
										tempString = new StringBuffer(ans);
										String E = tempString.delete(0, stop).toString();
										tempString = new StringBuffer(ans);
										tempString.delete(stop, tempString.length());
										BigDecimal round2 = new BigDecimal(Double.parseDouble(tempString.toString())).setScale(9, RoundingMode.HALF_UP);
										ans = String.valueOf(round2.doubleValue())+E;
									}
									break;
								}
							}
						}
						
						//check if Answer ends with ".0"
						if(ans.endsWith(".0")) { //remove ".0" at the last in Answer
							tempString = new StringBuffer(ans);
							tempString.delete(tempString.length()-2, tempString.length());
							ans = tempString.toString();
						}
						
						//insert ','
						if(ans.contains(".")) {
							for(int i = 0; i < ans.length(); i++) {
								if(ans.charAt(i) == '.') {
									i--;
									while(i-2>0) {
										i-=2;
										tempString = new StringBuffer(ans);
										tempString.insert(i, ",");
										ans = tempString.toString();
										i--;
									}
									break;
								}
							}
						}
						else {
							int i = ans.length()-1;
							while(i-2>0) {
								i-=2;
								tempString = new StringBuffer(ans);
								tempString.insert(i, ",");
								ans = tempString.toString();
								i--;
							}
						}
						
						Answer.setText(ans);
						flag = true; //to mark that the button '=' was pressed
						return;
					}
				}
				else if(Expression.getText().equals("Syntax ERROR")) {
					Expression.setText(expression);
					Answer.setText("0");
					return;
				}
				return;
			}
		});
		btnEqual.setForeground(new Color(255, 255, 255));
		btnEqual.setBackground(new Color(255, 153, 51));
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnEqual.setBounds(275, 366, 75, 40);
		btnEqual.setFocusable(false);
		frmMycalculator.getContentPane().add(btnEqual);
	}
}

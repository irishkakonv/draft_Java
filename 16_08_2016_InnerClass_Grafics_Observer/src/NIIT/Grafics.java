package NIIT;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

interface Stack{
	void push(String value);
	String pop();
}
class MyContainer implements Stack{
	LinkedList<String> list = new LinkedList<String>();
	@Override
	public void push(String value) {
		list.add(value);
	}
	@Override
	public String pop() {
	if(! list.isEmpty()){
		String last = list.getLast();
		list.removeLast();
		return last;
	}
	else
	{
		return "Stack is empty";
	}
}
}
public class Grafics {
	static JFrame frame = new JFrame("Some title");      //объект окно
	static JPanel panel = new JPanel(null);				// 
	static JLabel outLabel = new JLabel();
	static JTextArea inText = new JTextArea();
	static JButton pushBtn = new JButton("Push");
	static JButton pophBtn = new JButton("Pop");
	static Stack stack = new MyContainer();
	
	
	public static void main(String[] args) {
		
		panel.setBackground(Color.yellow);              //фон
		panel.add(outLabel);
		panel.add(pophBtn);
		panel.add(inText);
		panel.add(pushBtn);
		
		outLabel.setLocation(0, 10);
		//outLabel.setText("dffffff");
		outLabel.setSize(150, 20);
		
		pophBtn.setLocation(200, 0);
		pophBtn.setSize(80, 20);
		pophBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				outLabel.setText(stack.pop());
			}
		});
		
		inText.setLocation(10, 40);
		inText.setSize(150, 20);
		
		pushBtn.setLocation(200, 40);
		pushBtn.setSize(80, 20);
		pushBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				stack.push(inText.getText());
				inText.setText(null);
				
			}
		
		});
		
		
		frame.setTitle("Title");
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(panel);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}

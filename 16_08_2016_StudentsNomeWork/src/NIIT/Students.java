package NIIT;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


interface Stack {
	void push(String name, String marks);
	String pop();
	String getAverage(String name);
	String getMarks(String name);
}


class Student{
	private String name;
	protected String marks;
	private double average;
	
	Student(String n, String m){
		this.name = n;
		this.marks = m;
		this.makeAverage();
	}
	
	public String getName(){
		return name;
	}
	
	public String getMarks(){
		return marks;
	}
	
	public double getAverage(){
		return average;
	}
	
	public void makeAverage(){
		/* parse the marks*/
		LinkedList<Integer> listMarks = new LinkedList<Integer>();
		String[] temp = this.marks.split(",");
		// delete all white spaces
		for(String t: temp){
			t.replace(" ", "");
			try{
				if(Integer.parseInt(t) > 0 && Integer.parseInt(t) < 6){
				listMarks.add(Integer.parseInt(t));
				}
				else{
					this.average = 0; 
				}
			}catch (NumberFormatException e) {                    
		       this.average = 0; 
		    } 
		}
		int aver = 0;
		for(Integer t: listMarks){
			aver += t;
		}
		this.average = (double)aver/listMarks.size();
	}
}


class MyContainer implements Stack {
	LinkedList<Student> students = new LinkedList<Student>(); //the list of the students
	@Override
	public void push(String name, String marks) {
		Student student = new Student(name, marks);
		students.add(student);
	}

	@Override
	public String pop() {
		if (!students.isEmpty()) {
			Student lastStudent = students.getLast();
			students.removeLast();
			return lastStudent.getName();
		} else {
			return "Stack is empty";
		}
	}
	
	@Override
	public String getAverage(String name_) {
		for(Student s: students){
			if(s.getName().equals(name_)){
				if(s.marks.isEmpty()){                 
					return "The student don't have marks";
				}
				return String.valueOf(s.getAverage()) ;
			}
		}
		return "The student doesn't exist";
	}
	
	@Override
	public String getMarks(String name_) {
		for(Student s: students){
			if(s.getName().equals(name_)){
				if(s.marks.isEmpty()){                 
					return "The student don't have marks";
				}
				return s.getMarks();
			}	
		}
		return "The student doesn't exist";
	}
}

	
public class Students {
	static JFrame frame = new JFrame("Some title"); 
	static JPanel panel = new JPanel(null); //
	
	static JLabel outLabelName = new JLabel();
	static JLabel outLabelGetAverafeMarks = new JLabel();
	static JLabel outLabelGetListMarks = new JLabel();
	static JLabel outLabelMarks = new JLabel();
	static JLabel outLabelGetName = new JLabel();
	
	static JTextArea inName = new JTextArea();
	static JTextArea inMarks = new JTextArea();	
	static JTextArea inNameGetMarks = new JTextArea();
	
	static JButton pushBtnNameMarks = new JButton("Push");
	static JButton popBtnName = new JButton("Pop");
	static JButton pushBtnGetAverageMarks = new JButton("Get");
	static JButton pushBtnGetListMarks = new JButton("Get");

	static Stack stack = new MyContainer();

	public static void main(String[] args) {
		
		panel.setBackground(Color.green);             
		panel.add(outLabelName);
		panel.add(outLabelMarks);
		panel.add(outLabelGetName);
		panel.add(outLabelGetAverafeMarks);
		panel.add(outLabelGetListMarks);
		
		panel.add(inName);
		panel.add(inMarks);
		panel.add(inNameGetMarks);
		
		panel.add(pushBtnNameMarks);
		panel.add(pushBtnGetAverageMarks);
		panel.add(pushBtnGetListMarks);
		
		panel.add(popBtnName);
		
		outLabelName.setLocation(0, 10);
		outLabelName.setText("Enter name");
		outLabelName.setSize(150, 20);
		
		outLabelMarks.setLocation(0, 70);
		outLabelMarks.setText("Enter mark");
		outLabelMarks.setSize(150, 20);
		
		outLabelGetName.setLocation(0, 125);
		outLabelGetName.setText("Enter name");
		outLabelGetName.setSize(150, 20);
				
		outLabelGetAverafeMarks.setLocation(0, 140);
		outLabelGetAverafeMarks.setText("Get an average rating");
		outLabelGetAverafeMarks.setSize(180, 100);
		
		outLabelGetListMarks.setLocation(0, 170);
		outLabelGetListMarks.setText("Get a list of assessments");
		outLabelGetListMarks.setSize(180, 100);
		
		inName.setLocation(10, 40);
		inName.setSize(150, 20);
		
		inMarks.setLocation(10, 100);
		inMarks.setSize(150, 20);
		
		inNameGetMarks.setLocation(10, 150);
		inNameGetMarks.setSize(150, 20);
		
		pushBtnNameMarks.setLocation(220, 50);
		pushBtnNameMarks.setSize(80, 20);
		
		pushBtnGetAverageMarks.setLocation(220, 175);
		pushBtnGetAverageMarks.setSize(80, 20);
		
		pushBtnGetListMarks.setLocation(220, 210);
		pushBtnGetListMarks.setSize(80, 20);
		
		popBtnName.setLocation(220,80);
		popBtnName.setSize(80, 20);

		frame.setTitle("Title");
		frame.setSize(320, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(panel);
		frame.setResizable(false);
		frame.setVisible(true);
		
		pushBtnNameMarks.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				stack.push(inName.getText(), inMarks.getText());
				inName.setText(null);
				inMarks.setText(null);
			}
		});
		
		pushBtnGetAverageMarks.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				outLabelGetAverafeMarks.setText(stack.getAverage(inNameGetMarks.getText()));			
			}
		});
		
		pushBtnGetListMarks.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				outLabelGetListMarks.setText(stack.getMarks(inNameGetMarks.getText()));			
			}
		});
		
		popBtnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				outLabelName.setText(stack.pop());
			}
		});
		
	}
}

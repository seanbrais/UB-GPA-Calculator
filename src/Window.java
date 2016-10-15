import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Window extends JFrame {
	private JTextField gpaLabel = new JTextField(30);
	private int _numberOfClasses;
	JTextField sizeField = new JTextField(30);
	private ArrayList<JTextField> _earnedCredits;
	private ArrayList<JTextField> _maxCredits;
	
	public Window(int numberOfClasses) {
		_earnedCredits = new ArrayList<JTextField>();
		_maxCredits = new ArrayList<JTextField>();
		_numberOfClasses = numberOfClasses;
		this.setTitle("GPA Calculator--Sean Brais");
		Container panel1 = checkBoxContainer(Component.TOP_ALIGNMENT);
		Container panel3 = gpaContainer(Component.CENTER_ALIGNMENT);
		setLayout(new GridLayout(1, 2));
		add(panel1);
		add(panel3);
		setSize(1200, 300);
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private Container checkBoxContainer(float alignment) {
		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createTitledBorder("Classes"));
		GridLayout layout = new GridLayout(_numberOfClasses + 1, 1);
		container.setLayout(layout);
		JPanel containerInsideFirst = new JPanel();
		GridLayout layoutInsideFirst = new GridLayout(1,4);
		containerInsideFirst.setLayout(layoutInsideFirst);
		JLabel classes = new JLabel("Class");
		JLabel earnCredit = new JLabel("Earned Credit");
		JLabel totalCredit = new JLabel("Total Credit");
		containerInsideFirst.add(classes);
		containerInsideFirst.add(earnCredit);
		containerInsideFirst.add(totalCredit);
		container.add(containerInsideFirst);
		for(int i = 0; i < _numberOfClasses; i++){
			JPanel containerInside = new JPanel();
			GridLayout layoutInside = new GridLayout(1,4);
			containerInside.setLayout(layoutInside);
			
			//Class Name
			JTextField className = new JTextField();
			className.setSize(100, 100);
			Font font = new Font("SansSerif", Font.BOLD, 20);
			className.setHorizontalAlignment(SwingConstants.CENTER);
			className.setFont(font);
			containerInside.add(className);
			
			//Earned Credit
			JTextField earnedCredit = new JTextField("A");
			earnedCredit.setSize(100, 100);
			earnedCredit.setHorizontalAlignment(SwingConstants.CENTER);
			earnedCredit.setFont(font);
			earnedCredit.addActionListener(new ChangeGradeHandler(this, _numberOfClasses));
			containerInside.add(earnedCredit);
			_earnedCredits.add(earnedCredit);
			
			//Total Credit
			JTextField maxCredit = new JTextField("4");
			maxCredit.setSize(100, 100);
			maxCredit.setHorizontalAlignment(SwingConstants.CENTER);
			maxCredit.setFont(font);
			maxCredit.addActionListener(new ChangeGradeHandler(this, _numberOfClasses));
			containerInside.add(maxCredit);
			_maxCredits.add(maxCredit);
			//Add these to container
			container.add(containerInside);
		}
		return container;
	}

	private Container gpaContainer(float alignment) {
		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createTitledBorder("Expected GPA"));
		BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
		container.add(gpaLabel);
		gpaLabel.setSize(100, 100);
		Font font = new Font("SansSerif", Font.BOLD, 20);
		gpaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gpaLabel.setFont(font);
		container.setLayout(layout);
		return container;
	}
	public void setGPAText(String incomingGPA) {
		double gpa = Double.valueOf(incomingGPA);
		DecimalFormat decFor = new DecimalFormat("##.####");
		gpaLabel.setText(decFor.format(gpa));
	}
	public String getEarnedCredit(int index){
		return Double.toString(letterToGrade(_earnedCredits.get(index).getText()));
	}
	public String getTotalCredit(int index){
		return _maxCredits.get(index).getText();
	}
	
	public double letterToGrade(String grade){
		if(grade.equals("A")){
			return 4.0;
		}
		else if(grade.equals("A-")){
			return 11.0/3.0;
		}
		else if(grade.equals("B+")){
			return 10.0/3.0;
		}
		else if(grade.equals("B")){
			return 3.0;
		}
		else if(grade.equals("B-")){
			return 8.0/3.0;
		}
		else if(grade.equals("C+")){
			return 7.0/3.0;
		}
		else if(grade.equals("C")){
			return 2.0;
		}
		else if(grade.equals("C-")){
			return 5.0/3.0;
		}
		else if(grade.equals("D+")){
			return 4.0/3.0;
		}
		else if(grade.equals("D")){
			return 1.0;
		}
		else if(grade.equals("F")){
			return 0.0;
		}
		else{
			return 0;
		}
	}
}

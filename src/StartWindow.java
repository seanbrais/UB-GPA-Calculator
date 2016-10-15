import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

public class StartWindow extends JFrame {
	private JTextField numberOfClasses = new JTextField(30);
	JTextField sizeField = new JTextField(30);

	public StartWindow() {
		this.setTitle("GPA Calculator--Sean Brais");
		Container panel3 = numberOfClasses();
		setLayout(new GridLayout(1,1));
		add(panel3);
		setSize(1200, 300);
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private Container numberOfClasses() {
		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createTitledBorder(""));
		FlowLayout layout = new FlowLayout();
		JLabel label = new JLabel("Number of Classes");
		container.add(label);
		container.add(numberOfClasses);
		numberOfClasses.setSize(100, 100);
		Font font = new Font("SansSerif", Font.BOLD, 20);
		numberOfClasses.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfClasses.setFont(font);
		JButton startButton = new JButton("Click to begin");
		startButton.addActionListener(new EnterWindowHandler(this));
		container.add(startButton);
		container.setLayout(layout);
		return container;
	}
	public void setPasswordText(String passwordText) {
		numberOfClasses.setText(passwordText);
	}
	public void setSizeLabelText(int size) {
		sizeField.setText("" + size);
	}

	public int getSizeLabelText() {
		return Integer.parseInt(sizeField.getText());
	}
	public int getNumberOfClasses(){
		return Integer.parseInt(numberOfClasses.getText());
	}
}

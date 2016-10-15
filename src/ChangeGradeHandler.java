import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ChangeGradeHandler implements ActionListener {
	Window _window;
	int _numberOfClasses;
	public ChangeGradeHandler(Window window, int numberOfClasses){
		_window = window;
		_numberOfClasses = numberOfClasses;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		double totalCredits = 0.0;
		double earnedCredits = 0.0;
		for(int i = 0; i < _numberOfClasses; i++){
			earnedCredits += Double.parseDouble(_window.getTotalCredit(i)) * Double.parseDouble(_window.getEarnedCredit(i));
			totalCredits += Double.parseDouble(_window.getTotalCredit(i));
		}
		if(totalCredits == 0){
			_window.setGPAText("0");
		}
		else{
			_window.setGPAText(Double.toString(earnedCredits/totalCredits));
		}
		
		
	}

}

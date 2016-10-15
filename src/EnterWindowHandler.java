import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class EnterWindowHandler implements ActionListener {
	StartWindow _currentWindow;
	public EnterWindowHandler(StartWindow currentWindow){
		_currentWindow = currentWindow;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_currentWindow.dispose();
		new Window(_currentWindow.getNumberOfClasses());
	}

}

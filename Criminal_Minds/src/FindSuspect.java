import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

//GUI gia to Find Suspect
public class FindSuspect extends JFrame{
	private Registry registry;
	private JTextField nameField;
	private JButton findButton;
	private JPanel panel;
	
	public FindSuspect(Registry aRegistry){
		this.registry=aRegistry;
		panel = new JPanel();
		nameField = new JTextField(17);
		nameField.setText("Please enter suspect's name");
		nameField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                nameField.setText("");
            }
        });  
		findButton = new JButton("Find");
		
		panel.add(nameField);
		panel.add(findButton);
		
		ButtonListener listener = new ButtonListener();
		findButton.addActionListener(listener);
		
		this.setContentPane(panel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Find Suspect");
		this.setSize(300,100);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean flag=false;
			Suspect sus = null;
			String name = nameField.getText();
			System.out.print("");
			for(Suspect s : registry.getSuspectsList()) {
				if(s.getName().equals(name)) {
					flag=true;
					sus = s;
				}
			}
			if(e.getSource().equals(findButton)) {
				if(!flag) {
					JOptionPane.showMessageDialog(null, "User "+name+" Not Found");
				} else {
					new SuspectPage(sus,registry);
					dispose();
				}
			}
		}
		
	}
	
}

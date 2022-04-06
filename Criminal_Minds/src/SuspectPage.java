import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

//GUI gia Suspect page
public class SuspectPage extends JFrame{
	Suspect sus;
	Registry registry;
	private JPanel panel1,panel2,panel3,panel4,panel5;
	private JTextField nameField,codenameField,telnumField;
	private TextArea smsField,parField,sugField;
	private JButton smsButton,returnButton;
	private JList<String> list;
	private JLabel parLabel,sugLabel;
	
	public SuspectPage(Suspect sus,Registry registry) {
		this.sus = sus;
		this.registry = registry;
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		panel1 = new JPanel(new FlowLayout());
		panel2 = new JPanel(new FlowLayout());
		panel3 = new JPanel(new FlowLayout());
		panel4 = new JPanel(new FlowLayout());
		panel5 = new JPanel(new FlowLayout());
		
		nameField = new JTextField(10);
		nameField.setText(sus.getName());
		nameField.setEditable(false);
		codenameField = new JTextField(10);
		codenameField.setText(sus.getCodename());
		codenameField.setEditable(false);
		list = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();		
		for(String s : sus.getTelNumbers()) {
			model.addElement(s);
		}
		list.setModel(model);
		
		telnumField = new JTextField(10);
		smsField = new TextArea(10,30);
		smsButton = new JButton("Find SMS");
		
		parLabel = new JLabel("Partners");
		parField = new TextArea(10,30);
		for(Suspect susp : sus.getCoworkers()){
			   parField.append(susp.getName() +", "+ susp.getCodename()+ "\n");
			};
		
		sugLabel = new JLabel("Suggested partners");
		sugField = new TextArea(10,20);
		for(Suspect su : sus.suggestedPartners()){
			   sugField.append(su.getName() +", "+ su.getCodename()+ "\n");
			};
			
		returnButton = new JButton("Back to search screen");
			
		panel1.add(nameField);
		panel1.add(codenameField);
		panel1.add(list);
		
		panel2.add(telnumField);
		panel2.add(smsField);
		panel2.add(smsButton);
		
		panel3.add(parLabel);
		panel3.add(parField);
		
		panel4.add(sugLabel);
		panel4.add(sugField);
		
		panel5.add(returnButton);
		
		contentPane.add(panel1);
		contentPane.add(panel2);
		contentPane.add(panel3);
		contentPane.add(panel4);
		contentPane.add(panel5);
		
		ButtonListener listener = new ButtonListener();
		smsButton.addActionListener(listener);
		returnButton.addActionListener(listener);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Suspect Page");
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		

	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String telnum = telnumField.getText();
			ArrayList<String> smsList = new ArrayList<String>();
			if(e.getSource().equals(smsButton)) {
				for(String s : sus.getTelNumbers()) {
					for(Communication c : registry.getCommList()) {
						if(((c.getNum1().equals(telnum) && c.getNum2().equals(s)))||((c.getNum1().equals(s) && c.getNum2().equals(telnum)))){
							if(c.getContent()!=null&&(c.getContent().contains("Bomb")||c.getContent().contains("Attack")||c.getContent().contains("Explosives")||c.getContent().contains("Gun"))) {
								smsList.add(c.getContent());
							}
						}
					}
				}
				for(String s : smsList){
					   smsField.append(s + "\n");
					};
			}else if (e.getSource().equals(returnButton)) {
				new FindSuspect(registry);
				dispose();
			}
			
		}
		
	}

}

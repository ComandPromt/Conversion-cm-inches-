import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class MetricConverter extends JFrame implements ActionListener {
	// the components for cm-inch
	private JTextField cmText = new JTextField(6);
	private JLabel cmLabel = new JLabel("cm");
	private JButton cmToInchButton = new JButton("===>");
	private JButton inchToCmButton = new JButton("<===");
	private JPanel inchCmButtons = new JPanel();// compound container
	private JTextField inchText = new JTextField(6);
	private JLabel inchLabel = new JLabel("inches");
	private JPanel inchCmPanel = new JPanel();// compound container

	// clear screen button
	private JButton clearButton = new JButton("CLEAR");
	private JPanel clearPanel = new JPanel();

	public MetricConverter() {
		// set window specifics
		setTitle("CM - Inches Converter");
		setSize(424, 100);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		setVisible(true);

		inchCmButtons.setLayout(new BorderLayout());
		cmToInchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		inchCmButtons.add("North", cmToInchButton);
		inchToCmButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		inchCmButtons.add("South", inchToCmButton);
		cmText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		// add components to the cm inch panel
		inchCmPanel.add(cmText);
		cmLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		inchCmPanel.add(cmLabel);
		inchCmPanel.add(inchCmButtons);
		inchText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inchCmPanel.add(inchText);
		inchLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		inchCmPanel.add(inchLabel);

		// add clear button to clear panel
		clearPanel.setLayout(new BorderLayout());

		// add the panels (which hold the window components)
		getContentPane().add(inchCmPanel);
		clearButton.setFont(new Font("Verdana", Font.BOLD, 16));
		getContentPane().add(clearButton);
		clearButton.addActionListener(this);
		getContentPane().add(clearPanel);

		// give raised borders to the buttons
		cmToInchButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		inchToCmButton.setBorder(new BevelBorder(BevelBorder.RAISED));

		// add actionListeners to buttons
		cmToInchButton.addActionListener(this);
		inchToCmButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		double d;
		String s;
		// format the output
		DecimalFormat df = new DecimalFormat("#####0.0#");

		// convert cm to inches
		if (e.getSource() == cmToInchButton) {
			s = cmText.getText();
			d = Double.parseDouble(s);
			d = d / 2.54;
			s = df.format(d);
			inchText.setText(s);
		}
		// inch to cm
		if (e.getSource() == inchToCmButton) {
			s = inchText.getText();
			d = Double.parseDouble(s);
			d = d * 2.54;
			s = df.format(d);
			cmText.setText(s);
		}
		// clear
		if (e.getSource() == clearButton) {
			s = "";

			cmText.setText(s);
			inchText.setText(s);

		}

	}

}

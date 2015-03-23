/* Author: Richard Huang
 * Date: 3-23-2015
 * Description: Used to convert Celsius into Fahrenheit using Swing components
 *				and layouts
 * File: CelsiusConverterGUI.java 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CelsiusConverterGUI extends JFrame
{
	// Variables
	private JLabel celsiusLabel;
	private JButton convertButton;
	private JLabel fahrenheitLabel;
	private JTextField tempTextField;
	
	//start!
	public static void main(String args[]) 
	{
		java.awt.EventQueue.invokeLater(new Runnable() 
		{	
			public void run() 
			{
				new CelsiusConverterGUI().setSize(210,110);
			}
		});
	}
	
	//JFrame that displays Celsius GUI Conveter
	public CelsiusConverterGUI()
	{
		initComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Celsius Converter");
		setVisible(true);
		pack();
	}
	
	//Initialize the variables
	public void initComponents()
	{
		celsiusLabel = new JLabel();
		convertButton = new JButton();
		fahrenheitLabel = new JLabel();
		tempTextField = new JTextField();
		
		//Set up convert button
		convertButton.setText("Convert");
		convertButton.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e)
			{
				convert(e);
			}
		});
		
		//Set up fahrenheit label
		fahrenheitLabel.setText("Fahrenheit");
		
		//Set up celsius label
		celsiusLabel.setText("Celsius");
		
		//Set up layout with parallel groups
		Container panel = getContentPane();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//Horizontal
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().
			addComponent(tempTextField).addComponent(convertButton));
		hGroup.addGroup(layout.createParallelGroup().
			addComponent(celsiusLabel).addComponent(fahrenheitLabel));
		layout.setHorizontalGroup(hGroup);
		layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {convertButton, tempTextField}); //keeps button/textField same size
		
		//Vertical
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
			addComponent(tempTextField).addComponent(celsiusLabel));
		vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
			addComponent(convertButton).addComponent(fahrenheitLabel));
		layout.setVerticalGroup(vGroup);
	}
	
	//When convertButton pressed, calculate and display conversion
	public void convert(ActionEvent e)
	{
		int fahrenheit = (int)(Double.valueOf(tempTextField.getText()) * 1.8 + 32);
		fahrenheitLabel.setText(fahrenheit + " Fahrenheit");
	}
}
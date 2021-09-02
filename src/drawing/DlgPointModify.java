package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPointModify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXcoord;
	private JTextField txtYcoord;
	
	private int xCoordP;
	private int yCoordP;
	
	private Color newColor;
	private JButton btnColorP;

	
	private int option = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPointModify dialog = new DlgPointModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// kreiranje dijaloga
	
	public DlgPointModify() {
		setModal(true);
		setBounds(100, 100, 355, 233);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 178, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXcoord = new JLabel("X coordinate:");
			GridBagConstraints gbc_lblXcoord = new GridBagConstraints();
			gbc_lblXcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcoord.anchor = GridBagConstraints.EAST;
			gbc_lblXcoord.gridx = 1;
			gbc_lblXcoord.gridy = 1;
			contentPanel.add(lblXcoord, gbc_lblXcoord);
		}
		{
			txtXcoord = new JTextField();
			GridBagConstraints gbc_txtXcoord = new GridBagConstraints();
			gbc_txtXcoord.insets = new Insets(0, 0, 5, 0);
			gbc_txtXcoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXcoord.gridx = 2;
			gbc_txtXcoord.gridy = 1;
			contentPanel.add(txtXcoord, gbc_txtXcoord);
			txtXcoord.setColumns(10);
		}
		{
			JLabel lblYCoordinate = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
			gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinate.gridx = 1;
			gbc_lblYCoordinate.gridy = 2;
			contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
		}
		{
			txtYcoord = new JTextField();
			GridBagConstraints gbc_txtYcoord = new GridBagConstraints();
			gbc_txtYcoord.insets = new Insets(0, 0, 5, 0);
			gbc_txtYcoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYcoord.gridx = 2;
			gbc_txtYcoord.gridy = 2;
			contentPanel.add(txtYcoord, gbc_txtYcoord);
			txtYcoord.setColumns(10);
		}
		
		// lbl boja tacke
		
		{
			JLabel lblColorP = new JLabel("Color:");
			GridBagConstraints gbc_lblColorP = new GridBagConstraints();
			gbc_lblColorP.anchor = GridBagConstraints.EAST;
			gbc_lblColorP.insets = new Insets(0, 0, 0, 5);
			gbc_lblColorP.gridx = 1;
			gbc_lblColorP.gridy = 3;
			contentPanel.add(lblColorP, gbc_lblColorP);
			
		}
		
		// btn boja tacke 
		{
			
			btnColorP = new JButton("");
			btnColorP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Color c = JColorChooser.showDialog(null, "Select color", newColor);
					if (c != null) {
						newColor = c;
						btnColorP.setBackground(newColor);
					}
				}
			});
			btnColorP.setBackground(newColor);
			GridBagConstraints gbc_btnColorP = new GridBagConstraints();
			gbc_btnColorP.fill = GridBagConstraints.BOTH;
			gbc_btnColorP.gridx = 2;
			gbc_btnColorP.gridy = 3;
			contentPanel.add(btnColorP, gbc_btnColorP);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			// potvrdjivanje
			
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							xCoordP = Integer.parseInt(txtXcoord.getText());
							yCoordP = Integer.parseInt(txtYcoord.getText());
							if (xCoordP < 1 || yCoordP < 1) {
								JOptionPane.showMessageDialog(null, "Numbers must be positive");
							}
							else {
								setOption(1);
								dispose();
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "All fields must be filled with whole numbers");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			// odustajanje
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setOption(0);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	// metoda za podatke za izmenu tacke 
	
	public void dimensionsModify(int x, int y, Color newColor) {
		setxCoordP(x);
		txtXcoord.setText(Integer.toString(x));
		setyCoordP(y);
		txtYcoord.setText(Integer.toString(y));
		setNewColor(newColor);
		btnColorP.setBackground(newColor);
		
	}
	
	// geteri i seteri

	

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public int getxCoordP() {
		return xCoordP;
	}

	public void setxCoordP(int xCoordP) {
		this.xCoordP = xCoordP;
	}

	public int getyCoordP() {
		return yCoordP;
	}

	public void setyCoordP(int yCoordP) {
		this.yCoordP = yCoordP;
	}

	public Color getNewColor() {
		return newColor;
	}

	public void setNewColor(Color newColor) {
		this.newColor = newColor;
	}

	

}

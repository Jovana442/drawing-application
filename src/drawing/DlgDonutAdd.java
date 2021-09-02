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
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonutAdd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXdonut;
	private JTextField txtYdonut;
	private JTextField txtRadius;
	private JTextField txtInnerR;
	
	private int xCoordD;
	private int yCoordD;
	private int radiusD;
	private int innerR;
	
	private Color newColorB;
	private Color newColorI;
	private boolean colorBoolB;
	private boolean colorBoolI;
	
	private JButton btnBorder;
	private JButton btnInside;
	
	private int option = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonutAdd dialog = new DlgDonutAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// kreiranje dijaloga
	
	public DlgDonutAdd() {
		setModal(true);
		setBounds(100, 100, 373, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 172, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXdonut = new JLabel("X coordinate - center:");
			GridBagConstraints gbc_lblXdonut = new GridBagConstraints();
			gbc_lblXdonut.insets = new Insets(0, 0, 5, 5);
			gbc_lblXdonut.anchor = GridBagConstraints.EAST;
			gbc_lblXdonut.gridx = 1;
			gbc_lblXdonut.gridy = 1;
			contentPanel.add(lblXdonut, gbc_lblXdonut);
		}
		{
			txtXdonut = new JTextField();
			GridBagConstraints gbc_txtXdonut = new GridBagConstraints();
			gbc_txtXdonut.insets = new Insets(0, 0, 5, 0);
			gbc_txtXdonut.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXdonut.gridx = 2;
			gbc_txtXdonut.gridy = 1;
			contentPanel.add(txtXdonut, gbc_txtXdonut);
			txtXdonut.setColumns(10);
		}
		{
			JLabel lblYdonut = new JLabel("Y coordinate - center:");
			GridBagConstraints gbc_lblYdonut = new GridBagConstraints();
			gbc_lblYdonut.insets = new Insets(0, 0, 5, 5);
			gbc_lblYdonut.anchor = GridBagConstraints.EAST;
			gbc_lblYdonut.gridx = 1;
			gbc_lblYdonut.gridy = 2;
			contentPanel.add(lblYdonut, gbc_lblYdonut);
		}
		{
			txtYdonut = new JTextField();
			GridBagConstraints gbc_txtYdonut = new GridBagConstraints();
			gbc_txtYdonut.insets = new Insets(0, 0, 5, 0);
			gbc_txtYdonut.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYdonut.gridx = 2;
			gbc_txtYdonut.gridy = 2;
			contentPanel.add(txtYdonut, gbc_txtYdonut);
			txtYdonut.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 2;
			gbc_txtRadius.gridy = 3;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JLabel lblInnerR = new JLabel("Inner radius:");
			GridBagConstraints gbc_lblInnerR = new GridBagConstraints();
			gbc_lblInnerR.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerR.anchor = GridBagConstraints.EAST;
			gbc_lblInnerR.gridx = 1;
			gbc_lblInnerR.gridy = 4;
			contentPanel.add(lblInnerR, gbc_lblInnerR);
		}
		{
			txtInnerR = new JTextField();
			GridBagConstraints gbc_txtInnerR = new GridBagConstraints();
			gbc_txtInnerR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInnerR.insets = new Insets(0, 0, 5, 0);
			gbc_txtInnerR.gridx = 2;
			gbc_txtInnerR.gridy = 4;
			contentPanel.add(txtInnerR, gbc_txtInnerR);
			txtInnerR.setColumns(10);
		}
		
		// lbl boja ivica
		{
			JLabel lblBorderColor = new JLabel("Border color:");
			GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
			gbc_lblBorderColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblBorderColor.anchor = GridBagConstraints.EAST;
			gbc_lblBorderColor.gridx = 1;
			gbc_lblBorderColor.gridy = 5;
			contentPanel.add(lblBorderColor, gbc_lblBorderColor);
		}
		
		// btn boja ivica
		{
			btnBorder = new JButton("");
			btnBorder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color cB = JColorChooser.showDialog(null, "Select color", newColorB);
					if (cB != null) {
						newColorB = cB;
						btnBorder.setBackground(newColorB);
						colorBoolB = true;
					}
					
				}
			});
			btnBorder.setBackground(newColorB);
			GridBagConstraints gbc_btnBorder = new GridBagConstraints();
			gbc_btnBorder.fill = GridBagConstraints.BOTH;
			gbc_btnBorder.insets = new Insets(0, 0, 5, 0);
			gbc_btnBorder.gridx = 2;
			gbc_btnBorder.gridy = 5;
			contentPanel.add(btnBorder, gbc_btnBorder);
		}
		
		// lbl boja unutra
		
		{
			JLabel lblInsideColor = new JLabel("Inside color:");
			GridBagConstraints gbc_lblInsideColor = new GridBagConstraints();
			gbc_lblInsideColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInsideColor.anchor = GridBagConstraints.EAST;
			gbc_lblInsideColor.gridx = 1;
			gbc_lblInsideColor.gridy = 6;
			contentPanel.add(lblInsideColor, gbc_lblInsideColor);
		}
		
		// btn boja unutra
		
		{
			btnInside = new JButton("");
			btnInside.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color cI = JColorChooser.showDialog(null, "Select color", newColorI);
					if (cI != null) {
						newColorI = cI;
						btnInside.setBackground(newColorI);
						colorBoolI = true;
					}
					
				}
			});
			btnInside.setBackground(newColorI);
			GridBagConstraints gbc_btnInside = new GridBagConstraints();
			gbc_btnInside.fill = GridBagConstraints.BOTH;
			gbc_btnInside.gridx = 2;
			gbc_btnInside.gridy = 6;
			contentPanel.add(btnInside, gbc_btnInside);
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
							xCoordD = Integer.parseInt(txtXdonut.getText());
							yCoordD = Integer.parseInt(txtYdonut.getText());
							radiusD = Integer.parseInt(txtRadius.getText());
							innerR = Integer.parseInt(txtInnerR.getText());
							if (xCoordD < 1 || yCoordD < 1) {
								JOptionPane.showMessageDialog(null, "Numbers must be positive");
							}
							else if (innerR >= radiusD) {
								JOptionPane.showMessageDialog(null, "Inner radius must be smaller than radius");
							}
							else if (innerR < 2) {
								JOptionPane.showMessageDialog(null, "Inner radius must be longer than 2");
							}
							else {
								if (radiusD > innerR) {
									setOption(1);
									dispose();
								}
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
	
	// metoda za popunjavanje
	
		public void fillValues(int x, int y)  {
			setxCoordD(x);
			txtXdonut.setText(Integer.toString(x));
			txtXdonut.setEditable(false);
			setyCoordD(y);
			txtYdonut.setText(Integer.toString(y));
			txtYdonut.setEditable(false);
			
			
		}
		
	// metoda za podatke za izmenu
		
		public void dimensionsModify(int x, int y, int r, int innerR, Color newBorder, Color newInside) {
			setxCoordD(x);
			txtXdonut.setText(Integer.toString(x));
			setyCoordD(y);
			txtYdonut.setText(Integer.toString(y));
			setRadiusD(r);
			txtRadius.setText(Integer.toString(r));
			setInnerR(innerR);
			txtInnerR.setText(Integer.toString(innerR));
			setNewColorB(newBorder);
			btnBorder.setBackground(newBorder);
			setNewColorI(newInside);		
			btnInside.setBackground(newInside);
		}
		
	
	// geteri i seteri

	public int getxCoordD() {
		return xCoordD;
	}

	public void setxCoordD(int xCoordD) {
		this.xCoordD = xCoordD;
	}

	public int getyCoordD() {
		return yCoordD;
	}

	public void setyCoordD(int yCoordD) {
		this.yCoordD = yCoordD;
	}

	public int getRadiusD() {
		return radiusD;
	}

	public void setRadiusD(int radiusD) {
		this.radiusD = radiusD;
	}

	public int getInnerR() {
		return innerR;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public Color getNewColorB() {
		return newColorB;
	}

	public void setNewColorB(Color newColorB) {
		this.newColorB = newColorB;
	}

	public Color getNewColorI() {
		return newColorI;
	}

	public void setNewColorI(Color newColorI) {
		this.newColorI = newColorI;
	}

	public boolean isColorBoolB() {
		return colorBoolB;
	}

	public void setColorBoolB(boolean colorBoolB) {
		this.colorBoolB = colorBoolB;
	}

	public boolean isColorBoolI() {
		return colorBoolI;
	}

	public void setColorBoolI(boolean colorBoolI) {
		this.colorBoolI = colorBoolI;
	}


	
	
}

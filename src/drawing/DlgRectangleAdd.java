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

public class DlgRectangleAdd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXrec;
	private JTextField txtYrec;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JButton btnBorder;
	private JButton btnInside;
	
	private int xRec;
	private int yRec;
	private int widthRec;
	private int heightRec;
	
	private Color newColorB;
	private Color newColorI;
	private boolean colorBoolB;
	private boolean colorBoolI;
	
	


	private int option = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangleAdd dialog = new DlgRectangleAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// kreiranje dijaloga
	
	public DlgRectangleAdd() {
		setModal(true);
		setBounds(100, 100, 385, 287);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 215, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXrec = new JLabel("X coordinate:");
			GridBagConstraints gbc_lblXrec = new GridBagConstraints();
			gbc_lblXrec.anchor = GridBagConstraints.EAST;
			gbc_lblXrec.insets = new Insets(0, 0, 5, 5);
			gbc_lblXrec.gridx = 1;
			gbc_lblXrec.gridy = 1;
			contentPanel.add(lblXrec, gbc_lblXrec);
		}
		{
			txtXrec = new JTextField();
			GridBagConstraints gbc_txtXrec = new GridBagConstraints();
			gbc_txtXrec.insets = new Insets(0, 0, 5, 0);
			gbc_txtXrec.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXrec.gridx = 2;
			gbc_txtXrec.gridy = 1;
			contentPanel.add(txtXrec, gbc_txtXrec);
			txtXrec.setColumns(10);
		}
		{
			JLabel lblYrec = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblYrec = new GridBagConstraints();
			gbc_lblYrec.anchor = GridBagConstraints.EAST;
			gbc_lblYrec.insets = new Insets(0, 0, 5, 5);
			gbc_lblYrec.gridx = 1;
			gbc_lblYrec.gridy = 2;
			contentPanel.add(lblYrec, gbc_lblYrec);
		}
		{
			txtYrec = new JTextField();
			GridBagConstraints gbc_txtYrec = new GridBagConstraints();
			gbc_txtYrec.anchor = GridBagConstraints.NORTH;
			gbc_txtYrec.insets = new Insets(0, 0, 5, 0);
			gbc_txtYrec.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYrec.gridx = 2;
			gbc_txtYrec.gridy = 2;
			contentPanel.add(txtYrec, gbc_txtYrec);
			txtYrec.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtWidth = new JTextField();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.anchor = GridBagConstraints.NORTH;
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 2;
			gbc_txtWidth.gridy = 3;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 4;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			txtHeight = new JTextField();
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 2;
			gbc_txtHeight.gridy = 4;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
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
			btnBorder.setVisible(true);
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
			gbc_lblInsideColor.insets = new Insets(0, 0, 5, 5);
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
			gbc_btnInside.insets = new Insets(0, 0, 5, 0);
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
							xRec = Integer.parseInt(txtXrec.getText());
							yRec = Integer.parseInt(txtYrec.getText());
							widthRec = Integer.parseInt(txtWidth.getText());
							heightRec = Integer.parseInt(txtHeight.getText());
							if (xRec < 1 || yRec < 1 || widthRec < 1 || heightRec < 1 ) {
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
						setOption(1);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	// metoda popuni 
	
	public void fillValues(int x, int y) {
		setxRec(x);
		txtXrec.setText(Integer.toString(x));
		txtXrec.setEditable(false);
		setyRec(y);
		txtYrec.setText(Integer.toString(y));
		txtYrec.setEditable(false);
		
	}
	
	// metoda za podatke za izmenu
	
	public void dimensionsModify(int x, int y, int width, int height, Color newBorder, Color newInside) {
		setxRec(x);
		txtXrec.setText(Integer.toString(x));
		setyRec(y);
		txtYrec.setText(Integer.toString(y));
		setWidthRec(width);
		txtWidth.setText(Integer.toString(width));
		setHeightRec(height);
		txtHeight.setText(Integer.toString(height));
		setNewColorB(newBorder);
		btnBorder.setBackground(newBorder);
		setNewColorI(newInside);
		btnInside.setBackground(newInside);
	}
	
	// geteri i seteri

	public int getxRec() {
		return xRec;
	}

	public void setxRec(int xRec) {
		this.xRec = xRec;
	}

	public int getyRec() {
		return yRec;
	}

	public void setyRec(int yRec) {
		this.yRec = yRec;
	}

	public int getWidthRec() {
		return widthRec;
	}

	public void setWidthRec(int widthRec) {
		this.widthRec = widthRec;
	}

	public int getHeightRec() {
		return heightRec;
	}

	public void setHeightRec(int heightRec) {
		this.heightRec = heightRec;
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

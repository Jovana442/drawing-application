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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircleAdd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXcenter;
	private JTextField txtYcenter;
	private JTextField txtRadius;
	
	private int xCoordC;
	private int yCoordC;
	private int radiusC;
	
	private Color newColorB;
	private Color newColorI;
	private boolean colorBoolB;
	private boolean colorBoolI;
	
	private JButton btnCircleBorder;
	private JButton btnCircleInside;
	
	private int option = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircleAdd dialog = new DlgCircleAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// kreiranje dijaloga
	
	public DlgCircleAdd() {
		setModal(true);
		setBounds(100, 100, 392, 231);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 177, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXcenter = new JLabel("X coordinate - center:");
			GridBagConstraints gbc_lblXcenter = new GridBagConstraints();
			gbc_lblXcenter.anchor = GridBagConstraints.EAST;
			gbc_lblXcenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcenter.gridx = 1;
			gbc_lblXcenter.gridy = 1;
			contentPanel.add(lblXcenter, gbc_lblXcenter);
		}
		{
			txtXcenter = new JTextField();
			txtXcenter.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_txtXcenter = new GridBagConstraints();
			gbc_txtXcenter.anchor = GridBagConstraints.NORTH;
			gbc_txtXcenter.insets = new Insets(0, 0, 5, 0);
			gbc_txtXcenter.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXcenter.gridx = 2;
			gbc_txtXcenter.gridy = 1;
			contentPanel.add(txtXcenter, gbc_txtXcenter);
			txtXcenter.setColumns(10);
		}
		{
			JLabel lblYcenter = new JLabel("Y coordinate - center:");
			GridBagConstraints gbc_lblYcenter = new GridBagConstraints();
			gbc_lblYcenter.anchor = GridBagConstraints.EAST;
			gbc_lblYcenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcenter.gridx = 1;
			gbc_lblYcenter.gridy = 2;
			contentPanel.add(lblYcenter, gbc_lblYcenter);
		}
		{
			txtYcenter = new JTextField();
			GridBagConstraints gbc_txtYcenter = new GridBagConstraints();
			gbc_txtYcenter.insets = new Insets(0, 0, 5, 0);
			gbc_txtYcenter.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYcenter.gridx = 2;
			gbc_txtYcenter.gridy = 2;
			contentPanel.add(txtYcenter, gbc_txtYcenter);
			txtYcenter.setColumns(10);
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
		
		//lbl boja ivice
		
		{
			JLabel lblBorderColor = new JLabel("Border color:");
			GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
			gbc_lblBorderColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblBorderColor.anchor = GridBagConstraints.EAST;
			gbc_lblBorderColor.gridx = 1;
			gbc_lblBorderColor.gridy = 4;
			contentPanel.add(lblBorderColor, gbc_lblBorderColor);
		}
		
		// btn boja ivice
		
		{
			btnCircleBorder = new JButton("");
			btnCircleBorder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color cB = JColorChooser.showDialog(null, "Select color", newColorB);
					if (cB != null) {
						newColorB = cB;
						btnCircleBorder.setBackground(newColorB);
						colorBoolB = true;
					}
					
				}
			});
			btnCircleBorder.setBackground(newColorB);
			GridBagConstraints gbc_btnCircleBorder = new GridBagConstraints();
			gbc_btnCircleBorder.fill = GridBagConstraints.BOTH;
			gbc_btnCircleBorder.insets = new Insets(0, 0, 5, 0);
			gbc_btnCircleBorder.gridx = 2;
			gbc_btnCircleBorder.gridy = 4;
			contentPanel.add(btnCircleBorder, gbc_btnCircleBorder);
		}
		
		//lbl boja unutra
		
		{
			JLabel lblInsideColor = new JLabel("Inside color:");
			GridBagConstraints gbc_lblInsideColor = new GridBagConstraints();
			gbc_lblInsideColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInsideColor.anchor = GridBagConstraints.EAST;
			gbc_lblInsideColor.gridx = 1;
			gbc_lblInsideColor.gridy = 5;
			contentPanel.add(lblInsideColor, gbc_lblInsideColor);
		}
		
		// btn boja unutra
		
		{
			btnCircleInside = new JButton("");
			btnCircleInside.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color cI = JColorChooser.showDialog(null, "Select color", newColorI);
					if (cI != null) {
						newColorI = cI;
						btnCircleInside.setBackground(newColorI);
						colorBoolI = true;
					}
					
					
				}
			});
			btnCircleInside.setBackground(newColorI);
			GridBagConstraints gbc_btnCircleInside = new GridBagConstraints();
			gbc_btnCircleInside.fill = GridBagConstraints.BOTH;
			gbc_btnCircleInside.gridx = 2;
			gbc_btnCircleInside.gridy = 5;
			contentPanel.add(btnCircleInside, gbc_btnCircleInside);
		}
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			// Potvrdjivanje 
			
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							xCoordC = Integer.parseInt(txtXcenter.getText());
							yCoordC = Integer.parseInt(txtYcenter.getText());
							radiusC = Integer.parseInt(txtRadius.getText());
							
							if (xCoordC <1 || yCoordC < 1) {
								JOptionPane.showMessageDialog(null, "Numbers must be positive");
							}
							else if (radiusC < 3) {
								JOptionPane.showMessageDialog(null, "Radius must be longer than 3");
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
			
			// Odustajanje 
			
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
		setxCoordC(x);
		txtXcenter.setText(Integer.toString(x));
		txtXcenter.setEditable(false);
		setyCoordC(y);
		txtYcenter.setText(Integer.toString(y));
		txtYcenter.setEditable(false);
		
	}
	
	// metoda za podatke za izmenu
	
	public void dimensionsModify(int x, int y, int r, Color newBorder, Color newInside ) {
		setxCoordC(x);
		txtXcenter.setText(Integer.toString(x));
		setyCoordC(y);
		txtYcenter.setText(Integer.toString(y));
		setRadiusC(r);
		txtRadius.setText(Integer.toString(r));
		setNewColorB(newBorder);
		btnCircleBorder.setBackground(newBorder);
		setNewColorI(newInside);
		btnCircleInside.setBackground(newInside);
	}
			
	
	// Geteri i seteri

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public int getxCoordC() {
		return xCoordC;
	}

	public void setxCoordC(int xCoordC) {
		this.xCoordC = xCoordC;
	}

	public int getyCoordC() {
		return yCoordC;
	}

	public void setyCoordC(int yCoordC) {
		this.yCoordC = yCoordC;
	}

	public int getRadiusC() {
		return radiusC;
	}

	public void setRadiusC(int radiusC) {
		this.radiusC = radiusC;
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

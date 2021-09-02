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

public class DlgLineModify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXstart;
	private JTextField txtYstart;
	private JTextField txtXend;
	private JTextField txtYend;
	
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	
	private Color newColor;
	private JButton btnColorL;
	
	private int option = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLineModify dialog = new DlgLineModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// kreiranje dijaloga
	
	public DlgLineModify() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 181, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXstart = new JLabel("X coordinate - start point:");
			GridBagConstraints gbc_lblXstart = new GridBagConstraints();
			gbc_lblXstart.insets = new Insets(0, 0, 5, 5);
			gbc_lblXstart.anchor = GridBagConstraints.EAST;
			gbc_lblXstart.gridx = 1;
			gbc_lblXstart.gridy = 1;
			contentPanel.add(lblXstart, gbc_lblXstart);
		}
		{
			txtXstart = new JTextField();
			GridBagConstraints gbc_txtXstart = new GridBagConstraints();
			gbc_txtXstart.insets = new Insets(0, 0, 5, 0);
			gbc_txtXstart.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXstart.gridx = 2;
			gbc_txtXstart.gridy = 1;
			contentPanel.add(txtXstart, gbc_txtXstart);
			txtXstart.setColumns(10);
		}
		{
			JLabel lblYstart = new JLabel("Y coordinate - start point:");
			GridBagConstraints gbc_lblYstart = new GridBagConstraints();
			gbc_lblYstart.insets = new Insets(0, 0, 5, 5);
			gbc_lblYstart.anchor = GridBagConstraints.EAST;
			gbc_lblYstart.gridx = 1;
			gbc_lblYstart.gridy = 2;
			contentPanel.add(lblYstart, gbc_lblYstart);
		}
		{
			txtYstart = new JTextField();
			GridBagConstraints gbc_txtYstart = new GridBagConstraints();
			gbc_txtYstart.insets = new Insets(0, 0, 5, 0);
			gbc_txtYstart.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYstart.gridx = 2;
			gbc_txtYstart.gridy = 2;
			contentPanel.add(txtYstart, gbc_txtYstart);
			txtYstart.setColumns(10);
		}
		{
			JLabel lblXend = new JLabel("X coordinate - end point:");
			GridBagConstraints gbc_lblXend = new GridBagConstraints();
			gbc_lblXend.insets = new Insets(0, 0, 5, 5);
			gbc_lblXend.anchor = GridBagConstraints.EAST;
			gbc_lblXend.gridx = 1;
			gbc_lblXend.gridy = 3;
			contentPanel.add(lblXend, gbc_lblXend);
		}
		{
			txtXend = new JTextField();
			GridBagConstraints gbc_txtXend = new GridBagConstraints();
			gbc_txtXend.anchor = GridBagConstraints.NORTH;
			gbc_txtXend.insets = new Insets(0, 0, 5, 0);
			gbc_txtXend.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXend.gridx = 2;
			gbc_txtXend.gridy = 3;
			contentPanel.add(txtXend, gbc_txtXend);
			txtXend.setColumns(10);
		}
		{
			JLabel lblYend = new JLabel("Y coordinate - end point:");
			GridBagConstraints gbc_lblYend = new GridBagConstraints();
			gbc_lblYend.insets = new Insets(0, 0, 5, 5);
			gbc_lblYend.anchor = GridBagConstraints.EAST;
			gbc_lblYend.gridx = 1;
			gbc_lblYend.gridy = 4;
			contentPanel.add(lblYend, gbc_lblYend);
		}
		{
			txtYend = new JTextField();
			GridBagConstraints gbc_txtYend = new GridBagConstraints();
			gbc_txtYend.insets = new Insets(0, 0, 5, 0);
			gbc_txtYend.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYend.gridx = 2;
			gbc_txtYend.gridy = 4;
			contentPanel.add(txtYend, gbc_txtYend);
			txtYend.setColumns(10);
		}
		{
			JLabel lblColorL = new JLabel("Color:");
			GridBagConstraints gbc_lblColorL = new GridBagConstraints();
			gbc_lblColorL.anchor = GridBagConstraints.EAST;
			gbc_lblColorL.insets = new Insets(0, 0, 0, 5);
			gbc_lblColorL.gridx = 1;
			gbc_lblColorL.gridy = 5;
			contentPanel.add(lblColorL, gbc_lblColorL);
		}
		
		// btn boja linija izmena
		
		{
			btnColorL = new JButton("");
			btnColorL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color c = JColorChooser.showDialog(null, "Select color", newColor);
					if (c != null) {
						newColor = c;
						btnColorL.setBackground(newColor);
					}
				}
			});
			btnColorL.setBackground(newColor);
			GridBagConstraints gbc_btnColorL = new GridBagConstraints();
			gbc_btnColorL.fill = GridBagConstraints.BOTH;
			gbc_btnColorL.gridx = 2;
			gbc_btnColorL.gridy = 5;
			contentPanel.add(btnColorL, gbc_btnColorL);
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
							xStart = Integer.parseInt(txtXstart.getText());
							yStart = Integer.parseInt(txtYstart.getText());
							xEnd = Integer.parseInt(txtXend.getText());
							yEnd = Integer.parseInt(txtYend.getText());
							if (xStart < 1 || yStart < 1 || xEnd < 1 || yEnd < 1) {
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
	
		public void dimensionsModify(int xs, int ys, int xe, int ye, Color newColor) {
			setxStart(xs);
			txtXstart.setText(Integer.toString(xs));
			setyStart(ys);
			txtYstart.setText(Integer.toString(ys));
			setxEnd(xe);
			txtXend.setText(Integer.toString(xe));
			setyEnd(ye);
			txtYend.setText(Integer.toString(ye));
			setNewColor(newColor);
			btnColorL.setBackground(newColor);
		} 
	
	// geteri i seteri

	public int getxStart() {
		return xStart;
	}

	public void setxStart(int xStart) {
		this.xStart = xStart;
	}

	public int getyStart() {
		return yStart;
	}

	public void setyStart(int yStart) {
		this.yStart = yStart;
	}

	public int getxEnd() {
		return xEnd;
	}

	public void setxEnd(int xEnd) {
		this.xEnd = xEnd;
	}

	public int getyEnd() {
		return yEnd;
	}

	public void setyEnd(int yEnd) {
		this.yEnd = yEnd;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public Color getNewColor() {
		return newColor;
	}

	public void setNewColor(Color newColor) {
		this.newColor = newColor;
	}
	
	

	
}

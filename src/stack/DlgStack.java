package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgStack extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXcoord;
	private JTextField txtYcoord;
	private JTextField txtWidth;
	private JTextField txtHeight;
	
	private int xCoord;
	private int yCoord;
	private int widthN;
	private int heightN;
	
	
	private int option = 0;
	private Rectangle rec = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStack dialogue = new DlgStack();
			dialogue.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialogue.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Kreiranje dijaloga
	
	public DlgStack() {
		setModal(true);
		setTitle("Rectangle");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbc_txtXcoord.anchor = GridBagConstraints.EAST;
			gbc_txtXcoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXcoord.gridx = 2;
			gbc_txtXcoord.gridy = 1;
			contentPanel.add(txtXcoord, gbc_txtXcoord);
			txtXcoord.setColumns(10);
		}
		{
			JLabel lblYcoord = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblYcoord = new GridBagConstraints();
			gbc_lblYcoord.anchor = GridBagConstraints.EAST;
			gbc_lblYcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcoord.gridx = 1;
			gbc_lblYcoord.gridy = 2;
			contentPanel.add(lblYcoord, gbc_lblYcoord);
		}
		{
			txtYcoord = new JTextField();
			GridBagConstraints gbc_txtYcoord = new GridBagConstraints();
			gbc_txtYcoord.insets = new Insets(0, 0, 5, 0);
			gbc_txtYcoord.anchor = GridBagConstraints.EAST;
			gbc_txtYcoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYcoord.gridx = 2;
			gbc_txtYcoord.gridy = 2;
			contentPanel.add(txtYcoord, gbc_txtYcoord);
			txtYcoord.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtWidth = new JTextField();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.anchor = GridBagConstraints.EAST;
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 2;
			gbc_txtWidth.gridy = 3;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 4;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			txtHeight = new JTextField();
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.anchor = GridBagConstraints.EAST;
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 2;
			gbc_txtHeight.gridy = 4;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
		}
		
		// Potvrdjivanje
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							xCoord = Integer.parseInt(txtXcoord.getText());
							yCoord = Integer.parseInt(txtYcoord.getText());
							widthN = Integer.parseInt(txtWidth.getText());
							heightN = Integer.parseInt(txtHeight.getText());
							if (xCoord < 1 || yCoord < 1 || widthN < 1 || heightN < 1) {
								JOptionPane.showMessageDialog(null, "Numbers must be positive");
							}
							else {
								rec = new Rectangle(new Point(xCoord, yCoord), widthN, heightN);
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
	
	// metoda za podatke za brisanje pravougaonika
	
	public void dimensionsDelete(int xCoord, int yCoord, int widthN, int heightN) {
		setTitle("Deleting the rectangle: ");
		txtXcoord.setText(Integer.toString(xCoord));
		txtXcoord.setEditable(false);
		txtYcoord.setText(Integer.toString(yCoord));
		txtYcoord.setEditable(false);
		txtWidth.setText(Integer.toString(widthN));
		txtWidth.setEditable(false);
		txtHeight.setText(Integer.toString(heightN));
		txtHeight.setEditable(false);
	}
	
	// geteri i seteri

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}
	

	

}

package drawing;


import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import java.awt.GridBagLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FrmDrawing extends JFrame{

	private JPanel contentPane;
	private PnlDrawing pnlDrawing;
	private Color chosenBorder = Color.BLACK;
	private Color chosenInside = Color.WHITE;
	private JToggleButton myButton;
	private boolean pressed = false;
	private Shape selected = null;
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	private ArrayList<Shape> createdShapes = new ArrayList<Shape>();
	private Point firstPointLine;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Kreiranje frejma
	
	public FrmDrawing() {
		setBackground(new Color(255, 218, 185));
		setTitle("Draw something nice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);;
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{90, 80, 80, 80, 80, 81, 47, 93, 0};
		gbl_contentPane.rowHeights = new int[]{23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		// Point btn
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myButton = tglbtnPoint;
			}
		});
		
		JLabel lblChoose = new JLabel("Choose shape:");
		GridBagConstraints gbc_lblChoose = new GridBagConstraints();
		gbc_lblChoose.fill = GridBagConstraints.BOTH;
		gbc_lblChoose.insets = new Insets(0, 0, 5, 5);
		gbc_lblChoose.gridx = 0;
		gbc_lblChoose.gridy = 0;
		contentPane.add(lblChoose, gbc_lblChoose);
		buttonGroup.add(tglbtnPoint);
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnPoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPoint.gridx = 1;
		gbc_tglbtnPoint.gridy = 0;
		contentPane.add(tglbtnPoint, gbc_tglbtnPoint);
		
		// Circle btn
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unselect();
				myButton = tglbtnCircle;
			}
		});
		
		// Line btn
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				unselect();
				myButton = tglbtnLine;
			}
		});
		buttonGroup.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnLine.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLine.gridx = 2;
		gbc_tglbtnLine.gridy = 0;
		contentPane.add(tglbtnLine, gbc_tglbtnLine);
		buttonGroup.add(tglbtnCircle);
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnCircle.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCircle.gridx = 3;
		gbc_tglbtnCircle.gridy = 0;
		contentPane.add(tglbtnCircle, gbc_tglbtnCircle);
		
		// Donut btn
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unselect();
				myButton = tglbtnDonut;
			}
		});
		buttonGroup.add(tglbtnDonut);
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnDonut.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnDonut.gridx = 4;
		gbc_tglbtnDonut.gridy = 0;
		contentPane.add(tglbtnDonut, gbc_tglbtnDonut);
		
		// Rectangle btn
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unselect();
				myButton = tglbtnRectangle;
			}
		});
		buttonGroup.add(tglbtnRectangle);
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.anchor = GridBagConstraints.NORTHWEST;
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnRectangle.gridx = 5;
		gbc_tglbtnRectangle.gridy = 0;
		contentPane.add(tglbtnRectangle, gbc_tglbtnRectangle);
		
		// select btn
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (createdShapes.isEmpty()) {
					JOptionPane.showMessageDialog(null, "There are no shapes to select");
				}
				else if (selected != null) {
					unselect();
					myButton = null;
				}

				else {
					myButton = tglbtnSelect;
				}
			}
		});
		buttonGroup.add(tglbtnSelect);
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelect.gridx = 7;
		gbc_tglbtnSelect.gridy = 1;
		contentPane.add(tglbtnSelect, gbc_tglbtnSelect);
		
		// mouse listener za panel
		
		pnlDrawing = new PnlDrawing();
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (myButton == tglbtnPoint) {
						unselect();
						Point tempPoint = new Point(arg0.getX(), arg0.getY());
						tempPoint.setBorder(chosenBorder);
						pnlDrawing.getShapes().add(tempPoint);
						createdShapes.add(0, tempPoint);

				}
				
				else if (myButton == tglbtnLine) {
					if (pressed == false) {
						firstPointLine = new Point(arg0.getX(), arg0.getY());
						pressed = true; 
					}
					else {
						Point secondPointLine = new Point(arg0.getX(), arg0.getY());
						Line tempLine = new Line(firstPointLine, secondPointLine);
						tempLine.setBorder(chosenBorder);
						pnlDrawing.getShapes().add(tempLine);
						pressed = false; 
						createdShapes.add(0, tempLine);
						firstPointLine = null; 
					}
				}
				
				else if (myButton == tglbtnCircle) {
					DlgCircleAdd dlgCircle = new DlgCircleAdd();
					dlgCircle.setTitle("Add circle");
					dlgCircle.fillValues(arg0.getX(), arg0.getY());
					dlgCircle.setVisible(true);
					if (dlgCircle.getOption() == 1) {
						Circle tempCircle = new Circle(new Point(dlgCircle.getxCoordC(), dlgCircle.getyCoordC()), dlgCircle.getRadiusC());
						if (dlgCircle.isColorBoolB()) {
							tempCircle.setBorder(dlgCircle.getNewColorB());
						}
						else {
							tempCircle.setBorder(chosenBorder);
						}
						if (dlgCircle.isColorBoolI()) {
							tempCircle.setInside(dlgCircle.getNewColorI());
						}
						else {
							tempCircle.setInside(chosenInside);
						}
						pnlDrawing.getShapes().add(tempCircle);
						createdShapes.add(0, tempCircle);
					}

				}
				
				else if (myButton == tglbtnDonut) {
					DlgDonutAdd dlgDonut = new DlgDonutAdd();
					dlgDonut.setTitle("Add donut");
					dlgDonut.fillValues(arg0.getX(), arg0.getY());
					dlgDonut.setVisible(true);
					if (dlgDonut.getOption() == 1) {
						Donut tempDonut = new Donut(new Point(dlgDonut.getxCoordD(), dlgDonut.getyCoordD()), dlgDonut.getRadiusD(), dlgDonut.getInnerR());
						if (dlgDonut.isColorBoolB()) {
							tempDonut.setBorder(dlgDonut.getNewColorB());
						}
						else {
							tempDonut.setBorder(chosenBorder);
						}
						if (dlgDonut.isColorBoolI()) {
							tempDonut.setInside(dlgDonut.getNewColorI());
						}
						else {
							tempDonut.setInside(chosenInside);
						}
						pnlDrawing.getShapes().add(tempDonut);
						createdShapes.add(0, tempDonut);
					}
				}
				
				else if (myButton == tglbtnRectangle) {
					
					DlgRectangleAdd dlgRectangle = new DlgRectangleAdd();
					dlgRectangle.setTitle("Add rectangle");
					dlgRectangle.fillValues(arg0.getX(), arg0.getY());
					dlgRectangle.setVisible(true);
					if (dlgRectangle.getOption() == 1) {
						Rectangle tempRec = new Rectangle(new Point(dlgRectangle.getxRec(), dlgRectangle.getyRec()), dlgRectangle.getWidthRec(), dlgRectangle.getHeightRec());
						if (dlgRectangle.isColorBoolB()) {
							tempRec.setBorder(dlgRectangle.getNewColorB());
						}
						else {
							tempRec.setBorder(chosenBorder);
						}
						if (dlgRectangle.isColorBoolI()) {
							tempRec.setInside(dlgRectangle.getNewColorI());
						}
						else {
							tempRec.setInside(chosenInside);
						}
						pnlDrawing.getShapes().add(tempRec);
						createdShapes.add(0, tempRec);
					}
				}
				
				else if (myButton == tglbtnSelect) {
					Iterator<Shape> it = createdShapes.iterator();
					while(it.hasNext()) {
						Shape shape = it.next();
						if (shape.contains(arg0.getX(), arg0.getY())) {
							if (selected != null) { 
								selected.setSelected(false);
								selected = null;
							}
							shape.setSelected(true);
							selected = shape;
							break;
						}
					}
				}
			}
		});
		
		pnlDrawing.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) pnlDrawing.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_pnlDrawing = new GridBagConstraints();
		gbc_pnlDrawing.fill = GridBagConstraints.BOTH;
		gbc_pnlDrawing.insets = new Insets(0, 0, 0, 5);
		gbc_pnlDrawing.gridheight = 9;
		gbc_pnlDrawing.gridwidth = 5;
		gbc_pnlDrawing.gridx = 0;
		gbc_pnlDrawing.gridy = 1;
		contentPane.add(pnlDrawing, gbc_pnlDrawing);
		
		
		// modifikacija btn
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected != null) {
					
					if (selected instanceof Point) {
						DlgPointModify dialogue = new DlgPointModify();
						dialogue.setTitle("Point modification");
						
						Point tempPoint = (Point) selected;
						dialogue.dimensionsModify(tempPoint.getX(), tempPoint.getY(), tempPoint.getBorder());
						dialogue.setVisible(true);
						if (dialogue.getOption() == 1) {
							tempPoint.moveTo(dialogue.getxCoordP(), dialogue.getyCoordP());
							tempPoint.setBorder(dialogue.getNewColor());
						}
					}
					else if (selected instanceof Donut) {
						DlgDonutAdd dialogue = new DlgDonutAdd();
						dialogue.setTitle("Donut modification");
						
						Donut tempDonut = (Donut) selected;
						dialogue.dimensionsModify(tempDonut.getCenter().getX(), tempDonut.getCenter().getY(), tempDonut.getR(), tempDonut.getInnerR(), tempDonut.getBorder(), tempDonut.getInside());
						dialogue.setVisible(true);
						if (dialogue.getOption() == 1) {
							tempDonut.moveTo(dialogue.getxCoordD(), dialogue.getyCoordD());
							tempDonut.setR(dialogue.getRadiusD());
							tempDonut.setInnerR(dialogue.getInnerR());
							if (dialogue.isColorBoolB()) {
								tempDonut.setBorder(dialogue.getNewColorB());
							}
							if (dialogue.isColorBoolI()) {
								tempDonut.setInside(dialogue.getNewColorI());
							}
						}
					}
					else if (selected instanceof Circle) {
						DlgCircleAdd dialogue = new DlgCircleAdd();
						dialogue.setTitle("Circle modification");
						
						Circle tempCircle = (Circle) selected;
						dialogue.dimensionsModify(tempCircle.getCenter().getX(), tempCircle.getCenter().getY(), tempCircle.getR(), tempCircle.getBorder(), tempCircle.getInside());
						dialogue.setVisible(true);
						if (dialogue.getOption() == 1) {
							tempCircle.moveTo(dialogue.getxCoordC(), dialogue.getyCoordC());
							tempCircle.setR(dialogue.getRadiusC());
							if (dialogue.isColorBoolB()) {
								tempCircle.setBorder(dialogue.getNewColorB());
							}
							if (dialogue.isColorBoolI()) {
								tempCircle.setInside(dialogue.getNewColorI());
							}
							}
					}
					
					
					else if (selected instanceof Rectangle) {
						DlgRectangleAdd dialogue = new DlgRectangleAdd();
						dialogue.setTitle("Rectangle modification");
						
						Rectangle tempRec = (Rectangle) selected;
						dialogue.dimensionsModify(tempRec.getUpperLeft().getX(), tempRec.getUpperLeft().getY(), tempRec.getWidth(), tempRec.getHeight(), tempRec.getBorder(), tempRec.getInside());
						dialogue.setVisible(true);
						if (dialogue.getOption() == 1) {
							tempRec.moveTo(dialogue.getxRec(), dialogue.getyRec());
							tempRec.setWidth(dialogue.getWidthRec());
							tempRec.setHeight(dialogue.getHeightRec());
							if (dialogue.isColorBoolB()) {
								tempRec.setBorder(dialogue.getNewColorB());
							}
							if (dialogue.isColorBoolI()) {
								tempRec.setInside(dialogue.getNewColorI());
							}
							
						}
					}
					
					else if (selected instanceof Line) {
						DlgLineModify dialogue = new DlgLineModify();
						dialogue.setTitle("Line modification");
						
						Line tempLine = (Line) selected;
						dialogue.dimensionsModify(tempLine.getStartPoint().getX(), tempLine.getStartPoint().getY(), tempLine.getEndPoint().getX(), tempLine.getEndPoint().getY(), tempLine.getBorder());
						dialogue.setVisible(true);
						if (dialogue.getOption() == 1) {
							tempLine.getStartPoint().setX(dialogue.getxStart());
							tempLine.getStartPoint().setY(dialogue.getyStart());
							tempLine.getEndPoint().setX(dialogue.getxEnd());
							tempLine.getEndPoint().setY(dialogue.getyEnd());
							tempLine.setBorder(dialogue.getNewColor());
						}
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "A shape must be selected"); 
					
				}
			}
		});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.anchor = GridBagConstraints.NORTH;
		gbc_btnModify.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModify.insets = new Insets(0, 0, 5, 0);
		gbc_btnModify.gridx = 7;
		gbc_btnModify.gridy = 2;
		contentPane.add(btnModify, gbc_btnModify);
		
		// boja ivice lbl
		
		JLabel lblBorderColor = new JLabel("Border color");
		GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
		gbc_lblBorderColor.anchor = GridBagConstraints.NORTH;
		gbc_lblBorderColor.insets = new Insets(0, 0, 5, 0);
		gbc_lblBorderColor.gridx = 7;
		gbc_lblBorderColor.gridy = 3;
		contentPane.add(lblBorderColor, gbc_lblBorderColor);
		
		//  btn boja ivice 
		
		JButton btnBorderColor = new JButton("Border color");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Select color:", Color.BLACK);
				if (color != null) {
					chosenBorder = color;
					btnBorderColor.setBackground(chosenBorder);
				}
			}
		});
		btnBorderColor.setBackground(chosenBorder);
		
		
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBorderColor.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBorderColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorderColor.gridx = 7;
		gbc_btnBorderColor.gridy = 4;
		contentPane.add(btnBorderColor, gbc_btnBorderColor);
		
		// boja unutrasnjosti lbl
		
		JLabel lblInsideColor = new JLabel("Inside color");
		GridBagConstraints gbc_lblInsideColor = new GridBagConstraints();
		gbc_lblInsideColor.fill = GridBagConstraints.VERTICAL;
		gbc_lblInsideColor.insets = new Insets(0, 0, 5, 0);
		gbc_lblInsideColor.gridx = 7;
		gbc_lblInsideColor.gridy = 5;
		contentPane.add(lblInsideColor, gbc_lblInsideColor);
		
		// btn boja unutrasnjosti 
		
		JButton btnInsideColor = new JButton("Inside color");
		btnInsideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color colorIn = JColorChooser.showDialog(null, "Select color:", Color.WHITE);
				if (colorIn != null) {
					chosenInside = colorIn;
					btnInsideColor.setBackground(chosenInside);
				}
			}
		});
		btnInsideColor.setBackground(chosenInside);
		
		
		GridBagConstraints gbc_btnInsideColor = new GridBagConstraints();
		gbc_btnInsideColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsideColor.anchor = GridBagConstraints.NORTH;
		gbc_btnInsideColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsideColor.gridx = 7;
		gbc_btnInsideColor.gridy = 6;
		contentPane.add(btnInsideColor, gbc_btnInsideColor);
		
		// btn brisanje
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDelete dialogue = new DlgDelete();
				if (selected != null) {
					dialogue.setVisible(true);
					if (dialogue.getOption() == 1) {
						createdShapes.remove(selected);
						pnlDrawing.getShapes().remove(selected);
						unselect();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Select the shape that you want do delete");
				}
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.NORTH;
		gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 7;
		gbc_btnDelete.gridy = 8;
		contentPane.add(btnDelete, gbc_btnDelete);
		
	
				
	}
	
	// metode
	
	private void unselect() {
		if (selected != null) {
			selected.setSelected(false);
			selected = null;
		}
	}
	
	// geteri i seteri

	public Shape getSelected() {
		return selected;
	}
	
	public void setSelected(Shape selected) {
		this.selected = selected;
	}

	public ArrayList<Shape> getCreatedShapes() {
		return createdShapes;
	}

	public void setCreatedShapes(ArrayList<Shape> createdShapes) {
		this.createdShapes = createdShapes;
	}

	public Color getChosenBorder() {
		return chosenBorder;
	}

	public void setChosenBorder(Color chosenBorder) {
		this.chosenBorder = chosenBorder;
	}

	public Color getChosenInside() {
		return chosenInside;
	}

	public void setChosenInside(Color chosenInside) {
		this.chosenInside = chosenInside;
	}
	

}

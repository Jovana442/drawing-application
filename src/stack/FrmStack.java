package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlmStack = new DefaultListModel<Rectangle>();
	private Stack<Rectangle> stek = new Stack<Rectangle> ();
	Rectangle rec = new Rectangle();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// kreiranje frejma
	
	public FrmStack() {
		setBackground(new Color(255, 218, 185));
		setTitle("Malic Jovana IM 40-2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlMain = new JPanel();
		contentPane.add(pnlMain, BorderLayout.CENTER);
		
		JScrollPane sPaneStack = new JScrollPane();
		
		// Dodavanje
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgStack dialogue = new DlgStack();
				dialogue.setVisible(true);
				if (dialogue.getOption() == 1) {
					rec = dialogue.getRec();
					stek.push(rec);
					display();
				}
			}
		});
		
		
		// brisanje
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stek.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No rectangles to delete");
				}
				else {
					DlgStack stack = new DlgStack();
					stack.dimensionsDelete(stek.peek().getUpperLeft().getX(), stek.peek().getUpperLeft().getY(), stek.peek().getWidth(), stek.peek().getHeight());
					stack.setVisible(true);
					if (stack.getOption() == 1) {
						stek.pop();
						display();
					}
				}
			}
		});
		GroupLayout gl_pnlMain = new GroupLayout(pnlMain);
		gl_pnlMain.setHorizontalGroup(
			gl_pnlMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnlMain.createSequentialGroup()
					.addGap(59)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
					.addComponent(btnRemove)
					.addGap(73))
				.addGroup(Alignment.LEADING, gl_pnlMain.createSequentialGroup()
					.addComponent(sPaneStack, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlMain.setVerticalGroup(
			gl_pnlMain.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlMain.createSequentialGroup()
					.addComponent(sPaneStack, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_pnlMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(33))
		);
		
		JList<Rectangle> list = new JList<Rectangle>();
		sPaneStack.setViewportView(list);
		pnlMain.setLayout(gl_pnlMain);
		list.setModel(dlmStack);
	}
	
	// metoda za ispis pravougaonika
	
	private void display() {
		Iterator<Rectangle> it = stek.iterator();
		dlmStack.removeAllElements();
		while(it.hasNext()) 
			dlmStack.add(0, it.next());	}
}

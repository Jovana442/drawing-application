package sort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;
import stack.DlgStack;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	
	private DefaultListModel<Rectangle> dlmSort = new DefaultListModel<Rectangle>();
	private ArrayList<Rectangle> list = new ArrayList<Rectangle>();
	Rectangle rec = new Rectangle();


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//kreiranje frejma
	
	public FrmSort() {
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
		
		JScrollPane sPaneSort = new JScrollPane();
		
		// Dodavanje
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgStack dialogue = new DlgStack();
				dialogue.setVisible(true);
				if (dialogue.getOption() == 1) {
					rec = dialogue.getRec();
					list.add(rec);
					Collections.sort(list);
					display();
			}
		}}
		);
		
		// Brisanje
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No rectangles to delete");
				}
				else {
					DlgStack dialogue = new DlgStack();
					
					dialogue.dimensionsDelete(list.get(list.size() - 1).getUpperLeft().getX(), list.get(list.size() - 1).getUpperLeft().getY(), list.get(list.size() - 1).getWidth(), list.get(list.size() - 1).getHeight());
					dialogue.setVisible(true);
					if (dialogue.getOption() == 1) {
						list.remove(list.size()-1);
						display();
					}
				}
			}
		});
		
		
		GroupLayout gl_pnlMain = new GroupLayout(pnlMain);
		gl_pnlMain.setHorizontalGroup(
			gl_pnlMain.createParallelGroup(Alignment.LEADING)
				.addComponent(sPaneSort, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_pnlMain.createSequentialGroup()
					.addGap(60)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(146)
					.addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(66))
		);
		gl_pnlMain.setVerticalGroup(
			gl_pnlMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMain.createSequentialGroup()
					.addComponent(sPaneSort, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pnlMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		JList<Rectangle> listSort = new JList<Rectangle>();
		sPaneSort.setViewportView(listSort);
		pnlMain.setLayout(gl_pnlMain);
		listSort.setModel(dlmSort);
	}
	
	// metoda za ispis pravougaonika
	
	private void display() {
		Iterator<Rectangle> iterSort = list.iterator();
		dlmSort.removeAllElements();
		while(iterSort.hasNext()) 
			dlmSort.add(0, iterSort.next());	}
}

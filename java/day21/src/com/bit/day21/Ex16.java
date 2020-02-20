package com.bit.day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

class MyMouse implements MouseListener {

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
public class Ex16 extends Frame implements Runnable {
	public static void main(String[] args) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image penguin = kit.createImage("penguin.png");
		Image polarbear = kit.createImage("polarbear.png");
		Image sealion = kit.createImage("sealion.png");
		Image turtle = kit.createImage("turtle.png");
		Icon iPenguin = new ImageIcon(penguin);
		Icon iPolarbear = new ImageIcon(polarbear);
		Icon iSealion = new ImageIcon(sealion);
		Icon iTurtle = new ImageIcon(turtle);
		
		GridLayout grid16 = new GridLayout(4, 4);
		BorderLayout puzzle = new BorderLayout();
		
		Ex16 me = new Ex16();
		final Frame frame = new Frame();
		
		Panel pNorth = new Panel();
		Panel pCenter = new Panel();
		Panel pSouth = new Panel();
		Panel pEast = new Panel();
		
		frame.add(pNorth, BorderLayout.NORTH);
		frame.add(pCenter, BorderLayout.CENTER);
		frame.add(pSouth, BorderLayout.SOUTH);
		frame.add(pEast, BorderLayout.EAST);
		
		Button start = new Button("시작");
		Button end = new Button("종료");
		pEast.add(start);
		pEast.add(end);
		
		Label quest = new Label("문제입니다.");
//		Label status = new Label(count+"초 / "+score+"점");
		
		pNorth.add(new Label("제목"));
		pSouth.add(new Label("아래"));
		
		String[] imgNms = {"penguin.png", "polarbear.png", "sealion.png", "turtle.png"};
		JButton[] btns = new JButton[16];
		pCenter.setLayout(grid16);
		for (int i=0; i<btns.length; i++) {
			Image img = kit.getImage(imgNms[i/4]);
			Icon icon = new ImageIcon(img);
			JButton btn = new JButton(icon);
			pCenter.add(btn);
			if (i/4 == 0) {
				btn.addActionListener (new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						System.out.println("펭귄");
					}
				});
			}
		}
		
//		while (true) {
//			frame.mix(pCenter, btns);
//			Thread.sleep(1000);
//			this.revalidate();
//		}
		
		frame.setBounds(10, 10, 600, 600);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
	}
	
	public void mix(Panel pCenter, JButton[] btns) {
		Random random = new Random();
		for (int i=0; i<1000; i++) {
			int ran = random.nextInt(16);
			JButton temp = btns[0];
			btns[0] = btns[ran];
			btns[ran] = temp;
		}
		for (int i=0; i<16; i++) {
			pCenter.add(btns[i]);
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
}

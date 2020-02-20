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
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Ex161 extends Frame implements Runnable{
	Panel p1=new Panel();
	JButton[] jbtn=new JButton[16];
	
	public Ex161() {
		setLayout(new BorderLayout());
		Panel p2=new Panel();
		
		p1.setLayout(new GridLayout(4,4));
		Toolkit kit = Toolkit.getDefaultToolkit();
		String[] imgNms={"penguin.png","polarbear.png","sealion.png","turtle.png"};
		for(int i=0; i<16; i++){
			
			Image img = kit.getImage(imgNms[i/4]);
			Icon icon=new ImageIcon(img);
			JButton btn = new JButton(icon);
			if(i/4==0){
				btn.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						System.out.println("�ƿ���...");
					}
				});
			}
			jbtn[i]=btn;
			btn.setEnabled(false);
			p1.add(btn);
		}
		Button startBtn = new Button("����");
		final Ex161 me = this;
		startBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Thread thr=new Thread(me);
				thr.start();
			}
		});
		p2.add(startBtn);
		p2.add(new Button("����"));
		
		add(new Label("�ƿ�������� �����ϼ���"),BorderLayout.NORTH);
		add(new Label("60�� 0��"),BorderLayout.SOUTH);
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.EAST);
		setBounds(100,100,600,600);
		setVisible(true);
		
	}
	public void play(){
		int limit=10;
		for(int i=0; i<jbtn.length; i++){
			jbtn[i].setEnabled(true);
		}
		while(--limit>0){
			mix();
			try {
				Thread.sleep(500);
				this.revalidate();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mix();
			try {
				Thread.sleep(500);
				this.revalidate();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0; i<jbtn.length; i++){
			jbtn[i].setEnabled(false);
		}
	}
	public void mix(){
		Random random=new Random();
		for(int i=0; i<1000; i++){
			int ran=random.nextInt(16);
			
			JButton temp = jbtn[0];
			jbtn[0]=jbtn[ran];
			jbtn[ran]=temp;
		}
		for(int i=0; i<16; i++){
			p1.add(jbtn[i]);
		}		
	}

	public static void main(String[] args) {
		new Ex161();
	}
	public void run() {
		play();
	}
}
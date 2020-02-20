package mew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class RestRoomUI extends JFrame implements ActionListener {

	public int lastRoomNum = 100;
	public JButton makeRoomBtn, getInRoomBtn, whisperBtn, sendBtn;
	public JTree userTree;
	public JList roomList;
	public JTextField chatField;
	public JTextArea restRoomArea;
	public JLabel lb_id, lb_nick;
	public JTextField lb_ip;

	private SixClient client;
	public ArrayList<User> userArray; // ����� ��� �迭
	public String currentSelectedTreeNode;
	public DefaultListModel model;
	public DefaultMutableTreeNode level_1;
	public DefaultMutableTreeNode level_2_1;
	public DefaultMutableTreeNode level_2_2;

	public RestRoomUI(SixClient sixClient) {
		setTitle("\uBBA4\uBBA4 Chat");
		userArray = new ArrayList<User>();
		client = sixClient;
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu basicMenus = new JMenu("\uC77C\uBC18");
		basicMenus.addActionListener(this);
		menuBar.add(basicMenus);

		JMenuItem changeNickItem = new JMenuItem(
				"\uB2C9\uB124\uC784 \uBC14\uAFB8\uAE30");
		changeNickItem.addActionListener(this);
		basicMenus.add(changeNickItem);

		JMenuItem exitItem = new JMenuItem("\uB05D\uB0B4\uAE30");
		exitItem.addActionListener(this);
		basicMenus.add(exitItem);

		JMenu helpMenus = new JMenu("\uB3C4\uC6C0\uB9D0");
		helpMenus.addActionListener(this);
		menuBar.add(helpMenus);

		JMenuItem proInfoItem = new JMenuItem(
				"\uD504\uB85C\uADF8\uB7A8 \uC815\uBCF4");
		proInfoItem.addActionListener(this);
		helpMenus.add(proInfoItem);
		getContentPane().setLayout(null);

		JPanel room = new JPanel();
		room.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\uCC44\uD305\uBC29",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		room.setBounds(12, 10, 477, 215);
		getContentPane().add(room);
		room.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		room.add(scrollPane, BorderLayout.CENTER);

		// ����Ʈ ��ü�� �� ����
		roomList = new JList(new DefaultListModel());
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ä�ù� ��� �� �ϳ��� ������ ���,
				// ������ ���� ���ȣ�� ����
				String temp = (String) roomList.getSelectedValue();

				try {
					client.getUser()
							.getDos()
							.writeUTF(
									User.UPDATE_SELECTEDROOM_USERLIST + "/"
											+ temp.substring(0, 3));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		model = (DefaultListModel) roomList.getModel();
		roomList.setBackground(new Color(224, 255, 255));
		scrollPane.setViewportView(roomList);

		JPanel panel_2 = new JPanel();
		room.add(panel_2, BorderLayout.SOUTH);

		makeRoomBtn = new JButton("\uBC29 \uB9CC\uB4E4\uAE30");
		makeRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		makeRoomBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// �游��� ��ư Ŭ��
				createRoom();
			}
		});
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		panel_2.add(makeRoomBtn);

		getInRoomBtn = new JButton("\uBC29 \uB4E4\uC5B4\uAC00\uAE30");
		getInRoomBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// �� ����
				getIn();
			}
		});
		panel_2.add(getInRoomBtn);

		JPanel user = new JPanel();
		user.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\uC0AC\uC6A9\uC790 \uBAA9\uB85D", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		user.setBounds(501, 10, 171, 215);
		getContentPane().add(user);
		user.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		user.add(scrollPane_1, BorderLayout.CENTER);

		// ����ڸ��, Ʈ������
		userTree = new JTree();
		userTree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				currentSelectedTreeNode = arg0.getPath().getLastPathComponent()
						.toString();
			}
		});
		level_1 = new DefaultMutableTreeNode("������");
		level_2_1 = new DefaultMutableTreeNode("ä�ù�");
		level_2_2 = new DefaultMutableTreeNode("����");
		level_1.add(level_2_1);
		level_1.add(level_2_2);

		DefaultTreeModel model = new DefaultTreeModel(level_1);
		userTree.setModel(model);

		scrollPane_1.setViewportView(userTree);

		JPanel panel_1 = new JPanel();
		user.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		whisperBtn = new JButton("\uADD3\uC18D\uB9D0");
		whisperBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StringTokenizer token = new StringTokenizer(
						currentSelectedTreeNode, "("); // ��ū ����
				String temp = token.nextToken(); // ��ū���� �и��� ��Ʈ��
				temp = token.nextToken();

				// �г��� �����ϰ� ���̵� ����
				chatField.setText("/" + temp.substring(0, temp.length() - 1)
						+ " ");
				chatField.requestFocus();
			}
		});
		panel_1.add(whisperBtn);

		JPanel restroom = new JPanel();
		restroom.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\uB300 \uAE30 \uC2E4",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
		restroom.setBounds(12, 235, 477, 185);
		getContentPane().add(restroom);
		restroom.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		restroom.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane_4 = new JScrollPane();
		panel.add(scrollPane_4);

		chatField = new JTextField();

		chatField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					msgSummit();
				}
			}

		});
		scrollPane_4.setViewportView(chatField);
		chatField.setColumns(10);

		sendBtn = new JButton("\uBCF4\uB0B4\uAE30");
		sendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				msgSummit();
				chatField.requestFocus();
			}
		});
		panel.add(sendBtn);

		JScrollPane scrollPane_2 = new JScrollPane();
		restroom.add(scrollPane_2, BorderLayout.CENTER);

		restRoomArea = new JTextArea();
		restRoomArea.setBackground(new Color(224, 255, 255));
		restRoomArea.setEditable(false);
		scrollPane_2.setViewportView(restRoomArea);

		JPanel info = new JPanel();
		info.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\uB0B4 \uC815\uBCF4",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		info.setBounds(501, 235, 171, 185);
		getContentPane().add(info);
		info.setLayout(null);

		JLabel lblNewLabel = new JLabel("IP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(-25, 54, 57, 15);
		info.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 89, 57, 15);
		info.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uB2C9\uB124\uC784");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 129, 57, 15);
		info.add(lblNewLabel_3);

		lb_id = new JLabel("-");
		lb_id.setBounds(57, 89, 102, 15);
		info.add(lb_id);

		lb_nick = new JLabel("-");
		lb_nick.setBounds(57, 129, 102, 15);
		info.add(lb_nick);

		lb_ip = new JTextField();
		lb_ip.setBounds(57, 51, 102, 21);
		lb_ip.setEditable(false);
		info.add(lb_ip);
		lb_ip.setColumns(10);
		chatField.requestFocus();
		setVisible(true);
		chatField.requestFocus();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		// �޴�1 ���� �޴�
		case "�г��� �ٲٱ�":
			changeNick();
			break;
		case "������":
			exit();
			break;
		case "���α׷� ����":
			maker();
			System.out.println("�佺Ʈ");
			break;
		}
	}

	private void changeNick() {
		String temp = JOptionPane.showInputDialog(this, "������ �г����� �Է��ϼ���.");
		if (temp != null && !temp.equals("")) {
			try {
				client.getUser().getDos()
						.writeUTF(User.CHANGE_NICK + "/" + temp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void msgSummit() {
		// �޽�������
		String string = chatField.getText();

		if (!string.equals("")) {
			if (string.substring(0, 1).equals("/")) {
				StringTokenizer token = new StringTokenizer(string, " "); // ��ū
																			// ����
				String id = token.nextToken(); // ��ū���� �и��� ��Ʈ��
				String msg = token.nextToken();

				try {
					client.getDos().writeUTF(User.WHISPER + id + "/" + msg);
					restRoomArea.append(id + "�Կ��� �ӼӸ� : " + msg + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				chatField.setText("");
			} else {

				try {
					// ���ǿ� �޽��� ����
					client.getDos().writeUTF(User.ECHO01 + "/" + string);
				} catch (IOException e) {
					e.printStackTrace();
				}
				chatField.setText("");
			}
		}
	}

	private void exit() {
		try {
			client.getUser().getDos().writeUTF(User.LOGOUT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createRoom() {
		String roomname = "�Բ� ��ƺ��ƿ�";
		Room newRoom = new Room(roomname); // �� ��ü ����
		newRoom.setRoomNum(lastRoomNum);
		newRoom.setrUI(new RoomUI(client, newRoom)); // UI

		// Ŭ���̾�Ʈ�� ������ �� ��Ͽ� �߰�
		client.getUser().getRoomArray().add(newRoom);

		try {
			client.getDos().writeUTF(
					User.CREATE_ROOM + "/" + newRoom.toProtocol());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getIn() {
		// ������ �� ����
		String selectedRoom = (String) roomList.getSelectedValue();
		StringTokenizer token = new StringTokenizer(selectedRoom, "/"); // ��ū ����
		String rNum = token.nextToken();
		String rName = token.nextToken();

		Room theRoom = new Room(rName); // �� ��ü ����
		theRoom.setRoomNum(Integer.parseInt(rNum)); // ���ȣ ����
		theRoom.setrUI(new RoomUI(client, theRoom)); // UI

		// Ŭ���̾�Ʈ�� ������ �� ��Ͽ� �߰�
		client.getUser().getRoomArray().add(theRoom);

		try {
			client.getDos().writeUTF(
					User.GETIN_ROOM + "/" + theRoom.getRoomNum());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void maker() {
		JDialog maker = new JDialog();
		Maker m = new Maker();
		maker.setTitle("���α׷� ����");
		maker.getContentPane().add(m);
		maker.setSize(400, 170);
		maker.setVisible(true);
		maker.setLocation(400, 350);
		maker.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}

class Maker extends JPanel {
	public Maker() {
		super();
		initialize();
	}

	private void initialize() {
		this.setLayout(new GridLayout(3, 1));

		JLabel j1 = new JLabel("       ���α׷� ������ : û�������ī����");
		JLabel j2 = new JLabel("       ������ ��� : CBNU");
		JLabel j3 = new JLabel("       ���α׷� ���� : 1.0v  ( 13 . 8 . 29 )");

		this.add(j1);
		this.add(j2);
		this.add(j3);
	}
}
import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;


public class Launcher extends JFrame{
	private static final long serialVersionUID = 4063192308692236637L;
	private JTextField txtUsername;
	private JTextField txtIP;
	private JTextField txtPort;
	private JRadioButton rdbtnHostANetworked;
	private JRadioButton rdbtnConnectToExisting;
	private JButton btnAuth;
	private JLabel lblWaiting;
	private JLabel lblServerAddress;
	private JLabel lblPlayers;
	private JLabel lblOpsTick;
	private JButton btnKick;
	private JButton btnBan;
	private JList listPlayers;
	private JLabel lblStatus;
	private JButton btnStartGame;
	
	public static void main(String[] args) {
		new Launcher();
	}
	
	public Launcher() {
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setType(Type.UTILITY);
		setTitle("Bill Clicker Launcher");
		
		JLabel lblBillClicker = new JLabel("Bill Clicker");
		lblBillClicker.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblProgrammedByJad = new JLabel("Programmed by Jad Aboulhosn and Richard Capewell");
		lblProgrammedByJad.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblDesignedByGalen = new JLabel("Designed by Galen Gerhard and Garrison Lewis");
		lblDesignedByGalen.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblInNoWay = new JLabel("Creative Commons 2.0 License");
		lblInNoWay.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblsweaver = new JLabel("#sweaver2013");
		lblsweaver.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new GameInterface();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBillClicker)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProgrammedByJad)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblDesignedByGalen)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblsweaver))
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblInNoWay)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE))
									.addComponent(btnStartGame, Alignment.TRAILING)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBillClicker)
								.addComponent(btnStartGame))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProgrammedByJad)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDesignedByGalen)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblsweaver)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInNoWay)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblConfigureGameOptions = new JLabel("Configure Game Options");
		lblConfigureGameOptions.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JPanel ServerPanel = new JPanel();
		ServerPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		rdbtnHostANetworked = new JRadioButton("Host");
		rdbtnHostANetworked.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		rdbtnHostANetworked.setSelected(true);
		
		rdbtnConnectToExisting = new JRadioButton("Connect");
		rdbtnConnectToExisting.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblServerIp = new JLabel("Server IP:");
		lblServerIp.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtUsername.setColumns(10);
		
		txtIP = new JTextField();
		txtIP.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtIP.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtPort.setColumns(10);
		
		JLabel lblStatusIn = new JLabel("Status:");
		lblStatusIn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		lblStatus = new JLabel("Waiting...");
		lblStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		btnAuth = new JButton("Authenticate");
		btnAuth.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		lblWaiting = new JLabel("Waiting...");
		lblWaiting.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStatusIn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblStatus))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblConfigureGameOptions, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnHostANetworked)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnConnectToExisting))
						.addComponent(lblUsername)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblServerIp)
								.addComponent(txtIP, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPort, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPort)
									.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)))
							.addGap(4)
							.addComponent(btnAuth, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblWaiting)
							.addGap(66))
						.addComponent(ServerPanel, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblServerIp)
								.addComponent(lblPort))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWaiting)
								.addComponent(btnAuth)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConfigureGameOptions)
								.addComponent(rdbtnHostANetworked)
								.addComponent(rdbtnConnectToExisting))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ServerPanel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatusIn)
						.addComponent(lblStatus))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		lblServerAddress = new JLabel("Server Address: ???");
		lblServerAddress.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		lblPlayers = new JLabel("Players: ???");
		lblPlayers.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		listPlayers = new JList();
		listPlayers.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		listPlayers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnKick = new JButton("Kick");
		btnKick.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		btnBan = new JButton("Ban");
		btnBan.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblOperationsTick = new JLabel("Operations / Tick:");
		
		lblOpsTick = new JLabel("??");
		GroupLayout gl_ServerPanel = new GroupLayout(ServerPanel);
		gl_ServerPanel.setHorizontalGroup(
			gl_ServerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ServerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPlayers)
						.addGroup(gl_ServerPanel.createSequentialGroup()
							.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(listPlayers, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblServerAddress))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ServerPanel.createSequentialGroup()
									.addComponent(lblOperationsTick)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblOpsTick))
								.addComponent(btnBan, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(btnKick, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_ServerPanel.setVerticalGroup(
			gl_ServerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ServerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ServerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServerAddress)
						.addComponent(lblOperationsTick)
						.addComponent(lblOpsTick))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPlayers)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ServerPanel.createSequentialGroup()
							.addComponent(btnKick)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBan))
						.addComponent(listPlayers, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
					.addContainerGap())
		);
		ServerPanel.setLayout(gl_ServerPanel);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(new Dimension(640, 404));
	}
}

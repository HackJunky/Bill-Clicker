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
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;


public class Launcher extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		new GameInterface();
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
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblDesignedByGalen)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblsweaver))
									.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblInNoWay)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBillClicker)
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
		
		JRadioButton rdbtnHostANetworked = new JRadioButton("Host");
		rdbtnHostANetworked.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		rdbtnHostANetworked.setSelected(true);
		
		JRadioButton rdbtnConnectToExisting = new JRadioButton("Connect");
		rdbtnConnectToExisting.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblServerIp = new JLabel("Server IP:");
		lblServerIp.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_2.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblUnknown = new JLabel("Waiting...");
		lblUnknown.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JButton btnNewButton = new JButton("Authenticate");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblWaiting = new JLabel("Waiting...");
		lblWaiting.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStatus)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUnknown))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblConfigureGameOptions, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnHostANetworked)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnConnectToExisting))
						.addComponent(lblUsername)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblServerIp)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPort)
									.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)))
							.addGap(4)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWaiting)
								.addComponent(btnNewButton)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConfigureGameOptions)
								.addComponent(rdbtnHostANetworked)
								.addComponent(rdbtnConnectToExisting))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ServerPanel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatus)
						.addComponent(lblUnknown))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		JLabel lblServerAddress = new JLabel("Server Address: ???");
		lblServerAddress.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblPlayers = new JLabel("Players: ???");
		lblPlayers.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JList list = new JList();
		list.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnNewButton_1 = new JButton("Kick");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JButton btnBan = new JButton("Ban");
		btnBan.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblOperationsTick = new JLabel("Operations / Tick:");
		
		JLabel label = new JLabel("??");
		GroupLayout gl_ServerPanel = new GroupLayout(ServerPanel);
		gl_ServerPanel.setHorizontalGroup(
			gl_ServerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ServerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPlayers)
						.addGroup(gl_ServerPanel.createSequentialGroup()
							.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblServerAddress))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ServerPanel.createSequentialGroup()
									.addComponent(lblOperationsTick)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label))
								.addComponent(btnBan, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_ServerPanel.setVerticalGroup(
			gl_ServerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ServerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ServerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServerAddress)
						.addComponent(lblOperationsTick)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPlayers)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ServerPanel.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBan))
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
					.addContainerGap())
		);
		ServerPanel.setLayout(gl_ServerPanel);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.setVisible(true);
		this.setSize(new Dimension(640, 404));
	}
}

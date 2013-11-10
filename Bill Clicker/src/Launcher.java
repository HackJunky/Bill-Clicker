import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.BorderLayout;
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

	public static void main(String[] args) {
		
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
		
		JProgressBar progressBar = new JProgressBar();
		
		JButton btnNewButton = new JButton("Launch!");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblUnknown = new JLabel("Waiting...");
		lblUnknown.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblInNoWay)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBillClicker)
									.addPreferredGap(ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
									.addComponent(lblsweaver))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDesignedByGalen)
										.addComponent(lblProgrammedByJad))))
							.addGap(22))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblStatus)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblUnknown)
									.addPreferredGap(ComponentPlacement.RELATED, 452, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBillClicker)
						.addComponent(lblsweaver))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblProgrammedByJad)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDesignedByGalen)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatus)
						.addComponent(lblUnknown))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInNoWay)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblConfigureGameOptions = new JLabel("Configure Game Options");
		lblConfigureGameOptions.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JRadioButton rdbtnHostANetworked = new JRadioButton("Host a Networked Game");
		rdbtnHostANetworked.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		rdbtnHostANetworked.setSelected(true);
		
		JRadioButton rdbtnConnectToExisting = new JRadioButton("Connect to Existing Game");
		rdbtnConnectToExisting.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JPanel ServerPanel = new JPanel();
		ServerPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(ServerPanel, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addComponent(lblConfigureGameOptions)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(rdbtnHostANetworked)
							.addGap(18)
							.addComponent(rdbtnConnectToExisting)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConfigureGameOptions)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnHostANetworked)
							.addComponent(rdbtnConnectToExisting))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ServerPanel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		GroupLayout gl_ServerPanel = new GroupLayout(ServerPanel);
		gl_ServerPanel.setHorizontalGroup(
			gl_ServerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ServerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblServerAddress)
						.addComponent(lblPlayers)
						.addGroup(gl_ServerPanel.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBan, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_ServerPanel.setVerticalGroup(
			gl_ServerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ServerPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblServerAddress)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPlayers)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ServerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ServerPanel.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBan))
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
					.addContainerGap())
		);
		ServerPanel.setLayout(gl_ServerPanel);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
	}
}

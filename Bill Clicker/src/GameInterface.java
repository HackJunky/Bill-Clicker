import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameInterface extends JFrame{
	private static final long serialVersionUID = -7919915401364513058L;

	//Begin Static Definitions Region
	private static int WINDOW_SIZE_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static int WINDOW_SIZE_Y = Toolkit.getDefaultToolkit().getScreenSize().height;

	//Begin Drawing Area Region
	private Rectangle billClickerArea;
	private Rectangle billClickerButton;
	private int billClickerButtonMOD;
	private Rectangle billStatsArea;
	private Rectangle billSupportArea;
	private Rectangle billPurchaseArea;
	private Rectangle billUpgradeArea;
	private Rectangle drawArea;
	private Rectangle[] billDrawArea;

	//Begin Drawing Resources Region
	private BufferedImage backgroundImage = CoreUtils.getBackgroundImage();
	private BufferedImage billImage = CoreUtils.getBill();
	private BufferedImage gradientDown = CoreUtils.getGradientDown();
	private BufferedImage gradientUp = CoreUtils.getGradientUp();
	private BufferedImage horSep = CoreUtils.getHorSep();
	private BufferedImage vertSep = CoreUtils.getVertSep();
	private BufferedImage textGradient = CoreUtils.getTextGradient();
	private BufferedImage storeTile = CoreUtils.getStoreTile();

	private ArrayList<FloatingText> floatingText = new ArrayList<FloatingText>();

	//Begin Store Definitions Region
	private ArrayList<StoreTile> storeEntries;

	//Begin Bill Definitions Region
	private int appealPerSecond = 0;
	private int appealPerClick = 1;
	private int totalAppeal = 1000;

	//Begin UI Strings Region
	private String status = "You feel like passing a bill, but no one wants to hear about your bill.";
	private String name = "Weaver";
	private String[] statusList = {
			"You feel like passing a bill, but no one wants to hear about your bill.",
			"I <3 'MERICA.",
			"Comic Sans MS is the greatest font invented.",
			"COMIC SANS? I AM COMIC SANS!!",
			"Cookie Clicker is the most intellectually stimulating game ever.",
			"Jad's humor is not only witty, but also beautifully executed.",
			"Of course I carry a pocket constitution!",
			"#swerve",
			"I think that JDaddy Comic Sans is an excellent programmer.",
			"Bill Clicker deserves an A.",
			"Sweaving people is a huge perk of my job.",
			"Don't you hate it when you're friends use the wrong grammar?",
			"Just finished cooking.. get me the camera.",
			"Looks like we got Idaho's votes... all 4 of them.",
			"Of course she's going to complain.. she's a girl!",
			"Wut wut, wut, wut, wut wut, wut wut, wut, wut, wut wut...",
			"I don't always wear my grill and chains.",
			"IT'S MY MONEY AND I NEED IT NOW! (877-CASH-NOW)",
			"I found all my role models in 'White Chicks'.",
			"Swag.",
			"I wish I had said something of value to quote..",
			"It is an honor to be quoted by this game.",
			"Yeah, I represent my district. What are ya gonna do 'bout it?",
			"Such bills. So much pass. So appeal. Wow.",
			"My iPod is a variety of Taylor Swift and Based God.",
			"What do you mean you didn't vote?!?",
			"What kind of person lives in Modesto anyway?",
			"What do the people of Modesto and Danville have in common? ... Nothing.",
			"Your vote does count!",
			"Wow, look at this news article I posted on my twitter.",
			"#SWEAVED",
			"Did your computer just shut down? Oh, what a shame!",
			"The Farmers of the Constitution were great men.",
			"British people just make my day.",
			"Garrison has the most beautiful eyes.",
			"100111000111010101110001111011 -- Look I'm speaking in binary.",
			"Bill Clicker is the only reason I come to teach anymore."
	};

	private String[] nameList = {
			"Weaver",
			"Sweaver",
			"SweaveDaddy",
			"WeaveDaddy",
			"Weaver 'The Sans' Daddy",
			"Uncle Sweaver",
			"Uncle 'Sans'"
	};

	//Begin Class Instances Region
	private WorldTimer gameHandle;
	private Timer gameTimer;

	public GameInterface() {
		//Begin Store Entries Region
		storeEntries = new ArrayList<StoreTile>();
		storeEntries.add(new StoreTile("Supporters", 100, 1, 0.05f));
		storeEntries.add(new StoreTile("Weaver", 200, 2, 0.1f));
		storeEntries.add(new StoreTile("Public Support", 400, 4, 0.2f));
		storeEntries.add(new StoreTile("Committee Approval", 800, 8, 0.2f));
		storeEntries.add(new StoreTile("S. of the House Approval", 1600, 16, 0.3f));
		storeEntries.add(new StoreTile("Law Maker Approval", 3200, 32, 0.3f));
		storeEntries.add(new StoreTile("Senate Approval", 6400, 32, 0.4f));
		storeEntries.add(new StoreTile("Advanced Campaigning", 128000, 32, 0.4f));
		storeEntries.add(new StoreTile("Presidential Approval", 256000, 32, 0.5f));
		storeEntries.add(new StoreTile("Luck", 512000, 32, 0.6f));

		//Begin Drawing Definitions Region
		billClickerArea = new Rectangle(0, 0, WINDOW_SIZE_X / 4, WINDOW_SIZE_Y);
		billClickerButton = new Rectangle(billClickerArea.x + ((billClickerArea.width - billImage.getWidth()) / 2), billClickerArea.y + (billClickerArea.height / 8), billImage.getWidth(), billImage.getHeight());
		billClickerButtonMOD = 0;
		billStatsArea = new Rectangle(billClickerArea.x + billClickerArea.width, 0, WINDOW_SIZE_X / 2, WINDOW_SIZE_Y / 8);
		billSupportArea = new Rectangle(billStatsArea.x, billStatsArea.y + billStatsArea.height, billStatsArea.width, WINDOW_SIZE_Y - (WINDOW_SIZE_Y / 8));
		billPurchaseArea = new Rectangle(billStatsArea.x + billStatsArea.width, 0, WINDOW_SIZE_X / 4, WINDOW_SIZE_Y);

		//Begin Store Draw Definitions Region
		int stores = storeEntries.size();
		drawArea = new Rectangle(billStatsArea.x, billStatsArea.y + billStatsArea.height, billStatsArea.width, WINDOW_SIZE_Y - (billStatsArea.y + billStatsArea.height));
		int sizeX = drawArea.width;
		int sizeY = drawArea.height / stores;
		billDrawArea = new Rectangle[stores];
		for (int i = 0; i < stores; i++) {
			billDrawArea[i] = new Rectangle(drawArea.x, drawArea.y + (sizeY * i) + 16, drawArea.width, sizeY);
		}

		//Begin Class Instantiation Region
		gameHandle = new WorldTimer();
		gameTimer = new Timer(1, gameHandle);
		//networkHandle = new NetworkManager();

		//Begin Main INIT Region
		this.setUndecorated(true);
		this.setSize(new Dimension(WINDOW_SIZE_X, WINDOW_SIZE_Y));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.createBufferStrategy(2);
		this.addMouseListener(gameHandle);

		//Begin Secondary INIT Region
		gameTimer.start();

		//Initialize Custom Cursor
		//	Toolkit toolkit = Toolkit.getDefaultToolkit();
		//	Image cursor = toolkit.getImage("res/img/cursoricon.png");
		//	Cursor gameCursor = toolkit.createCustomCursor(cursor, new Point(this.getRootPane().getX(), this.getRootPane().getY()), "img");
		//	this.setCursor(gameCursor);
	}

	public void draw() {
		//Begin Drawing Strategy Definitions Region
		BufferStrategy bs = this.getBufferStrategy();
		Graphics2D g2d = (Graphics2D)bs.getDrawGraphics();
		Stroke defaultStroke = g2d.getStroke();
		Stroke thickStroke = new BasicStroke(6);
		g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		FontMetrics fm = g2d.getFontMetrics();

		//Begin Graphical Background Region
		g2d.setColor(Color.CYAN);
		g2d.setStroke(defaultStroke);
		g2d.fillRect(0, 0, WINDOW_SIZE_X, WINDOW_SIZE_Y);

		//Fill background with tiles
		int BG_SIZE_X = backgroundImage.getWidth();
		int BG_SIZE_Y = backgroundImage.getHeight();
		int numHor = WINDOW_SIZE_X / BG_SIZE_X;
		int numVert = WINDOW_SIZE_Y / BG_SIZE_Y;

		for (int x = 0; x <= numHor; x++) {
			for (int y = 0; y <= numVert; y++) {
				g2d.drawImage(backgroundImage, BG_SIZE_X * x, BG_SIZE_Y * y, BG_SIZE_X, BG_SIZE_Y, this);
			}
		}

		//Begin Graphical Outline Region
		g2d.setColor(Color.BLACK);
		g2d.drawRect(billClickerArea.x, billClickerArea.y, billClickerArea.width, billClickerArea.height);
		g2d.drawRect(billStatsArea.x, billStatsArea.y, billStatsArea.width, billStatsArea.height);
		g2d.drawRect(billSupportArea.x, billSupportArea.y, billSupportArea.width, billSupportArea.height);
		g2d.drawRect(billPurchaseArea.x, billPurchaseArea.y, billPurchaseArea.width, billPurchaseArea.height);

		//Begin Bill Clicker Region
		int GRAD_SIZE_X = gradientDown.getWidth();
		int GRAD_SIZE_Y = billClickerArea.height / 8;
		numHor = billClickerArea.width / GRAD_SIZE_X;
		for (int x = 0; x <= numHor; x++) {
			g2d.drawImage(gradientDown, billClickerArea.x + GRAD_SIZE_X * x, 0, GRAD_SIZE_X, GRAD_SIZE_Y, this);
		}
		for (int x = 0; x <= numHor; x++) {
			g2d.drawImage(gradientUp, billClickerArea.x + GRAD_SIZE_X * x, billClickerArea.y + billClickerArea.height - GRAD_SIZE_Y, GRAD_SIZE_X, GRAD_SIZE_Y, this);
		}

		//Draw Bill Region
		g2d.drawImage(billImage, billClickerButton.x - billClickerButtonMOD, billClickerButton.y - billClickerButtonMOD, billClickerButton.width + (billClickerButtonMOD * 2), billClickerButton.height + (billClickerButtonMOD * 2), this);
		g2d.drawImage(textGradient, 0, billClickerButton.y + (billClickerButton.height / 8), billClickerArea.width, 64, this);

		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		for (FloatingText f : floatingText) {
			g2d.drawString(f.getText(), f.getLocation().x, f.getLocation().y);
		}

		//Begin Text Region A
		g2d.setColor(Color.WHITE);
		String superScript = totalAppeal + " appeal";
		String subScript = "per second: " + appealPerSecond;
		g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		fm = g2d.getFontMetrics();
		g2d.drawString(superScript, billClickerArea.x + (billClickerArea.width / 2) - (fm.stringWidth(superScript) / 2), billClickerArea.y + (billClickerArea.height / 8) + fm.getHeight() + fm.getAscent());
		g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		fm = g2d.getFontMetrics();
		g2d.drawString(subScript, billClickerArea.x + (billClickerArea.width / 2) - (fm.stringWidth(subScript) / 2), billClickerArea.y + (billClickerArea.height / 8) + (fm.getAscent() * 2) + (fm.getHeight() * 2));

		//Begin Upper Central Region
		numHor = billSupportArea.width / GRAD_SIZE_X;
		for (int x = 0; x <= numHor; x++) {
			g2d.drawImage(gradientDown, billSupportArea.x + GRAD_SIZE_X * x, -(GRAD_SIZE_Y / 2), GRAD_SIZE_X, GRAD_SIZE_Y, this);
		}
		for (int x = 0; x <= numHor; x++) {
			g2d.drawImage(gradientUp, billSupportArea.x + GRAD_SIZE_X * x, billSupportArea.y + billSupportArea.height - (GRAD_SIZE_Y / 2), GRAD_SIZE_X, GRAD_SIZE_Y, this);
		}

		//Begin Text Region B
		g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		fm = g2d.getFontMetrics();
		String message = "'" + status + "' -" + name + "2013";
		g2d.drawString(message, billStatsArea.x + (billStatsArea.width / 2) - (fm.stringWidth(message) / 2), fm.getAscent() + 15);

		//Begin Central Region
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(drawArea.x, drawArea.y, drawArea.width, drawArea.height);
		g2d.setColor(Color.WHITE);
		for (int i = 0; i < billDrawArea.length; i++) {
			Rectangle r = billDrawArea[i];
			g2d.drawImage(textGradient, r.x, r.y, r.width, 8, this);
		}

		//Begin Shop Region
		numHor = billPurchaseArea.width / GRAD_SIZE_X;
		for (int x = 0; x <= numHor; x++) {
			g2d.drawImage(gradientDown, billPurchaseArea.x + 16 + GRAD_SIZE_X * x, -(GRAD_SIZE_Y / 2), GRAD_SIZE_X, GRAD_SIZE_Y, this);
		}
		for (int x = 0; x <= numHor; x++) {
			g2d.drawImage(gradientUp, billPurchaseArea.x + 16 + GRAD_SIZE_X * x, billPurchaseArea.y + billPurchaseArea.height - (GRAD_SIZE_Y / 2), GRAD_SIZE_X, GRAD_SIZE_Y, this);
		}

		int entries = storeEntries.size();
		for (int cTile = 0; cTile < entries; cTile++) {
			g2d.setColor(Color.WHITE);
			Rectangle buttonLoc = new Rectangle(billPurchaseArea.x + 16, billPurchaseArea.y + (billPurchaseArea.height / 8) + (cTile * storeTile.getHeight()), billPurchaseArea.width, storeTile.getHeight());
			storeEntries.get(cTile).setLocation(buttonLoc);
			if (storeEntries.get(cTile).isMouseOver()) {
				g2d.drawImage(storeTile, buttonLoc.x - 4, buttonLoc.y - 4, buttonLoc.width + 8, buttonLoc.height + 8, this);
			}else {
				g2d.drawImage(storeTile, buttonLoc.x, buttonLoc.y, buttonLoc.width, buttonLoc.height, this);
			}

			g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
			fm = g2d.getFontMetrics();
			if (storeEntries.get(cTile).isMouseOver()) {
				g2d.drawString(storeEntries.get(cTile).getName(), billPurchaseArea.x + 28, billPurchaseArea.y + (billPurchaseArea.height / 8) + (cTile * storeTile.getHeight()) + fm.getAscent() + 1);
			}else {
				g2d.drawString(storeEntries.get(cTile).getName(), billPurchaseArea.x + 32, billPurchaseArea.y + (billPurchaseArea.height / 8) + (cTile * storeTile.getHeight()) + fm.getAscent() + 5);
			}

			g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			fm = g2d.getFontMetrics();
			if (storeEntries.get(cTile).getCost() > totalAppeal) {
				g2d.setColor(Color.RED);
			}else {
				g2d.setColor(Color.GREEN);
			}

			Rectangle tileLoc = new Rectangle(billPurchaseArea.x + 48, billPurchaseArea.y + (billPurchaseArea.height / 8) + (cTile * storeTile.getHeight()) + fm.getHeight() + 15, 30, 16);
			if (storeEntries.get(cTile).isMouseOver()) {
				g2d.drawImage(billImage, tileLoc.x - 4, tileLoc.y - 4, tileLoc.width + 8, tileLoc.height + 8, this);
				g2d.drawString(String.valueOf(storeEntries.get(cTile).getCost()), billPurchaseArea.x + 76, billPurchaseArea.y + (billPurchaseArea.height / 8) + (cTile * storeTile.getHeight()) + fm.getAscent() + fm.getHeight() + 6);
			}else {
				g2d.drawImage(billImage, tileLoc.x, tileLoc.y, tileLoc.width, tileLoc.height, this);
				g2d.drawString(String.valueOf(storeEntries.get(cTile).getCost()), billPurchaseArea.x + 80, billPurchaseArea.y + (billPurchaseArea.height / 8) + (cTile * storeTile.getHeight()) + fm.getAscent() + fm.getHeight() + 10);
			}
			g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
			fm = g2d.getFontMetrics();
			g2d.setColor(Color.WHITE);
			if (storeEntries.get(cTile).isMouseOver()) {
				g2d.drawString(String.valueOf(storeEntries.get(cTile).getOwned()), WINDOW_SIZE_X - (fm.stringWidth(String.valueOf(storeEntries.get(cTile).getOwned())) * 2) - 9,  billPurchaseArea.y + (billPurchaseArea.height / 8) + (cTile * storeTile.getHeight()) + fm.getHeight() + 1);
			}else {
				g2d.drawString(String.valueOf(storeEntries.get(cTile).getOwned()), WINDOW_SIZE_X - (fm.stringWidth(String.valueOf(storeEntries.get(cTile).getOwned())) * 2) - 5,  billPurchaseArea.y + (billPurchaseArea.height / 8) + (cTile * storeTile.getHeight()) + fm.getHeight() + 5);
			}
		}
		g2d.setColor(Color.WHITE);

		//Begin Text Region C
		g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		fm = g2d.getFontMetrics();
		g2d.drawString("Store", billPurchaseArea.x + (billPurchaseArea.width / 2) - (fm.stringWidth("Store") / 2), billPurchaseArea.y + fm.getAscent() + 15);

		//Begin Border Outline Region
		g2d.drawImage(vertSep, billClickerArea.x + billClickerArea.width - 16, billClickerArea.y, 16, billClickerArea.height, this);
		g2d.drawImage(horSep, billSupportArea.x, billSupportArea.y, billSupportArea.width, 16, this);
		g2d.drawImage(vertSep, billPurchaseArea.x, billPurchaseArea.y, 16, billPurchaseArea.height, this);

		//Begin Graphics FINALIZE Region
		Toolkit.getDefaultToolkit().sync();
		bs.show();
	}

	public class WorldTimer implements ActionListener, MouseListener {
		public Point cursorCoords;
		public boolean leftClick;
		private int time;
		private int statusTicks = 0;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//Begin Networking Region

			//Begin Game Drawing Region
			draw();

			//Begin Game Time Regions
			if (Calendar.getInstance().get(Calendar.SECOND) > time) {
				totalAppeal += appealPerSecond;
				statusTicks++;
				time = Calendar.getInstance().get(Calendar.SECOND);
			}

			//Begin Time Taking Region
			if (statusTicks == 6) {
				status = statusList[new Random().nextInt(statusList.length)];
				name = nameList[new Random().nextInt(nameList.length)];
				statusTicks = 0;
			}

			if (cursorCoords != null) {
				if (billClickerButton.contains(cursorCoords) && billClickerButtonMOD == 5) {
					if (leftClick) {
						billClickerButtonMOD = 0;
						floatingText.add(new FloatingText(String.valueOf(appealPerClick), cursorCoords));
						totalAppeal += appealPerClick;
					}
				}else if (billClickerButton.contains(cursorCoords) && billClickerButtonMOD < 5) {
					if (!leftClick) {
						billClickerButtonMOD += 1;
					}else {
						billClickerButtonMOD = 0;
					}
				}else if (!billClickerButton.contains(cursorCoords) && billClickerButtonMOD > 0){
					billClickerButtonMOD -= 1;
				}
				int totalOwned = 0;
				for (StoreTile s : storeEntries) {
					if (s.getLocation().contains(cursorCoords)) {
						s.setMouseOver(true);
						if (leftClick && totalAppeal >= s.getCost()) {
							totalAppeal -= s.getCost();
							s.buyItem();
						}
					}else {
						s.setMouseOver(false);
					}
					totalOwned += s.getOwned();
				}
				if (totalOwned > 2) {
					appealPerClick = totalOwned / 2;
				}else {
					appealPerClick = 1;
				}
			}

			for (int i = 0; i < floatingText.size(); i++) {
				FloatingText f = floatingText.get(i);
				if (f.isDone()) {
					floatingText.remove(i);
				}else {
					f.flutter();
				}
			}

			//Begin Appeal Population Region
			appealPerSecond = 0;
			for (StoreTile s : storeEntries) {
				appealPerSecond += (s.getAppeal() * s.getOwned());
			}

			cursorCoords = GameInterface.this.getMousePosition();	
			leftClick = false;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			if (arg0.getButton() == MouseEvent.BUTTON1) {
				leftClick = true;
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}
	}
}

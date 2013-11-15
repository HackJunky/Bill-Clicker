import java.util.ArrayList;

public class ServerModule {
	private String ip;
	private String username;
	private int port;
	private boolean isServer;
	
	private ArrayList<Object> networkObjects;
	
	private ArrayList<String> playerNames;
	
	private Thread[] serverThreads;
	private NetworkModule[] serverSockets;
	private int players = 0;
	
	public ServerModule(String ip, int port, String username) {
		isServer = true;
		this.ip = ip;
		this.port = port;
		this.username = username;
		serverThreads = new Thread[16];
		serverSockets = new NetworkModule[16];
		
		serverThreads[players] = new Thread(serverSockets[players] = new NetworkModule(true, ip, port, username));
		serverThreads[players].start();
	}
	
	public void tick() {
		if (serverSockets[players].isConnected()) {
			players++;
			port++;
			serverThreads[players] = new Thread(serverSockets[players] = new NetworkModule(true, ip, port, username));
			serverThreads[players].start();
		}
		playerNames = new ArrayList<String>();
		playerNames.add(serverSockets[0].getLocalName());
		for (int i = 0; i < players; i++) {
			playerNames.add(serverSockets[i].getRemoteName());
		}
		for (int i = 0; i < players; i++) {
			NetworkModule m = serverSockets[i];
			m.setRemotePlayers(playerNames);
		}
	}
	
	public NetworkModule[] getModules() {
		return serverSockets;
	}
	
	public void updateNetworkPacket(ArrayList<Object> a) {
		networkObjects = a;
		for (int i = 0; i <= players; i++) {
			serverSockets[i].setOutput(networkObjects);
		}
	}
	
	public int getPort() {
		return port;
	}
	
	public String[] getPlayers() {
		String[] s = new String[players + 1];
		s[0] = serverSockets[0].getLocalName();
		for (int i = 0; i < players; i++) {
			s[i + 1] = serverSockets[i].getRemoteName();
		}
		return s;
	}
	
	public ArrayList<Object>[] getClientOutput() {
		ArrayList<Object>[] group = (ArrayList<Object>[])new ArrayList[players];
		for (int i = 0; i <= players; i++) {
			group[i] = serverSockets[i].getInStream();
		}
		return group;
	}
	
	public String getIP() {
		return ip;
	}
}

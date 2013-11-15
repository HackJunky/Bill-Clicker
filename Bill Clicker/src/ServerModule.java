import java.util.ArrayList;

public class ServerModule {
	private String ip;
	private String username;
	private int port;
	
	private ArrayList<Object> networkObjects;
	
	private Thread[] serverThreads;
	private NetworkModule[] serverSockets;
	private int players = 0;
	
	public ServerModule(String ip, int port, String username) {
		this.ip = ip;
		this.port = port;
		this.username = username;
		serverThreads = new Thread[16];
		serverSockets = new NetworkModule[16];
		
		serverThreads[players] = new Thread(serverSockets[players] = new NetworkModule(true, ip, port, username));
		serverThreads[players].start();
	}
	
	public void updateNetworkPacket(ArrayList<Object> a) {
		networkObjects = a;
		for (int i = 0; i <= players; i++) {
			serverSockets[i].setOutput(networkObjects);
		}
	}
	
	public ArrayList<Object>[] getClientOutput() {
		ArrayList<Object>[] group = (ArrayList<Object>[])new ArrayList[players];
		for (int i = 0; i <= players; i++) {
			group[i] = serverSockets[i].getInStream();
		}
		return group;
	}
}

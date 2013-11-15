import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class NetworkModule implements Runnable {
	private boolean isServer;
	private String ip;
	private int port;
	private String username;
	private String remoteName;
	
	private ServerSocket serverSocket;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	private boolean terminated = false;
	private boolean connected = false;
	private int overhead = 0;

	private ArrayList<String> remotePlayers = new ArrayList<String>();
	
	private ArrayList<Object> input = new ArrayList<Object>();
	private ArrayList<Object> output = new ArrayList<Object>();
	
	public NetworkModule(boolean isServer, String ip, int port, String username) {
		this.isServer = isServer;
		this.ip = ip;
		this.port = port;
		this.username = username;
	}

	@Override
	public void run() {
		if (isServer) {
			if (!terminated) {
				try {
					try {
						serverSocket = new ServerSocket();
						serverSocket.bind(new InetSocketAddress(ip, port));
					} catch (IOException ex) {
						System.out.println("Server could not be created. " + ex.getMessage());
						return;
					}
					System.out.println("Waiting for connections...");
					socket = null;
					try {
						socket = serverSocket.accept();
					} catch (IOException ex) {
						System.out.println("The Socket could not be read.");
						return;
					}
					System.out.println("Connection created with Client (" + socket.getInetAddress() + ").");
					while (!terminated) {
						connected = socket.isConnected();
						if (out == null) {
							out = new ObjectOutputStream(socket.getOutputStream());
						}
						if (in == null) {
							in = new ObjectInputStream(socket.getInputStream());
						}
						//Read changes first
						remoteName = in.readUTF();
						input = (ArrayList<Object>)in.readObject();

						//Write changes back
						out.writeObject(output);
						out.writeObject(remotePlayers);
					}
				}catch (Exception ex) {
					if (!terminated) {
						if (ex.getMessage() != null) { 
							System.out.println(ex.getMessage());
							ex.printStackTrace();
						}else{
							ex.printStackTrace();
						}
						terminated = true;
					}
					try {
						out.flush();
					}catch (Exception e) {
						terminated = true;
					}
				}
			}
		}else {
			if (!terminated) {
				try {
					try {
						socket = new Socket(ip, port);
						System.out.println("Connection Established with Server (" + socket.getInetAddress() + ")");
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					while (!terminated) {
						connected = socket.isConnected();
						if (out == null) {
							out = new ObjectOutputStream(socket.getOutputStream());
						}
						if (in == null) {
							in = new ObjectInputStream(socket.getInputStream());
						}
						//Write changes first
						out.writeUTF(username);
						out.writeObject(output);

						//Read changes back
						input = (ArrayList<Object>)in.readObject();
						remotePlayers = (ArrayList<String>)in.readObject();
					}
				}catch (Exception ex) {
					if (!terminated) {
						if (ex.getMessage() != null) { 
							ex.printStackTrace();
						}else{
							ex.printStackTrace();
						}
						terminated = true;
					}
					try {
						out.flush();
					}catch (Exception e) {
						terminated = true;
					}
				}
			}
		}
	}
	
	public String getLocalName() {
		return username;
	}
	
	public String getRemoteName() {
		return remoteName;
	}
	
	public ArrayList<String> getRemotePlayers() {
		return remotePlayers;
	}
	
	public void setRemotePlayers(ArrayList<String> s) {
		remotePlayers = s;
	}
	
	public ArrayList<Object> getInStream() {
		return input;
	}
	
	public void setOutput(ArrayList<Object> a) {
		output = a;
	}
	
	public void kick() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("You have been kicked from the server");
	}

	public boolean isConnected() {
		return connected;
	}
	
	public String getIP() {
		return ip;
	}
}
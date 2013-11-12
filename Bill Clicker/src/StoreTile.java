import java.awt.Rectangle;


public class StoreTile {
	enum TileName {
		Public_Advertisers, Advanced_Adertisement, Partisan_Campaigns, House_Assists, Congress_Assists, Presidential_Assists
	};
	
	private TileName thisName;
	private int thisCost;
	private int thisAppeal;
	private float thisInflation;
	
	private int owned = 0;
	private Rectangle location = null;
	private boolean mouseOver = false;
	
	public StoreTile(TileName name, int cost, int appeal, float inflation) {
		thisName = name;
		thisCost = cost;
		thisAppeal = appeal;
		thisInflation = inflation;
	}
	
	public void buyItem() {
		owned++;
		thisCost = (int)(thisCost + (thisCost * thisInflation));
	}
	
	public void sellItem() {
		owned--;
		thisCost = (int)(thisCost - (thisCost * thisInflation));
		if (thisCost > 0) {
			thisCost = 100;
		}
	}
	
	public void setMouseOver(boolean b) {
		mouseOver = b;
	}
	
	public boolean isMouseOver() {
		return mouseOver;
	}
	
	public void setLocation(Rectangle r) {
		location = r;
	}
	
	public Rectangle getLocation() {
		return location;
	}
	
	public int getOwned() {
		return owned;
	}
	
	public String getName() {
		return thisName.toString();
	}
	
	public TileName getType() {
		return thisName;
	}
	
	public int getCost() {
		return thisCost;
	}
	
	public int getAppeal() {
		return thisAppeal;
	}
	
	public float getInflation() {
		return thisInflation;
	}
}

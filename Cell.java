package cell;

  public class Cell 
{
	private String name;
	private int pos,own=0;
	public Cell(String name, int pos) {
		this.name = name;
		this.pos = pos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPos() {
		return pos;
	}
	
	public String getType()
	{
		return "cell";
	}
	public void setOwn(int own) {}
	public int getOwn()
	{
		return 0;
	}
	 public int getPrice()
	 {
		 return 0;
	 }
	 public int getHouse()
	 {
		 return 0;
	 }
	 public void houseUpgrade() {}
	 public String toString()
	 {
		 String str="";
		 str+=name+"\n";
		 return str;
	 }
	 public int getCost()
	 {
		 return 0;
	 }
}

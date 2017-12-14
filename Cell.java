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
		/*Return the cell's name*/
		return name;
	}
	public void setName(String name) {
		/*Set the cell's name*/
		this.name = name;
	}
	public int getPos() {
		/*return the cell's position*/
		return pos;
	}
	
	public String getType()
	{
		/*Return the cell type*/
		return "cell";
	}
	public void setOwn(int own) {}
	public int getOwn()
	{
		/*return the owner*/
		return 0;
	}
	 public int getPrice()
	 {
		 /*return the cell's price*/
		 return 0;
	 }
	 public int getHouse()
	 {
		 /*return the cell's house number*/
		 return 0;
	 }
	 public void houseUpgrade() {}
	 public String toString()
	 {
		 /*return the cell infomation*/
		 String str="";
		 str+=name+"\n";
		 return str;
	 }
	 public int getCost()
	 {
		 /*return the rent cost*/
		 return 0;
	 }
	 public int getHousePrice()
	 {
		 /*return the cell's house price*/
		 return 0;
	 }
	 public int getHotelPrice()
	 {
		 /*return the cell's hotel price*/
		 return 0;
	 }
}

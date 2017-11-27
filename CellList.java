package cell;
import java.util.ArrayList;
public class CellList extends ArrayList<Cell>
{
	public CellList()
	{
		this.add(new Cell("GO",0));
		this.add(new Land("Tokyo",600,500,500,1));
//		this.add(new ("Community Chest",2));
		this.add(new Land("Seoul",600,500,500,3));
//		this.add(new Cell("Incom Tax",4));
		this.add(new Airport("HongKong Airport",2000,5));
		this.add(new Land("Shanghai",1000,500,500,6));
//		this.add(new Land("Chance",7));
		this.add(new Land("Taipei",1000,500,500,8));
		this.add(new Land("Sydney",1200,500,500,9));
//		this.add(new Land("Jail",10));
		this.add(new Land("Djakarta",1400,1000,1000,11));
		this.add(new Company("Electricity Company",1500,12));
		this.add(new Land("Mumbai",1400,1000,1000,13));
		this.add(new Land("Dubai",1600,1000,1000,14));
		this.add(new Airport("Singapor Airport",2000,15));
		this.add(new Land("Cairo",1800,1000,1000,16));
//		this.add(new Land("Community Chest",17));
		this.add(new Land("Istanbul",1800,1000,1000,18));
		this.add(new Land("Athens",2000,1000,1000,19));
		this.add(new Cell("Free Parking",20));
		this.add(new Land("Rome",2200,1500,1500,21));
//		this.add(new Land("Chance",22));
		this.add(new Land("Madrid",2200,1500,1500,23));
		this.add(new Land("Paris",2400,1500,1500,24));
		this.add(new Airport("Amsterdam Airport",2000,25));
		this.add(new Land("Berlin",2600,1500,1500,26));
		this.add(new Land("Moscow",2600,1500,1500,27));
		this.add(new Company("Water Works",1500,28));
		this.add(new Land("London",2800,1500,1500,29));
//		this.add(new Land("Go To Jail",30));
		this.add(new Land("Toronto",3000,2000,2000,31));
		this.add(new Land("Washington",3000,2000,2000,32));
//		this.add(new Land("Community Chest",33));
		this.add(new Land("New York",3200,2000,2000,34));
		this.add(new Airport("Chicago Airport",2000,35));
//		this.add(new Land("Chance",36));
		this.add(new Land("Mexico City",3500,2000,2000,37));
//		this.add(new Land("Tax on Luxury",38));
		this.add(new Land("Rio De Janeiro",4000,2000,2000,39));
	}
}

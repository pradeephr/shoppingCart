package beans;

public class OrderDetails {
   private  int itemId;
   private int quantity;
   private int price;
   private long cardNo; //ITEMID,QUANTITY,PRICE,CARDNO
   private String img;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	   
	@Override								//ID,COLOR,WIDTH,HEIGHT,MATERIAL,THICKNESS,IMG,COUNT,PRICE,TYPE
	public String toString(){
		return "OrderDetails{"+"id="+itemId+",img="+img+",quantity="+quantity+",price="+price+",cardNo="+cardNo+'}';
	}
}

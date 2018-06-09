package beans;

public class Item {
  private int id;
  private String color;          //ID,COLOR,WIDTH,HEIGHT,MATERIAL,THICKNESS,IMG,COUNT,PRICE,TYPE
  private int width;
  private int height;
  private String material;
  private int thickness;
  private String img;
  private int count;
  private int price;
  private String type;
        public Item(){
        	
        }
        public Item(Item item){
        	this.id=item.id;
        	this.color=item.color;
        	this.width=item.width;
        	this.height=item.height;
        	this.material=item.material;
        	this.thickness=item.thickness;
        	this.img=item.img;
        	this.count=item.count;
        	this.price=item.price;
        	this.type=item.type;
        }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public String getMaterial() {
			return material;
		}
		public void setMaterial(String material) {
			this.material = material;
		}
		public int getThickness() {
			return thickness;
		}
		public void setThickness(int thickness) {
			this.thickness = thickness;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		  
		@Override								//ID,COLOR,WIDTH,HEIGHT,MATERIAL,THICKNESS,IMG,COUNT,PRICE,TYPE
		public String toString(){
			return "Item{"+"id="+id+",color="+color+",width="+width+",height="+height+",material="+material+
					",thickness="+thickness+",img="+img+",count="+count+",price="+price+",type="+type+'}';
		}
}

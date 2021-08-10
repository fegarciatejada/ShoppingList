

public class Item implements Comparable<Item>{
   private String name; //product name
   private int quantity; //quantity
   private double unitPrice; //unit price

   public Item(String name, int quantity, double unitPrice){
      setName(name); 
      setQuantity(quantity); 
      setUnitPrice(unitPrice); 
   }

   public String getName(){
      return name;
   }
   public int getQuantity(){
      return quantity;
   }
   public double getUnitPrice(){
      return unitPrice;
   }
   public void setName(String name){
     
      if(name ==null || name.length()==0){
         throw new RuntimeException("null or empty String value is not allowed");
      }
      if(name.length()>50){
         name=name.substring(0, 50);
      }
      this.name = name;
   }
   public void setQuantity(int quantity){
      
      if(quantity<1 || quantity>100){
         quantity=1;
      }
      this.quantity = quantity;
   }
   public void setUnitPrice(double unitPrice){
      
      if(unitPrice<=0 || unitPrice>1000){
         unitPrice=0.99;
      }
      this.unitPrice = unitPrice;
   }
   public int compareTo(Item item){
      
      return name.toLowerCase().compareTo(item.getName().toLowerCase());
   }
   public double subtotal(){
      return quantity*unitPrice;
   }
   public String toString(){
      return String.format("%-50s%-5d$%.2f",name,quantity, quantity*unitPrice);
   }
}

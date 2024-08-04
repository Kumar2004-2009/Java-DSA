import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {
    public static class Item{
        int value;
        int weight;
        public String toString(){
            return value+" "+weight;
        }
    }
    private static class ItemComparator implements Comparator<Item>{
        public int compare(Item i1,Item i2){
            if((i1.value/i1.weight)<(i2.value/i2.weight)) return 1;
            else if((i1.value/i1.weight)>(i2.value/i2.weight)) return -1;
            else
                return 0;
        }
    }
    public static void main(String[] args) {
        List<Integer> value=List.of(60,100,150,120);
        List<Integer> weight=List.of(10,20,50,15);
        List<Item> itemList=new ArrayList<>();
        for(int i=0;i<value.size();i++){
            Item item=new Item();
            item.value=value.get(i);
            item.weight=weight.get(i);
            itemList.add(item);
        }
        itemList.sort(new ItemComparator());
        System.out.println(itemList);
        int W=30;
        int profit=0;
        for(int i=0;i<itemList.size() && W>0;i++){
            Item item=itemList.get(i);
            if(item.weight<=W){
                profit+=item.value;
                W-=item.weight;
            }
            else{
                profit+=(item.value)/(item.weight)*W;
                W=0;
            }
        }
        System.out.println(profit);
    }
}

import java.util.*;

public class MinChair {
    class Friend{
        int arr;
        int dep;
        int friendNumber;
        public Friend(int a, int d, int f){
            arr=a;
            dep=d;
            friendNumber=f;
        }
    }
    class Chair{
        int end;
        public Chair(int e){
            end=e;
        }
    }

    public static void main(String[] args) {
        int times[][]=new int[][]{{1,4},{2,3},{4,6}};
        int target=1;
        MinChair minChair=new MinChair();
        int i = minChair.smallestChair(times, target);
        System.out.println("chair:"+i);
    }
    public int smallestChair(int[][] times, int targetFriend) {
        List<Friend> friends=new ArrayList<>();
        int j=0;
        for(int time[]:times){
            friends.add(new Friend(time[0],time[1],j++));
        }
        Collections.sort(friends, new Comparator<Friend>() {
            public int compare(final Friend entry1,
                               final Friend entry2) {
                if (entry1.arr > entry2.arr)
                    return 1;
                else
                    return -1;
            }
        });
        Chair chairs[]=new Chair[times.length];
        for(int i=0;i<times.length;i++){
            chairs[i]=new Chair(-1);
        }
//        Arrays.fill(chairs,new Chair(-1));
        for(Friend f:friends){
            for(int i=0;i<times.length;i++){
                Chair c=chairs[i];
                if(c.end<=f.arr){
                    c.end=f.dep;
                    if(f.friendNumber==targetFriend)
                        return i;
                    break;
                }

            }
        }
        return -1;
    }
}

class IWrapper {
    int ans;

    public IWrapper(int ans) {
        this.ans = ans;
    }
}

public class IntegerWrapper {

    public static void main(String[] args) {
        Integer j = 3;
        IntegerWrapper integerWrapper = new IntegerWrapper();
        integerWrapper.update(j);
        System.out.println(j);
        ////
        IWrapper iWrapper = new IWrapper(3);
        integerWrapper.iUpdate(iWrapper);
        System.out.println(iWrapper.ans);
    }

    private void update(Integer i) {
        i = new Integer(4);
    }

    private void iUpdate(IWrapper i) {
        //i = new IWrapper(4);//does not work
        //i.ans++;//does work
        i.ans = 4;
    }
}

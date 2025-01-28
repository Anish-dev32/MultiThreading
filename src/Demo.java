public abstract class Demo implements Damo, Demon {
    public int val=32;

    Demo() {
    }

    @Override
    public boolean isDummy(int s) {
        return true;
    }

    /*@Override
    public void isCalledDummy() {
        System.out.println("used method");
    }*/
    public void getval(){
        System.out.println(valuee);
    }
    public abstract boolean isGood();
    public boolean isReallyGood(){
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        Demo other = (Demo) obj;
        return this.val == other.val;
    }

    static void fun(){
        Demo d = new Demo() {
            @Override
            public boolean isGood() {
                return false;
            }
        };
        boolean reallyGood = d.isReallyGood();
    }
    public static void main(String[] args) {
        Demo d1 = new Demo() {
            @Override
            public boolean isGood() {
                return false;
            }
        };
        d1.isReallyGood();
        Demo.fun();
        d1.isCalledDummy();
    }
}

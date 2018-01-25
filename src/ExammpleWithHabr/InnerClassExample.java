package ExammpleWithHabr;

public class InnerClassExample {
    private int myField;
    public class InnerClass {
        private int myField;
        public class InnerInnerClass {
            private int myField;
            public InnerInnerClass() {
                int i = InnerClassExample.InnerClass.InnerInnerClass.this.myField;
            }
        }
    }
}

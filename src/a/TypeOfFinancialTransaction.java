package a;

public enum TypeOfFinancialTransaction {
    REVENUE_TYPE(),
    EXPENSE_TYPE();

    public IContextMenuType getType() {
        return () -> "open";
    }
}

class t {
    public static void main(String[] args) {
        System.out.println(TypeOfFinancialTransaction.EXPENSE_TYPE);
        System.out.println(TypeOfFinancialTransaction.REVENUE_TYPE);

        System.out.println(TypeOfFinancialTransaction.REVENUE_TYPE.getType().getTypeName());
    }
}

//@FunctionalInterface
interface IContextMenuType {
    String getTypeName();
}
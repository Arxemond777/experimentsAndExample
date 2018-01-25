package _a._trash_0;

public class C
{
	public static void main(String[] args) {
		new B(5);
	}
}

class A
{
    void f() {
		System.out.println("A.f()");
	}

	A() {
		System.out.println("В construct РОДИТЕЛЯ еще нет init radius");
		f();

	}
}

class B extends A
{

	private int radius = 1;

	void f() {
		System.out.println("А CHILDREN уже есть");
		System.out.println("B radius =" + radius);
	}

	B(int r) {
		radius = r;
		System.out.println("B.f() radius =" + radius);
	}
}

package u19;

/**
 * Created by Marius Luding on 19.05.2017 for group 13
 */
    public class A {
        public void a() { System.out.println("a"); }
    }
    public class B extends A {
        public void b() { System.out.println("b"); }
    }
    public class C extends B {
        public void c() { System.out.println("c"); }
    }
    public class ABCMain {
        public static void main(String[] args) {
                 A a= new A();
                 B b= new B();
                 C c= new C();

                 a.a();
                 b.a();
                 c.a();

                 a.b();    //compilerfehler, da methode "b" nicht in A oder parent von A enthalten ist
                 b.b();
                 c.b();
                 a.c();    //compilerfehler, da methode "c" nicht in A oder parent von A enthalten ist
                 b.c();     //compilerfehler, da methode "c" nicht in B oder parent von B enthalten ist
                 c.c();

                 A x= new B();
                 x.a();
                 x.b();
                 x.c();

                 ((A)x).a();
                 ((B)x).b();
                 ((C)x).c();
        }
    }


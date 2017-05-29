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
                 b.a();    //impliziter Upcast
                 c.a();    //impliziter Upcast

                 a.b();    //compilerfehler, da methode "b" nicht in A oder parent von A enthalten ist
                 b.b();
                 c.b();    //impliziter Upcast
                 a.c();    //compilerfehler, da methode "c" nicht in A oder parent von A enthalten ist
                 b.c();    //compilerfehler, da methode "c" nicht in B oder parent von B enthalten ist
                 c.c();

                 A x= new B(); // impliziter Upcast
                 x.a();
                 x.b(); //compilerfehler, weil x nur die Methoden aus der statischen Klasse A kennt
                 x.c(); //compilerfehler, weil x nur die Methoden aus der statischen Klasse A kennt

                 ((A)x).a(); // == x.a(); weder Downcast noch Upcast
                 ((B)x).b(); // expliziter Downcast und ausführbar, weil der dynamische Typ von x B ist
                 ((C)x).c(); // zu weit gedowncastet, nur nach B downcastbar, daher Laufzeitfehler
        }

        /*

            Identifizieren Sie die Programmzeilen, die zu einem Compilerfehler führen.
            Erläutern Sie jeweils mit einem Satz, was die Ursache des Compilerfehlers ist.
            Identifizieren Sie die Programmzeilen, die zu einem Laufzeitfehler führen.
            Erläutern Sie jeweils mit einem Satz, was die Ursache des Laufzeitfehlers ist.
            Identifizieren Sie die Programmzeilen (wenn vorhanden), die einen expliziten Downcast enthalten.
            Identifizieren Sie die Programmzeilen (wenn vorhanden), die einen expliziten Upcast enthalten.
            Identifizieren Sie die Programmzeilen (wenn vorhanden), die einen impliziten Upcast enthalten.

         */
    }


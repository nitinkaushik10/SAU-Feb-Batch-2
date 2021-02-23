
package SingletonClass;

public class SingletonExample {

   private static SingletonExample singleton = new SingletonExample( );

   
   private SingletonExample() { }

   /* Static 'instance' method */
   public static SingletonExample getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
   protected static void demoMethod( ) {
      System.out.println("hi! I am Nitin Kaushik");
   }
   
    public static void main(String[] args) {
     SingletonExample tmp = SingletonExample.getInstance( );
      tmp.demoMethod( );
   }
}



  

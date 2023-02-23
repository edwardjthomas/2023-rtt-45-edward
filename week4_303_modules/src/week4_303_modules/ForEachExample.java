package week4_303_modules;

import java.util.ArrayList;
import java.util.List;
public class ForEachExample{ //original name of class was MyRunner

   public static void main (String[] args) {
      List<String> names = new ArrayList<String>();
       names.add("Larry");
       names. add ("Steve") ;
       names. add ("James") ;
       names.add ( "Conan") ;
       names.add ( "Ellen") ;
   
       names.stream().forEach(name -> {  System.out.println (name);  } );
   }
}


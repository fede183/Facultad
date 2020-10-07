package uba.algo3.ejemplotp;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import uba.algo3.Utils;


public class LinearPlateaoTest {


   @Test
   public void plateaoIntTest() {
      LinearPlateauFinderPrim pf = new LinearPlateauFinderPrim();
      assertEquals( 2, pf.run( new int[]{ 1, 2, 3, 4 }, new int[]{ 1, 2, 3, 4 } )   );
      
      
      assertEquals( 2, pf.run( Utils.parseArrayI( "1 2 3 4" ), Utils.parseArrayI( "1 2 3 4" ) )   );
      assertEquals( 3, pf.run( Utils.parseArrayI( "1 1 2 3 4" ), Utils.parseArrayI( "1 2 3 4" ) )   );
      assertEquals( 3, pf.run( Utils.parseArrayI( "1 2 3 4" ), Utils.parseArrayI( "1 1 2 3 4" ) ) );
      assertEquals( 2, pf.run( Utils.parseArrayI( "2 3 4" ), Utils.parseArrayI( "1 2 3 4" ) )   );
      assertEquals( 2, pf.run( Utils.parseArrayI( "1 2 3 4" ), Utils.parseArrayI( "2 3 4" ) )     );
      assertEquals( 3, pf.run( Utils.parseArrayI( "1 2 3 4 4" ), Utils.parseArrayI( "1 2 3 4" ) )   );
      assertEquals( 3, pf.run( Utils.parseArrayI( "1 2 3 4" ), Utils.parseArrayI( "1 2 3 4 4" ) ) );
      assertEquals( 3, pf.run( Utils.parseArrayI( "1 2 2 3 4" ), Utils.parseArrayI( "1 2 3 4" ) )   );
      assertEquals( 3, pf.run( Utils.parseArrayI( "1 2 3 4" ), Utils.parseArrayI( "1 2 2 3 4" ) ) );
      assertEquals( 2, pf.run( Utils.parseArrayI( "1" ), Utils.parseArrayI( "1 2 3 4" ) )   );
      assertEquals( 2, pf.run( Utils.parseArrayI( "1 2 3 4" ), Utils.parseArrayI( "1" ) )         );
      assertEquals( 1, pf.run( Utils.parseArrayI( "1" ), Utils.parseArrayI( "2 3 4" ) )     );
      assertEquals( 1, pf.run( Utils.parseArrayI( "2 3 4" ), Utils.parseArrayI( "1" ) )         );
      assertEquals( 1, pf.run( Utils.parseArrayI( "4" ), Utils.parseArrayI( "1 2 3" ) )     );
      assertEquals( 1, pf.run( Utils.parseArrayI( "1 2 3" ), Utils.parseArrayI( "4" ) )         );
      assertEquals( 2, pf.run( Utils.parseArrayI( "1 2 3 4" ), Utils.parseArrayI( "3" ) )         );
      assertEquals( 2, pf.run( Utils.parseArrayI( "3" ), Utils.parseArrayI( "1 2 3 4" ) )   );
      assertEquals( 1, pf.run( Utils.parseArrayI( "1 2 4" ), Utils.parseArrayI( "3" ) )         );
      assertEquals( 1, pf.run( Utils.parseArrayI( "3" ), Utils.parseArrayI( "1 2 4" ) )     );

   }
   
   @Test
   public void plateaoStreamTest() {
      LinearPlateauStreamFinder pf = new LinearPlateauStreamFinder();

      assertEquals( 2, pf.run( Arrays.asList( 1, 2, 3, 4 ), Arrays.asList( 1, 2, 3, 4 ) )  );

      assertEquals( 2, pf.run( Utils.parseVector( "1 2 3 4" ), Utils.parseVector( "1 2 3 4" ) )   );
      assertEquals( 3, pf.run( Utils.parseVector( "1 1 2 3 4" ), Utils.parseVector( "1 2 3 4" ) )   );
      assertEquals( 3, pf.run( Utils.parseVector( "1 2 3 4" ), Utils.parseVector( "1 1 2 3 4" ) ) );
      assertEquals( 2, pf.run( Utils.parseVector( "2 3 4" ), Utils.parseVector( "1 2 3 4" ) )   );
      assertEquals( 2, pf.run( Utils.parseVector( "1 2 3 4" ), Utils.parseVector( "2 3 4" ) )     );
      assertEquals( 3, pf.run( Utils.parseVector( "1 2 3 4 4" ), Utils.parseVector( "1 2 3 4" ) )   );
      assertEquals( 3, pf.run( Utils.parseVector( "1 2 3 4" ), Utils.parseVector( "1 2 3 4 4" ) ) );
      assertEquals( 3, pf.run( Utils.parseVector( "1 2 2 3 4" ), Utils.parseVector( "1 2 3 4" ) )   );
      assertEquals( 3, pf.run( Utils.parseVector( "1 2 3 4" ), Utils.parseVector( "1 2 2 3 4" ) ) );
      assertEquals( 2, pf.run( Utils.parseVector( "1" ), Utils.parseVector( "1 2 3 4" ) )   );
      assertEquals( 2, pf.run( Utils.parseVector( "1 2 3 4" ), Utils.parseVector( "1" ) )         );
      assertEquals( 1, pf.run( Utils.parseVector( "1" ), Utils.parseVector( "2 3 4" ) )     );
      assertEquals( 1, pf.run( Utils.parseVector( "2 3 4" ), Utils.parseVector( "1" ) )         );
      assertEquals( 1, pf.run( Utils.parseVector( "4" ), Utils.parseVector( "1 2 3" ) )     );
      assertEquals( 1, pf.run( Utils.parseVector( "1 2 3" ), Utils.parseVector( "4" ) )         );
      assertEquals( 2, pf.run( Utils.parseVector( "1 2 3 4" ), Utils.parseVector( "3" ) )         );
      assertEquals( 2, pf.run( Utils.parseVector( "3" ), Utils.parseVector( "1 2 3 4" ) )   );
      assertEquals( 1, pf.run( Utils.parseVector( "1 2 4" ), Utils.parseVector( "3" ) )         );
      assertEquals( 1, pf.run( Utils.parseVector( "3" ), Utils.parseVector( "1 2 4" ) )     );

   }

}
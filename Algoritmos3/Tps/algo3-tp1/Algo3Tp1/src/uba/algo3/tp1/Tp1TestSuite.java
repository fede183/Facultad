package uba.algo3.tp1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses(value = {
	TelegrafoFileTest.class,
	TelegrafoTestCorrectitud.class,
	AMediasFileTest.class,
	AMediasTestCorrectitud.class,
	GirlScoutsFileTest.class,
	RondaDistanceTest.class
})
@RunWith(Suite.class)
public class Tp1TestSuite {

}

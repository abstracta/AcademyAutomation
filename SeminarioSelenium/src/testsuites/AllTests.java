package testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.Test_Busqueda_1;
import tests.Test_Busqueda_2;
import tests.Test_busqueda_3;
import tests.Test_busqueda_4;
import tests.Test_busqueda_5;

@RunWith(Suite.class)
@SuiteClasses({
			Test_Busqueda_1.class,
			Test_Busqueda_2.class,
			Test_busqueda_3.class,
			Test_busqueda_4.class,
			Test_busqueda_5.class})
public class AllTests {

}

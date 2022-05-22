import org.junit.Test;
import static org.junit.Assert.*;

public class faen {

    @Test
    public void jævel(){

        String x = "Emil  ";

        assertEquals(x.trim(), x.replaceAll("[^a-zA-Z0-9]",""));
        //!name.trim().replaceAll("[^a-zA-Z0-9]","").equals(name.trim())
    }
}

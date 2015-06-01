package scmspain.karyon.restrouter;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;


public class PoorURIParameterParserTest extends TestCase {

    private PoorURIParameterParser parameterParser;

    @Before
    public void setUp(){

        this.parameterParser = new PoorURIParameterParser();

    }

    public void testURIWithOneParam() throws Exception {

        String pathUri = "/hello/{id}";
        String requestUri = "/hello/1";

        Map<String,String> paramsExpected = this.parameterParser.getParams(pathUri,requestUri);

        assertEquals(1,paramsExpected.size());
    }

    public void testURIWithOneParamShouldReturnParamId() throws Exception{

        String pathUri = "/hello/{id}";
        String requestUri = "/hello/1";

        HashMap<String,String> paramsExpected = (HashMap<String,String>) this.parameterParser.getParams(pathUri,requestUri);

        assertEquals("1",paramsExpected.get("id"));

    }

    public void testURIWithTwoParams() throws Exception{

        String pathUri = "/hello/{id}/ninja/{name}";
        String requestUri = "/hello/1/ninja/forlayo";

        Map<String,String> paramsExpected = this.parameterParser.getParams(pathUri,requestUri);

        assertEquals(2,paramsExpected.size());

    }

    public void testURIWithTwoParamsShouldReturnParamIdAndName() throws Exception{

        String pathUri = "/hello/{id}/ninja/{name}";
        String requestUri = "/hello/1/ninja/forlayo";

        HashMap<String,String> paramsExpected = (HashMap<String,String>) this.parameterParser.getParams(pathUri,requestUri);

        assertEquals("1",paramsExpected.get("id"));
        assertEquals("forlayo",paramsExpected.get("name"));

    }

    public void testURIWithNoParams() throws Exception{

        String pathUri = "/forlayo";
        String requestUri = "/forlayo";

        Map<String,String> paramsExpected = this.parameterParser.getParams(pathUri,requestUri);

        assertEquals(0,paramsExpected.size());
    }



    public void testGetUriRegex() throws Exception {

    }
}

package at.ac.tuwien.big.flagservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "FlagServiceImplService", targetNamespace = "http://flagservice.big.tuwien.ac.at/", wsdlLocation = "http://pephimon.big.tuwien.ac.at/FlagService/flagservice?wsdl")
public class FlagServiceImplService
    extends Service
{

    private final static URL FLAGSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(at.ac.tuwien.big.flagservice.FlagServiceImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = at.ac.tuwien.big.flagservice.FlagServiceImplService.class.getResource(".");
            url = new URL(baseUrl, "http://pephimon.big.tuwien.ac.at/FlagService/flagservice?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://pephimon.big.tuwien.ac.at/FlagService/flagservice?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        FLAGSERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public FlagServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FlagServiceImplService() {
        super(FLAGSERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://flagservice.big.tuwien.ac.at/", "FlagServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns FlagService
     */
    @WebEndpoint(name = "FlagServiceImplPort")
    public FlagService getFlagServiceImplPort() {
        return super.getPort(new QName("http://flagservice.big.tuwien.ac.at/", "FlagServiceImplPort"), FlagService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FlagService
     */
    @WebEndpoint(name = "FlagServiceImplPort")
    public FlagService getFlagServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://flagservice.big.tuwien.ac.at/", "FlagServiceImplPort"), FlagService.class, features);
    }

}

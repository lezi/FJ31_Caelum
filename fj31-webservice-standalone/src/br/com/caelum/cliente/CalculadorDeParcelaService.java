
package br.com.caelum.cliente;

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
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "CalculadorDeParcelaService", targetNamespace = "http://webservices.caelum.com.br/", wsdlLocation = "http://localhost:10000/CalculadorDeParcela?wsdl")
public class CalculadorDeParcelaService
    extends Service
{

    private final static URL CALCULADORDEPARCELASERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(br.com.caelum.cliente.CalculadorDeParcelaService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = br.com.caelum.cliente.CalculadorDeParcelaService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:10000/CalculadorDeParcela?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:10000/CalculadorDeParcela?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CALCULADORDEPARCELASERVICE_WSDL_LOCATION = url;
    }

    public CalculadorDeParcelaService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculadorDeParcelaService() {
        super(CALCULADORDEPARCELASERVICE_WSDL_LOCATION, new QName("http://webservices.caelum.com.br/", "CalculadorDeParcelaService"));
    }

    /**
     * 
     * @return
     *     returns CalculadorDeParcela
     */
    @WebEndpoint(name = "CalculadorDeParcelaPort")
    public CalculadorDeParcela getCalculadorDeParcelaPort() {
        return super.getPort(new QName("http://webservices.caelum.com.br/", "CalculadorDeParcelaPort"), CalculadorDeParcela.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalculadorDeParcela
     */
    @WebEndpoint(name = "CalculadorDeParcelaPort")
    public CalculadorDeParcela getCalculadorDeParcelaPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.caelum.com.br/", "CalculadorDeParcelaPort"), CalculadorDeParcela.class, features);
    }

}
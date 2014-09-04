
package client.matrix;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.matrix package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddServerResponse_QNAME = new QName("matrix.client", "addServerResponse");
    private final static QName _MultiplyMatricesResponse_QNAME = new QName("matrix.client", "multiplyMatricesResponse");
    private final static QName _MultiplyMatrices_QNAME = new QName("matrix.client", "multiplyMatrices");
    private final static QName _AddServer_QNAME = new QName("matrix.client", "addServer");
    private final static QName _InterruptedException_QNAME = new QName("matrix.client", "InterruptedException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.matrix
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddServerResponse }
     * 
     */
    public AddServerResponse createAddServerResponse() {
        return new AddServerResponse();
    }

    /**
     * Create an instance of {@link AddServer }
     * 
     */
    public AddServer createAddServer() {
        return new AddServer();
    }

    /**
     * Create an instance of {@link MultiplyMatricesResponse }
     * 
     */
    public MultiplyMatricesResponse createMultiplyMatricesResponse() {
        return new MultiplyMatricesResponse();
    }

    /**
     * Create an instance of {@link InterruptedException }
     * 
     */
    public InterruptedException createInterruptedException() {
        return new InterruptedException();
    }

    /**
     * Create an instance of {@link MultiplyMatrices }
     * 
     */
    public MultiplyMatrices createMultiplyMatrices() {
        return new MultiplyMatrices();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "matrix.client", name = "addServerResponse")
    public JAXBElement<AddServerResponse> createAddServerResponse(AddServerResponse value) {
        return new JAXBElement<AddServerResponse>(_AddServerResponse_QNAME, AddServerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplyMatricesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "matrix.client", name = "multiplyMatricesResponse")
    public JAXBElement<MultiplyMatricesResponse> createMultiplyMatricesResponse(MultiplyMatricesResponse value) {
        return new JAXBElement<MultiplyMatricesResponse>(_MultiplyMatricesResponse_QNAME, MultiplyMatricesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplyMatrices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "matrix.client", name = "multiplyMatrices")
    public JAXBElement<MultiplyMatrices> createMultiplyMatrices(MultiplyMatrices value) {
        return new JAXBElement<MultiplyMatrices>(_MultiplyMatrices_QNAME, MultiplyMatrices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddServer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "matrix.client", name = "addServer")
    public JAXBElement<AddServer> createAddServer(AddServer value) {
        return new JAXBElement<AddServer>(_AddServer_QNAME, AddServer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterruptedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "matrix.client", name = "InterruptedException")
    public JAXBElement<InterruptedException> createInterruptedException(InterruptedException value) {
        return new JAXBElement<InterruptedException>(_InterruptedException_QNAME, InterruptedException.class, null, value);
    }

}

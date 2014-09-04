
package matrix.multiply;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the matrix.multiply package. 
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

    private final static QName _InterruptedException_QNAME = new QName("multiply.matrix", "InterruptedException");
    private final static QName _GetPoolSize_QNAME = new QName("multiply.matrix", "getPoolSize");
    private final static QName _SetPoolSizeResponse_QNAME = new QName("multiply.matrix", "setPoolSizeResponse");
    private final static QName _ExecutionException_QNAME = new QName("multiply.matrix", "ExecutionException");
    private final static QName _Multiply_QNAME = new QName("multiply.matrix", "multiply");
    private final static QName _GetPoolSizeResponse_QNAME = new QName("multiply.matrix", "getPoolSizeResponse");
    private final static QName _MultiplyResponse_QNAME = new QName("multiply.matrix", "multiplyResponse");
    private final static QName _SetPoolSize_QNAME = new QName("multiply.matrix", "setPoolSize");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: matrix.multiply
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetPoolSize }
     * 
     */
    public SetPoolSize createSetPoolSize() {
        return new SetPoolSize();
    }

    /**
     * Create an instance of {@link MultiplyResponse }
     * 
     */
    public MultiplyResponse createMultiplyResponse() {
        return new MultiplyResponse();
    }

    /**
     * Create an instance of {@link GetPoolSizeResponse }
     * 
     */
    public GetPoolSizeResponse createGetPoolSizeResponse() {
        return new GetPoolSizeResponse();
    }

    /**
     * Create an instance of {@link GetPoolSize }
     * 
     */
    public GetPoolSize createGetPoolSize() {
        return new GetPoolSize();
    }

    /**
     * Create an instance of {@link Multiply }
     * 
     */
    public Multiply createMultiply() {
        return new Multiply();
    }

    /**
     * Create an instance of {@link ExecutionException }
     * 
     */
    public ExecutionException createExecutionException() {
        return new ExecutionException();
    }

    /**
     * Create an instance of {@link SetPoolSizeResponse }
     * 
     */
    public SetPoolSizeResponse createSetPoolSizeResponse() {
        return new SetPoolSizeResponse();
    }

    /**
     * Create an instance of {@link InterruptedException }
     * 
     */
    public InterruptedException createInterruptedException() {
        return new InterruptedException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterruptedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "multiply.matrix", name = "InterruptedException")
    public JAXBElement<InterruptedException> createInterruptedException(InterruptedException value) {
        return new JAXBElement<InterruptedException>(_InterruptedException_QNAME, InterruptedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPoolSize }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "multiply.matrix", name = "getPoolSize")
    public JAXBElement<GetPoolSize> createGetPoolSize(GetPoolSize value) {
        return new JAXBElement<GetPoolSize>(_GetPoolSize_QNAME, GetPoolSize.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPoolSizeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "multiply.matrix", name = "setPoolSizeResponse")
    public JAXBElement<SetPoolSizeResponse> createSetPoolSizeResponse(SetPoolSizeResponse value) {
        return new JAXBElement<SetPoolSizeResponse>(_SetPoolSizeResponse_QNAME, SetPoolSizeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecutionException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "multiply.matrix", name = "ExecutionException")
    public JAXBElement<ExecutionException> createExecutionException(ExecutionException value) {
        return new JAXBElement<ExecutionException>(_ExecutionException_QNAME, ExecutionException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multiply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "multiply.matrix", name = "multiply")
    public JAXBElement<Multiply> createMultiply(Multiply value) {
        return new JAXBElement<Multiply>(_Multiply_QNAME, Multiply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPoolSizeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "multiply.matrix", name = "getPoolSizeResponse")
    public JAXBElement<GetPoolSizeResponse> createGetPoolSizeResponse(GetPoolSizeResponse value) {
        return new JAXBElement<GetPoolSizeResponse>(_GetPoolSizeResponse_QNAME, GetPoolSizeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "multiply.matrix", name = "multiplyResponse")
    public JAXBElement<MultiplyResponse> createMultiplyResponse(MultiplyResponse value) {
        return new JAXBElement<MultiplyResponse>(_MultiplyResponse_QNAME, MultiplyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPoolSize }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "multiply.matrix", name = "setPoolSize")
    public JAXBElement<SetPoolSize> createSetPoolSize(SetPoolSize value) {
        return new JAXBElement<SetPoolSize>(_SetPoolSize_QNAME, SetPoolSize.class, null, value);
    }

}


package wscliente;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wscliente package. 
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

    private final static QName _Bye_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "bye");
    private final static QName _ByeResponse_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "byeResponse");
    private final static QName _GetEstudiante_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "getEstudiante");
    private final static QName _GetEstudiantePorMateria_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "getEstudiantePorMateria");
    private final static QName _GetEstudiantePorMateriaResponse_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "getEstudiantePorMateriaResponse");
    private final static QName _GetEstudianteResponse_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "getEstudianteResponse");
    private final static QName _GetMateria_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "getMateria");
    private final static QName _GetMateriaResponse_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "getMateriaResponse");
    private final static QName _GetMateriasPorEstudiante_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "getMateriasPorEstudiante");
    private final static QName _GetMateriasPorEstudianteResponse_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "getMateriasPorEstudianteResponse");
    private final static QName _Hello_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://ws.crudestudiantesws.carlos.com/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wscliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Bye }
     * 
     */
    public Bye createBye() {
        return new Bye();
    }

    /**
     * Create an instance of {@link ByeResponse }
     * 
     */
    public ByeResponse createByeResponse() {
        return new ByeResponse();
    }

    /**
     * Create an instance of {@link GetEstudiante }
     * 
     */
    public GetEstudiante createGetEstudiante() {
        return new GetEstudiante();
    }

    /**
     * Create an instance of {@link GetEstudiantePorMateria }
     * 
     */
    public GetEstudiantePorMateria createGetEstudiantePorMateria() {
        return new GetEstudiantePorMateria();
    }

    /**
     * Create an instance of {@link GetEstudiantePorMateriaResponse }
     * 
     */
    public GetEstudiantePorMateriaResponse createGetEstudiantePorMateriaResponse() {
        return new GetEstudiantePorMateriaResponse();
    }

    /**
     * Create an instance of {@link GetEstudianteResponse }
     * 
     */
    public GetEstudianteResponse createGetEstudianteResponse() {
        return new GetEstudianteResponse();
    }

    /**
     * Create an instance of {@link GetMateria }
     * 
     */
    public GetMateria createGetMateria() {
        return new GetMateria();
    }

    /**
     * Create an instance of {@link GetMateriaResponse }
     * 
     */
    public GetMateriaResponse createGetMateriaResponse() {
        return new GetMateriaResponse();
    }

    /**
     * Create an instance of {@link GetMateriasPorEstudiante }
     * 
     */
    public GetMateriasPorEstudiante createGetMateriasPorEstudiante() {
        return new GetMateriasPorEstudiante();
    }

    /**
     * Create an instance of {@link GetMateriasPorEstudianteResponse }
     * 
     */
    public GetMateriasPorEstudianteResponse createGetMateriasPorEstudianteResponse() {
        return new GetMateriasPorEstudianteResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Estudiante }
     * 
     */
    public Estudiante createEstudiante() {
        return new Estudiante();
    }

    /**
     * Create an instance of {@link Materia }
     * 
     */
    public Materia createMateria() {
        return new Materia();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bye }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Bye }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "bye")
    public JAXBElement<Bye> createBye(Bye value) {
        return new JAXBElement<Bye>(_Bye_QNAME, Bye.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ByeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ByeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "byeResponse")
    public JAXBElement<ByeResponse> createByeResponse(ByeResponse value) {
        return new JAXBElement<ByeResponse>(_ByeResponse_QNAME, ByeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEstudiante }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEstudiante }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "getEstudiante")
    public JAXBElement<GetEstudiante> createGetEstudiante(GetEstudiante value) {
        return new JAXBElement<GetEstudiante>(_GetEstudiante_QNAME, GetEstudiante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEstudiantePorMateria }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEstudiantePorMateria }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "getEstudiantePorMateria")
    public JAXBElement<GetEstudiantePorMateria> createGetEstudiantePorMateria(GetEstudiantePorMateria value) {
        return new JAXBElement<GetEstudiantePorMateria>(_GetEstudiantePorMateria_QNAME, GetEstudiantePorMateria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEstudiantePorMateriaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEstudiantePorMateriaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "getEstudiantePorMateriaResponse")
    public JAXBElement<GetEstudiantePorMateriaResponse> createGetEstudiantePorMateriaResponse(GetEstudiantePorMateriaResponse value) {
        return new JAXBElement<GetEstudiantePorMateriaResponse>(_GetEstudiantePorMateriaResponse_QNAME, GetEstudiantePorMateriaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEstudianteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEstudianteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "getEstudianteResponse")
    public JAXBElement<GetEstudianteResponse> createGetEstudianteResponse(GetEstudianteResponse value) {
        return new JAXBElement<GetEstudianteResponse>(_GetEstudianteResponse_QNAME, GetEstudianteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMateria }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMateria }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "getMateria")
    public JAXBElement<GetMateria> createGetMateria(GetMateria value) {
        return new JAXBElement<GetMateria>(_GetMateria_QNAME, GetMateria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMateriaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMateriaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "getMateriaResponse")
    public JAXBElement<GetMateriaResponse> createGetMateriaResponse(GetMateriaResponse value) {
        return new JAXBElement<GetMateriaResponse>(_GetMateriaResponse_QNAME, GetMateriaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMateriasPorEstudiante }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMateriasPorEstudiante }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "getMateriasPorEstudiante")
    public JAXBElement<GetMateriasPorEstudiante> createGetMateriasPorEstudiante(GetMateriasPorEstudiante value) {
        return new JAXBElement<GetMateriasPorEstudiante>(_GetMateriasPorEstudiante_QNAME, GetMateriasPorEstudiante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMateriasPorEstudianteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMateriasPorEstudianteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "getMateriasPorEstudianteResponse")
    public JAXBElement<GetMateriasPorEstudianteResponse> createGetMateriasPorEstudianteResponse(GetMateriasPorEstudianteResponse value) {
        return new JAXBElement<GetMateriasPorEstudianteResponse>(_GetMateriasPorEstudianteResponse_QNAME, GetMateriasPorEstudianteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.crudestudiantesws.carlos.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}

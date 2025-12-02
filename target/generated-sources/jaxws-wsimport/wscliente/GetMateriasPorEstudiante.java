
package wscliente;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getMateriasPorEstudiante complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getMateriasPorEstudiante"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idEstudiante" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMateriasPorEstudiante", propOrder = {
    "idEstudiante"
})
public class GetMateriasPorEstudiante {

    @XmlElement(namespace = "")
    protected int idEstudiante;

    /**
     * Obtiene el valor de la propiedad idEstudiante.
     * 
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * Define el valor de la propiedad idEstudiante.
     * 
     */
    public void setIdEstudiante(int value) {
        this.idEstudiante = value;
    }

}

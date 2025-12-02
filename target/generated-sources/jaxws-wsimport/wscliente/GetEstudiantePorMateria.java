
package wscliente;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getEstudiantePorMateria complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getEstudiantePorMateria"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idMateria" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEstudiantePorMateria", propOrder = {
    "idMateria"
})
public class GetEstudiantePorMateria {

    @XmlElement(namespace = "")
    protected int idMateria;

    /**
     * Obtiene el valor de la propiedad idMateria.
     * 
     */
    public int getIdMateria() {
        return idMateria;
    }

    /**
     * Define el valor de la propiedad idMateria.
     * 
     */
    public void setIdMateria(int value) {
        this.idMateria = value;
    }

}

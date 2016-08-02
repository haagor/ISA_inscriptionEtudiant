
package stubs.inscr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour afficheEtudiantsInParcoursResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="afficheEtudiantsInParcoursResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="afficherEtus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "afficheEtudiantsInParcoursResponse", propOrder = {
    "afficherEtus"
})
public class AfficheEtudiantsInParcoursResponse {

    protected String afficherEtus;

    /**
     * Obtient la valeur de la propriété afficherEtus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfficherEtus() {
        return afficherEtus;
    }

    /**
     * Définit la valeur de la propriété afficherEtus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfficherEtus(String value) {
        this.afficherEtus = value;
    }

}

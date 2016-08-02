
package stubs.inscr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour cours.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="cours">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EP5I9161"/>
 *     &lt;enumeration value="EP5I9193"/>
 *     &lt;enumeration value="EP5I9112"/>
 *     &lt;enumeration value="EP5EU301"/>
 *     &lt;enumeration value="EP5I9270"/>
 *     &lt;enumeration value="EP5I9212"/>
 *     &lt;enumeration value="EP5I9264"/>
 *     &lt;enumeration value="EP5I9262"/>
 *     &lt;enumeration value="EP5I9261"/>
 *     &lt;enumeration value="EP5I9xxx"/>
 *     &lt;enumeration value="EP5I9162"/>
 *     &lt;enumeration value="EP5I9106"/>
 *     &lt;enumeration value="EP5I9217"/>
 *     &lt;enumeration value="EPmultiPrerequis"/>
 *     &lt;enumeration value="EPmultiCorequis"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "cours")
@XmlEnum
public enum Cours {

    @XmlEnumValue("EP5I9161")
    EP_5_I_9161("EP5I9161"),
    @XmlEnumValue("EP5I9193")
    EP_5_I_9193("EP5I9193"),
    @XmlEnumValue("EP5I9112")
    EP_5_I_9112("EP5I9112"),
    @XmlEnumValue("EP5EU301")
    EP_5_EU_301("EP5EU301"),
    @XmlEnumValue("EP5I9270")
    EP_5_I_9270("EP5I9270"),
    @XmlEnumValue("EP5I9212")
    EP_5_I_9212("EP5I9212"),
    @XmlEnumValue("EP5I9264")
    EP_5_I_9264("EP5I9264"),
    @XmlEnumValue("EP5I9262")
    EP_5_I_9262("EP5I9262"),
    @XmlEnumValue("EP5I9261")
    EP_5_I_9261("EP5I9261"),
    @XmlEnumValue("EP5I9xxx")
    EP_5_I_9_XXX("EP5I9xxx"),
    @XmlEnumValue("EP5I9162")
    EP_5_I_9162("EP5I9162"),
    @XmlEnumValue("EP5I9106")
    EP_5_I_9106("EP5I9106"),
    @XmlEnumValue("EP5I9217")
    EP_5_I_9217("EP5I9217"),
    @XmlEnumValue("EPmultiPrerequis")
    E_PMULTI_PREREQUIS("EPmultiPrerequis"),
    @XmlEnumValue("EPmultiCorequis")
    E_PMULTI_COREQUIS("EPmultiCorequis");
    private final String value;

    Cours(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Cours fromValue(String v) {
        for (Cours c: Cours.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

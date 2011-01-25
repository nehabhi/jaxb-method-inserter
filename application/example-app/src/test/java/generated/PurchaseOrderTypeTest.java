package generated;

import java.io.File;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PurchaseOrderTypeTest extends TestCase {

    public PurchaseOrderTypeTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(PurchaseOrderTypeTest.class);
    }

    public void testGetTotalPrice() {
        try {
            PurchaseOrderType po = getPurchaseOrderType();
            BigDecimal totalPrice = po.getTotalPrice();
            BigDecimal expectedTotalPrice = new BigDecimal("188.93");

            assertEquals(totalPrice, expectedTotalPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGetTotalNumberOfItems() {
        try {
            PurchaseOrderType po = getPurchaseOrderType();
            int totalNumberOfItems = po.getTotalNumberOfItems();
            assertEquals(totalNumberOfItems, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PurchaseOrderType getPurchaseOrderType() throws JAXBException {
        String persistenceUnitName = "generated";

        JAXBContext context = JAXBContext.newInstance(persistenceUnitName);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        PurchaseOrderType po = (PurchaseOrderType) ((javax.xml.bind.JAXBElement) unmarshaller.unmarshal(new File("src/test/resources/po.xml"))).getValue();
        return po;
    }

}

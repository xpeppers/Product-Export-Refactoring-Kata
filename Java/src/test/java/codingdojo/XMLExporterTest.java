package codingdojo;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Collections.emptyList;

public class XMLExporterTest {

    @Test
    public void exportFull_OneOrder() {
        Collection<Order> orderList = new ArrayList<>();
        orderList.add(SampleModelObjects.RecentOrder);

        String result = XMLExporter.exportFull(orderList);

        Approvals.verifyXml(result);
    }

    @Test
    public void exportFull_ZeroOrders() {
        String result = XMLExporter.exportFull(emptyList());

        Approvals.verifyXml(result);
    }
}

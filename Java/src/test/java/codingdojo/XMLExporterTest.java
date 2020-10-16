package codingdojo;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static codingdojo.SampleModelObjects.*;
import static java.util.Collections.*;

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

    @Test
    public void exportFull_OrderWithNoEventProduct() {
        Product productWithNoEvent = CherryBloom;
        Order order = new Order("1234", Util.fromIsoDate("2018-09-01T00:00Z"),
                FlagshipStore, new Product[]{productWithNoEvent});
        String result = XMLExporter.exportFull(singletonList(order));

        Approvals.verifyXml(result);
    }
}

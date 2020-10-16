package codingdojo;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class XMLExporterTest {

    @Test
    public void exportFull_OneOrder() {
        Collection<Order> orderList = new ArrayList<>();
        orderList.add(SampleModelObjects.RecentOrder);

        String result = XMLExporter.exportFull(orderList);

        Approvals.verify(result);
    }

}

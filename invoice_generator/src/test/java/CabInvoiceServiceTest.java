import static org.junit.jupiter.api.Assertions.assertEquals;

import org.InvoiceGenerator;
import org.Ride;
import org.Summary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @BeforeEach
    public void setUp() throws Exception {
        this.invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void testFare() {
        int distance = 10;
        int time = 20;
        String type = "normal";
        double fare = invoiceGenerator.calculateFare(distance, time, type);
        assertEquals(120, fare);
    }

    @Test
    public void testMinFare() {
        int distance = 0;
        int time = 1;
        String type = "normal";
        double fare = invoiceGenerator.calculateFare(distance, time, type);
        assertEquals(5, fare);
    }

    @Test
    public void testPremiumFare() {
        int distance = 10;
        int time = 20;
        String type = "premium";
        double fare = invoiceGenerator.calculateFare(distance, time, type);
        assertEquals(190, fare);
    }

    @Test
    public void testMinPremiumFare() {
        int distance = 0;
        int time = 1;
        String type = "premium";
        double fare = invoiceGenerator.calculateFare(distance, time, type);
        assertEquals(20, fare);
    }

    @Test
    public void testFareForMultipleRides() {
        Ride rides[] = {
                new Ride(10, 20, "normal"),
                new Ride(0, 1, "normal"),
                new Ride(10, 20, "premium"),
                new Ride(0, 1, "premium")
        };
        double fare = invoiceGenerator.calculateMultipleRidesFare(rides);
        assertEquals(335, fare);
    }

    @Test
    public void testInvoiceSummary() {
        Ride rides[] = {
                new Ride(10, 20, "normal"),
                new Ride(1, 1, "normal")
        };
        Summary summary = new Summary();
        summary = invoiceGenerator.generateInvoiceSummary(rides);
        Summary expectedSummary = new Summary(2, 131, 65.5);
        assertEquals(expectedSummary, summary);
    }

    @Test
    public void testInvoiceSummaryWithUserId() {
        String userID = "test_user";
        Ride rides[] = {
                new Ride(10, 20, "normal"),
                new Ride(1, 1, "normal")
        };
        Summary summary = new Summary();
        invoiceGenerator.addRides(userID, rides);
        summary = invoiceGenerator.getInvoiceSummary(userID);
        Summary expectedSummary = new Summary(2, 131, 65.5);
        assertEquals(expectedSummary, summary);

    }

}

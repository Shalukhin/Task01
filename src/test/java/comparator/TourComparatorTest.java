package comparator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import entity.Cruise;
import entity.Recovery;
import entity.Relaxation;
import entity.TypeOfTransportation;

public class TourComparatorTest {
	
	private Cruise cruise = new Cruise(5, TypeOfTransportation.AIR, false, BigDecimal.valueOf(565.5), "ower world");
	private Relaxation relaxation = new Relaxation(30, TypeOfTransportation.REAL, true, BigDecimal.valueOf(1000), "Uhan");
	private Recovery recovery  = new Recovery(30, TypeOfTransportation.REAL, true, BigDecimal.valueOf(1000), "Belarus");
	
	@Test
	public void testAmountDayIncreaseCompareDifferentTours() {
		int expected = 1;
		assertEquals(expected, TourComparator.AMOUNT_DAY_INCREASE.compare(relaxation, cruise));
	}
	
	@Test
	public void testAmountDayIncreaseCompareEquelTours() {
		int expected = 0;
		assertEquals(expected, TourComparator.AMOUNT_DAY_INCREASE.compare(relaxation, recovery));
	}
	
	@Test
	public void testPriceIncreaseCompareDifferentTours() {
		int expected = -1;
		assertEquals(expected, TourComparator.PRICE_INCREASE.compare(cruise, relaxation));
	}
	
	@Test
	public void testPriceIncreaseCompareeEquelTours() {
		int expected = 0;
		assertEquals(expected, TourComparator.PRICE_INCREASE.compare(relaxation, recovery));
	}

}

package com.octoperf.metrics.utils;

import org.junit.Test;

import static com.octoperf.metrics.utils.DataUnitIEC.GIBIS;
import static com.octoperf.metrics.utils.DataUnitIEC.KIBIS;
import static com.octoperf.metrics.utils.DataUnitIEC.MEBIS;
import static com.octoperf.metrics.utils.DataUnitIEC.UNIT;
import static org.junit.Assert.assertEquals;

public class DataUnitIECTest {

	private static final long VALUE = 1024;

	@Test
	public void shouldPassXTest() {
		assertEquals(Long.MAX_VALUE, DataUnitIEC.x(1L, 0L, 0L));
		assertEquals(Long.MIN_VALUE, DataUnitIEC.x(-1L, 0L, 0L));
	}

	@Test
	public void shouldReturnGibis() {
		assertEquals(0, UNIT.toGibis(VALUE));
		assertEquals(0, KIBIS.toGibis(VALUE));
		assertEquals(1, MEBIS.toGibis(VALUE));
		assertEquals(VALUE, GIBIS.toGibis(VALUE));
	}

	@Test
	public void shouldConvertToGibis() {
		assertEquals(0, GIBIS.convert(VALUE, UNIT));
		assertEquals(0, GIBIS.convert(VALUE, KIBIS));
		assertEquals(1, GIBIS.convert(VALUE, MEBIS));
		assertEquals(VALUE, GIBIS.convert(VALUE, GIBIS));
	}

	@Test
	public void shouldReturnMebis() {
		assertEquals(0, UNIT.toMebis(VALUE));
		assertEquals(1, KIBIS.toMebis(VALUE));
		assertEquals(VALUE, MEBIS.toMebis(VALUE));
		assertEquals(VALUE * VALUE, GIBIS.toMebis(VALUE));
	}

	@Test
	public void shouldConvertToMebis() {
		assertEquals(0, MEBIS.convert(VALUE, UNIT));
		assertEquals(1, MEBIS.convert(VALUE, KIBIS));
		assertEquals(VALUE, MEBIS.convert(VALUE, MEBIS));
		assertEquals(VALUE * VALUE, MEBIS.convert(VALUE, GIBIS));
	}

	@Test
	public void shouldReturnKibis() {
		assertEquals(1, UNIT.toKibis(VALUE));
		assertEquals(VALUE, KIBIS.toKibis(VALUE));
		assertEquals(VALUE * VALUE, MEBIS.toKibis(VALUE));
		assertEquals(VALUE * VALUE * VALUE, GIBIS.toKibis(VALUE));
	}

	@Test
	public void shouldConvertToKibis() {
		assertEquals(1, KIBIS.convert(VALUE, UNIT));
		assertEquals(VALUE, KIBIS.convert(VALUE, KIBIS));
		assertEquals(VALUE * VALUE, KIBIS.convert(VALUE, MEBIS));
		assertEquals(VALUE * VALUE * VALUE, KIBIS.convert(VALUE, GIBIS));
	}

	@Test
	public void shouldReturnUnits() {
		assertEquals(VALUE, UNIT.toUnit(VALUE));
		assertEquals(VALUE * VALUE, KIBIS.toUnit(VALUE));
		assertEquals(VALUE * VALUE * VALUE, MEBIS.toUnit(VALUE));
		assertEquals(VALUE * VALUE * VALUE * VALUE, GIBIS.toUnit(VALUE));
	}

	@Test
	public void shouldConvertToUnits() {
		assertEquals(VALUE, UNIT.convert(VALUE, UNIT));
		assertEquals(VALUE * VALUE, UNIT.convert(VALUE, KIBIS));
		assertEquals(VALUE * VALUE * VALUE, UNIT.convert(VALUE, MEBIS));
		assertEquals(VALUE * VALUE * VALUE * VALUE, UNIT.convert(VALUE, GIBIS));
	}
}


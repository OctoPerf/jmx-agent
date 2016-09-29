package com.octoperf.metrics.utils;


/**
 * A <tt>DataUnitIEC</tt> represents data in IEC standard at a given unit of
 * granularity and provides utility methods to convert across units,
 * and to perform timing and delay operations in these units. A
 * <tt>DataUnitIEC</tt> does not maintain data information, but only
 * helps organize and use data representations that may be maintained
 * separately across various contexts.
 *
 * @author Jerome Loisel
 */
public enum DataUnitIEC {
	UNIT {
		@Override
		public long toUnit(final long d)   {
			return d;
		}
		@Override
		public long toKibis(final long d)  {
			return d/(C1/C0);
		}
		@Override
		public long toMebis(final long d)  {
			return d/(C2/C0);
		}
		@Override
		public long toGibis(final long d) {
			return d/(C3/C0);
		}
		@Override
		public long convert(final long d, final DataUnitIEC u) {
			return u.toUnit(d);
		}
	},
	KIBIS {
		@Override
		public long toUnit(final long d)   {
			return x(d, C1/C0, MAX/(C1/C0));
		}
		@Override
		public long toKibis(final long d) {
			return d;
		}
		@Override
		public long toMebis(final long d)  {
			return d/(C2/C1);
		}
		@Override
		public long toGibis(final long d) {
			return d/(C3/C1);
		}
		@Override
		public long convert(final long d, final DataUnitIEC u) {
			return u.toKibis(d);
		}
	},
	MEBIS {

		@Override
		public long toUnit(final long d)   {
			return x(d, C2/C0, MAX/(C2/C0));
		}
		@Override
		public long toKibis(final long d)  {
			return x(d, C2/C1, MAX/(C2/C1));
		}
		@Override
		public long toMebis(final long d)  {
			return d;
		}
		@Override
		public long toGibis(final long d) {
			return d/(C3/C2);
		}

		@Override
		public long convert(final long d, final DataUnitIEC u) {
			return u.toMebis(d);
		}
	},
	GIBIS { // NOSONAR

		@Override
		public long toUnit(final long d) {
			return x(d, C3 / C0, MAX / (C3 / C0));
		}

		@Override
		public long toKibis(final long d) {
			return x(d, C3 / C1, MAX / (C3 / C1));
		}

		@Override
		public long toMebis(final long d) {
			return x(d, C3 / C2, MAX / (C3 / C2));
		}

		@Override
		public long toGibis(final long d) {
			return d;
		}

		@Override
		public long convert(final long d, final DataUnitIEC u) {
			return u.toGibis(d);
		}
	};

	static final long C0 = 1L;
	static final long C1 = C0 * 1024L;
	static final long C2 = C1 * 1024L;
	static final long C3 = C2 * 1024L;
	static final long C4 = C3 * 1024L;
	static final long MAX = Long.MAX_VALUE;

	/**
	 * Equivalent to <tt>BIS.convert(duration, this)</tt>.
	 * @param data the data
	 * @return the converted data,
	 * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
	 * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
	 * @see #convert
	 */
	public abstract long toUnit(final long d);

	/**
	 * Equivalent to <tt>KIBIS.convert(duration, this)</tt>.
	 * @param data the data
	 * @return the converted data,
	 * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
	 * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
	 * @see #convert
	 */
	public abstract long toKibis(final long d);

	/**
	 * Equivalent to <tt>MEBIS.convert(duration, this)</tt>.
	 * @param data the data
	 * @return the converted data,
	 * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
	 * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
	 * @see #convert
	 */
	public abstract long toMebis(final long d);

	/**
	 * Equivalent to <tt>GIBIS.convert(duration, this)</tt>.
	 * @param data the data
	 * @return the converted data,
	 * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
	 * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
	 * @see #convert
	 */
	public abstract long toGibis(final long d);

	/**
	 * Scale d by m, checking for overflow.
	 * This has a short name to make above code more readable.
	 */
	static long x(final long d, final long m, final long over) {
		if (d >  over) {
			return Long.MAX_VALUE;
		}
		if (d < -over) {
			return Long.MIN_VALUE;
		}
		return d * m;
	}

	/**
	 * Convert the given data unit in the given unit to this
	 * unit.  Conversions from finer to coarser granularities
	 * truncate, so lose precision. For example converting
	 * <tt>999</tt> bis to kibis results in
	 * <tt>0</tt>. Conversions from coarser to finer granularities
	 * with arguments that would numerically overflow saturate to
	 * <tt>Long.MIN_VALUE</tt> if negative or <tt>Long.MAX_VALUE</tt>
	 * if positive.
	 *
	 * <p>For example, to convert 10 minutes to milliseconds, use:
	 * <tt>DataUnitIEC.UNIT.convert(10L, DataUnitIEC.KIBI)</tt>
	 *
	 * @param sourceData the data in the given <tt>sourceUnit</tt>
	 * @param sourceUnit the unit of the <tt>sourceData</tt> argument
	 * @return the converted data in this unit,
	 * or <tt>Long.MIN_VALUE</tt> if conversion would negatively
	 * overflow, or <tt>Long.MAX_VALUE</tt> if it would positively overflow.
	 */
	public abstract long convert(final long d, final DataUnitIEC u);
}

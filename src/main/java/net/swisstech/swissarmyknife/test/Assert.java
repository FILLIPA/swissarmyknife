package net.swisstech.swissarmyknife.test;

import java.util.Collection;
import java.util.Map;

/** Assert methods that don't exist anywhere else */
public final class Assert {

	/** private constructor for utility class */
	private Assert() {}

	public static void assertInstanceOf(Class<?> expected, Object actualObject) {
		if (!expected.isAssignableFrom(actualObject.getClass())) {
			String msg = String.format("Expected class is %s but got %s", expected, actualObject.getClass());
			throw new AssertionError(msg);
		}
	}

	public static <T> void assertSize(T[] c, int size) {
		if (c.length != size) {
			String msg = String.format("Expected array size to be %d but contained %d elements", size, c.length);
			throw new AssertionError(msg);
		}
	}

	public static <T> void assertSize(Collection<T> c, int size) {
		int actual = c.size();
		if (actual != size) {
			String msg = String.format("Expected collection size to be %d but contained %d elements", size, actual);
			throw new AssertionError(msg);
		}
	}

	public static <K, V> void assertSize(Map<K, V> map, int size) {
		int actual = map.size();
		if (actual != size) {
			String msg = String.format("Expected map size to be %d but contained %d elements", size, actual);
			throw new AssertionError(msg);
		}
	}

	public static <T> void assertSizeMin(Collection<T> c, int minSize) {
		int actual = c.size();
		if (actual < minSize) {
			String msg = String.format("Expected minimal collection size to be %d but contained %d elements", minSize, actual);
			throw new AssertionError(msg);
		}
	}

	public static <T> void assertEmpty(T[] c) {
		if (c.length != 0) {
			String msg = String.format("Expected array to be empty but contained %d elements", c.length);
			throw new AssertionError(msg);
		}
	}

	public static <T> void assertEmpty(Collection<T> c) {
		if (c.size() != 0) {
			String msg = String.format("Expected collection to be empty but contained %d elements", c.size());
			throw new AssertionError(msg);
		}
	}

	public static <K, V> void assertEmpty(Map<K, V> m) {
		if (m.size() != 0) {
			String msg = String.format("Expected map to be empty but contained %d elements", m.size());
			throw new AssertionError(msg);
		}
	}

	public static void assertSmallerThan(double smaller, double larger) {
		if (smaller >= larger) {
			String msg = String.format("Excpected %f to be smaller than %f", smaller, larger);
			throw new AssertionError(msg);
		}
	}

	public static void assertEmpty(String string) {
		if (!"".equals(string)) {
			String msg = String.format("Expected String to be empty but got '%s'", string);
			throw new AssertionError(msg);
		}
	}

	public static void assertHammingDistanceLowerEqual(int x, int y, int maxHmmingDistance) {
		if (calcHammingDistance(x, y) > maxHmmingDistance) {
			String msg = String.format("Expected hamming distance of %d and %d to be smaller or equal %d, but is %d", x, y, maxHmmingDistance, calcHammingDistance(x, y));
			throw new AssertionError(msg);
		}
	}

	public static <E> void assertCollectionContains(Collection<E> collection, E element) {
		if (!collection.contains(element)) {
			String msg = String.format("Expected collection to contain element %s but found %d other elements", element, collection.size());
			throw new AssertionError(msg);
		}
	}

	public static <E> void assertCollectionContainsAll(Collection<E> collection, Collection<E> elements) {
		if (!collection.containsAll(elements)) {
			String msg = String.format("Expected collection to contain all %d elements", elements.size());
			throw new AssertionError(msg);
		}
	}

	private static int calcHammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}
}

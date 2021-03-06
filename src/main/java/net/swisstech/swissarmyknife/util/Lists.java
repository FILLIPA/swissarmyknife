package net.swisstech.swissarmyknife.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * list utils we've been missing from guava and jdk standart apis
 * @since 1.1.7
 */
public class Lists {

	/** private constructor for utility class */
	private Lists() {}

	public static <T> List<T> newArrayList(T... items) {
		List<T> list = new ArrayList<>();
		return addAll(list, items);
	}

	public static <T> List<T> newLinkedList(T... items) {
		List<T> list = new LinkedList<>();
		return addAll(list, items);
	}

	public static <T> List<T> addAll(List<T> list, T... items) {
		List<T> itemlist = Arrays.asList(items);
		list.addAll(itemlist);
		return list;
	}
}

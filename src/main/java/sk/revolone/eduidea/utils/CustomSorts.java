package sk.revolone.eduidea.utils;

import org.springframework.data.domain.Sort;

public class CustomSorts {
	public static Sort sortByDateCreatedDesc() {
		return new Sort(Sort.Direction.DESC, "dateCreated");
	}
	
	public static Sort sortByNameAsc() {
		return new Sort(Sort.Direction.ASC, "name");
	}
}

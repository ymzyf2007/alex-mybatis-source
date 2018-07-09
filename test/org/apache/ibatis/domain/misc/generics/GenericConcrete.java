package org.apache.ibatis.domain.misc.generics;

public class GenericConcrete extends GenericSubclass implements GenericInterface<Long> {
	
	private Long id;

	@Override
	protected Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setId(String id) {
		this.id = Long.valueOf(id);
	}

	public void setId(Integer id) {
		this.id = (long) id;
	}

}
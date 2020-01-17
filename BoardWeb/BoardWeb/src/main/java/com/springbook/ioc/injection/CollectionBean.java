package com.springbook.ioc.injection;

import java.util.List;

public class CollectionBean {
	private List<String> addressList;  //private이라서 겟빈 안되고 겟함수 따로한다. 조건따라 반납. 
	public void setAddressList(List<String> addressList) {  //세터주입. 의존성 있으니 xml가자.
		this.addressList=addressList;
	}
	public List<String> getAddressList(){
		return addressList;
	}
}

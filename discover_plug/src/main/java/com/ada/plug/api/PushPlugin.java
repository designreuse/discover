package com.ada.plug.api;

import com.ada.plug.data.vo.PushBack;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Map;

public abstract class PushPlugin extends IPlugin{

	
	/**
	 * 给所有人推送消息
	 * @param msg 消息
	 * @return
	 */
	public abstract PushBack pushAll(String msg, Map<String,String> keys);

	public abstract PushBack pushToSingleDevice(String chanel,String msg,Map<String,String> keys);
	
	public abstract PushBack pushToTag(String tag,String msg,Map<String,String> keys);
	
	
	public abstract PushBack pushToChannels(String[] chanels,String msg,Map<String,String> keys);


	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		StoragePlugin other = (StoragePlugin) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}

}

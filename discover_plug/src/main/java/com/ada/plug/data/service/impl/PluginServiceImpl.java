/*
 * 
 * 
 * 
 */
package com.ada.plug.data.service.impl;

import com.ada.plug.api.PushPlugin;
import com.ada.plug.api.SendCodePlugin;
import com.ada.plug.api.StoragePlugin;
import com.ada.plug.data.service.PluginService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Service - 插件
 * 
 * 
 * 
 */
@Service("pluginServiceImpl")
public class PluginServiceImpl implements PluginService {

	@Resource
	private List<PushPlugin> paymentPlugins = new ArrayList<PushPlugin>();
	@Resource
	private List<StoragePlugin> storagePlugins = new ArrayList<StoragePlugin>();

	@Resource
	private List<SendCodePlugin> senCodePlugins = new ArrayList<SendCodePlugin>();

	@Resource
	private Map<String, PushPlugin> paymentPluginMap = new HashMap<String, PushPlugin>();

	@Resource
	private Map<String, StoragePlugin> storagePluginMap = new HashMap<String, StoragePlugin>();



	@Resource
	private Map<String, SendCodePlugin> sendCodePluginMap = new HashMap<String, SendCodePlugin>();

	public List<PushPlugin> getPushPlugins() {
		Collections.sort(paymentPlugins);
		return paymentPlugins;
	}

	public List<StoragePlugin> getStoragePlugins() {
		Collections.sort(storagePlugins);
		return storagePlugins;
	}

	@Override
	public List<SendCodePlugin> getSendCodePlugins() {
		Collections.sort(senCodePlugins);
		return senCodePlugins;
	}

	public List<PushPlugin> getPushPlugins(final boolean isEnabled) {
		List<PushPlugin> result = new ArrayList<PushPlugin>();
		CollectionUtils.select(paymentPlugins, new Predicate() {
			public boolean evaluate(Object object) {
				PushPlugin paymentPlugin = (PushPlugin) object;
				return paymentPlugin.getIsEnabled() == isEnabled;
			}
		}, result);
		Collections.sort(result);
		return result;
	}

	public List<StoragePlugin> getStoragePlugins(final boolean isEnabled) {
		List<StoragePlugin> result = new ArrayList<StoragePlugin>();
		CollectionUtils.select(storagePlugins, new Predicate() {
			public boolean evaluate(Object object) {
				StoragePlugin storagePlugin = (StoragePlugin) object;
				return storagePlugin.getIsEnabled() == isEnabled;
			}
		}, result);
		Collections.sort(result);
		return result;
	}

	@Override
	public List<SendCodePlugin> getSendCodePlugins(final boolean isEnabled) {
		List<SendCodePlugin> result = new ArrayList<SendCodePlugin>();
		CollectionUtils.select(senCodePlugins, new Predicate() {
			public boolean evaluate(Object object) {
				SendCodePlugin storagePlugin = (SendCodePlugin) object;
				return storagePlugin.getIsEnabled() == isEnabled;
			}
		}, result);
		Collections.sort(result);
		return result;	}

	public PushPlugin getPushPlugin(String id) {
		return paymentPluginMap.get(id);
	}

	public StoragePlugin getStoragePlugin(String id) {
		return storagePluginMap.get(id);
	}

	@Override
	public SendCodePlugin getSendCodePlugin(String id) {
		return sendCodePluginMap.get(id);
	}

}
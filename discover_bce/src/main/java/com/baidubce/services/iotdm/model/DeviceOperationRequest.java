/*
 * Copyright 2016 Baidu, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.baidubce.services.iotdm.model;

import java.util.List;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;

public class DeviceOperationRequest extends AbstractBceRequest {

    private String condition;
    private List<String> devices;

    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public List<String> getDevices() {
        return devices;
    }
    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    public DeviceOperationRequest withCondition(String condition) {
        setCondition(condition);
        return this;
    }
    public DeviceOperationRequest withDevices(List<String> devices) {
        setDevices(devices);
        return this;
    }

    @Override
    public DeviceOperationRequest withRequestCredentials(BceCredentials credentials) {
        this.setRequestCredentials(credentials);
        return this;
    }

}

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
package com.baidubce.services.iothub.model;

import java.util.List;

/**
 * Represent the create permission request.
 */
public class CreatePermissionRequest extends BaseRequest {

    private String policyName;

    private List<Operation> operations;

    private String topic;

    public  CreatePermissionRequest withPolicyName(String policyName) {
        this.policyName = policyName;
        return this;
    }

    public  CreatePermissionRequest withOperations(List<Operation> operations) {
        this.operations = operations;
        return this;
    }

    public  CreatePermissionRequest withTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public CreatePermissionRequest withEndpointName(String endpointName) {
        this.setEndpointName(endpointName);
        return this;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

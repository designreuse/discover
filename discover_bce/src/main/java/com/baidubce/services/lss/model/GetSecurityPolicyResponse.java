/*
 * Copyright 2015 Baidu, Inc.
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

package com.baidubce.services.lss.model;

import com.baidubce.model.AbstractBceResponse;

public class GetSecurityPolicyResponse  extends AbstractBceResponse {
    private String name = null;

    private AuthInfo auth = null;

    private AntiLeech antiLeech = null;

    private Encryption encryption = null;

    private String createTime = null;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthInfo getAuth() {
        return auth;
    }

    public void setAuth(AuthInfo auth) {
        this.auth = auth;
    }

    public AntiLeech getAntiLeech() {
        return antiLeech;
    }

    public void setAntiLeech(AntiLeech antiLeech) {
        this.antiLeech = antiLeech;
    }

    public Encryption getEncryption() {
        return encryption;
    }

    public void setEncryption(Encryption encryption) {
        this.encryption = encryption;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class GetSecurityPolicyResponse {\n");
        sb.append("    name: ").append(name).append("\n");
        sb.append("    auth: ").append(auth).append("\n");
        sb.append("    antiLeech: ").append(antiLeech).append("\n");
        sb.append("    encryption: ").append(encryption).append("\n");
        sb.append("    createTime: ").append(createTime).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}

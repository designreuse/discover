package com.ada.discover.pay.weixin.api;

import com.ada.discover.pay.weixin.domain.UnifiedOrderPayBack;
import com.ada.discover.pay.weixin.domain.UnifiedOrderPayData;

public interface PayService {

    UnifiedOrderPayBack order(UnifiedOrderPayData data);
}

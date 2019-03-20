package com.sensetime.accessibilitydemo;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * @author qinhaihang_vendor
 * @version $Rev$
 * @time 2019/3/20 20:02
 * @des
 * @packgename com.sensetime.accessibilitydemo
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes
 */
public class MyAccessibility extends AccessibilityService {

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        AccessibilityNodeInfo source = event.getSource();
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();

        List<AccessibilityNodeInfo> texts = source.findAccessibilityNodeInfosByText("确定");
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}

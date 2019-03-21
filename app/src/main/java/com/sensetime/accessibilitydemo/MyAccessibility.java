package com.sensetime.accessibilitydemo;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.util.Log;
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
        Log.i("qhh","onServiceConnected");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.i("qhh","onAccessibilityEvent = "+event.toString());

        CharSequence packageName = event.getPackageName();
        if(packageName.equals("com.android.systemui")){
            AccessibilityNodeInfo source = event.getSource();
            if(source != null){
                Log.i("qhh_source",source.toString());
            }else {
                Log.e("qhh_source","event.getSource() is null!!");
            }

        }else if(packageName.equals("com.huawei.android.launcher")){
            AccessibilityNodeInfo source = event.getSource();
            if(source != null){
                Log.i("qhh_source","launcher = "+source.toString());
                List<AccessibilityNodeInfo> nodeInfo = source.findAccessibilityNodeInfosByText("手机管家");
                for (int i = 0; i < nodeInfo.size(); i++) {
                    AccessibilityNodeInfo info = nodeInfo.get(i);
                    if(info.getClassName().equals("android.widget.TextView") && info.isEnabled()){
//                        info.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    }
                }
            }else {
                Log.e("qhh_source","event.getSource() is null!!");
            }
        }

        String className = event.getClassName().toString();
        if(className.equals("com.android.systemui.recents.RecentsActivity")){

        }

        //得到事件来源
        AccessibilityNodeInfo source = event.getSource();

        if(source != null){
            List<AccessibilityNodeInfo> nodes = source.findAccessibilityNodeInfosByText("确认");
            if(nodes != null){
                for (int i = 0; i < nodes.size(); i++) {
                    AccessibilityNodeInfo nodeInfo = nodes.get(i);
                    Log.d("qhh",nodeInfo.getClassName()+"");
                    if(nodeInfo.getClassName().equals("android.widget.Button") && nodeInfo.isEnabled()){
                        nodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    }
                }
            }
        }else{
            Log.e("qhh","event.getSource() is null!!");
        }


        //得到当前窗口根节点所有信息
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();

        if(rootInActiveWindow != null){

        }else{
            Log.e("qhh","event.getSource() is null!!");
        }

    }

    @Override
    public void onInterrupt() {
        Log.i("qhh","onInterrupt");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("qhh","onUnbind");
        return super.onUnbind(intent);
    }
}

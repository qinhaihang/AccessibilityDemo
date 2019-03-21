package com.sensetime.accessibilitydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AccessibilityUtils.openAccessibility(this,getPackageName() + "/" + MyAccessibility.class.getCanonicalName());
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void startService(View view) {
//        startService(new Intent(this,MyAccessibility.class));
//        Intent intent = new Intent();
//        ComponentName componentName = new ComponentName("com.android.systemui", "com.android.systemui.recents.RecentsActivity");
//        intent.setComponent(componentName);
//        intent.setAction("android.intent.action.MAIN");
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }
}

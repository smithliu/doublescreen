package com.zxm.test.doublescreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mLayout;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = findViewById(R.id.layout);
        setCustomerProductList();

    }

    /**
     * 设置客户屏显示商品内容
     */
    private void setCustomerProductList() {
        CustomerEngine.getInstance(getApplicationContext()).setProductList("测试一下吧");
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i+=(++i)*8888;
                CustomerEngine.getInstance(getApplicationContext()).setProductList("hahahahahah"+i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        onDestroy();
        //完全退出应用，取消双屏异显
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
        System.exit(0);
    }
}

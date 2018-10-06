package cn.byk.pandora.sample.rotatingview;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import cn.byk.pandora.rotatingview.RotatingView;

public class MainActivity extends AppCompatActivity {

    private RotatingView mRvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mRvContent = findViewById(R.id.rv_content);

        findViewById(R.id.btn_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRvContent.isRotating()) {
                    mRvContent.stop();
                } else {
                    mRvContent.start();
                }
            }
        });

        ((Switch) findViewById(R.id.swc_infinity)).setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        mRvContent.switchInfinity(isChecked);
                    }
                });
    }

}

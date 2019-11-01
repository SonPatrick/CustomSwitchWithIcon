package com.uigitdev.customswitchwithicon.uigitdev.design;

import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.SwitchCompat;

import com.uigitdev.customswitchwithicon.R;

public class CustomSwitch {
    private RelativeLayout custom_switch;
    private SwitchCompat mswitch;
    private SwitchClickInterface switchClickInterface;

    public CustomSwitch(View view, SwitchClickInterface switchClickInterface) {
        setType(view);
        setSwitchClick();
        this.switchClickInterface = switchClickInterface;
    }

    private void setType(View view) {
        custom_switch = view.findViewById(R.id.custom_switch);
        mswitch = view.findViewById(R.id.mswitch);
    }

    private void setSwitchClick() {
        custom_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSwitchValue();
                switchClickInterface.getSwitchValue(mswitch.isChecked());
            }
        });
    }

    private void setSwitchValue() {
        if (mswitch.isChecked()) {
            mswitch.setChecked(false);
        } else {
            mswitch.setChecked(true);
        }
    }

    public void setDefault(boolean def) {
        mswitch.setChecked(def);
    }

    public interface SwitchClickInterface{
        void getSwitchValue(boolean value);
    }

}

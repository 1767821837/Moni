package cdictv.moni.fagement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cdictv.moni.R;
import cdictv.moni.util.Sputil;

public class FazhiFragment extends Fragment {
    private TextView tvBalanceWarning;
    private TextView tvWarning;
    private TextView tvSettingTitle;
    private EditText etSettingWarning;
    private Button btnSetting;
    private View mView;
    Context mContext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = View.inflate(container.getContext(), R.layout.list_fazhi,null);
        initview();
        mContext=container.getContext();
        //第一次在引导界面设置默认值
        String war= Sputil.getString("fazhi");
        if((!("".equals(war)))){
            tvWarning.setText(war+"元");
        }
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String waning=etSettingWarning.getText().toString().trim();
                tvWarning.setText(waning+"元");
                etSettingWarning.setText("");
                Toast.makeText(mContext,"设置成功",Toast.LENGTH_LONG).show();
                Sputil.putString("fazhi",waning);
            }
        });
        return mView;


    }

    private void initview() {
        tvBalanceWarning = mView. findViewById(R.id.tv_balance_warning);
        tvWarning =  mView. findViewById(R.id.tv_warning);
        tvSettingTitle =  mView. findViewById(R.id.tv_setting_title);
        etSettingWarning =  mView.  findViewById(R.id.et_setting_warning);
        btnSetting =  mView.  findViewById(R.id.btn_setting);
    }
}

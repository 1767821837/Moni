package cdictv.moni.fagement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cdictv.moni.R;
import cdictv.moni.util.Sputil;


public class Xinxifragment extends Fragment {
    private TextView genrenName;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(container.getContext(), R.layout.gerenxinxilayout,null);
        genrenName = view.findViewById(R.id.genren_name);
        genrenName.setText("姓名:"+Sputil.getString("name")+"");
        return view;
    }
}

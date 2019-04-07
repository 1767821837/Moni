package cdictv.moni.adatper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cdictv.moni.R;
import cdictv.moni.activity.CarWeizhangImageActivity;
import cdictv.moni.bean.CarCradBean;

public class CarWeizhangAdapter extends BaseAdapter {

    private TextView carTime;
    private TextView carLuduan;
    private TextView carState;
    private TextView carYuanyin;
    private TextView carKoufen;
    private TextView carFakuan;

    List<CarCradBean.DataBean.XiangqingBean> list;
    Context  context;
    List<CarCradBean.DataBean> list2;

    public CarWeizhangAdapter(List<CarCradBean.DataBean.XiangqingBean> list, Context context,List<CarCradBean.DataBean> list2) {
        this.list = list;
        this.context = context;
        this.list2 = list2;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.car_weizhang_item,parent,false);
        }

        if(list2.size() == 0){
            list.clear();
        }else {

            carTime = (TextView) convertView.findViewById(R.id.car_time);
            carLuduan = (TextView) convertView.findViewById(R.id.car_luduan);
            carState = (TextView) convertView.findViewById(R.id.car_state);
            carYuanyin = (TextView) convertView.findViewById(R.id.car_yuanyin);
            carKoufen = (TextView) convertView.findViewById(R.id.car_koufen);
            carFakuan = (TextView) convertView.findViewById(R.id.car_fakuan);

            LinearLayout layout = convertView.findViewById(R.id.car_weicahnglin);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,CarWeizhangImageActivity.class);
                    context.startActivity(intent);
                }
            });

            carTime.setText(list.get(position).time);
            carLuduan.setText(list.get(position).luduan);
            carState.setText(list.get(position).state);
            carYuanyin.setText(list.get(position).yuanyin);
            carKoufen.setText("扣分： "+list.get(position).koufen+"分");
            carFakuan.setText("罚款"+list.get(position).fakuan+"元");
        }


        return convertView;
    }
}

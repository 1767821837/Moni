package cdictv.moni.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cdictv.moni.R;
import cdictv.moni.bean.CarCradBean;

public class CarCardAdapter extends BaseAdapter {

    Context context;
    public List<CarCradBean.DataBean> list;

    public CarCardAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.car_crad_item,parent,false);
        }else {
            view = convertView;
        }

        TextView itemCarId =  view.findViewById(R.id.item_car_id);
        TextView itemCarCount =  view.findViewById(R.id.item_car_count);
        TextView itemCarFeng =  view.findViewById(R.id.item_car_feng);
        ImageView imageView = view.findViewById(R.id.item_car_remove);

        itemCarId.setText(list.get(position).chepai);
        itemCarCount.setText("未处理违章"+list.get(position).weichuli+"次");
        itemCarFeng.setText("扣"+list.get(position).koufen+"分 罚款"+list.get(position).fankuan+"元");
        imageView.setTag(position);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = (int) v.getTag();
                list.remove(list.get(i));
                notifyDataSetChanged();
            }
        });

        return view;
    }
}

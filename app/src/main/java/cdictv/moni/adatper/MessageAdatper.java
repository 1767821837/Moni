package cdictv.moni.adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cdictv.moni.R;
import cdictv.moni.bean.MessageBean;


public class MessageAdatper extends BaseAdapter {

    private List<MessageBean.NewslistBean> newslist;
    private Context mContext;

    public MessageAdatper(List<MessageBean.NewslistBean> list, Context context) {
        newslist = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return newslist.size();
    }

    @Override
    public Object getItem(int position) {
        return newslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        MessageBean.NewslistBean bean = newslist.get(position);
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_message, null);
            viewHolder = new ViewHolder();
            viewHolder.tltle = convertView.findViewById(R.id.tv_mes_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tltle.setText(bean.title);
        //

        return convertView;
    }

    class ViewHolder {
        TextView tltle;
    }

}

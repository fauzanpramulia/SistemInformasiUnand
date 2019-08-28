package com.fauzanpramulia.sisteminformasiunand;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fauzanpramulia.sisteminformasiunand.model.MahasiswaItem;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {
    static List<MahasiswaItem> mahasiswaItemList;

    Context context;
    private int colorId;
    RequestOptions requestOptions;
    static OnItemClicked handler;

    public void setDataMahasiswa(ArrayList<MahasiswaItem> data) {
        this.mahasiswaItemList = data;
        notifyDataSetChanged();
    }

    public void setHandler(OnItemClicked clickHandler) {
        this.handler = clickHandler;
    }

    public ListViewAdapter(List<MahasiswaItem> mahasiswaItemList, Context context, int colorId) {
        this.mahasiswaItemList = mahasiswaItemList;
        this.context = context;
        this.colorId = colorId;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imageView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animation));
        holder.textContainer.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));

            holder.textName.setText(mahasiswaItemList.get(position).getName());
            holder.textBp.setText(mahasiswaItemList.get(position).getBp());

        if (mahasiswaItemList.get(position).getFoto().equalsIgnoreCase("null")) {
            if (mahasiswaItemList.get(position).getJk().equals("p")){
                Glide.with(context).load(R.drawable.avatar_cewek).into(holder.imageView);
            }else{
                Glide.with(context).load(R.drawable.avatar_cowok).into(holder.imageView);
            }

        } else {
//            imageView.setImageResource(R.mipmap.ic_launcher);
            Glide.with(context).load(mahasiswaItemList.get(position).getFoto()).into(holder.imageView);
//            Glide.with(context).load(playerItem.getFoto()).apply(new RequestOptions().override(200, 200)).into(imageView);
        }
        int color = ContextCompat.getColor(context, colorId);
        holder.textContainer.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return mahasiswaItemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        View textContainer;
        TextView foto;
        TextView textName;
        TextView textBp;
        RelativeLayout viewContainer;

        CircularImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textContainer = itemView.findViewById(R.id.text_container);
            viewContainer = itemView.findViewById(R.id.info_container);
            textName = itemView.findViewById(R.id.text_nama);
            textBp = itemView.findViewById(R.id.text_bp);
            imageView = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handler.clik(mahasiswaItemList.get(getAdapterPosition()));
                }
            });
        }
    }
    public interface OnItemClicked{
        void clik(MahasiswaItem m);
    }
}

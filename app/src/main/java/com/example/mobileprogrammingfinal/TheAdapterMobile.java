package com.example.mobileprogrammingfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TheAdapterMobile extends RecyclerView.Adapter<TheViewHolderMobile> {

    Context context;
    List<item> items;

    public TheAdapterMobile(Context context, List<item> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public TheViewHolderMobile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TheViewHolderMobile(LayoutInflater.from(context).inflate(R.layout.item_mobile,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TheViewHolderMobile holder, int position) {
        holder.gameImage.setImageResource(items.get(position).getDrawable());
        holder.judul.setText(items.get(position).getJudul());
        holder.inGameCurrency.setText(items.get(position).getCurrency());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

//    public interface ClickListener {
//
//        void onPositionClicked(int position);
//
//        void onLongClicked(int position);
//    }
//
//    public class TheAdapterMobile extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//
//        private final ClickListener listener;
//        private final List<MyItems> itemsList;
//
//        public TheViewHolderMobile(List<MyItems> itemsList, ClickListener listener) {
//            this.listener = listener;
//            this.itemsList = itemsList;
//        }
//
//        @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row_layout), parent, false), listener);
//        }
//
//        @Override public void onBindViewHolder(MyViewHolder holder, int position) {
//            // bind layout and data etc..
//        }
//
//        @Override public int getItemCount() {
//            return itemsList.size();
//        }
//
//        public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
//
//            private ImageView iconImageView;
//            private TextView iconTextView;
//            private WeakReference<ClickListener> listenerRef;
//
//            public MyViewHolder(final View itemView, ClickListener listener) {
//                super(itemView);
//
//                listenerRef = new WeakReference<>(listener);
//                iconImageView = (ImageView) itemView.findViewById(R.id.myRecyclerImageView);
//                iconTextView = (TextView) itemView.findViewById(R.id.myRecyclerTextView);
//
//                itemView.setOnClickListener(this);
//                iconTextView.setOnClickListener(this);
//                iconImageView.setOnLongClickListener(this);
//            }
//
//            // onClick Listener for view
//            @Override
//            public void onClick(View v) {
//
//                if (v.getId() == iconTextView.getId()) {
//                    Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
//                }
//
//                listenerRef.get().onPositionClicked(getAdapterPosition());
//            }
//
//
//            //onLongClickListener for view
//            @Override
//            public boolean onLongClick(View v) {
//
//                final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                builder.setTitle("Hello Dialog")
//                        .setMessage("LONG CLICK DIALOG WINDOW FOR ICON " + String.valueOf(getAdapterPosition()))
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        });
//
//                builder.create().show();
//                listenerRef.get().onLongClicked(getAdapterPosition());
//                return true;
//            }
//        }
//    }
//    https://stackoverflow.com/questions/30284067/handle-button-click-inside-a-row-in-recyclerview

}

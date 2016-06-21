package sample.recyclerview.com.recyclerviewsample;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jam on 16-5-18
 * Description:
 */
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ItemTouchHelper itemTouchHelper;
    Adapter adapter;
    public List<String> data;
    public static Toast mToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        data = new ArrayList<>();
        for (int i = 65; i < 90; i++) {
            data.add(((char) i) + "");
        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), R.drawable.list_divider));
        recyclerView.addOnItemTouchListener(new OnItemClickListener(recyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder holder, int position) {
                if (mToast == null) {
                    mToast = Toast.makeText(MainActivity.this, "点击了：" + position, Toast.LENGTH_SHORT);
                } else {
                    mToast.setText("点击了：" + position);
                }
                mToast.show();
            }

            @Override
            public void onLongPress(RecyclerView.ViewHolder holder, int position) {
                //如果不是最后一个就拖拽
                if (holder.getLayoutPosition() != data.size() - 1) {
                    itemTouchHelper.startDrag(holder);
                }

            }
        });
        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

            //设置移动方式
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                final int dragFlags;
                final int swipeFlags;
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    swipeFlags = 0;
                } else {
                    dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                    swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                }
                return makeMovementFlags(dragFlags, swipeFlags);
            }

            //移动过程中调用
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                data.add(toPosition, data.remove(fromPosition));
                adapter.notifyItemMoved(fromPosition, toPosition);
                return false;
            }

            //侧滑过程中调用
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                adapter.notifyItemRemoved(position);
                data.remove(position);
            }

            //是否可以拖拽移动位置
            @Override
            public boolean isLongPressDragEnabled() {
                return false;
            }

            //当长按的时候调用
            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                }
                Vibrator vibrator = (Vibrator) MainActivity.this.getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(70);
                super.onSelectedChanged(viewHolder, actionState);
            }

            //当手指松开的时候调用
            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundResource(0);
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


    class Adapter extends RecyclerView.Adapter<Holder> {


        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = View.inflate(parent.getContext(), R.layout.activity_home_item, null);
            return new Holder(v);
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView tv;

        public Holder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.mHomeItemModuleLabel);
        }

        public void setText(String text) {
            tv.setText(text);
        }
    }

}

package homepunk.work.mall.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import homepunk.work.mall.R;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class FloorAdapter extends RecyclerView.Adapter<FloorAdapter.FloorHolder> {
    private final Context context;
    private List<FloorViewModel> floors;

    public FloorAdapter(Context context) {
        this.context = context;
    }

    @Override
    public FloorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.item_floor, parent, false);

        return new FloorHolder(root);
    }

    @Override
    public void onBindViewHolder(FloorHolder holder, int position) {
        FloorViewModel floor = floors.get(position);

        holder.setLevel(floor.getLevel());
    }

    @Override
    public int getItemCount() {
        return floors.size();
    }

    public void update(List<FloorViewModel> floors) {
        this.floors.clear();
        this.floors.addAll(floors);
        notifyDataSetChanged();
    }

    public void setList(List<FloorViewModel> floors) {
        this.floors = floors;
    }

    class FloorHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_floor_level)
        TextView level;

        public FloorHolder(View root) {
            super(root);
            level = (TextView) root.findViewById(R.id.item_floor_level);
        }

        public void setLevel(String level) {
            this.level.setText(level);
        }
    }
}

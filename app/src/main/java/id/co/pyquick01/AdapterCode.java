package id.co.pyquick01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdapterCode extends RecyclerView.Adapter<AdapterCode.ViewHolder> {

    private List<CodeModel> codeModelList;
    private List<CodeModel> filteredList;

    public AdapterCode(List<CodeModel> codeModelList) {
        this.codeModelList = codeModelList != null ? codeModelList : new ArrayList<>();
        this.filteredList = new ArrayList<>(this.codeModelList);
    }

    @NonNull
    @Override
    public AdapterCode.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCode.ViewHolder holder, int position) {
        CodeModel item = filteredList.get(position);
        holder.listCode.setText(item.getJenisCode());
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("codeTitle", item.getJenisCode());
            intent.putExtra("detailCode", item.getDetailCode()); // Perbaikan di sini
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView listCode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listCode = itemView.findViewById(R.id.list_code);
        }
    }

    public void filter(String query) {
        query = query.toLowerCase(Locale.getDefault());
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(codeModelList);
        } else {
            for (CodeModel item : codeModelList) {
                if (item.getJenisCode().toLowerCase(Locale.getDefault()).contains(query)) {
                    filteredList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}

package sg.edu.np.mad.madpractical4;


import android.view.View;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView smallImage, largeImage;
    TextView name, description;

    public UserViewHolder(@NonNull View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.tvName);
        description = itemView.findViewById(R.id.tvDescription);
        smallImage = itemView.findViewById(R.id.ivSmallImage);
        largeImage = itemView.findViewById(R.id.ivLargeImage);
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = viewType == 1 ? R.layout.custom_activity_list_special : R.layout.custom_activity_list;
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new UserViewHolder(view);
    }
}

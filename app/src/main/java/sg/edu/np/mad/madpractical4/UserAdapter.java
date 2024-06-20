package sg.edu.np.mad.madpractical4;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Random;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context context;
    List<User> myUserList;

    public UserAdapter(List<User> myUserList) {
        this.context = context;
        this.myUserList = myUserList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_activity_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.name.setText(myUserList.get(position).getName());
        holder.description.setText(myUserList.get(position).getDescription());

        holder.smallImage.setOnClickListener(v -> {
            //Implement the AlertDialog here
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
            builder.setMessage(myUserList.get(position).getName())
                    .setPositiveButton("View", (dialog, id) -> {
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        v.getContext().startActivity(intent);
                    })
                    .setNegativeButton("Cancel", null);
            builder.create().show();
        });
    }

    @Override
    public int getItemCount() {
        return myUserList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView smallImage, largeImage;
        TextView name, description;

        public UserViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            description = itemView.findViewById(R.id.tvDescription);
            smallImage = itemView.findViewById(R.id.ivSmallImage);
            largeImage = itemView.findViewById(R.id.ivLargeImage);
        }
    }

    @Override
    public int getItemViewType(int position) {
        String name = myUserList.get(position).getName();
        return name.endsWith("7") ? 1 : 0;
    }

    //int layout = viewType == 1 ? R.layout.custom_activity_list_special : R.layout.custom_activity_list;
    //View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    //    return new UserViewHolder(view);
}

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
import java.util.ArrayList;
import java.util.Random;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private ArrayList<User> myUserList;

    public UserAdapter(ArrayList<User> myUserList) {
        this.myUserList = myUserList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = myUserList.get(position);
        holder.name.setText(user.getName());
        holder.description.setText(user.getDescription());

        holder.smallImage.setOnClickListener(v -> {
            //Implement the AlertDialog here
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
            builder.setMessage(user.getName())
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

    @Override
    public int getItemViewType(int position) {
        String name = myUserList.get(position).getName();
        return name.endsWith("7") ? 1 : 0;
    }
}

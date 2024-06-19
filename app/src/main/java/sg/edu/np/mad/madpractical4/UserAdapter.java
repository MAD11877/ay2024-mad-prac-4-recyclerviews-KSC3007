package sg.edu.np.mad.madpractical4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<User> listObjects;
    private Context context;

    public UserAdapter(Context context, ArrayList<User> listObjects) {
        this.listObjects = listObjects;
        this.context = context;
    }

    public UserAdapter(ArrayList<User> myUserList, ListActivity listActivity) {
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = listObjects.get(position);
        holder.name.setText(user.getName());
        holder.description.setText(user.getDescription());
        holder.smallImage.setImageResource(user.getImage()); // Replace with actual image
        holder.bigImage.setImageResource(user.getImage()); // Replace with actual image
    }

    @Override
    public int getItemCount() {
        return listObjects.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView name, description;
        ImageView smallImage, bigImage;
        private Context context;

        public UserViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            name = itemView.findViewById(R.id.tvName);
            description = itemView.findViewById(R.id.tvDescription);
            smallImage = itemView.findViewById(R.id.ivSmallImage);
            bigImage = itemView.findViewById(R.id.imageView);

            smallImage.setOnClickListener(v -> {
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                // Set the message show for the Alert time
                builder.setMessage("Profile");

                // Set Alert Title
                builder.setTitle(name.getText().toString());

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                builder.setPositiveButton("Close", (dialog, which) -> dialog.cancel());

                builder.setNegativeButton("View", (dialog, which) -> {
                    Intent intent = new Intent(context, MainActivity.class);
                    String randomNumber = String.valueOf(new Random().nextInt(999999));
                    intent.putExtra("MAD", randomNumber);
                    context.startActivity(intent);
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            });
        }
    }
}

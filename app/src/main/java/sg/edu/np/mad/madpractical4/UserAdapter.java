package sg.edu.np.mad.madpractical4;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
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

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    ArrayList<User> listObjects;
    Context context;

    public UserAdapter(Context context, ArrayList<User> listObjects) {
        this.listObjects = listObjects;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_activity_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = listObjects.get(position);
        holder.name.setText(user.getName());
        holder.description.setText(user.getDescription());
    }

    @Override
    public int getItemCount() {
        return listObjects.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView smallImage, bigImage;
        private Context context;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            description = itemView.findViewById(R.id.tvDescription);
            smallImage = itemView.findViewById(R.id.ivSmallImage);
            bigImage = itemView.findViewById(R.id.imageView);
        }
    }

    ivSmallImage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Create the object of AlertDialog Builder class
            AlertDialog.Builder builder = new AlertDialog.Builder(UserAdapter.this);

            // Set the message show for the Alert time
            builder.setMessage("Profile");

            // Set Alert Title
            builder.setTitle("name");

            // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
            builder.setCancelable(false);

            builder.setPositiveButton("Close", (DialogInterface.OnClickListener) (dialog, which) -> {
                dialog.cancel();
            });

            builder.setNegativeButton("View", (DialogInterface.OnClickListener) (dialog, which) -> {
                Intent intent = new Intent(UserAdapter.this, ListActivity.class);
                String randomNumber = String.valueOf(random.nextInt(999999));
                intent.putExtra("MAD", randomNumber);
                startActivity(intent);
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    };
}

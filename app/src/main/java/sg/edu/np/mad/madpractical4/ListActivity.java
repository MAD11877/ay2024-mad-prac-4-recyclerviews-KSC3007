package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Create list of 20 random users
        ArrayList<User> myUser_List = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            int name = new Random().nextInt(999999999);
            int description = new Random().nextInt(999999999);
            boolean followed = new Random().nextBoolean();

            User user = new User("Shan Chun", "MAD Developer", 1, false);
            user.setName("Name: "+String.valueOf(name));
            user.setDescription("Description: "+String.valueOf(description));
            user.setFollowed(followed);
            myUser_List.add(user);
        }

        UserAdapter userAdapter = new UserAdapter(myUser_List, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);

        ImageView ivSmallImage = findViewById(R.id.ivSmallImage);
        final Random random = new Random();

        ivSmallImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

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
                    Intent intent = new Intent(ListActivity.this, MainActivity.class);
                    String randomNumber = String.valueOf(random.nextInt(999999));
                    intent.putExtra("MAD", randomNumber);
                    startActivity(intent);
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
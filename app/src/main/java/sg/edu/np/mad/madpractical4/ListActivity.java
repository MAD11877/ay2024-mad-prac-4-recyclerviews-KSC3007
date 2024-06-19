package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ArrayList<User> myUserList;

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

        recyclerView = findViewById(R.id.recyclerView1);

        myUserList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int name = new Random().nextInt(999999999);
            int description = new Random().nextInt(999999999);
            boolean followed = new Random().nextBoolean();

            User user = new User("Shan Chun", "MAD Developer", 1, false);
            user.setName("Name"+String.valueOf(name));
            user.setDescription("Description "+String.valueOf(description));
            user.setFollowed(followed);
            myUserList.add(user);
        }

        // Check if the list contains all data
        if (myUserList != null && myUserList.size() == 20) {
            boolean allDataPresent = true;
            for (User user : myUserList) {
                if (user.getName() == null || user.getDescription() == null) {
                    allDataPresent = false;
                    break;
                }
            }

            if (allDataPresent) {
                // Proceed with setting up the RecyclerView
                UserAdapter userAdapter = new UserAdapter(this, myUserList);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(userAdapter);
            } else {
                // Handle the case where some data is missing
                Log.e("ListActivity", "Some data is missing in myUserList");
            }
        } else {
            // Handle the case where myUserList is null or does not contain 20 users
            Log.e("ListActivity", "myUserList is null or does not contain 20 users");
        }

        //UserAdapter userAdapter = new UserAdapter(this, myUserList);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setAdapter(userAdapter);
    }
}

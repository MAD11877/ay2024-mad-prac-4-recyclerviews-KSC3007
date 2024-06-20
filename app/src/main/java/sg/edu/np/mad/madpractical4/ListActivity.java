package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    public UserAdapter userAdapter;

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);

        List<User> myUserList = new ArrayList<User>();

        for (int i = 0; i < 20; i++) {
            User user = new User("Shan Chun", "MAD Developer", 1, false);
            int nameRandomNo = new Random().nextInt(999999999);
            user.setName("Name"+String.valueOf(nameRandomNo));

            int descRandomNo = new Random().nextInt(999999999);
            user.setDescription("Description "+String.valueOf(descRandomNo));

            boolean followed = new Random().nextBoolean();
            user.setFollowed(followed);

            myUserList.add(user);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

    }
}

package id.co.pyquick01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterCode adapterCode;
    private ArrayList<CodeModel> codeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.recyclerview);
        adapterCode = new AdapterCode(codeModel);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterCode);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapterCode.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterCode.filter(newText);
                return false;
            }
        });

        ImageButton buttonMenu = findViewById(R.id.Menu);
        buttonMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        });
    }

    private void getData() {
        codeModel = new ArrayList<>();
        codeModel.add(new CodeModel("Hello World", ">>> print(\"Hello, World!\")\nHello, World!\n"));
        codeModel.add(new CodeModel("Variables", "age = 18      # age is of type int\nname = \"John\" # name is now of type str\nprint(name)\n"));
        codeModel.add(new CodeModel("Data Types", "Text = str\nNumeric = int, float, complex\nSequence = list, tuple, range\nMapping = dict\nSet = set, frozenset\nBoolean = bool\nBinary = bytes, bytearray, memoryview\n"));
        codeModel.add(new CodeModel("Strings", "hello = \"Hello World\"\nhello = 'Hello World'\n\nmulti_string = \"\"\"Multiline Strings\nLorem ipsum dolor sit amet,\nconsectetur adipiscing elit \"\"\"\n"));
        codeModel.add(new CodeModel("Float", "x = float(1)     # x will be 1.0\ny = float(2.8)   # y will be 2.8\nz = float(\"3\")   # z will be 3.0\nw = float(\"4.2\") # w will be 4.2\n"));
        codeModel.add(new CodeModel("Integers", "x = int(1)   # x will be 1\ny = int(2.8) # y will be 2\nz = int(\"3\") # z will be 3\n"));
        codeModel.add(new CodeModel("Boolean", "my_bool = True \nmy_bool = False\n\nbool(0)     # => False\nbool(1)     # => True\n"));
        codeModel.add(new CodeModel("Numbers", "x = 1    # int\ny = 2.8  # float\nz = 1j   # complex\n\n>>> print(type(x))\n<class 'int'>\n"));
        codeModel.add(new CodeModel("List", "list1 = [\"apple\", \"banana\", \"cherry\"]\nlist2 = [True, False, False]\nlist3 = [1, 5, 7, 9, 3]\nlist4 = list((1, 5, 7, 9, 3))\n"));
        codeModel.add(new CodeModel("Tuple", "my_tuple = (1, 2, 3)\nmy_tuple = tuple((1, 2, 3))\n"));
        codeModel.add(new CodeModel("Set", "set1 = {\"a\", \"b\", \"c\"}\nset2 = set((\"a\", \"b\", \"c\"))\n"));
        codeModel.add(new CodeModel("Arithmetic", "result = 10 + 30 # => 40\nresult = 40 - 10 # => 30\nresult = 50 * 5  # => 250\nresult = 16 / 4  # => 4.0 (Float Division)\nresult = 16 // 4 # => 4 (Integer Division)\nresult = 25 % 2  # => 1\nresult = 5 ** 3  # => 125\n"));
        codeModel.add(new CodeModel("If Else", "num = 200\nif num > 0:\n    print(\"num is greater than 0\")\nelse:\n    print(\"num is not greater than 0\")\n"));
        codeModel.add(new CodeModel("Loops", "for item in range(6):\n    if item == 3: break\n    print(item)\nelse:\n    print(\"Finally finished!\")\n"));
    }
}

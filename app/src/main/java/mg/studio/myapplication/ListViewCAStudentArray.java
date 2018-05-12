package mg.studio.myapplication;

/**
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import java.util.List;

/**
 * This is a custom ArrayAdapter that extends ArrayAdapter
 */

class ListViewCAStudentArray extends ArrayAdapter<ListViewCAStudent>{
    private int resourceId;

    public ListViewCAStudentArray(Context context, int resource, List<ListViewCAStudent> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewCAStudent student = getItem(position);
        View view;
        ListViewCAHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ListViewCAHolder();
            viewHolder.studentName = view.findViewById(R.id.tv_student_name);
            viewHolder.studentId = view.findViewById(R.id.tv_student_id);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ListViewCAHolder) view.getTag();

        }

        viewHolder.studentName.setText(student.getName());
        Log.d(getContext().getPackageName().toString(), student.getName());
        viewHolder.studentId.setText(String.valueOf(student.getStudentId()));
        Log.d(getContext().getPackageName().toString(), String.valueOf(student.getStudentId()));
        return view;

    }

}

package net.thumbshow.activity;

import java.util.ArrayList;
import java.util.HashMap;

import net.thumbshow.zstudy.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

//注意：这里继承的是ListActivity，而不是Activity  
public class ListViewActivity extends ListActivity {  
  /** Called when the activity is first created. */  
  @Override  
  public void onCreate(Bundle savedInstanceState) {  
      super.onCreate(savedInstanceState);  
      setContentView(R.layout.activity_listview);  

      // 创建一个ArrayList，ArrayList里面存放的是HashMap，而HashMap的键值对都是String类型  
      ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();  
      HashMap<String, String> map1 = new HashMap<String, String>();  
      HashMap<String, String> map2 = new HashMap<String, String>();  
      HashMap<String, String> map3 = new HashMap<String, String>();  
      // 分别往3个HashMap中存储值  
      map1.put("user_name", "zhangsan");  
      map1.put("user_ip", "192.168.0.1");  
      map2.put("user_name", "lisi");  
      map2.put("user_ip", "192.168.0.2");  
      map3.put("user_name", "wangwu");  
      map3.put("user_ip", "192.168.0.3");  
      // 将3个HashMap添加到ArrayList中  
      list.add(map1);  
      list.add(map2);  
      list.add(map3);  
      //创建适配器  
      //第一个参数Content：上下文  
      //第二个参数List<? extends Map<String, ?>>：ArrayList对象，ArrayList里面存放的是HashMap，而HashMap的键值对都是String类型  
      //第三个参数int resource：内容显示的布局文件  
      //第四个参数String[] from：被添加到ArrayList中的HashMap中key的名称,要显示的列  
      //第五个参数int[] to：内容显示的布局文件中,显示内容的控件id  
      SimpleAdapter listAdapter = new SimpleAdapter(this, list,  
              R.layout.listview, new String[] { "user_name", "user_ip" },  
              new int[] { R.id.user_name, R.id.user_ip });  
      //绑定到适配器。  
      setListAdapter(listAdapter);  
  }  

  /** 
   * 列表当中一行的点击事件 
   * ListView：ListView对象本身 
   * View：被选中的那一行的View对象 
   * position：被选中的那一行的位置 
   * id：被选中的那一行的id 
   */  
  @Override  
  protected void onListItemClick(ListView l, View v, int position, long id) {  
      // TODO Auto-generated method stub  
      super.onListItemClick(l, v, position, id);  
      //打印出被选中的那一行的位置和id，计数都是从0开始  
      System.out.println("-------------"+position);  
      System.out.println("-------------"+id);  
  }  
}  

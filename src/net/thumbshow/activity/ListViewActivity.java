package net.thumbshow.activity;

import java.util.ArrayList;
import java.util.HashMap;

import net.thumbshow.zstudy.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

//ע�⣺����̳е���ListActivity��������Activity  
public class ListViewActivity extends ListActivity {  
  /** Called when the activity is first created. */  
  @Override  
  public void onCreate(Bundle savedInstanceState) {  
      super.onCreate(savedInstanceState);  
      setContentView(R.layout.activity_listview);  

      // ����һ��ArrayList��ArrayList�����ŵ���HashMap����HashMap�ļ�ֵ�Զ���String����  
      ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();  
      HashMap<String, String> map1 = new HashMap<String, String>();  
      HashMap<String, String> map2 = new HashMap<String, String>();  
      HashMap<String, String> map3 = new HashMap<String, String>();  
      // �ֱ���3��HashMap�д洢ֵ  
      map1.put("user_name", "zhangsan");  
      map1.put("user_ip", "192.168.0.1");  
      map2.put("user_name", "lisi");  
      map2.put("user_ip", "192.168.0.2");  
      map3.put("user_name", "wangwu");  
      map3.put("user_ip", "192.168.0.3");  
      // ��3��HashMap��ӵ�ArrayList��  
      list.add(map1);  
      list.add(map2);  
      list.add(map3);  
      //����������  
      //��һ������Content��������  
      //�ڶ�������List<? extends Map<String, ?>>��ArrayList����ArrayList�����ŵ���HashMap����HashMap�ļ�ֵ�Զ���String����  
      //����������int resource��������ʾ�Ĳ����ļ�  
      //���ĸ�����String[] from������ӵ�ArrayList�е�HashMap��key������,Ҫ��ʾ����  
      //���������int[] to��������ʾ�Ĳ����ļ���,��ʾ���ݵĿؼ�id  
      SimpleAdapter listAdapter = new SimpleAdapter(this, list,  
              R.layout.listview, new String[] { "user_name", "user_ip" },  
              new int[] { R.id.user_name, R.id.user_ip });  
      //�󶨵���������  
      setListAdapter(listAdapter);  
  }  

  /** 
   * �б���һ�еĵ���¼� 
   * ListView��ListView������ 
   * View����ѡ�е���һ�е�View���� 
   * position����ѡ�е���һ�е�λ�� 
   * id����ѡ�е���һ�е�id 
   */  
  @Override  
  protected void onListItemClick(ListView l, View v, int position, long id) {  
      // TODO Auto-generated method stub  
      super.onListItemClick(l, v, position, id);  
      //��ӡ����ѡ�е���һ�е�λ�ú�id���������Ǵ�0��ʼ  
      System.out.println("-------------"+position);  
      System.out.println("-------------"+id);  
  }  
}  

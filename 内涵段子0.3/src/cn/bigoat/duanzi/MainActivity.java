package cn.bigoat.duanzi;

import cn.bigoat.duanzi.fragment.AuditFragment;
import cn.bigoat.duanzi.fragment.DiscoveryFragment;
import cn.bigoat.duanzi.fragment.HomeFragment;
import cn.bigoat.duanzi.fragment.MsgFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity implements
		OnCheckedChangeListener {

	private RadioGroup radioGroup;

	private HomeFragment homeFragment;
	private DiscoveryFragment discoveryFragment;
	private AuditFragment auditFragment;
	private MsgFragment msgFragment;

	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		radioGroup = (RadioGroup) findViewById(R.id.rg);
		radioGroup.setOnCheckedChangeListener(this);

		// 界面初始化
		init();

	}

	private void init() {

		fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		homeFragment = new HomeFragment();
		auditFragment = new AuditFragment();
		discoveryFragment = new DiscoveryFragment();
		msgFragment = new MsgFragment();

		
		transaction.commit();

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub

		FragmentTransaction transaction = fragmentManager.beginTransaction();

		switch (checkedId) {
		case R.id.home:
			choiceHome(transaction);
			break;

		case R.id.discovery:
			choiceDiscovery(transaction);
			break;

		case R.id.audit:
			choiceAudit(transaction);
			break;

		case R.id.msg:
			choiceMsg(transaction);
			break;

		}

		transaction.commit();

	}

	private void choiceMsg(FragmentTransaction transaction) {
		// TODO Auto-generated method stub

		transaction.replace(R.id.container, msgFragment);

	}

	private void choiceDiscovery(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		transaction.replace(R.id.container, discoveryFragment);

	}

	private void choiceAudit(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		transaction.replace(R.id.container, auditFragment);

	}

	private void choiceHome(FragmentTransaction transaction) {
		// TODO Auto-generated method stub

		transaction.replace(R.id.container, homeFragment);

	}

}

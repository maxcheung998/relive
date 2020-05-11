package jiguang.chat.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import jiguang.chat.R;

public class IntroAnxietyActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        initView();
    }

    private void initView() {
        initTitle(true, true, "認識抑鬱症", "", false, "");
        TextView textTitle = (TextView) findViewById(R.id.title);
        TextView textIntro = (TextView) findViewById(R.id.intro);
        ImageView heropic = (ImageView) findViewById(R.id.heropic);
        heropic.setImageResource(R.drawable.img2);
        textTitle.setText("什麼是焦慮症?");
        textIntro.setText("焦慮如何產生\n" +
                "焦慮的產生跟外在壓力與個人的脆弱性有關。外在的壓力可以是人與環境的互動當中，一種令人疲累且已超出個人所能承載的情況，而個人的脆弱性以及對壓力源感受上的差別，則與遺傳、學習經驗有關。然而外在的壓力並不一定會讓個人產生焦慮現象，若一個人的脆弱性很高，則即使小小的壓力也會讓個人產生極大的焦慮。\n" +
                "焦慮症的認識\n\n" +
                "焦慮症是一種以過度焦慮、擔憂、畏懼、逃避為主要症狀，造成重大痛苦、損害社會、職業功能的疾病。主要可分為下列幾種疾病：\n" +
                "- 恐慌症：獨特而且不可預期的極度焦慮反應，有造成瀕死的害怕。\n" +
                "- 強迫症：重覆不願意的想法或行為。\n" +
                "- 廣泛性焦慮症：過度廣泛焦慮或擔憂。\n" +
                "- 慮病症：持續擔心自己可能得到身體疾病。\n\n" +
                "焦慮症的病徵\n" +
                "- 生理反應：身體發熱、心悸、胸口緊、過度換氣、腸胃不適、暈眩、口乾、肌肉緊繃、痛、疲倦、無法專心、思考混亂等。\n" +
                "- 認知反應：我做不來、覺得自己很傻、別人常注意我、可能會暈倒、得心臟病、無法呼吸、不願意出門、會發瘋等。\n" +
                "- 情緒反應：害怕、激動、恐慌、過度擔心、不安、感覺世界毀滅、悲哀、失去控制、罪惡感、生氣、憂鬱等。\n\n" +
                "資料來源： 亞洲大學附屬醫院 https://www.auh.org.tw/\n");
    }
}

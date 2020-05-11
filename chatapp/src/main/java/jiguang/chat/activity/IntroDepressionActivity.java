package jiguang.chat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import jiguang.chat.R;

public class IntroDepressionActivity extends BaseActivity{

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
        heropic.setImageResource(R.drawable.img1);
        textTitle.setText("什麼是抑鬱症?");
        textIntro.setText("簡介\n" +
                "抑鬱症(depression)是一種嚴重疾病。抑鬱症患者會有極端沮喪的感覺，並且持續很\n" +
                "長時間。這樣的感覺常常嚴重到幹擾日常生活，可持續數周、數月，而不僅僅是數\n" +
                "天。\n" +
                "抑鬱症是一種常見疾病。大約 15%的人在某一生活階段會經歷嚴重抑鬱症。英國每\n" +
                "年約 5,000 例自殺與抑鬱症有關。\n" +
                "抑鬱症在女性中比在男性中更常見，但這有可能是因為女性更願意就其症狀尋求幫\n" +
                "助。抑鬱症可發生於任何年齡，即便是兒童。\n" +
                "抑鬱症以多種不同方式對人造成影響，能造成廣泛的身體、心理(精神)和社會症狀。\n\n" +
                "症狀\n" +
                "抑鬱症患者易激動，經常哭泣。他們會覺得自己優柔寡斷，感到無價值、內疚、絕\n" +
                "望、無助。\n" +
                "抑鬱症患者還會對曾經喜歡的事物喪失興趣。他們願意花更多的時間獨處，避免見\n" +
                "到家人與朋友。抑鬱症患者還會出現身體症狀，例如疲勞和睡眠問題。\n" +
                "抑鬱症患者會食欲不振，雖然某些患者由於安慰進食會使體重增加。他們還可能喪\n" +
                "失性欲。某些女性的月經週期會受到影響。\n" +
                "抑鬱不同於憂傷。憂傷是對損失的正常反應，憂傷的人其沮喪感常有波動，通常都\n" +
                "會欣賞生活中的事物，對未來抱有希望。 而抑鬱症患者其沮喪感則是持續性的，對\n" +
                "未來沒有積極的感覺。\n\n" +
                "資料來源： NHS website https://www.nhs.uk/\n");
    }

}

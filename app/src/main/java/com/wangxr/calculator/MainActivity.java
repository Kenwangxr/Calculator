package com.wangxr.calculator;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);
        findViewById(R.id.bt6).setOnClickListener(this);
        findViewById(R.id.bt7).setOnClickListener(this);
        findViewById(R.id.bt8).setOnClickListener(this);
        findViewById(R.id.bt9).setOnClickListener(this);
        findViewById(R.id.bt10).setOnClickListener(this);
        findViewById(R.id.bt11).setOnClickListener(this);
        findViewById(R.id.bt12).setOnClickListener(this);
        findViewById(R.id.bt13).setOnClickListener(this);
        findViewById(R.id.bt14).setOnClickListener(this);
        findViewById(R.id.bt15).setOnClickListener(this);
        findViewById(R.id.bt16).setOnClickListener(this);
        findViewById(R.id.bt17).setOnClickListener(this);
        findViewById(R.id.bt18).setOnClickListener(this);


    }

    private double num1;

    private double num2;

    private StringBuilder input = new StringBuilder();

    private String opt;//运算符

    private Button lastOptButton;


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1://回退
                back();
                break;
            case R.id.bt2://清空
                clear();
                findViewById(R.id.contentText).setBackgroundColor(Color.WHITE);
                if(lastOptButton !=null){
                    lastOptButton.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
                }
                break;
            case R.id.bt6://算数运算符
                case R.id.bt10:
                    case R.id.bt17:
                        case R.id.bt18:
                            if(input.length() ==0 || opt!=null) break;
                            try{
                                num1 = Float.parseFloat(input.toString());

                            }catch (NumberFormatException e){
                                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                                alertDialog.setTitle("输入有误！");
                                alertDialog.show();
                                return;
                            }
                            lastOptButton = findViewById(v.getId());

                            lastOptButton.setBackgroundColor(Color.RED);
                            opt = lastOptButton.getText().toString();
                            input = new StringBuilder();
                break;
            case R.id.bt14://=号
                if(opt == null || input.length() == 0) break;
                try{
                    num2 = Float.parseFloat(input.toString());
                }catch (NumberFormatException e){
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setTitle("输入有误！");
                    alertDialog.show();
                    return;
                }
                if(opt.equals("/")) {
                    div(num1, num2);
                }else if(opt.equals("*")){
                    multi(num1, num2);
                }else if(opt.equals("-")){
                    sub(num1, num2);
                }else {
                    sum(num1, num2);
                }
                opt = null;
                findViewById(R.id.contentText).setBackgroundColor(Color.RED);
                if(lastOptButton !=null){
                    lastOptButton.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
                }



                break;
            default:
                Button numberBtn = (Button)findViewById(v.getId());
                input.append(numberBtn.getText());
                show(input.toString());
                break;

        }
    }

    /**
     * 加法
     * @param num1
     * @param num2
     * @return
     */
    private double sum(double num1, double num2){
        double result = num1 + num2;
//        this.num1 = result;
        input = new StringBuilder(result+"");
        show(result+"");
        return result;
    }

    /**
     * 减法
     * @param num1
     * @param num2
     * @return
     */
    private double sub(double num1, double num2){
        double result = num1 - num2;
//        this.num1 = result;
        input = new StringBuilder(result+"");
        show(result+"");
        return result;
    }

    /**
     * 乘法
     * @param num1
     * @param num2
     * @return
     */
    private double multi(double num1, double num2){
        double result = num1 * num2;
//        this.num1 = result;
        input = new StringBuilder(result+"");
        show(result+"");
        return result;
    }

    /**
     * 除法
     * @param num1
     * @param num2
     * @return
     */
    private double div(double num1, double num2){
        if(num2 == 0){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("除数不能为0！");
            alertDialog.show();
            return 0;
        }
        double result = num1/num2;
        input = new StringBuilder(result+"");
//        this.num1 = result;
        show(result+"");
        return result;
    }

    /**
     * 回退
     */
    private void back(){
        if(input.length()>=1){
            input.deleteCharAt(input.length()-1);
            if(input.length() == 0){
                show(getResources().getString(R.string.defaultText));
                findViewById(R.id.contentText).setBackgroundColor(Color.WHITE);
            }else{
                show(input.toString());
            }
        }
    }

    /**
     * 清空
     */
    private void clear(){
        num1 = 0;
        num2 = 0;
        input = new StringBuilder();
        show(getResources().getString(R.string.defaultText));
    }
    private void show(String text){
        TextView contentView = (TextView)findViewById(R.id.contentText);
        contentView.setText(text);

    }
}
